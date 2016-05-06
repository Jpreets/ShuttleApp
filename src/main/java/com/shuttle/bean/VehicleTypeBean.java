/**
 * Created Date: 06 May 2016
 * Last Modified Date: 06 May 2016
 */
package com.shuttle.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author baldeep
 */
@Document(collection = "vehicleType")
public class VehicleTypeBean {
    @Id
    private String vehicleTypeID;
    private String vehicleType;

    public String getVehicleTypeID() {
        return vehicleTypeID;
    }

    public void setVehicleTypeID(String vehicleTypeID) {
        this.vehicleTypeID = vehicleTypeID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleTypeBean(String vehicleTypeID, String vehicleType) {
        this.vehicleTypeID = vehicleTypeID;
        this.vehicleType = vehicleType;
    }
    
    
}
