<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<div align="center">
<form action="login" method="post">
	工号：<input type="text" name="id" required/><br/> 
	密码：<input type="password" name="password" required/><br/>
	<input type="radio" name="role" value="teacher" checked>用户&nbsp;&nbsp;
	<input type="radio" name="role" value="admin">管理员&nbsp;&nbsp;<br/> 
	<input type="submit" value="提交">
	<input type="reset"><br />
</form>
</div>
</body>
</html>