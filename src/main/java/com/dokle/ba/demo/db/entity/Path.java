package com.dokle.ba.demo.db.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "paths")
public class Path extends BaseEntity {
    @Column(name = "starting_point")
    private String startingPoint;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departure_date")
    private Date date;

    @Column(name = "departure_time")
    private Date time;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
