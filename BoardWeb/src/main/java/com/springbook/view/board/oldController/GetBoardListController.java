package com.springbook.view.board.oldController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController {

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {

		System.out.println("글 목록 검색 처리");

		// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
		// 2. DB 연동 처리
//		BoardVO vo = new BoardVO();
//		BoardDAO boardDAO = new BoardDAO();
		
//		List<BoardVO> boardList = boardDAO.getBoardList(vo);           //얘는 어떻게 처리됬을까나..어노테이션이 해준걸까나 그냥..
		

		// 3. 검색 결과를 세션에 저장하고 목록 화면으로 이동한다.
		// 검색결과를 세션에 하는건 비효율. HttpServletRequest객체에 저장해서 공유해야하는데, 지금은 코드의 간결함떄문에 세션에.
		// 나중에 spring변환할 때 한다
//		HttpSession session = request.getSession(); 		//세션에서 하던거 mav에 담아서 이제 보냄. 그래서 주석.
//		session.setAttribute("boardList", boardList);
		
		
//		response.sendRedirect("getBoardList.jsp");
//		return "getBoardList";
//		ModelAndView mav = new ModelAndView();
		
//		mav.addObject("boardList", boardList); //모델 정보 저장
		mav.addObject("boardList", boardDAO.getBoardList(vo)); //모델 정보 저장
		mav.setViewName("getBoardList.jsp"); 	   // View 정보 저장
		return mav;

	}
}
