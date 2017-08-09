<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	request.setAttribute("path", request.getContextPath());
	request.setAttribute("jsPath", path+"/js");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<script type="text/javascript" src="${jsPath}/jquery.min.js"></script>
<script type="text/javascript">
	var x = 4;
	alert(x);
	function test(){
		x = 5;
		y = 3;
	}
	
	alert(x);
	test();
	alert(y);
	function myUpdate(id){
		//alert(id);
		var url = "${path}/auth/user/detail?id="+id;
		window.open(url,"userdetail");
	}
	
	function search(){
		$("#pageNum").val(1);
		$('#userSearchForm').submit();
	}
	
	function goPage(pageNum){
		$("#pageNum").val(pageNum);
		$('#userSearchForm').submit();
	}
</script>
<body>
	<form id="userSearchForm" action="${path}/auth/user/list" method="get">
		<label for="name">用户名：</label><input type="text" name="userName" id="name" value="${userInfoVo.userName}"/>
		<label for="begin">创建时间</label><input type="text" value="${userInfoVo.beginDate}" name="beginDate" id="begin"/>--<input type="text" name="endDate" value="${userInfoVo.endDate}" id="begin"/>
		<br/>
		<input type="hidden" id="pageNum" name="pageNum" value="${userInfoVo.pageNum}"/> 
		<input type="button" value="查询" onclick="search()"/>
	</form>
	<span style="color: red">${errorMessage}</span>
	<a href='${path}/auth/user/showAdd'>添加</a>
	<table>
		<thead>
			<tr>
				<th>序号</th>
				<th>用户名</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${userList}" var="user" varStatus="status">
			<tr>
				<td>${status.index+1}</td>
				<td>${user.userName }</td>
				<td>${user.createDateStr}|<fmt:formatDate value="${user.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
					<a href="${path}/auth/user/del?id=${user.id}">删除</a> 
					<a href="${path}/auth/user/detail?id=${user.id}">修改</a>
					<input type="button" value="修改2" onclick="myUpdate('${user.id}')"/>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<a href="javaScript:void(0)" onclick="goPage(${userInfoVo.pageNum-1})">上一页</a>,<a href="javascript:void(0)" onclick="goPage(${userInfoVo.pageNum+1})">下一页</a>第<input id="myPageNum" value="${userInfoVo.pageNum}"/>页 
	<a href="javaScript:void(0)" onclick="goPage($('#myPageNum').val())">跳转</a>
	<br>
	不能保留查询条件的方式
	<a href="${path}/auth/user/list?pageNum=${userInfoVo.pageNum-1}">上一页</a> ，<a href="${path}/auth/user/list?pageNum=${userInfoVo.pageNum+1}">下一页</a> 
</body>
</html>