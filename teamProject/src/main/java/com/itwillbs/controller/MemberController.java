package com.itwillbs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.service.MemberService;

public class MemberController extends HttpServlet{
	
	RequestDispatcher dispatcher = null;
	MemberService memberService = null;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController doGet()");
		doProcess(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController doPost()");
		doProcess(request, response);
	}
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController doProcess()");
		
//		가상주소 뽑아오기
		String sPath = request.getServletPath();
		System.out.println("뽑은 가상주소 : " + sPath);
		
		
		if (sPath.equals("/insert.me")) {
			System.out.println("뽑은 가상주소 비교 : /insert.me");
			
//			주소변경 없이 이동
			dispatcher = request.getRequestDispatcher("member/registered_3.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
		if (sPath.equals("/insertPro.me")) {
			System.out.println("뽑은 가상주소 비교 : /insertPro.me");
			
//			MemberService 객체생성
//			insertMember(request) 호출
			memberService = new MemberService();
			memberService.insertMember(request);
			
//			로그인 화면 이동 -> 주소 변경 하면서 이동
			response.sendRedirect("login.me");
			
		}
		
		// 내가 추가함
		if(sPath.equals("/login.me")) {
			// member/login.jsp 주소변경 없이 이동
		dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response);
					}//

		

		
		if (sPath.equals("/idCheck.me")) {
			System.out.println("뽑은 가상주소 비교 : /idCheck.me");
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	// doProcess()
	
	
}	// MemberController()
