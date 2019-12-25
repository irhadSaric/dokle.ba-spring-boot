package com.dokle.ba.demo.controller;

import com.dokle.ba.demo.db.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class HomeController {
    @GetMapping("/")
    public ModelAndView home_(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/register");
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/home");
        modelAndView.addObject("id", session.getAttribute("id"));
        return modelAndView;
    }
}
