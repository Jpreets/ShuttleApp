package com.shuttle.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.shuttle.bean.UserBean;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private MongoOperations mongoOperation;
	
	@Override
	public void save(UserBean user) {
		this.mongoOperation.save(user);
		
	}

}
