package com.dokle.ba.demo.db.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "messages")
@NamedStoredProcedureQueries(value = {
        @NamedStoredProcedureQuery(
                name = "addMessage",
                procedureName = "ADD_MESSAGE",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "receiver_id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sender_id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "message_text_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "message_time_in", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "getAllMessagesForReceiver",
                procedureName = "GET_ALL_MESSAGES_FOR_RECEIVER",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "receiver_id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sender_id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "response", type = Object.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "getAllSenders",
                procedureName = "GET_ALL_SENDERS",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "response", type = User.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "getAllSendersV2",
                procedureName = "GET_ALL_SENDERS_V2",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "response", type = Object.class)
                }
        )
})
public class Message extends BaseEntity {
    @Column(name = "message_text", nullable = false)
    private String messageText;

    @Column(name = "sending_time", nullable = false)
    private Date sendingTime;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    public Message() {
    }

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
