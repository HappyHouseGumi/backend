package com.jsg.house.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsg.house.user.model.dto.User;
import com.jsg.house.user.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("유저 컨트롤러 API V1")
@RequestMapping("/user")
@RestController
public class RestUserController {
	
	@Autowired
	private UserService service;
	
	@ApiOperation(value = "게시판 글작성", notes = "새로운 게시글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@GetMapping("/list")
	public ResponseEntity<?> test() {
		try {
			List<User> users = service.list();
			if(users == null || users.isEmpty()) {
				return new ResponseEntity<String>("Test",HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
