package com.jsg.house.data.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsg.house.board.controller.RestBoardController;
import com.jsg.house.config.HttpFlag;
import com.jsg.house.data.model.service.DataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("기타 정보 컨트롤러 API V1") // http://localhost/happy/swagger-ui/index.html
@RequestMapping("/data")
@CrossOrigin
@RestController
public class RestDataController {

	private static final Logger log = LoggerFactory.getLogger(RestBoardController.class);

	private HttpFlag flag = new HttpFlag();

	@Autowired
	private DataService service;

	@ApiOperation(value = "부동산 관련 뉴스를 불러온다.", notes = "부동산 관련 최신 뉴스 10개를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/news")
	public ResponseEntity<?> getNews() {
		List<Object> news = service.getNews();
		flag.setFlag("fail");
		flag.setData(null);
		if (news.size() != 0) {
			flag.setFlag("success");
			flag.setData(news);
		}
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "지역별 평균 매매가를 계산하여 불러온다.", notes = "지역별 평균 매매가를 연도별로 계산하여불러온다. 시도 이름을 보내면 2015~2022년의 연도별 매매가 반환 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping("/avgDeal")
	public ResponseEntity<?> getAvgDeal(@RequestBody String sidoName) {
		List<Object> avgList = service.getAvgDeal(sidoName);
		flag.setFlag("success");
		flag.setData(avgList);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}
}
