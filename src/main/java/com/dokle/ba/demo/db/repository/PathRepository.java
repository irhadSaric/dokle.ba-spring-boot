package com.dokle.ba.demo.db.repository;

import com.dokle.ba.demo.db.entity.Path;
import com.dokle.ba.demo.service.dtos.PathDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PathRepository {
    @Autowired
    private EntityManager entityManager;

    /*
    @Transactional
    public void addPath(PathDTO pathDTO, Long id) {
        String date_in = new Timestamp(pathDTO.getDate().getTime()).toString();
        String time_in = new Timestamp(pathDTO.getDate().getTime()).toString();

        entityManager.createNamedStoredProcedureQuery("addPath")
            .setParameter("id_in", id)
            .setParameter("date_in", date_in)
            .setParameter("time_in", time_in)
            .setParameter("country_in", pathDTO.getCountry())
            .setParameter("starting_point_in", pathDTO.getStartingPoint())
            .setParameter("destination_in", pathDTO.getDestination())
            .setParameter("payment_int", pathDTO.getPayment())
        .execute();
    }*/
    /*@Transactional
    public void addPath(PathDTO pathDTO, Long id) {
        String date_in = new Timestamp(pathDTO.getDate().getTime()).toString();
        String time_in = new Timestamp(pathDTO.getDate().getTime()).toString();

        entityManager.createNamedStoredProcedureQuery("addPathV2")
                .setParameter("id_in", id)
                .setParameter("country_in", pathDTO.getCountry())
                .setParameter("starting_point_in", pathDTO.getStartingPoint())
                .setParameter("destination_in", pathDTO.getDestination())
                .setParameter("payment_int", pathDTO.getPayment())
                .execute();
    }*/

    /*
    // RADI
    @Transactional
    public void addPath(PathDTO pathDTO, Long id) {
        String date_in = new Timestamp(pathDTO.getDate().getTime()).toString();
        String time_in = new Timestamp(pathDTO.getDate().getTime()).toString();

        entityManager.createNamedStoredProcedureQuery("addPathV3")
                .setParameter("id_in", id)
                .setParameter("starting_point_in", pathDTO.getStartingPoint())
                .setParameter("destination_in", pathDTO.getDestination())
                .execute();
    }*/
    /*
    // RADI
    @Transactional
    public void addPath(PathDTO pathDTO, Long id) {
        String date_in = new Timestamp(pathDTO.getDate().getTime()).toString();
        String time_in = new Timestamp(pathDTO.getDate().getTime()).toString();

        entityManager.createNamedStoredProcedureQuery("addPathV4")
                .setParameter("id_in", id)
                .setParameter("country_in", pathDTO.getCountry())
                .execute();
    }*/

    /*//RADI
    @Transactional
    public void addPath(PathDTO pathDTO, Long id) {
        String date_in = new Timestamp(pathDTO.getDate().getTime()).toString();
        String time_in = new Timestamp(pathDTO.getDate().getTime()).toString();

        entityManager.createNamedStoredProcedureQuery("addPathV5")
                .setParameter("id_in", id)
                .setParameter("date_in", date_in)
                .execute();
    }*/
    /*
    //RADI
    @Transactional
    public void addPath(PathDTO pathDTO, Long id) {
        String date_in = new Timestamp(pathDTO.getDate().getTime()).toString();
        String time_in = new Timestamp(pathDTO.getDate().getTime()).toString();

        entityManager.createNamedStoredProcedureQuery("addPathV6")
                .setParameter("id_in", id)
                .setParameter("date_in", date_in)
                .setParameter("time_in", time_in)
                .execute();
    }*/
    /*
    @Transactional
    public void addPath(PathDTO pathDTO, Long id) {
        String date_in = new Timestamp(pathDTO.getDate().getTime()).toString();
        String time_in = new Timestamp(pathDTO.getDate().getTime()).toString();

        entityManager.createNamedStoredProcedureQuery("addPathV7")
                .setParameter("id_in", id)
                .setParameter("date_in", date_in)
                .setParameter("time_in", time_in)
                .setParameter("payment_in", pathDTO.getPayment())
                .execute();
    }*/
    @Transactional
    public void addPath(PathDTO pathDTO, Long id) {
        String date_in = new Timestamp(pathDTO.getDate().getTime()).toString();
        String time_in = new Timestamp(pathDTO.getDate().getTime()).toString();

        entityManager.createNamedStoredProcedureQuery("addPathV8")
                .setParameter("id_in", id)
                .setParameter("date_in", date_in)
                .setParameter("time_in", time_in)
                .setParameter("country_in", pathDTO.getCountry())
                .setParameter("starting_point_in", pathDTO.getStartingPoint())
                .setParameter("destination_in", pathDTO.getDestination())
                .setParameter("payment_in", pathDTO.getPayment())
                .execute();
    }

    public List<Path> getAllForUser(Long id) throws NoResultException {
        return (List<Path>) entityManager.createNamedStoredProcedureQuery("getPathsByUserId")
                .setParameter("id_in", id)
                .getResultList();
    }
}
