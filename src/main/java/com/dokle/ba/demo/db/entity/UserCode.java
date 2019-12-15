package com.dokle.ba.demo.db.entity;

import com.dokle.ba.demo.db.keys.UserCodeKey;

import javax.persistence.*;

@Entity
@Table(name = "user_codes")
@IdClass(UserCodeKey.class)
public class UserCode {
    @Id
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @OneToOne
    @JoinColumn(name = "code_id")
    private Code code;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }
}
