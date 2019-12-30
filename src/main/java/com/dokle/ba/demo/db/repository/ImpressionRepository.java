package com.dokle.ba.demo.db.repository;

import com.dokle.ba.demo.db.entity.Details;
import com.dokle.ba.demo.db.entity.Impression;
import com.dokle.ba.demo.db.entity.User;
import com.dokle.ba.demo.service.dtos.ImpressionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Repository
public class ImpressionRepository {
    @Autowired
    private EntityManager entityManager;

    public void addImpression(Long receiverId, Long id, String impression){
        entityManager.createNamedStoredProcedureQuery("addImpression")
                .setParameter("receiver_id_in", receiverId)
                .setParameter("sender_id_in", id)
                .setParameter("impression_in", impression)
                .execute();
    }

    public List<ImpressionResponse> getAllImpressionsForUser(Long id) {
        List result = entityManager.createNamedStoredProcedureQuery("getAllImpressionsForUserV2")
                .setParameter("id_in", id)
                .getResultList();
        List<ImpressionResponse> impressionResponses = new ArrayList<>();
        for (Object obj: result){
            Object[] fields = (Object[]) obj;
            String impression_out = (String) fields[0];
            BigDecimal id_out = (BigDecimal) fields[1];
            ImpressionResponse impressionResponse = new ImpressionResponse(id_out.longValue(), impression_out);

            Details detail = (Details) entityManager.createNamedStoredProcedureQuery("getDetailsByUserId")
                    .setParameter("id_in", id_out.longValue())
                    .getSingleResult();

            impressionResponse.setSenderLogo(Base64.getEncoder().encodeToString(detail.getAvatar()));

            User user = (User) entityManager.createNamedStoredProcedureQuery("getUserById")
                    .setParameter("userId", id_out.longValue())
                    .getSingleResult();
            impressionResponse.setSenderFirstName(user.getFirstName());

            impressionResponses.add(impressionResponse);
        }

        return impressionResponses;
    }
}
