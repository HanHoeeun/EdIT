package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.itwillbs.dao.AdminDAO;
import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.AdminDTO;
import com.itwillbs.domain.AdminPageDTO;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.ReportDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminService {
	AdminDAO adminDAO = null;
	MemberDAO memberDAO = null;
	
//	faq 문의글 리스트 호출 
	public List<AdminDTO> getFAQBoardList(AdminPageDTO pageDTO) {
		List<AdminDTO> adminList = null;
		try {
//			시박하는 행부터 10개 뽑아오기
//			페이지 번호 	한화면에 보여줄 글개수 => 			시작하는 행번호
//			currentPage		pageSize	=>		 	startRow
//			1				10			=> 0*10 +1	 1 ~ 10
//			2				10			=> 1*10 +1 	11 ~ 20
//			3				10			=> 2*10 +1 	21 ~ 30
//			((currentPage-1)*10)+1
			int startRow = (pageDTO.getCurrentPage()-1)*pageDTO.getPageSize()+1;
			int endRow = startRow + pageDTO.getPageSize() -1;
			System.out.println("start Row : " + startRow);
			System.out.println("end Row : " + endRow);
			pageDTO.setStartRow(startRow);
			pageDTO.setEndRow(endRow);
			
//			AdminDAO 객체 생성
			adminDAO = new AdminDAO();
//			adminList = getBoardList() 메서드 호출
			adminList =  adminDAO.getFAQBoardList(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return adminList;
		
	}
//  faq 문의 게시판 페이징 처리
	public int getFAQBoardCount(AdminPageDTO pageDTO) {
		int count = 0;
		try {
			adminDAO = new AdminDAO();
			count = adminDAO.getFAQBoardCount(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
//	faq 게시판 문의글 작성 
	public void FAQBoardInsert(HttpServletRequest request) {
		try {

			//파일이 저장될 경로명
			String uploadPath = request.getRealPath("/upload");
			
//			이클립스에 실행하면 이클립스 가상 경로 
			System.out.println(uploadPath);
			
			//파일의 최대 크기 10mb
			int sizeLimit = 10*1024*1024;	
//										MultipartRequest(request, 저장경로, 파일크기제한, 한글처리, 파일이름 중복처리
			MultipartRequest multi = new MultipartRequest(request, uploadPath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy() );
			
//			multi 파라미터 값 가져오기
			String a_cs_type = multi.getParameter("faq_select");
			String m_id = multi.getParameter("m_id");
			String subject = multi.getParameter("subject");
			String content = multi.getParameter("content");
			adminDAO = new AdminDAO();
			
//			첨부파일 이름 가져오기 <input type="file" name="file" > name = file 매개변수 
			String file = multi.getFilesystemName("imgfile");
			
			AdminDTO adminDTO = new AdminDTO();
			
			adminDTO.setA_cs_type(a_cs_type);
			adminDTO.setA_m_id(m_id);
			adminDTO.setA_title(subject);
			adminDTO.setA_content(content);
			
			System.out.println(adminDTO.getA_cs_type());
			
			if(file != null) {
				adminDTO.setA_file(file);
			}
			
			adminDAO.FAQBoardInsert(adminDTO);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	faq 게시판 문의글 답변 등록  
	public void updateFAQAnswer(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			
			AdminDTO adminDTO = new AdminDTO();
			
			int a_num = Integer.parseInt(request.getParameter("a_num"));
			adminDTO.setA_num(a_num);
			adminDTO.setA_answer(request.getParameter("a_answer1"));
			
			
			adminDAO = new AdminDAO();
			adminDAO.updateFAQAnswer(adminDTO);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
//	관리자 페이지 문의내용 전체 확인
	public List<AdminDTO> getAdminFAQBoardList(AdminPageDTO pageDTO) {
		List<AdminDTO> adminList = null;
		try {
			int startRow = (pageDTO.getCurrentPage()-1)*pageDTO.getPageSize()+1;
			int endRow = startRow + pageDTO.getPageSize() -1;
			System.out.println("start Row : " + startRow);
			System.out.println("end Row : " + endRow);
			pageDTO.setStartRow(startRow);
			pageDTO.setEndRow(endRow);
			
//			AdminDAO 객체 생성
			adminDAO = new AdminDAO();
//			adminList = getBoardList() 메서드 호출
			adminList =  adminDAO.getAdminFAQBoardList(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return adminList;
		
	}

	public int getAdminFAQBoardCount(AdminPageDTO pageDTO) {
		int count = 0;
		try {
			adminDAO = new AdminDAO();
			count = adminDAO.getAdminFAQBoardCount(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
// 문의 상세페이지 가져오기
	public AdminDTO getFAQBoardContent(HttpServletRequest request) {
		AdminDTO adminDTO = null;
		
		try {
			request.setCharacterEncoding("utf-8");
			
			int a_num = Integer.parseInt(request.getParameter("a_num"));
			
			adminDAO = new AdminDAO();
			adminDTO = new AdminDTO();
			
			adminDTO = adminDAO.getFAQBoardContent(a_num);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminDTO;
	}

//	관리자 페이지 신고내역 리스트 
	public List<ReportDTO> getAdminReportList(AdminPageDTO pageDTO) {
		List<ReportDTO> reportList = null;
		try {
			int startRow = (pageDTO.getCurrentPage()-1)*pageDTO.getPageSize()+1;
			int endRow = startRow + pageDTO.getPageSize() -1;
			
			pageDTO.setStartRow(startRow);
			pageDTO.setEndRow(endRow);
			
//			AdminDAO 객체 생성
			adminDAO = new AdminDAO();
//			adminList = getBoardList() 메서드 호출
			reportList =  adminDAO.getAdminReportList(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return reportList;
	}
	
//	관리자 페이지 신고 게시판 페이징 처리용 count
	public int getAdminReportCount(AdminPageDTO pageDTO) {
		int count = 0;
		try {
			adminDAO = new AdminDAO();
			count = adminDAO.getAdminReportCount(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

//	신고 상세 페이지
	public ReportDTO getReportContent(HttpServletRequest request) {
		ReportDTO reportDTO = null;
		
		try {
			request.setCharacterEncoding("utf-8");
			
			int r_num = Integer.parseInt(request.getParameter("r_num"));
			
			adminDAO = new AdminDAO();
			reportDTO = new ReportDTO();
			
			reportDTO = adminDAO.getReportContent(r_num);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reportDTO;
	}

//	신고 상세페이지 답변 등록 
	public void updateReportAnswer(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			
			ReportDTO reportDTO = new ReportDTO();
			reportDTO.setR_num(Integer.parseInt(request.getParameter("r_num")));
			reportDTO.setR_answer(request.getParameter("r_answer"));
			
			System.out.println(request.getParameter("r_num"));
			System.out.println(request.getParameter("r_answer"));
			adminDAO = new AdminDAO();
			adminDAO.updateReportAnswer(reportDTO);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	신고 상세 페이지에서 신고 적용 시키기 m_count +1 
	public int updateReportCheck(HttpServletRequest request) {
		int result = 0;
		try {
			request.setCharacterEncoding("utf-8");
			
			ReportDTO reportDTO = new ReportDTO();
			reportDTO.setR_num(Integer.parseInt(request.getParameter("r_num")));
			
			adminDAO = new AdminDAO();
			result = adminDAO.updateReportCheck(reportDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("유저 service count 횟수 : " + result);
		return result;
	}
	
//	블랙리스트 등록 및 사유 입력 
	public int updateBlackReason(HttpServletRequest request) {
		int result = 0;
		try {
			request.setCharacterEncoding("utf-8");
			ReportDTO reportDTO = new ReportDTO();
			reportDTO.setR_num(Integer.parseInt(request.getParameter("r_num")));
			reportDTO.setBl_reason(request.getParameter("reason"));
			
			System.out.println(request.getParameter("r_num"));
			System.out.println("블랙 사유 : " + reportDTO.getBl_reason() );
			adminDAO = new AdminDAO();
			result = adminDAO.updateBlackReason(reportDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("유저 service count 횟수 : " + result);
		return result;
	}
	
//	관리자 페이지 회원정보 리스트 
	public List<MemberDTO> getMemberListSearch(AdminPageDTO pageDTO) {
		List<MemberDTO> memberList = null;
		try {
			int startRow = (pageDTO.getCurrentPage()-1)*pageDTO.getPageSize()+1;
			int endRow = startRow + pageDTO.getPageSize() -1;
			
			pageDTO.setStartRow(startRow);
			pageDTO.setEndRow(endRow);
			
			System.out.println("start Row : " + startRow);
			System.out.println("end Row : " + endRow);
			
//			AdminDAO 객체 생성
			adminDAO = new AdminDAO();
//			adminList = getMemberList() 메서드 호출
			memberList =  adminDAO.getMemberList(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return memberList;
		
	}
	
//	회원정보 상세 페이지
	public MemberDTO getMemberContent(HttpServletRequest request) {
		MemberDTO memberDTO = null;
		try {
			request.setCharacterEncoding("utf-8");
			
			int num = Integer.parseInt(request.getParameter("m_num"));
			
			adminDAO = new AdminDAO();
			
			
			memberDTO = adminDAO.getMemberContent(num);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberDTO;
	}

//	전화번호 정규화
	public String formatPhoneNumber(String m_phone) {
		 // 전화번호에서 숫자만 추출
        String digitsOnly = m_phone.replaceAll("[^0-9]", "");
        
        // 전화번호 길이에 따라 정규식 패턴 선택
        String pattern;
        if (digitsOnly.length() == 10) {
            pattern = "(\\d{3})(\\d{3})(\\d{4})";
        } else {
            pattern = "(\\d{3})(\\d{4})(\\d{4})";
        }

        // 정규식 패턴 적용하여 전화번호 포맷 변환
        Pattern phonePattern = Pattern.compile(pattern);
        Matcher matcher = phonePattern.matcher(digitsOnly);
        if (matcher.matches()) {
        	return String.format("%s-%s-%s", matcher.group(1), matcher.group(2), matcher.group(3));
        } else {
            // 매치되지 않는 경우에는 원본 번호 그대로 반환
            return m_phone;
        }
    }

//	회원정보 수정 
	public void updateUserContent(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			
			adminDAO = new AdminDAO();
			
			MemberDTO memberDTO = new MemberDTO();
			
			int m_num = Integer.parseInt(request.getParameter("m_num"));

			String phone = request.getParameter("m_phone").replace("-", "");
			System.out.println(phone);
			memberDTO.setM_num(m_num);
			memberDTO.setM_id(request.getParameter("m_id"));
			memberDTO.setM_name(request.getParameter("m_name"));
			memberDTO.setM_nick(request.getParameter("m_nick"));
			memberDTO.setM_phone(phone);
			memberDTO.setM_email(request.getParameter("m_email"));
//			memberDTO.setM_date(request.getParameter("m_date"));
			memberDTO.setM_event(request.getParameter("m_event"));
			memberDTO.setM_level(Integer.parseInt(request.getParameter("m_level")));
			memberDTO.setM_count(Integer.parseInt(request.getParameter("m_count")));
			
			adminDAO.updateUserContent(memberDTO);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

//	회원정보 페이징 처리용 
	public int getMemberCountSearch(AdminPageDTO pageDTO) {
		int count = 0;
		try {
			adminDAO = new AdminDAO();
			count = adminDAO.getMemberCountSearch(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

	public List<MemberDTO> getBlackListSearch(AdminPageDTO pageDTO) {
		List<MemberDTO> memberList = null;
		try {
			int startRow = (pageDTO.getCurrentPage()-1)*pageDTO.getPageSize()+1;
			int endRow = startRow + pageDTO.getPageSize() -1;
			
			pageDTO.setStartRow(startRow);
			pageDTO.setEndRow(endRow);
			
//			AdminDAO 객체 생성
			adminDAO = new AdminDAO();
			
			memberList =  adminDAO.getBlackList(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return memberList;
	}

	public int getBlackCountSearch(AdminPageDTO pageDTO) {
		int count = 0;
		try {
			adminDAO = new AdminDAO();
			count = adminDAO.getBlackCountSearch(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

	
	
//========================================== 신고하기 =================================================
	public void insertReport(HttpServletRequest request) {
			System.out.println("AdminService insertReport()");
			try {
				// request 한글처리
				request.setCharacterEncoding("utf-8");
				// 업로드 폴더 경로=> 물리적 경로
				String uploadPath=request.getRealPath("/upload");
				// 이클립스에 실행하면 이클립스 가상경로 
				System.out.println(uploadPath);
				//파일 최대크기 지정  10M
				int maxSize=10*1024*1024; 
				// 파일 업로드 했을때 폴더내 파일이름 동일하면 파일이름 변경하는 프로그램
				// import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
				// new DefaultFileRenamePolicy()
				MultipartRequest multi 
				= new MultipartRequest(request, uploadPath, maxSize,"utf-8", new DefaultFileRenamePolicy()); 
				// multi 파라미터 값 가져오기
				String r_title = multi.getParameter("r_title");
				String r_content = multi.getParameter("r_content");
				//첨부파일이름 가져오기
				String r_file = multi.getFilesystemName("r_file");
				
				// request 파라미터 값 가져오기
				String m_id = (multi.getParameter("m_id"));
				String r_m_target = (multi.getParameter("r_m_target"));
				
				memberDAO = new MemberDAO();
				MemberDTO memberDTO = memberDAO.getMember(m_id);
				int m_num = memberDTO.getM_num();
				
				MemberDTO memberDTO2 = memberDAO.getMember(r_m_target);
				int m_target = memberDTO2.getM_num();
				
				
				// r_date 변수저장
				Timestamp r_date = new Timestamp(System.currentTimeMillis());

				// NoticeDAO 객체생성
				adminDAO = new AdminDAO();
				// NoticeDTO 객체생성
				ReportDTO reportDTO = new ReportDTO();
				// set메서드 호출 파라미터값 저장				
				reportDTO.setR_title(r_title);
				reportDTO.setR_content(r_content);
				reportDTO.setR_date(r_date);
				
				reportDTO.setR_m_target(m_target);
				reportDTO.setR_m_num(m_num);
				// 첨부파일
				reportDTO.setR_file(r_file);
				
				adminDAO.insertReport(reportDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//insertReport

	

}
