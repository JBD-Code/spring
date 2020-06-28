package com.spring.pro08.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.pro08.member.vo.MemberVO;

public interface MemberDAO {

	public List listMember()throws DataAccessException;

	public void insertMember(MemberVO memberVO)throws DataAccessException;

	public MemberVO selectMember(String id) throws DataAccessException;

	public void updateMember(MemberVO memberVO) throws DataAccessException;

	public void deleteMember(String id)throws DataAccessException;

}
