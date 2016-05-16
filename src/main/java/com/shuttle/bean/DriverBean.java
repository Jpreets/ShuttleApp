package com.shuttle.bean;

/**
 *
 * @author baldeep
 */
public class DriverBean {
    
    private int driverId;
    private String driverPhoto;
    private String driverLicense;
    private String driverIdProof;

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
    
    
}
