<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	request.setAttribute("path", request.getContextPath());
	request.setAttribute("jsPath", path+"/js");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详细信息</title>
</head>
<script type="text/javascript" src="${jsPath}/jquery.min.js"></script>
<script type="text/javascript">
	<c:if test="${!empty errorMessage}">
		$(function(){
			alert('${errorMessage}');
			window.location.href='${path}/auth/user/list';
		});
	</c:if>
	// 正常提交表单
	function userUpdate(){
		//使用js进行表单检查
		var userName = $("#userName").val();
		if($.trim(userName)==''){
			alert("用户名不能为空");
			return;
		}
		$("#userForm").submit();
	}
	//如果有封装ajax请求函数的时候，这个是响应后的处理函数，也是程序员真正需要写逻辑处理的函数
	function mydo($data){
		console.info($data);
		var code = $data.code;
		var message = $data.message;
		if(code==1){
			//修改成功
			//做你想做的事情，提示成功，跳转页面
		}else{
			//错误处理，根据你的需求文档处理
			alert(message);
		}
	}
	//使用ajax
	function userAjaxUpdate(){
		//使用js进行表单检查
		var userName = $("#userName").val();
		if($.trim(userName)==''){
			alert("用户名不能为空");
			return;
		}
		var userForm = $("#userForm");
		var url=userForm.attr("action");
		var params = userForm.serialize();
		console.info(params);
		$.post(url,params,function($data){
			console.info($data);
			var code = $data.code;
			var message = $data.message;
			if(code==1){
				//修改成功
				//做你想做的事情，提示成功，跳转页面
				alert("修改成功！");
				window.opener.search();
				/* var userSearchForm = window.opener.document.getElementById("userSearchForm");
				$(userSearchForm).submit();*/
				window.close(); 
				
			}else{
				//错误处理，根据你的需求文档处理
				alert(message);
			}
		},"json");
	}
</script>

<body>
	<form id="userForm" action="${path}/auth/user/ajax/update" method="post" >
		<input name="id" value="${info.id }" type="hidden"/>
		<table>
			<thead>
				<tr>
					<th>用户信息</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>用户名：</td>
					<td>
						<input type="text" id="userName" name="userName" value="${info.userName}"/>
					</td>
				</tr>
			</tbody>	
		</table>
		<input type="button" value="提交" onclick="userAjaxUpdate();"/>
	</form>
</body>
</html>