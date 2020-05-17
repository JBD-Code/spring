package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberService {
	
	public List<MemberVO> listMember() throws Exception;
	public void insertMember(MemberVO memberVO) throws Exception;
	public MemberVO selectMember(String id)throws Exception;
}
