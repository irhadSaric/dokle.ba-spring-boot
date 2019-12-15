package com.dokle.ba.demo.db.entity;

import com.dokle.ba.demo.db.keys.UserDetailKey;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
@IdClass(UserDetailKey.class)
public class UserDetail {
    @Id
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @OneToOne
    @JoinColumn(name = "detail_id")
    private Details details;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
}
