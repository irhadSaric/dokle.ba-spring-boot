package com.dokle.ba.demo.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "codes")
@NamedStoredProcedureQueries(value= {
        @NamedStoredProcedureQuery(
                name = "getActivationKeyForUser",
                procedureName = "GET_ACTIVATION_KEY_FOR_USER",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "response", type = Short.class)
                })
})
@SqlResultSetMapping(
        name = "code_result_mapping",
        entities = {
                @EntityResult(
                        entityClass = Code.class
                )
        }
)
public class Code extends BaseEntity{
    @Column(name = "activation_code", nullable = false)
    private Short activationCode;

    public Short getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(Short activationCode) {
        this.activationCode = activationCode;
    }
}
