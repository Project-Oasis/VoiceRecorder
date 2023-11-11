package com.asynctaskcoffee.audiorecorder.worker

import android.content.Context
import android.media.AudioFormat
import android.media.MediaRecorder
import java.util.*

class Recorder(audioRecordListener: AudioRecordListener?, private var context: Context?) {

    private var recorder: MediaRecorder? = null
    private var audioRecordListener: AudioRecordListener? = null
    private var filePath: String? = null


    private var isRecording = false

    fun setFilePath(filePath: String?) {
        this.filePath = filePath
    }

    fun setContext(context: Context) {
        this.context = context
    }

    fun startRecord() {
        if (context == null) {
            throw IllegalStateException("Context cannot be null")
        }
        recorder = MediaRecorder()
        recorder?.setAudioSource(MediaRecorder.AudioSource.DEFAULT)
        recorder?.setOutputFormat(AudioFormat.ENCODING_PCM_16BIT)
        recorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        recorder?.setAudioChannels(2)
        recorder?.setAudioSamplingRate(44100)
        recorder?.setAudioEncodingBitRate(128000)

        //File path
        if (filePath == null) { //If file path is not set
            filePath = context?.cacheDir?.absolutePath ?: ""
            filePath += "/Recorder_" + UUID.randomUUID().toString() + ".m4a"
        } else {                //If file path is set
            if (filePath?.endsWith(".m4a") == false) {
                throw IllegalArgumentException("File extension must be .m4a")
            }
        }
        recorder?.setOutputFile(filePath)

        try {
            recorder?.prepare()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            reflectError(e.toString())
            return
        }
        recorder?.start()
        isRecording = true
        audioRecordListener?.onReadyForRecord()
    }

    fun reset() {
        if (recorder != null) {
            recorder?.release()
            recorder = null
            isRecording = false
        }
    }

    fun stopRecording() {
        try {
            Thread.sleep(150)
            recorder?.stop()
            recorder?.release()
            recorder = null
            reflectRecord(filePath)
        } catch (e: Exception) {
            e.printStackTrace()
            reflectError(e.toString())
        }
    }

    private fun reflectError(error: String?) {
        audioRecordListener?.onRecordFailed(error)
        isRecording = false
    }

    private fun reflectRecord(uri: String?) {
        audioRecordListener?.onAudioReady(uri)
        isRecording = false
    }

    init {
        this.audioRecordListener = audioRecordListener
    }
}