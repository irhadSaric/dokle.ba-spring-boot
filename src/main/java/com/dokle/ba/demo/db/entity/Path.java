package com.dokle.ba.demo.db.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "paths")
@NamedStoredProcedureQueries(value = {
        @NamedStoredProcedureQuery(
                name = "addPath",
                procedureName = "ADD_PATH",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "date_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "time_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "country_in", type = Short.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "starting_point_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "destination_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "payment_int", type = Short.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "addPathV3",
                procedureName = "ADD_PATH_V3",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "starting_point_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "destination_in", type = String.class),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "addPathV4",
                procedureName = "ADD_PATH_V4",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "country_in", type = Short.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "addPathV5",
                procedureName = "ADD_PATH_V5",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "date_in", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "addPathV6",
                procedureName = "ADD_PATH_V6",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "date_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "time_in", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "addPathV7",
                procedureName = "ADD_PATH_V7",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "date_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "time_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "payment_in", type = Short.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "addPathV8",
                procedureName = "ADD_PATH_V8",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "date_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "time_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "country_in", type = Short.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "starting_point_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "destination_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "payment_in", type = Short.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "getPathsByUserId",
                procedureName = "GET_PATHS_BY_USER_ID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "response", type = Path.class)
                },
                resultClasses = { Path.class }
        ),
        @NamedStoredProcedureQuery(
                name = "getAllForHomePage",
                procedureName = "GET_ALL_FOR_HOME_PAGE",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "response", type = Object.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "filterAllForHomePage",
                procedureName = "FILTER_PATHS_TEST",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "starting_point_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "destination_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "departure_date_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "departure_time_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "country_in", type = Short.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "payment_in", type = Short.class),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "response", type = Path.class)
                },
                resultClasses = {Path.class}
        ),
        @NamedStoredProcedureQuery(
                name = "filterAllForHomePageV2",
                procedureName = "FILTER_PATHS_TEST_2",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "starting_point_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "destination_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "departure_date_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "departure_time_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "country_in", type = Short.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "payment_in", type = Short.class),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "response", type = Path.class)
                }
        )
})
public class Path extends BaseEntity {
    @Column(name = "starting_point")
    private String startingPoint;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departure_date")
    private Date date;

    @Column(name = "departure_time")
    private Date time;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
