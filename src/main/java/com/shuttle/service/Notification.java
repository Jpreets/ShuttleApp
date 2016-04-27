package com.shuttle.service;

import com.shuttle.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author baldeep
 */
@Service
public class Notification {

    @Autowired
    Email email;

    public void sendWelcomeMail(UserBean user) {

        String body = "<center><h2>Mindfire Shuttle</h2></center><br><br><h4>Hi " + user.getUserName()
                + "<br><br>WELCOME ! We are excited to have you on board with us.</h4><br><h5>"
                + "Transform the way you travel. No more haggling with auto and still pay less! "
                + "Your convenience is our priority.<br><br><b>Cheers,<br>Team Shuttle</b></h5>";
        try {
            email.sendMail("mindfireprojects@gmail.com", user.getUserEmail(), "Welcome to Shuttle", body);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void sendForgotPasswordEmail(UserBean user,String tempPassword) {

        String body = "<center><h2>Mindfire Shuttle</h2></center><br><br><h4>Hi " + user.getUserName()
                + ",<br><br><h4>"
                + "We received a request to reset your password. If you made a request then click below to change else please ignore this email."
                + "<br><center><a href=\"http://localhost:8080/ShuttleApp/index.html?changePassword?id="+tempPassword+"&email="+user.getUserEmail()+"\">Click Here to Change Password</a></center><br><br>Your convenience is our priority.<br><br><b>Cheers,<br>Team Shuttle</b></h4>";
        try {
            email.sendMail("mindfireprojects@gmail.com", user.getUserEmail(), "Shuttle Forgot Password", body);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
