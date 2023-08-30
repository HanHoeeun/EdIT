package com.itwillbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.itwillbs.domain.AdminDTO;
import com.itwillbs.domain.AdminPageDTO;

public class AdminDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//1,2 단계 디비 연결 메서드  정의 => 필요로 할때 호출 사용
	public Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds=
		(DataSource)init.lookup("java:comp/env/jdbc/c1d2304t4");
		con=ds.getConnection();
		return con;
	}
	//기억장소 해제 메서드()
	public void dbClose() {
		//  => con, pstmt, rs 기억장소 해제
		if(rs != null) {try {rs.close();} catch (SQLException e) {	}}			
		if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {	}}
		if(con != null) {try {con.close();} catch (SQLException e) {	}}
	}
	
	public void insertBoard(AdminDTO adminDTO) {
		try {
			con = this.getConnection();
			String sql = "";
//			번호(자동) 작성자 제목 내용 시간 타입 파일 
			if(adminDTO.getA_cs_type() == 1) {
				sql = "insert into test_1 values (default,?,?,?,default,'계정',?,?)";
			}else if(adminDTO.getA_cs_type() == 2) {
				sql = "insert into test_1 values (default,?,?,?,default,'중고거래',?,?)";
			}else {
				sql = "insert into test_1 values (default,?,?,?,default,'기타',?,?)";
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adminDTO.getA_m_nick());
			pstmt.setString(2, adminDTO.getA_title());
			pstmt.setString(3, adminDTO.getA_content());
			pstmt.setString(4, adminDTO.getA_file());
			pstmt.setString(5, "");
			
			pstmt.executeUpdate();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
	}
	public List<AdminDTO> getBoardListSearch(AdminPageDTO pageDTO) {
		List<AdminDTO> adminList = null;
		try {
			con = this.getConnection();
//			limit start, pagesize; 	start 에서 시작해서 pagesize 개수만큼 출력 
			String sql = "select * from test_1 where a_m_nick like ? order by a_num desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "%"+pageDTO.getSearch()+"%");
			
			pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
			pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
			
			rs = pstmt.executeQuery();
			adminList = new ArrayList<>();
			while(rs.next()) {
				AdminDTO adminDTO = new AdminDTO();
				adminDTO.setA_num(rs.getInt("a_num"));
				adminDTO.setA_title(rs.getString("a_title"));
				adminDTO.setA_m_nick(rs.getString("a_m_nick"));
				adminDTO.setA_date(rs.getTimestamp("a_date"));
				
				adminList.add(adminDTO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		
		return adminList;
		
	}
	public int getBoardCountSearch(AdminPageDTO pageDTO) {
		int count = 0;
		
		try {
			con = this.getConnection();
			String sql = "select count(*) as count from test_1 where a_m_nick like ? ";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "%"+pageDTO.getSearch()+"%");
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public AdminDTO getBoardContent(int num) {
		AdminDTO adminDTO = null;
		try {
			con = this.getConnection();
			
			String sql = "select * from test_1 where a_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				adminDTO = new AdminDTO();
				adminDTO.setA_num(rs.getInt("a_num"));
				adminDTO.setA_m_nick(rs.getString("a_m_nick"));
				adminDTO.setA_title(rs.getString("a_title"));
				adminDTO.setA_file(rs.getString("a_file"));
				adminDTO.setA_content(rs.getString("a_content"));
				adminDTO.setA_answer(rs.getString("a_answer"));
			}
			
		} catch (Exception e) {
			
		}finally {
			this.dbClose();
		}
		
		return adminDTO;
	}
}
