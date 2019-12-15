package com.dokle.ba.demo.db.keys;

import com.dokle.ba.demo.db.entity.Code;
import com.dokle.ba.demo.db.entity.User;

import java.io.Serializable;

public class UserCodeKey implements Serializable {
    private User user;
    private Code code;

    public UserCodeKey() {
    }

    public UserCodeKey(User user, Code code) {
        this.user = user;
        this.code = code;
    }
}
