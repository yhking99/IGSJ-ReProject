package ezen.project.IGSJ.inquire.dao;

import java.util.List;

import ezen.project.IGSJ.inquire.domain.InquireDTO;

public interface InquireDAO {
	
	// 제품 문의 목록
	public List<InquireDTO> inquireList() throws Exception;
	
	// 제품 문의 등록
	public int inquireWrite(InquireDTO inquireDTO) throws Exception;

	// 제품 문의 조회
	public InquireDTO inquireView(int inquireNum) throws Exception;
	
	// 제품 문의 수정
	public int inquireUpdate(InquireDTO inquireDTO) throws Exception;
	
	// 제품 문의 삭제
	public int inquireDelete(int inquireNum) throws Exception;

}
