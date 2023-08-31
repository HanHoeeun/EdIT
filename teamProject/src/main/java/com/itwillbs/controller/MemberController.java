package com.itwillbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.CallSite;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.itwillbs.dao.MemberDAO;
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
		

		
		
//		회원가입 화면
		if (sPath.equals("/insert.me")) {
			System.out.println("뽑은 가상주소 비교 : " + sPath);
			
			dispatcher = request.getRequestDispatcher("member/registered_3.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
//		회원가입
		if (sPath.equals("/insertPro.me")) {
			System.out.println("뽑은 가상주소 비교 : insertPro.me");

			memberService = new MemberService();
			memberService.insertMember(request);
			
			response.sendRedirect("login.me");
			
		}
		
		
//		로그인 화면
		if (sPath.equals("/login.me")) {
		System.out.println("뽑은 가상주소 비교 : login.me");
		
		
		dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response);
		
	}
		
		
//		로그인 하기 -- 로그인 성공은 뜨는데... 메인화면으로 이동 안함
		if (sPath.equals("/loginPro.me")) {
			System.out.println("뽑은 가상주소 비교 : loginPro.me");
			
			memberService = new MemberService();
			
			MemberDTO memberDTO = memberService.userCheck(request);
			
			if (memberDTO != null) {
				
				HttpSession session = request.getSession();
				session.setAttribute("m_id", memberDTO.getM_id());
				
				response.sendRedirect("main.me");
				
			} else {
				dispatcher = request.getRequestDispatcher("member/login.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		
		
		
//		메인
		if (sPath.equals("/main.me")) {
			System.out.println("뽑은 가상주소 비교 : main.me");
			
			dispatcher = request.getRequestDispatcher("main/main.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
//		로그아웃
		if (sPath.equals("/logout.me")) {
			System.out.println("뽑은 가상주소 비교 : logout.me");
			
			HttpSession session = request.getSession();
			session.invalidate();
			
			response.sendRedirect("main.me");
			
		}
		
		
		
//		회원정보확인
		if (sPath.equals("/mypage.me")) {
			System.out.println("뽑은 가상주소 비교 : mypage.me");
			
//			DB의 나의 정보 조회
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("m_id");
			

			memberService = new MemberService();
			MemberDTO memberDTO =  memberService.getMember(id);
			
			request.setAttribute("memberDTO", memberDTO);
			
			
			dispatcher = request.getRequestDispatcher("member/mypage.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
		if (sPath.equals("/update.me")) {
			System.out.println("뽑은 가상주소 비교 : update.me");
			
//			DB의 나의 정보 조회
			HttpSession session = request.getSession();
			String m_id = (String)session.getAttribute("m_id");
			

			memberService = new MemberService();
			MemberDTO memberDTO =  memberService.getMember(m_id);
			
			request.setAttribute("memberDTO", memberDTO);
			
			
			dispatcher = request.getRequestDispatcher("member/update.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
		
//		회원정보 수정	---------------------------------------------------------------수정해야함
		if (sPath.equals("/updatePro.me")) {
			System.out.println("뽑은 가상주소 비교 : updatePro.me");

			memberService = new MemberService();
			
//			아이디, 비밀번호 일치하는지 확인
			MemberDTO memberDTO = memberService.userCheck(request);
			
			
//			일치하면 updateMember 호출
			if (memberDTO != null) {
				
				memberService.updateMember(request);
				
				response.sendRedirect("mypage.me");
				
			} else {
//				불일치면 경고 메시지 화면에 띄우기 나중에 고치기
				dispatcher = request.getRequestDispatcher("member/update.jsp");
				dispatcher.forward(request, response);
				
			}
			
		}
		
		
//		회원탈퇴 화면
		if (sPath.equals("/delete.me")) {
			System.out.println("뽑은 가상주소 비교 : delete.me");
			
			dispatcher = request.getRequestDispatcher("member/delete.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
//		회원탈퇴하기
		if (sPath.equals("/deletePro.me")) {
			System.out.println("뽑은 가상주소 비교 : deletePro.me");
			
			memberService = new MemberService();
			
			MemberDTO memberDTO = memberService.userCheck(request);
					
			if (memberDTO != null) {
				memberService.deleteMember(request);
				
				HttpSession session = request.getSession();
				session.invalidate();
				
				response.sendRedirect("main.me");
				
			} else {
//				아이디, 비밀번호 불일치 -> 경고 메시지다 -------------------------------수정
				dispatcher = request.getRequestDispatcher("member/war.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		
		
//		회원리스트
		if (sPath.equals("listjson.me")) {
			System.out.println("뽑은 가상주소 비교 : listjson.me");
			
			memberService = new MemberService();
			
			List<MemberDTO> memberList = memberService.getMemberList();
			
			JSONArray arr = new JSONArray();
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
			
			
			for (int i=0; i<memberList.size(); i++) {
				MemberDTO memberDTO = memberList.get(i);
				
				JSONObject object = new JSONObject();
				object.put("m_num", memberDTO.getM_num());
				object.put("m_id", memberDTO.getM_id());
				object.put("m_pass", memberDTO.getM_pass());
				object.put("m_name", memberDTO.getM_name());
				object.put("m_nick", memberDTO.getM_nick());
				object.put("m_email", memberDTO.getM_email());
				object.put("m_phone", memberDTO.getM_phone());
				object.put("m_date", memberDTO.getM_date());
				
				
//				배열 한칸에 저장
				arr.add(object);
				
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
//		아이디 중복체크
		if (sPath.equals("/idCheck.me")) {
			System.out.println("뽑은 가상주소 비교 : idCheck.me");
			
			
			String id = request.getParameter("_6id");
			System.out.println("받은 아이디 : " +id);
			
			memberService = new MemberService();
			memberService.getMember(id);
			
			MemberDTO memberDTO = memberService.getMember(id);
			
			String result = "";
			if (memberDTO != null) {
				System.out.println("아이디 중복");
				result = "아이디 중복입니다";
			} else {
				System.out.println("아이디 사용가능!");
				result = "아이디 사용가능 합니다";
			}
			
//			이동하지 않고 결과를 웹 화면에 출력
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.print(result);
			printWriter.close();
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	// doProcess()
	
	
}	// MemberController()
