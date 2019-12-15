package com.dokle.ba.demo.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "codes")
public class Code extends BaseEntity{
    @Column(name = "activation_code", nullable = false)
    private Short activationCode;

    public Short getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(Short activationCode) {
        this.activationCode = activationCode;
    }
}
