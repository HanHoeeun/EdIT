package com.itwillbs.controller;

import java.io.IOException;

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
		



		if (sPath.equals("/main.me")) {
			dispatcher = request.getRequestDispatcher("main/main.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		
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
			// memeber/login.jsp 주소변경 없이 이동
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
		dispatcher 
	    = request.getRequestDispatcher("member/msg.jsp");   // msg.jsp는 -> 아이디/비밀번호 틀림 창 뜨게
	dispatcher.forward(request, response);
	}
	
	}//	if

	// 수정중 //	
		
		
		
		
		
		
		
		
		
//		마이페이지 - 나의 정보 확인 readonly) >>> 이게 update랑 똑같은건가...? 
		if (sPath.equals("/mypage.me")) {
			System.out.println("뽑은 가상주소 비교 : /mypage.me");
			
			
			
			
		}
		
		
		
		if (sPath.equals("/update.me")) {
			System.out.println("뽑은 가상주소 비교 : /update.me");
			
//			수정 전 DB에서 나의 정보 조회(세션 id) => jsp 화면 출력
//			세션 값 가져오기 -> id 변수 저장
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("m_id");
			
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
			
			
			
		}
		
		
		
		
		
		if (sPath.equals("/main.me")) {
			
			dispatcher = request.getRequestDispatcher("main/main.jsp");
			dispatcher.forward(request, response);
			
			
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	// doProcess()
	
	
}	// MemberController()
