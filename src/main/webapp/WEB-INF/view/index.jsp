<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
<h2>${user.name}</h2>${error}8888888${requestScope.name}
<ul>
	<li>requestScope.name:${requestScope.name}</li>
	<li>sessionScope.name:${sessionScope.name}</li>
	<li>applicationScope.name:${applicationScope.name}</li>
</ul>


</body>
</html>
