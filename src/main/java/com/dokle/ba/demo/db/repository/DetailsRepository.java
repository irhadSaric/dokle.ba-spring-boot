package com.dokle.ba.demo.db.repository;

import com.dokle.ba.demo.db.entity.Country;
import com.dokle.ba.demo.db.entity.Details;
import com.dokle.ba.demo.db.entity.Payment;
import com.dokle.ba.demo.service.dtos.DetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class DetailsRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Details getDetailsByUserId(Long id) {
        try {
            return (Details) entityManager.createNamedStoredProcedureQuery("getDetailsByUserId")
                    .setParameter("id_in", id)
                    .getSingleResult();
        }
        catch (NoResultException exc){
            return null;
        }
    }

    @Transactional
    public void uploadAvatar(Long id, byte[] bytes) {
        entityManager.createNamedStoredProcedureQuery("uploadAvatar")
                .setParameter("id_in", id)
                .setParameter("image_in", bytes)
                .execute();
    }

    @Transactional
    public void editDetails(Long id, DetailsDTO details) {
        Short country_id = 0;
        if(details.getCountry() != null){
            country_id = details.getCountry();
        }
        System.out.println("Repository" + details);
        entityManager.createNamedStoredProcedureQuery("editDetailsV2")
                .setParameter("id_in", id)
                .setParameter("city_in", details.getCity())
                .setParameter("country_in", country_id)
                .setParameter("phone_number_in", details.getPhoneNumber())
                .execute();
    }

    @Transactional
    public List<Country> getCountries() {
        return (List<Country>) entityManager.createNamedStoredProcedureQuery("getCountries")
                .getResultList();
    }

    @Transactional
    public List<Payment> getPayments() {
        return (List<Payment>) entityManager.createNamedStoredProcedureQuery("getPayments")
                .getResultList();
    }
}
