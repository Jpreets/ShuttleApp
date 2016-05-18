/**
 * Created Date: 28 April 2016
 * Last Modified Date: 28 April 2016
 */
package com.shuttle.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicle")
public class VehicleBean {

    @Id
    private String vehicleId;
    private String vehicleName;
    private String vehicleType;
    private String vehicleFuelType;
    private String vehicleRegNo;
    private String vehicleColor;
    private String vehicleSeats;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
    private Date vehiclePermitEndTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
    private Date vehicleInsuranceExpiry;
    private String vehicleCreatedTime;
    private String vehicleLastUpdateTime;
    @Transient
    private String vehicleOwnerId;
    @DBRef
    private UserBean userBean;

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    public void setVehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }

    public Date getVehiclePermitEndTime() {
        return vehiclePermitEndTime;
    }

    public void setVehiclePermitEndTime(Date vehiclePermitEndTime) {
        this.vehiclePermitEndTime = vehiclePermitEndTime;
    }

    public String getVehicleCreatedTime() {
        return vehicleCreatedTime;
    }

    public void setVehicleCreatedTime(String vehicleCreatedTime) {
        this.vehicleCreatedTime = vehicleCreatedTime;
    }

    public String getVehicleLastUpdateTime() {
        return vehicleLastUpdateTime;
    }

    public void setVehicleLastUpdateTime(String vehicleLastUpdateTime) {
        this.vehicleLastUpdateTime = vehicleLastUpdateTime;
    }

    public String getVehicleFuelType() {
        return vehicleFuelType;
    }

    public void setVehicleFuelType(String vehicleFuelType) {
        this.vehicleFuelType = vehicleFuelType;
    }

    public Date getVehicleInsuranceExpiry() {
        return vehicleInsuranceExpiry;
    }

    public void setVehicleInsuranceExpiry(Date vehicleInsuranceExpiry) {
        this.vehicleInsuranceExpiry = vehicleInsuranceExpiry;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleSeats() {
        return vehicleSeats;
    }

    public void setVehicleSeats(String vehicleSeats) {
        this.vehicleSeats = vehicleSeats;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public String getVehicleOwnerId() {
        return vehicleOwnerId;
    }

    public void setVehicleOwnerId(String vehicleOwnerId) {
        this.vehicleOwnerId = vehicleOwnerId;
    }

    @Override
    public String toString() {
        return "VehicleBean{" + "vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", vehicleType=" + vehicleType + ", vehicleFuelType=" + vehicleFuelType + ", vehicleRegNo=" + vehicleRegNo + ", vehicleColor=" + vehicleColor + ", vehicleSeats=" + vehicleSeats + ", vehiclePermitEndTime=" + vehiclePermitEndTime + ", vehicleInsuranceExpiry=" + vehicleInsuranceExpiry + ", vehicleCreatedTime=" + vehicleCreatedTime + ", vehicleLastUpdateTime=" + vehicleLastUpdateTime + ", vehicleOwnerId=" + vehicleOwnerId + ", userBean=" + userBean + '}';
    }

}
