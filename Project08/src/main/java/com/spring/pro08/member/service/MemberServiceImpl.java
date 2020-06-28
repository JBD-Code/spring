package com.spring.pro08.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.pro08.member.dao.MemberDAO;
import com.spring.pro08.member.vo.MemberVO;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO; 
	
	@Override
	public List memberList() throws DataAccessException {
		List list = null ;
		list =memberDAO.listMember();
		return list;
	}

	@Override
	public void memberInsert(MemberVO memberVO) throws DataAccessException {

		memberDAO.insertMember(memberVO);
	}
	
	@Override
	public MemberVO memberSelect(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		return memberDAO.selectMember(id);
	}

	@Override
	public void memberUpdate(MemberVO memberVO) throws DataAccessException {
		// TODO Auto-generated method stub
		memberDAO.updateMember(memberVO);
	}

	@Override
	public void memberDelete(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		memberDAO.deleteMember(id);
	}
	

	
	
	

	
}
