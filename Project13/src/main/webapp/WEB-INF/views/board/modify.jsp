<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	$(document).ready(function(){
		
		var formObj = $("form"); 
		
		$("button").on("click", function(e){
			
			e.preventDefault();
		
			var operation = $(this).data("oper");
			
			console.log(operation); 
			
			if(operation === "remove"){
		
				formObj.attr("action", "${contextPath}/board/remove");
		
			}else if(operation === "list"){
				//self.location = "/board/list"; 
				formObj.attr("action", "${contextPath}/board/list").attr("method","get");
				formObj.empty();
				return ; 
			}
			
			formObj.submit();
		});
	});	
	


</script>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Read</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Read</div>
      <!-- /.panel-heading -->
      <div class="panel-body">
		
		<form role="form" action="${contextPath}/board/modify" method="post">
          <div class="form-group">
            <label>Index</label> <input class="form-control" name='bno' 
            value='<c:out value="${board.bno}"/>' readonly="readonly">
          </div>

		
          <div class="form-group">
            <label>Title</label> <input class="form-control" name='title'
            value='<c:out value="${board.title}"/>'>
          </div>

          <div class="form-group">
            <label>Text area</label>
            <textarea class="form-control" rows="3" name='content'><c:out value="${board.content}"/></textarea>
          </div>

          <div class="form-group">
            <label>Writer</label> <input class="form-control" name='writer' readonly="readonly"
            value='<c:out value="${board.writer}"/>'>
          </div>

	
			<div class="form-group">
			  <label>RegDate</label> 
			  <input class="form-control" name='regDate'
			    value='<fmt:formatDate pattern = "yyyy-MM-dd" value = "${board.regDate}" />'  readonly="readonly">            
			</div>
			
			<div class="form-group">
			  <label>Update Date</label> 
			  <input class="form-control" name='updateDate'
			    value='<fmt:formatDate pattern = "yyyy-MM-dd" value = "${board.updateDate}" />'  readonly="readonly">            
			</div>
          
          <button type="submit" data-oper="modify" class="btn btn-default">Modify</button>
          <button type="submit" data-oper="remove" class="btn btn-danger">Remove</button>
          <button type="submit" data-oper="list" class="btn btn-info">List</button>
      	</form>

      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp"%>
