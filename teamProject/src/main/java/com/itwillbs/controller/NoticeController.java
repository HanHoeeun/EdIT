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


import com.itwillbs.domain.NoticeDTO;
import com.itwillbs.domain.NoticePageDTO;
import com.itwillbs.service.NoticeService;

public class NoticeController extends HttpServlet{
	
	NoticeService noticeService = null;
	RequestDispatcher dispatcher = null;
	
	
	@Override
	protected void doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		this.doProcess(requset, response);
	}//doGet()

	@Override
	protected void doPost(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		this.doProcess(requset, response);
	}//doPost()
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductController doProcess()");
		// 가상주소 뽑아오기
		String sPath=request.getServletPath();
		System.out.println("뽑은 가상주소 :  " + sPath);
		
		//================================================= 일반공지 리스트 =============================================
		if(sPath.equals("/noticelist.no")) {
			System.out.println("뽑은 가상주소 비교 : /noticelist.no");
			// 한페이지에서 보여지는 글 개수 설정
			int pageSize=10;
			// 페이지번호 
			String pageNum=request.getParameter("pageNum");
			// 페이지번호가 없으면 1페이지 설정
			if(pageNum == null) {
				pageNum = "1";
			}
			// 페이지 번호를 => 정수형 변경
			int currentPage = Integer.parseInt(pageNum);
			
			NoticePageDTO pageDTO = new NoticePageDTO();
			pageDTO.setPageSize(pageSize);
			pageDTO.setPageNum(pageNum);
			pageDTO.setCurrentPage(currentPage);
			
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// List<NoticeDTO> noticeList = getnoticeList(); 메서드 호출
			List<NoticeDTO> noticeList = noticeService.getNoticeList(pageDTO);
			// 게시판 전체 글 개수 구하기 
			int count = noticeService.getNoticeCount();
			// 한화면에 보여줄 페이지개수 설정
			int pageBlock = 10;
			// 시작하는 페이지번호
			int startPage=(currentPage-1)/pageBlock*pageBlock+1;
			// 끝나는 페이지번호
			int endPage=startPage+pageBlock-1;
			// 전체 페이지 구하기
			int pageCount = count / pageSize + (count % pageSize==0?0:1);
			if(endPage > pageCount) {
				endPage = pageCount;
			}
			//pageDTO 저장
			pageDTO.setCount(count);
			pageDTO.setPageBlock(pageBlock);
			pageDTO.setStartPage(startPage);
			pageDTO.setEndPage(endPage);
			pageDTO.setPageCount(pageCount);
			
			// request에 "noticeList",noticeList 저장
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("pageDTO", pageDTO);	
			
			System.out.println("pageDTO");
			
			dispatcher = request.getRequestDispatcher("/admin/notice_copy.jsp");
			dispatcher.forward(request, response);	
		}//noticelist.no
		
		//=============================================== 공지글 작성 ================================================
//		if(sPath.equals("/write.no")) { 
//			System.out.println("뽑은 가상주소 비교 : /write.no");
//			NoticeService noticeService = new NoticeService();
//			noticeService.insertNotice(request);
//			// 주소변경 이동 "notice.no?tab=tab-1" 
//			response.sendRedirect("notice.no?tab=tab-1");//=> 글 작성 후 일반공지 리스트로 이동
//		}//write.no
//		
//		if(sPath.equals("/notice.no")) {
//			System.out.println("뽑은 가상주소 비교 : /notice.no");
//			// 한페이지에서 보여지는 글 개수 설정
//			int pageSize=10;
//			// 페이지번호 
//			String pageNum=request.getParameter("pageNum");
//			// 페이지번호가 없으면 1페이지 설정
//			if(pageNum == null) {
//				pageNum = "1";
//			}
//			// 페이지 번호를 => 정수형으로 변경
//			int currentPage = Integer.parseInt(pageNum);
//			System.out.println("n_pageNum"+pageNum);
//			NoticePageDTO pageDTO = new NoticePageDTO();
//			pageDTO.setN_pageSize(n_pageSize);
//			pageDTO.setN_pageNum(n_pageNum);
//			pageDTO.setN_currentPage(n_currentPage);
//			
//			// NoticeService 객체생성
//			noticeService = new NoticeService();
//			
//			// List<NoticeDTO> noticeList = getNoticeList(); 메서드 호출
//			List<NoticeDTO> noticeList=noticeService.getNoticeList(pageDTO);
//			// 게시판 전체 글 개수 구하기 
//			int n_count = noticeService.getNoticeCount();
//			// 한화면에 보여줄 페이지개수 설정
//			int n_pageBlock = 10;
//			// 시작하는 페이지번호
//			int n_startPage=(n_currentPage-1)/n_pageBlock*n_pageBlock+1;
//			// 끝나는 페이지번호
//			int n_endPage=n_startPage+n_pageBlock-1;
//			// 전체 페이지 구하기
//			int n_pageCount = n_count / n_pageSize + (n_count % n_pageSize==0?0:1);
//			if(n_endPage > n_pageCount) {
//				n_endPage = n_pageCount;
//			}
//			
//			
//			//pageDTO 저장
//			pageDTO.setN_count(n_count);
//			pageDTO.setN_pageBlock(n_pageBlock);
//			pageDTO.setN_startPage(n_startPage);
//			pageDTO.setN_endPage(n_endPage);
//			pageDTO.setN_pageCount(n_pageCount);
//			// request에 "noticeList",noticeList 저장
//			System.out.println("noticeListSize"+noticeList.size());
//			
//			request.setAttribute("noticeList", noticeList);
//			request.setAttribute("pageDTO", pageDTO);
//			
//			// 주소변경없이 이동 "admin/notice_copy.jsp"
//			dispatcher = request.getRequestDispatcher("admin/notice_copy.jsp");
//			dispatcher.forward(request, response);
//		}//notice.no

//=============================================== 공지글 작성 ================================================
		if(sPath.equals("/writePro.no")) {
			System.out.println("뽑은 가상주소 비교 : /writePro.no");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// 리턴할형없음 insertNotice(request) 메서드 호출
			noticeService.insertNotice(request);
			// list.no 주소 변경 되면서 이동
			response.sendRedirect("noticelist.no");//=> 글 작성 후 일반공지 리스트로 이동
		}//writePro.no

//=============================================== 게시물 상세페이지 ================================================
		if(sPath.equals("/content.no")) {
			System.out.println("뽑은 가상주소 비교 : /content.no");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// NoticeDTO noticeDTO = getNotice(request) 메서드 호출
			NoticeDTO noticeDTO = noticeService.getNotice(request);
			
			// 엔터치면 줄바뀌게 -> <br>
//			String content = noticeDTO.getA_content();
//			content = content.replace("\r\n", "<br>"); //"\r\n"엔터 -> "<br>"줄바꿈
//			noticeDTO.setA_content(content);
			
			// request에 "noticeDTO",noticeDTO 담아서
			request.setAttribute("noticeDTO", noticeDTO);
			// center/content.jsp 주소변경없이 이동
			dispatcher = request.getRequestDispatcher("admin/noticeContent.jsp");
			dispatcher.forward(request, response);
		}//content.no

//=============================================== 게시물 수정 페이지 ================================================
		if(sPath.equals("/update.no")) {
			System.out.println("뽑은 가상주소 비교 : /update.no");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// NoticeDTO noticeDTO = getNotice(request) 메서드 호출
			NoticeDTO noticeDTO = noticeService.getNotice(request);
			// request에 "noticeDTO",noticeDTO 담아서
			request.setAttribute("noticeDTO", noticeDTO);
			// center/update.jsp 주소변경없이 이동
			dispatcher = request.getRequestDispatcher("admin/noticeUpdate.jsp");
			dispatcher.forward(request, response);
		}//update.no
		
		if(sPath.equals("/updatePro.no")) {
			System.out.println("뽑은 가상주소 비교 : /updatePro.no");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// noticeDTO(request) 메서드 호출
			noticeService.updateNotice(request);
			// 글목록 noticelist.no 주소 변경되면서 이동
			response.sendRedirect("noticelist.no");
		}//updatePro.no
		
//=============================================== 게시물 삭제 페이지 ================================================		
		if(sPath.equals("/delete.no")) {
			System.out.println("뽑은 가상주소 비교 : /delete.no");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// deleteNotice(request) 메서드 호출
			noticeService.deleteNotice(request);
			// 글목록 noticelist.no 주소 변경 되면서 이동
			response.sendRedirect("noticelist.no");
		}//delete.no
		
//=============================================== 파일 업로드 ================================================
		if(sPath.equals("/fwrite.no")) {
			// 주소변경없이 이동 admin/fwrite.jsp
			dispatcher = request.getRequestDispatcher("admin/fwrite.jsp");
			dispatcher.forward(request, response);
		}//fwrite.no

		if(sPath.equals("/fwritePro.no")) {
			System.out.println("뽑은 가상주소 비교 : /fwritePro.no");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// 리턴할형없음 finsertNotice(request) 메서드 호출
			//					noticeService.finsertNotice(request);
			// list.no 주소 변경 되면서 이동
			response.sendRedirect("noticelist.no");
		}//fwritePro.no
		
//=============================================== 파일 수정 ================================================
//		if(sPath.equals("/fupdate.no")) {
//			System.out.println("뽑은 가상주소 비교 : /fupdate.no");
//			// NoticeService 객체생성
//			noticeService = new NoticeService();
//			// NoticeDTO noticeDTO = getNotice(request) 메서드 호출
//			NoticeDTO noticeDTO = NoticeService.getNotice(request);
//			// request에 "noticeDTO",noticeDTO 담아서
//			request.setAttribute("noticeDTO", noticeDTO);
//			// admin/noticeUpdate.jsp 주소변경없이 이동
//			dispatcher = request.getRequestDispatcher("admin/noticeUpdate.jsp");
//			dispatcher.forward(request, response);
//		}//fupdate.no
//		
//		if(sPath.equals("/fupdatePro.no")) {
//			System.out.println("뽑은 가상주소 비교 : /fupdatePro.no");
//			// NoticeService 객체생성
//			noticeService = new NoticeService();
//			// updateNotice(request) 메서드 호출
//			noticeService.fupdateNotice(request);
//			// 글목록 list.no 주소 변경 되면서 이동
//			response.sendRedirect("noticelist.no");
//		}//fupdatePro.no
		
//================================================= 이벤트 리스트 =============================================
		if(sPath.equals("/eventlist.no")) {
			System.out.println("뽑은 가상주소 비교 : /eventlist.no");
			// 한페이지에서 보여지는 글 개수 설정
			int pageSize=10;
			// 페이지번호 
			String pageNum=request.getParameter("pageNum");
			// 페이지번호가 없으면 1페이지 설정
			if(pageNum == null) {
				pageNum = "1";
			}
			// 페이지 번호를 => 정수형 변경
			int currentPage = Integer.parseInt(pageNum);
			
			NoticePageDTO pageDTO = new NoticePageDTO();
			pageDTO.setPageSize(pageSize);
			pageDTO.setPageNum(pageNum);
			pageDTO.setCurrentPage(currentPage);
			
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// List<NoticeDTO> eventList = geteventList(); 메서드 호출
			List<NoticeDTO> eventList = noticeService.getEventList(pageDTO);
			
			// 게시판 전체 글 개수 구하기 
			int count = noticeService.getNoticeCount();
			// 한화면에 보여줄 페이지개수 설정
			int pageBlock = 10;
			// 시작하는 페이지번호
			int startPage=(currentPage-1)/pageBlock*pageBlock+1;
			// 끝나는 페이지번호
			int endPage=startPage+pageBlock-1;
			// 전체 페이지 구하기
			int pageCount = count / pageSize + (count % pageSize==0?0:1);
			if(endPage > pageCount) {
				endPage = pageCount;
			}
			//pageDTO 저장
			pageDTO.setCount(count);
			pageDTO.setPageBlock(pageBlock);
			pageDTO.setStartPage(startPage);
			pageDTO.setEndPage(endPage);
			pageDTO.setPageCount(pageCount);
			
			// request에 "noticeList",noticeList 저장
			request.setAttribute("eventList", eventList);
			request.setAttribute("pageDTO", pageDTO);	
			
			dispatcher = request.getRequestDispatcher("/admin/notice_copy.jsp");
			dispatcher.forward(request, response);	
		
		}//eventnlist.no
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//doProcess

}//class
