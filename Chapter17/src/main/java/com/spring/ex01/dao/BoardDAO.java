package com.spring.ex01.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.spring.ex01.dto.BoardDTO;

public class BoardDAO {
	
	
	private Connection conn; 
	private PreparedStatement pstmt;
	private ResultSet rs; 
	String sql= "" ;
	
	public Connection getConnection () {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void closeDB() {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<BoardDTO>list() {
		
		List<BoardDTO>lists = new ArrayList<BoardDTO>();
		try {
			conn=getConnection();
			sql ="select * from board"; 
			pstmt= conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setReadCount(rs.getInt("readCount"));
				dto.setbGroup(rs.getInt("bgroup"));
				dto.setbStep(rs.getInt("bStep"));
				dto.setbIndent(rs.getInt("bIndent"));
				dto.setWriteDate(rs.getDate("writeDate"));
				lists.add(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDB();
		} 
		
		return lists; 
	}

	public void insert(int idx, String id, String name, String title, String content, Date writeDate) {
		
		idx = idxCount(idx);
		try {
			conn = getConnection();
			sql = "insert into board(idx, id, name, title, content, writeDate)"
					+ " values(?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, id);
			pstmt.setString(3, name);
			pstmt.setString(4, title);
			pstmt.setString(5, content);
			pstmt.setDate(6, writeDate);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("insert Method Error" +e);
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
	}
	
	public int idxCount(int idx) {
		
		try {
			conn=getConnection();
			sql= "select count(*) count from board";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery(); 
			while(rs.next()) {
				idx = rs.getInt("count");
			}
			
		} catch (Exception e) {
			System.out.println("idxCout Error" +e);
			
			e.printStackTrace();
		} 
		return idx+1;
	}

	
}
