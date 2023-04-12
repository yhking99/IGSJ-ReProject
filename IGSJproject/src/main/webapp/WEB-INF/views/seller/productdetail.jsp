<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${productInfo.product_name }</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/36.0.0/classic/ckeditor.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
<link rel="stylesheet" href="/resources/Outer/admin/css/adminProductDetail.css">
</head>
<style>
/*헤더*/
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

/*상품정보*/
.product-title{

}
</style>
<body>
	<!-- 헤더 -->
	<div class="header">
		<div class="header_container">
			<div class="logo">
				<span>IGSJ</span>
			</div>
			<div class="login_info">
				<p>판매자 ${member.userId } 님이 로그인중입니다.</p>
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

	<!-- 상품 정보 -->
	<div class="product-title">
		<h2 style="padding-top: 40px">${productInfo.product_name }</h2>
	</div>
	<div class="single-product" align="center">
		<div class="inner-product">
			<div class="img-box">
				<img id="resultimg" src="${productInfo.storedFileRootName }" alt="상품 이미지 로딩 실패">
			</div>

			<div class="product-info">
				<div class="explan_product product_info_section" align="left">
					<h3 class="title-box font-mss">
						Product Info
						<span class="korSub">
							&#47;&nbsp;<font size="2">제품정보</font>
						</span>
					</h3>
					<ul class="product_article">
						<li>
							<p class="product_article_tit">품번</p>
							<p class="product_article_contents">
								<strong>${productInfo.pno }</strong>
							</p>
						</li>
						<li>
							<p class="product_article_tit">
								<span class="tooltip">
									<a class="ui-toggle-btn"> 시즌 </a>
								</span>
								<span class="txt_unit2">&#47;</span>
								성별
							</p>
							<p class="product_article_contents">
								<strong> 2023 S/S </strong>
								<span class="txt_unit2">&#47;</span>
								<span class="txt_gender">
									<strong>남</strong>
								</span>
							</p>
						</li>

						<li>
							<p class="product_article_tit">
								<span class="tooltip">
									<a class="ui-toggle-btn"> 남은재고 </a>
								</span>
							</p>
							<p class="product_article_contents">
								<span class="txt_gender">
									<strong>${productInfo.product_stock }</strong>
								</span>
							</p>
						</li>

						<li class="article-tag-list list">
							<p class="product_article_tit">
								<span class="tooltip"> 상품 판매자 </span>
							</p>
							<p class="product_article_contents">
								<span class="provider">
									<strong title="판매자에게 문의하기"><a href="#">${productInfo.userId }</a></strong>
								</span>
							</p>
						</li>
					</ul>
				</div>
				<!--//제품정보-->

				<!-- 가격정보 -->
				<div class="explan_product price_info_section" align="right">
					<h3 class="title-box font-mss">
						Price Info
						<span class="korSub">
							&#47;&nbsp;<font size="2">가격정보</font>
						</span>
					</h3>
					<ul class="product_article">
						<li class="box_info_products">
							<p class="product_article_tit" align="left">IGSJ 판매가</p>
							<p class="product_article_contents">
								<span class="product_article_price" id="goods_price">
									<!-- <del class="price-del">59,000원</del> -->
									<!-- del : 취소선 -->
									<span class="prouct-price">
										<font size="5"> <b><fmt:formatNumber value="${productInfo.product_price }" pattern="###,###,###"></fmt:formatNumber></b> 원
										</font>
									</span>
								</span>
							</p>
						</li>
					</ul>
				</div>
			</div>
			<!-- ck데이터 적용구역 -->
			<div class="product-description-area">
				<div class="inputArea">
					<h3 class="title-box font-mss">
						Product Description
						<span class="korSub">
							&#47;&nbsp;<font size="2">상품소개</font>
						</span>
					</h3>
					<textarea id="product_description" name="product_description">${productInfo.product_description }</textarea>
				</div>

				<div class="admin-btn-box" align="right">
					<a href="/seller/productmodify?pno=${productInfo.pno }">
						<button class="admin-pro-btn pro-modify">
							<b>상품정보수정</b>
						</button>
					</a>
					&emsp;
					<a href="javascript:RemoveProduct('${productInfo.pno }')">
						<button class="admin-pro-btn pro-del" >
							<b>상품삭제</b>
						</button>
					</a>
					&emsp;
					<a href="/seller/productlist?pageNum=1">
						<button class="admin-pro-btn pro-back">
							<b>상품목록으로</b>
						</button>
					</a>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="/resources/Outer/admin/js/sellerProductDetail.js"></script>
</html>