<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
 <%
 	String path = request.getContextPath();
 	request.setAttribute("path", path);
 	request.setAttribute("jsPath", path+"/js");
 	request.setAttribute("imagePath", path+"/images/");
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<script type="text/javascript" src="${jsPath}/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		//alert(1);
	});
	function addUser(){
		var url="${path}/user/ajax";
		var params = $("#userForm").serialize();
		console.info(params);
		$.post(url,params,function($data){
			console.info($data);
		},"json");
	}
	
</script>
<body>
	${requestScope["org.springframework.validation.BindingResult.user"]}
	<form id="userForm" action="abc/def" >
		<label for="name">用户名：</label>
		<input type="text" name="name" id="name"/>
		<label for="age">年龄:</label>
		<input type="text" name="age" id="age"/>
		<input type="button" onclick="addUser();" value="提交">
		
	</form>
	<fm:form method="post" modelAttribute="user" action="${path}/user/upload" enctype="multipart/form-data">
		<fm:label path="" for="name2">用户名：</fm:label>
		<fm:input path="name" id="name2"/>
		<fm:errors path="name"></fm:errors>
		<fm:label path="" for="ages">年龄：</fm:label>
		<fm:input path="age" id="ages"/>
		<fm:errors path="age"></fm:errors>
		A:<input type="file" name="file" />
		B:<input type="file" name="file2" />
		<fm:button>保存</fm:button>	
	</fm:form>
	${age}
	<% 
		request.setAttribute("names",request.getAttributeNames());
	%>
	<ul>
	<%-- <c:forEach var="x" items="${names}">
		<li>${x}</li>
	</c:forEach> --%>
	</ul>
</body>
</html>