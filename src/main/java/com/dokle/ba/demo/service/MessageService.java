package com.dokle.ba.demo.service;

import com.dokle.ba.demo.db.entity.Message;
import com.dokle.ba.demo.db.repository.MessageRepository;
import com.dokle.ba.demo.service.dtos.MessageResponse;
import com.dokle.ba.demo.service.dtos.MessageSenderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public void addMessage(Long receiverId, Long senderId, Message message){
        messageRepository.addMessage(receiverId, senderId, message);
    }

    public List<MessageResponse> getAllMessagesForReceiver(Long id, Long receiverId) {
        return messageRepository.getAllMessagesForReceiver(id, receiverId);
    }

    public List<MessageSenderResponse> getAllSenders(Long id) {
        return messageRepository.getAllSenders(id);
    }
}
