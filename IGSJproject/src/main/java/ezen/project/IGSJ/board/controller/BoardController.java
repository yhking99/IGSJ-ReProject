package ezen.project.IGSJ.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import ezen.project.IGSJ.board.service.BoardService;

@CrossOrigin
@Controller
public class BoardController {
	
	// Console 창에 해당 로그가 찍힘 프로그램 오류 발생 시 어디서 어떤 이유로 오류가 발생하는지 알 수 있음 
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	// 공지사항 출력
	
	
	// 공지사항 작성
	
	// 공지사항 수정
	
	// 공지사항 삭제


}
