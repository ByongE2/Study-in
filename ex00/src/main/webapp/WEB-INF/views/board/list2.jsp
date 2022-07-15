<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <title>list page</title>
</head>
<body>
  <div class="container">
  <h1>List page</h1>
  <table class="table">
  <thead>
    <tr>
      <th>#번호</th>
      <th>제목</th>
      <th>내용</th>
      <th>저자</th>
      <th>작성일</th>
      <th>수정일</th>
    </tr>
  </thead>
  <c:forEach items="${list}" var="board">
    <tbody>
      <tr>
        <td><c:out value="${board.bno}"/></td>
        <td><c:out value="${board.title}"/></td>
        <td><c:out value="${board.content}"/></td>
        <td><c:out value="${board.writer}"/></td>
        <%-- <td><c:out value="${board.regDate}"/></td> --%>
        <%-- <td><c:out value="${board.updateDate}"/></td> --%>
        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}"/></td>
        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
        
        <!-- 보안문제 때문에 좀더 불편하더라도 c태그 씀. 입력란에 <>코드 넣어버리면 적용되기때문에.. 서치 ㄱ-->
        <!-- <td>${board.bno}</td>
        <td>${board.title}</td>
        <td>${board.content}</td>
        <td>${board.writer}</td>
        <td>${board.regDate}</td>
        <td>${board.updateDate}</td> -->
      </tr>

    </tbody>
  </c:forEach>

  </table>
  </div>
  
</body>
</html>
