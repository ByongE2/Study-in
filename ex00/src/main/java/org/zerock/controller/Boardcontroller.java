package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/board/*")
public class Boardcontroller {
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("리스트 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		log.info("cri : " + cri);
		log.info("listㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		int total = service.getTotal(cri);
		log.info("total count : " + total);
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}//list
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("등록 ㅡㅡㅡㅡㅡㅡㅡ: " + vo);
		service.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect:/board/list";
	}//register
	
	@GetMapping({"get", "/modify"})
	public void get(@ModelAttribute("cri")Criteria cri, Long bno, Model model) {
		log.info("ㅡㅡㅡㅡㅡㅡㅡㅡget or modifyㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		model.addAttribute("board", service.get(bno));
	}//get
	
	@PostMapping("/remove")
	public String remove(Long bno, @ModelAttribute("cri")Criteria cri, RedirectAttributes rttr) {
		log.info("삭제ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ: " + bno);
		
		if(service.remove(bno) == 1) {  // 삭제가 되었다면 , 반환타입이 int임.
			rttr.addFlashAttribute("result", "secess");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		//삭제 후 리턴 페이지 관리.
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO vo, @ModelAttribute("cri")Criteria cri, RedirectAttributes rttr) {
		
		log.info("수정ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + vo);
		
		if(service.modify(vo) == 1) {  // 수정이 되었다면 , 반환타입이 int임.
			rttr.addFlashAttribute("result", "secess");
		}
		//리다이렉트로 해주고있어서, rttr에 정보 담는다. 수정 누르면 수정 후에 기존 list페이지로.. mod~.jsp hidden이랑 연계해서.
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		//수정 후 리턴 페이지 관리
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/list";
	}
	

}
