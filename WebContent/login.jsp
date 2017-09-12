<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form action="/ShiXun09/admin?method=login" method="post">
			  <div class="form-group">
			    <label for="exampleInputEmail1">用户名</label>
			    <input name="name" class="form-control" id="exampleInputEmail1">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail1">密码</label>
			    <input name="password" class="form-control" id="exampleInputEmail1">
			  </div>
			  <button type="submit" class="btn btn-default">登陆</button>
		</form>
	</div>
</body>
</html>