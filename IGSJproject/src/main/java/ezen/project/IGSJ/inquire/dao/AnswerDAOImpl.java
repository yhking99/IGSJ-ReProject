package ezen.project.IGSJ.inquire.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ezen.project.IGSJ.inquire.controller.AnswerController;
import ezen.project.IGSJ.inquire.domain.AnswerDTO;

@Repository
public class AnswerDAOImpl implements AnswerDAO {

	private static final Logger logger = LoggerFactory.getLogger(AnswerController.class);

	private static final String NAME_SPACE = "mappers.answerMapper";

	@Autowired
	private SqlSession sqlSession;

	// 문의내용 답변 불러오기
	@Override
	public AnswerDTO answerList(int inquireNum) throws Exception {

		logger.info("{} 번 문의내용 답변 불러오기");

		return sqlSession.selectOne(NAME_SPACE + ".answerList", inquireNum);
	}

	// 답변하기
	@Override
	public int answerWrite(AnswerDTO answerDTO) throws Exception {

		logger.info("{}번 문의사항에 답변 남기기", answerDTO);

		return sqlSession.insert(NAME_SPACE + ".answerWrite", answerDTO);
	}

}
