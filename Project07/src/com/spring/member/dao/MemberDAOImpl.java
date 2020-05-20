package com.spring.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

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

	@Override
	public void insertMember(MemberVO memberVO) throws DataAccessException {
		try {
			sqlSession.insert("mapper.member.memberInsert", memberVO);
		} catch (Exception e) {
			System.out.println("insertMember Method Error " +e);
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteMember(String id) throws DataAccessException {
		
		sqlSession.delete("mapper.member.memberDelete", id);
	}

	@Override
	public MemberVO selectMember(String id) throws DataAccessException {
		MemberVO memberVO = new MemberVO(); 
		memberVO= (MemberVO) sqlSession.selectOne("mapper.member.memberSelect", id);
		return memberVO;
	}

	@Override
	public void updateMember(MemberVO memberVO) throws DataAccessException {
		try {
			sqlSession.update("mapper.member.memberUpdate", memberVO);
		} catch (Exception e) {
			System.out.println("updateMember Method Error " +e);
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
}
