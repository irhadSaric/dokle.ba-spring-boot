package com.dokle.ba.demo.controller;

import com.dokle.ba.demo.db.entity.Country;
import com.dokle.ba.demo.db.entity.Path;
import com.dokle.ba.demo.db.entity.Payment;
import com.dokle.ba.demo.db.entity.User;
import com.dokle.ba.demo.service.DetailsService;
import com.dokle.ba.demo.service.PathService;
import com.dokle.ba.demo.service.dtos.PathDTO;
import com.dokle.ba.demo.service.dtos.PathResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private PathService pathService;

    @Autowired
    private DetailsService detailsService;

    @GetMapping("/")
    public ModelAndView home_(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/home");
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home(HttpSession session, HttpServletResponse response) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        PathDTO path = new PathDTO();
        List<Path> allPaths = pathService.getAll();
        List<Country> countries = detailsService.getCountries();
        List<Payment> payments = detailsService.getPayments();

        modelAndView.setViewName("view/login");
        modelAndView.addObject("id", session.getAttribute("id"));
        modelAndView.addObject("path", path);
        modelAndView.addObject("paths", allPaths);
        modelAndView.addObject("countries", countries);
        modelAndView.addObject("payments", payments);

        modelAndView.setViewName("view/home");
        /*if(session.getAttribute("id") == null){
            response.sendRedirect("/api/user/login?message=You have to login");
        }*/
        return modelAndView;
    }

    @GetMapping("/home2")
    public ModelAndView home2(HttpSession session, HttpServletResponse response) throws IOException {
        if(session.getAttribute("id") != null){
            ModelAndView modelAndView = new ModelAndView();
            PathDTO path = new PathDTO();
            List<Country> countries = detailsService.getCountries();
            List<Payment> payments = detailsService.getPayments();
            List<PathResponse> pathResponse = pathService.getAllForHomePage();

            modelAndView.setViewName("view/home");
            modelAndView.addObject("path", path);
            modelAndView.addObject("countries", countries);
            modelAndView.addObject("payments", payments);
            modelAndView.addObject("paths", pathResponse);
            return modelAndView;
        }
        else{
            response.sendRedirect("/api/user/login?message=You have to log in");
            return null;
        }
    }
}
