package com.dokle.ba.demo.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "countries")
@NamedStoredProcedureQueries(value= {
        @NamedStoredProcedureQuery(
                name = "getCountries",
                procedureName = "GET_COUNTRIES",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "response", type = Country.class)
                },
                resultClasses = {Country.class}
                )
})
public class Country extends LookupEntity {
    @Column(name = "country_code", length = 2, unique = true)
    private String countryCode;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return this.getId().toString();
    }
}
