package ezen.project.IGSJ.inquire.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ezen.project.IGSJ.inquire.domain.AnswerDTO;
import ezen.project.IGSJ.inquire.service.AnswerService;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class AnswerController {
	
	private static final Logger logger = LoggerFactory.getLogger(AnswerController.class);

	@Autowired
	private AnswerService answerService;

	// 답글불러오기
	@ResponseBody
	@RequestMapping(value = "/answer/AnswerList", method = RequestMethod.GET)
	public AnswerDTO answerList(@RequestParam int inquireNum) throws Exception {

		logger.info("vue 답글 불러오기");

		AnswerDTO ansList = answerService.answerList(inquireNum);

		return ansList;
	}
	
	// 답글 작성하기
	@ResponseBody
	@RequestMapping(value = "/answer/AnswerWrite", method = RequestMethod.POST)
	public boolean answerWrite(@RequestBody AnswerDTO answerDTO) throws Exception {

		logger.info("답변 작성", answerDTO);

		int result = answerService.answerWrite(answerDTO);

		if (result == 1) {

			return true;

		} else {

			return false;

		}

	}
}
