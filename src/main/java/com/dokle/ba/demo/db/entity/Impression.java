package com.dokle.ba.demo.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "impressions")
public class Impression extends BaseEntity{
    @Column(name = "impression", nullable = false)
    private String impression;

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression;
    }
}
