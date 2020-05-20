package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberService {
	public List memberList()throws DataAccessException ;
	public void memberInsert(MemberVO memberVO) throws DataAccessException;
	public void memberDelete(String id )throws DataAccessException;
	public MemberVO memberInfo(String id)throws DataAccessException;
}
