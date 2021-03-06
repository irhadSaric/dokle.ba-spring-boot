package com.dokle.ba.demo.controller;

import com.dokle.ba.demo.db.entity.*;
import com.dokle.ba.demo.service.*;
import com.dokle.ba.demo.service.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private ImpressionService impressionService;

    @Autowired
    private DetailsService detailsService;

    @Autowired
    private PathService pathService;

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
            modelAndView.addObject("successMessage", "Check your mail for activation code");
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
            response.sendRedirect("/api/user/register?message=Wrong activation link");
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
            //return false;//"/api/user/login?message=Wrong email or password or not activated";
            response.sendRedirect("/api/user/login?message=Wrong email or password or not activated");
        }
    }

    @GetMapping("/logout")
    public void logout(HttpSession session, HttpServletResponse response) throws IOException {
        session.removeAttribute("id");
        session.invalidate();
        response.sendRedirect("/api/user/login?message=Successfully logged out");
    }

    @GetMapping("/all")
    public List<UserResponse> all(){
        return userService.getAll();
    }

    @GetMapping("/find/{id}")
    public User findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @GetMapping("/profile/{id}")
    public ModelAndView profile(@PathVariable("id") Long id, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        User user = findById(id);
        Details details = detailsService.getDetailsByUserId(id);
        DetailsDTO detailsDTO;
        PathDTO pathDTO = new PathDTO();

        if (details.getCountry() == null){
            detailsDTO = new DetailsDTO(details.getAvatar(), details.getCity(), details.getPhoneNumber(), (short) 0);
        }
        else
        {
            detailsDTO = new DetailsDTO(details.getAvatar(), details.getCity(), details.getPhoneNumber(), details.getCountry().getId());
        }

        List<Country> countries = detailsService.getCountries();
        List<Payment> payments = detailsService.getPayments();
        List<Path> paths = pathService.getAllForUser(id);
        String image = null;
        if(details.getAvatar() != null){
            image = Base64.getEncoder().encodeToString(details.getAvatar());
        }
        List<ImpressionResponse> impressionResponseList = impressionService.getAllImpressionsForUser(id);
        Long unreadMessages = messageService.countUnreadMessages((Long) session.getAttribute("id"));

        modelAndView.setViewName("view/profile");
        modelAndView.addObject("unread", unreadMessages);
        modelAndView.addObject("user", user);
        modelAndView.addObject("impressions", impressionResponseList);
        modelAndView.addObject("details", details);
        modelAndView.addObject("detailsDTO", detailsDTO);
        modelAndView.addObject("avatar", image);
        modelAndView.addObject("countries", countries);
        modelAndView.addObject("path", pathDTO);
        modelAndView.addObject("payments", payments);
        modelAndView.addObject("paths", paths);
        //modelAndView.addObject("impressions",)
        return modelAndView;
    }

    @PostMapping("/ispis")
    public void ispis(PathDTO request){
        System.out.println(request);
        Date date = new Date();

    }

}
