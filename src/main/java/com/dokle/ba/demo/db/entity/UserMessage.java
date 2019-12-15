package com.dokle.ba.demo.db.entity;

import com.dokle.ba.demo.db.keys.UserMessageKey;

import javax.persistence.*;

@Entity
@Table(name = "user_messages")
@IdClass(UserMessageKey.class)
public class UserMessage {
    @Id
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiverId;

    @Id
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User senderId;

    @Id
    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message messageId;

    public User getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(User receiverId) {
        this.receiverId = receiverId;
    }

    public User getSenderId() {
        return senderId;
    }

    public void setSenderId(User senderId) {
        this.senderId = senderId;
    }

    public Message getMessageId() {
        return messageId;
    }

    public void setMessageId(Message messageId) {
        this.messageId = messageId;
    }
}
