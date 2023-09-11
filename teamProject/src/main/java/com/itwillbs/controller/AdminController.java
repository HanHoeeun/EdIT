package com.itwillbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.domain.AdminDTO;
import com.itwillbs.domain.AdminPageDTO;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.ReportDTO;
import com.itwillbs.service.AdminService;

public class AdminController extends HttpServlet{
	RequestDispatcher dispatcher = null;
	AdminService adminService = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductController doProcess()");
		// 가상주소 뽑아오기
		String sPath=request.getServletPath();
		System.out.println("뽑은 가상주소 :  " + sPath);
		
//		faq 문의 게시판으로 이동 
		if(sPath.equals("/faq.ad")) {
//			한글처리
			request.setCharacterEncoding("utf-8");
//			request 검색어 뽑아오기
//			String search = request.getParameter("search");
			HttpSession session = request.getSession();
			String search = (String)session.getAttribute("m_id");
			if(search != null) {
				
//			한페이지에서 보여지는 글개수 설정
				int pageSize =10;
//			페이지 번호
				String pageNum=request.getParameter("pageNum");
//			패이지 번호가 없으면 1페이지 설정
				if(pageNum == null) {
					pageNum = "1";
				}
//			페이지 번호를 정수형 변경 
				int currentPage = Integer.parseInt(pageNum);
				
				AdminPageDTO pageDTO = new AdminPageDTO();
				pageDTO.setPageSize(pageSize);
				pageDTO.setPageNum(pageNum);
				pageDTO.setCurrentPage(currentPage);
				
//			검색어 담기
				pageDTO.setSearch(search);
				
				// AdminService 객체생성
				adminService = new AdminService();
				
				List<AdminDTO> adminList = adminService.getFAQBoardList(pageDTO);
				
//			게시판 전체 글 개수 구하기
				int count = adminService.getFAQBoardCount(pageDTO);
				System.out.println(count);
//			한화면에 보여줄 페이지 개수 설정
				int pageBlock =10;
//			시작하는 페이지 번호
//			currentPage 			pageBlock => startPage
//			1~10(0~9)/10 = 0		    10    => 0*10+1  => 1
//			11~20(10~19)/10 = 1			10    => 1*10+1  => 11
//			21~30(20~29)/10 = 2			10    => 2*10+1  => 21
				int startPage = (currentPage-1)/pageBlock*pageBlock+1;
//			끝나는 페이지 번호
//			startPage  pageBlock => endPage
//			1			10		 =>  10
//			2			10		 =>  20
//			3			10		 =>  30
//			계산한값 endPage 10 => 실제 페이지는 2 
				int endPage = startPage + pageBlock -1;
				
//			전체페이지 구하기 
//			글개수 50 한화면에 보여줄 글 개수 10 => 페이지수 5
//			count%pageBlock == 0 ? count/pageBlock : count/pageBlock+1;
				int pageCount = count%pageBlock == 0 ? count/pageBlock : count/pageBlock+1 ;
				if(endPage > pageCount ) {
					endPage = pageCount;
				}
				
				pageDTO.setCount(count);
				pageDTO.setPageBlock(pageBlock);	
				pageDTO.setStartPage(startPage);
				pageDTO.setEndPage(endPage);
				pageDTO.setPageCount(pageCount);
				request.setAttribute("pageDTO", pageDTO);
				
				// request에 "adminList",adminList 저장
				request.setAttribute("adminList", adminList);
				// 주소변경없이 이동 faq 이동
				
			}
			
			dispatcher = request.getRequestDispatcher("admin/faq.jsp");
			dispatcher.forward(request, response);	
		}
		
//		고객센터 문의글 작성 
		if(sPath.equals("/faqWritePro.ad")) {
			adminService = new AdminService();
			
			adminService.FAQBoardInsert(request);
//			문의글 작성후 내 문의글 게시판으로 이동 
			response.sendRedirect("faq.ad?tab=tab-3");
		}
		
//		문의내역 상세 페이지 
		if(sPath.equals("/faqContent.ad")) {
			adminService = new AdminService();
			AdminDTO adminDTO = adminService.getFAQBoardContent(request);
//			엔터(\r\n) -> <br> 로 바꾼다
			adminDTO.setA_content(adminDTO.getA_content().replaceAll("\r\n","&#10;"));
			if(adminDTO.getA_answer() != null) {
				adminDTO.setA_answer(adminDTO.getA_answer().replaceAll("\r\n","&#10;"));
			}
			
			request.setAttribute("adminDTO", adminDTO);
			dispatcher = request.getRequestDispatcher("admin/faqContent.jsp");
			dispatcher.forward(request, response);
		}
		
//		문의 내역 답변 등록 
		if(sPath.equals("/faqAnswer.ad")) {
			try {
				request.setCharacterEncoding("utf-8");
			
				adminService = new AdminService();
				
				adminService.updateFAQAnswer(request);
				
				int a_num = Integer.parseInt(request.getParameter("a_num"));
				
				
//				답변 등록후 부모 페이지 새로고침 후 상세페이지 이동 
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("window.opener.location.reload();");
				out.println("location.href='faqContent.ad?a_num="+a_num+"'");
				out.println("</script>");
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
//		관리자 페이지 첫 페이지는 신고 내역 게시판 
		if(sPath.equals("/adminPage.ad")) {
			request.setCharacterEncoding("utf-8");
			
			int pageSize =10;
			String pageNum=request.getParameter("pageNum");
			if(pageNum == null) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			
			AdminPageDTO pageDTO = new AdminPageDTO();
			pageDTO.setPageSize(pageSize);
			pageDTO.setPageNum(pageNum);
			pageDTO.setCurrentPage(currentPage);
			
			
			// AdminService 객체생성
			adminService = new AdminService();

			List<ReportDTO> reportList = adminService.getAdminReportList(pageDTO);
			
//			게시판 전체 글 개수 구하기
			int count = adminService.getAdminReportCount(pageDTO);
			System.out.println(count);
//			한화면에 보여줄 페이지 개수 설정
			int pageBlock =10;
			int startPage = (currentPage-1)/pageBlock*pageBlock+1;
			int endPage = startPage + pageBlock -1;
			
			int pageCount = count%pageBlock == 0 ? count/pageBlock : count/pageBlock+1 ;
			if(endPage > pageCount ) {
				endPage = pageCount;
			}
			
			pageDTO.setCount(count);
			pageDTO.setPageBlock(pageBlock);	
			pageDTO.setStartPage(startPage);
			pageDTO.setEndPage(endPage);
			pageDTO.setPageCount(pageCount);
			request.setAttribute("pageDTO", pageDTO);
			
			// request에 "reportList",reportList 저장
			request.setAttribute("reportList", reportList);
			
			dispatcher = request.getRequestDispatcher("admin/adminPage.jsp");
			dispatcher.forward(request, response);	
		}
		
//		신고 상세 페이지
		if(sPath.equals("/reportContent.ad")) {
			adminService = new AdminService();
			ReportDTO reportDTO = adminService.getReportContent(request);
//			엔터(\r\n) -> &#10; , <br> 로 바꾼다
			reportDTO.setR_content(reportDTO.getR_content().replaceAll("\r\n","&#10;"));
			
			if(reportDTO.getR_answer() != null) {
				reportDTO.setR_answer(reportDTO.getR_answer().replaceAll("\r\n","&#10;"));
			}
			
			
			request.setAttribute("reportDTO", reportDTO);
			dispatcher = request.getRequestDispatcher("admin/reportContent.jsp");
			dispatcher.forward(request, response);
		}
		
//		신고 답변 
		if(sPath.equals("/reportAnswer.ad")) {
			adminService = new AdminService();
			adminService.updateReportAnswer(request);
			
			int r_num = Integer.parseInt(request.getParameter("r_num"));
			
			response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>");
	        out.println("window.opener.location.reload();");
	        out.println("location.href='reportContent.ad?r_num="+r_num+"'");
	        out.println("</script>");
			
		}
		
//		신고 적용 페이지 
		if(sPath.equals("/reportCheck.ad")) {
			adminService = new AdminService();
			int result = 0;
			result = adminService.updateReportCheck(request);

			response.setContentType("text/html;charset=UTF-8");
	        response.getWriter().write(result + "");
		}
		
//		신고 적용후 신고횟수(m_count)가 3회일때 블랙리스트 이유를 저장 
		if(sPath.equals("/updateBlackReason.ad")) {
			adminService = new AdminService();
			int result = 0;
			result = adminService.updateBlackReason(request);
			response.setContentType("text/html;charset=UTF-8");
			if(result == 1) {
				response.getWriter().write("success");
			}else {
				response.getWriter().write("");
			}
		}
		
//		관리자 페이지 문의 내역 게시판 
		if(sPath.equals("/adminFAQ.ad")) {
			request.setCharacterEncoding("utf-8");
			
//			문의 분류
			String select = request.getParameter("select");
			if(select == null) {
				select = "전체";
			}
			
			int pageSize =10;
			
			String pageNum=request.getParameter("pageNum");
			
			if(pageNum == null) {
				pageNum = "1";
			}

			int currentPage = Integer.parseInt(pageNum);
			
			AdminPageDTO pageDTO = new AdminPageDTO();
			pageDTO.setPageSize(pageSize);
			pageDTO.setPageNum(pageNum);
			pageDTO.setCurrentPage(currentPage);
			
//			분류 담기
			pageDTO.setSearch(select);
			
			adminService = new AdminService();

			List<AdminDTO> adminList = adminService.getAdminFAQBoardList(pageDTO);
			
			int count = adminService.getAdminFAQBoardCount(pageDTO);
			
			int pageBlock =10;
			int startPage = (currentPage-1)/pageBlock*pageBlock+1;
			int endPage = startPage + pageBlock -1;
			
			int pageCount = count%pageBlock == 0 ? count/pageBlock : count/pageBlock+1 ;
			if(endPage > pageCount ) {
				endPage = pageCount;
			}
			
			pageDTO.setCount(count);
			pageDTO.setPageBlock(pageBlock);	
			pageDTO.setStartPage(startPage);
			pageDTO.setEndPage(endPage);
			pageDTO.setPageCount(pageCount);
			request.setAttribute("pageDTO", pageDTO);
			
			// request에 "adminList",adminList 저장
			request.setAttribute("adminList", adminList);
			
			dispatcher = request.getRequestDispatcher("admin/adminFAQ.jsp");
			dispatcher.forward(request, response);
		}
		
//		관리자 페이지 회원정보 페이지 
		if(sPath.equals("/adminMemberPage.ad")) {
			request.setCharacterEncoding("utf-8");
//			request 검색어 뽑아오기
			String search_t = request.getParameter("search_type");
			int search_type = 0;
			if(search_t != null) {
				search_type = Integer.parseInt(search_t);
			}
			String search = request.getParameter("search");
			
			System.out.println("검색값 : " + search);
			System.out.println(search_t);
			
			
			int pageSize =10;
			
			String pageNum=request.getParameter("pageNum");
			
			if(pageNum == null) {
				pageNum = "1";
			}
			
			int currentPage = Integer.parseInt(pageNum);
			
			AdminPageDTO pageDTO = new AdminPageDTO();
			pageDTO.setPageSize(pageSize);
			pageDTO.setPageNum(pageNum);
			pageDTO.setCurrentPage(currentPage);
			
//			검색어 담기
			pageDTO.setSearch_type(search_type);
			pageDTO.setSearch(search);
			
			adminService = new AdminService();

			List<MemberDTO> memberList = adminService.getMemberListSearch(pageDTO);
			
			int count = adminService.getMemberCountSearch(pageDTO);
		
			int pageBlock =10;
			int startPage = (currentPage-1)/pageBlock*pageBlock+1;
			int endPage = startPage + pageBlock -1;
			
			int pageCount = count%pageBlock == 0 ? count/pageBlock : count/pageBlock+1 ;
			if(endPage > pageCount ) {
				endPage = pageCount;
			}
			
			pageDTO.setCount(count);
			pageDTO.setPageBlock(pageBlock);	
			pageDTO.setStartPage(startPage);
			pageDTO.setEndPage(endPage);
			pageDTO.setPageCount(pageCount);
			request.setAttribute("pageDTO", pageDTO);
			
			request.setAttribute("memberList", memberList);
			
			
			dispatcher = request.getRequestDispatcher("admin/adminMemberPage.jsp");
			dispatcher.forward(request, response);
		}
		
//		회원정보 불러오기
		if(sPath.equals("/userContent.ad")) {
			adminService = new AdminService();
			MemberDTO memberDTO = adminService.getMemberContent(request);
			
			String phone = adminService.formatPhoneNumber(memberDTO.getM_phone());
			memberDTO.setM_phone(phone);
			
			request.setAttribute("memberDTO", memberDTO);
			
			dispatcher = request.getRequestDispatcher("admin/userContent.jsp");
			dispatcher.forward(request, response);
		}
		
//		회원정보 수정
		if(sPath.equals("/updateUserContent.ad")) {
			
			try {
				request.setCharacterEncoding("utf-8");
				
				adminService = new AdminService();
				
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				if(request.getParameter("admin_pass").equals("1q2w3e4r")) {
					adminService.updateUserContent(request);
					int m_num = Integer.parseInt(request.getParameter("m_num"));
					
					response.sendRedirect("userContent.ad?m_num="+m_num);
				}else {
					out.println("<script>");
					out.println("window.close();");
					out.println("</script>");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
//		관리자 블랙리스트 페이지
		if(sPath.equals("/adminBlackPage.ad")) {
//			한글처리
			request.setCharacterEncoding("utf-8");
//			request 검색어 뽑아오기
			String search_t = request.getParameter("search_type");
			int search_type = 0;
			if(search_t != null) {
				search_type = Integer.parseInt(search_t);
			}
			String search = request.getParameter("search");
			
			
			int pageSize =10;
			
			String pageNum=request.getParameter("pageNum");
			
			if(pageNum == null) {
				pageNum = "1";
			}
			
			int currentPage = Integer.parseInt(pageNum);
			
			AdminPageDTO pageDTO = new AdminPageDTO();
			pageDTO.setPageSize(pageSize);
			pageDTO.setPageNum(pageNum);
			pageDTO.setCurrentPage(currentPage);
			
//			검색어 담기
			pageDTO.setSearch_type(search_type);
			pageDTO.setSearch(search);
			
			adminService = new AdminService();

			List<MemberDTO> blackList = adminService.getBlackListSearch(pageDTO);
			
//			게시판 전체 글 개수 구하기
			int count = adminService.getBlackCountSearch(pageDTO);
			System.out.println(count);
//			한화면에 보여줄 페이지 개수 설정
			int pageBlock =10;
			int startPage = (currentPage-1)/pageBlock*pageBlock+1;
			int endPage = startPage + pageBlock -1;
			
			int pageCount = count%pageBlock == 0 ? count/pageBlock : count/pageBlock+1 ;
			if(endPage > pageCount ) {
				endPage = pageCount;
			}
			
			pageDTO.setCount(count);
			pageDTO.setPageBlock(pageBlock);	
			pageDTO.setStartPage(startPage);
			pageDTO.setEndPage(endPage);
			pageDTO.setPageCount(pageCount);
			request.setAttribute("pageDTO", pageDTO);
			
			request.setAttribute("blackList", blackList);
			
			
			dispatcher = request.getRequestDispatcher("admin/adminBlackPage.jsp");
			dispatcher.forward(request, response);
		}
		
//====================================== 신고페이지 ==============================================================	
		if(sPath.equals("/reportWrite.ad")) {
			System.out.println("뽑은 가상주소 비교 : /reportWrite.ad");
			request.setCharacterEncoding("utf-8");
			String m_id = (String)request.getSession().getAttribute("m_id");
			String r_m_target = request.getParameter("r_m_target");
			
			ReportDTO reportDTO = new ReportDTO(); // request에서 값을 받아서 DTO 로 전달 
			reportDTO.setR_m_num_id(m_id);	//신고자 아이디
			reportDTO.setR_m_target_id(r_m_target); // 신고 대상자 아이디 
				
			request.setAttribute("reportDTO", reportDTO);
		// 주소변경없이 이동 admin/reportWrite.jsp
			dispatcher 
		    = request.getRequestDispatcher("admin/reportWrite.jsp");
		dispatcher.forward(request, response);
		}//noticeWrite.no


		if(sPath.equals("/reportWritePro.ad")) {
			System.out.println("뽑은 가상주소 비교 : /reportWritePro.ad");
			request.setCharacterEncoding("utf-8");
			// AdminService 객체생성
			adminService = new AdminService();
			// 리턴할형없음 insertReport(request) 메서드 호출
			adminService.insertReport(request);
			PrintWriter out = response.getWriter();
	        out.println("<script>");
	        out.println("window.close()");
	        out.println("</script>");
		}//reportWritePro.no	
	
	}//do
}//class
