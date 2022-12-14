package com.jsg.house.qna.controller;

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
import com.jsg.house.qna.model.dto.Qna;
import com.jsg.house.qna.model.service.QnaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("QnA(게시판) 컨트롤러 API V1") // http://localhost/happy/swagger-ui/index.html
@RestController
@RequestMapping("/qna")
@CrossOrigin
public class RestQnaController {

	private static final Logger log = LoggerFactory.getLogger(RestQnaController.class);

	private HttpFlag flag = new HttpFlag();

	@Autowired
	private QnaService service;

	@ApiOperation(value = "QnA 리스트를 불러온다.", notes = "QnA 전체 리스트를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping()
	public ResponseEntity<?> listQnA() {
		log.debug("QnA List : ");
		List<Object> qnaList = service.listQna();
		log.debug(qnaList.toString());
		flag.setFlag("success");
		flag.setData(qnaList);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}
	
	@ApiOperation(value = "QnA 리스트를 불러온다.", notes = "QnA 전체 리스트를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping("/list")
	public ResponseEntity<?> listQnAPaging(@RequestBody HashMap<String, Object> map) {
		log.debug("QnA List : ");
		List<Object> qnaList = service.listQnaPaging(map);
		log.debug(qnaList.toString());
		flag.setFlag("success");
		flag.setData(qnaList);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "QnA 상세 정보를 불러온다.", notes = "QnA 상세 정보를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/{id}")
	public ResponseEntity<?> detailBoard(@PathVariable int id) {
		log.debug("QnA List : ");
		List<Object> qnaList = new ArrayList<Object>();
		qnaList.add(service.detailQna(id));
		log.debug(qnaList.toString());
		flag.setFlag("success");
		flag.setData(qnaList);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "QnA를 추가한다.", notes = "QnA를 추가한다. 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping()
	public ResponseEntity<?> addQnA(@RequestBody Qna qna) {
		log.debug("QnA Add : ");
		service.addQna(qna);
		log.debug(qna.toString());
		flag.setFlag("success");
		flag.setData(null);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "QnA를 수정한다.", notes = "QnA를 수정한다. 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/{id}")
	public ResponseEntity<?> modifyQnA(@PathVariable int id, @RequestBody HashMap<String, Object> map) {
		log.debug("QnA delete : ");
		map.put("id", id);
		service.modifyQna(map);
		flag.setFlag("success");
		flag.setData(null);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "QnA를 삭제한다.", notes = "QnA를 삭제한다. 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteQnA(@PathVariable int id) {
		log.debug("QnA delete : ");
		service.deleteQna(id);
		flag.setFlag("success");
		flag.setData(null);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "QnA 상세 검색을 한다.", notes = "QnA 상세 검색을 불러온다.\n type : title, userName\n 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/search/{type}/{text}")
	public ResponseEntity<?> searchQna(@PathVariable("type") String type, @PathVariable("text") String text) {
		log.debug("QnA List : ");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("text", text);
		List<Object> qnaList = new ArrayList<Object>();
		qnaList = service.searchQna(map);
		log.debug(qnaList.toString());
		flag.setFlag("success");
		flag.setData(qnaList);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "QnA 리스트의 개수를 불러온다.", notes = "QnA 전체 리스트의 개수를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping("/count")
	public ResponseEntity<?> getTotalQna(@RequestBody HashMap<String, Object> map) {
		log.debug("Qna List Count : ");
		int checkSum = service.getTotalQna(map);
		log.debug(checkSum + "");
		List<Object> checkList = new ArrayList<Object>();
		checkList.add(checkSum);
		flag.setFlag("success");
		flag.setData(checkList);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

}
