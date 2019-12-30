package com.dokle.ba.demo.db.entity;

import com.dokle.ba.demo.service.dtos.ImpressionResponse;

import javax.persistence.*;
import java.sql.Types;
import java.util.List;

import static java.sql.Types.REF_CURSOR;

@Entity
@Table(name = "impressions")
@NamedStoredProcedureQueries(value = {
        @NamedStoredProcedureQuery(
                name = "addImpression",
                procedureName = "ADD_IMPRESSION",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "receiver_id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sender_id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "impression_in", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "getAllImpressionsForUser",
                procedureName = "GET_ALL_IMPRESSIONS_FOR_USER",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "response", type = Impression.class)
                },
                resultClasses = {
                        Impression.class
                }
        ),
        @NamedStoredProcedureQuery(
                name = "getAllImpressionsForUserV2",
                procedureName = "GET_ALL_IMPRESSIONS_FOR_USER_V2",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "response", type = Object.class)
                }
        )
})

public class Impression extends BaseEntity{
    @Column(name = "impression", nullable = false)
    private String impression;

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression;
    }
}
