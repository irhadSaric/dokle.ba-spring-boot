package com.dokle.ba.demo.db.entity;

import com.dokle.ba.demo.service.dtos.UserResponse;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "users")
@NamedStoredProcedureQueries(value= {
        @NamedStoredProcedureQuery(
                name= "registerUser",
                procedureName= "REGISTER_USER",
                parameters= {
                @StoredProcedureParameter(mode= ParameterMode.IN, name= "first_name_in", type= String.class),
                @StoredProcedureParameter(mode= ParameterMode.IN, name= "last_name_in", type= String.class),
                @StoredProcedureParameter(mode= ParameterMode.IN, name= "email_in", type= String.class),
                @StoredProcedureParameter(mode= ParameterMode.IN, name= "password_in", type= String.class),
                @StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "response", type= User.class)
                }),
        @NamedStoredProcedureQuery(
        name= "registerUserV2",
        procedureName= "REGISTER_USER_V2",
        parameters= {
                @StoredProcedureParameter(mode= ParameterMode.IN, name= "first_name_in", type= String.class),
                @StoredProcedureParameter(mode= ParameterMode.IN, name= "last_name_in", type= String.class),
                @StoredProcedureParameter(mode= ParameterMode.IN, name= "email_in", type= String.class),
                @StoredProcedureParameter(mode= ParameterMode.IN, name= "password_in", type= String.class),
                @StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "response", type= UserResponse.class)
        },
        resultSetMappings = { "user_result_mapping"}),
        @NamedStoredProcedureQuery(
                name= "registerUserV3",
                procedureName= "REGISTER_USER_V3",
                parameters= {
                        @StoredProcedureParameter(mode= ParameterMode.IN, name= "first_name_in", type= String.class),
                        @StoredProcedureParameter(mode= ParameterMode.IN, name= "last_name_in", type= String.class),
                        @StoredProcedureParameter(mode= ParameterMode.IN, name= "email_in", type= String.class),
                        @StoredProcedureParameter(mode= ParameterMode.IN, name= "password_in", type= String.class),
                        @StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "response", type= UserResponse.class)
                },
                resultSetMappings = { "user_result_mapping"}),
        @NamedStoredProcedureQuery(
                name= "getUsers",
                procedureName= "GET_USERS",
                parameters= {
                        @StoredProcedureParameter(mode= ParameterMode.REF_CURSOR, name= "response", type= User.class)
                },
                resultSetMappings = { "user_result_mapping" }),
        @NamedStoredProcedureQuery(
                name = "getUserById",
                procedureName = "GET_USER_BY_ID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "response", type = UserResponse.class)
                },
                resultClasses = { User.class }),
        @NamedStoredProcedureQuery(
                name = "activateUser",
                procedureName = "ACTIVATE_USER",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "user_id_in", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "activation_code_in", type = Short.class),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "response", type = UserResponse.class)
                },
                resultClasses = { User.class }),
        @NamedStoredProcedureQuery(
                name = "login",
                procedureName = "LOGIN",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "email_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "response", type = String.class)
                }),
        @NamedStoredProcedureQuery(
                name = "getUserByEmail",
                procedureName = "GET_USER_BY_EMAIL",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "email_in", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "response", type = User.class)
                },
                resultClasses = { User.class })
})
@SqlResultSetMapping(
        name = "user_result_mapping",
        entities = {
                @EntityResult(
                        entityClass = User.class
                )
        }
)
public class User extends BaseEntity implements Serializable {
    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(name = "password", nullable = false)
    @Length(min = 5, message = "Your password must have at least 5 characters")
    private String password;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public User() {
    }

    public User(@NotNull String firstName, @NotNull String lastName, @NotNull @Email String email, @NotNull @Length(min = 5, message = "Your password must have at least 5 characters") String password, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public User(@NotNull String firstName, @NotNull String lastName, @NotNull @Email String email, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
    }

    public User(Long id){
        this.setId(id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
