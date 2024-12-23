<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/Header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 정보 수정</h1>
	<hr>
	<form action="update.do" method="post">
		<table>
		<tr><th>no</th><td><input type="text" name="no" value="${requestScope.student.getNo()}" readonly></td></tr>
		<tr><th>name</th><td><input type="text" name="name" value="${requestScope.student.getName()}"></td></tr>
		<tr><th>email</th><td><input type="text" name="email" value="${requestScope.student.getEmail()}"></td></tr>
		<tr><th>pwd</th><td><input type="password" name="pwd" value="${requestScope.student.getPwd()}"></td></tr>
		<tr><th>cre_date</th><td><input type="date" name="cre_date" value="${requestScope.student.getCre_date()}" readonly></td></tr>
		<tr><th>mod_date</th><td><input type="date" name="mod_date" value="${requestScope.student.getMod_date()}" readonly></td></tr>
		<tr><th colspan="2">
			<input type="submit" value="수정">
			<input type="reset" value="취소">
			<input type="button" value="삭제" onclick='location.href="delete.do?no=${requestScope.student.getNo()}"'>
			</th></tr>
		</table>
	</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>