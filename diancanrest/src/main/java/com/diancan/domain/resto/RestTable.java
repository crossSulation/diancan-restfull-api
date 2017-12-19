package com.diancan.domain.resto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

// 餐桌
@Entity(name="rest_table")
public class RestTable {
    @IdLong
    @GeneratedValue
    private  id; //

    private Integer num; // 编号
    private Integer maxPeople; //最大顾客人数
    private Integer minPeople = 1 ;//最小顾客人数,默认为一个
    private Date  startBookTime ;// 预定开始时间
    private Integer bookedTime ;// 预定时间
    private Boolean isBooked; //是否已经被预定
    @ManyToOne
    private Restaurant restaurant;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public RestTable() {}

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public Integer getMinPeople() {
        return minPeople;
    }

    public void setMinPeople(Integer minPeople) {
        this.minPeople = minPeople;
    }

    public Date getStartBookTime() {
        return startBookTime;
    }

    public void setStartBookTime(Date startBookTime) {
        this.startBookTime = startBookTime;
    }

    public Integer getBookedTime() {
        return bookedTime;
    }

    public void setBookedTime(Integer bookedTime) {
        this.bookedTime = bookedTime;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }
}
