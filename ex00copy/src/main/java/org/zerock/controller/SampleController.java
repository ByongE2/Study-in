package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

//	@RequestMapping("")
//	public void basic() {
//		log.info("basicㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//	
//	}
//	@RequestMapping(value="", method = RequestMethod.GET)
//	public String basic() {
//		log.info("basicㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//		return "basic";
//	}
//	@RequestMapping(value="", method = RequestMethod.POST)
//	public String basic2() {
//		log.info("basic2ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//		return "basic";
//	}
//	@GetMapping("basicOnlyGet")
//	public String basicGet() {
//		log.info("basicㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//		return "basic";
//	}
//	@GetMapping("/ex01")
//	public String ex01(SampleDTO dto) {
//		log.info("dtoㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + dto);
//		return "ex01";
//	}
//	@GetMapping("/ex01")
//	public String ex01(SampleDTO dto, Model model) {
//		log.info("dtoㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + dto);
//		model.addAttribute("name", "AAA222222");
//		model.addAttribute("model", model);
//		String aaa= "AAA";
//		model.addAttribute("name2", aaa);
//		return "ex01";
//	}
//	@GetMapping("/ex03")
//	public String ex03(SampleDTO dto, @ModelAttribute("page") int page) {
//		log.info("dtoㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + dto);
//		log.info("pageㅡㅡㅡㅡㅡㅡㅡㅡ" + page);
//		return "ex03";
//	}
	
	
	//제이슨 형태로 반환. pom.xml에 jackson-bindDate 추가해줘야함.
	@GetMapping("/ex04")
	public @ResponseBody SampleDTO ex04() {
		log.info("ex04:ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ "  );
		SampleDTO dto = new SampleDTO();
		dto.setName("AAA");
		dto.setAge(50);
		return dto;
	}
	
}
