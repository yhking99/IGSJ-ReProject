package ezen.project.IGSJ.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.member.dao.MemberDAO;
import ezen.project.IGSJ.member.domain.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	// 회원가입 로직
	@Override
	public void signUpMember(MemberDTO memberDTO) throws Exception {

		logger.info("회원가입 실행 signUpMember - Service");

		memberDAO.signUpMember(memberDTO);

	}
	
	// 로그인
	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {

		logger.info("로그인 실행 memberLogin - Service");

		return memberDAO.memberLogin(memberDTO);
	}

	// 회원가입 아이디 중복 체크
	@Override
	public int memberIdCheck(MemberDTO memberDTO) throws Exception {

		logger.info("회원가입 아이디 중복 체크 memberIdCheck - Service");

		return memberDAO.memberIdCheck(memberDTO);

	}

	// 회원정보 수정 로직
	@Override
	public void memberModify(MemberDTO memberDTO) throws Exception {

		logger.info("회원정보 수정 로직 memberModify - Service");

		memberDAO.memberModify(memberDTO);
	}

	// 회원 정보 찾기
	@Override
	public MemberDTO memberProfile(String userId) throws Exception {

		logger.info("회원정보 정보 찾기 memberProfile - Service");

		return memberDAO.memberProfile(userId);
	}

	// 회원 탈퇴
	@Override
	public int removeMember(MemberDTO memberDTO) throws Exception {

		logger.info("회원 탈퇴 removeMember - Service");

		return memberDAO.removeMember(memberDTO);
	}

	//비밀번호 검증
	@Override
	public String getPwd(String userId) throws Exception {
		
		logger.info("비밀번호 검증 getPwd - Service");
		
		return memberDAO.getPwd(userId);

	}
}
