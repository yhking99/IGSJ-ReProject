package ezen.project.IGSJ.admin.dao;

import java.util.List;

import ezen.project.IGSJ.member.domain.MemberDTO;

public interface AdminDAO {
	
	// 전체 회원 불러오기
	public List<MemberDTO> getAllUsers(int displayTotalContent, int pageContent, String searchType, String keyword) throws Exception;
	
	// 검색 결과에 따른 회원 수 출력
	public int searchMember(String searchType, String keyword) throws Exception;
	
	// 전체 상품 불러오기
	public List<ProductDTO> getProductList(int displayTotalContent, int pageContent, String searchType, String keyword) throws Exception;
}
