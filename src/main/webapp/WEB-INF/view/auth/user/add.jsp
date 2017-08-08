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
	//使用ajax
	function userAdd(){
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
				alert("添加成功！")
				window.location.href='${path}/auth/user/list';
			}else{
				//错误处理，根据你的需求文档处理
				alert(message);
			}
		},"json");
	}
	
	function ajaxAdd(){
		var url = "http://127.0.0.1:8888/user/fastJson";
		$.post(url,null,function($data){
			console.info($data);
			alert(typeof($data));
			var code = "var user="+$data;
			alert(code);
			eval(code);
			alert(user.name);
		},"json");
	}
</script>

<body>
	<form id="userForm" action="${path}/auth/user/add" method="post" >
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
						<input type="text" id="userName" name="userName" />
					</td>
				</tr>
			</tbody>	
		</table>
		<input type="button" value="提交" onclick="userAdd();"/>
		<input type="button" value="ajax" onclick="ajaxAdd();"/>
	</form>
</body>
</html>