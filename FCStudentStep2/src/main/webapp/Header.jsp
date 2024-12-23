<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%-- <jsp:useBean id="student" class="vo.Student" scope="session"/> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#header{
		background-color: #72C2E4;
		color : blue;
		height : 20px;
		padding : 5px;
	}
</style>
</head>
<body>
	<%-- <div id="header">WPMS(Web Project Management System)
	
	<% if(student.getName() != null) { %>
		<span style="float:right;">
			${sessionScope.student.name} 
			<a style="color:white;" href="<%=request.getContextPath()%>/auth/logout" >logout</a>
		</span>
	<% } else {%>
	<span style="float:right;">
			<a style="color:white;" href="<%=request.getContextPath()%>/auth/login" >login</a>
		</span>
	<%} %>
	
	</div> --%>
	<div id="header">WPMS(Web Project Management System)
	
	<c:choose>
		<c:when test="${not empty sessionScope.student}">
			<span style="float:right;">
				<a style="color:white;" href="<%=request.getContextPath()%>/auth/logout.do" >logout</a>
			</span>
		</c:when>
		<c:when test="${empty sessionScope.student}">
			<span style="float:right;">
				<a style="color:white;" href="<%=request.getContextPath()%>/auth/login.do" >login</a>
			</span>
		</c:when>
	</c:choose>
	</div>
</body>
</html>