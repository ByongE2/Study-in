<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../includes/header.jsp" %>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           Board Read Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        		<div class="form-group">
                        			<label>Bno</label><input class="form-control" name="bno" readonly="readonly"
                        			value='<c:out value="${board.bno}"/>'><br>
                        		</div>
                        		<div class="form-group">
                        			<label>Title</label><input class="form-control" name="title" readonly="readonly" 
                        			value='<c:out value="${board.title}"/>'><br>
                        		</div>
                        		<div class="form-group">
                        			<label>Text Area</label><textarea class="form-control" rows="3" name="content" readonly="readonly">
                        			<c:out value="value=${board.content}"/></textarea><br>
                        		</div>
                        		<div class="form-group">
                        			<label>Writer</label><input class="form-control" name="writer" readonly="readonly"
                        			value='<c:out value="${board.writer}"/>'><br>
                        		</div>
				<button data-oper='modify' class="btn btn-default">Modify</button>
				<button data-oper='list' class="btn btn-info">List</button>
				<%-- <button data-oper='modify' class="btn btn-default" 
                        		onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'">modify</button>
                        		<button data-oper='list' class="btn btn-default" onclick="location.href='/board/list' ">
                        		>List</button> --%>
                        								<!-- modify????????????, ?????? j???????????? list ???????????? "/board/list" ????????????. -->
                        		<form id='operForm' action = "/board/modify" method="get">
                        			<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}"/>'>
                        			<!-- list ????????? ??????????????? ?????? ?????? ???????????? ???????????? ?????????+?????????????????? ???????????? cri ?????? -->
                        			<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
                        			<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
                        			<!-- ???????????? ????????? list ????????? ???????????? ?????? ????????????.-->
                        			<input type="hidden" name="type" value='<c:out value="${cri.type}"/>'>
                        			<input type="hidden" name="keyword" value='<c:out value="${cri.keyword}"/>'>
                        		</form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
<script>
	var operForm = $("#operForm");
  $("button[data-oper='modify']").on("click",function(){
    operForm.attr("action","/board/modify").submit();
  });
  $("button[data-oper='list']").on("click", function(){
    operForm.find("#bno").remove();
    operForm.attr("action","/board/list");
    operForm.submit();
  });
</script>             
           
 <%@ include file="../includes/footer.jsp" %>