<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@page import="com.situ.student.pojo.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<!-- 顶部导航条 begin -->
	<nav class="navbar navbar-default">
	  <div class="container">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">教务管理系统</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;学生管理 </a></li>
	        <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;班级管理</a></li>
	        <li><a href="#"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;课程管理</a></li>
	        <li><a href="#"><span class="glyphicon glyphicon-tag"></span>&nbsp;&nbsp;教务管理</a></li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <%
	        	Admin admin = (Admin)session.getAttribute("admin");
	       		if(admin != null) {
	        %>
	        	<li><a href="#"><%=admin.getName()%></a></li>
	        <%
	       		}
	        %>
	        <li><a href="/ShiXun09/login?method=logout"><span class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;退出</a></li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	<!-- 顶部导航条 end -->
	
	<!-- 中间内容部分 begin -->
	<div class="container">
		<div class="row">
			<!--左边列表占12份中的2份-->
			<div class="col-md-2">
				<div class="list-group">
				   <a href="/ShiXun09/student?method=findAll" class="list-group-item">学生管理</a>
				  <a href="student_search.jsp" class="list-group-item  active">学生搜索</a>
				  <a href="/ShiXun09/student?method=getAddPage" class="list-group-item">添加学生</a>
				</div>
			</div>
			<!--左边列表占12份中的10份-->
			<div class="col-md-10">
				<ul class="nav nav-tabs">
				  <li role="presentation"><a href="/ShiXun09/student?method=findAll">学生管理</a></li>
				  <li role="presentation"  class="active"><a href="student_search.jsp">学生搜索</a></li>
				  <li role="presentation"><a href="/ShiXun09/student?method=getAddPage">添加学生</a></li>
				</ul>
				<!-- 搜索开始 -->
				<form action="/ShiXun09/student?method=searchByName" method="post">
				  <div class="form-group">
				    <label for="exampleInputEmail1">根据名字搜索</label>
				    <input name="name" class="form-control" id="exampleInputEmail1">
				  </div>
				  <button type="submit" class="btn btn-default">搜索</button>
				</form>
				<!-- 搜索结束 -->
				
				<table class="table  table-condensed table-hover">
					<thead>
						<td>id</td>
						<td>名字</td>
						<td>年龄</td>
						<td>性别</td>
						<td>地址</td>
					</thead>
					<%
						List<Student> list = (List<Student>)request.getAttribute("list");
					%>
					<%
						if (list != null) {
							for(Student student : list){
					%>
							<tr>
								<td><%=student.getId() %></td>
								<td><%=student.getName() %></td>
								<td><%=student.getAge() %></td>
								<td><%=student.getGender() %></td>
								<td><%=student.getAddress() %></td>
							</tr>
					<%
						    }
						}
					%>
				</table>
				
			</div>
		</div>
	</div>
	<!-- 中间内容部分 end -->
	
</body>
</html>