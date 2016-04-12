package com.shuttle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shuttle.bean.UserBean;
import com.shuttle.service.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration",
            method = RequestMethod.POST)
    public String index(String userName,String userEmail, String userPassword) {

        
        this.userService.save(new UserBean( userName, userEmail, userPassword));

        return "/welcome";
    }

    @RequestMapping(value = "/admin/index")

    public String admin() {

        return "admin/index";
    }

    @RequestMapping(value = "/driver/index")

    public String driver() {

        return "driver/index";
    }
    
       @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("admin")) {
            return "redirect:/service/admin/index";
        }
        return "redirect:/service/driver/index";
    }


}
