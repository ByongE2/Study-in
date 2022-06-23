package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		// 1. spring 컨테이너 구동 
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	
		// 2. Spring 컨테이너로부터 BoardServieImpl 객체를 LookUp한다.
//		BoardService boardService = (BoardService)container.getBean("boardService");
		BoardService boardService = container.getBean("boardService", BoardService.class);
		
		// 3. 글 등록 기능 테스트
		BoardVO vo = new BoardVO();
		vo.setTitle("임시제목33");
		vo.setWriter("테스트사용자33");
		vo.setContent("임시내용33");
		boardService.insertBoard(vo);

		// 4. 글 목록 검색 기능 테스트
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("--->" + board.toString());
		}
		
		container.close();
	}
	
}
