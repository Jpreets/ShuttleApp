/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shuttle.conf;

import org.springframework.stereotype.Component;
import com.shuttle.repository.RoleRepository;
import java.util.ArrayList;
import com.shuttle.bean.RoleBean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

/**
 *
 * @author AmitPandey
 */
@Component
public class CreateTable {

    @Autowired
    private RoleRepository roleRespository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent started) {

        List<RoleBean> roleBean = new ArrayList<RoleBean>();
        roleBean.add(new RoleBean("1", "ROLE_ADMIN"));
        roleBean.add(new RoleBean("2", "ROLE_CUSTOMER"));

        //Insert List to MondoDb
        roleRespository.save(roleBean);
    }

}
