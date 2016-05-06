/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shuttle.listeners;

import org.springframework.stereotype.Component;
import com.shuttle.repository.RoleRepository;
import java.util.ArrayList;
import com.shuttle.bean.RoleBean;
import com.shuttle.bean.VehicleTypeBean;
import com.shuttle.repository.VehicleTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

/**
 *
 * @author AmitPandey
 */
@Component
public class ContextRefreshListener {

    @Autowired
    private RoleRepository roleRespository;
    
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent started) {

        List<RoleBean> roleBean = new ArrayList<>();
        roleBean.add(new RoleBean("1", "ROLE_ADMIN"));
        roleBean.add(new RoleBean("2", "ROLE_CUSTOMER"));
        roleRespository.save(roleBean);
        
        List<VehicleTypeBean> vehicleTypeBean = new ArrayList<>();
        vehicleTypeBean.add(new VehicleTypeBean("1","BUS"));
        vehicleTypeBean.add(new VehicleTypeBean("2", "MINI BUS"));
        vehicleTypeBean.add(new VehicleTypeBean("3", "MPV"));
        vehicleTypeBean.add(new VehicleTypeBean("4", "LUV"));
        vehicleTypeRepository.save(vehicleTypeBean);
    }

}
