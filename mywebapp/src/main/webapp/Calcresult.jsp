<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator using JSP</title>
</head>
<body bgcolor=gray>
<blink>Result : <%= request.getParameter("n1") %> <%=request.getParameter("op") %> <%= request.getParameter("n2") %> = <%= request.getAttribute("result") %></blink>


</body>
</html>