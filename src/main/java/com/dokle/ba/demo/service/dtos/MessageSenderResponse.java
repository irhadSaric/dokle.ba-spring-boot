package com.dokle.ba.demo.service.dtos;

import com.dokle.ba.demo.db.entity.Message;

public class MessageSenderResponse {
    private Long id;
    private String firstName;
    private String avatar;
    private Message lastMessage;

    public MessageSenderResponse() {
    }

    public MessageSenderResponse(Long id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public MessageSenderResponse(Long id, String firstName, String avatar) {
        this.id = id;
        this.firstName = firstName;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Message getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(Message lastMessage) {
        this.lastMessage = lastMessage;
    }
}
