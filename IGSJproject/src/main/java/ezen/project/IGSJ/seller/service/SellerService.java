package ezen.project.IGSJ.seller.service;

import java.util.List;

import ezen.project.IGSJ.category.domain.CategoryDTO;
import ezen.project.IGSJ.product.domain.ProductDTO;
import ezen.project.IGSJ.productFile.domain.ProductFileDTO;

public interface SellerService {
	
	// 판매자 상품 등록 카테고리 불러오기
	public List<CategoryDTO> getCategory() throws Exception;
	
	// 판매자 상품등록
	public void postRegister(ProductDTO product, ProductFileDTO productFile) throws Exception;
	
	// 전체 상품 불러오기
	public List<ProductDTO> getProductList(int displayTotalContent, int pageContent, String searchType, String keyword) throws Exception;

	// 검색결과에 따른 상품 출력
	public int searchProduct(String searchType, String keyword) throws Exception;
	
	// 판매자 상품 조회
	public ProductDTO sellerProductViewPage(String pno) throws Exception;
		
	// 판매자 상품 수정
	public void sellerProductModify(ProductDTO productDTO, ProductFileDTO productFileDTO) throws Exception;
	
}
