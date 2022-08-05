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
                        								<!-- modify가는건데, 아래 j쿼리에서 list 클릭하면 "/board/list" 바꿔버림. -->
                        		<form id='operForm' action = "/board/modify" method="get">
                        			<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}"/>'>
                        			<!-- list 누르면 첫페이지가 아닌 원래 페이지로 가기위해 여기랑+컨트롤러에서 매개변수 cri 추가 -->
                        			<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
                        			<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
                        			<!-- 상세보기 갔다가 list 누르면 원래있던 검색 페이지로.-->
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
  
<!-- 댓글----------------------------------------------------------------------- -->
<style type="text/css">
	.chat{
		background: #eee;
		cursor: pointer;
	}
</style>
			<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Read Page</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           <i class="fa fa-comments fa-fw"></i>Ready
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<ul class="chat">
                        		<li class="left clearfix" data-rno='12'>
                        			<div>
	                        			<div class="header">
	                        				<strong class="primary-font">user00</strong>
	                        				<small class="pull-right text-muted">2022-01-01 12:12</small>
	                        			</div>
	                        			<p>댓글 테스트</p>
	                        		</div>	
                        		</li>
                        	</ul>
                        		
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

<script type="text/javascript" src="/resources/js/reply.js"></script>
<script>

	
$(document).ready(function(){
    var bnoValue = '<c:out value="${board.bno}"/>';
    var replyUL =$(".chat");
    console.log("replyUL : " + replyUL);
    
    showList(1);
    function showList(page){
       replyService.getList(
          {bno:bnoValue, page:page||1},
          function(list){
             var str="";
             if(list==null||list.length==0){
                replyUL.html("");
                return;
             }
             
             for(var i=0,len=list.length||0;i<len;i++){
                str += "<li class='left clearfix' data-rno='"+list[i].rno+"'>";
                str += "<div><div class='header'><strong class='primary-font'>"+list[i].replyer+"</strong>";
                str += "<small class='pull-right text-muted'>"+replyService.displayTime(list[i].replyDate)+"</small></div>";
                str += "<p>"+list[i].reply+"</p></div></li>"
             }//for
             
             replyUL.html(str);
             
          }//function(list)
          
       );//replyService.getList
       
    }//function showList(page)
    
 });//$(document).ready(function()
	
	/* replyService.add(
		{reply : "JS TEST2", replyer:"tester2", bno: bnoValue},
		function(result){
			alert("RESULT : " + result);
		}
	) */
	
	/* replyService.getList(
		{bno: bnoValue, page:1},
		function(list){
			for(var i = 0, len = list.length || 0; i<len; i++){
				console.log(list[i]);
			}
		}
	) */
	
	/* replyService.remove(42, function(result){
		console.log(result);
		if(result === "success"){
			alert("Removed");
		}
	},
		function(err){
			alert("Error");
		}
	);  */
	
	/* replyService.update(
			{rno: 41, reply: '수정내용..555555'},
			function(result){
				alert("수정 완료");
			}
		); */
	
	 /* replyService.get(41,function(data){
		   alert(data);
		   console.log(data);
	}); */	 

	
</script>
            
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