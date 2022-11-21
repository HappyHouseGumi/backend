package com.jsg.house.board.controller;

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

import com.jsg.house.board.model.dto.Board;
import com.jsg.house.board.model.service.BoardService;
import com.jsg.house.config.HttpFlag;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Board(게시판) 컨트롤러 API V1") // http://localhost/happy/swagger-ui/index.html
@RestController
@RequestMapping("/board")
@CrossOrigin
public class RestBoardController {

	private static final Logger log = LoggerFactory.getLogger(RestBoardController.class);

	private HttpFlag flag = new HttpFlag();

	private BoardService service;

	@Autowired
	public RestBoardController(BoardService service) {
		log.info("Board Controller 생성자 호출");
		this.service = service;
	}

	@ApiOperation(value = "Board subject 시도 구군 정보를 불러온다.", notes = "게시판 말머리를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/{gubun}/{code}")
	public ResponseEntity<?> subjectBoard(@PathVariable(name = "gubun") String gubun,
			@PathVariable(name = "code") String code) {
		log.debug("Board Subject : ", gubun, code);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("gubun", gubun);
		map.put("code", code);
		if (map.get("gubun").equals("sido")) {
			List<Object> dongcode = service.getSidoName();
			flag.setFlag("success");
			flag.setData(dongcode);
			return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
		}
		if (map.get("gubun").equals("gugun")) {
			List<Object> dongcode = service.getGugunName(map.get("code"));
			flag.setFlag("success");
			flag.setData(dongcode);
			return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ApiOperation(value = "Board 리스트의 개수를 불러온다.", notes = "게시판 전체 리스트의 개수를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping("/count")
	public ResponseEntity<?> getTotalBoard(@RequestBody HashMap<String, Object> map) {
		log.debug("Board List Count : ");
		int checkSum = service.getTotalBoard(map);
		log.debug(checkSum+"");
		List<Object> checkList = new ArrayList<Object>();
		checkList.add(checkSum);
		flag.setFlag("success");
		flag.setData(checkList);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "Board 리스트를 불러온다.", notes = "게시판 전체 리스트를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping("/list")
	public ResponseEntity<?> listBoard(@RequestBody HashMap<String, Object> map) {
		log.debug("Board List : ");
		List<Object> boardList = service.listBoard(map);
		log.debug(boardList.toString());
		flag.setFlag("success");
		flag.setData(boardList);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "Board write를 불러온다.", notes = "게시판 글 쓰기를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PostMapping()
	public ResponseEntity<?> writeBoard(@RequestBody Board board) {
		log.debug("Board Write : ", board);
		service.writeBoard(board);
		flag.setFlag("success");
		flag.setData(null);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "Board view를 불러온다.", notes = "게시판 글 상세 보기를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@GetMapping("/{boardid}")
	public ResponseEntity<?> viewBoard(@PathVariable("boardid") String boardId) {
		log.debug("Board View : ", boardId);
		List<Object> vboard = service.viewBoard(boardId);
		flag.setFlag("success");
		flag.setData(vboard);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "Board modify를 불러온다.", notes = "게시판 글 수정을 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@PutMapping("/{boardid}")
	public ResponseEntity<?> modifyBoard(@PathVariable("boardid") String boardId, @RequestBody HashMap<String, Object> map) {
		log.debug("Board Modify : ", map);
		map.put("id", boardId);
		service.modifyBoard(map);
		List<Object> mboard = service.viewBoard(boardId);
		flag.setFlag("success");
		flag.setData(mboard);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

	@ApiOperation(value = "Board delete를 불러온다.", notes = "게시판 글 삭제를 불러온다. 'success' 또는 'fail' 문자열과 데이터를 반환한다.", response = String.class)
	@DeleteMapping("/{boardid}")
	public ResponseEntity<?> deleteBoard(@PathVariable("boardid") String boardId) {
		log.debug("Board Delete : ", boardId);
		service.deleteBoard(boardId);
		flag.setFlag("success");
		flag.setData(null);
		return new ResponseEntity<HttpFlag>(flag, HttpStatus.OK);
	}

}
