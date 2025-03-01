package com.asynctaskcoffee.audiorecorder.uikit;

public class LangObj {

    public LangObj() {
    }

    String record_audio_string = "Start Recording";
    String hold_for_record_string = "Hold to record";
    String release_for_end_string = "Release to end recording";
    String listen_record_string = "Play Recording";
    String stop_listen_record_string = "Stop Playing";
    String stop_record_string = "Stop Recording";
    String send_record_string = "Send Recording";

    public LangObj(String record_audio_string, String hold_for_record_string, String release_for_end_string, String listen_record_string, String stop_listen_record_string, String stop_record_string, String send_record_string) {
        this.record_audio_string = record_audio_string;
        this.hold_for_record_string = hold_for_record_string;
        this.release_for_end_string = release_for_end_string;
        this.listen_record_string = listen_record_string;
        this.stop_listen_record_string = stop_listen_record_string;
        this.stop_record_string = stop_record_string;
        this.send_record_string = send_record_string;
    }

    public String getRecord_audio_string() {
        return record_audio_string;
    }

    public void setRecord_audio_string(String record_audio_string) {
        this.record_audio_string = record_audio_string;
    }

    public String getHold_for_record_string() {
        return hold_for_record_string;
    }

    public void setHold_for_record_string(String hold_for_record_string) {
        this.hold_for_record_string = hold_for_record_string;
    }

    public String getRelease_for_end_string() {
        return release_for_end_string;
    }

    public void setRelease_for_end_string(String release_for_end_string) {
        this.release_for_end_string = release_for_end_string;
    }

    public String getListen_record_string() {
        return listen_record_string;
    }

    public void setListen_record_string(String listen_record_string) {
        this.listen_record_string = listen_record_string;
    }

    public String getStop_listen_record_string() {
        return stop_listen_record_string;
    }

    public void setStop_listen_record_string(String stop_listen_record_string) {
        this.stop_listen_record_string = stop_listen_record_string;
    }

    public String getStop_record_string() {
        return stop_record_string;
    }

    public void setStop_record_string(String stop_record_string) {
        this.stop_record_string = stop_record_string;
    }

    public String getSend_record_string() {
        return send_record_string;
    }

    public void setSend_record_string(String send_record_string) {
        this.send_record_string = send_record_string;
    }
}
