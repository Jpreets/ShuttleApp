/**
 * Created Date: 28 April 2016
 * Last Modified Date: 28 April 2016
 */
package com.shuttle.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuttle.bean.DriverBean;
import com.shuttle.bean.RouteBean;
import com.shuttle.bean.RouteStopsBean;
import com.shuttle.bean.UserBean;
import com.shuttle.bean.VehicleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shuttle.constants.ShuttleConstants;
import com.shuttle.repository.DriverRepository;
import com.shuttle.repository.RouteRepository;
import com.shuttle.repository.UserRepository;
import com.shuttle.repository.VehicleRepository;
import com.shuttle.service.UserService;
import com.shuttle.util.GenerateFileName;
import java.io.File;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@PropertySource("classpath:ShuttleConfig.properties")

@Controller
public class AdminController {

    @Value("${shuttle.directory_driver_photo}")
    private String directoryDriverPhoto;
    @Value("${shuttle.directory_driver_license}")
    private String directoryDriverLicense;
    @Value("${shuttle.directory_driver_id_proof}")
    private String directoryDriverIdProof;
    @Value("${shuttle.directory_route_map}")
    private String directoryRouteMap;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private DriverRepository driverRepository;

    @RequestMapping(value = ShuttleConstants.ADMIN_ADD_OWNER, method = RequestMethod.POST)
    @ResponseBody
    public String insertOwner(@RequestBody final String owner) {
        UserBean result = null;
        try {
            UserBean s = new ObjectMapper().readValue(owner, UserBean.class);
            s.setUserRole(ShuttleConstants.ROLE_OWNER);
            result = userService.insertUser(s);
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (result != null ? ShuttleConstants.SUCCESS : ShuttleConstants.EMAIL_EXISTS);
    }

    @RequestMapping(value = ShuttleConstants.ADMIN_GET_OWNERS, method = RequestMethod.GET, produces = ShuttleConstants.PRODUCES_JSON)
    @ResponseBody
    public List<UserBean> getOwnerList() {
        List<UserBean> users = userRepository.findByUserRole(ShuttleConstants.ROLE_OWNER);
        return users;
    }
    
     @RequestMapping(value = ShuttleConstants.ADMIN_GET_CUSTOMERS, method = RequestMethod.GET, produces = ShuttleConstants.PRODUCES_JSON)
    @ResponseBody
    public List<UserBean> getCustomerList() {
        List<UserBean> users = userRepository.findByUserRole(ShuttleConstants.ROLE_CUSTOMER);
        return users;
    }


    @RequestMapping(value = ShuttleConstants.ADMIN_ADD_VEHICLE, method = RequestMethod.POST)
    @ResponseBody
    public String insertVehicle(@RequestBody final String vehicle) {
        try {
            VehicleBean s = new ObjectMapper().readValue(vehicle, VehicleBean.class);
            s.setUserBean(new UserBean(Integer.parseInt(s.getVehicleOwnerId())));
            if (vehicle != null) {
                vehicleRepository.save(s);
                return ShuttleConstants.SUCCESS;
            }
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ShuttleConstants.FAILURE;
    }

    @RequestMapping(value = ShuttleConstants.ADMIN_GET_VEHICLES, method = RequestMethod.GET, produces = ShuttleConstants.PRODUCES_JSON)
    @ResponseBody
    public List<VehicleBean> getVehicleList() {
        return vehicleRepository.findAll();
    }

    @RequestMapping(value = ShuttleConstants.ADMIN_GET_ROUTES, method = RequestMethod.GET, produces = ShuttleConstants.PRODUCES_JSON)
    @ResponseBody
    public List<RouteBean> getRouteList() {
        return routeRepository.findAll();
    }

    @RequestMapping(value = ShuttleConstants.ADMIN_ADD_ROUTE, method = RequestMethod.POST)
    @ResponseBody
    public String insertRoute(HttpServletRequest request,
            HttpServletResponse response,
            MultipartHttpServletRequest nRequest,
            @ModelAttribute("route") RouteBean route) {
        try {
            MultipartFile mFile = nRequest.getFile("file");
            List<RouteStopsBean> listStops
                    = Arrays.asList(new ObjectMapper().readValue(request.getParameter("routeStop1"),
                            RouteStopsBean[].class));
            String fileName = GenerateFileName.createFileName(mFile.getOriginalFilename());
            route.setRouteMapImage(fileName);
            route.setRouteStopsBean(listStops);
            mFile.transferTo(new File(directoryRouteMap + fileName));
            routeRepository.save(route);
            return ShuttleConstants.SUCCESS;
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ShuttleConstants.FAILURE;
    }

    @RequestMapping(value = ShuttleConstants.ADMIN_GET_DRIVERS, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<DriverBean> getDriverList() {
        return driverRepository.findAll();
    }

    @RequestMapping(value = ShuttleConstants.ADMIN_ADD_DRIVER, method = RequestMethod.POST)
    @ResponseBody
    public String insertDriver(HttpServletRequest request,
            HttpServletResponse response,
            MultipartHttpServletRequest nRequest,
            @ModelAttribute("user") UserBean user, DriverBean driver) {
        try {
            user.setUserRole(ShuttleConstants.ROLE_DRIVER);
            UserBean savedUser = userService.insertUser(user);
            if (savedUser != null) {
                MultipartFile idProofM = nRequest.getFile("idProof");
                String idProof = GenerateFileName.createFileName(idProofM.getOriginalFilename());
                idProofM.transferTo(new File(directoryDriverIdProof + idProof));
                driver.setDriverIdProof(idProof);

                MultipartFile licenseM = nRequest.getFile("license");
                String license = GenerateFileName.createFileName(licenseM.getOriginalFilename());
                licenseM.transferTo(new File(directoryDriverLicense + license));
                driver.setDriverLicense(license);

                MultipartFile photoM = nRequest.getFile("photo");
                String photo = GenerateFileName.createFileName(photoM.getOriginalFilename());
                photoM.transferTo(new File(directoryDriverPhoto + photo));
                driver.setDriverPhoto(photo);

                driver.setDriverId(savedUser.getUserId());
                driver.setUserBean(user);
                driverRepository.save(driver);
                return ShuttleConstants.SUCCESS;
            }
            return ShuttleConstants.EMAIL_EXISTS;

        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ShuttleConstants.FAILURE;
    }
}
