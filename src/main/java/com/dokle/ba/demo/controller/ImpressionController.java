package com.dokle.ba.demo.controller;

import com.dokle.ba.demo.db.entity.Impression;
import com.dokle.ba.demo.service.ImpressionService;
import com.dokle.ba.demo.service.dtos.ImpressionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/impression")
public class ImpressionController {
    @Autowired
    private ImpressionService impressionService;

    @PostMapping("/add/{receiverId}/{senderId}")
    public void addReview(@PathVariable Long receiverId, @PathVariable Long senderId, String impression, HttpServletResponse response) throws IOException {
        impressionService.addReview(receiverId, senderId, impression);
        response.sendRedirect("/api/user/profile/"+receiverId.toString());
    }

    @GetMapping("/get/all/{id}")
    public List<ImpressionResponse> getAll(@PathVariable Long id){
        return impressionService.getAllImpressionsForUser(id);
    }
}
