package com.spring.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;


@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	/*
	 public void setMemberDAO(MemberDAO memberDAO) { 
	 	this.memberDAO = memberDAO; }
	 */
	
	@Override
	public List memberList() throws DataAccessException {
		List list = null;
		list = memberDAO.listMember();
		return list;
	}

	@Override
	public void memberInsert(MemberVO memberVO) throws DataAccessException {
		
		memberDAO.insertMember(memberVO);
	}

	@Override
	public void memberDelete(String id) throws DataAccessException {
		memberDAO.deleteMember(id);
		
	}

	@Override
	public MemberVO memberInfo(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		MemberVO memberVO = new MemberVO();
		memberVO=memberDAO.selectMember(id);
		return memberVO;
	}

	@Override
	public void memberUpdate(MemberVO memberVO) throws DataAccessException {
		memberDAO.updateMember(memberVO);
		
	}
	
	
	
	
	
	
	

	

}
