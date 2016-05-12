/**
 * Created Date: 20 April 2016
 * Last Modified Date: 2 May 2016
 */
package com.shuttle.constants;

public interface ShuttleConstants {

    /*URL CONSTANTS*/
    public static final String USER_REGISTRATION = "/registration";
    public static final String USER_FORGOT_PASSWORD = "/forgotPassword";
    public static final String USER_CHANGE_PASSWORD = "/ChangePasswordSubmit";
    public static final String ADMIN_ADD_OWNER = "/addOwner";
    public static final String ADMIN_ADD_VEHICLE = "/addVehicle";
    public static final String ADMIN_ADD_ROUTE = "/addRoute";
    public static final String ADMIN_GET_OWNERS = "/admin/getOwnerList";
    public static final String ADMIN_GET_VEHICLES = "/admin/getVehicleList";
    public static final String ADMIN_GET_ROUTES = "/admin/getRouteList";

    
    public static final String DOMAIN="http://localhost:8080/ShuttleApp/";
    public static final String SUCCESS="success";
    public static final String FAILURE="failure";
    /*MAIL CONSTANTS*/
    public static final String WELCOME_MAIL_BODY = "<center><h2>Mindfire Shuttle</h2></center><br><br><h4>Hi  <<userName>>"
            + "<br><br>WELCOME ! We are excited to have you on board with us.</h4><br><h5>"
            + "Transform the way you travel. No more haggling with auto and still pay less! "
            + "Your convenience is our priority.<br><br><b>Cheers,<br>Team Shuttle</b></h5>";
    public static final String WELCOME_MAIL_SUBJECT = "Welcome to Shuttle";

    public static final String FORGOT_PASSWORD_MAIL_BODY = "<center><h2>Mindfire Shuttle</h2></center><br><br><h4>Hi <<userName>>"
            + ",<br><br><h4>"
            + "We received a request to reset your password. If you made a request then click below to change else please ignore this email."
            + "<br><center><a href=\"<<Domain>>index.html?changePassword?id=<<tempPassword>>&email=<<userEmail>>\">"
            + "Click Here to Change Password</a></center><br><br>Your convenience is our priority.<br><br><b>Cheers,<br>Team Shuttle</b></h4>";
    public static final String FORGOT_PASSWORD_MAIL_SUBJECT = "Shuttle Forgot Password";

    /*TAGS USED IN THE SHUTTLE APP*/
    public static final String TAG_USER_NAME = "<<userName>>";
    public static final String TAG_TEMP_PASSWORD = "<<tempPassword>>";
    public static final String TAG_USER_EMAIL = "<<userEmail>>";
    public static final String TAG_DOMAIN="<<Domain>>";

    /*EMAIL*/
    public static final String SHUTTLE_EMAIL = "mindfireprojects@gmail.com";

    /*HASHING CONSTANTS*/
    public static final String SALT = "$2a$12$nqfG9jIkLm8th3OpoxX8a.";
    
    /*FOLDER CONSTANTS*/
    public static final String DIRECTORY_ROUTE_MAP="/home/baldeep/Pictures/Route Map/";
}
