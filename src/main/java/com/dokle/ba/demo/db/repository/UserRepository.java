package com.dokle.ba.demo.db.repository;

import com.dokle.ba.demo.db.entity.Code;
import com.dokle.ba.demo.db.entity.User;
import com.dokle.ba.demo.service.dtos.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User register(User user) throws NoResultException{
        return (User) entityManager.createNamedStoredProcedureQuery("registerUserV2")
                            .setParameter("first_name_in", user.getFirstName())
                            .setParameter("last_name_in", user.getLastName())
                            .setParameter("email_in", user.getEmail())
                            .setParameter("password_in", bCryptPasswordEncoder.encode(user.getPassword()))
                            .getSingleResult();
    }

    public Short getActivationLink(Long id){
        return (Short) entityManager.createNamedStoredProcedureQuery("getActivationKeyForUser")
                .setParameter("id_in", id)
                .getOutputParameterValue("response");
    }

    public List<UserResponse> getAll(){
        List<UserResponse> result = new ArrayList<>();
        List<User> data = entityManager.createNamedStoredProcedureQuery("getUsers").getResultList();
        for (User user: data) {
            result.add(new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getStatus()));
        }
        return result;
    }

    public User findById(Long id) throws NoResultException{
        return (User) entityManager.createNamedStoredProcedureQuery("getUserById")
                .setParameter("userId", id)
                .getSingleResult();
    }

    public User activate(Long userId, Short activationCode) throws NullPointerException {
        return (User) entityManager.createNamedStoredProcedureQuery("activateUser")
                .setParameter("user_id_in", userId)
                .setParameter("activation_code_in", activationCode)
                .getSingleResult();
    }

    public String login(String email) {
        return (String) entityManager.createNamedStoredProcedureQuery("login")
                                .setParameter("email_in", email)
                                .getOutputParameterValue("response");
    }

    public User findByEmail(String email) throws NoResultException {
        return (User) entityManager.createNamedStoredProcedureQuery("getUserByEmail")
                .setParameter("email_in", email)
                .getSingleResult();
    }
}
