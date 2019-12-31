package com.dokle.ba.demo.db.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "details")
@NamedStoredProcedureQueries(value = {
        @NamedStoredProcedureQuery(
                name = "getDetailsByUserId",
                procedureName = "GET_USER_DETAILS_BY_ID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "response", type = Details.class)
                },
                resultClasses = { Details.class }
        ),
        @NamedStoredProcedureQuery(
                name = "uploadAvatar",
                procedureName = "UPLOAD_AVATAR",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "image_in", type = byte[].class)
                },
                resultClasses = { Details.class }
        ),
        @NamedStoredProcedureQuery(
                name = "editDetails",
                procedureName = "EDIT_DETAILS",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "city_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "country_in", type = Short.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "phone_number_in", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "editDetailsV2",
                procedureName = "EDIT_DETAILS_V2",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "city_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "country_in", type = Short.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "phone_number_in", type = String.class)
                }
        )
    }
)
public class Details extends BaseEntity{
    @Lob
    @Column(name = "avatar")
    private byte[] avatar;

    @Column(name = "city")
    private String city;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Details{" +
                "avatar=" + Arrays.toString(avatar) +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", country=" + country.getName() +
                '}';
    }
}
