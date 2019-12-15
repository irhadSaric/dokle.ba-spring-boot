package com.dokle.ba.demo.db.keys;

import com.dokle.ba.demo.db.entity.Path;
import com.dokle.ba.demo.db.entity.User;

import java.io.Serializable;

public class UserPathKey implements Serializable {
    private User user;
    private Path path;

    public UserPathKey() {
    }

    public UserPathKey(User user, Path path) {
        this.user = user;
        this.path = path;
    }
}
