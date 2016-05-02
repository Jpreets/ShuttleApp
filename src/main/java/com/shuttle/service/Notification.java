/**
 * Created Date: 28 April 2016
 * Last Modified Date: 28 April 2016
 */
package com.shuttle.service;

import com.shuttle.bean.UserBean;
import com.shuttle.constants.ShuttleConstants;
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

        try {
            email.sendMail(ShuttleConstants.SHUTTLE_EMAIL, user.getUserEmail(),
                    ShuttleConstants.WELCOME_MAIL_SUBJECT,
                    ShuttleConstants.WELCOME_MAIL_BODY.replaceAll("<<username>>", user.getUserName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendForgotPasswordEmail(UserBean user, String tempPassword) {

        try {
            email.sendMail(ShuttleConstants.SHUTTLE_EMAIL, user.getUserEmail(),
                    ShuttleConstants.FORGOT_PASSWORD_MAIL_SUBJECT,
                    ShuttleConstants.FORGOT_PASSWORD_MAIL_BODY.
                    replaceAll(ShuttleConstants.TAG_USER_NAME, user.getUserName()).
                    replaceAll(ShuttleConstants.TAG_TEMP_PASSWORD, tempPassword).
                    replaceAll(ShuttleConstants.TAG_USER_EMAIL, user.getUserEmail()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
