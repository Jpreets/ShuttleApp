
package com.shuttle.service;

import com.shuttle.bean.UserBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author baldeep
 */
public class Notification {
    
    public static void sendWelcomeMail(UserBean user)
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("EmailConfig.xml");
    	Email email = (Email) context.getBean("mail");
        String body="<center><h2>Mindfire Shuttle</h2></center><br><br><h4>Hi "+user.getUserName()+
                "<br><br>WELCOME ! We are excited to have you on board with us.</h4><br><br><h5>"
                + "Transform the way you travel. No more haggling with auto and still pay less! "
                + "Your convenience is our priority.<br><br><b>Cheers,<br>Team Shuttle</b></h5>";
	email.sendMail("mindfireprojects@gmail.com",user.getUserEmail(),"Welcome to Shuttle",body);
        
    }
}
