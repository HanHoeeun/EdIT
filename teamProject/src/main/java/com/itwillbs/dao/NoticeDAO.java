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
import com.itwillbs.domain.NoticePageDTO;

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
	
//================================================ 공지사항 =======================================================	
	public List<NoticeDTO> getNoticeList(NoticePageDTO pageDTO){
		System.out.println("NoticeDAO getNoticeList()");
		List<NoticeDTO> noticeList = null;
		try {
			//1,2 디비연결
			con = getConnection();
			//3 sql  => mysql 제공 => limit 시작행-1, 몇개
			String sql="select * from notice1 order by a_num desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pageDTO.getStartRow()-1);//시작행-1
			pstmt.setInt(2, pageDTO.getPageSize());//몇개
			//4 실행 => 결과 저장
			rs = pstmt.executeQuery();
			// noticeList 객체생성
			noticeList = new ArrayList<>();
			//5 결과 행접근 => NoticeDTO객체생성 => set호출(열접근저장)
			// => 배열 한칸에 저장
			while(rs.next()) {
				System.out.println("반복");
				NoticeDTO noticeDTO = new NoticeDTO();
				noticeDTO.setA_num(rs.getInt("a_num"));
				noticeDTO.setA_title(rs.getString("a_title"));
				noticeDTO.setA_content(rs.getString("a_content"));
				noticeDTO.setA_date(rs.getTimestamp("a_date"));
				// => 배열 한칸에 저장
				noticeList.add(noticeDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}return noticeList;		
	}//getNoticeList()

	public void insertNotice(NoticeDTO noticeDTO) {
		System.out.println("NoticeDAO insertNotice()");
		// 테이블 file 열추가
		// mysql -uroot -p1234 jspdb
		// file컬럼 추가
		// alter table notice
		// add file varchar(100);
		try {
			//1,2 디비연결
			con=getConnection();
			//3 sql insert
			String sql="";
//			글번호 내용 시간 분류 파일명 제목
			if(noticeDTO.getA_notice_type()==1) {
				sql = "insert into notice1 values (default, ?, default,'일반공지', ?, ?)";
			}else {
				sql = "insert into notice1 values (default, ?, default,'이벤트', ?, ?)";
			}
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, noticeDTO.getA_content());
			//파일추가
			pstmt.setString(2, noticeDTO.getA_file());
			pstmt.setString(3, noticeDTO.getA_title());
			//4 실행 
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}//insertNotice()

	public NoticeDTO getNotice(int a_num) {
		NoticeDTO noticeDTO = null;
		try {
			//1,2 디비연결
			con = getConnection();
			//3 sql select * from notice where a_num = ?
			String sql="select * from notice1 where a_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, a_num);
			//4 실행 => 결과 저장
			rs = pstmt.executeQuery();
			//5 결과 행접근 => noticeDTO 객체생성 
			//        => set메서드 호출 => 열접근 데이터 저장
			if(rs.next()) {
				noticeDTO = new NoticeDTO();
				noticeDTO.setA_num(rs.getInt("a_num"));
	//			noticeDTO.setA_notice_type(rs.getString("a_notice_type"));
				noticeDTO.setA_title(rs.getString("a_title"));
				noticeDTO.setA_content(rs.getString("a_content"));
				noticeDTO.setA_date(rs.getTimestamp("a_date"));
				
				//첨부파일
				noticeDTO.setA_file(rs.getString("a_file"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return noticeDTO;
	}//getNotice()

	public int getNoticeCount() {
		int count = 0;
		try {
			//1,2 디비연결
			con=getConnection();
			//3 sql select count(*) from notice
			String sql = "select count(*) from notice1;";
			pstmt=con.prepareStatement(sql);
			//4 실행 => 결과저장
			rs = pstmt.executeQuery();
			//5 결과 행접근 => 열접근 => count변수 저장
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
			
			System.out.println("n_count"+count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return count;
	}//getNoticeCount()

	public void updateNotice(NoticeDTO noticeDTO) {
		try {
			//1,2 디비연결
			con = getConnection();
			//3 sql update Notice set a_title=?, a_content=? where a_num=?
			String sql="update notice1 set a_title=?, a_content=?, a_file=? where a_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, noticeDTO.getA_title());
			pstmt.setString(2, noticeDTO.getA_content());
			pstmt.setString(3, noticeDTO.getA_file());
			pstmt.setInt(4, noticeDTO.getA_num());
			//4 실행
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}//updateNotice

	public void deleteNotice(int a_num) {
		try {
			con = getConnection();
			// 3단계 sql구문 delete from notice where a_num=?
			String sql = "delete from notice1 where a_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,a_num);
			// 4단계
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}		
	}//deleteNotice()

	

//=============================================== 이벤트 ===========================================================
	public List<NoticeDTO> getEventList(NoticePageDTO pageDTO) {
		System.out.println("NoticeDAO getEventList()");
		List<NoticeDTO> eventList = null;
		try {
			//1,2 디비연결
			con = getConnection();
			//3 sql  => mysql 제공 => limit 시작행-1, 몇개
			String sql="select * from notice1 order by a_num desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pageDTO.getStartRow()-1);//시작행-1
			pstmt.setInt(2, pageDTO.getPageSize());//몇개
			//4 실행 => 결과 저장
			rs = pstmt.executeQuery();
			// eventList 객체생성
			eventList = new ArrayList<>();
			//5 결과 행접근 => NoticeDTO객체생성 => set호출(열접근저장)
			// => 배열 한칸에 저장
			while(rs.next()) {
				System.out.println("반복");
				NoticeDTO noticeDTO = new NoticeDTO();
				noticeDTO.setA_num(rs.getInt("a_num"));
				noticeDTO.setA_title(rs.getString("a_title"));
				noticeDTO.setA_content(rs.getString("a_content"));
				noticeDTO.setA_date(rs.getTimestamp("a_date"));
				// => 배열 한칸에 저장
				eventList.add(noticeDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}return eventList;		
	}//getEventList()
	
		
		
		
		
}//class
