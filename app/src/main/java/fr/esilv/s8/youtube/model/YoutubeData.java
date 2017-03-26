package fr.esilv.s8.youtube.model;

import java.util.ArrayList;

/**
 * Created by hope on 17/03/2017.
 */

public class YoutubeData {

    private String regionCode;
    private String etag;
    private String kind;
    private ArrayList<Item> items;

    public String getRegionCode() {
        return regionCode;
    }

    public String getEtag() {
        return etag;
    }

    public String getKind() {
        return kind;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
