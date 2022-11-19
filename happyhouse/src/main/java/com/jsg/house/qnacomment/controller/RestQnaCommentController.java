package com.jsg.house.qnacomment.controller;

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

import com.jsg.house.board.controller.RestBoardController;
import com.jsg.house.config.HttpFlag;
import com.jsg.house.qnacomment.model.dto.QnaComment;
import com.jsg.house.qnacomment.model.service.QnaCommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("QnA Comment(댓글) 컨트롤러 API V1") // http://localhost/happy/swagger-ui/index.html
@RestController
@CrossOrigin
@RequestMapping("/qnacomment")
public class RestQnaCommentController {

	private static final Logger log = LoggerFactory.getLogger(RestBoardController.class);

	private HttpFlag flag = new HttpFlag();

	private QnaCommentService service;

	@Autowired
	public RestQnaCommentController(QnaCommentService service) {
		log.info("Comment Controller 생성자 호출");
		this.service = service;
	}

	@ApiOperation(value = "댓글 리스트를 불러온다.", notes = "댓글 전체 리스트를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/{qnaId}")
	public ResponseEntity<?> listQnAComment(@PathVariable int qnaId) {
		log.debug("QnA Comment 불러오기.");
		try {
			List<Object> comment = service.listQnaComment(qnaId);
			if (comment == null || comment.isEmpty()) {
				flag.setFlag("fail");
				flag.setData(null);
			} else {
				flag.setFlag("success");
				flag.setData(comment);
			}
			return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "댓글 작성을 불러온다.", notes = "댓글 작성을 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping()
	public ResponseEntity<?> writeQnAComment(@RequestBody QnaComment comment) {
		log.debug("Comment 작성하기 : ", comment);
		List<Object> comments = new ArrayList<Object>();
		try {
			int checkSum = service.writeQnaComment(comment);
			comments = service.listQnaComment(comment.getQnaId());
			if (checkSum == 0) {
				throw new Exception();
			} else {
				flag.setFlag("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			flag.setFlag("fail");
		}
		flag.setData(comments);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}
	
//	@ApiOperation(value = "댓글 상세 보기를 불러온다.", notes = "댓글 상세 보기를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	
	@ApiOperation(value = "댓글 수정을 불러온다.", notes = "댓글 수정을 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PutMapping("/{id}")
	public ResponseEntity<?> modifyQnAComment(@PathVariable int id, @RequestBody HashMap<String,Object> map) {
		log.debug("Comment 수정하기 : ");
		try {
			map.put("id", id);
			int checkSum = service.modifyQnaComment(map);
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
	
	@ApiOperation(value = "댓글 삭제를 불러온다.", notes = "댓글 삭제를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable("id") int id) {
		log.debug("Comment 삭제하기 : ", id);
		try {
			int checkSum = service.deleteQnaComment(id);
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
