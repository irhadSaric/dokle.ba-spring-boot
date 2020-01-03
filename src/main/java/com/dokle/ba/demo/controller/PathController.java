package com.dokle.ba.demo.controller;

import com.dokle.ba.demo.service.PathService;
import com.dokle.ba.demo.service.dtos.PathDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/path")
public class PathController {
    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @Autowired
    private PathService pathService;

    @PostMapping("/add")
    public void addPath(PathDTO pathDTO, HttpSession session, HttpServletResponse response) throws IOException {
        Long id = (Long) session.getAttribute("id");
        pathService.addPath(pathDTO, id);

        response.sendRedirect("/api/user/profile/"+session.getAttribute("id").toString());
    }
}
