package com.spring.pro08.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.pro08.member.vo.MemberVO;

public interface MemberService {

	public List memberList()throws DataAccessException;
	public void memberInsert(MemberVO memberVO) throws DataAccessException;
	public void memberUpdate(MemberVO memberVO) throws DataAccessException;
	public MemberVO memberSelect(String id)throws DataAccessException;
	public void memberDelete(String id)throws DataAccessException;

}
