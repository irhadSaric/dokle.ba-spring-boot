package com.dokle.ba.demo.controller;

import com.dokle.ba.demo.db.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@RestController
public class HomeController {
    @GetMapping("/")
    public ModelAndView home_(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/login");
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home(HttpSession session, HttpServletResponse response) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/home");
        /*if(session.getAttribute("id") == null){
            response.sendRedirect("/api/user/login?message=You have to login");
        }*/
        modelAndView.addObject("id", session.getAttribute("id"));
        return modelAndView;
    }
}
