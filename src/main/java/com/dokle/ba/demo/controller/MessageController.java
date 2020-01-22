package com.dokle.ba.demo.controller;

import com.dokle.ba.demo.db.entity.Message;
import com.dokle.ba.demo.db.entity.User;
import com.dokle.ba.demo.service.MessageService;
import com.dokle.ba.demo.service.dtos.MessageResponse;
import com.dokle.ba.demo.service.dtos.MessageSenderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public ModelAndView allMessages(HttpSession session, HttpServletResponse response) throws IOException {
        if(session.getAttribute("id") == null){
            response.sendRedirect("/api/user/login?message=You have to log in");
        }
        ModelAndView modelAndView = new ModelAndView();
        List<MessageSenderResponse> senders = messageService.getAllSenders((Long) session.getAttribute("id"));
        Message message = new Message();
        Long unreadMessages = messageService.countUnreadMessages((Long) session.getAttribute("id"));

        modelAndView.setViewName("view/message");
        modelAndView.addObject("unread", unreadMessages);
        modelAndView.addObject("senders", senders);
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @PostMapping("/add/{receiverId}")
    public void addMessage(HttpSession session, HttpServletResponse response,
                           @PathVariable("receiverId") Long receiverId,
                           Message message) throws IOException {
        Long senderId = (Long) session.getAttribute("id");
        message.setSendingTime(new Timestamp(System.currentTimeMillis()));
        messageService.addMessage(receiverId, senderId, message);
        response.sendRedirect("/api/messages/"+receiverId.toString());
    }

    @GetMapping("/{senderId}")
    public ModelAndView getAllMessagesForReceiver(HttpSession session, @PathVariable("senderId") Long senderId,
                                                           HttpServletResponse response) throws IOException {
        if(session.getAttribute("id") == null){
            response.sendRedirect("/api/user/login?message=You have to log in");
        }
        ModelAndView modelAndView = new ModelAndView();
        messageService.changeStatusOfMessages((Long) session.getAttribute("id"), senderId);
        List<MessageSenderResponse> senders = messageService.getAllSenders((Long) session.getAttribute("id"));
        List<MessageResponse> messages = messageService.getAllMessagesForReceiver((Long) session.getAttribute("id"), senderId);
        Message message = new Message();
        Long unreadMessages = messageService.countUnreadMessages((Long) session.getAttribute("id"));

        modelAndView.setViewName("view/message");
        modelAndView.addObject("unread", unreadMessages);
        modelAndView.addObject("receiverId", senderId);
        modelAndView.addObject("senders", senders);
        modelAndView.addObject("message", message);
        modelAndView.addObject("messages", messages);
        return modelAndView;
    }
    /*
    @GetMapping("/test/{senderId}")
    public ModelAndView test(HttpSession session, HttpServletResponse response,
                             @PathVariable("senderId") Long senderId) throws IOException {
        if(session.getAttribute("id") == null){
            response.sendRedirect("/api/user/login?message=You have to log in");
        }
        ModelAndView modelAndView = new ModelAndView();
        List<MessageSenderResponse> senders = messageService.getAllSenders((Long) session.getAttribute("id"));
        List<MessageResponse> messages = messageService.getAllMessagesForReceiver((Long) session.getAttribute("id"), senderId);
        Message message = new Message();
        modelAndView.setViewName("view/test");
        modelAndView.addObject("receiverId", senderId);
        modelAndView.addObject("senders", senders);
        modelAndView.addObject("message", message);
        modelAndView.addObject("messages", messages);
        return modelAndView;
    }*/
}
