/**
 * Created Date: 28 April 2016
 * Last Modified Date: 28 April 2016
 */
package com.shuttle.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuttle.bean.OwnerBean;
import com.shuttle.bean.VehicleBean;
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
import com.shuttle.repository.VehicleRepository;

@Controller
public class AdminController {

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @RequestMapping(value = ShuttleConstants.ADMIN_ADD_OWNER, method = RequestMethod.POST)
    @ResponseBody
    public String insertOwner(@RequestBody final String owner) {
        try {

            OwnerBean s = new ObjectMapper().readValue(owner, OwnerBean.class);
            if (owner != null) {

                ownerRepository.save(s);
                return "success";
            }
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "failure";
    }

    @RequestMapping(value = ShuttleConstants.ADMIN_GET_OWNERS, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<OwnerBean> getOwnerList() {

        return ownerRepository.findAll();
    }

    @RequestMapping(value = ShuttleConstants.ADMIN_ADD_Vehicle, method = RequestMethod.POST)
    @ResponseBody
    public String insertVehicle(@RequestBody final String vehicle) {
        try {
            System.out.println(vehicle);
            VehicleBean s = new ObjectMapper().readValue(vehicle, VehicleBean.class);
            
            if (vehicle != null) {
                vehicleRepository.save(s);
                return "success";
            }
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "failure";
    }

    @RequestMapping(value = ShuttleConstants.ADMIN_GET_VEHICLES, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<VehicleBean> getVehicleList() {
        return vehicleRepository.findAll();
    }
}
