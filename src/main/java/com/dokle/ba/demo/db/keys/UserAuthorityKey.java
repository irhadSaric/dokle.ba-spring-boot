package com.dokle.ba.demo.db.keys;

import com.dokle.ba.demo.db.entity.Authority;
import com.dokle.ba.demo.db.entity.User;

import java.io.Serializable;

public class UserAuthorityKey implements Serializable {
    private User user;
    private Authority authority;

    public UserAuthorityKey() {
    }

    public UserAuthorityKey(User user, Authority authority) {
        this.user = user;
        this.authority = authority;
    }
}
