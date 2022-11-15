package com.jsg.house.interest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsg.house.config.HttpFlag;
import com.jsg.house.interest.model.dto.Interest;
import com.jsg.house.interest.model.service.InterestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("관심지역 컨트롤러 API V1")
@RequestMapping("/interest")
@RestController
public class RestInterestController {
	
	@Autowired
	private InterestService service;
	
	private HttpFlag flag = new HttpFlag();
	
	
	@ApiOperation(value = "관심지역 리스트를 불러온다.", notes = "userid를 넣어주면 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/{userid}")
	public ResponseEntity<?> getIntersts(@PathVariable int userid) {
		flag.setFlag("fail");
		flag.setData(null);
		try {
			List<Object> list = service.getIntersts(userid);
			if(list.size() != 0) {
				flag.setFlag("success");
				flag.setData(list);	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addIntersts(@RequestBody Interest interest) {
		flag.setFlag("fail");
		flag.setData(null);
		try {
			int checkSum = service.addIntersts(interest);
			if(checkSum != 0) {
				flag.setFlag("success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<?> deleteIntersts(@PathVariable int id) {
		flag.setFlag("fail");
		flag.setData(null);
		try {
			int checkSum = service.deleteIntersts(id);
			if(checkSum != 0) {
				flag.setFlag("success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}
}
