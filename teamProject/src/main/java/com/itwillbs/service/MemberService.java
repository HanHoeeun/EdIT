package com.itwillbs.service;



import java.io.UnsupportedEncodingException;
import java.lang.reflect.Member;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.itwillbs.dao.AdminDAO;
import com.itwillbs.dao.MemberDAO;
import com.itwillbs.dao.ProductDAO;
import com.itwillbs.domain.AdminPageDTO;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.ProductPageDTO;
import com.itwillbs.domain.ReportDTO;
import com.itwillbs.domain.WishListDTO;

public class MemberService {
	
	MemberDAO memberDAO = null;

	public void insertMember(HttpServletRequest request) {
		System.out.println("MemberService insertMember()");
		
		try {
			
			request.setCharacterEncoding("utf-8");
			
			String m_id = request.getParameter("m_id");
			String m_pass1 = request.getParameter("m_pass1");
			String m_pass2 = request.getParameter("m_pass2");
			String m_name = request.getParameter("m_name");
			String m_nick = request.getParameter("m_nick");
			String m_phone = request.getParameter("m_phone");
			String m_email = request.getParameter("m_email");
			Timestamp m_date = new Timestamp(System.currentTimeMillis());
			String m_event = request.getParameter("m_event");
			
			int m_num = 1;
			
			memberDAO = new MemberDAO();
			
			m_num = memberDAO.getMaxNum() + 1;
			

			MemberDTO memberDTO = new MemberDTO();
			
			memberDTO.setM_num(m_num);
			memberDTO.setM_id(m_id);
			memberDTO.setM_pass(m_pass1);
			memberDTO.setM_pass(m_pass2);
			memberDTO.setM_name(m_name);
			memberDTO.setM_nick(m_nick);
			memberDTO.setM_phone(m_phone);
			memberDTO.setM_email(m_email);
			memberDTO.setM_date(m_date);
			memberDTO.setM_event(m_event);
			
			System.out.println(memberDTO);
			
			
			memberDAO.insertMember(memberDTO);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
//	유저체크
	public MemberDTO userCheck(HttpServletRequest request) {
		System.out.println("MemberService userCheck()");
		
		MemberDTO memberDTO = null;
		
		try {
			
//			한글처리
			request.setCharacterEncoding("utf-8");
			
			
			String m_id = request.getParameter("m_id");
			String m_pass = request.getParameter("m_pass");
			
			MemberDTO memberDTO2 = new MemberDTO();
			memberDTO2.setM_id(m_id);
			memberDTO2.setM_pass(m_pass);
			
			memberDAO = new MemberDAO();
			memberDTO = memberDAO.userCheck(memberDTO2);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return memberDTO;
	}

	

	public MemberDTO userCheck2(HttpServletRequest request) {
		MemberDTO memberDTO = null;
		
		try {
			
//			한글처리
			request.setCharacterEncoding("utf-8");
			
			
			String m_id = request.getParameter("m_id");
			
			MemberDTO memberDTO2 = new MemberDTO();
			memberDTO2.setM_id(m_id);
			
			memberDAO = new MemberDAO();
			memberDTO = memberDAO.userCheck2(memberDTO2);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return memberDTO;
	}
	
	
	
	

	public MemberDTO getMember(String m_id) {
		System.out.println("MemberService getMember()");
		
		MemberDTO memberDTO = null;
		
		try {
			
			memberDAO = new MemberDAO();
			memberDTO = memberDAO.getMember(m_id);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberDTO;
	}

	
	
	
	public MemberDTO getIdCheck(String m_id) {
		System.out.println("MemberService getIdCheck()");
		
		MemberDTO memberDTO = null;
		
		try {
			
			memberDAO = new MemberDAO();
			memberDTO = memberDAO.getIdCheck(m_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberDTO;
	}

	
	
	
//	닉네임 중복체크
	public MemberDTO getNickCheck(String m_nick) {
		System.out.println("MemberService getNickCheck()");
		
		MemberDTO memberDTO = null;
		
		try {
			
			memberDAO = new MemberDAO();
			memberDTO = memberDAO.getNickCheck(m_nick);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberDTO;	
	}
	
	
	
//	이메일 중복확인
	public MemberDTO getEmailCheck(String m_email) {
		System.out.println("MemberService getEmailCheck()");
		
		MemberDTO memberDTO = null;
		
		try {
			
			memberDAO = new MemberDAO();
			memberDTO = memberDAO.getEmailCheck(m_email);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberDTO;
	}

	
	
//	회원정보 수정
	public void updateMember(HttpServletRequest request) {
		System.out.println("MemberService updateMember()");
		
		try {
//			한글처리
			request.setCharacterEncoding("utf-8");
			
			String m_id = request.getParameter("m_id");
			String m_name = request.getParameter("m_name");
			String m_nick = request.getParameter("m_nick");
			String m_email = request.getParameter("m_email");
			String m_phone = request.getParameter("m_phone");
			
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setM_id(m_id);
			memberDTO.setM_name(m_name);
			memberDTO.setM_nick(m_nick);
			memberDTO.setM_email(m_email);
			memberDTO.setM_phone(m_phone);
			
			memberDAO = new MemberDAO();
			memberDAO.updateMember(memberDTO);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


//	비밀번호 수정
	public void updatePass(HttpServletRequest request) {
		System.out.println("MemberService updatePass()");
		
		try {
//			한글처리
			request.setCharacterEncoding("utf-8");
			
			String m_id = request.getParameter("m_id");
			String m_name = request.getParameter("m_name");
			String m_pass = request.getParameter("m_pass");
			String m_pass2 = request.getParameter("m_pass2");
			String m_pass3 = request.getParameter("m_pass3");


			
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setM_id(m_id);
			memberDTO.setM_name(m_name);
			memberDTO.setM_pass(m_pass);
			memberDTO.setM_pass(m_pass2);
			memberDTO.setM_pass(m_pass3);


			memberDAO = new MemberDAO();
			memberDAO.updatePass(memberDTO);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
//	회원탈퇴	
	public void deleteMember(HttpServletRequest request) {
		System.out.println("MemberService deleteMember()");

		
		try {
			String m_id = request.getParameter("m_id");
			String m_pass = request.getParameter("m_pass");
	
			
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setM_id(m_id);
			memberDTO.setM_pass(m_pass);
			
			memberDAO = new MemberDAO();
			memberDAO.deleteMember(memberDTO);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	
	
//	멤버리스트
	public List<MemberDTO> getMemberList() {
		System.out.println("MemberService getMemberList()");

		List<MemberDTO> memberList = null;
		
		try {
			
			memberDAO = new MemberDAO();
			memberList = memberDAO.getMemberList();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberList;
	}

	
	


	// 아이디 찾기
	public String findidmember(String m_name, String m_email) {
		// 이름과 이메일을 이용하여 아이디를 찾는 로직을 구현
		memberDAO = new MemberDAO();
		MemberDTO memberDTO = memberDAO.findidmember(m_name, m_email);

		 // 이름과 이메일을 이용하여 아이디를 찾는 로직을 구현

        // 예시: MemberDAO의 메서드를 이용하여 데이터베이스에서 아이디를 조회
        // 실제로는 데이터베이스에서 조회하도록 로직을 구현해야 합니다.(???)
		if (memberDTO != null) {
	        return memberDTO.getM_id(); // 아이디 반환
	    } else {
	        return null; // 아이디를 찾지 못한 경우
	    }
	}
	
	// 새 비밀번호 설정 -> DB에 업데이트
	public int newPassword(HttpServletRequest request) {	
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		
		HttpSession mySession = request.getSession();
		String email = (String)mySession.getAttribute("email");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setM_email(email);
		memberDTO.setM_pass(newPassword);
		
		memberDAO = new MemberDAO();
		int result = memberDAO.newPassword(memberDTO);
		
		return result;
	}

	public MemberDTO IdAndEmailMatch(String m_id, String m_email) {
		MemberDTO memberDTO = null;
		try {
			memberDAO = new MemberDAO();
			 memberDTO = memberDAO.IdAndEmailMatch(m_id, m_email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberDTO;
	}

	
    // 마이페이지 - 신고내역 연결(admin 참고)
	public List<ReportDTO> getReportList(AdminPageDTO pageDTO) {
		List<ReportDTO> reportList = null;
		try {
//			시박하는 행부터 10개 뽑아오기
//			페이지 번호 	한화면에 보여줄 글개수 => 			시작하는 행번호
//			currentPage		pageSize	=>		 	startRow
//			1				10			=> 0*10 +1	 1 ~ 10
//			2				10			=> 1*10 +1 	11 ~ 20
//			3				10			=> 2*10 +1 	21 ~ 30
//			((currentPage-1)*10)+1
			int startRow = (pageDTO.getCurrentPage()-1)*pageDTO.getPageSize()+1;
			int endRos = startRow + pageDTO.getPageSize() -1;
			
			pageDTO.setStartRow(startRow);
			pageDTO.setEndRow(endRos);
			
//			AdminDAO 객체 생성
			memberDAO = new MemberDAO();
//			adminList = getBoardList() 메서드 호출
			reportList =  memberDAO.getReportList(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return reportList;
	}

	public int getReportCount(AdminPageDTO pageDTO) {
		int count = 0;
		try {
			memberDAO = new MemberDAO();
			count = memberDAO.getReportCount(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}


	public List<WishListDTO> getWishList(ProductPageDTO ppageDTO) {
		System.out.println("memberservice getWishList()");
		List<WishListDTO> wishList = null;
		try {
			int p_startRow = (ppageDTO.getP_currentPage()-1)*ppageDTO.getP_pageSize()+1;
			int p_endRow = p_startRow+ppageDTO.getP_pageSize()-1;
			//pageDTO 저장 <= startRow, endRow
			ppageDTO.setP_startRow(p_startRow);
			ppageDTO.setP_endRow(p_endRow);
			// BoardDAO 객체생성
			memberDAO = new MemberDAO();
			// boardList = getBoardList() 메서드 호출
			wishList = memberDAO.getWishList(ppageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wishList;
		}
		


	public int getProductCount() {
		System.out.println("memberservice getProductCount()");
		int count=0;
		try {
			// productDAO 객체생성
			memberDAO = new MemberDAO();
			// count = getBoardCount() 호출
			count = memberDAO.getProductCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}





	
	
} // MemberService()
