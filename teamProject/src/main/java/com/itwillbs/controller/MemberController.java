package com.itwillbs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.domain.MemberDTO;
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
		

		
//		회원가입
		if (sPath.equals("/insert.me")) {
			System.out.println("뽑은 가상주소 비교 : /insert.me");
			
//			주소변경 없이 이동
			dispatcher = request.getRequestDispatcher("member/registered_3.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
//		회원가입완료 후 로그인 창으로 이동
		if (sPath.equals("/insertPro.me")) {
			System.out.println("뽑은 가상주소 비교 : /insertPro.me");
			
//			MemberService 객체생성
//			insertMember(request) 호출
			memberService = new MemberService();
			memberService.insertMember(request);
			
//			로그인 화면 이동 -> 주소 변경 하면서 이동
			response.sendRedirect("login.me");
			
		}
		
		
		
		// 진유정 수정중
		if(sPath.equals("/login.me")) {
			// member/login.jsp 주소변경 없이 이동
			dispatcher = request.getRequestDispatcher("member/login.jsp");
			dispatcher.forward(request, response);
	}
		
		
		if(sPath.equals("/loginPro.me")) {
			System.out.println("뽑은 가상주소 비교 : /insertPro.me");
			
			// MemberService 객체생성
			memberService = new MemberService();
			// MemberDTO memberDTO = userCheck(request) 메서드 호출
			MemberDTO memberDTO = memberService.userCheck(request);
	
			if(memberDTO != null) {
				// memberDTO != null 아이디 비밀번호 일치=> 세션값 저장=>main.me
				HttpSession session = request.getSession();
				session.setAttribute("id", memberDTO.getM_id());
				response.sendRedirect("main.me");
			}else {
				// memberDTO == null 아이디 비밀번호 틀림=> member/msg.jsp
				dispatcher = request.getRequestDispatcher("member/msg.jsp");   // msg.jsp는 -> 아이디/비밀번호 틀림 창 뜨게
				dispatcher.forward(request, response);
			}
	
		}//	if

	// 수정중 //	
		

		
//		메인
		if (sPath.equals("/main.me")) {
			System.out.println("뽑은 가상주소 비교 : /main.me");
			
//			주소 변경 없이 이동
			dispatcher = request.getRequestDispatcher("main/main.jsp");
			dispatcher.forward(request, response);
		}
		
		
//		로그아웃
		if (sPath.equals("/logout.me")) {
			System.out.println("뽑은 가상주소 비교 : /logout.me");
			
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("main.me");
			
		}
		 
		
		
//		회원정보 확인 -  마이페이지		
		if (sPath.equals("/update.me")) {
			System.out.println("뽑은 가상주소 비교 : /update.me");
			
//			수정 전 DB에서 나의 정보 조회(세션 id) => jsp 화면 출력
//			세션 값 가져오기 -> id 변수 저장
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("m_id");
//			수정해야할거 다 가져와야할것같음.... 어우졸려
			
//			memberService 객체생성
			memberService = new MemberService();
			
//			MemberDTO memberDTO = getMember(id) 메서드 호출
			MemberDTO memberDTO = memberService.getMember(id);
			
//			request에 memberDTO 저장 ("이름", 값)
			request.setAttribute("memberDTO", memberDTO);
			
//			주소변경 없이 이동
			dispatcher = request.getRequestDispatcher("member/mypage.jsp");
			dispatcher.forward(request, response);
			
		}
		
//		회원정보 수정
		if (sPath.equals("/updatePro.me")) {
			System.out.println("뽑은 가상주소 비교 : /updatePro.me");
			
//			request 안 폼에서 입력한 수정 값이 저장
//			MemberService 객체생성
			memberService = new MemberService();
			
//			아이디, 비밀번호 일치하는지 확인 userCheck
			MemberDTO memberDTO = memberService.userCheck(request);
			
//			
			if (memberDTO != null) {
				memberService.updateMember(request);
				response.sendRedirect("main.me");
			} else {
				dispatcher = request.getRequestDispatcher("member/msg.jsp");
				dispatcher.forward(request, response);
			}
		}

		
//		회원탈퇴
		if (sPath.equals("/delete.me")) {
			System.out.println("뽑은 가상주소 비교 : /deletePro.me");
			
//			MemberService 객체생성
			memberService = new MemberService();
			
//			아이디, 비밀번호 일치하는지 확인
			MemberDTO memberDTO = memberService.userCheck(request);
			
			if (memberDTO != null) {
				memberService.deleteMember(request);
				
//				세션 초기화
				HttpSession session = request.getSession();
				session.invalidate();
				
//				주소 변경하면서 메인화면으로 이동
				response.sendRedirect("main.me");
			} else {
//				아이디, 비밀번호 불일치시 경고메시지
				dispatcher = request.getRequestDispatcher("member/msg.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		
		
		
//		아이디 중복체크
		if (sPath.equals("/idCheck.me")) {
			System.out.println("뽑은 가상주소 비교 : /idCheck.me");
			
			String id = request.getParameter("m_id");
			System.out.println("받은 아이디 : " + id);
			
//			memberService 객체생성
			memberService = new MemberService();
			
//			getMember(id) 메서드 호출
			memberService.getMember(id);
			
			MemberDTO memberDTO = memberService.getMember(id);
			
			String result ="";
			if (memberDTO != null) {
				System.out.println("아이디 중복");
				result = "아이디 중복";
			} else {
				System.out.println("아이디 사용가능");
				result = "아이디 사용 가능";
			}
			
//			이동하지 않고 결과를 웹에 출력 ( 출력 결과를 가지고 되돌아감)
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.println(result);
			printWriter.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	// doProcess()
	
	
}	// MemberController()
