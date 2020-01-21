package com.dokle.ba.demo.service.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Date;

public class MessageResponse {
    private String messageText;
    private Timestamp sending_time;
    private Short statusId;
    private Long receiverId;
    private Long senderId;

    public MessageResponse() {
    }

    public MessageResponse(String messageText, Timestamp sending_time, Short statusId, Long receiverId, Long senderId) {
        this.messageText = messageText;
        this.sending_time = sending_time;
        this.statusId = statusId;
        this.receiverId = receiverId;
        this.senderId = senderId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Timestamp getSending_time() {
        return sending_time;
    }

    public void setSending_time(Timestamp sending_time) {
        this.sending_time = sending_time;
    }

    public Short getStatusId() {
        return statusId;
    }

    public void setStatusId(Short statusId) {
        this.statusId = statusId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }
}
