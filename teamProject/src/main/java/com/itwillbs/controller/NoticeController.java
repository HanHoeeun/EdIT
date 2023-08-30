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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}//doGet()

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}//doPost()
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductController doProcess()");
		// 가상주소 뽑아오기
		String sPath=request.getServletPath();
		System.out.println("뽑은 가상주소 :  " + sPath);
		
		//================================================= 공지 리스트 =============================================
		if(sPath.equals("/list.no")) {
			System.out.println("뽑은 가상주소 비교 : /list.no");
			// 한페이지에서 보여지는 글 개수 설정
			int pageSize=10;
			// 페이지번호 
			String pageNum=request.getParameter("pageNum");
			// 페이지번호가 없으면 1페이지 설정
			if(pageNum == null) {
				pageNum = "1";
			}
			// 페이지 번호를 => 정수형으로 변경
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
			
			dispatcher = request.getRequestDispatcher("/admin/notice_copy.jsp");
			dispatcher.forward(request, response);	
		}//list.no
		
		//=============================================== 공지글 작성 ================================================
		if(sPath.equals("/write.no")) { 
			System.out.println("뽑은 가상주소 비교 : /write.no");
			NoticeService noticeService = new NoticeService();
			noticeService.insertNotice(request);
			// 주소변경 이동 "notice.no?tab=tab-1"
			response.sendRedirect("notice.no?tab=tab-1");
		}//write.no
		
		if(sPath.equals("/notice.no")) {
			System.out.println("뽑은 가상주소 비교 : /write.no");
			// 주소변경없이 이동 "admin/notice_copy.jsp"
			dispatcher = request.getRequestDispatcher("admin/notice_copy.jsp");
			dispatcher.forward(request, response);
		}//notice.no
		
		if(sPath.equals("/writePro.no")) {
			System.out.println("뽑은 가상주소 비교 : /writePro.no");
			// BoardService 객체생성
			noticeService = new NoticeService();
			// 리턴할형없음 insertBoard(request) 메서드 호출
			noticeService.insertNotice(request);
			// list.bo 주소 변경 되면서 이동
			response.sendRedirect("list.no");
		}//writePro.no
		
		if(sPath.equals("/content.no")) {
			System.out.println("뽑은 가상주소 비교 : /content.no");
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// NoticeDTO noticeDTO = getNotice(request) 메서드 호출
			NoticeDTO noticeDTO = noticeService.getNotice(request);
			
			// 엔터치면 줄바뀌게 -> <br>
			String content = noticeDTO.getA_content();
			content = content.replace("\r\n", "<br>"); //"\r\n"엔터 -> "<br>"줄바꿈
			noticeDTO.setA_content(content);
			
			// request에 "noticeDTO",noticeDTO 담아서
			request.setAttribute("noticeDTO", noticeDTO);
			// center/content.jsp 주소변경없이 이동
			dispatcher = request.getRequestDispatcher("admin/content.jsp");
			dispatcher.forward(request, response);
		}//content.no
		
		if(sPath.equals("/fwrite.no")) {
			// 주소변경없이 이동 admin/fwrite.jsp
			dispatcher = request.getRequestDispatcher("admin/fwrite.jsp");
			dispatcher.forward(request, response);
		}//fwrite.no
		
		if(sPath.equals("/fwritePro.no")) {
			System.out.println("뽑은 가상주소 비교 : /fwritePro.no");
			// BoardService 객체생성
			noticeService = new NoticeService();
			// 리턴할형없음 finsertBoard(request) 메서드 호출
//			noticeService.finsertNotice(request);
			// list.bo 주소 변경 되면서 이동
			response.sendRedirect("list.no");
		}//fwritePro.no
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//doProcess

}//class
