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
	<h1>학생 등록</h1>
	<hr>
	<form action="add.do" method="post">
		<table>
			<!-- <tr><th>no</th><td><input type="text" name="no"></td></tr> -->
			<tr><th>name</th><td><input type="text" name="name"></td></tr>
			<tr><th>email</th><td><input type="text" name="email"></td></tr>
			<tr><th>pwd</th><td><input type="password" name="pwd"></td></tr>
			<!-- <tr><th>cre_date</th><td><input type="text" name="cre_date"></td></tr> -->
			<!-- <tr><th>mod_date</th><td><input type="text" name="mod_date"></td></tr> -->
			<tr><th colspan="2">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</th></tr>
		</table>
	</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>