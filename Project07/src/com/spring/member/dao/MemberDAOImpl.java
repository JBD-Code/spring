package com.spring.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession sqlSession;

	/*
	 public void setSqlSession(SqlSession sqlSession) { 
	 	this.sqlSession = sqlSession; 
	 }
	 */

	@Override
	public List listMember() throws DataAccessException {
		// TODO Auto-generated method stub
		
		List<MemberVO>list = null;
		try {
			list=sqlSession.selectList("mapper.member.memberList");
		} catch (Exception e) {
			System.out.println("listMember Method Error " +e);
			e.printStackTrace();
		}
		return list;
	}
	
	
}
