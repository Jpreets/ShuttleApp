package com.shuttle.service;

import com.shuttle.bean.UserBean;
import com.shuttle.constants.ShuttleConstants;
import com.shuttle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

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

    public UserBean insertUser(UserBean user) { //Changing return type to UserBean instead of Boolean as Id is needed in Driver Addition
        
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
            UserBean savedUser=userRepository.save(user);
            if (savedUser != null) {

                notification.sendWelcomeMail(user);//trigger welcome mail
                return savedUser;
            }
        }
        return null;
    }
}
