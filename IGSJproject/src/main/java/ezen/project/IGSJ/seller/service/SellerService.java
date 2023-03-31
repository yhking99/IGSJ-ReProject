package ezen.project.IGSJ.seller.service;

import java.util.List;

import ezen.project.IGSJ.category.domain.CategoryDTO;
import ezen.project.IGSJ.product.domain.ProductDTO;
import ezen.project.IGSJ.productFile.domain.ProductFileDTO;

public interface SellerService {

	public List<CategoryDTO> getCategory() throws Exception;
	
	public void postRegister(ProductDTO product, ProductFileDTO productFile) throws Exception;
	
	// 전체 상품 불러오기
		public List<ProductDTO> getProductList(int displayTotalContent, int pageContent, String searchType, String keyword) throws Exception;

	// 검색결과에 따른 상품 출력
	public int searchProduct(String searchType, String keyword) throws Exception;
	
}
