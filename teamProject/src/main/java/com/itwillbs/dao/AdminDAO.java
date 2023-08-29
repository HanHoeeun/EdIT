package com.itwillbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.itwillbs.domain.AdminDTO;

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
				sql = "insert into test_1 values (default,?,?,?,default,'계정',?)";
			}else if(adminDTO.getA_cs_type() == 2) {
				sql = "insert into test_1 values (default,?,?,?,default,'중고거래',?)";
			}else {
				sql = "insert into test_1 values (default,?,?,?,default,'기타',?)";
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adminDTO.getA_m_nick());
			pstmt.setString(2, adminDTO.getA_title());
			pstmt.setString(3, adminDTO.getA_content());
			pstmt.setString(4, adminDTO.getA_file());
			
			pstmt.executeUpdate();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
	}
}
