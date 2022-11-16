package com.jsg.house.notice.controller;

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
import com.jsg.house.notice.model.dto.Notice;
import com.jsg.house.notice.model.service.NoticeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Notice(공지사항) 컨트롤러 API V1") // http://localhost/happy/swagger-ui/index.html
@RestController
@RequestMapping("/notice")
public class RestNoticeController {

	private static final Logger log = LoggerFactory.getLogger(RestNoticeController.class);

	private HttpFlag flag = new HttpFlag();
	
	private NoticeService service;

	@Autowired
	public RestNoticeController(NoticeService service) {
		log.info("Notice Controller 생성자 호출");
		this.service = service;
	}
	
	@ApiOperation(value = "Notice 리스트를 불러온다.", notes = "공지사항 전체 리스트를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping()
	public ResponseEntity<?> listNotice() {
		log.debug("Notice List : ");
		try {
			List<Object> noticeList = service.listNotice();
			log.debug(noticeList.toString());
			if (noticeList == null || noticeList.isEmpty()) {
				flag.setFlag("fail");
				flag.setData(null);
			} else {
				flag.setFlag("success");
				flag.setData(noticeList);
			}
			return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ApiOperation(value = "Notice write를 불러온다.", notes = "공지사항 글 쓰기를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping()
	public ResponseEntity<?> writeNotice(@RequestBody Notice notice) {
		log.debug("Notice Write : ", notice);
		try {
			int checkSum = service.writeNotice(notice);
			if (checkSum == 0) {
				throw new Exception();
			} else {
				flag.setFlag("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			flag.setFlag("fail");
		}
		flag.setData(null);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "Notice view를 불러온다.", notes = "공지사항 글 상세 보기를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/{noticeid}")
	public ResponseEntity<?> viewNotice(@PathVariable("noticeid") String noticeId) {
		log.debug("Notice View : ", noticeId);
		try {
			List<Object> vnotice = service.viewNotice(noticeId);
			if (vnotice == null || vnotice.isEmpty()) {
				flag.setFlag("fail");
				flag.setData(null);
			} else {
				flag.setFlag("success");
				flag.setData(vnotice);
			}
			return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ApiOperation(value = "Notice modify를 불러온다.", notes = "공지사항 글 수정을 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PutMapping()
	public ResponseEntity<?> modifyNotice(@RequestBody HashMap<String, Object> map) {
		log.debug("Notice Modify : ", map);
		try {
			int checkSum = service.modifyNotice(map);
			if (checkSum != 0) {
				String noticeId = map.get("id") + "";
				List<Object> mnotice = service.viewNotice(noticeId);
				if (mnotice == null || mnotice.isEmpty()) {
					flag.setFlag("fail");
					flag.setData(null);
				} else {
					flag.setFlag("success");
					flag.setData(mnotice);
				}
				return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ApiOperation(value = "Notice delete를 불러온다.", notes = "공지사항 글 삭제를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@DeleteMapping("/{noticeid}")
	public ResponseEntity<?> deleteNotice(@PathVariable("noticeid") String noticeId) {
		log.debug("Notice Delete : ", noticeId);
		try {
			int checkSum = service.deleteNotice(noticeId);
			if (checkSum == 0) {
				throw new Exception();
			} else {
				flag.setFlag("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			flag.setFlag("fail");
		}
		flag.setData(null);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}
	
}
