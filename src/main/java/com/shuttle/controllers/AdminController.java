/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shuttle.controllers;

import com.google.gson.Gson;
import com.shuttle.bean.OwnerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shuttle.bean.UserBean;
import com.shuttle.constants.ControllerConstants;
import com.shuttle.repository.OwnerRepository;
import com.shuttle.service.Notification;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import com.shuttle.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private OwnerRepository ownerRepository;

    @RequestMapping(value = "/addOwner", method = RequestMethod.POST)
    @ResponseBody
    public String insertOwner(@RequestBody final String owner) {
        Gson gson = new Gson();
        OwnerBean s = gson.fromJson(owner, OwnerBean.class);
        if (owner != null) {
            ownerRepository.save(s);
            return "success";
        }
        return "failure";
    }

    @RequestMapping(value = "/getOwnerList", method = RequestMethod.GET,produces ="application/json")
    @ResponseBody
    public String getOwnerList() {
        List<OwnerBean> ownerList = new ArrayList<OwnerBean>();
        Gson gson = new Gson();
        String json = gson.toJson(ownerRepository.findAll());
        System.out.println("Amit" + json);
        return json;
    }
}
