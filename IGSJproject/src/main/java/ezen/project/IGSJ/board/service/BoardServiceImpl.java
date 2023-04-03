package ezen.project.IGSJ.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.board.dao.BoardDAO;
import ezen.project.IGSJ.board.domain.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardDTO> getBoardList() throws Exception {
		
		logger.info("공지사항 리스트 가져오기 vue - service");
		
		return boardDAO.getBoardList();
	}
}
