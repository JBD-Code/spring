package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public List<MemberVO> listMember() throws Exception {
		List<MemberVO> list = null;
		list=memberDAO.memberList();
		return list;
	}

	@Override
	public void insertMember(MemberVO memberVO) throws Exception {

		memberDAO.memberInsert(memberVO);
	}
	
	
	
	
	
}
