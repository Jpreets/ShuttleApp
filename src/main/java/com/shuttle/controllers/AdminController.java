/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shuttle.controllers;

//import com.google.gson.Gson;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            ObjectMapper mapper = new ObjectMapper();

            OwnerBean s = mapper.readValue(owner, OwnerBean.class);
            if (owner != null) {
                
                ownerRepository.save(s);
                return "success";
            }
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "failure";
    }

    @RequestMapping(value = "/getOwnerList", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<OwnerBean> getOwnerList() {

        return ownerRepository.findAll();
    }
}
