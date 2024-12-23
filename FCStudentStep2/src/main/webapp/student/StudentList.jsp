<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="java.util.ArrayList,vo.Student"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<jsp:include page="/Header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 목록</h1>
	<a href="add.do">신규등록</a>
	<hr>
	<c:forEach var="s" items="${requestScope.students}">
		${s.no}, 
		<a href="update.do?no=${s.no}">${s.name}</a>, 
		${s.email}, 
		${s.cre_date} <br>
	</c:forEach>
	
<jsp:include page="/Tail.jsp"/>
</body>
</html>