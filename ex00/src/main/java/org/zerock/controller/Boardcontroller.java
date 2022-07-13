package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/board/*")
public class Boardcontroller {
	
	private BoardService service;
	
	@RequestMapping("list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}//list
	
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("등록 ㅡㅡㅡㅡㅡㅡㅡ: " + vo);
		service.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect: /board/list";
	}//register
	
	@GetMapping("get")
	public void get(Long bno, Model model) {
		log.info("getㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		model.addAttribute("board", service.get(bno));
	}//get
	
	@PostMapping("remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		log.info("삭제ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ: " + bno);
		
		if(service.remove(bno) == 1) {  // 삭제가 되었다면 , 반환타입이 int임.
			rttr.addFlashAttribute("result", "secess");
		}
		
		return "redirect:/board/list";
	}
	
	@PostMapping("modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		
		log.info("수정ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + vo);
		
		if(service.modify(vo) == 1) {  // 수정이 되었다면 , 반환타입이 int임.
			rttr.addFlashAttribute("result", "secess");
		}
		
		return "redirect:/board/list";
	}
	

}
