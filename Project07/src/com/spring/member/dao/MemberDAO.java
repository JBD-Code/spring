package com.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberDAO {
	
	public List listMember() throws DataAccessException;
	public void insertMember(MemberVO memberVO) throws DataAccessException;
}
