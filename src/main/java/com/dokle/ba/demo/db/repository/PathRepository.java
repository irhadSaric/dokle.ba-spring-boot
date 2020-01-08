package com.dokle.ba.demo.db.repository;

import com.dokle.ba.demo.db.entity.Details;
import com.dokle.ba.demo.db.entity.Path;
import com.dokle.ba.demo.service.dtos.PathDTO;
import com.dokle.ba.demo.service.dtos.PathResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
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

    @Transactional
    public List<Path> getAllForUser(Long id) throws NoResultException {
        return (List<Path>) entityManager.createNamedStoredProcedureQuery("getPathsByUserId")
                .setParameter("id_in", id)
                .getResultList();
    }

    @Transactional
    public List<Path> getAll() {
        return (List<Path>) entityManager.createNamedStoredProcedureQuery("getPathsByUserId")
                .setParameter("id_in", Long.valueOf(101))
                .getResultList();
    }

    @Transactional
    public List<PathResponse> getAllForHomePage() throws SQLException {
        List result = entityManager.createNamedStoredProcedureQuery("getAllForHomePage")
                .getResultList();

        List<PathResponse> pathResponses = new ArrayList<>();

        for (Object obj: result){
            Object[] fields = (Object[]) obj;
            BigDecimal pathId = (BigDecimal) fields[0];
            Timestamp departureDate = (Timestamp) fields[1];
            String destination = (String) fields[2];
            String startingPoint = (String) fields[3];
            Timestamp departureTime = (Timestamp) fields[4];
            BigDecimal countryId = (BigDecimal) fields[5];
            BigDecimal paymentId = (BigDecimal) fields[6];
            String countryName = (String) fields[7];
            String paymentName = (String) fields[8];
            String userFirstName = (String) fields[9];
            BigDecimal userId = (BigDecimal) fields[10];
            Blob avatar = (Blob) fields[11];

            byte[] avatarByte;
            PathResponse pathResponse = new PathResponse();
            if(avatar != null){
                avatarByte = avatar.getBytes(1, (int) avatar.length());
                pathResponse.setSenderLogo(Base64.getEncoder().encodeToString(avatarByte));
            }

            pathResponse.setPathId(pathId.longValue());
            pathResponse.setDepartureDate(departureDate);
            pathResponse.setDestination(destination);
            pathResponse.setStartingPoint(startingPoint);
            pathResponse.setDepartureTime(departureTime);
            pathResponse.setCountryId(countryId.shortValueExact());
            pathResponse.setPaymentId(paymentId.shortValueExact());
            pathResponse.setCountryName(countryName);
            pathResponse.setPaymentName(paymentName);
            pathResponse.setUserFirstName(userFirstName);
            pathResponse.setUserId(userId.longValue());
            pathResponses.add(pathResponse);
        }
        return pathResponses;
    }
}
