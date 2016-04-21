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
}
