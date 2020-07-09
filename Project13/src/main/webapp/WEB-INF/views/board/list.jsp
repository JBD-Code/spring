<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file = "../includes/header.jsp" %>	
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
                        <div class="panel-heading">Board List</div>
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
                         </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
            <%@include file = "../includes/footer.jsp" %>	
      