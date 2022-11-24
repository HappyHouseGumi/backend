package com.jsg.house.like.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsg.house.config.HttpFlag;
import com.jsg.house.like.model.dto.Like;
import com.jsg.house.like.model.service.LikeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("좋아요 글 컨트롤러 API V1") // http://localhost/happy/swagger-ui/index.html
@RestController
@RequestMapping("/like")
@CrossOrigin
public class RestLikeController {

	private static final Logger log = LoggerFactory.getLogger(RestLikeController.class);

	private HttpFlag flag = new HttpFlag();

	private LikeService service;

	@Autowired
	public RestLikeController(LikeService service) {
		log.info("List Controller 생성자 호출");
		this.service = service;
	}
	
	@ApiOperation(value = "Like 리스트의 개수를 불러온다.", notes = "관심 글 전체 리스트의 개수를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping("/count")
	public ResponseEntity<?> getTotalLike(@RequestBody HashMap<String, Object> map) {
		log.debug("Board List Count : ");
		int checkSum = service.getTotalLike(map);
		log.debug(checkSum+"");
		List<Object> checkList = new ArrayList<Object>();
		checkList.add(checkSum);
		flag.setFlag("success");
		flag.setData(checkList);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "Like 리스트를 불러온다.", notes = "관심 글 전체 리스트를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping("/list")
	public ResponseEntity<?> listLike(@RequestBody HashMap<String, Object> map) {
		log.debug("Like List : ");
		List<Object> likeList = service.listLike(map);
		flag.setFlag("success");
		flag.setData(likeList);
		log.debug(likeList.toString());
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "Like Check를 불러온다.", notes = "관심 글의 존재 여부 확인을 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping("/check")
	public ResponseEntity<?> checkLike(@RequestBody HashMap<String, Object> map) {
		log.debug("Like Check : ");
		int checkSum = service.checkLike(map);
		log.debug(checkSum+"");
		List<Object> checkList = new ArrayList<Object>();
		checkList.add(checkSum);
		flag.setFlag("success");
		flag.setData(checkList);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "Like regist를 불러온다.", notes = "관심 글 등록을 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping()
	public ResponseEntity<?> registLike(@RequestBody Like like) {
		log.debug("Like regist : ", like);
		service.registLike(like);
		flag.setFlag("success");
		flag.setData(null);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "Like delete를 불러온다.", notes = "관심 글 삭제를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@DeleteMapping("/{boardid}/{userid}")
	public ResponseEntity<?> deleteLike(@PathVariable("boardid") String boardId,
			@PathVariable("userid") String userId) {
		log.debug("Like delete : ", boardId, userId);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("boardId", boardId);
		map.put("userId", userId);
		service.deleteLike(map);
		flag.setFlag("success");
		flag.setData(null);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Like 게시글 별 좋아요 수를 불러온다.", notes = "관심 글 게시글 별 좋아요 수를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/countBoard/{boardid}")
	public ResponseEntity<?> getCountLike(@PathVariable("boardid") String boardId) {
		log.debug("Like 게시글 별 좋아요 수 : ", boardId);
		int checkSum = service.getCountLike(boardId);
		log.debug(checkSum+"");
		List<Object> checkList = new ArrayList<Object>();
		checkList.add(checkSum);
		flag.setFlag("success");
		flag.setData(checkList);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "Like 게시글 별 좋아요 사용자를 불러온다.", notes = "관심 글 게시글 별 좋아요 사용자를를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/likeUser/{boardid}")
	public ResponseEntity<?> getLikeUser(@PathVariable("boardid") String boardId) {
		log.debug("Like 게시글 별 좋아요 사용자 : ", boardId);
		List<Object> userList = service.getLikeUser(boardId);
		log.debug(userList.toString());
		flag.setFlag("success");
		flag.setData(userList);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

}
