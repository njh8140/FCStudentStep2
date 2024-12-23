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
	<h1>사용자 로그인</h1>
	<hr>
	<form action="login.do" method="post">
		이메일 : <input type="email" name="email" required><br>
		비밀번호 : <input type="password" name="pwd" required><br>
		<input type="submit" value="로그인">
		<input type="reset" value="취소">
	
	</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>