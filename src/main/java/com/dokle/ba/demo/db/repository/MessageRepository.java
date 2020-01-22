package com.dokle.ba.demo.db.repository;

import com.dokle.ba.demo.db.entity.Details;
import com.dokle.ba.demo.db.entity.Message;
import com.dokle.ba.demo.service.dtos.MessageResponse;
import com.dokle.ba.demo.service.dtos.MessageSenderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Repository
public class MessageRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void addMessage(Long receiverId, Long senderId, Message message){
        String messageTime = new Timestamp(message.getSendingTime().getTime()).toString();
        entityManager.createNamedStoredProcedureQuery("addMessage")
                .setParameter("receiver_id_in", receiverId)
                .setParameter("sender_id_in", senderId)
                .setParameter("message_text_in", message.getMessageText())
                .setParameter("message_time_in", messageTime)
                .execute();
    }

    @Transactional
    public List<MessageResponse> getAllMessagesForReceiver(Long id, Long receiverId) {
        List result = entityManager.createNamedStoredProcedureQuery("getAllMessagesForReceiver")
                .setParameter("receiver_id_in", receiverId)
                .setParameter("sender_id_in", id)
                .getResultList();

        List<MessageResponse> messageResponses = new ArrayList<>();
        for(Object obj: result){
            MessageResponse messageResponse = new MessageResponse();
            Object[] fields = (Object[]) obj;
            messageResponse.setMessageText((String) fields[1]);
            messageResponse.setSending_time((Timestamp) fields[2]);
            messageResponse.setStatusId(((BigDecimal) fields[3]).shortValueExact());
            messageResponse.setSenderId(((BigDecimal) fields[4]).longValue());
            messageResponse.setReceiverId(((BigDecimal) fields[5]).longValue());
            messageResponses.add(messageResponse);
        }
        return messageResponses;
    }

    @Transactional
    public List<MessageSenderResponse> getAllSenders(Long id) {
        List result = entityManager.createNamedStoredProcedureQuery("getAllSendersV2")
                .setParameter("id_in", id)
                .getResultList();
        //id -> session.id, id_out -> sender.id
        List<MessageSenderResponse> messageSenderResponses = new ArrayList<>();
        for (Object obj: result){
            Object[] fields = (Object[]) obj;
            BigDecimal id_out = (BigDecimal) fields[0];
            String name_out = (String) fields[1];
            MessageSenderResponse messageSenderResponse = new MessageSenderResponse(id_out.longValue(), name_out);

            Details detail = (Details) entityManager.createNamedStoredProcedureQuery("getDetailsByUserId")
                    .setParameter("id_in", id_out.longValue())
                    .getSingleResult();

            if(detail.getAvatar() == null){
                messageSenderResponse.setAvatar(null);
            }
            else
            {
                messageSenderResponse.setAvatar(Base64.getEncoder().encodeToString(detail.getAvatar()));
            }
            Long sender_id = id_out.longValue();

            Message lastMessage = (Message) entityManager.createNamedStoredProcedureQuery("getLastMessage")
                    .setParameter("receiver_in", id)
                    .setParameter("sender_in", sender_id)
                    .getSingleResult();
            messageSenderResponse.setLastMessage(lastMessage);
            messageSenderResponses.add(messageSenderResponse);
        }

        return messageSenderResponses;
    }

    @Transactional
    public Long countUnreadMessages(Long id) {
        return (Long) entityManager.createNamedStoredProcedureQuery("countUnreadMessages")
                .setParameter("id_in", id)
                .getOutputParameterValue("response");
    }

    @Transactional
    public void changeStatusOfMessages(Long id, Long senderId) {
        entityManager.createNamedStoredProcedureQuery("changeStatusOfMessages")
                .setParameter("receiver_in", id)
                .setParameter("sender_in", senderId)
                .execute();
    }
}
