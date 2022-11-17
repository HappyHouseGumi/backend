package com.jsg.house.like.controller;

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
public class RestLikeController {

	private static final Logger log = LoggerFactory.getLogger(RestLikeController.class);

	private HttpFlag flag = new HttpFlag();

	private LikeService service;

	@Autowired
	public RestLikeController(LikeService service) {
		log.info("List Controller 생성자 호출");
		this.service = service;
	}

	@ApiOperation(value = "Like 리스트를 불러온다.", notes = "관심 글 전체 리스트를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping()
	public ResponseEntity<?> listLike() {
		log.debug("Like List : ");
		try {
			List<Object> likeList = service.listLike();
			if (likeList == null || likeList.isEmpty()) {
				flag.setFlag("fail");
				flag.setData(null);
			} else {
				flag.setFlag("success");
				flag.setData(likeList);
				log.debug(likeList.toString());
			}
			return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Like regist를 불러온다.", notes = "관심 글 등록을 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping()
	public ResponseEntity<?> registLike(@RequestBody Like like) {
		log.debug("Like regist : ", like);
		System.out.println(like);
		try {
			int checkSum = service.registLike(like);
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

	@ApiOperation(value = "Like delete를 불러온다.", notes = "관심 글 전체 리스트를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@DeleteMapping("/{likeid}")
	public ResponseEntity<?> deleteLike(@PathVariable("likeid") String likeId) {
		log.debug("Like delete : ", likeId);
		System.out.println(likeId);
		try {
			int checkSum = service.deleteLike(likeId);
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
