<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<style type="text/css">
/*헤더*/
*{
	margin: 0;
	padding: 0;
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



.admin-menu{
	min-height: 601px;
}
</style>
</head>
<body>
<!-- 헤더 -->
	<div class="header">
		<div class="header_container">
			<div class="logo">
				<span>IGSJ</span>
			</div>
			<div class="login_info">
				<c:choose>
				<c:when test="${member == null }">
					<p>관리자 로그인이 되어있지 않은 상태입니다.</p>
				</c:when>
				<c:otherwise>
					<p>관리자 ${member.userId } 님이 로그인중입니다.</p>
				</c:otherwise>
			</c:choose>
			</div>
		</div>
		<div class="menu">
			<ul>
				<li><a href="/admin/memberlist?pageNum=1">회원관리페이지</a></li>
			</ul>
			<ul>
				<li><a href="/admin/productlist?pageNum=1">상품관리페이지</a></li>
			</ul>
			<ul>
				<li><a href="#">아직미정</a></li>
			</ul>
		</div>
	</div>

<!--  -->
	<div class="admin-menu">
		<h1 align="right">
			<c:choose>
				<c:when test="${member == null }">
					관리자 로그인이 되어있지 않은 상태입니다.
				</c:when>
				<c:otherwise>
					관리자 ${member.userId } 님이 로그인중입니다.
				</c:otherwise>
			</c:choose>
		</h1>

		<ul>
			<li>
				<a href="/admin/admindetail">
					<img src="/resources/pageImg/adminLogo.png" alt="관리자페이지로고" width="500" height="500">
				</a>
			</li>
		</ul>
	</div>
	
	<jsp:include page="../pageIngredient/footer.jsp"></jsp:include>
</body>
</html>