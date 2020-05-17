package com.spring.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{
	
	private SqlSession sqlSession ; 
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	
	@Override
	public List<MemberVO> memberList() throws DataAccessException {
		List<MemberVO> memberList = null; 
		memberList = sqlSession.selectList("mapper.member.memberList");
		
		return memberList;
	}

	@Override
	public void memberInsert(MemberVO memberVO) {
		
		try {
			sqlSession.insert("mapper.member.memberInsert", memberVO);
			//sqlSession.commit();
		} catch (Exception e) {
			System.out.println("memberInsert Method Error" +e);
			e.printStackTrace();
		}
	}

	@Override
	public MemberVO memberSelect(String id) {
		MemberVO memberVO = null ; 
		memberVO = sqlSession.selectOne("mapper.member.memberSelect", id);
		return memberVO; 
	}
	
	
	
	
}
