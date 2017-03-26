package fr.esilv.s8.youtube.model;

import java.io.Serializable;

/**
 * Created by hope on 17/03/2017.
 */

public class IdVideo implements Serializable {
    private String kind;
    private String videoId;

    public String getKind() {
        return kind;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}



