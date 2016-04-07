package com.shuttle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shuttle.bean.UserBean;
import com.shuttle.service.UserService;

@Controller
public class IndexController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/saveUser",
			method = RequestMethod.POST)
	 @ResponseBody
	public UserBean index(@RequestBody UserBean user) {

		this.userService.save(user);

		return user;
	}

}
