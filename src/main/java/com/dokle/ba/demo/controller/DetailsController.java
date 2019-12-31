package com.dokle.ba.demo.controller;

import com.dokle.ba.demo.db.entity.Country;
import com.dokle.ba.demo.db.entity.Details;
import com.dokle.ba.demo.service.DetailsService;
import com.dokle.ba.demo.service.dtos.DetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/details")
public class DetailsController {
    @Autowired
    private DetailsService detailsService;

    @GetMapping("/get/countries")
    public List<Country> getCountries(){
        return detailsService.getCountries();
    }

    @GetMapping("/get/{id}")
    public Details getDetailsByUserId(@PathVariable("id") Long id){
        return detailsService.getDetailsByUserId(id);
    }

    @PostMapping("/change/avatar/{id}")
    public void uploadAvatar(@PathVariable("id") Long id, MultipartFile file, HttpServletResponse response) throws IOException {
        detailsService.uploadAvatar(id, file);
        response.sendRedirect("/api/user/profile/"+id.toString());
    }

    @PostMapping("/edit/{id}")
    public void editDetails(@PathVariable("id") Long id, DetailsDTO details, HttpSession sessionId, HttpServletResponse response) throws IOException {
        if(id.equals(sessionId.getAttribute("id"))){
            System.out.println("Controller:" + details);
            detailsService.editDetails(id, details);
            //response.sendRedirect("/api/user/profile/"+sessionId.getAttribute("id").toString());
        }
        response.sendRedirect("/api/user/profile/"+sessionId.getAttribute("id").toString());
    }
}
