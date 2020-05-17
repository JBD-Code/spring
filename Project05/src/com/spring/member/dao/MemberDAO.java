package com.spring.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberDAO {
	
	public List<MemberVO> memberList()throws DataAccessException, Exception;
	public void memberInsert(MemberVO memberVO);
	public MemberVO memberSelect(String id);
	public void memberUpdate(Map memberMap);
}
