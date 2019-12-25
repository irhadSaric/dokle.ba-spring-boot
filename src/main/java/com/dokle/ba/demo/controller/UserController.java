package com.dokle.ba.demo.controller;

import com.dokle.ba.demo.db.entity.User;
import com.dokle.ba.demo.service.UserService;
import com.dokle.ba.demo.service.dtos.LoginRequest;
import com.dokle.ba.demo.service.dtos.LoginResponse;
import com.dokle.ba.demo.service.dtos.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView register(@RequestParam(required = false) String message){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/register");
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid User user, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/register");
        User user1 = userService.register(user);
        if(user1 != null){
            modelAndView.addObject("message", "Check your mail for activation code");
            session.setAttribute("user", user1);
        }
        else {
            modelAndView.addObject("message", "Registration failed");
        }
        return modelAndView;
    }

    @GetMapping("/activate/{userId}/{activationCode}")
    public void activate(@PathVariable Long userId, @PathVariable Short activationCode, HttpServletResponse response) throws IOException {
        User user = userService.activate(userId, activationCode);
        if(user == null){
            response.sendRedirect("/api/user/register?message=Wrong activation code");
        }
        else {
            response.sendRedirect("/api/user/login?message=Activation successful. Please login");
        }
    }

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(required = false) String message){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/login");
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @PostMapping("/login")
    public void login(LoginRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        LoginResponse loginResponse = userService.login(request);
        if(loginResponse != null && loginResponse.isPassed()){
            session.setAttribute("id", loginResponse.getUser().getId());
            response.sendRedirect("/home");
        }
        else{
            response.sendRedirect("/api/login?message=Wrong email or password");
        }
    }

    @GetMapping("/all")
    public List<UserResponse> all(){
        return userService.getAll();
    }

    @GetMapping("/find/{id}")
    public User findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

}
