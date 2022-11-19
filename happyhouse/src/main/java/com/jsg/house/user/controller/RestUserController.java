package com.jsg.house.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsg.house.config.HttpFlag;
import com.jsg.house.exception.NoDataException;
import com.jsg.house.user.model.dto.User;
import com.jsg.house.user.model.service.JwtService;
import com.jsg.house.user.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("유저 컨트롤러 API V1")
@RequestMapping("/user")
@RestController
@CrossOrigin
public class RestUserController {

	@Autowired
	private UserService service;

	@Autowired
	private JwtService jwtService;

	private HttpFlag flag = new HttpFlag();

	private static final Logger loggger = LoggerFactory.getLogger(RestUserController.class);

	@ApiOperation(value = "유저 리스트를 불러온다.", notes = "유저 전체 리스트를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping
	public ResponseEntity<?> getUserList() {
		loggger.info("send : getUserList");
		List<Object> users = service.getUserList();
		flag.setFlag("success");
		flag.setData(users);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "유저를 등록한다.", notes = "유저를 등록한다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping()
	public ResponseEntity<?> registUser(@RequestBody User user)  {
		loggger.info("send : registUser {} ", user);
		service.registUser(user);
		flag.setFlag("success");
		flag.setData(null);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	//@PathVariable(name = "userid")
	@ApiOperation(value = "유저를 수정한다.", notes = "유저를 수정한다. account가 아닌 userId(index)를 넘겨준다.\n { nickName : String, password : String, location : String }\n  'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PutMapping("/{userid}")
	public ResponseEntity<?> modifyUser(@PathVariable int userid, @RequestBody HashMap<String, Object> map) {
		loggger.info("send : modifyUser {} ", userid);
		map.put("id", userid);
		service.modifyUser(map);
		flag.setData(null);
		flag.setFlag("success");
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}
	
	@ApiOperation(value = "(개발자용) 유저를 완전히 삭제한다.", notes = "유저를 삭제한다. account가 아닌 userId(index)를 넘겨준다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/force/{userid}")
	public ResponseEntity<?> deleteForceUser(@PathVariable int userid) {
		loggger.info("send : deleteUser {} ", userid);
		service.deleteForceUser(userid);
		flag.setFlag("success");
		flag.setData(null);

		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}
	
	@ApiOperation(value = "(개발자용) 유저를 운영자로 지정한다.", notes = "account가 아닌 userId(index)를 넘겨준다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/force/{id}")
	public ResponseEntity<?> addAdmin(@PathVariable int id) {
		loggger.info("send : addAdmin {} ", id);
		service.addAdmin(id);
		flag.setFlag("success");
		flag.setData(null);

		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}
	
	@ApiOperation(value = "유저를 삭제한다.", notes = "유저를 삭제한다. account가 아닌 userId(index)를 넘겨준다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@DeleteMapping("/{userid}")
	public ResponseEntity<?> deleteUser(@PathVariable int userid) {
		loggger.info("send : deleteUser {} ", userid);
		service.deleteUser(userid);
		flag.setFlag("success");
		flag.setData(null);

		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "닉네임 중복 체크를 한다.", notes = "중복 되는 account가 없으면 'success', 있으면 'fail' 문자열을 반환한다.", response = String.class)
	@GetMapping("/checknick/{nickName}")
	public ResponseEntity<?> checkNick(@PathVariable String nickName) {
		loggger.info("send : idCheck {} ", nickName);
		flag.setFlag("fail");
		flag.setData(null);
		int checkSum = service.checkNick(nickName);
		if (checkSum == 0) {
			flag.setFlag("success");
		}
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "로그인을 한다.", notes = "로그인에 성공하면 'success', 실패하면 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody HashMap<String, String> map) {
		List<Object> data = new ArrayList<Object>();
		int userId = service.loginUser(map);
		String token = jwtService.createToken(userId);
		flag.setFlag("success");
		map.clear();
		map.put("access-token", token);
		data.add(map);
		flag.setData(data);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "유저 상세 정보를 찾는다.", notes = "{id : int}만 전달한다. \n 성공하면 'success', 실패하면 'fail' 문자열을 반환한다.", response = String.class)
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> detailUser(@PathVariable int id) {
		List<Object> data = new ArrayList<Object>();
		flag.setFlag("success");
		User user = service.detailUser(id);
		data.add(user);
		flag.setData(data);
		
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@PostMapping("/jwt")
	public ResponseEntity<?> jwt(@RequestBody HashMap<String, String> map) {
		flag.setFlag("fail");
		flag.setData(null);
		boolean check = jwtService.checkToken(map.get("access-token"));
		if (check) {
			flag.setFlag("success");
		}
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}
	// checkToken
}
