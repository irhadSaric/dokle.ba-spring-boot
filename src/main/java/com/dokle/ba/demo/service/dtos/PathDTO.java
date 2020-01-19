package com.dokle.ba.demo.service.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class PathDTO {
    private String startingPoint;
    private String destination;

    //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;

    @DateTimeFormat(pattern = "HH:mm")
    @Temporal(TemporalType.TIME)
    private Date time;

    private Short country;
    private Short payment;

    public PathDTO() {
    }

    public PathDTO(String startingPoint, String destination, Date date, Date time, Short country, Short payment) {
        this.startingPoint = startingPoint;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.country = country;
        this.payment = payment;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Short getCountry() {
        return country;
    }

    public void setCountry(Short country) {
        this.country = country;
    }

    public Short getPayment() {
        return payment;
    }

    public void setPayment(Short payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "PathDTO{" +
                "startingPoint='" + startingPoint + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", country=" + country +
                ", payment=" + payment +
                '}';
    }
}
