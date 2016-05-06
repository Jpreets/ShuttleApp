/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shuttle.service;

import com.shuttle.bean.UserBean;
import com.shuttle.constants.ShuttleConstants;
import com.shuttle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AmitPandey
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private Notification notification;

    public boolean insertUser(UserBean user) {
        
        user.setUserEmail(user.getUserEmail().toLowerCase());
        
        if (userRepository.findByUserEmail(user.getUserEmail()) == null) {

            user.setUserName(user.getUserName().toUpperCase());
            user.setUserPassword(BCrypt.hashpw(user.getUserPassword(),
                    ShuttleConstants.SALT));//hash user password before storing

            UserBean lastUser = userRepository.findTopByOrderByUserIdDesc();
            if (lastUser != null) {
                user.setUserId((lastUser.getUserId()) + 1);
            } else {
                user.setUserId(1);
            }
            if (userRepository.save(user) != null) {

                notification.sendWelcomeMail(user);//trigger welcome mail
                return true;
            }
        }
        return false;
    }
}
