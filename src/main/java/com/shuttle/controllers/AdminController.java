/**
 * Created Date: 28 April 2016
 * Last Modified Date: 28 April 2016
 */
package com.shuttle.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.shuttle.bean.OwnerBean;
import com.shuttle.bean.UserBean;
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
import com.shuttle.constants.ShuttleConstants;
import com.shuttle.repository.RoleRepository;
import com.shuttle.repository.UserRepository;
import com.shuttle.service.UserService;
import com.shuttle.util.GeneratePassword;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;
    
  
    
    @Autowired
    private OwnerRepository ownerRepository;

    @RequestMapping(value = ShuttleConstants.ADMIN_ADD_OWNER, method = RequestMethod.POST)
    @ResponseBody
    public String insertOwner(@RequestBody final String owner) {
        Boolean result = false;
        try {
            UserBean s = new ObjectMapper().readValue(owner, UserBean.class);
            s.setUserRole("ROLE_OWNER");
            //s.setUserRole(roleRepository.findByRoleName("ROLE_OWNER"));
            result=userService.insertUser(s);
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (result?"success":"failure");
    }

    @RequestMapping(value = ShuttleConstants.ADMIN_GET_OWNERS, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserBean> getOwnerList() {
        List<UserBean> users=userRepository.findByUserRole("ROLE_OWNER");
        return users;
    }
}
