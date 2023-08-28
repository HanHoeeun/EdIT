package com.itwillbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {

	
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	
//	1단계, 2단계 DB 연결 메서드 정의 => 필요할 때 호출해서 사용	
	public Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/c1d2304t4");
		Connection con = ds.getConnection();
		return con;
	}
	

	
//	예외 상관없이 마무리 작업 => con, pstmt, rs 기억 장소 해제
	public void dblClose() {
		if (pstmt != null) { 	try { 	pstmt.close(); } catch (SQLException e) { e.printStackTrace();	} }
		if (con != null) { try { con.close(); } catch (SQLException e) { e.printStackTrace();	} }
		if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace();	} }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
