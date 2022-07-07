package com.springbook.biz.board;

import java.sql.SQLException;
import java.util.List;

import com.springbook.biz.board.impl.BoardDAO;

public class BoardServiceClient {

	public static void main(String[] args) throws SQLException {
		
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		vo.setTitle("마이바티스 제목");
		vo.setWriter("홍길동");
		vo.setContent("마이바티스 내용...");
		boardDAO.insertBoard(vo);
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
//		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		List<BoardVO> boardListTest = boardDAO.getBoardTest(vo);
		
//		for(BoardVO board : boardList) {
			for(BoardVO board : boardListTest) {
			System.out.println("--->" + board.toString());
		}
		
	}
	
}
