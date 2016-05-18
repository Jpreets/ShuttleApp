package com.shuttle.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author baldeep
 */
@Document(collection = "driver")
public class DriverBean {
    @Id
    private int driverId;
    private String driverPhoto;
    private String driverLicense;
    private String driverIdProof;
    @DBRef
    private UserBean userBean;

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }


    public String getDriverPhoto() {
        return driverPhoto;
    }

    public void setDriverPhoto(String driverPhoto) {
        this.driverPhoto = driverPhoto;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getDriverIdProof() {
        return driverIdProof;
    }

    public void setDriverIdProof(String driverIdProof) {
        this.driverIdProof = driverIdProof;
    }

    
    @Override
    public String toString() {
        return "DriverBean{" + "driverId=" + driverId + ", driverPhoto=" + driverPhoto + ", driverLicense=" + driverLicense + ", driverIdProof=" + driverIdProof + '}';
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
    
    
}
