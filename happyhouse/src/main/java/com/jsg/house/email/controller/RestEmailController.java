package com.jsg.house.email.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsg.house.config.HttpFlag;
import com.jsg.house.email.model.service.EmailService;
import com.jsg.house.user.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Email")
@RequestMapping("/email")
@CrossOrigin
@RestController
public class RestEmailController {
	
	private HttpFlag flag = new HttpFlag();
	
	@Autowired
	private EmailService service;
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "EMAIL 리스트를 불러온다.", notes = "EMAIL인증 서버를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<?> authEmail(@RequestBody HashMap<String,String> map) {
		
		List<Object> nono = new ArrayList<>();
		int checkSum = userService.findUserByEmail(map.get("email"));
		if(checkSum == 0) {
			String code = service.sendCode(map.get("email"));
			flag.setFlag("success");
			map.clear();
			map.put("code", code);
			nono.add(map);
			flag.setData(nono);
		} else {
			flag.setFlag("fail");
			flag.setData(null);
		}
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

}
