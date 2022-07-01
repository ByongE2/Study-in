package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class InsertBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardDAO DAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		DAO.insertBoard(vo);
//		response.sendRedirect("getBoardList.do");
//		return "getBoardList.do";
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		return mav;
		
	}
	
}
