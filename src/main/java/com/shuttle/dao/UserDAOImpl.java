package com.shuttle.dao;

import com.shuttle.bean.UserBean;
import com.shuttle.constants.ControllerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private MongoOperations mongoOperation;

    @Override
    public void save(UserBean user) {

        user.setUserPassword(BCrypt.hashpw(user.getUserPassword(), 
                ControllerConstants.SALT));
        
        this.mongoOperation.save(user);
    }
}
