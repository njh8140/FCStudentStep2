<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시스템 오류!</title>
</head>
<body>
	<p>요청 처리 중 문제가 발생.
	 잠시 후 다시 요청 바람.</p>
	 <p>
	 	<% Exception e = (Exception)request.getAttribute("error"); %>
	 	<%= e.getMessage() %>
	 </p>
</body>
</html>