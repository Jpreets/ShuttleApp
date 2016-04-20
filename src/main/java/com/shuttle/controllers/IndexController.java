package com.shuttle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shuttle.bean.UserBean;
import com.shuttle.constants.ControllerConstants;
import com.shuttle.dao.UserDAO;
import com.shuttle.service.Notification;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IndexController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/registration",
            method = RequestMethod.POST)
    public String index(@ModelAttribute("user") UserBean user) {
        
        user.setUserPassword(BCrypt.hashpw(user.getUserPassword(), ControllerConstants.SALT));
        if(userDAO.save(user)!=null)
        {   Notification.sendWelcomeMail(user);
            return "redirect:/index.html#/login";
        }
        else
            return "redirect:/index.html";//error message to be sent
    }

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/admin/index.html";
        }
        return "redirect:/driver/index.html";
    }

}
