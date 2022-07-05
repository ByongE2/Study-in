package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board") // Model에 "board" 이름 저장된 데이터 있으면, 그 데이터를 세션에도 자동으로 저장하라는 설정.애너테이션.
								// date에 null값 안들어가게 세션에 저장하는거.
// 스프링 컨테이너가 먼저 @ModelAttribute("board") 해석해서 세션에 board로 저장된거 있는지 확인. 있으면 세션에 있는 data를 매개변수인 vo에 할당
//그리고 사용자가 입력한 파라미터값을 vo에 할당. >> 사용자가 수정한 값만 새롭게 할당되고, 나머지는 세션에 저장된 데이터 그대로 유지.
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//글 등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		return "redirect: getBoardList.do";
	}//insertBoard
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
//		System.out.println("번호: " + vo.getSeq());
//		System.out.println("제목: " + vo.getTitle());
//		System.out.println("작성자: " + vo.getWriter());
//		System.out.println("내용: " + vo.getContent());
//		System.out.println("등록일: " + vo.getRegDate());
//		System.out.println("조회수: " + vo.getCnt());
		boardService.updateBoard(vo);
		return "redirect: getBoardList.do";
	}//updateBoard
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect: getBoardList.do";
	}//deleteBoard
	
	//글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo)); //Model 정보 저장
		return "getBoard.jsp"; //View 이름 리턴
//		mav.addObject("board", boardDAO.getBoard(vo));
//		mav.setViewName("getBoard.jsp");
//		return mav;
	}//getBoard
	
	// 검색 조건 목록 설정 ㅡ 목록설정임.
	@ModelAttribute("conditionMap") //메서드에 @ModelAttribute을 붙이면, @RequestMapping적용 메서드보다 먼저 호출됨.
									// 그리고 @ModelAttribute 메소드 실행결과로 리턴된 객체는 자동으로 Model에 저장됨. -> 그래서 View에서 사용가능.
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
//		conditionMap.put("작성자", "WRITER"); 
		return conditionMap;
	}
	
	
	//글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}//getBoardList
	
//	@RequestMapping("/getBoardList.do")
//	public String getBoardList(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false)	String condition,
//			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
//			BoardDAO boardDAO, Model model) {
//		System.out.println("검색 조건: " + condition);
//		System.out.println("검색 단어: " + keyword);
		
//		return "getBoardList.jsp";
		
//	}//getBoardList
}
