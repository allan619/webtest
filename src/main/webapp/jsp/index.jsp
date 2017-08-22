<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
</head>
<%
	request.setAttribute("path", request.getContextPath());
%>
<body>
<form id="userForm" action="${path}/auth_User_upload" enctype="multipart/form-data" method="post" target="frame">
		<label for="name">用户名：</label>
		<input type="text" name="name" id="name"/>
		<label for="age">年龄:</label>
		<input type="text" name="age" id="age"/>
		<input type="file" name="file"/>
		
		<input type="submit" value="提交">
	</form>
	<a href="${path}/auth_User_down">下载测试</a>
	<iframe name="frame" src=""></iframe>
</body>
</html>