package ezen.project.IGSJ.admin.service;

import java.util.List;

import ezen.project.IGSJ.member.domain.MemberDTO;
import ezen.project.IGSJ.product.domain.ProductDTO;

public interface AdminService {
	
	// 전체 회원 불러오기
	public List<MemberDTO> getAllUsers(int displayTotalContent, int pageContent, String searchType, String keyword) throws Exception;
	
	// 검색결과에 따른 회원 출력
	public int searchMember (String searchType , String keyword) throws Exception;
	
	// 전체 상품 불러오기
	public List<ProductDTO> getProductList(int displayTotalContent, int pageContent, String searchType, String keyword) throws Exception;

}
