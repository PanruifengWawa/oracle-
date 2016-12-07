package com.oracle.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.course.datawrapper.DataWrapper;


@Controller
@RequestMapping(value="api/user")
public class UserController {
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<String> getByCode(
    		@RequestParam(value = "userName", required = true) String userName,
    		@RequestParam(value = "password", required = true) String password) {
		DataWrapper<String> dataWrapper = new DataWrapper<>();
        return dataWrapper;
    }

}
