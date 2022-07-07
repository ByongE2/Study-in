package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board") // Model에 "board" 이름 저장된 데이터 있으면, 그 데이터를 세션에도 자동으로 저장하라는 설정.애너테이션.
								// date에 null값 안들어가게 세션에 저장하는거.
// 스프링 컨테이너가 먼저 @ModelAttribute("board") 해석해서 세션에 board로 저장된거 있는지 확인. 있으면 세션에 있는 data를 매개변수인 vo에 할당
//그리고 사용자가 입력한 파라미터값을 vo에 할당. >> 사용자가 수정한 값만 새롭게 할당되고, 나머지는 세션에 저장된 데이터 그대로 유지.
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//getBoardList()와 같음. Jackson2변환기 사용했기 때문에, JSON으로 변환되어 HTTP 응답 보디에 설정되게하는 메서드.
	@RequestMapping("/dataTransform.do")
	@ResponseBody	//자바 객체를 Http 응답 포로토콜의 body로 변환하기 위해 사용.
	public List<BoardVO> dataTransfrom(BoardVO vo){
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		return boardList;
	}
	
	//글 등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		// 파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("c:/upload/" + fileName)); //c드라이브에 upload폴더 자동으로 만들어줌.
		}
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
		//Null Check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
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
