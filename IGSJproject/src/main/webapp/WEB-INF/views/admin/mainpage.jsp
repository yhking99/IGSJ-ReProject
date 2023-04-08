<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
}

.admin-menu{
	min-height: 601px;
}
</style>
</head>
<body>
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