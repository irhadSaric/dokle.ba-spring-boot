package com.dokle.ba.demo.db.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message extends BaseEntity {
    @Column(name = "message_text", nullable = false)
    private String messageText;

    @Column(name = "sending_time", nullable = false)
    private Date sendingTime;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Date getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(Date sendingTime) {
        this.sendingTime = sendingTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
