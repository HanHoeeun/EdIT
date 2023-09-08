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

import com.itwillbs.domain.AdminPageDTO;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.ProductDTO;
import com.itwillbs.domain.ProductPageDTO;
import com.itwillbs.domain.ReportDTO;
import com.itwillbs.domain.WishListDTO;

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
	public void dbClose() {
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
			dbClose();
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
			dbClose();
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
			dbClose();
		}
		
		return memberDTO;
	}

	public MemberDTO userCheck2(MemberDTO memberDTO2) {
		MemberDTO memberDTO = null;
		
		try {
			
			con = getConnection();
			String sql = "select * from members where m_id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO2.getM_id());

			
			rs = pstmt.executeQuery();
			
//			첫번째 행으로 데이터 있으면 memberDTO 객체생성, set 메서드 호출,rs열 데이터 저장
			if (rs.next() == true) {
				memberDTO = new MemberDTO();
				// m_level 추가
				memberDTO.setM_id(rs.getString("m_id"));


				
			} else {
//				아이디, 비밀번호 불일치 -> 초기값 null -> 리턴
				memberDTO = null;
				
				System.out.println("실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
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
			dbClose();
		}
		
		return memberDTO;
	}


	
	
	public MemberDTO getIdCheck(String m_id) {
		System.out.println("MemberDAO getNickCheck()");
		
		MemberDTO memberDTO = null;
		
		try {
			
			con = getConnection();
			String sql = "select * from members where m_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next() == true) {
				memberDTO = new MemberDTO();
				memberDTO.setM_id(rs.getString("m_id"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
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
			dbClose();
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
			dbClose();
		}
		
		return memberDTO;
	}


	

//	회원정보 변경
	public void updateMember(MemberDTO memberDTO) {
		System.out.println("MemberDAO updateMember()");

		try {
			
			con = getConnection();
			
			String sql = "update members set m_name = ?, m_nick = ?, m_email = ?, m_phone = ? where m_id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getM_name());
			pstmt.setString(2, memberDTO.getM_nick());
			pstmt.setString(3, memberDTO.getM_email());
			pstmt.setString(4, memberDTO.getM_phone());
			pstmt.setString(5, memberDTO.getM_id());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	
	
	
//	비밀번호수정
	public void updatePass(MemberDTO memberDTO) {
		System.out.println("MemberDAO updatePass()");

		try {
			
			con = getConnection();
			
			String sql = "update members set m_pass = ? where m_id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getM_pass());
			pstmt.setString(2, memberDTO.getM_id());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
	}
	
	
	
	

//	회원탈퇴 -----> 글쓴거 찜한거 있으면 탈퇴 불가^^ 글쓴거랑 찜한것도 다 들고 삭제한 다음 탈퇴가넝~
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
			dbClose();
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
			dbClose();
		}
		
		return memberList;
	}




	// 아이디 찾기
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
			dbClose();
		}
		return memberDTO; // 멤버 정보 반환
	} // findidmember


	// 아이디와 비밀번호 일치한지 아닌지확인
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
			dbClose();
		}

		return result;
	} // newPassword()

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
			dbClose();
		}
		return memberDTO;
	} // IdAndEmailMatch()


	// 마이페이지 - 신고내역 연결(admin 참고)
	public List<ReportDTO> getReportList(AdminPageDTO pageDTO) {
		List<ReportDTO> reportList = null;
		try {
			
			int r_m_num = this.getMemberNum(pageDTO.getSearch());
			con = this.getConnection();
			
			String sql = "select * from report where r_m_num  = ? order by r_num desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, r_m_num);
			pstmt.setInt(2, pageDTO.getStartRow()-1); // 시작하는 행 -1 
			pstmt.setInt(3, pageDTO.getPageSize()); // 몇개
			
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


	// 마이페이지 - 신고내역 연결(admin 참고)
	public int getReportCount(AdminPageDTO pageDTO) {
		int count = 0;
		try {
			int r_m_num = this.getMemberNum(pageDTO.getSearch());
			con = this.getConnection();
			String sql = "select count(*) as count from report where r_m_num = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, r_m_num);
			
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
	
    // pageDTO.getSearch() = m_id 로 m_num 가져오기
	public int getMemberNum(String m_id) {
		int result = 0;
		try {
			con = this.getConnection();
			String  sql = "select m_num from members where m_id = ?";
			pstmt = con.prepareStatement(sql);
		
			pstmt.setString(1, m_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("m_num");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return result;
}



	public int getProductCount() {
		int p_count = 0;
		try {
			//1,2 디비연결
			con=getConnection();
			//3 sql select count(*) from products
			String sql = "select count(*) from products;";
			pstmt=con.prepareStatement(sql);
			//4 실행 => 결과저장
			rs = pstmt.executeQuery();
			//5 결과 행접근 => 열접근 => count변수 저장
			if(rs.next()) {
				p_count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return p_count;
	}



	public List<WishListDTO> getWishList(ProductPageDTO ppageDTO) {
		System.out.println("ProductDAO getWishList()");
		List<WishListDTO> wishList = new ArrayList<>();
		//int size = wishList.size();
		try {
			con = getConnection();
			String sql = "SELECT w.w_num, m.m_nick, p.p_file, p.p_title, p.p_status, p.p_type, p.p_price "
					+ "from wishlists w "
					+ "JOIN products p ON w.w_p_num = p.p_num "
					+ "JOIN members m ON w.w_m_num = m.m_num "
					+ "where m.m_id = ? "
					+ " limit ?, ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ppageDTO.getM_id());
			System.out.println("m_id = "+ppageDTO.getM_id());
			pstmt.setInt(2, ppageDTO.getP_startRow()-1);//시작행-1
			pstmt.setInt(3, ppageDTO.getP_pageSize());//몇개
			rs = pstmt.executeQuery();
			System.out.println("결과 =" + pstmt);
			//wishList = new ArrayList<>();
			//size = wishList.size();
			while(rs.next()) {
				WishListDTO wishListDTO = new WishListDTO();
	            ProductDTO productDTO = new ProductDTO();
	            MemberDTO memberDTO = new MemberDTO();

	            wishListDTO.setW_num(rs.getInt("w_num"));
	            memberDTO.setM_nick(rs.getString("m_nick"));
	            productDTO.setP_file(rs.getString("p_file"));
	            productDTO.setP_title(rs.getString("p_title"));
	            productDTO.setP_status(rs.getString("p_status"));
	            productDTO.setP_type(rs.getString("p_type"));
	            productDTO.setP_price(rs.getInt("p_price"));

	            wishListDTO.setMemberDTO(memberDTO);
	            wishListDTO.setProductDTO(productDTO);

	            wishList.add(wishListDTO);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return wishList;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	

	
	
	
	


