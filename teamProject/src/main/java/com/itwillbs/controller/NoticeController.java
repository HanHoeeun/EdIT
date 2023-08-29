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
			
			PageDTO pageDTO = new PageDTO();
			pageDTO.setPageSize(pageSize);
			pageDTO.setPageNum(pageNum);
			pageDTO.setCurrentPage(currentPage);
			
			// NoticeService 객체생성
			noticeService = new NoticeService();
			// List<NoticeDTO> noticeList = getnoticeList(); 메서드 호출
			List<NoticeDTO> noticeList=noticeService.getNoticeList(pageDTO);
			// 게시판 전체 글 개수 구하기 
			int count = noticeService.getNoticeCount();
			// 한화면에 보여줄 페이지개수 설정
			int pageBlock = 10;
			// 시작 페이지
			int startPage=(currentPage-1)/pageBlock*pageBlock+1;
			// 마지막 페이지
			int endPage=startPage+pageBlock-1;
			// 전체 페이지
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

			// 주소변경없이 이동 admin/notice.jsp
			dispatcher = request.getRequestDispatcher("admin/notice.jsp");
			dispatcher.forward(request, response);				
		}//list.no
		
		if(sPath.equals("/writePro.no")) {
			System.out.println("뽑은 가상주소 비교 : /writePro.no");
			// 주소변경없이 이동 center/write.jsp
		}//write.no
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//doProcess

}//class
