package com.dokle.ba.demo.db.repository;

import com.dokle.ba.demo.db.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class StatusRepository {
    @Autowired
    private EntityManager entityManager;

    public Status getStatusByName(String name){
        return (Status) entityManager.createNamedStoredProcedureQuery("getStatusByName")
                .setParameter("name_in", name)
                .getSingleResult();
    }
}
