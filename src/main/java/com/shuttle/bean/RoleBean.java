/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shuttle.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "role")
public class RoleBean {

    @Id
    private String roleId;
    private String roleName;

     public RoleBean(String roleId, String roleName){
        this.roleId = roleId;
        this.roleName = roleName;
    }
     
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
