package fr.esilv.s8.youtube.model;

import java.io.Serializable;

/**
 * Created by hope on 26/03/2017.
 */

public class MediumUrl implements Serializable {
    private String url;
    private int width;
    private int height;

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
