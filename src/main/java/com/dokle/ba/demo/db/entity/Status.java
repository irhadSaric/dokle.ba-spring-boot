package com.dokle.ba.demo.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "statuses")
@NamedStoredProcedureQueries(
        @NamedStoredProcedureQuery(
                name = "getStatusByName",
                procedureName = "GET_STATUS_BY_NAME",
                parameters = {
                        @StoredProcedureParameter(name = "name_in", mode = ParameterMode.IN, type = String.class),
                        @StoredProcedureParameter(name = "response", mode = ParameterMode.REF_CURSOR, type = Status.class),
                },
                resultClasses = { Status.class }
        )
)
public class Status extends LookupEntity {
}
