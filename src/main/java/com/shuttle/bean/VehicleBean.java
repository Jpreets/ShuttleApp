/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shuttle.bean;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicle")
public class VehicleBean {

    private String vehicleId;
    private String vehiceName;
    private String vehiceType;
    private String vehiceRegNo;
    private Date vehiclePermitEndTime;
    private Date vehicleCreatedTime;
    private Date vehicleLastUpdateTime;
    private String vehicleOwnerId;

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehiceName() {
        return vehiceName;
    }

    public void setVehiceName(String vehiceName) {
        this.vehiceName = vehiceName;
    }

    public String getVehiceType() {
        return vehiceType;
    }

    public void setVehiceType(String vehiceType) {
        this.vehiceType = vehiceType;
    }

    public String getVehiceRegNo() {
        return vehiceRegNo;
    }

    public void setVehiceRegNo(String vehiceRegNo) {
        this.vehiceRegNo = vehiceRegNo;
    }

    public Date getVehiclePermitEndTime() {
        return vehiclePermitEndTime;
    }

    public void setVehiclePermitEndTime(Date vehiclePermitEndTime) {
        this.vehiclePermitEndTime = vehiclePermitEndTime;
    }

    public Date getVehicleCreatedTime() {
        return vehicleCreatedTime;
    }

    public void setVehicleCreatedTime(Date vehicleCreatedTime) {
        this.vehicleCreatedTime = vehicleCreatedTime;
    }

    public Date getVehicleLastUpdateTime() {
        return vehicleLastUpdateTime;
    }

    public void setVehicleLastUpdateTime(Date vehicleLastUpdateTime) {
        this.vehicleLastUpdateTime = vehicleLastUpdateTime;
    }

    public String getVehicleOwnerId() {
        return vehicleOwnerId;
    }

    public void setVehicleOwnerId(String vehicleOwnerId) {
        this.vehicleOwnerId = vehicleOwnerId;
    }

}
