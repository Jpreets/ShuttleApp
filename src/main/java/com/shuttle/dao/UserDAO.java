package com.shuttle.dao;

import com.shuttle.bean.UserBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends MongoRepository<UserBean,String>{

    

}
