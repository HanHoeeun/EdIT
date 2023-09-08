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
		
		DataSource ds=
				(DataSource)init.lookup("java:comp/env/jdbc/c1d2304t4");
		con=ds.getConnection();
		return con;
	}
	//기억장소 해제 메서드()
	public void dbClose() {
		if(rs != null) {try {rs.close();} catch (SQLException e) {	}}			
		if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {	}}
		if(con != null) {try {con.close();} catch (SQLException e) {	}}
	}

//===================================== getNoticeList =============================================
	public List<NoticeDTO> getNoticeList(NoticePageDTO pageDTO) {
		System.out.println("NoticeDAO getNoticeList()");
		List<NoticeDTO> noticeList = null;
		try {
			con = getConnection();
			String sql="select * from admin where a_notice_type=? order by a_num desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pageDTO.getA_notice_type());//일반공지 / 이벤트
			pstmt.setInt(2, pageDTO.getStartRow()-1);//시작행-1
			pstmt.setInt(3, pageDTO.getPageSize());//몇개
			rs = pstmt.executeQuery();
			
			// noticeList 객체생성
			noticeList = new ArrayList<>();
			
			// 배열에 저장
			while (rs.next()) {
				NoticeDTO noticeDTO = new NoticeDTO();
				noticeDTO.setA_num(rs.getInt("a_num"));
				noticeDTO.setA_title(rs.getString("a_title"));
				noticeDTO.setA_content(rs.getString("a_content"));
				noticeDTO.setA_date(rs.getTimestamp("a_date"));
				noticeList.add(noticeDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}return noticeList;
	}//getNoticeList

//====================================== getNoticeCount ==================================
	public int getNoticeCount() {
		int count = 0;
		try {
			con=getConnection();
			String sql = "select count(*) from admin;";
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return count;
	}//getNoticeCount
	
//=================================== insertNotice ========================================
	public void insertNotice(NoticeDTO noticeDTO) {
		System.out.println("NoticeDAO insertNotice()");
		try {
			con=getConnection();
			String sql="";
			// 글번호 유저번호 닉네임 제목 내용 답변 파일 처리여부 작성일 cs유형 공지유형
			if(noticeDTO.getA_notice_type().equals("일반공지")){
				sql = "insert into admin values (default, ?, ?, ?, ?, null, ?, null, default, null, '일반공지')";
			}else {
				sql = "insert into admin values (default, ?, ?, ?, ?, null, ?, null, default, null, '이벤트')";
			}
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, noticeDTO.getA_m_num());
			pstmt.setString(2, noticeDTO.getA_m_nick());
			pstmt.setString(3, noticeDTO.getA_title());
			pstmt.setString(4, noticeDTO.getA_content());
			// 파일추가
			pstmt.setString(5, noticeDTO.getA_file());		
			// 실행 
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}//insertNotice()
	
//======================================== getNotice =========================================
	public NoticeDTO getNotice(int a_num) {
		NoticeDTO noticeDTO = null;
		try {
			con = getConnection();
			String sql="select * from admin where a_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, a_num);
			//4 실행 => 결과 저장
			rs = pstmt.executeQuery();
			//5 결과 행접근 => noticeDTO 객체생성 => set메서드 호출 => 열접근 데이터 저장
			if(rs.next()) {
				noticeDTO = new NoticeDTO();
				noticeDTO.setA_num(rs.getInt("a_num"));
				noticeDTO.setA_notice_type(rs.getString("a_notice_type"));
				noticeDTO.setA_title(rs.getString("a_title"));
				noticeDTO.setA_content(rs.getString("a_content"));
				noticeDTO.setA_date(rs.getTimestamp("a_date"));				
				//첨부파일
				noticeDTO.setA_file(rs.getString("a_file"));
			}
			
			System.out.println("a_num"+a_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return noticeDTO;
	}//getNotice
	
//======================================= updateNotice =========================================
	public void updateNotice(NoticeDTO noticeDTO) {
		try {
			con = getConnection();
			String sql="update admin set a_notice_type=?, a_title=?, a_content=?, a_file=? where a_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, noticeDTO.getA_notice_type());
			pstmt.setString(2, noticeDTO.getA_title());
			pstmt.setString(3, noticeDTO.getA_content());
			pstmt.setString(4, noticeDTO.getA_file());
			pstmt.setInt(5, noticeDTO.getA_num());
			//4 실행
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}//updateNotice
	
//=================================== deleteNotice =======================================
	public void deleteNotice(int a_num) {
		try {
			con = getConnection();
			String sql = "delete from admin where a_num=?";
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
	
//===================================== getNoticeListSearch =============================================
		public List<NoticeDTO> getNoticeListSearch(NoticePageDTO pageDTO) {
			System.out.println("NoticeDAO getNoticeListSearch()");
			List<NoticeDTO> noticeList = null;
			try {
				con = getConnection();
				String sql="select * from admin where a_notice_type=? and a_title like ? order by a_num desc limit ?, ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, pageDTO.getA_notice_type());//일반공지 / 이벤트
				pstmt.setString(2, "%"+pageDTO.getSearch()+"%");
				pstmt.setInt(3, pageDTO.getStartRow()-1);//시작행-1
				pstmt.setInt(4, pageDTO.getPageSize());//몇개
				rs = pstmt.executeQuery();
				
				System.out.println(pstmt);
				// noticeList 객체생성
				noticeList = new ArrayList<>();
				
				// 배열에 저장
				while (rs.next()) {
					NoticeDTO noticeDTO = new NoticeDTO();
					noticeDTO.setA_num(rs.getInt("a_num"));
					noticeDTO.setA_title(rs.getString("a_title"));
					noticeDTO.setA_content(rs.getString("a_content"));
					noticeDTO.setA_date(rs.getTimestamp("a_date"));
					noticeList.add(noticeDTO);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				dbClose();
			}return noticeList;
		}//getNoticeList

//====================================== getNoticeCountSearch ==================================
		public int getNoticeCountSearch(NoticePageDTO pageDTO) {
			int count = 0;
			try {
				con=getConnection();
				String sql = "select count(*) from admin where a_title like ?;";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, "%"+pageDTO.getSearch()+"%");//='%검색어%'
				rs = pstmt.executeQuery();
				if(rs.next()) {
					count = rs.getInt("count(*)");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				dbClose();
			}
			return count;
		}//getNoticeCount
		
		
//*******************************************************************************************	
//********************************************************************************************	
//==========================================================================================		
//===================================== getEventList =============================================
	public List<NoticeDTO> getEventList(NoticePageDTO pageDTO2) {
		System.out.println("NoticeDAO getEventList()");
		List<NoticeDTO> eventList = null;
		try {
			con = getConnection();
			String sql="select * from admin where a_notice_type=? order by a_num desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pageDTO2.getA_notice_type());//일반공지 / 이벤트
			pstmt.setInt(2, pageDTO2.getStartRow()-1);//시작행-1
			pstmt.setInt(3, pageDTO2.getPageSize());//몇개
			rs = pstmt.executeQuery();

			// eventList 객체생성
			eventList = new ArrayList<>();

			// 배열에 저장
			while (rs.next()) {
				NoticeDTO noticeDTO = new NoticeDTO();
				noticeDTO.setA_num(rs.getInt("a_num"));
				noticeDTO.setA_title(rs.getString("a_title"));
				noticeDTO.setA_content(rs.getString("a_content"));
				noticeDTO.setA_date(rs.getTimestamp("a_date"));
				eventList.add(noticeDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}return eventList;
	}//getEventList		

//====================================== getEventCount ==================================
	public int getEventCount() {
		int count = 0;
		try {
			con=getConnection();
			String sql = "select count(*) from admin;";
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return count;
	}//getEventCount	
	
//=================================== insertEvent ========================================
	public void insertEvent(NoticeDTO noticeDTO) {
		System.out.println("NoticeDAO insertEvent()");
		try {
			con=getConnection();
			String sql="";
			// 글번호 유저번호 닉네임 제목 내용 답변 파일 처리여부 작성일 cs유형 공지유형
			if(noticeDTO.getA_notice_type().equals("일반공지")){
				sql = "insert into admin values (default, ?, ?, ?, ?, null, ?, null, default, null, '일반공지')";
			}else {
				sql = "insert into admin values (default, ?, ?, ?, ?, null, ?, null, default, null, '이벤트')";
			}
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, noticeDTO.getA_m_num());
			pstmt.setString(2, noticeDTO.getA_m_nick());
			pstmt.setString(3, noticeDTO.getA_title());
			pstmt.setString(4, noticeDTO.getA_content());
			// 파일추가
			pstmt.setString(5, noticeDTO.getA_file());	
			// 실행 
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}//insertEvent()	
	
//======================================== getEvent =========================================
	public NoticeDTO getEvent(int a_num) {
		NoticeDTO noticeDTO = null;
		try {
			con = getConnection();
			String sql="select * from admin where a_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, a_num);
			//4 실행 => 결과 저장
			rs = pstmt.executeQuery();
			//5 결과 행접근 => noticeDTO 객체생성 => set메서드 호출 => 열접근 데이터 저장
			if(rs.next()) {
				noticeDTO = new NoticeDTO();
				noticeDTO.setA_num(rs.getInt("a_num"));
				noticeDTO.setA_notice_type(rs.getString("a_notice_type"));
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
	}//getEvent	
	
//======================================= updateEvent =========================================
	public void updateEvent(NoticeDTO noticeDTO) {
		try {
			con = getConnection();
			String sql="update admin set a_title=?, a_content=?, a_file=? where a_num=?";
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
	}//updateEvent	
	
//=================================== deleteEvent =======================================
	public void deleteEvent(int a_num) {
		try {
			con = getConnection();
			String sql = "delete from admin where a_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,a_num);
			// 4단계
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}		
	}//deleteEvent()	
	
//===================================== getEventListSearch =============================================
	public List<NoticeDTO> getEventListSearch(NoticePageDTO pageDTO2) {
		System.out.println("NoticeDAO getEventListSearch()");
		List<NoticeDTO> eventList = null;
		try {
			con = getConnection();
			String sql="select * from admin where a_notice_type=? and a_title like ? order by a_num desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pageDTO2.getA_notice_type());//일반공지 / 이벤트
			pstmt.setString(2, "%"+pageDTO2.getSearch()+"%");
			pstmt.setInt(3, pageDTO2.getStartRow()-1);//시작행-1
			pstmt.setInt(4, pageDTO2.getPageSize());//몇개
			rs = pstmt.executeQuery();

			System.out.println(pstmt);
			// noticeList 객체생성
			eventList = new ArrayList<>();

			// 배열에 저장
			while (rs.next()) {
				NoticeDTO noticeDTO2 = new NoticeDTO();
				noticeDTO2.setA_num(rs.getInt("a_num"));
				noticeDTO2.setA_title(rs.getString("a_title"));
				noticeDTO2.setA_content(rs.getString("a_content"));
				noticeDTO2.setA_date(rs.getTimestamp("a_date"));
				eventList.add(noticeDTO2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}return eventList;
	}//getEventList

//====================================== getEventCountSearch ==================================
	public int getEventCountSearch(NoticePageDTO pageDTO2) {
		int count = 0;
		try {
			con=getConnection();
			String sql = "select count(*) from admin where a_title like ?;";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+pageDTO2.getSearch()+"%");//='%검색어%'
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return count;
	}//getEventCount



}//class
