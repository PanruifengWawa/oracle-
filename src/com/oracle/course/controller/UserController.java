package com.oracle.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.course.datawrapper.DataWrapper;
import com.oracle.course.models.User;
import com.oracle.course.service.UserService;


@Controller
@RequestMapping(value="api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<String> login(
    		@RequestParam(value = "userName", required = true) String userName,
    		@RequestParam(value = "password", required = true) String password) {
        return userService.login(userName, password);
    }
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> register(
    		@RequestParam(value = "userName", required = true) String userName,
    		@RequestParam(value = "password", required = true) String password,
    		@RequestParam(value = "email", required = true) String email) {
        return userService.register(userName, password,email);
    }
	
	@RequestMapping(value="/details", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<User> details(
    		@RequestParam(value = "token", required = true) String token) {
        return userService.getUserDetails(token);
    }
	
	@RequestMapping(value="/details", method = RequestMethod.PUT)
    @ResponseBody
    public DataWrapper<Void> update(
    		@RequestParam(value = "birthday", required = true) String birthday,
    		@RequestParam(value = "email", required = true) String email,
    		@RequestParam(value = "token", required = true) String token) {
        return userService.updateUser(birthday, email, token);
    }

}
