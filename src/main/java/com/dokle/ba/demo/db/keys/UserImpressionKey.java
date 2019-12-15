package com.dokle.ba.demo.db.keys;

import com.dokle.ba.demo.db.entity.Impression;
import com.dokle.ba.demo.db.entity.User;

import java.io.Serializable;

public class UserImpressionKey implements Serializable {
    private User receiverId;
    private User senderId;
    private Impression impressionId;

    public UserImpressionKey() {
    }

    public UserImpressionKey(User receiverId, User senderId, Impression impressionId) {
        this.receiverId = receiverId;
        this.senderId = senderId;
        this.impressionId = impressionId;
    }
}
