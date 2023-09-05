package com.itwillbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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



//	유저체크
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
				// m_level 추가
				memberDTO.setM_id(rs.getString("m_id"));
				memberDTO.setM_pass(rs.getString("m_pass"));
				memberDTO.setM_level(rs.getInt("m_level"));

				System.out.println("로그인 성공!");
				
			} else {
//				아이디, 비밀번호 불일치 -> 초기값 null -> 리턴
				memberDTO = null;
				
				System.out.println("실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dblClose();
		}
		
		return memberDTO;
	}



	
//	
	public MemberDTO getMember(String m_id) {
		System.out.println("MemberDAO getMember()");
		
		MemberDTO memberDTO = null;
		
		try {
			
			
			con = getConnection();
			
			String sql = "select * from members where m_id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next() == true) {
				memberDTO = new MemberDTO();
				memberDTO.setM_num(rs.getInt("m_num"));
				memberDTO.setM_id(rs.getString("m_id"));
				memberDTO.setM_name(rs.getString("m_name"));
				memberDTO.setM_nick(rs.getString("m_nick"));
				memberDTO.setM_email(rs.getString("m_email"));
				memberDTO.setM_phone(rs.getString("m_phone"));
				memberDTO.setM_pass(rs.getString("m_pass"));
				memberDTO.setM_date(rs.getTimestamp("m_date"));
				memberDTO.setM_event(rs.getString("m_event"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dblClose();
		}
		
		return memberDTO;
	}


	
	
// 	닉네임 중복확인	
	public MemberDTO getNickCheck(String m_nick) {
		System.out.println("MemberDAO getNickCheck()");
		
		MemberDTO memberDTO = null;
		
		try {
			
			con = getConnection();
			String sql = "select * from members where m_nick = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_nick);
			
			rs = pstmt.executeQuery();
			
			if (rs.next() == true) {
				memberDTO = new MemberDTO();
				memberDTO.setM_nick(rs.getString("m_nick"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dblClose();
		}
		return memberDTO;
	}

	
	
	
//	이메일 중복확인	
	public MemberDTO getEmailCheck(String m_email) {
		System.out.println("MemberDAO getEmailCheck()");
		
		MemberDTO memberDTO = null;
		
		try {
			
			con = getConnection();
			String sql = "select * from members where m_email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_email);
			
			rs = pstmt.executeQuery();
			
			if (rs.next() == true) {
				memberDTO = new MemberDTO();
				memberDTO.setM_nick(rs.getString("m_email"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dblClose();
		}
		
		return memberDTO;
	}


	
	
	
	
	
	
	

//	회원정보 변경
	public void updateMember(MemberDTO memberDTO) {
		System.out.println("MemberDAO updateMember()");

		try {
			
			con = getConnection();
			
			String sql = "update members set m_pass = ?, m_email = ?, m_phone = ? where m_id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getM_pass());
			pstmt.setString(2, memberDTO.getM_email());
			pstmt.setString(3, memberDTO.getM_phone());
			pstmt.setString(4, memberDTO.getM_id());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dblClose();
		}
	}

	
	

//	회원삭제
	public void deleteMember(MemberDTO memberDTO) {
		System.out.println("MemberDAO deleteMember()");
		
		try {

			con = getConnection();
			
			String sql = "delete from members where m_id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getM_id());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dblClose();
		}
		
	}

	
	
	
	
	
	

	

//	멤버리스트
	public List<MemberDTO> getMemberList() {
		System.out.println("MemberDAO getMemberList()");

		
		List<MemberDTO> memberList = null;
		try {
			
			con = getConnection();
			
			String sql = "select * from members";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			memberList = new ArrayList<>();
			while (rs.next() == true) {
				MemberDTO memberDTO = new MemberDTO();
				System.out.println("회원 한 명 :" + memberDTO);
				
				
				memberDTO.setM_num(rs.getInt("m_num"));
				memberDTO.setM_id(rs.getString("m_id"));
				memberDTO.setM_pass(rs.getString("m_pass"));
				memberDTO.setM_name(rs.getString("m_name"));
				memberDTO.setM_nick(rs.getString("m_nick"));
				memberDTO.setM_email(rs.getString("m_email"));
				memberDTO.setM_phone(rs.getString("m_phone"));
				memberDTO.setM_date(rs.getTimestamp("m_date"));
				
				memberList.add(memberDTO);
			}
			System.out.println("배열에 회원 여러 명 : " + memberList);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dblClose();
		}
		
		return memberList;
	}


	
	
	
	
	


	// 8.31 진 - 아이디 찾기
	public MemberDTO findidmember(String m_name, String m_email) {

		System.out.println("MemberDAO findidmember()");
		MemberDTO memberDTO = null;
		try {
			con = getConnection();
			
			String sql = "SELECT * FROM members WHERE m_name = ? and m_email = ?";
			pstmt = con.prepareStatement(sql);
            pstmt.setString(1, m_name);
            pstmt.setString(2, m_email);

            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                memberDTO = new MemberDTO();
                memberDTO.setM_id(rs.getString("m_id"));
            }
            System.out.println(m_name + "," + m_email );
			System.out.println(memberDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dblClose();
		}
		return memberDTO; // 멤버 정보 반환
	} // findidmember


	// 8.31 진 - 비밀번호 찾기 주석처리해도 되나,,??
//	public MemberDTO findpwmember(String m_id, String m_email) {
//		
//		System.out.println("MemberDAO findpwmember()");
//		MemberDTO memberDTO = null;
//		try {
//			// 디비 연결
//			con = getConnection();
//			
//			String sql = "SELECT * FROM members WHERE m_id = ? and m_email = ?";
//			pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, m_id);
//            pstmt.setString(2, m_email);
//            
//            ResultSet rs = pstmt.executeQuery();
//			if(rs.next()) {
//                memberDTO = new MemberDTO();
//                memberDTO.setM_pass(rs.getString("m_pass"));	
//			}
//            System.out.println(m_id + "," + m_email );
//			System.out.println(memberDTO);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			dblClose();
//		}
//		return memberDTO; // 멤버 정보 반환
//	}


<<<<<<< HEAD
=======
  // 9월 5일 
	public int newPassword(MemberDTO memberDTO) {
		int result = 0;
		try {
			con = getConnection();
			
			PreparedStatement pst = con.prepareStatement("update members set m_pass = ? where m_email = ? ");
			pst.setString(1, memberDTO.getM_pass());
			pst.setString(2, memberDTO.getM_email());
			
			result = pst.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dblClose();
		}

		return result;
	} // newPassword()


 // 9.5 아이디와 비밀번호 일치한지 아닌지 DB 연동
	public MemberDTO IdAndEmailMatch(String m_id, String m_email) {
		MemberDTO memberDTO = null;
		try {
			con = getConnection();
			
			String sql = "SELECT * FROM members WHERE m_id = ? and m_email = ?";
			pstmt = con.prepareStatement(sql);
            pstmt.setString(1, m_id);
            pstmt.setString(2, m_email);
            
            ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
                memberDTO = new MemberDTO();
                memberDTO.setM_pass(rs.getString("m_pass"));	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dblClose();
		}
		return memberDTO;
	} // IdAndEmailMatch()


}	// insertMember()
>>>>>>> branch 'master' of https://github.com/HanHoeeun/EdIT.git





	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
	
	
	
	


