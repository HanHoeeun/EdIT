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

import com.itwillbs.domain.NoticeDTO;

public class NoticeDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//1,2 단계 디비 연결 메서드  정의 => 필요로 할때 호출 사용
	public Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds= (DataSource)init.lookup("java:comp/env/jdbc/c1d2304t4");
		con=ds.getConnection();
		return con;
	}//getConnection
	
	//기억장소 해제 메서드()
	public void dbClose() {
		//  => con, pstmt, rs 기억장소 해제
		if(rs != null) {try {rs.close();} catch (SQLException e) {	}}			
		if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {	}}
		if(con != null) {try {con.close();} catch (SQLException e) {	}}
	}//dbClose
	
	public List<NoticeDTO> getNoticeList(PageDTO pageDTO){
		System.out.println("Notice getNoticeList()");
		List<NoticeDTO> noticeList = null;
		try {
			//1,2 디비연결
			con = getConnection();
			//3 sql  => mysql 제공 => limit 시작행-1, 몇개
			String sql="select * from admin order by num desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pageDTO.getStartRow()-1);//시작행-1
			pstmt.setInt(2, pageDTO.getPageSize());//몇개
			//4 실행 => 결과 저장
			rs = pstmt.executeQuery();
			// noticeList 객체생성
			noticeList = new ArrayList<>();
			//5 결과 행접근 => BoardDTO객체생성 => set호출(열접근저장)
			// => 배열 한칸에 저장
			while(rs.next()) {
				NoticeDTO noticeDTO =new NoticeDTO();
				NoticeDTO.setA_num(rs.getInt("a_num"));
				NoticeDTO.setA_title(rs.getString("a_title"));
				NoticeDTO.setA_content(rs.getString("a_content"));
				NoticeDTO.setA_date(rs.getTimestamp("a_date"));
				// => 배열 한칸에 저장
				noticeList.add(noticeDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}return noticeList;
	}//getNoticeList()
	
		
		
		
		
}//class
