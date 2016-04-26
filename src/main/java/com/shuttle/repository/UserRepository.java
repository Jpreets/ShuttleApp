package com.shuttle.repository;

import com.shuttle.bean.UserBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserBean,String>{

     UserBean findByUserEmail(String userEmail);
}
