package com.diancan.domain.resto;


import com.diancan.domain.resto.metadata.Address;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;
    @Id
    @GeneratedValue
    private Long restaurantId;
    //the Image info of the resto
    private String restoImage;
    //the contact
    private String contactor;
    //resto address
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address address;
    //resto dialnumber
    private String restodialnumber;
    //rest name
    private String restoName;
    // the rating star
    private Integer rating;

    @OneToMany(mappedBy = "restaurantId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<RestTable> tables =new ArrayList<>();

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Restaurant() {
    }

    public List<RestTable> getTables() {
        for(RestTable restTable : tables) {
            restTable.setRestaurantId(restaurantId);
        }
        return tables;
    }

    public void setTables(List<RestTable> tables) {
        this.tables = tables;
    }

    public String getRestoName() {
        return restoName;
    }

    public void setRestoName(String restoName) {
        this.restoName = restoName;
    }

    public String getRestoImage() {
        return restoImage;
    }

    public void setRestoImage(String restoImage) {
        this.restoImage = restoImage;
    }

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getRestodialnumber() {
        return restodialnumber;
    }

    public void setRestodialnumber(String restodialnumber) {
        this.restodialnumber = restodialnumber;
    }
}
