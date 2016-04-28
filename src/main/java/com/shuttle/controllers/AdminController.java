package com.shuttle.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuttle.bean.OwnerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shuttle.repository.OwnerRepository;
import org.springframework.stereotype.Controller;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
