package com.dokle.ba.demo.db.entity;

import com.dokle.ba.demo.db.keys.UserImpressionKey;

import javax.persistence.*;

@Entity
@Table(name = "user_impressions")
@IdClass(UserImpressionKey.class)
public class UserImpression {
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
    @JoinColumn(name = "impression_id")
    private Impression impressionId;

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

    public Impression getImpressionId() {
        return impressionId;
    }

    public void setImpressionId(Impression impressionId) {
        this.impressionId = impressionId;
    }
}
