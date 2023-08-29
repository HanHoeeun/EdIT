package com.itwillbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.itwillbs.domain.MemberDTO;

public class MemberDAO {

	
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	
//	1단계, 2단계 DB 연결 메서드 정의 => 필요할 때 호출해서 사용	
	public Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/c1d2304t4");
		Connection con = ds.getConnection();
		System.out.println("MemberDAO DB연결성공!" + con);
		return con;
	}
	

	
//	예외 상관없이 마무리 작업 => con, pstmt, rs 기억 장소 해제
	public void dblClose() {
		if (pstmt != null) { 	try { 	pstmt.close(); } catch (SQLException e) { e.printStackTrace();	} }
		if (con != null) { try { con.close(); } catch (SQLException e) { e.printStackTrace();	} }
		if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace();	} }
	}


	
	
	public int getMaxNum() {
		System.out.println("MemberDAO getMaxNum()");
		
		int num = 0;
		
		try {
			
			con = getConnection();
			
			String sql = "select max(num) from members";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if (rs.next() == true) {
				num = rs.getInt("max(num)");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dblClose();
		}
		
		return num;
		
	}	// getMaxNum ()
	
	
	

	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberDAO insertMember()");
		
		try {
			
			con = getConnection();
			String sql 
			= "insert into members(m_id, m_pass, m_name, m_nick, m_phone, m_email, m_date, m_event) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getM_id());
			pstmt.setString(2, memberDTO.getM_pass());
			pstmt.setString(3, memberDTO.getM_name());
			pstmt.setString(4, memberDTO.getM_nick());
			pstmt.setInt(5, memberDTO.getM_phone());
			pstmt.setString(6, memberDTO.getM_email());
			pstmt.setTimestamp(7, memberDTO.getM_date());
			pstmt.setString(8, memberDTO.getM_event());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dblClose();
		}
		
	}	// insertMember()



	public MemberDTO getMember(String id) {
		System.out.println("MemberDAO getMember()");
		
		MemberDTO memberDTO = null;
		
		try {
			
			con = getConnection();
			String sql = "select * from members where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next() == true) {
				memberDTO = new MemberDTO();
				memberDTO.setM_id(rs.getString("_6id"));
				memberDTO.setM_name(rs.getString("_6name"));
				memberDTO.setM_nick(rs.getString("_6nick"));
				memberDTO.setM_email(rs.getString("_6maile"));
				memberDTO.setM_phone(rs.getInt("_6phone"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberDTO;
	}

	public MemberDTO userCheck(MemberDTO memberDTO2) {
		MemberDTO memberDTO = null;
		try {
			// 디비연결
			con = getConnection();
			// sql
			String sql = "select * from members where m_id=? and m_pass=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO2.getM_id());
			pstmt.setString(1, memberDTO2.getM_pass());
			// 데이터있으면 memberDTO 객체생성, set메서드 호출 rs열데이터 저장
			if(rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setM_id(rs.getString("_6id"));
				memberDTO.setM_pass(rs.getString("_6pass"));
				memberDTO.setM_name(rs.getString("_6name"));
				memberDTO.setM_date(rs.getTimestamp("_6date"));
			}
			// 아이디, 비밀번호 틀리면 => 초기값 null => 리턴
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dblClose();
		}
		return memberDTO;
	}  // userCheck()




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	// insertMember()
