package com.springbook.view.board.oldController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class UpdateBoardController{

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		
		System.out.println("글 수정 처리");
		
//		request.setCharacterEncoding("utf-8");
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		String seq = request.getParameter("seq");
//		System.out.print(seq);
//		
//		
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setContent(content);
//		vo.setSeq(Integer.parseInt(seq));
//		
//		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		
//		response.sendRedirect("getBoardList.do");
//		return "getBoardList.do";
		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
		return "redirect: getBoardList.do";
	}
	
}
