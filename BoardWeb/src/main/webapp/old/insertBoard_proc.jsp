<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>   
<%@ page import="com.springbook.biz.board.BoardVO" %>  
<%
	request.setCharacterEncoding("utf-8");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	BoardDAO DAO = new BoardDAO();
	BoardVO vo = new BoardVO();
	
	vo.setTitle(title);
	vo.setWriter(writer);
	vo.setContent(content);
	
	DAO.insertBoard(vo);
	response.sendRedirect("getBoardList.jsp");
%>