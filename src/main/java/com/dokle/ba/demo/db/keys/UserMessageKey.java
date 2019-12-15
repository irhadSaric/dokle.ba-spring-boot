package com.dokle.ba.demo.db.keys;

import com.dokle.ba.demo.db.entity.Message;
import com.dokle.ba.demo.db.entity.User;

import java.io.Serializable;

public class UserMessageKey implements Serializable {
    private User receiverId;
    private User senderId;
    private Message messageId;

    public UserMessageKey() {
    }

    public UserMessageKey(User receiverId, User senderId, Message messageId) {
        this.receiverId = receiverId;
        this.senderId = senderId;
        this.messageId = messageId;
    }
}
