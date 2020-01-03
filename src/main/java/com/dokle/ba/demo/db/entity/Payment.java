package com.dokle.ba.demo.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "payments")
@NamedStoredProcedureQueries(value= {
        @NamedStoredProcedureQuery(
                name = "getPayments",
                procedureName = "GET_PAYMENTS",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "response", type = Payment.class)
                },
                resultClasses = {Payment.class}
        )
})
public class Payment extends LookupEntity{
}
