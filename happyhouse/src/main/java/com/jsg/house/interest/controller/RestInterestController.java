package com.jsg.house.interest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class RestInterestController {

	@Autowired
	private InterestService service;

	private HttpFlag flag = new HttpFlag();

	@ApiOperation(value = "관심지역 리스트를 불러온다.", notes = "userid를 넣어주면 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/{userid}")
	public ResponseEntity<?> getIntersts(@PathVariable int userid) {
		List<Object> list = service.getInterests(userid);
		flag.setFlag("success");
		flag.setData(list);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "관심지역 리스트를 추가한다.", notes = "@PostMapping, 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<?> addIntersts(@RequestBody Interest interest) {
		service.addInterests(interest);
		flag.setFlag("success");
		flag.setData(null);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "관심 지역을 삭제한다.", notes = "deleteMapping, 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@DeleteMapping()
	public ResponseEntity<?> deleteIntersts(@RequestBody Interest interest) {
		service.deleteInterests(interest);
		flag.setFlag("success");
		flag.setData(null);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "관심지역 지역별 랭킹 상위 5개를 불러온다.", notes = "시도 코드를 넣어주면 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/ranking/{code}")
	public ResponseEntity<?> getRankingIntersts(@PathVariable("code") int sidoCode) {
		List<Object> list = service.getRankingIntersts(sidoCode);
		flag.setFlag("success");
		flag.setData(list);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}
}
