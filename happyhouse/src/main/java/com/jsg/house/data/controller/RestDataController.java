package com.jsg.house.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsg.house.config.HttpFlag;
import com.jsg.house.data.model.service.DataService;

import io.swagger.annotations.Api;

@Api
@RequestMapping("/data")
@CrossOrigin
@RestController
public class RestDataController {
	
	@Autowired
	private DataService service;
	
	private HttpFlag flag = new HttpFlag();
	
	@GetMapping("/news")
	public ResponseEntity<?> getNews() {
		List<Object> news = service.getNews();
		flag.setFlag("fail");
		flag.setData(null);
		if(news.size() != 0) {
			flag.setFlag("success");
			flag.setData(news);
		}
		return new ResponseEntity<HttpFlag> (flag,HttpStatus.OK);
	}
}
