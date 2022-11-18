package com.jsg.house.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsg.house.exception.NoDataException;
import com.jsg.house.exception.NotChangeDataException;

@RestControllerAdvice
@CrossOrigin
public class MainExceptionHandler {
	
	HttpFlag flag = new HttpFlag();
	List<Object> data = new ArrayList<>();
	HashMap<String,String> map = new HashMap<>();
	@ExceptionHandler(ParseException.class)
	protected ResponseEntity<?> handleParseException() {
		
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}
	
	@ExceptionHandler(NoDataException.class)
	protected ResponseEntity<?> handleNoDataException() {
		clear();
		map.put("msg", "sql에 데이터가 없습니다.");
		data.add(map);
		flag.setData(data);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(NotChangeDataException.class)
	protected ResponseEntity<?> handleNotChangeDataException() {
		clear();
		map.put("msg", "sql에 데이터가 추가 되지 않았습니다.");
		data.add(map);
		flag.setData(data);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.FORBIDDEN);
	}
	
	private void clear() {
		flag.setFlag("fail");
		map.clear();
		data = new ArrayList<>();
		flag.setData(data);
	}
}
