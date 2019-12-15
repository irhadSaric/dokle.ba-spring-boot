package com.dokle.ba.demo.db.keys;

import com.dokle.ba.demo.db.entity.Details;
import com.dokle.ba.demo.db.entity.User;

import java.io.Serializable;

public class UserDetailKey implements Serializable {
    private User user;
    private Details details;

    public UserDetailKey() {
    }

    public UserDetailKey(User user, Details details) {
        this.user = user;
        this.details = details;
    }
}
