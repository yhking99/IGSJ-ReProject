<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${productInfo.product_name }수정하기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/36.0.0/classic/ckeditor.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
<link rel="stylesheet" href="/resources/Outer/admin/css/adminProductModify.css">
</head>
<body>
	<form id="product-form" action="/admin/productmodify" method="post" enctype="multipart/form-data">
		<div class="product-title">
			<h1>
				<input value="${productInfo.product_name }" name="product_name" placeholder="상품이름">
			</h1>
		</div>
		<div class="single-product" align="center">
			<div class="inner-product">
				<div class="img-box">
					<img id="resultimg" src="${productInfo.storedFileRootName }" alt="상품 이미지 로딩 실패">
					<input type="hidden" name="originalFileName" value="${productInfo.originalFileName }">
					<input type="hidden" name="storedFileRootName" value="${productInfo.storedFileRootName }">
					<input type="hidden" name="storedThumbNailName" value="${productInfo.storedThumbNailName }">
					<div class="input-img-box">
						<input type="file" id="input-img" name="file">
					</div>
				</div>
				
				<div class="product-info">
					<div class="explan_product product_info_section" align="left">
						<input type="hidden" id="category-List" value="${category}">
						<h3 class="title-box font-mss">
							Product Info
							<span class="korSub">
								&#47;&nbsp;<font size="2">제품정보</font>
							</span>
						</h3>
						<ul class="product_article">

							<li>
								<p class="product_article_tit">1차 분류</p>
								<p class="product_article_contents">
									<select class="category1">
										<option value="">전체</option>
									</select>
								</p>
							</li>

							<li>
								<p class="product_article_tit">2차 분류</p>
								<p class="product_article_contents">
									<select class="category2" name="cno">
										<option value="">전체</option>
									</select>
								</p>
							</li>

							<li>
								<p class="product_article_tit">품번</p>
								<p class="product_article_contents">
									<strong title="상품번호는 고유번호이므로 변경이 불가능합니다."> <input type="text" name="pno" value="${productInfo.pno }" readonly="readonly">
									</strong>
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
									<strong><input type="text" value="2023 S/S"> </strong>
									<span class="txt_unit2">&#47;</span>
									<span class="txt_gender">
										<strong> <input type="text" value="남">
										</strong>
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
										<strong> <input type="text" name="product_stock" value="${productInfo.product_stock }">
										</strong>
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
											<font size="5"> <b><input type="text" name="product_price" value="${productInfo.product_price }"></b>원
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
						<button class="admin-pro-btn pro-modify">
							<b>상품정보수정</b>
						</button>
						<a href="/admin/productDetail?pno=${productInfo.pno }">
							<button type="button" class="admin-pro-btn pro-del">
								<b>이전으로</b>
							</button>
						</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	// 이미지 올리면 보여주기
	$ ( "#input-img" ).change ( function () {
		if ( this.files && this.files[0] ) {
			var reader = new FileReader;
			reader.onload = function ( data ) {
				$ ( ".img-box img" ).attr ( "src" , data.target.result ).width ( 325 ).height ( 425 );
			}
			reader.readAsDataURL ( this.files[0] );
		}
	} );

	// 컨트롤러에서 데이터 받기
	var jsonData = JSON.parse ( '${category}' );

	var cate1Arr = new Array ();
	var cate2Arr = new Array ();
	var cate1Obj = new Object ();
	var cate2Obj = new Object ();

	// 1차 분류 셀렉트 박스에 삽입할 데이터 준비
	for ( var i = 0; i < jsonData.length; i++ ) {

		if ( jsonData[i].big_ctg == "1" ) {
			cate1Obj = new Object (); //초기화
			cate1Obj.cno = jsonData[i].cno;
			cate1Obj.category_name = jsonData[i].category_name;
			cate1Arr.push ( cate1Obj );
		}
	}

	// 1차 분류 셀렉트 박스에 데이터 삽입
	var cate1Select = $ ( "select.category1" )

	for ( var i = 0; i < cate1Arr.length; i++ ) {
		cate1Select.append ( "<option value='" + cate1Arr[i].cno + "'>" + cate1Arr[i].category_name + "</option>" );
	}

	$ ( document ).on ( "change" , "select.category1" , function () {
		cate2Arr = [];

		// 2차 분류 셀렉트 박스에 삽입할 데이터 준비
		for ( var i = 0; i < jsonData.length; i++ ) {

			if ( jsonData[i].big_ctg == "2" ) {
				cate2Obj = new Object (); //초기화
				cate2Obj.cno = jsonData[i].cno;
				cate2Obj.category_name = jsonData[i].category_name;
				cate2Obj.category_level = jsonData[i].category_level;

				cate2Arr.push ( cate2Obj );
			}
		}

		var cate2Select = $ ( "select.category2" );

		/*
		for(var i = 0; i < cate2Arr.length; i++) {
		  cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
		       + cate2Arr[i].cateName + "</option>");
		}
		 */

		cate2Select.empty ();

		$ ( "option:selected" , this ).each ( function () {

			var selectVal = $ ( this ).val ();

			cate2Select.append ( "<option value='" + selectVal + "'>전체</option>" );

			for ( var i = 0; i < cate2Arr.length; i++ ) {
				if ( selectVal == cate2Arr[i].category_level ) {
					cate2Select.append ( "<option value='" + cate2Arr[i].cno + "'>" + cate2Arr[i].category_name + "</option>" );
				}
			}

		} );

	} );
	
	// ck에디터 적용
	var myEditor;
	ClassicEditor
		.create( document.querySelector( '#product_description' ), {
			ckfinder: {
		        uploadUrl: '/seller/register/ckUpload' // 내가 지정한 업로드 url (post로 요청감)
			}, 
			removePlugins: [ 'Heading' ],
		    language: "ko"
		} )
		.then( editor => {
	        console.log( 'Editor was initialized', editor );
	        myEditor = editor;
	    } )
		.catch( error => {
		    console.error( error );
	} );
</script>
</html>