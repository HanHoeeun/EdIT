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
import com.itwillbs.service.NoticeService2;

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
		
		if(sPath.equals("/noticelist.no")) {
			System.out.println("뽑은 가상주소 비교 : /noticelist.no");
			
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//doProcess
}//class
