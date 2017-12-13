package com.diancan.domain.restoinfo;

import com.sun.jndi.toolkit.url.Uri;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class RestoBasicInfo implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;
    @Id
    @GeneratedValue
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
