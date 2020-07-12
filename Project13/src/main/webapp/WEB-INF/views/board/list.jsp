<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file = "../includes/header.jsp" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


	
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
                        <div class="panel-heading">Board List
                        	<button id = "regBtn" type="button" class="btn btn-xs pull-right">Register </button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Index</th>
                                        <th>Title</th>
                                        <th>Writer</th>
                                        <th>WriteDate</th>
                                        <th>UpdateDate</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="board">
                                <tr>
                                	<td><c:out value="${board.bno}"/></td>	
                                	<td><c:out value="${board.title}"/></td>	
                                	<td><c:out value="${board.writer}"/></td>
                                	<td><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd"/>	
                                	<td><fmt:formatDate value="${board.updateDate}" pattern="yyyy-MM-dd"/>	
                                </tr>
                                </c:forEach>
                            </table>
                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            	<div class="modal-dialog">
                            		<div class="modal-content">
                            			<div class="modal-header">
                            				<button type="button" class="close" data-dimiss="modal" aria-hidden="true">&time;</button>
                            				<h4 class="modal-title" id="myModalLabel">Modal Title</h4>
                            			</div>
                            			<div class="modal-body">처리가 완료되었습니다 </div>
                            			<div class="modal-footer">
                            				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            				<button type="button" class="btn btn-primary">Save Change</button>
                            			</div>
                            		</div>
									<!-- .Modal Content -->                            	
                            	</div>
								<!-- .Modal-dialog -->                            
                            </div>
                            <!-- .Modal -->
                         </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->

      		<script type="text/javascript">
				$(document).ready(function(){
					var result = '<c:out value="${result}"/>'; 
					
					checkModal(result);
					
					function checkModal(result){
						if(result==""){
							return; 
						}
						
						if(parseInt(result)>0){
							$(".modal-body").html("게시글" + parseInt(result) + "번이 등록되었습니다.");				
						
						}
						$("#myModal").modal("show");
					}
					$("#regBtn").on("click", function(){
						self.location ="${contextPath}/board/register";
					});
				});
      		
      		</script>	
            <%@include file = "../includes/footer.jsp" %>	
      		<!-- //-->
