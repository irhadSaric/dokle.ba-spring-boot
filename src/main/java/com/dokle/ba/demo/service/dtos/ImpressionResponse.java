package com.dokle.ba.demo.service.dtos;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.Arrays;

public class ImpressionResponse {
    private Long senderId;
    private String impression;
    private String senderLogo;
    private String senderFirstName;

    public ImpressionResponse() {
    }

    public ImpressionResponse(Long senderId, String impression) {
        this.senderId = senderId;
        this.impression = impression;
    }

    public ImpressionResponse(Long senderId, String impression, String senderLogo, String senderFirstName) {
        this.senderId = senderId;
        this.impression = impression;
        this.senderLogo = senderLogo;
        this.senderFirstName = senderFirstName;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression;
    }

    public String getSenderLogo() {
        return senderLogo;
    }

    public void setSenderLogo(String senderLogo) {
        this.senderLogo = senderLogo;
    }

    public String getSenderFirstName() {
        return senderFirstName;
    }

    public void setSenderFirstName(String senderFirstName) {
        this.senderFirstName = senderFirstName;
    }

    @Override
    public String toString() {
        return "ImpressionResponse{" +
                "senderId=" + senderId +
                ", impression='" + impression + '\'' +
                ", senderFirstName='" + senderFirstName + '\'' +
                '}';
    }
}
