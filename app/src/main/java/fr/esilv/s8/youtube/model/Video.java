package fr.esilv.s8.youtube.model;

import java.io.Serializable;

/**
 * Created by hope on 17/03/2017.
 */

public class Video implements Serializable {

    private String publishedAt;
    private String channelId;
    private String title;
    private String description;
    private UrlImage thumbnails;

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediumUrl(){
        return thumbnails.getMedium_url().getUrl();
    }

    public UrlImage getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(UrlImage thumbnails) {
        this.thumbnails = thumbnails;
    }
}
