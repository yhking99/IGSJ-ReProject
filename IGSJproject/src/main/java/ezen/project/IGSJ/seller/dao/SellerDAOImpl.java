package ezen.project.IGSJ.seller.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ezen.project.IGSJ.category.domain.CategoryDTO;
import ezen.project.IGSJ.product.domain.ProductDTO;
import ezen.project.IGSJ.productFile.domain.ProductFileDTO;
import ezen.project.IGSJ.seller.controller.SellerController;
import ezen.project.IGSJ.seller.service.SellerServiceImpl;

@Repository
public class SellerDAOImpl implements SellerDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(SellerDAOImpl.class);
	private static final String Namespace = "mappers.sellerMapper";

	
	@Override
	public List<CategoryDTO> getCategory() throws Exception {
		return sqlSession.selectList(Namespace+".getCategory");
	}


	@Override
	public void postRegister(ProductDTO product) throws Exception {
		sqlSession.insert(Namespace+".postRegister",product);
	}
	@Override
	public void postImgRegister(ProductFileDTO productFile) throws Exception {
		sqlSession.insert(Namespace+".imgRegister",productFile);
	}
	
	// 전체 상품 목록 불러오기
	@Override
	public List<ProductDTO> getProductList(int displayTotalContent, int pageContent, String searchType, String keyword) throws Exception {

		logger.info("관리자 페이지 전체상품 불러오기 DAO");

		HashMap<String, Object> productPageData = new HashMap<>();
		productPageData.put("displayTotalContent", displayTotalContent);
		productPageData.put("pageContent", pageContent);
		productPageData.put("searchType", searchType);
		productPageData.put("keyword", keyword);

		return sqlSession.selectList(Namespace + ".getProductList", productPageData);
	}

	// 검색 결과에 따른 상품 목록 불러오기
	@Override
	public int searchProduct(String searchType, String keyword) throws Exception {

		logger.info("관리자 페이지 검색결과에 따른 상품 출력");

		HashMap<String, String> searchData = new HashMap<>();

		searchData.put("searchType", searchType);
		searchData.put("keyword", keyword);

		return sqlSession.selectOne(Namespace + ".searchProduct", searchData);
	}
	
}
