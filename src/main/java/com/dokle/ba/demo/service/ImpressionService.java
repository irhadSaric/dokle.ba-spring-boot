package com.dokle.ba.demo.service;

import com.dokle.ba.demo.db.entity.Impression;
import com.dokle.ba.demo.db.repository.ImpressionRepository;
import com.dokle.ba.demo.service.dtos.ImpressionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImpressionService {
    @Autowired
    private ImpressionRepository impressionRepository;

    @Transactional
    public void addReview(Long receiverId, Long id, String impression) {
        impressionRepository.addImpression(receiverId, id, impression);
    }

    @Transactional
    public List<ImpressionResponse> getAllImpressionsForUser(Long id){
        List<ImpressionResponse> tempResult = impressionRepository.getAllImpressionsForUser(id);
        List<ImpressionResponse> result = new ArrayList<>();
        return tempResult;
    }
}
