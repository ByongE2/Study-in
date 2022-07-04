package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("글 목록 검색 처리");

		// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);

		// 3. 검색 결과를 세션에 저장하고 목록 화면으로 이동한다.
		// 검색결과를 세션에 하는건 비효율. HttpServletRequest객체에 저장해서 공유해야하는데, 지금은 코드의 간결함떄문에 세션에.
		// 나중에 spring변환할 때 한다
//		HttpSession session = request.getSession(); 		//세션에서 하던거 mav에 담아서 이제 보냄. 그래서 주석.
//		session.setAttribute("boardList", boardList);
		
		
//		response.sendRedirect("getBoardList.jsp");
//		return "getBoardList";
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); //모델 정보 저장
		mav.setViewName("getBoardList"); 	   // View 정보 저장
		return mav;

	}
}
