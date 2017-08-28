<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ognl</title>
</head>
<body>
<s:property value="%{point}"/>
<s:property value="%{#request}"/>
<s:debug/>
${point}
<%
	Map<String,String> map = new HashMap<String,String>();
	map.put("user.one", "one");
	map.put("name", "accp");
	request.setAttribute("map.map", map);
%>
${map['user.one']}
${map['user.one']}
${requestScope['map.map']}
</body>
</html>