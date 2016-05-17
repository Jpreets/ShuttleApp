/**
 * Created Date: 28 April 2016
 * Last Modified Date: 28 April 2016
 */
package com.shuttle.service;

import com.shuttle.bean.UserBean;
import com.shuttle.constants.ShuttleConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 *
 * @author baldeep
 */
@PropertySource("classpath:ShuttleConfig.properties")
@Service
public class Notification {

    @Value("${shuttle.domain}")
    private String domain;

    @Autowired
    Email email;

    public void sendWelcomeMail(UserBean user) {

        try {
            email.sendMail(user.getUserEmail(),
                    ShuttleConstants.WELCOME_MAIL_SUBJECT,
                    ShuttleConstants.WELCOME_MAIL_BODY.replaceAll(ShuttleConstants.TAG_USER_NAME, user.getUserName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendForgotPasswordEmail(UserBean user, String tempPassword) {

        try {
            email.sendMail(user.getUserEmail(),
                    ShuttleConstants.FORGOT_PASSWORD_MAIL_SUBJECT,
                    ShuttleConstants.FORGOT_PASSWORD_MAIL_BODY.
                    replaceAll(ShuttleConstants.TAG_DOMAIN, domain).
                    replaceAll(ShuttleConstants.TAG_USER_NAME, user.getUserName()).
                    replaceAll(ShuttleConstants.TAG_TEMP_PASSWORD, tempPassword).
                    replaceAll(ShuttleConstants.TAG_USER_EMAIL, user.getUserEmail()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
