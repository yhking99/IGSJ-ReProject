<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소비자 페이지</title>
</head>
<style>
* {
	margin: 0;
}

.header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	width: 100%;
	height: 30px;
	background: black;
	padding: 20px;
}

.header_container {
	display: flex;
	justify-content: left;
	align-items: center;
	padding: 0;
}

.logo span {
	color: white;
	font-size: 40px;
	margin-right: 20px;
	text-decoration: none;
}

.login_info p {
	color: white;
	font-size: 20px;
	margin-left: 20px;
	text-decoration: none;
}

.menu {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-right: 40px;
}

.menu ul {
	list-style: none;
	padding-left: 30px;
}

.menu a {
	text-decoration: none;
	color: white;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
}
</style>
<body>
	<div class="header">
		<div class="header_container">
			<div class="logo">
				<span>IGSJ</span>
			</div>
			<div class="login_info">
				<p>판매자 seller 님이 로그인중입니다.</p>
			</div>
		</div>
		<div class="menu">
			<ul>
				<li><a href="/seller/productlist?pageNum=1">상품목록</a></li>
			</ul>
			<ul>
				<li><a href="#">아직미정</a></li>
			</ul>
			<ul>
				<li><a href="#">아직미정</a></li>
			</ul>
		</div>
	</div>

</body>
</html>