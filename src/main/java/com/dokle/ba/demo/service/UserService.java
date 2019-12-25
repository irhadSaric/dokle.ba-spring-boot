package com.dokle.ba.demo.service;

import com.dokle.ba.demo.db.entity.User;
import com.dokle.ba.demo.db.repository.UserRepository;
import com.dokle.ba.demo.service.dtos.LoginRequest;
import com.dokle.ba.demo.service.dtos.LoginResponse;
import com.dokle.ba.demo.service.dtos.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User register(User user){
        try {
            User userResponse = userRepository.register(user);
            Short activationCode = userRepository.getActivationLink(userResponse.getId());
            sendEmail(userResponse.getEmail(), activationCode, userResponse.getId());
            return userResponse;
        }
        catch (NoResultException exc){
            return null;
        }
    }

    @Transactional
    public List<UserResponse> getAll(){
        return userRepository.getAll();
    }

    @Transactional
    public User findById(Long id) {
        try{
            return userRepository.findById(id);
        }
        catch (NoResultException exc){
            return null;
        }
    }

    @Transactional
    public User findByEmail(String email) {
        try{
            return userRepository.findByEmail(email);
        }
        catch (NoResultException exc){
            return null;
        }
    }

    @Transactional
    public LoginResponse login(LoginRequest request) {
        try{
            User user = userRepository.findByEmail(request.getEmail());
            LoginResponse loginResponse = new LoginResponse();
            if(user == null){
                return null;
            }
            else {
                if (bCryptPasswordEncoder.matches(request.getPassword(), user.getPassword())){
                    loginResponse.setUser(user);
                    loginResponse.setPassed(true);
                }
                else {
                    loginResponse.setPassed(false);
                }
            }
            return loginResponse;
        }
        catch (NoResultException exception){
            return null;
        }
    }

    @Transactional
    public User activate(Long userId, Short activationCode) {
        try {
            return userRepository.activate(userId, activationCode);
        }
        catch (NullPointerException | NoResultException exception){
            return null;
        }
    }

    private void sendEmail(String email, Short code, Long userId) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject("Activation code - dokle.ba");
        msg.setText("http://localhost:8080/api/user/activate/"+userId.toString()+"/"+code.toString());
        javaMailSender.send(msg);
    }
}
