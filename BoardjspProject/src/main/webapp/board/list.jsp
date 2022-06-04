<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.it.dao.*, java.text.* "%>
    
<jsp:useBean id="dao" class="com.it.dao.BoardDAO"/>
<%
	//1. 사용자 입력값 받기(page)
	String strpage = request.getParameter("page");
	
	if(strpage == null) {
		strpage = "1";
	}
	
	int curPage = Integer.parseInt(strpage);
	//2. 데이터베이스로 부터 데이터를 읽어 온다.
	List<BoardVO> lsit = dao.boardListData(curPage);
	int totalPage = dao.boardTotalPage();
	
		//페이지 나누기
	final int BLOCK =3;
	int startPage = ( (curPage-1)/BLOCK*BLOCK ) + 1;
	int endPage = ( (curPage-1)/BLOCK*BLOCK ) + BLOCK;
	
	if(endPage > totalPage)
		endPage = totalPage;
		//오늘 날짜
	String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <style type="text/css">
  .container{
   margin-top: 50px;
  }
  .row{
   margin: 0px auto; 
   width : 960px;
  }
  h1{
   text-align: center;
  }
  
  
  
 </style>
</head>
<body>
 <div class="container">
  <h1>자유게시판</h1>
  <div class="row">
   <table class="table">
    <tr>
     <td>
      <a href="insert.jsp" class="btn btn-sm btn-success">새글</a>
     </td>
    </tr>
   </table>
   
   <table class="table">
    <tr class="danger">
     <th class="text-center" width=10%>번호</th>
     <th class="text-center" width=45%>제목</th>
     <th class="text-center" width=15%>이름</th>
     <th class="text-center" width=20%>작성일</th>
     <th class="text-center" width=10%>조회수</th>
    </tr>
    <%
    	for(BoardVO vo :list){
    %>
     <td class="text-center" width=10%><%=vo.getNo() %></td>
     <td width=45%>
      <a href="detail.jsp?no=<%vo.getNo() %>"><%=vo.getSubject()%></a>
    <%

    %>
   </table>
  </div>
 </div>



















</body>
</html>