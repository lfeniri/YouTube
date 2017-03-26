package fr.esilv.s8.youtube.model;

import java.io.Serializable;

/**
 * Created by hope on 26/03/2017.
 */

public class UrlImage implements Serializable {
    private MediumUrl medium;

    public MediumUrl getMedium_url() {
        return medium;
    }

    public void setMedium_url(MediumUrl medium_url) {
        this.medium = medium_url;
    }

}
