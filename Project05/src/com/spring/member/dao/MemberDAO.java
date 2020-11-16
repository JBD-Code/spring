package com.spring.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberDAO {
	
	public List<MemberVO> memberList()throws DataAccessException, Exception;
	public void memberInsert(MemberVO memberVO)throws DataAccessException, Exception;
	public MemberVO memberSelect(String id)throws DataAccessException, Exception;
	public void memberUpdate(Map memberMap)throws DataAccessException, Exception;
	public void memberDelete(String id)throws DataAccessException, Exception;
	public MemberVO searchId(String id)throws DataAccessException, Exception;
	public MemberVO searchName(String name)throws DataAccessException, Exception;
}
