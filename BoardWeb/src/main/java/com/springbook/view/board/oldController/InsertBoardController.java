package com.springbook.view.board.oldController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController {

	@RequestMapping(value = "/insertBoard.do")
//	public void insertBoard(HttpServletRequest request) { > request(사용자입력)이 많거나, 수정되면 다 바꿔줘야하니, command객체 이용
	//command 객체 : controller메소드 매개변수로 받은 VO 객체. @컨트롤러,리퀘스트맵핑으로 매개변수받으면 스프링컨테이너가 다처리해줌 1,2 
	//p 364~
//		public void insertBoard(BoardVO vo) {  //return으로 getBoardList.do를 하기위해 바꾼다. DAO도 command처럼 매개변수로받아서 처리.
		public String insertBoard(BoardVO vo, BoardDAO boardDAO) {  
		
		System.out.println("글 등록 처리");
		
//		//1. 사용자 입력 정보 추출
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
//
//		//2. DB 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
		
//		BoardDAO DAO = new BoardDAO();
//		DAO.insertBoard(vo);
		boardDAO.insertBoard(vo);
		
//		response.sendRedirect("getBoardList.do");
//		return "getBoardList.do";
		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
		return "redirect: getBoardList.do";
		
	}
	
}
