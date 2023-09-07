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
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.ReportDTO;
import com.itwillbs.service.AdminService;

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
	
	public MemberDTO getMemberInfo(MemberDTO member) {
		MemberDTO memberDTO = null;
		try {
			con = this.getConnection();
			String sql = "select m_num, m_nick from members where m_id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member.getM_id());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setM_num(rs.getInt("m_num"));
				memberDTO.setM_nick(rs.getString("m_nick"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return memberDTO;
	}
	
	
	public void insertBoard(AdminDTO adminDTO) {
		try {
//			아이디로 회원번호 닉네임 얻어오기 
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setM_id(adminDTO.getA_m_id());
			
			memberDTO = this.getMemberInfo(memberDTO);
			
			con = this.getConnection();
			String sql = "";
//			문의타입 아이디 제목 내용 파일
			
			
//			1게시글번호 (2회원번호 3닉네임 4제목 5내용) 6답변 (7파일명) 8확인용 9작성시간 10문의타입 11공지타입
				sql = "insert into admin values (default,?,?,?,?,null,?,default,default,?,null)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, memberDTO.getM_num());
			pstmt.setString(2, memberDTO.getM_nick());
			pstmt.setString(3, adminDTO.getA_title());
			pstmt.setString(4, adminDTO.getA_content());
			pstmt.setString(5, adminDTO.getA_file());
			pstmt.setString(6, adminDTO.getA_cs_type());
			
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
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setM_id(pageDTO.getSearch());
			
			memberDTO = this.getMemberInfo(memberDTO);

			con = this.getConnection();
			
			String sql = "select * from admin where a_m_nick = ? order by a_num desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			
			//지금 아이디 
			pstmt.setString(1, memberDTO.getM_nick());
			
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
				adminDTO.setA_check(rs.getInt("a_check"));
				
				
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
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setM_id(pageDTO.getSearch());
			
			memberDTO = this.getMemberInfo(memberDTO);
			
			con = this.getConnection();
			String sql = "select count(*) as count from admin where a_m_nick = ? ";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, memberDTO.getM_nick());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return count;
	}
	
	public List<AdminDTO> getBoardList(AdminPageDTO pageDTO) {
		List<AdminDTO> adminList = null;
		try {
			con = this.getConnection();
			
			String sql;
			if(pageDTO.getSearch() == "전체") {
				sql ="select * from admin order by a_num desc limit ?, ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, pageDTO.getStartRow()-1); // 시작하는 행 -1 
				pstmt.setInt(2, pageDTO.getPageSize()); // 몇개
			}else {
				sql ="select * from admin where a_cs_type = ? order by a_num desc limit ?, ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, pageDTO.getSearch());
				pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
				pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
			}
			
			rs = pstmt.executeQuery();
			adminList = new ArrayList<>();
			while(rs.next()) {
				AdminDTO adminDTO = new AdminDTO();
				adminDTO.setA_num(rs.getInt("a_num"));
				adminDTO.setA_title(rs.getString("a_title"));
				adminDTO.setA_m_nick(rs.getString("a_m_nick"));
				adminDTO.setA_date(rs.getTimestamp("a_date"));
				adminDTO.setA_check(rs.getInt("a_check"));
				adminDTO.setA_cs_type(rs.getString("a_cs_type"));
				
				
				adminList.add(adminDTO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		
		return adminList;
		
	}
	public int getBoardCount(AdminPageDTO pageDTO) {
		int count = 0;
		
		try {
			con = this.getConnection();
			String sql;
			if(pageDTO.getSearch() == "전체") {
				sql = "select count(*) as count from admin";
				pstmt = con.prepareStatement(sql);
			}else {
				sql = "select count(*) as count from admin where a_cs_type = ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, pageDTO.getSearch());
			}
			
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return count;
	}
	public AdminDTO getBoardContent(int a_num) {
		AdminDTO adminDTO = null;
		try {
			con = this.getConnection();
			
			String sql = "select * from admin where a_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,a_num);
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
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		
		return adminDTO;
	}
	
	public void updateFaqAnswer(AdminDTO adminDTO) {
		try {
			con = this.getConnection();
			String sql = "update admin set a_answer = ?, a_check = 1 where a_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adminDTO.getA_answer());
			pstmt.setInt(2, adminDTO.getA_num());
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
	}
	
	public List<ReportDTO> getReportList(AdminPageDTO pageDTO) {
		List<ReportDTO> reportList = null;
		try {
			con = this.getConnection();
			
			String sql = "select * from report order by r_num desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setInt(1, pageDTO.getStartRow()-1); // 시작하는 행 -1 
			pstmt.setInt(2, pageDTO.getPageSize()); // 몇개
			
			rs = pstmt.executeQuery();
			reportList = new ArrayList<>();
			while(rs.next()) {
//				신고번호 회원번호 제목 작성자 작성시간 확인여부
				ReportDTO reportDTO = new ReportDTO();
				reportDTO.setR_num(rs.getInt("r_num"));
				reportDTO.setR_m_num(rs.getInt("r_m_num"));
				reportDTO.setR_title(rs.getString("r_title"));
				reportDTO.setR_date(rs.getTimestamp("r_date"));
				reportDTO.setR_check(rs.getInt("r_check"));
				
				reportList.add(reportDTO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return reportList;
	}
	public int getReportCount(AdminPageDTO pageDTO) {
		int count = 0;
		
		try {
			con = this.getConnection();
			String sql = "select count(*) as count from report";
			pstmt = con.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return count;
	}

//	report 번호로 맴버테이블 닉네임 반환
	public String getTargetId(int r_num) {
		String target_id=null;
		try {
			con = this.getConnection();
//			신고자 대상자 아이디
			String sql = "select m.m_nick nick "
					+ "from report r join members m "
					+ "on r.r_m_target = m.m_num "
					+ "where r_num = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r_num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				target_id = rs.getString("nick");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		return target_id;
	}
	
	public ReportDTO getReportContent(int r_num) {
		ReportDTO reportDTO = new ReportDTO();
		try {
			con = this.getConnection();
			
//			신고 아이디 및 신고정보 
			String sql = "select *  "
					+ "from report r join members m "
					+ "on r.r_m_num =  m.m_num "
					+ "where r.r_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r_num);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String target_id = this.getTargetId(r_num);
				
				reportDTO.setR_m_target_id(target_id);
				reportDTO.setR_num(rs.getInt("r_num"));
				reportDTO.setR_m_num_id(rs.getString("m_nick"));
				reportDTO.setR_title(rs.getString("r_title"));
				reportDTO.setR_file(rs.getString("r_file"));
				reportDTO.setR_content(rs.getString("r_content"));
				reportDTO.setR_answer(rs.getString("r_answer"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		
		return reportDTO;
	}
	public void updateReportAnswer(ReportDTO reportDTO) {
		try {
			con = this.getConnection();
			
			String sql = "update report set r_answer = ?, r_check = 1 where r_num = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, reportDTO.getR_answer());
			pstmt.setInt(2, reportDTO.getR_num());
			
			pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
	}
	
//	닉네임으로 m_count 반환 
	public int getMemberCountCheck(String m_nick) {
		int m_count = 0;
		try {
			con = this.getConnection();
			String sql = "select m_count from members where m_nick = ?";;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_nick);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				m_count = rs.getInt("m_count");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
//			this.dbClose();
		}
		return m_count;
	}
	
	public int updateReportCheck(ReportDTO reportDTO) {
		int result = 0;
		try {
			String m_nick = this.getTargetId(reportDTO.getR_num());
			int m_count = this.getMemberCountCheck(m_nick);
//			m_count 3보다 작아야 작동 
//			count 가 2면 +1 하고 블랙리스트 등록 m_level 			
			if(m_count == 2){
				result = m_count +1;
				con = this.getConnection();
				String sql = "update members set m_count = m_count + 1, m_level = 1 where m_nick = ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, m_nick);
				
				pstmt.executeUpdate();
			}else if(m_count < 3 ) {
				result = m_count + 1;
				con = this.getConnection();
				String sql = "update members set m_count = m_count + 1 where m_nick = ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, m_nick);
				
				pstmt.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		System.out.println("유저 DAO count 횟수 : " + result);
		return result;
	}
	public int updateBlackReason(ReportDTO reportDTO) {
		int result = 0;
		try {
			String m_nick = this.getTargetId(reportDTO.getR_num());
		
			con = this.getConnection();
			String sql = "update members set m_event =? where m_nick = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, reportDTO.getBl_reason());
			pstmt.setString(2, m_nick);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		System.out.println("유저 DAO count 횟수 : " + result);
		return result;
	}
	
	
	public List<MemberDTO> getMemberList(AdminPageDTO pageDTO) {
		List<MemberDTO> memberList = null;
		try {
			con = this.getConnection();
			
			String sql;
			
			
			if(pageDTO.getSearch() != null) {
				if(pageDTO.getSearch_type() == 1) {
					sql = "select * from members where m_num = ? order by m_num desc limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, Integer.parseInt(pageDTO.getSearch()));
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}else if(pageDTO.getSearch_type() == 2) {
					sql = "select * from members where m_id = ? order by m_num desc limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}else if(pageDTO.getSearch_type() == 3) {
					sql = "select * from members where m_nick = ? order by m_num desc limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}else if(pageDTO.getSearch_type() == 4) {
					sql = "select * from members where m_count = ? order by m_num desc limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, Integer.parseInt(pageDTO.getSearch()));
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}else if(pageDTO.getSearch()=="null" || pageDTO.getSearch().equals("null")) {
//					search=null 로 전달될때 getParameter로 읽으면 문자열 null 이 돼서 막아줘야한다
					sql = "select * from members order by m_num desc limit ?, ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(2, pageDTO.getPageSize()); // 몇개
				}
			}else{
				sql = "select * from members order by m_num desc limit ?, ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, pageDTO.getStartRow()-1); // 시작하는 행 -1 
				pstmt.setInt(2, pageDTO.getPageSize()); // 몇개
			}
			
			rs = pstmt.executeQuery();
			memberList = new ArrayList<>();
			while(rs.next()) {
//				회원번호 아이디 닉네임 이름 신고횟수 
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setM_num(rs.getInt("m_num"));
				memberDTO.setM_id(rs.getString("m_id"));
				memberDTO.setM_nick(rs.getString("m_nick"));
				memberDTO.setM_name(rs.getString("m_name"));
				memberDTO.setM_count(rs.getInt("m_count"));
				
				memberList.add(memberDTO);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		
		return memberList;
	}
	public MemberDTO getMemberContent(int num) {
		MemberDTO memberDTO = new MemberDTO();
		try {
			con = this.getConnection();
			
//			신고 아이디 및 신고정보 
			String sql = "select * from members where m_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDTO.setM_num(rs.getInt("m_num"));
				memberDTO.setM_id(rs.getString("m_id"));
				memberDTO.setM_name(rs.getString("m_name"));
				memberDTO.setM_nick(rs.getString("m_nick"));
				memberDTO.setM_phone(rs.getString("m_phone"));
				memberDTO.setM_email(rs.getString("m_email"));
				memberDTO.setM_date(rs.getTimestamp("m_date"));
				memberDTO.setM_event(rs.getString("m_event"));
				memberDTO.setM_level(rs.getInt("m_level"));
				memberDTO.setM_count(rs.getInt("m_count"));
			}
		} catch (Exception e) {

		}finally {
			this.dbClose();
		}
		
		return memberDTO;
		
	}
	public void updateUserContent(MemberDTO memberDTO) {
		try {
			con = this.getConnection();
			
//			신고 아이디 및 신고정보 
			String sql = "update members "  
					+ "set m_id = ?, m_name = ?, m_nick = ?, m_phone = ?, m_email = ?, m_event = ?, m_level = ?, m_count = ? " 
					+ "where m_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getM_id());
			pstmt.setString(2, memberDTO.getM_name());
			pstmt.setString(3, memberDTO.getM_nick());
			pstmt.setString(4, memberDTO.getM_phone());
			pstmt.setString(5, memberDTO.getM_email());
//			pstmt.setTimestamp(6, memberDTO.getM_date());
			pstmt.setString(6, memberDTO.getM_event());
			pstmt.setInt(7, memberDTO.getM_level());
			pstmt.setInt(8, memberDTO.getM_count());
			pstmt.setInt(9, memberDTO.getM_num());
			
			pstmt.executeUpdate();
		
		} catch (Exception e) {

		}finally {
			this.dbClose();
		}
	}
	public int getMemberCountSearch(AdminPageDTO pageDTO) {
		int count = 0;
		
		try {
			con = this.getConnection();
			String sql;
			if(pageDTO.getSearch() != null) {
				if(pageDTO.getSearch_type() == 1) {
					sql = "select count(*) as count from members where m_num = ? limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, Integer.parseInt(pageDTO.getSearch()));
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}
				if(pageDTO.getSearch_type() == 2) {
					sql = "select count(*) as count from members where m_id = ? limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}
				if(pageDTO.getSearch_type() == 3) {
					sql = "select count(*) as count from members where m_nick = ? limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}
				if(pageDTO.getSearch_type() == 4) {
					sql = "select count(*) as count from members where m_count = ? limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, Integer.parseInt(pageDTO.getSearch()));
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}
			}else {
				sql = "select count(*) as count from members limit ?, ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, pageDTO.getStartRow()-1); // 시작하는 행 -1 
				pstmt.setInt(2, pageDTO.getPageSize()); // 몇개
			}
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return count;
	}
	public List<MemberDTO> getBlackList(AdminPageDTO pageDTO) {
		List<MemberDTO> blackList = new ArrayList<>();
		try {
			con = this.getConnection();
//			블랙리스트 출력 
			String sql;
//			아이디 이름 이메일 
			if(pageDTO.getSearch() != null) {
				if(pageDTO.getSearch_type() == 1) {
					sql = "select * from members where m_id = ? and m_count = 3 limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}else if(pageDTO.getSearch_type() == 2) {
					sql = "select * from members where m_name = ? and m_count = 3 limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}else if(pageDTO.getSearch_type() == 3) {
					sql = "select * from members where m_email = ? and m_count = 3 limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}else {
					sql = "select * from members where m_count = 3 limit ?, ?";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(2, pageDTO.getPageSize()); // 몇개
				}
			}else {
				sql = "select * from members where m_count = 3 limit ?, ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, pageDTO.getStartRow()-1); // 시작하는 행 -1 
				pstmt.setInt(2, pageDTO.getPageSize()); // 몇개
			}
			
			rs = pstmt.executeQuery();
			AdminService adminService = new AdminService();
//			회원번호 아이디 이름 이메일 전화번호 
			while(rs.next()) {
				MemberDTO memberDTO = new MemberDTO();
				
				memberDTO.setM_num(rs.getInt("m_num"));
				memberDTO.setM_id(rs.getString("m_id"));
				memberDTO.setM_name(rs.getString("m_name"));
				memberDTO.setM_email(rs.getString("m_email"));

				String phone = adminService.formatPhoneNumber(rs.getString("m_phone"));
				
				memberDTO.setM_phone(phone);
				
				blackList.add(memberDTO);
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		
		return blackList;
	}
	public int getBlackCountSearch(AdminPageDTO pageDTO) {
		int count = 0;
		
		try {
			con = this.getConnection();
			String sql;
			
//			아이디 이름 이메일 
			if(pageDTO.getSearch() != null) {
				if(pageDTO.getSearch_type() == 1) {
					sql = "select count(*) as count from members where m_id = ? and m_count = 3 limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}
				if(pageDTO.getSearch_type() == 2) {
					sql = "select count(*) as count from members where m_name = ? and m_count = 3 limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}
				if(pageDTO.getSearch_type() == 3) {
					sql = "select count(*) as count from members where m_email = ? and m_count = 3 limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}
			}else {
				sql = "select count(*) as count from members where m_count = 3 limit ?, ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, pageDTO.getStartRow()-1); // 시작하는 행 -1 
				pstmt.setInt(2, pageDTO.getPageSize()); // 몇개
			}
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return count;
	}
	
}
