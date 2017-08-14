<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
${request["name"]}
<h2>${user}</h2>aaaa${requestScope.name}
<ul>
	<li>requestScope.name:${requestScope.name}</li>
	<li>sessionScope.name:${sessionScope.name}</li>
	<li>applicationScope.name:${applicationScope.name}</li>
</ul>
</body>
</html>
