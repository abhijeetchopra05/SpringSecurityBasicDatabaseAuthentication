package com.springsecurity.basicDatabaseAuthentication.controller;


import com.springsecurity.basicDatabaseAuthentication.model.User;
import com.springsecurity.basicDatabaseAuthentication.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NonSecuredResources {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/signupPage")
    public String signupPage(){
        return "signup";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/signup")
    public void signup(HttpServletRequest httpServletRequest){
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        User user = new User();
        user.setUsername(username);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(11);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userRepo.save(user);
    }
}
