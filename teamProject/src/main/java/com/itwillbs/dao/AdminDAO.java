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
	
//	세션에서 받은 m_id를 기준으로 members 테이블의 회원 정보를 받는 메서드
	public MemberDTO getMemberInfo(MemberDTO member) {
		MemberDTO memberDTO = null;
		try {
			con = this.getConnection();
			String sql = "SELECT m_num, m_nick "
					+ 	 "FROM members "
					+ 	 "WHERE m_id = ?";
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
		}finally {
			this.dbClose();
		}
		
		
		
		return memberDTO;
	}
	
//	admin 테이블에 값을 넣는다 (고객센터 문의글 삽입)
	public void FAQBoardInsert(AdminDTO adminDTO) {
		try {
//			아이디로 회원번호 닉네임 얻어오기 
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setM_id(adminDTO.getA_m_id());
			
			memberDTO = this.getMemberInfo(memberDTO);
			
			con = this.getConnection();
			String sql = "";
//			문의타입 아이디 제목 내용 파일
			
			
//			1게시글번호 (2회원번호 3닉네임 4제목 5내용) 6답변 (7파일명) 8확인용 9작성시간 10문의타입 11공지타입
				sql = "INSERT INTO admin "
					+ "VALUES (DEFAULT ,? ,? ,? ,? , NULL, ?, DEFAULT, DEFAULT, ?, NULL)";
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
//	내 문의내역 리스트 출력 
//	search = m_num 으로 자기 자신의 문의내역 리스트만 호출
	public List<AdminDTO> getFAQBoardList(AdminPageDTO pageDTO) {
		List<AdminDTO> adminList = null;
		try {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setM_id(pageDTO.getSearch());
			
			memberDTO = this.getMemberInfo(memberDTO);

			con = this.getConnection();
			
			String sql = "SELECT * "
					+ 	 "FROM admin "
					+ 	 "WHERE a_m_nick = ? "
					+ 	 "ORDER BY a_num DESC "
					+ 	 "LIMIT ?, ?";
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
//	내문의 내역 글 수 확인 => 페이징 처리를 위해서 
	public int getFAQBoardCount(AdminPageDTO pageDTO) {
		int count = 0;
		
		try {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setM_id(pageDTO.getSearch());
			
			memberDTO = this.getMemberInfo(memberDTO);
			
			con = this.getConnection();
			String sql = "SELECT COUNT(*) AS COUNT "
					+ 	 "FROM admin "
					+ 	 "WHERE a_m_nick = ? ";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, memberDTO.getM_nick());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		return count;
	}
	
//	관리자 페이지에서 모든 문의 내역 확인 
	public List<AdminDTO> getAdminFAQBoardList(AdminPageDTO pageDTO) {
		List<AdminDTO> adminList = null;
		try {
			con = this.getConnection();
			
			String sql;

			if(pageDTO.getSearch() == "전체" || pageDTO.getSearch().equals("전체")) {
//				기본은 전체 검색
				sql = "SELECT * "
					+ "FROM admin "
					+ "ORDER BY a_num DESC "
					+ "LIMIT ?, ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, pageDTO.getStartRow()-1); // 시작하는 행 -1 
				pstmt.setInt(2, pageDTO.getPageSize()); // 몇개
			}else {
//				문의 타입에 따라 검색 
				sql = "SELECT * "
					+ "FROM admin "
					+ "WHERE a_cs_type = ? "
					+ "ORDER BY a_num DESC "
					+ "LIMIT ?, ?";
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
//	관리자 페이지 문의 내역 페이징 처리를 위한 글 갯수 구하는 메서드 
	public int getAdminFAQBoardCount(AdminPageDTO pageDTO) {
		int count = 0;
		
		try {
			con = this.getConnection();
			
			String sql;
			
			if(pageDTO.getSearch() == "전체" || pageDTO.getSearch().equals("전체")) {
//				기본은 전체 
				sql = "SELECT COUNT(*) AS COUNT "
					+ "FROM admin";
				pstmt = con.prepareStatement(sql);
			}else {
//				문의 타입에 따라서 검색
				sql = "SELECT COUNT(*) AS COUNT "
					+ "FROM admin "
					+ "WHERE a_cs_type = ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, pageDTO.getSearch());
			}
			
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		return count;
	}
	
//	문의 내역 내용 확인
//	admin 테이블의 기본키로 검색
	public AdminDTO getFAQBoardContent(int a_num) {
		AdminDTO adminDTO = null;
		try {
			con = this.getConnection();
			
			String sql = "SELECT a.a_num AS a_num, a.a_m_nick AS a_m_nick, a.a_title AS a_title, "
					+ 	 "a.a_file AS a_file, a.a_content AS a_content, a.a_answer AS a_answer, "
					+ 	 "m.m_id AS m_id "
					+ 	 "FROM admin a JOIN members m "
					+ 	 "ON a.a_m_nick = m.m_nick "
					+	 "WHERE a.a_num = ? ";
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
				adminDTO.setA_m_id(rs.getString("m_id"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		
		return adminDTO;
	}
	
//	문의 내역 답변 작성 
	public void updateFAQAnswer(AdminDTO adminDTO) {
		try {
			con = this.getConnection();
			
			String sql = "UPDATE admin "
					+ 	 "SET a_answer = ?, a_check = 1 "
					+ 	 "WHERE a_num = ?";
			
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
	
//	관리자 페이지 신고 게시판 리스트 
	public List<ReportDTO> getAdminReportList(AdminPageDTO pageDTO) {
		List<ReportDTO> reportList = null;
		try {
			con = this.getConnection();
			
			String sql = "SELECT * "
					+ 	 "FROM report "
					+ 	 "ORDER BY r_num DESC "
					+ 	 "LIMIT ?, ?";
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
			this.dbClose();
		}
		
		return reportList;
	}
//	관리자 페이지 신고 게시판 페이징 처리용 count 
	public int getAdminReportCount(AdminPageDTO pageDTO) {
		int count = 0;
		
		try {
			con = this.getConnection();
			String sql = "SELECT COUNT(*) AS COUNT "
					+ 	 "FROM report";
			pstmt = con.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		return count;
	}

//	report 번호로 맴버테이블 닉네임 반환
	public String getTargetId(int r_num) {
		String target_id=null;
		try {
			con = this.getConnection();
//			신고자 대상자 아이디
			String sql = "SELECT m.m_nick nick "
					+ 	 "FROM report r JOIN members m "
					+	 "ON r.r_m_target = m.m_num "
					+ 	 "WHERE r_num = ?";

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
	
//	신고테이블 기본키 신고 번호로 신고 상세내용 호출 
	public ReportDTO getReportContent(int r_num) {
		ReportDTO reportDTO = new ReportDTO();
		try {
			String target_nick = this.getTargetId(r_num);
			con = this.getConnection();
			
//			신고 아이디 및 신고정보 
			String sql = "SELECT *  "
					+ 	 "FROM report r JOIN members m "
					+ 	 "ON r.r_m_num =  m.m_num "
					+ 	 "WHERE r.r_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r_num);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
//				신고번호로 신고 대상자 아이디 구하는 부분 
				
				
				reportDTO.setR_m_target_nick(target_nick);
				reportDTO.setR_num(rs.getInt("r_num"));
				reportDTO.setR_m_num_nick(rs.getString("m_nick"));
				reportDTO.setR_title(rs.getString("r_title"));
				reportDTO.setR_file(rs.getString("r_file"));
				reportDTO.setR_content(rs.getString("r_content"));
				reportDTO.setR_answer(rs.getString("r_answer"));
				reportDTO.setR_m_num_id(rs.getString("m_id"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		
		return reportDTO;
	}
	
//	신고게시판 신고 답변 등록 
	public void updateReportAnswer(ReportDTO reportDTO) {
		try {
			con = this.getConnection();
			
			String sql = "UPDATE report "
					+ 	 "SET r_answer = ?, r_check = 1 "
					+ 	 "WHERE r_num = ?";
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
	
//	닉네임으로 회원정보 테이블의 신고 횟수 구하는 부분
	public int getMemberCountCheck(String m_nick) {
		int m_count = 0;
		try {
			con = this.getConnection();
			String sql = "SELECT m_count "
					+ 	 "FROM members "
					+ 	 "WHERE m_nick = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_nick);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				m_count = rs.getInt("m_count");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose(); 
		}
		return m_count;
	}
	
//	신고를 적용하는 부분
//	신고를 적용하면 신고횟수 m_count +1 되고 
//	m_count가 3이 되면 m_level 도 +1 이 된다 
//	m_level = 0 일반회원, 1 블랙리스트, 2 관리자 
	public int updateReportCheck(ReportDTO reportDTO) {
		int result = 0;
		try {
//			신고 번호로 m_nick을 얻어온다
			String m_nick = this.getTargetId(reportDTO.getR_num());
//			m_nick으로 신고 횟수 반환 서브쿼리를 사용해도 된다 
			int m_count = this.getMemberCountCheck(m_nick);
			
//			m_count 3보다 작아야 작동 
//			count 가 2면 +1 하고 블랙리스트 등록 m_level 			
			if(m_count == 2){
				result = m_count +1;
				con = this.getConnection();
				String sql = "UPDATE members "
						+ 	 "SET m_count = m_count + 1, m_level = 1 "
						+ 	 "WHERE m_nick = ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, m_nick);
				
				pstmt.executeUpdate();
			}else if(m_count < 3 ) {
				result = m_count + 1;
				con = this.getConnection();
				String sql = "UPDATE members "
						+ 	 "SET m_count = m_count + 1 "
						+ 	 "WHERE m_nick = ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, m_nick);
				
				pstmt.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		return result;
	}
	
//	신고 적용시 신고횟수가 3이 반환이 되면 정지 사유를 입력 할 수 있다.
	public int updateBlackReason(ReportDTO reportDTO) {
		int result = 0;
		try {
			String m_nick = this.getTargetId(reportDTO.getR_num());
		
			con = this.getConnection();
			String sql = "UPDATE members "
					+ 	 "SET m_event = ? "
					+ 	 "WHERE m_nick = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, reportDTO.getBl_reason());
			pstmt.setString(2, m_nick);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		return result;
	}
	
//	관리자 페이지에서 회원 정보 리스트를 호출 
	public List<MemberDTO> getMemberList(AdminPageDTO pageDTO) {
		List<MemberDTO> memberList = null;
		try {
			con = this.getConnection();
			
			String sql;
			
//			검색이 있는 경우 다시 검색 분류별로 리스트 호출 
			if(pageDTO.getSearch() != null) {
//				getParameter로 null 값이 넘어오는데 그게 문자열로 오기 때문에 막아준다 
				if(pageDTO.getSearch() == "null" || pageDTO.getSearch().equals("null")) {
					sql = "SELECT * "
						+ "FROM members "
						+ "ORDER BY m_num DESC "
						+ "LIMIT ?, ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(2, pageDTO.getPageSize()); // 몇개
				}else if(pageDTO.getSearch_type() == 1) {
//					회원 번호로 검색 
					sql = "SELECT * "
						+ "FROM members "
						+ "WHERE m_num = ? "
						+ "ORDER BY m_num DESC "
						+ "LIMIT ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, Integer.parseInt(pageDTO.getSearch()));
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}else if(pageDTO.getSearch_type() == 2) {
//					회원 아이디로 검색
					sql = "SELECT * "
						+ "FROM members "
						+ "WHERE m_id = ? "
						+ "ORDER BY m_num DESC "
						+ "LIMIT ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}else if(pageDTO.getSearch_type() == 3) {
//					회원 닉네임으로 검색
					sql = "SELECT * "
						+ "FROM members "
						+ "WHERE m_nick = ? "
						+ "ORDER BY m_num DESC "
						+ "LIMIT ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}else if(pageDTO.getSearch_type() == 4) {
//					신고 횟수 검색 
					sql = "SELECT * "
						+ "FROM members "
						+ "WHERE m_count = ? "
						+ "ORDER BY m_num DESC "
						+ "LIMIT ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, Integer.parseInt(pageDTO.getSearch()));
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}
				
			}else{
//				검색이 없을 경구 모든 회원 정보 출력 
				sql = "SELECT * "
					+ "FROM members "
					+ "ORDER BY m_num DESC "
					+ "LIMIT ?, ?";
				
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
//	회원 정보 페이징 처리를 위한 count 호출 
	public int getMemberCountSearch(AdminPageDTO pageDTO) {
		int count = 0;
		
		try {
			con = this.getConnection();
			String sql;
			if(pageDTO.getSearch() != null) {
				if(pageDTO.getSearch() == "null" || pageDTO.getSearch().equals("null")) {
					sql = "SELECT COUNT(*) AS COUNT "
						+ "FROM members";
					pstmt = con.prepareStatement(sql);
					
				}else if(pageDTO.getSearch_type() == 1) {
					sql = "SELECT COUNT(*) AS COUNT "
						+ "FROM members "
						+ "WHERE m_num = ?";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, Integer.parseInt(pageDTO.getSearch()));
				}else if(pageDTO.getSearch_type() == 2) {
					sql = "SELECT COUNT(*) AS COUNT "
						+ "FROM members "
						+ "WHERE m_id = ?";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
				}else if(pageDTO.getSearch_type() == 3) {
					sql = "SELECT COUNT(*) AS COUNT "
						+ "FROM members "
						+ "WHERE m_nick = ?";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
				}else if(pageDTO.getSearch_type() == 4) {
					sql = "SELECT COUNT(*) AS COUNT "
						+ "FROM members "
						+ "WHERE m_count = ?";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, Integer.parseInt(pageDTO.getSearch()));
				}
			}else {
				sql = "SELECT COUNT(*) AS COUNT "
					+ "FROM members";
				pstmt = con.prepareStatement(sql);
			}
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		return count;
	}
	
//	회원 정보 상세 내용 
	public MemberDTO getMemberContent(int num) {
		MemberDTO memberDTO = new MemberDTO();
		try {
			con = this.getConnection();
			
//			신고 아이디 및 신고정보 
			String sql = "SELECT * "
					+ 	 "FROM members "
					+ 	 "WHERE m_num = ?";
			
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
	
//	관리자 페이지에서 회원 정보 수정 
	public void updateUserContent(MemberDTO memberDTO) {
		try {
			con = this.getConnection();
			
//			신고 아이디 및 신고정보 
			String sql = "UPDATE members "  
					+ 	 "SET m_id = ?, m_name = ?, m_nick = ?, m_phone = ?, m_email = ?, m_event = ?, m_level = ?, m_count = ? " 
					+ 	 "WHERE m_num = ?";
			
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
	
//	관리자 페이지 블랙리스트 호출 
	public List<MemberDTO> getBlackList(AdminPageDTO pageDTO) {
		List<MemberDTO> blackList = new ArrayList<>();
		try {
			con = this.getConnection();
//			블랙리스트 출력 
			String sql;
//			아이디 이름 이메일 
			if(pageDTO.getSearch() != null) {
				if(pageDTO.getSearch() == "null" || pageDTO.getSearch().equals("null")) {
					sql = "SELECT * "
						+ "FROM members "
						+ "WHERE m_count = 3 "
						+ "ORDER BY m_num DESC "
						+ "LIMIT ?, ?";
						pstmt = con.prepareStatement(sql);
						
						pstmt.setInt(1, pageDTO.getStartRow()-1); // 시작하는 행 -1 
						pstmt.setInt(2, pageDTO.getPageSize()); // 몇개
				}else if(pageDTO.getSearch_type() == 1) {
					sql = "SELECT * "
						+ "FROM members "
						+ "WHERE m_id = ? AND m_count = 3 "
						+ "ORDER BY m_num DESC "
						+ "LIMIT ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}else if(pageDTO.getSearch_type() == 2) {
					sql = "SELECT * "
						+ "FROM members "
						+ "WHERE m_name = ? AND m_count = 3 "
						+ "ORDER BY m_num DESC "
						+ "LIMIT ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}else if(pageDTO.getSearch_type() == 3) {
					sql = "SELECT * "
						+ "FROM members "
						+ "WHERE m_email = ? AND m_count = 3 "
						+ "ORDER BY m_num DESC "
						+ "LIMIT ?, ? ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
					pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
					pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
				}
			}else {
				sql = "SELECT * "
					+ "FROM members "
					+ "WHERE m_count = 3 "
					+ "ORDER BY m_num DESC "
					+ "LIMIT ?, ?";
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
//	블랙리스트 페이징 처리
	public int getBlackCountSearch(AdminPageDTO pageDTO) {
		int count = 0;
		
		try {
			con = this.getConnection();
			String sql;
			
//			아이디 이름 이메일 
			if(pageDTO.getSearch() != null) {
				if(pageDTO.getSearch() == "null" || pageDTO.getSearch().equals("null")) {
					sql = "SELECT COUNT(*) as COUNT "
						+ "FROM members "
						+ "WHERE m_count = 3 "
						+ "ORDER BY m_num DESC ";
					pstmt = con.prepareStatement(sql);
				}else if(pageDTO.getSearch_type() == 1) {
					sql = "SELECT COUNT(*) as COUNT "
						+ "FROM members "
						+ "WHERE m_id = ? AND m_count = 3 "
						+ "ORDER BY m_num DESC ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
				}else if(pageDTO.getSearch_type() == 2) {
					sql = "SELECT COUNT(*) as COUNT "
						+ "FROM members "
						+ "WHERE m_name = ? AND m_count = 3 "
						+ "ORDER BY m_num DESC ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
				}else if(pageDTO.getSearch_type() == 3) {
					sql = "SELECT COUNT(*) as COUNT "
						+ "FROM members "
						+ "WHERE m_email = ? AND m_count = 3 "
						+ "ORDER BY m_num DESC ";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, pageDTO.getSearch());
				}
			}else {
				sql = "SELECT COUNT(*) as COUNT "
					+ "FROM members "
					+ "WHERE m_count = 3 "
					+ "ORDER BY m_num DESC ";                                                                                                            
				pstmt = con.prepareStatement(sql);
			}
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return count;
	}
	
//============================================= 신고하기 =================================================	
	public void insertReport(ReportDTO reportDTO) {
		System.out.println("AdminDAO insertReport()");
		System.out.println("admin report r_m_num" + reportDTO.getR_m_num() + reportDTO.getR_m_target());
		try {
			con=getConnection();
			
			// 글번호 신고자번호 신고대상자번호 제목 내용 답변 작성일 처리여부 파일
			String sql = "INSERT INTO report "
					+	 "VALUES (DEFAULT, ?, ?, ?, ?, NULL, DEFAULT, NULL, ?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, reportDTO.getR_m_num());//신고자번호
			pstmt.setInt(2, reportDTO.getR_m_target());//신고대상자번호
			
			pstmt.setString(3, reportDTO.getR_title());//제목
			pstmt.setString(4, reportDTO.getR_content());//내용
			// 파일추가
			pstmt.setString(5, reportDTO.getR_file());
			// 실행 
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}//insertNotice()


	
	
	
	
	
	
	
}//class

