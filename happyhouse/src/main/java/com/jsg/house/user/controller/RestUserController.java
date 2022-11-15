package com.jsg.house.user.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsg.house.config.HttpFlag;
import com.jsg.house.user.model.dto.User;
import com.jsg.house.user.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api("유저 컨트롤러 API V1")
@RequestMapping("/user")
@RestController
public class RestUserController {

	@Autowired
	private UserService service;

	private HttpFlag flag = new HttpFlag();

	@ApiOperation(value = "유저 리스트를 불러온다.", notes = "유저 전체 리스트를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping
	public ResponseEntity<?> getUserList() {
		try {
			List<Object> users = service.getUserList();
			if (users == null || users.isEmpty()) {
				flag.setFlag("fail");
				flag.setData(null);
			} else {
				flag.setFlag("success");
				flag.setData(users);
			}
			return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ApiOperation(value = "유저를 등록한다.", notes = "유저를 등록한다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping()
	public ResponseEntity<?> registUser(@RequestBody User user) {
		try {
			int checkSum = service.registUser(user);
			flag.setData(null);
			if (checkSum == 0) {
				throw new Exception();
			} else {
				flag.setFlag("success");
			}
		} catch (Exception e) {
			flag.setFlag("fail");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "유저를 수정한다.", notes = "유저를 수정한다. account가 아닌 userId(index)를 넘겨준다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PutMapping("/{userid}")
	public ResponseEntity<?> modifyUser(@PathVariable(name = "userid") String userid,
			@RequestBody HashMap<String, Object> map) {
		try {
			int id = Integer.parseInt(userid);
			for (String key : map.keySet()) {
				System.out.println(key + " : " + map.get(key));
			}
			map.put("id", id);
			int checkSum = service.modifyUser(map);
			flag.setData(null);
			if (checkSum == 0) {
				throw new Exception();
			} else {
				flag.setFlag("success");
			}
		} catch (Exception e) {
			flag.setFlag("fail");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "유저를 삭제한다.", notes = "유저를 삭제한다. account가 아닌 userId(index)를 넘겨준다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@DeleteMapping("/{userid}")
	public ResponseEntity<?> deleteUser(@PathVariable(name = "userid") String userid) {
		try {
			int id = Integer.parseInt(userid);
			int checkSum = service.deleteUser(id);
			flag.setData(null);
			if (checkSum == 0) {
				throw new Exception();
			} else {
				flag.setFlag("success");
			}
		} catch (Exception e) {
			flag.setFlag("fail");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "account 중복 체크를 한다.", notes = "중복 되는 account가 없으면 'success', 있으면 'fail' 문자열을 반환한다.", response = String.class)
	@GetMapping("/idcheck/{account}")
	public ResponseEntity<?> idCheck(@PathVariable(name = "account") String account) {
		flag.setFlag("fail");
		flag.setData(null);
		try {
			int checkSum = service.idCheck(account);
			if (checkSum == 0) {
				flag.setFlag("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "로그인을 한다.", notes = "로그인에 성공하면 'success', 실패하면 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@ApiIgnore HttpSession session,@RequestBody HashMap<String, String> map) {
		flag.setFlag("fail");
		flag.setData(null);
		try {
			User user = service.loginUser(map);
			if (user != null) {
				flag.setFlag("success");
				session.setAttribute("user", user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "로그아웃을 한다.", notes = "무조건 'success' 반환", response = String.class)
	@GetMapping("/logout")
	public ResponseEntity<?> logoutUser(@ApiIgnore HttpSession session) {
		flag.setData(null);
		flag.setFlag("success");
		session.invalidate();
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}
	
}
