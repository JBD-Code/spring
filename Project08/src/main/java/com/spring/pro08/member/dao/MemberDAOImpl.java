package com.spring.pro08.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.pro08.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession; 
	
	@Override
	public List listMember() throws DataAccessException {
		
		// TODO Auto-generated method stub
		List<MemberVO> list = new ArrayList<MemberVO>();;
	
		try {
			list=sqlSession.selectList("mapper.member.memberList");
		} catch (Exception e) {
			System.out.println("listMember Method Error" +e);
			e.printStackTrace();
		} 
		
		return list;
	}

	@Override
	public void insertMember(MemberVO memberVO) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			sqlSession.insert("mapper.member.memberInsert", memberVO);
		} catch (Exception e) {
			System.out.println("insertMember Method Error" +e);
			e.printStackTrace();
		}
		
	}

	@Override
	public MemberVO selectMember(String id) throws DataAccessException {
		MemberVO memberVO = new MemberVO();
		try {
			memberVO = (MemberVO) sqlSession.selectOne("mapper.member.memberSelect", id);
		} catch (Exception e) {
			System.out.println("selectMember Method Error"+e);
			e.printStackTrace();
		}
		return memberVO;
	}

	@Override
	public void updateMember(MemberVO memberVO) throws DataAccessException {
		try {
			sqlSession.update("mapper.member.memberUpdate", memberVO);
		} catch (Exception e) {
			System.out.println("updateMember Method Error" +e);
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteMember(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			sqlSession.delete("mapper.member.memberDelete", id);
		} catch (Exception e) {
			System.out.println("deleteMember Method Error" +e);
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	

	
}
