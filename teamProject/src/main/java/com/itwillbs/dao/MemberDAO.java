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
			String sql = "select max(m_num) from members";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if (rs.next() == true) {
				num = rs.getInt("max(m_num)");
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dblClose();
		}
		
		return num;
	}



	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberDAO getMaxNum()");

		try {
			
			con = getConnection();
			
			String sql = "insert into members(m_num, m_id, m_pass, m_name, m_nick, m_phone, m_email, m_date, m_event) "
					+ "values(?,?,?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, memberDTO.getM_num());
			pstmt.setString(2, memberDTO.getM_id());
			pstmt.setString(3, memberDTO.getM_pass());
			pstmt.setString(4, memberDTO.getM_name());
			pstmt.setString(5, memberDTO.getM_nick());
			pstmt.setString(6, memberDTO.getM_phone());
			pstmt.setString(7, memberDTO.getM_email());
			pstmt.setTimestamp(8, memberDTO.getM_date());
			pstmt.setString(9, memberDTO.getM_event());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dblClose();
		}
	}



//	로그인 유저체크
	public MemberDTO userCheck(MemberDTO memberDTO2) {
		System.out.println("MemberDAO userCheck()");
		
		MemberDTO memberDTO = null;
		
		try {
			
			con = getConnection();
			String sql = "select * from members where m_id = ? and m_pass = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO2.getM_id());
			pstmt.setString(2, memberDTO2.getM_pass());
			
			rs = pstmt.executeQuery();
			
//			첫번째 행으로 데이터 있으면 memberDTO 객체생성, set 메서드 호출,rs열 데이터 저장
			if (rs.next() == true) {
				memberDTO = new MemberDTO();
				
				memberDTO.setM_id(rs.getString("m_id"));
				memberDTO.setM_pass(rs.getString("m_pass"));

				System.out.println("로그인 성공!");
				
			} else {
//				아이디, 비밀번호 불일치 -> 초기값 null -> 리턴
				memberDTO = null;
				
				System.out.println("로그인 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dblClose();
		}
		
		return memberDTO;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	// insertMember()
