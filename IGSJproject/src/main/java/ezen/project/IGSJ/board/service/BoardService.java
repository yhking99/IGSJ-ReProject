package ezen.project.IGSJ.board.service;

import java.util.List;

import ezen.project.IGSJ.board.domain.BoardDTO;

public interface BoardService {
	
	public List<BoardDTO> getBoardList() throws Exception;
}
