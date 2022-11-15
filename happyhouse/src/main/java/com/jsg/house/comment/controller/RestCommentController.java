package com.jsg.house.comment.controller;

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

import com.jsg.house.board.controller.RestBoardController;
import com.jsg.house.comment.model.dto.Comment;
import com.jsg.house.comment.model.service.CommentService;
import com.jsg.house.config.HttpFlag;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Comment(댓글) 컨트롤러 API V1") // http://localhost/happy/swagger-ui/index.html
@RestController
@RequestMapping("/comment")
public class RestCommentController {

	private static final Logger log = LoggerFactory.getLogger(RestBoardController.class);

	private HttpFlag flag = new HttpFlag();

	private CommentService service;

	@Autowired
	public RestCommentController(CommentService service) {
		log.info("Comment Controller 생성자 호출");
		this.service = service;
	}

	@ApiOperation(value = "댓글 리스트를 불러온다.", notes = "댓글 전체 리스트를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping()
	public ResponseEntity<?> listComment() {
		log.debug("Comment List 불러오기.");
		try {
			List<Object> commentList = service.listComment();
			if (commentList == null || commentList.isEmpty()) {
				flag.setFlag("fail");
				flag.setData(null);
			} else {
				log.debug(commentList.toString());
				flag.setFlag("success");
				flag.setData(commentList);
			}
			return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "댓글 작성을 불러온다.", notes = "댓글 작성을 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping()
	public ResponseEntity<?> writeComment(@RequestBody Comment comment) {
		log.debug("Comment 작성하기 : ", comment);
		try {
			int checkSum = service.writeComment(comment);
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
	
//	@ApiOperation(value = "댓글 상세 보기를 불러온다.", notes = "댓글 상세 보기를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	
	@ApiOperation(value = "댓글 수정을 불러온다.", notes = "댓글 수정을 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PutMapping()
	public ResponseEntity<?> modifyComment(@RequestBody Comment comment) {
		log.debug("Comment 수정하기 : ", comment);
		try {
			int checkSum = service.modifyComment(comment);
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
	@DeleteMapping("/{commentid}")
	public ResponseEntity<?> deleteComment(@PathVariable("commentid") String commentId) {
		log.debug("Comment 삭제하기 : ", commentId);
		try {
			int checkSum = service.deleteComment(commentId);
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
