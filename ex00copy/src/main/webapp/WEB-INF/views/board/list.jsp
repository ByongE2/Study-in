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
                           Board List Page
                           <button id="regBtn" type="button" class="btn btn-xs pull-right">등록화면</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" >
                                <thead>
                                    <tr>
                                        <th>#번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>변경일</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${list}" var="board">
                                    <tr class="odd gradeX">
                                        <td><c:out value="${board.bno}"/></td>
                                        <td>
                                        	<a class="move" href=<c:out value="${board.bno}"/>>
                                        		<c:out value="${board.title}"/>
                                        	</a>
                                        </td>
	                               <%-- <td>
                                        	<a href="/board/get?bno=<c:out value="${board.bno}"/>">
                                        		<c:out value="${board.title}"/>
                                        	</a>
                                        </td> --%>
                                        <td><c:out value="${board.writer}"/></td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}"/></td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
                                    </tr>
                                </c:forEach>
                            </table>
                             <!-- /.table-responsive -->
                             <!-- 검색 조건 Start -->
                             <form id="searchForm" action="/board/list" method="get">
                             	<select name='type'>
                             							<!-- 서칭조건이 처음엔 null, 한번 선택하면 그 기록 남게끔. 제목 서칭 후에, 조건에 그대로 제목 남게끔. -->
                             		<%-- <option value=" " <c:out value="${pageMaker.cri.type == null ? 'selected' : '' }"/>>--</option> --%>
                             		<option value="" <c:out value="${pageMaker.cri.type == null ? 'selected' : '' }"/>>--</option>
                             		<option value="T" <c:out value="${pageMaker.cri.type == 'T' ? 'selected' : '' }"/>>제목</option>
                             		<option value="C" <c:out value="${pageMaker.cri.type eq 'C' ? 'selected' : '' }"/>>내용</option>
                             		<option value="W" <c:out value="${pageMaker.cri.type == 'W' ? 'selected' : '' }"/>>작성자</option>
                             		<option value="TC" <c:out value="${pageMaker.cri.type == 'TC' ? 'selected' : '' }"/>>제목+내용</option>
                             		<option value="TW" <c:out value="${pageMaker.cri.type == 'TW' ? 'selected' : '' }"/>>제목+작성자</option>
                             		<option value="TCW" <c:out value="${pageMaker.cri.type == 'TCW' ? 'selected' : '' }"/>>제목+내용+작성자</option>
                             	</select>
                             	<input type="text"  name="keyword" placeholder="검색 입력" onfocus="this.placeholder=''" onblur="this.placeholder='검색 입력'"/>
                             	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}"/>
                             	<input type="hidden" name="amount" value="${pageMaker.cri.amount}"/>
                             	<button class="btn btn-default">Search</button>
                             </form>
                             <!-- 검색 조건 End -->
                            <!-- 페이지 처리 start -->
                            	<div class="pull-right">
								  <ul class="pagination">
								  
								  <c:if test="${pageMaker.prev}">
								    <li class="paginate_button previous"><a href="${pageMaker.startPage-1}">Previous</a></li>
								  </c:if>
								  
								  <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
								  <!-- 페이지 하이라이트 추가. 3항 연산자 -->
								  	<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active" : ""}">
								  	<a href="${num}">${num}</a></li>
								  </c:forEach>
								  
								  <c:if test="${pageMaker.next}">
								    <li class="paginate_button next"><a href="${pageMaker.endPage+1}">Next</a></li>
								  </c:if>
								  </ul>
								</div>
								<!-- 페이지 처리 End -->
								<form id="actionForm" action="/board/list" method="get">
									<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
									<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
									<!-- 페이징 처리 후, 검색 한 것을 다시 페이징 하기 위해. -->
									<input type="hidden" name="type" value="${pageMaker.cri.type}">
									<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
								</form>
                           
                            <!--Modal 창 추가 -->
				
				<div id="myModal" class="modal" tabindex="-1" role="dialog">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Modal title</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								처리가 완료됬습니다.
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary">Save
									changes</button>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
				<!--Modal 창 닫기 -->



			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<script>
	$(document).ready(function() {
		var result = '<c:out value="${result}"/>';
		console.log("result" + result);
		
		checkModal(result);
		/* unDo 했을 때 모달 창도 같이 뜨는거, stack(page남은 기록들이 stack으로 저장)에서 지우는 법*/
		history.replaceState({},null,null);
		
		function checkModal(result){
			if(result === '' || history.state){
				return ;				
			}
			
			if(parseInt(result) > 0){
				$(".modal-body").html("게시글 " + parseInt(result) + "번이 등록되었습니다.");
			}
			
			$("#myModal").modal("show");
		}
		
		$("#regBtn").on("click",function(){
			self.location = "/board/register";
		});
		
		// hidden에서 pageNum,amount 값 클릭하면 넘겨주기
		var actionForm = $("#actionForm");
		$(".paginate_button a").on("click", function(e){ //버튼 a태그 클릭하면 넘어가는거
		  e.preventDefault(); //막고
		  console.log('click'); //로그 찍고
		  actionForm.find("input[name='pageNum']").val($(this).attr("href")); // ${num}값을 "herf"에 넣어라.
		  actionForm.submit();
		});
		
		$(".move").on("click", function(e){
			   e.preventDefault();
			   actionForm.append("<input type = 'hidden' name = 'bno' value = '"+$(this).attr("href")+"'>");
			   actionForm.attr("action","/board/get");
			   actionForm.submit();
			});
		
		var searchForm = $("#searchForm");
		$("#searchForm button").on("click", function(e){
			e.preventDefault();
			
			//검색종류 아무것도 없을 때 알림.
			if(!searchForm.find("option:selected").val()){
				alert("검색종류를 입력하세요.")
				return false;
			}
			
			//검색 입력안하면 키워드.
			if(!searchForm.find("input[name='keyword']").val()){
				alert("키워드를 입력하세요.")
				return false;
			}
			//검색하는 페이지에서 검색결과가 pageNum만큼 있는곳으로 가는문제를, 강제로 pageNum=1로 바꿔줌.
			searchForm.find("input[name = 'pageNum']").val("1");
			searchForm.submit();
		})
		
	});
</script>

<%@ include file="../includes/footer.jsp"%>