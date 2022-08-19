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
<!-- 댓글 모달창 시작 -->
  <!-- Modal -->
<div id="myModal" class="modal fade" role="dialog" tabindex="-1"> <!--tabindex="-1"는 화면 모달 창이 제일 앞으로 ..  -->
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Reply Modal</h4>
      </div>
      <div class="modal-body">
		<div class="form-group">
			<label>Reply</label>
			<input class="form-control" name="reply" value="new replyer">
		</div>
		<div class="form-group">
			<label>Replyer</label>
			<input class="form-control" name="replyer" value="replyer">
		</div>
		<div class="form-group">
			<label>Reply Date</label>
			<input class="form-control" name="replyDate" value="">
		</div>
      </div>
      <div class="modal-footer">
      	<button id="modalModBtn" type="button" class="btn btn-warning">Modify</button>
      	<button id="modalRemoveBtn" type="button" class="btn btn-danger">Remove</button>
      	<button id="modalRegisterBtn" type="button" class="btn btn-info">Register</button>
        <button id="modalCloseBtn" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
<!-- 댓글 모달창 끝 -->  
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
                           <button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">New Reply</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<ul class="chat">
                        		<!-- <li class="left clearfix" data-rno='12'>
                        			<div>
	                        			<div class="header">
	                        				<strong class="primary-font">user00</strong>
	                        				<small class="pull-right text-muted">2022-01-01 12:12</small>
	                        			</div>
	                        			<p>댓글 테스트</p>
	                        		</div>	
                        		</li> 이벤트 위임 해서 동적인것으로 처리.-->
                        	</ul>
                        		
                        </div>
                        <!-- /.panel-body -->
                       	<div class="panel-footer">
                       		
                       	</div>
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

<script type="text/javascript" src="/resources/js/reply.js?ver=2"></script>
<script>

	
$(document).ready(function(){
    var bnoValue = '<c:out value="${board.bno}"/>';
    var replyUL =$(".chat");
    console.log("replyUL : " + replyUL);
    
    showList(1);
    
    // 댓글 modal창 연결
    var modal = $("#myModal");
    var modalInputReply = modal.find("input[name='reply']");
    var modalInputReplyer = modal.find("input[name='replyer']");
    var modalInputReplyDate = modal.find("input[name='replyDate']");
    
    var modalModBtn = $("#modalModBtn");
    var modalRemoveBtn = $("#modalRemoveBtn");
    var modalRegisterBtn = $("#modalRegisterBtn");
    
    //삭제
    modalRemoveBtn.on("click", function(e){
    	var rno = modal.data("rno");
    	replyService.remove(rno, function(result){
    		alert("result : " + result)
    		modal.modal("hide");
    		showList(pageNum);
    	});
    	
    });//remove
    
    //수정
    modalModBtn.on("click", function(e){
    	var reply = {
    			rno : modal.data("rno"),
    			reply : modalInputReply.val()
    	};
    	replyService.update(reply, function(result){
    		alert("result : " + result)
    		modal.modal("hide");
    		showList(pageNum);
    	});
    });//Modify    
    
    $("#addReplyBtn").on("click", function(){
    	modal.find("input").val("");  //input태그의 value를 ""로 초기화
    	modalInputReplyDate.closest("div").hide();
    	modal.find("button[id !='modalCloseBtn']").hide();
    	
    	modalRegisterBtn.show();
    	
    	$("#myModal").modal("show");
    });
    
    //등록
    modalRegisterBtn.on("click", function(e){
    	var replys = { //자바스크립트 key : value 객체 생성.
    			reply : modalInputReply.val(),
    			replyer : modalInputReplyer.val(),
    			bno : bnoValue
    	}
    	
    	replyService.add(replys, function(result){
    		alert("result : " + result);
    		modal.find("input").val("");
    		modal.modal("hide");
    		showList(-1); //등록 후 알람창 끄면 바로 추가되게끔.
    		
    	})// replyService.add
    	
    })//Register 
  
    
    //이벤트위임 시작(댓글 클릭 시) 어떤 댓글이 올지 모르니 위임으로 처리.
    $(".chat").on("click","li", function(){
    	var rno = $(this).data("rno"); //data()메서드이용해서 rno 가져옴.
		
    	replyService.get(rno, function(reply){
    		modalInputReply.val(reply.reply);
    		modalInputReplyer.val(reply.replyer);
    		//modalInputReplyDate.val(reply.Date)//수정예정
    		modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly", "readonly"); //수정불가하게.
    		modal.data("rno", reply.rno);
    		
    		modal.find("button[id !='modalClassBtn']").hide();
    		modalModBtn.show();
    		modalRemoveBtn.show();
    		
    		$("#myModal").modal("show");
    	});
    });
    //이벤트위임 끝
    function showList(page){
    	
    	replyService.getList(
          {bno:bnoValue, page:page||1},
          function(replyCnt, list){
        	 //댓글 추가하면 댓글 마지막에 page로 가게끔.
        	 if(page == -1){
        		 pageNum = Math.ceil(replyCnt/10.0);
        		 showList(pageNum);
        		 return ;
        	 } 
        	  
             var str="";
             if(list==null||list.length==0){
                //replyUL.html("");
                return;
             }
             
             for(var i=0,len=list.length||0;i<len;i++){
                str += "<li class='left clearfix' data-rno='"+list[i].rno+"'>";
                str += "<div><div class='header'><strong class='primary-font'>"+list[i].replyer+"</strong>";
                str += "<small class='pull-right text-muted'>"+replyService.displayTime(list[i].replyDate)+"</small></div>";
                str += "<p>"+list[i].reply+"</p></div></li>"
             }//for
             
             replyUL.html(str);
             showReplyPage(replyCnt);
             
          }//function(list)
          
       );//replyService.getList
       
    }//function showList(page)
    
    //댓글 페이지 출력 부분
    var pageNum = 1;
    var replyPageFooter = $(".panel-footer");
    
    function showReplyPage(replyCnt){
    	var endNum = Math.ceil(pageNum/10.0)*10;
    	var startNum = endNum -9;
    	
    	var prev = startNum != 1;
    	var next = false;
    	
    	if((endNum * 10) >= replyCnt){
    		next = true;
    	}

    	var str = "<ul class='pagination pull-right'>";
    	if(prev){
    		str += "<li class='page-item'><a class='page-link' href='"+ (startNum-1)  +" '>Previous</a></li>"; 
    	}
    	for(var i = startNum; i<= endNum; i++){
    		var active = pageNum == i ? "active" : "";
    		str += "<li class='page-item " + active + " '><a class='page-link' href='"+ i +" '>" + i + "</a></li>"; 
    	}
    	if(next){
    		str += "<li class='page-item'><a class='page-link' href='"+ (endNum-1)  +" '>Next</a></li>";
    	}
    	
    	str +="</ul></div>";
    	
    	replyPageFooter.html(str);
    }//end showReplyPage
    
    replyPageFooter.on("click","li a", function(e){
        e.preventDefault();
        console.log("page click");
        
        var targetPageNum = $(this).attr("href");
        
        console.log("targetPageNum: " + targetPageNum);
        
        pageNum = targetPageNum;
        
        showList(pageNum);
   });    //end replyPageFooter
    
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