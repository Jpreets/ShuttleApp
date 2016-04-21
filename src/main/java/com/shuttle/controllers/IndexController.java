package com.shuttle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shuttle.bean.UserBean;
import com.shuttle.constants.ControllerConstants;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import com.shuttle.repository.UserRepository;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userDAO;

    @RequestMapping(value = "/registration",
            method = RequestMethod.POST)
    public String index(String userName,String userEmail, String userPassword) {

        userPassword = BCrypt.hashpw(userPassword, ControllerConstants.SALT);
        this.userDAO.save(new UserBean( userName, userEmail, userPassword));

        return "redirect:/index.html#/login";
    }

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/admin/index.html";
        }
        return "redirect:/driver/index.html";
    }


}
