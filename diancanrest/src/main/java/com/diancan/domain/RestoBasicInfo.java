package com.diancan.domain;

import com.sun.jndi.toolkit.url.Uri;

import java.io.Serializable;

public class RestoBasicInfo implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;
    private Integer id;
    private Uri restoImage;
    private String contactor;
    private String restoAddress;
    private String restodialnumber;
    private String RestoName;
    public RestoBasicInfo() {
    }

    public String getRestoName() {
        return RestoName;
    }

    public void setRestoName(String restoName) {
        RestoName = restoName;
    }

    public Uri getRestoImage() {
        return restoImage;
    }

    public void setRestoImage(Uri restoImage) {
        this.restoImage = restoImage;
    }

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    public String getRestoAddress() {
        return restoAddress;
    }

    public void setRestoAddress(String restoAddress) {
        this.restoAddress = restoAddress;
    }

    public String getRestodialnumber() {
        return restodialnumber;
    }

    public void setRestodialnumber(String restodialnumber) {
        this.restodialnumber = restodialnumber;
    }
}
