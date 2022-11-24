package com.jsg.house.notice.controller;

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
import com.jsg.house.notice.model.dto.Notice;
import com.jsg.house.notice.model.service.NoticeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Notice(공지사항) 컨트롤러 API V1") // http://localhost/happy/swagger-ui/index.html
@RestController
@RequestMapping("/notice")
@CrossOrigin
public class RestNoticeController {

	private static final Logger log = LoggerFactory.getLogger(RestNoticeController.class);

	private HttpFlag flag = new HttpFlag();

	private NoticeService service;

	@Autowired
	public RestNoticeController(NoticeService service) {
		log.info("Notice Controller 생성자 호출");
		this.service = service;
	}
	
	@ApiOperation(value = "Notice 리스트의 개수를 불러온다.", notes = "공지사항 전체 리스트의 개수를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping("/count")
	public ResponseEntity<?> getTotalNotice(@RequestBody HashMap<String, Object> map) {
		log.debug("Board List Count : ");
		int checkSum = service.getTotalNotice(map);
		log.debug(checkSum+"");
		List<Object> checkList = new ArrayList<Object>();
		checkList.add(checkSum);
		flag.setFlag("success");
		flag.setData(checkList);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "Notice 리스트를 불러온다.", notes = "공지사항 전체 리스트를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping("/list")
	public ResponseEntity<?> listNotice(@RequestBody HashMap<String, Object> map) {
		log.debug("Notice List : ");
		List<Object> noticeList = service.listNotice(map);
		log.debug(noticeList.toString());
		flag.setFlag("success");
		flag.setData(noticeList);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "Notice write를 불러온다.", notes = "공지사항 글 쓰기를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping()
	public ResponseEntity<?> writeNotice(@RequestBody Notice notice) {
		log.debug("Notice Write : ", notice);
		service.writeNotice(notice);
		flag.setFlag("success");
		flag.setData(null);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "Notice view를 불러온다.", notes = "공지사항 글 상세 보기를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/{noticeid}")
	public ResponseEntity<?> viewNotice(@PathVariable("noticeid") String noticeId) {
		log.debug("Notice View : ", noticeId);
		List<Object> vnotice = service.viewNotice(noticeId);
		flag.setFlag("success");
		flag.setData(vnotice);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "Notice modify를 불러온다.", notes = "공지사항 글 수정을 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PutMapping("/{noticeid}")
	public ResponseEntity<?> modifyNotice(@PathVariable("noticeid") String noticeId, @RequestBody HashMap<String, Object> map) {
		log.debug("Notice Modify : ", map);
		map.put("id", noticeId);
		service.modifyNotice(map);
		List<Object> mnotice = service.viewNotice(noticeId);
		flag.setFlag("success");
		flag.setData(mnotice);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "Notice delete를 불러온다.", notes = "공지사항 글 삭제를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@DeleteMapping("/{noticeid}")
	public ResponseEntity<?> deleteNotice(@PathVariable("noticeid") String noticeId) {
		log.debug("Notice Delete : ", noticeId);
		service.deleteNotice(noticeId);
		flag.setFlag("success");
		flag.setData(null);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

}
