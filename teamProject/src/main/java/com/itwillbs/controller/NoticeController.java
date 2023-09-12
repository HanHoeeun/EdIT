package com.itwillbs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.domain.NoticeDTO;
import com.itwillbs.domain.NoticePageDTO;
import com.itwillbs.service.NoticeService;

public class NoticeController extends HttpServlet{
	
	NoticeService noticeService = null;
	RequestDispatcher dispatcher = null;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("NoticeController doGet()");
		doProcess(request, response);
	}//doGet()

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("NoticeController doPost()");
		doProcess(request, response);
	}//doPost()
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("NoticeController doProcess()");
		String sPath=request.getServletPath();
		System.out.println("뽑아온 가상주소:"+sPath);
		
//******************************************************************************************************
//******************************************************************************************************
//============================================= noticelist.no ================================================		
		if(sPath.equals("/noticelist.no")) {
			System.out.println("뽑은 가상주소 비교 : /noticelist.no");
			
//			HttpSession session = request.getSession();
//			String m_level = session.getAttribute("m_level")
			
			
			//notice 페이징 (NoticePageDTO pageDTO)
			int pageSize=10; 
			String pageNum=request.getParameter("pageNum");
			if(pageNum == null) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			
			NoticePageDTO pageDTO = new NoticePageDTO();
			pageDTO.setPageSize(pageSize);
			pageDTO.setPageNum(pageNum);
			pageDTO.setCurrentPage(currentPage);
			pageDTO.setA_notice_type("공지");
			
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// List<NoticeDTO> noticeList = getNoticeList(); 메서드 호출
			List<NoticeDTO> noticeList = noticeService.getNoticeList(pageDTO);

			// 공지사항 전체 글 개수 (NoticePageDTO)
			int count = noticeService.getNoticeCount();
			int pageBlock = 10;
			int startPage=(currentPage-1)/pageBlock*pageBlock+1;
			int endPage=startPage+pageBlock-1;
			int pageCount = count / pageSize + (count % pageSize==0?0:1);
			if(endPage > pageCount) {
				endPage = pageCount;
			}
			
			// NoticePageDTO pageDTO 저장
			pageDTO.setCount(count);
			pageDTO.setPageBlock(pageBlock);
			pageDTO.setStartPage(startPage);
			pageDTO.setEndPage(endPage);
			pageDTO.setPageCount(pageCount);
			
			
			// request에 "noticeList", noticeList 저장
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("pageDTO", pageDTO);
			
			// 주소변경없이 이동 admin/notice.jsp
			dispatcher 
			= request.getRequestDispatcher("admin/notice.jsp");
			dispatcher.forward(request, response);
		}//noticelist.no

//=========================================== noticeWrite.no ============================================		
		if(sPath.equals("/noticeWrite.no")) {
			System.out.println("뽑은 가상주소 비교 : /noticeWrite.no");
			// 주소변경없이 이동 admin/noticeWrite.jsp
			dispatcher 
		    = request.getRequestDispatcher("admin/noticeWrite.jsp");
		dispatcher.forward(request, response);
		}//noticeWrite.no

//============================================ noticeWritePro.no ==========================================		
		if(sPath.equals("/noticeWritePro.no")) {
			System.out.println("뽑은 가상주소 비교 : /noticeWritePro.no");
			request.setCharacterEncoding("utf-8");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// 리턴할형없음 insertNotice(request) 메서드 호출
			
			String m_id = (String)request.getSession().getAttribute("m_id");
			
			String a_notice_type=noticeService.insertNotice(request,m_id);
			
			// noticelist.no 주소 변경 되면서 이동			
//			String a_notice_type = request.getParameter("a_notice_type");
			System.out.println(a_notice_type);
			if(a_notice_type.equals("공지")) {
				
				response.sendRedirect("noticelist.no");
			}else {
				response.sendRedirect("eventlist.no");
			}

		}//noticeWritePro.no

//================================= noticeContent.no ==================================================		
		if(sPath.equals("/noticeContent.no")) {
			System.out.println("뽑은 가상주소 비교 : /noticeContent.no");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// NoticeDTO noticeDTO = getNotice(request) 메서드 호출
			NoticeDTO noticeDTO = noticeService.getNotice(request);
			
//			// 엔터 \r\n => <br> 바꾸기
//			String a_content = noticeDTO.getA_content();
//			a_content = a_content.replace("\r\n", "<br>");
//			noticeDTO.setA_content(a_content);
			
			// request에 "noticeDTO",noticeDTO 담아서
			request.setAttribute("noticeDTO", noticeDTO);
			// admin/noticeContent.jsp 주소변경없이 이동
			dispatcher 
		    = request.getRequestDispatcher("admin/noticeContent.jsp");
		dispatcher.forward(request, response);			
		}//noticeContent.no

//======================================  update.no =============================================		
		if(sPath.equals("/update.no")) {
			System.out.println("뽑은 가상주소 비교 : /update.no");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// NoticeDTO noticeDTO = getNotice(request) 메서드 호출
			NoticeDTO noticeDTO = noticeService.getNotice(request);
			// request에 "noticeDTO",noticeDTO 담아서
			request.setAttribute("noticeDTO", noticeDTO);
			// admin/noticeUpdate.jsp 주소변경없이 이동
			dispatcher 
			= request.getRequestDispatcher("admin/noticeUpdate.jsp");
			dispatcher.forward(request, response);
		}//update.no	

//====================================== updatePro.no ===============================================		
		if(sPath.equals("/updatePro.no")) {
			System.out.println("뽑은 가상주소 비교 : /updatePro.no");
			request.setCharacterEncoding("utf-8");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			
			// updateNotice(request) 메서드 호출
			String a_notice_type=noticeService.updateNotice(request);
			noticeService.updateNotice(request);

			// noticelist.no 주소 변경 되면서 이동			
//			String a_notice_type = request.getParameter("a_notice_type");
			if(a_notice_type.equals("공지")) {
				response.sendRedirect("noticelist.no");
			}else {
				response.sendRedirect("eventlist.no");
			}
		}//updatePro.no

//===================================== delete.no =============================================				
		if(sPath.equals("/delete.no")) {
			System.out.println("뽑은 가상주소 비교 : /delete.no");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// deleteNotice(request) 메서드 호출
			noticeService.deleteNotice(request);
			// 글목록 noticelist.no 주소 변경 되면서 이동
			response.sendRedirect("noticelist.no");
		}//delete.no
		
		
//============================================= noticelistSearch.no ================================================		
				if(sPath.equals("/noticelistSearch.no")) {
					System.out.println("뽑은 가상주소 비교 : /noticelistSearch.no");
					request.setCharacterEncoding("utf-8");
					
					// 검색어 뽑아오기
					String search = request.getParameter("search");
					System.out.println("search"+search);
					
					//notice 페이징 (NoticePageDTO pageDTO)
					int pageSize=10; 
					String pageNum=request.getParameter("pageNum");
					if(pageNum == null) {
						pageNum = "1";
					}
					int currentPage = Integer.parseInt(pageNum);
					
					NoticePageDTO pageDTO = new NoticePageDTO();
					pageDTO.setPageSize(pageSize);
					pageDTO.setPageNum(pageNum);
					pageDTO.setCurrentPage(currentPage);
					pageDTO.setA_notice_type("공지");
					// 검색어 저장
					pageDTO.setSearch(search);
					
					// NoticeService 객체생성
					noticeService = new NoticeService();
					// List<NoticeDTO> noticeList = getNoticeList(); 메서드 호출
					List<NoticeDTO> noticeList = noticeService.getNoticeListSearch(pageDTO);
					
					System.out.println(noticeList);
					
					// 공지사항 전체 글 개수 (NoticePageDTO)
					int count = noticeService.getNoticeCountSearch(pageDTO);
					System.out.println(count);
					
					int pageBlock = 10;
					int startPage=(currentPage-1)/pageBlock*pageBlock+1;
					int endPage=startPage+pageBlock-1;
					int pageCount = count / pageSize + (count % pageSize==0?0:1);
					if(endPage > pageCount) {
						endPage = pageCount;
					}
					
					// NoticePageDTO pageDTO 저장
					pageDTO.setCount(count);
					pageDTO.setPageBlock(pageBlock);
					pageDTO.setStartPage(startPage);
					pageDTO.setEndPage(endPage);
					pageDTO.setPageCount(pageCount);
					
					
					// request에 "noticeList", noticeList 저장
					request.setAttribute("noticeList", noticeList);
					request.setAttribute("pageDTO", pageDTO);
					
					// 주소변경없이 이동 admin/noticeSearch.jsp
					dispatcher 
					= request.getRequestDispatcher("admin/noticeSearch.jsp");
					dispatcher.forward(request, response);
				}//noticelistSearch.no
		
//**************************************************************************************************
//**************************************************************************************************
//======================================  eventlist.no ================================================		
		if(sPath.equals("/eventlist.no")) {
			System.out.println("뽑은 가상주소 비교 : /eventlist.no");

			//event 페이징 (NoticePageDTO pageDTO2)
			int pageSize=10; 
			String pageNum=request.getParameter("pageNum");
			if(pageNum == null) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);

			NoticePageDTO pageDTO2 = new NoticePageDTO();
			pageDTO2.setPageSize(pageSize);
			pageDTO2.setPageNum(pageNum);
			pageDTO2.setCurrentPage(currentPage);
			pageDTO2.setA_notice_type("이벤트");

			// NoticeService 객체생성
			noticeService = new NoticeService();
			// List<NoticeDTO> eventList = getNoticeList(); 메서드 호출
			List<NoticeDTO> eventList = noticeService.getEventList(pageDTO2);

			// 이벤트 전체 글 개수 (NoticePageDTO)
			int count = noticeService.getEventCount();
			int pageBlock = 10;
			int startPage=(currentPage-1)/pageBlock*pageBlock+1;
			int endPage=startPage+pageBlock-1;
			int pageCount = count / pageSize + (count % pageSize==0?0:1);
			if(endPage > pageCount) {
				endPage = pageCount;
			}

			// NoticePageDTO pageDTO2 저장
			pageDTO2.setCount(count);
			pageDTO2.setPageBlock(pageBlock);
			pageDTO2.setStartPage(startPage);
			pageDTO2.setEndPage(endPage);
			pageDTO2.setPageCount(pageCount);

			// request에 "eventList", eventList 저장
			request.setAttribute("eventList", eventList);
			request.setAttribute("pageDTO2", pageDTO2);

			// 주소변경없이 이동 admin/event.jsp
			dispatcher 
			= request.getRequestDispatcher("admin/event.jsp");
			dispatcher.forward(request, response);
		}//eventlist.no

//=========================================== eventWrite.no ============================================		
		if(sPath.equals("/eventWrite.no")) {
			System.out.println("뽑은 가상주소 비교 : /eventWrite.no");
			// 주소변경없이 이동 admin/noticeWrite.jsp
			dispatcher 
			= request.getRequestDispatcher("admin/noticeWrite.jsp");
			dispatcher.forward(request, response);
		}//eventWrite.no

//============================================ eventWritePro.no ==========================================		
		if(sPath.equals("/eventWritePro.no")) {
			System.out.println("뽑은 가상주소 비교 : /eventWritePro.no");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// 리턴할형없음 insertNotice(request) 메서드 호출
			noticeService.insertEvent(request);
			// noticelist.no 주소 변경 되면서 이동
			response.sendRedirect("eventlist.no");
		}//eventWritePro.no	
		
//================================= eventContent.no ==================================================		
		if(sPath.equals("/eventContent.no")) {
			System.out.println("뽑은 가상주소 비교 : /eventContent.no");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// NoticeDTO noticeDTO = getNotice(request) 메서드 호출
			NoticeDTO noticeDTO = noticeService.getEvent(request);

//			// 엔터 \r\n => <br> 바꾸기
//			String a_content = noticeDTO.getA_content();
//			a_content = a_content.replace("\r\n", "<br>");
//			noticeDTO.setA_content(a_content);

			// request에 "noticeDTO",noticeDTO 담아서
			request.setAttribute("noticeDTO", noticeDTO);
			// admin/eventContent.jsp 주소변경없이 이동
			dispatcher 
			= request.getRequestDispatcher("admin/noticeContent.jsp");
			dispatcher.forward(request, response);			
		}//eventContent.no
		
//====================================== eventUpdate.no =============================================		
		if(sPath.equals("/eventUpdate.no")) {
			System.out.println("뽑은 가상주소 비교 : /eventUpdate.no");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// NoticeDTO noticeDTO = getEvent(request) 메서드 호출
			NoticeDTO noticeDTO = noticeService.getEvent(request);
			// request에 "noticeDTO",noticeDTO 담아서
			request.setAttribute("noticeDTO", noticeDTO);
			// admin/eventUpdate.jsp 주소변경없이 이동
			dispatcher 
			= request.getRequestDispatcher("admin/eventUpdate.jsp");
			dispatcher.forward(request, response);
		}//eventUpdate.no			

//====================================== eventUpdatePro.no ===============================================		
		if(sPath.equals("/eventUpdatePro.no")) {
			System.out.println("뽑은 가상주소 비교 : /eventUpdatePro.no");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// updateEvent(request) 메서드 호출
			noticeService.updateEvent(request);
			// 글목록 noticelist.no 주소 변경되면서 이동
			response.sendRedirect("eventlist.no");
		}//eventUpdatePro.no		
		
//===================================== deleteEvent.no =============================================				
		if(sPath.equals("/deleteEvent.no")) {
			System.out.println("뽑은 가상주소 비교 : /deleteEvent.no");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// deleteNotice(request) 메서드 호출
			noticeService.deleteEvent(request);
			// 글목록 noticelist.no 주소 변경 되면서 이동
			response.sendRedirect("eventlist.no");
		}//deleteEvent.no		
		
//============================================= eventlistSearch.no ================================================		
		if(sPath.equals("/eventlistSearch.no")) {
			System.out.println("뽑은 가상주소 비교 : /eventlistSearch.no");
			request.setCharacterEncoding("utf-8");
			
			// 검색어 뽑아오기
			String search = request.getParameter("search");
			System.out.println("search"+search);
			
			// event 페이징 (NoticePageDTO pageDTO2)
			int pageSize=10; 
			String pageNum=request.getParameter("pageNum");
			if(pageNum == null) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			
			NoticePageDTO pageDTO2 = new NoticePageDTO();
			pageDTO2.setPageSize(pageSize);
			pageDTO2.setPageNum(pageNum);
			pageDTO2.setCurrentPage(currentPage);
			pageDTO2.setA_notice_type("이벤트");
			// 검색어 저장
			pageDTO2.setSearch(search);
			
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// List<NoticeDTO> noticeList = getNoticeList(); 메서드 호출
			List<NoticeDTO> eventList = noticeService.getEventListSearch(pageDTO2);
			
			System.out.println(eventList);
			
			// 공지사항 전체 글 개수 (NoticePageDTO)
			int count = noticeService.getNoticeCountSearch(pageDTO2);
			System.out.println(count);
			
			int pageBlock = 10;
			int startPage=(currentPage-1)/pageBlock*pageBlock+1;
			int endPage=startPage+pageBlock-1;
			int pageCount = count / pageSize + (count % pageSize==0?0:1);
			if(endPage > pageCount) {
				endPage = pageCount;
			}
			
			// NoticePageDTO pageDTO2 저장
			pageDTO2.setCount(count);
			pageDTO2.setPageBlock(pageBlock);
			pageDTO2.setStartPage(startPage);
			pageDTO2.setEndPage(endPage);
			pageDTO2.setPageCount(pageCount);
			
			
			// request에 "eventList", eventList 저장
			request.setAttribute("eventList", eventList);
			request.setAttribute("pageDTO2", pageDTO2);
			
			// 주소변경없이 이동 admin/eventSearch.jsp
			dispatcher 
			= request.getRequestDispatcher("admin/eventSearch.jsp");
			dispatcher.forward(request, response);
		}//eventlistSearch.no		
	}//doProcess
}//class
