// JS객체(메모리상) > JSON.stringify(문자열..text로)-jackson-databind > java객체 >>> 문자열-jackson-databind > JSON.parse() > JS객체  

package org.zerock.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.log4j.Log4j;

//@Controller
@RestController //@Controller + @ResponseBody > 즉 응답할 때 Body에 data를 넣어서 보내주겠다.
@RequestMapping("/sample2")
@Log4j
public class RestSampleController {
								   //반환형.반환타입
//	@GetMapping(value="/getText" , produces = "text/plain; charset=utf-8")
	@GetMapping(value="/getText" , produces = {MediaType.TEXT_PLAIN_VALUE})  //문자형을 ???로 인식하네.
//	@ResponseBody // "안녕하세요".jsp를 찾는게아니라, 문자열 자체를 전송하게 함. JSON 데이터를 스트링으로.
	public String getText() {
		log.info("MINY TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}//getText
	

//객체반환
	@GetMapping(value="/getSample" , produces = {
//			MediaType.APPLICATION_JSON_UTF8_VALUE,      deprecated
			MediaType.APPLICATION_JSON_VALUE,   //url 뒤에 .json 붙이면 나옴.
			MediaType.APPLICATION_XML_VALUE
	})
//	@ResponseBody @RestController 쓰면안써도된다.
	public SampleVO getSample() {
		log.info("getSample------------------------");
		return new SampleVO(111, "홍", "길동");
	}//getSample
	
	@GetMapping(value="/getList" , produces= {
			MediaType.APPLICATION_JSON_VALUE,    //없어도됨. 생략가능
			MediaType.APPLICATION_XML_VALUE
	})
	public List<SampleVO> getList(){
		log.info("getList----------------------");
		List<SampleVO> list = new ArrayList<SampleVO>();
		SampleVO vo = new SampleVO();
		vo.setMno(000);
		vo.setFirstName("김");
		vo.setLastName("찬호");
		
		list.add(vo);
		vo.setMno(111);
		vo.setFirstName("박");
		vo.setLastName("찬호");
		
		list.add(vo);
		vo.setMno(222);
		vo.setFirstName("홍");
		vo.setLastName("찬호");
		
//		return list;
		return IntStream.range(1, 5).mapToObj(i->new SampleVO(i, i+"FistName", i+"LastName")).collect(Collectors.toList());
		
	}//getList
	
	@GetMapping(value="/getMap", produces= {
			MediaType.APPLICATION_JSON_VALUE,    //없어도됨. 생략가능
			MediaType.APPLICATION_XML_VALUE
	})
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map = new HashMap<>();
		map.put("Fitst", new SampleVO(111,"수원", "이젠"));
		map.put("Second", new SampleVO(222,"경기", "팔달구"));
		return map;
	}//getMap
	
	//상태 코드로 함께 전송
	@GetMapping(value = "/check", params = {"height", "weight"})
		   //반환할 때 vo만 주는게 아니라, 상태코드도 주기 위해서 사용.
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(1, " " + height, "" + weight);
		ResponseEntity<SampleVO> result = null;
		
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo); // 150미만이면 에러.
		}else {
//			result = ResponseEntity.status(HttpStatus.OK).body(vo); //에러 안나서 상태코드 200번. 그리고 body에 데이터 담아서 응답
			result = new ResponseEntity<SampleVO>(vo, HttpStatus.OK); //위에주석보다 이거 더 많이 사용.
		}
		return result;
	}
	
	//쿼리스트링? path 경로에 data 직접기입하면 적용됨.
	@GetMapping(value="/product/{cat}/{pid}")
	public String[] getPath(
			@PathVariable("cat") String cat,
			@PathVariable("pid") String pid
			) {
		return new String[] {"category : " + cat, "productId : " + pid} ; 
		
	}
	
	@PostMapping("/ticket")			// json데이터를 java객체로 변환해주는 애너테이션.
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert : " + ticket);
		ticket.setTno(200);
		ticket.setOwner("홍길동");
		ticket.setGrade("C등급");
		return ticket;
	}
	
}//RestSampleController