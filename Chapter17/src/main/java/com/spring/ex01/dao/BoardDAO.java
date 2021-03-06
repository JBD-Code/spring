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

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.spring.ex01.dto.BoardDTO;
import com.spring.ex01.util.Constant;

public class BoardDAO {
	
	
	
	private Connection conn; 
	private PreparedStatement pstmt;
	private ResultSet rs; 
	String sql= "" ;
	JdbcTemplate template  ; 
	
	public BoardDAO() {
		template=Constant.template;
	}
	
	
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
	
	/*
	public List<BoardDTO>list() {
		
		List<BoardDTO>lists = new ArrayList<BoardDTO>();
		try {
			conn=getConnection();
			//sql ="select * from board order by idx desc"; 
			sql ="select level, idx, bgroup, title, content, id, name, writeDate, bStep, bIndent, readCount"
					+ " from board "
					+ " start with bgroup=0"
					+ " connect by prior idx=bgroup"
					+ " order siblings by idx desc";
			
			pstmt= conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setLevel(rs.getInt("level"));
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
			System.out.println("list Method Error" +e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDB();
		} 
		
		return lists; 
	}
	*/
	
	public List<BoardDTO>list() {
		//List<BoardDTO>lists = new ArrayList<BoardDTO>();
		
		sql ="select level, idx, bgroup, title, content, id, name, writeDate, bStep, bIndent, readCount"
				+ " from board "
				+ " start with bgroup=0"
				+ " connect by prior idx=bgroup"
				+ " order siblings by idx desc";
		return template.query(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	
		//return lists;
	}	
	
	/*
	public void insert(int idx, String id, String name, String title, String content, Date writeDate) {
		
		idx = idxCount(idx);
		try {
			conn = getConnection();
			sql = "insert into board(idx, id, name, title, content, writeDate, bGroup, bStep, bIndent)"
					+ " values(?,?,?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, id);
			pstmt.setString(3, name);
			pstmt.setString(4, title);
			pstmt.setString(5, content);
			pstmt.setDate(6, writeDate);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("insert Method Error" +e);
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
	}
	*/
	public void insert(int idx, final String id, final String name, final String title, final String content, final Date writeDate) {
			
		final int index = idxCount(idx);
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				sql = "insert into board(idx, id, name, title, content, writeDate, bGroup, bStep, bIndent)"
						+ " values(?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, index);
				pstmt.setString(2, id);
				pstmt.setString(3, name);
				pstmt.setString(4, title);
				pstmt.setString(5, content);
				pstmt.setDate(6, writeDate);
				pstmt.setInt(7, 0);
				pstmt.setInt(8, 0);
				pstmt.setInt(9, 0);
				
				return pstmt;
			}
		});
	}
	
	/*
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
	*/
	public int idxCount(int idx) {
		sql= "select count(*) from board";
		
		 return template.queryForInt(sql)+1;
		
	}
	
	/*
	public BoardDTO select(int idx) {
		BoardDTO dto = new BoardDTO(); 
		readCount(idx);
		
		try {
			conn = getConnection();
			sql= "select * from board where idx=?"; 
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				dto.setIdx(rs.getInt("idx"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getDate("writeDate"));
				dto.setReadCount(rs.getInt("readCount"));
			}
			
		} catch (Exception e) {
			System.out.println("select Method Error" +e);
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		// TODO Auto-generated method stub
		return dto; 
	}
	*/
	public BoardDTO select(int idx) {
		readCount(idx);
		sql= "select * from board where idx="+idx; 
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
		
	}
	/*
	public void modify(int idx, String name, String title, String content) {
		
		try {
			conn=getConnection();
			sql= "update board set name=?, title=?, content=? where idx=?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setInt(4, idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("modify Method Error" +e);
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
	}
	*/
	public void modify(final int idx, final String name, final String title, final String content) {
		
		sql= "update board set name=?, title=?, content=? where idx=?"; 
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, name);
				ps.setString(2, title);
				ps.setString(3, content);
				ps.setInt(4, idx);
	
			}
		});
	}
	
	/*
	public void readCount(int idx) {
		
		try {
			conn=getConnection();
			sql = "update board set readCount=readCount+1 where idx=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("readCount Error" +e);
			e.printStackTrace();
		} finally {
			closeDB();
		}

	}

	*/
	public void readCount(final int idx) {
		sql = "update board set readCount=readCount+1 where idx=?";
		
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, idx);
			}
		});
	}	
	
	/*
	public void delete(int idx) {
		try {
			conn=getConnection();
			sql = "delete from board where idx = ?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("delte Method Error" +e);
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
	}
	*/
	public void delete(final int idx) {
		sql = "delete from board where idx = ?"; 
		template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, idx);
			}
		});
	}

	/*
	public void insertReply(int idx, String id, String name, String title, String content, int bgroup,
			Date writeDate) {
		idx=idxCount(idx);
		try {
			conn=getConnection();
			sql="insert into board(idx, id, name, title, content, bgroup, writeDate )"
					+ " values(?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, id);
			pstmt.setString(3, name);
			pstmt.setString(4, title);
			pstmt.setString(5, content);
			pstmt.setInt(6, bgroup);
			pstmt.setDate(7, writeDate);
			pstmt.executeUpdate();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/
	
	public void insertReply(int idx, final String id, final String name, final String title, final String content, final int bgroup,
			final Date writeDate) {
		final int index=idxCount(idx);
		
		sql="insert into board(idx, id, name, title, content, bgroup, writeDate )"
				+ " values(?,?,?,?,?,?,?)";
		template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, index);
				pstmt.setString(2, id);
				pstmt.setString(3, name);
				pstmt.setString(4, title);
				pstmt.setString(5, content);
				pstmt.setInt(6, bgroup);
				pstmt.setDate(7, writeDate);
				
				return pstmt;
			}
			
		});
	
	
	}	
	
}
