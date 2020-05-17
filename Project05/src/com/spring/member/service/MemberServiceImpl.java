package com.spring.member.service;

import java.util.List;
import java.util.Map;

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

	@Override
	public MemberVO selectMember(String id) throws Exception {
		
		return memberDAO.memberSelect(id);
	}

	@Override
	public void updateMember(Map memberMap) throws Exception {
		memberDAO.memberUpdate(memberMap);
	}
	
	
	
	
	
	
}
