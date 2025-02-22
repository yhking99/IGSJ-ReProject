package ezen.project.IGSJ.seller.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.category.domain.CategoryDTO;
import ezen.project.IGSJ.product.domain.ProductDTO;
import ezen.project.IGSJ.productFile.domain.ProductFileDTO;
import ezen.project.IGSJ.seller.dao.SellerDAO;

@Service
public class SellerServiceImpl implements SellerService{

	@Inject
	private SellerDAO sellerDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(SellerServiceImpl.class);
	
	@Override
	public List<CategoryDTO> getCategory() throws Exception {
	
		return sellerDAO.getCategory();
	}


	@Override
	public void postRegister(ProductDTO product, ProductFileDTO productFile) throws Exception {
		sellerDAO.postRegister(product);
		sellerDAO.postImgRegister(productFile);
	}
	// 상품 목록 불러오기
	@Override
	public List<ProductDTO> getProductList(int displayTotalContent, int pageContent, String searchType, String keyword) throws Exception {
		
		logger.info("관리자 페이지 전체 상품 목록 불러오기 service");
		
		return sellerDAO.getProductList(displayTotalContent, pageContent, searchType, keyword);
	}
	
	// 검색 결과에 따른 상품 불러오기
	@Override
	public int searchProduct(String searchType, String keyword) throws Exception {
		
		logger.info("관리자 페이지 검색결과에 따른 상품 수 출력");
		
		return sellerDAO.searchProduct(searchType, keyword);
	}
	
	
}
