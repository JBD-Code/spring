package com.spring.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memberDAO;
	MemberVO memberVO;
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

	@Override
	public void deleteMember(String id) throws Exception {
		memberDAO.memberDelete(id);
	}

	@Override
	public MemberVO searchMemberName(String name) throws Exception {
		memberVO = memberDAO.searchName(name);
		// TODO Auto-generated method stub
		return memberVO;
	}

	@Override
	public MemberVO searchMemberId(String id) throws Exception {
		memberVO = memberDAO.searchId(id);
		// TODO Auto-generated method stub
		return memberVO;
	}
	
	
	
	
	
	
	
	
	
}
