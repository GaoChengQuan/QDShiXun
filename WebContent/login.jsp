<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	.form-signin {
	    max-width: 330px;
	    padding: 15px;
	    margin: 0 auto;
	}
</style>
</head>
<body>
	<div class="container">
		<form class="form-signin" action="/ShiXun09/login?method=login" method="post">
			  <div class="form-group">
			    <label for="exampleInputEmail1">用户名</label>
			    <input name="name" class="form-control" id="exampleInputEmail1">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail1">密码</label>
			    <input name="password" class="form-control" id="exampleInputEmail1">
			  </div>
			  <button type="submit" class="btn btn-lg btn-primary btn-block">登陆</button>
		</form>
	</div>
</body>
</html>