package com.dokle.ba.demo.controller;

import com.dokle.ba.demo.db.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class HomeController {
    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/home");
        return modelAndView;
    }

    @PostMapping(value = "/test")
    public ModelAndView test(@ModelAttribute User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hahu");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
