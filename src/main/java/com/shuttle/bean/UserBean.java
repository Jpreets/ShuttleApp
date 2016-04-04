package com.shuttle.bean;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class UserBean {
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
}
