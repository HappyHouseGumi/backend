package com.jsg.house.qna.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.jsg.house.qna.model.dto.QnA;
import com.jsg.house.qna.model.service.QnAService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("QnA(게시판) 컨트롤러 API V1") // http://localhost/happy/swagger-ui/index.html
@RestController
@RequestMapping("/qna")
public class RestQnAController {

	private static final Logger log = LoggerFactory.getLogger(RestQnAController.class);

	private HttpFlag flag = new HttpFlag();
	
	@Autowired
	private QnAService service;


	@ApiOperation(value = "QnA 리스트를 불러온다.", notes = "QnA 전체 리스트를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping()
	public ResponseEntity<?> listBoard() {
		log.debug("QnA List : ");
		try {
			List<Object> qnaList = service.listQnA();
			log.debug(qnaList.toString());
			if (qnaList == null || qnaList.isEmpty()) {
				flag.setFlag("fail");
				flag.setData(null);
			} else {
				flag.setFlag("success");
				flag.setData(qnaList);
			}
			return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ApiOperation(value = "QnA를 추가한다.", notes = "QnA를 추가한다. 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping()
	public ResponseEntity<?> addQnA(@RequestBody QnA qna) {
		log.debug("QnA Add : ");
		flag.setData(null);
		try {
			int checkSum = service.addQnA(qna);
			log.debug(qna.toString());
			if (checkSum == 0) {
				flag.setFlag("fail");
			} else {
				flag.setFlag("success");
			}
			return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ApiOperation(value = "QnA를 삭제한다.", notes = "QnA를 삭제한다. 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/{id}")
	public ResponseEntity<?> modifyQnA(@PathVariable int id, @RequestBody HashMap<String,Object> map) {
		log.debug("QnA delete : ");
		flag.setData(null);
		map.put("id", id);
		try {
			int checkSum = service.modifyQnA(map);
			if (checkSum == 0) {
				flag.setFlag("fail");
			} else {
				flag.setFlag("success");
			}
			return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ApiOperation(value = "QnA를 삭제한다.", notes = "QnA를 삭제한다. 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteQnA(@PathVariable int id) {
		log.debug("QnA delete : ");
		flag.setData(null);
		try {
			int checkSum = service.deleteQnA(id);
			if (checkSum == 0) {
				flag.setFlag("fail");
			} else {
				flag.setFlag("success");
			}
			return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
