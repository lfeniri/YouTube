package fr.esilv.s8.youtube.model;

import java.io.Serializable;

/**
 * Created by hope on 17/03/2017.
 */

public class Item implements Serializable {
    private IdVideo id;
    private Video snippet;
    private String channelTitle;

    public IdVideo getId() {
        return id;
    }

    public Video getSnippet() {
        return snippet;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setId(IdVideo id) {
        this.id = id;
    }

    public void setSnippet(Video snippet) {
        this.snippet = snippet;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getTitle(){return snippet.getTitle();}
    public String getDescription(){return snippet.getDescription();}
}
