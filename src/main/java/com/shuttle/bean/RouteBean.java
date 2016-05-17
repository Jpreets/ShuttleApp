/**
 * Created Date: 28 April 2016
 * Last Modified Date: 28 April 2016
 */
package com.shuttle.bean;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author baldeep
 */
@Document(collection = "route")
public class RouteBean {

    @Id
    private String routeId;
    private String routeCity;
    private String routeState;
    private String routeCountry;
    private String routeZone;
    private String routeStartLocation;
    private String routeEndLocation;
    private String routeMapImage;
    private String routeTotalDistance;
    private String routeTotalPrice;
    private List<RouteStopsBean> routeStopsBean;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getRouteCity() {
        return routeCity;
    }

    public void setRouteCity(String routeCity) {
        this.routeCity = routeCity;
    }

    public String getRouteState() {
        return routeState;
    }

    public void setRouteState(String routeState) {
        this.routeState = routeState;
    }

    public String getRouteCountry() {
        return routeCountry;
    }

    public void setRouteCountry(String routeCountry) {
        this.routeCountry = routeCountry;
    }

    public String getRouteZone() {
        return routeZone;
    }

    public void setRouteZone(String routeZone) {
        this.routeZone = routeZone;
    }

    public String getRouteStartLocation() {
        return routeStartLocation;
    }

    public void setRouteStartLocation(String routeStartLocation) {
        this.routeStartLocation = routeStartLocation;
    }

    public String getRouteEndLocation() {
        return routeEndLocation;
    }

    public void setRouteEndLocation(String routeEndLocation) {
        this.routeEndLocation = routeEndLocation;
    }

    public String getRouteMapImage() {
        return routeMapImage;
    }

    public void setRouteMapImage(String routeMapImage) {
        this.routeMapImage = routeMapImage;
    }

    public String getRouteTotalDistance() {
        return routeTotalDistance;
    }

    public void setRouteTotalDistance(String routeTotalDistance) {
        this.routeTotalDistance = routeTotalDistance;
    }
    
    public List<RouteStopsBean> getRouteStopsBean() {
        return routeStopsBean;
    }

    public void setRouteStopsBean(List<RouteStopsBean> routeStopsBean) {
        this.routeStopsBean = routeStopsBean;
    }

    public String getRouteTotalPrice() {
        return routeTotalPrice;
    }

    public void setRouteTotalPrice(String routeTotalPrice) {
        this.routeTotalPrice = routeTotalPrice;
    }

    @Override
    public String toString() {
        return "RouteBean{" + "routeId=" + routeId + ", routeCity=" + routeCity + ", routeState=" + routeState + ", routeCountry=" + routeCountry + ", routeZone=" + routeZone + ", routeStartLocation=" + routeStartLocation + ", routeEndLocation=" + routeEndLocation + ", routeMapImage=" + routeMapImage + ", routeTotalDistance=" + routeTotalDistance + ", routeTotalPrice=" + routeTotalPrice + ", routeStopsBean=" + routeStopsBean + '}';
    }
    

    
}
