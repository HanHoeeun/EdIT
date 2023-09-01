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
				sql = "insert into test_1 values (default,?,?,?,default,'계정',?,null)";
			}else if(adminDTO.getA_cs_type() == 2) {
				sql = "insert into test_1 values (default,?,?,?,default,'중고거래',?,null)";
			}else {
				sql = "insert into test_1 values (default,?,?,?,default,'기타',?,null)";
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
		}finally {
			dbClose();
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
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		
		return adminDTO;
	}
	public List<ReportDTO> getReportList(AdminPageDTO pageDTO) {
		List<ReportDTO> reportList = null;
		try {
			con = this.getConnection();
			
			String sql = "select * from report_test order by r_num desc limit ?, ?";
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
			String sql = "select count(*) as count from report_test";
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
	
	public String getTagetId(int num) {
		String target_id=null;
		try {
			con = this.getConnection();
//			신고자 대상자 아이디
			String sql = "select m.r_name name "
					+ "from report_test r join report_test_member m "
					+ "on r.r_m_target = m.r_m_num "
					+ "where r_num = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				target_id = rs.getString("name");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		return target_id;
	}
	
	public ReportDTO getReportContent(int num) {
		ReportDTO reportDTO = new ReportDTO();
		try {
			con = this.getConnection();
			
//			신고 아이디 및 신고정보 
			String sql = "select *  "
					+ "from report_test r join report_test_member m "
					+ "on r.r_m_num =  m.r_m_num "
					+ "where r.r_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String target_id = this.getTagetId(num);
				
				reportDTO.setR_m_target_id(target_id);
				reportDTO.setR_num(rs.getInt("r_num"));
				reportDTO.setR_m_num_id(rs.getString("r_name"));
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
			
			String sql = "update report_test set r_answer = ? where r_num = ?";
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
	public void updateReportCheck(ReportDTO reportDTO) {
		try {
			con = this.getConnection();
			
			String sql = "update report_test set r_check = 1 where r_num = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, reportDTO.getR_num());
			
			pstmt.executeUpdate();
//			신고 적용후에 member check에도 적용해야됨
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
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
				}
				if(pageDTO.getSearch_type() == 2) {
					sql = "select * from members where m_id = ? order by m_num desc limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}
				if(pageDTO.getSearch_type() == 3) {
					sql = "select * from members where m_nick = ? order by m_num desc limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}
				if(pageDTO.getSearch_type() == 4) {
					sql = "select * from members where m_count = ? order by m_num desc limit ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, Integer.parseInt(pageDTO.getSearch()));
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}
			}else {
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
			String sql = "select count(*) as count from members where a_m_nick like ? ";
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
}
