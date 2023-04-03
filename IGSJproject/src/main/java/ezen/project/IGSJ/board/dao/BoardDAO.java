package ezen.project.IGSJ.board.dao;

import java.util.List;

import ezen.project.IGSJ.board.domain.BoardDTO;

public interface BoardDAO {
	
	// 공지사항 리스트 가져오기
	public List<BoardDTO> getBoardList() throws Exception;
}
