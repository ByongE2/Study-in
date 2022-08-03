package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/*
 * 작업     URL        HTTP 전송방식
 * 등록: /replies/new  : POST
 * 조회: /replies/rno  : GET
 * 삭제: /replies/rno  : DELETE
 * 수정: /replies/rno  : PUT or PATCH
 * 페이지: /replies/pages/:bno/page:  : GET
*/


@RestController
@RequestMapping("/replies/")
@Log4j
@AllArgsConstructor 
public class ReplyController {
	
	//생성자 주입해서 @Autowired 안씀
	private ReplyService service;
	
	//클라이언트에서 서버전송 json, 서버에서 클라이언트 string
	//json data는{속성:값, 속성:값} 그래서 VO랑 일치안해서 requestBody 붙임
	//{bno:값, reply:값, replyer:값} 형태로 넘겨줘야한다.
	@PostMapping(value = "/new", consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) { 
		//String말고 ResponseEntity 쓴 이유는 상태코드를 같이 보내기위해서.
		log.info("ReplyVO : " + vo);
		int insertCount = service.register(vo);
		
		if(insertCount == 1) {
			return new ResponseEntity<>("success", HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//create
	
	//bno의 여러 댓글 들 중, 댓글들의 페이지.
	@GetMapping(value = "/pages/{bno}/{page}", 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<ReplyVO>> getlist(@PathVariable("bno") Long bno, @PathVariable("page") int page) {

		log.info("getList......" + bno + ":" + page);
		Criteria cri = new Criteria(page, 10);
		log.info("cri : " + cri);
		return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);
	}//getlist
	
	//삭제 										//값넘겨주는게아니라 성공 실패만알려주면 되서(String) text_plain_value
	@DeleteMapping(value = "/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		
		if(service.remove(rno) == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//remove
	
	//1건 data 가져오기
	@GetMapping(value = "/get/{rno}")
	public ResponseEntity<ReplyVO> get(@PathVariable("rno")Long rno){
		return new ResponseEntity<ReplyVO>(service.get(rno), HttpStatus.OK);
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
			value = "/{rno}", consumes = "application/json" , produces = {MediaType.TEXT_PLAIN_VALUE} )
	public ResponseEntity<String>modify(@PathVariable("rno")Long rno, @RequestBody ReplyVO vo){
		vo.setRno(rno);
		return service.modify(vo) == 1 ? new ResponseEntity<String>("success", HttpStatus.OK) :
										new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}//ReplyController
