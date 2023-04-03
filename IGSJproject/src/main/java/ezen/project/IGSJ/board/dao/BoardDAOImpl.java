package ezen.project.IGSJ.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ezen.project.IGSJ.board.domain.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	private static final String NAME_SPACE = "mappers.boardMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardDTO> getBoardList() throws Exception {
		
		logger.info("공지사항 리스트 가져오기 vue - DAO");
		
		return sqlSession.selectList(NAME_SPACE + ".getBoardList");
	}
	
}
