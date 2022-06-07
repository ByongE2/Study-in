<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import=" java.util.*, com.it.dao.*, java.text.* " %>

<jsp:useBean id="dao" class="com.it.dao.BoardDAO"/>

<%
   //1. 사용자 입력값 받기(page)
   String strPage = request.getParameter("page");
   if(strPage == null) {
      strPage = "1";
   }
   int curPage = Integer.parseInt(strPage);
   
   //2. 데이타베이스로 부터 데이터를 읽어 온다
   List<BoardVO> list = dao.boardListData(curPage);
   int totalPage = dao.boardTotalPage();
   
   //페이지 나누기
   final int BLOCK =3;
   int startPage = ( (curPage-1)/BLOCK*BLOCK ) + 1;  //1/3*3+1=2
   int endPage = ( (curPage-1)/BLOCK*BLOCK ) +BLOCK; //1/3*3+3=4
   
   if(endPage>totalPage)
      endPage = totalPage;
   
   //오늘 날짜
   String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Insert title here</title>
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
            <tr> <td> <a href="insert.jsp" class="btn btn-sm btn-success">새글</a> </td> </tr>
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
               for(BoardVO vo : list){
            %>
            <tr>
               <td class="text-center" width=10%><%=vo.getNo() %></td>
               <td width=45%>
                  <a href="detail.jsp?no=<%=vo.getNo()%>"><%=vo.getSubject() %></a>&nbsp;
                  <sup style="color:red">new</sup>
               </td>
               
               <td class="text-center" width=15%><%=vo.getName() %></td>
               <td class="text-center" width=20%><%=vo.getDbday() %></td>
               <td class="text-center" width=10%><%=vo.getHit() %></td>
            </tr>
            <%      
               }
            %>
         </table>
      </div>
      <!-- 게시판 밑 페이지네이션 -->
      <div class="row">
      	<div class="text-center">
	        <ul class="pagination">
	        	<%
                             if(startPage>1){//1,,,4,5 다음페이지 출력흐름
                             
                          %>
                          <li><a href="list.jsp?page=<%=startPage-1%>">&lt</a></li>
                          <%
                             }
                          %>
                          <!-- 페이지 바뀌는 소스 -->
                          <%
                             for(int i=startPage; i<=endPage; i++){
                             String act = "";
                             if(curPage==i)
                                act="class=active";
                             else act="";
                             
                          %>
                          <li <%=act %>><a href="list.jsp?page=<%=i%>"><%=i %></a></li>
                          <%
                             }
                          %>
                          <%
                             if(endPage<totalPage){
                          %>
                          <li><a href="list.jsp?page=<%=endPage+1%>">&gt</a></li>
                          <%
                             }
                          %>
                     </ul>
            </div>
         
         </div>
      </div>

</body>


</html>