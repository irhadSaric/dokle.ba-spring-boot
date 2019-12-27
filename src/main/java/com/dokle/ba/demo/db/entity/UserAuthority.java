package com.dokle.ba.demo.db.entity;

import com.dokle.ba.demo.db.keys.UserAuthorityKey;

import javax.persistence.*;

@Entity
@Table(name = "user_authorities")
@IdClass(UserAuthorityKey.class)
public class UserAuthority {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "authoroty_id")
    private Authority authority;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
