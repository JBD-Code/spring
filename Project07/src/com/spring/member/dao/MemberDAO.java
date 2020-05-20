package com.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface MemberDAO {
	
	public List listMember() throws DataAccessException;
}
