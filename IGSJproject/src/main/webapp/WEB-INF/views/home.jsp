<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>작업선택</h1>

	<P>The time on the server is ${serverTime}.</P>
	<ul>
		<li>
			<a href="/admin/managerLoginPage">관리자모드 로그인</a>
		</li>
		<li>
			<a href="/admin/mainpage">관리자 페이지</a>
		</li>
		<li>
			<a href="/seller/mainpage">판매자 페이지</a>
		</li>
	</ul>


	<br>
	<%=request.getRealPath("/")%>
</body>
</html>
