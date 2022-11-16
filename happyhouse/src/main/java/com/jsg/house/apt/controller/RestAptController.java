package com.jsg.house.apt.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsg.house.apt.model.service.AptInfoService;
import com.jsg.house.apt.model.service.DongCodeService;
import com.jsg.house.config.HttpFlag;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("아파트 컨트롤러 API V1")
@RequestMapping("/apt")
@RestController
public class RestAptController {
	
	@Autowired
	private DongCodeService dongService;
	
	@Autowired
	private AptInfoService infoService;
	
	private HttpFlag flag = new HttpFlag();
	
	@ApiOperation(value = "시도, 구군, 동 정보를 불러온다.", notes = "gubun : sido,gugun,dong 중 하나 입력 \n code : string(전체코드 적기 ex 1111010100)\n 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/{gubun}/{code}")
	public ResponseEntity<?> searchCode(@PathVariable(name = "gubun") String gubun, @PathVariable(name = "code") String code) {
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("gubun", gubun);
		map.put("code", code);
		if(map.get("gubun").equals("sido")) {
			try {
				List<Object> dongcode = dongService.getSido();
				flag.setFlag("success");
				flag.setData(dongcode);
				return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(map.get("gubun").equals("gugun")) {
			try {
				List<Object> dongcode = dongService.getGugun(map.get("code"));
				flag.setFlag("success");
				flag.setData(dongcode);
				return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(map.get("gubun").equals("dong")) {
			try {
				List<Object> dongcode = dongService.getDong(map.get("code"));
				flag.setFlag("success");
				flag.setData(dongcode);
				return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ApiOperation(value = "아파트 정보를 불러온다.", notes = "code : string(전체코드 적기 ex 1111010100)\n 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/list/{code}")
	public ResponseEntity<?> getAptList(@PathVariable(name = "code") String code) {
		flag.setFlag("fail");
		flag.setData(null);
		try {
			List<Object> aptlist = infoService.getAptList(code);
			flag.setFlag("success");
			flag.setData(aptlist);
			return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}