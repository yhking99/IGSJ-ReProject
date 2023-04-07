package ezen.project.IGSJ.inquire.service;

import ezen.project.IGSJ.inquire.domain.AnswerDTO;

public interface AnswerService {
	
	// 답변 내용 불러오기 (문의 내용 종속)
	public AnswerDTO answerList(int inquireNum) throws Exception;
	
	// 답변하기
	public int answerWrite(AnswerDTO answerDTO) throws Exception;
}
