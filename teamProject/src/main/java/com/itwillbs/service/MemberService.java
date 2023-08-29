package com.itwillbs.service;



import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberDTO;

public class MemberService {
	
	MemberDAO memberDAO = null;
	

	public void insertMember(HttpServletRequest request) {
		System.out.println("MemberService insertMember()");
		
		try {

//			한글처리
			request.setCharacterEncoding("utf-8");
			
//			request에서 저장된 파라미터 값 가져오기
			String id = request.getParameter("_6id");
			String pass1 = request.getParameter("_6pass1");
			String pass2 = request.getParameter("_6pass2");
			String name = request.getParameter("_6name");
			String nick = request.getParameter("_6nick");
			String email = request.getParameter("_6email");
			String phone = request.getParameter("_6phone");
			Timestamp date = new Timestamp(System.currentTimeMillis());
			String event = request.getParameter("_6check");
			
			int num = 1;
			
//			MemberDAO 객체생성
			memberDAO = new MemberDAO();
			
			num = memberDAO.getMaxNum() + 1;
			
//			MemberDTO 객체생성
			MemberDTO memberDTO = new MemberDTO();
//			set() 메서드 호출파라미터 값 저장
			memberDTO.setM_num(num);
			memberDTO.setM_id(id);
			memberDTO.setM_pass(pass1);
			memberDTO.setM_pass(pass2);
			memberDTO.setM_name(name);
			memberDTO.setM_nick(nick);
			memberDTO.setM_email(email);
			memberDTO.setM_phone(phone);
			memberDTO.setM_date(date);
			memberDTO.setM_event(event);
			
//			insertMember() 호출
			memberDAO.insertMember(memberDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	public MemberDTO getMember(String id) {
		System.out.println("MemberService getMember()");
		
		MemberDTO memberDTO = null;
		
		try {
			
			memberDAO = new MemberDAO();
			memberDTO = memberDAO.getMember(id);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberDTO;
	}

	
	
	public MemberDTO userCheck(HttpServletRequest request) {
		System.out.println("MemberService userCheck()");
		MemberDTO memberDTO = null;
		try {
			// 한글처리
			request.setCharacterEncoding("utf-8");
			// id,pass 파라미터 값 가져오기
			String id = request.getParameter("_6id");
			String pass = request.getParameter("_6pass");
			// MemberDTO 저장
			MemberDTO memberDTO2 = new MemberDTO();
			memberDTO2.setM_id(id);
			memberDTO2.setM_pass(pass);
			// MemberDAO 객체생성
			memberDAO = new MemberDAO();
			// MemberDTO = userCheck(memberDTO2) 메서드 호출
			memberDTO = memberDAO.userCheck(memberDTO2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberDTO;
	} // userCheck()



	public void updateMember(HttpServletRequest request) {
		System.out.println("MemberService getMember()" );
		
		try {
//			한글처리
			request.setCharacterEncoding("utf-8");
			
			String id = request.getParameter("_6id");
			String pass1 = request.getParameter("_6pass1");
			String pass2 = request.getParameter("_6pass2");
			String name = request.getParameter("_6name");
			String nick = request.getParameter("_6nick");
			String email = request.getParameter("_6email");
			String phone = request.getParameter("_6phone");
			String event = request.getParameter("_6check");
			
			
			MemberDTO memberDTO = new MemberDTO();
			
			memberDTO.setM_id(id);
			memberDTO.setM_pass(pass1);
			memberDTO.setM_pass(pass2);
			memberDTO.setM_name(name);
			memberDTO.setM_nick(nick);
			memberDTO.setM_email(email);
			memberDTO.setM_phone(phone);
			memberDTO.setM_event(event);
			
			memberDAO = new MemberDAO();
			memberDAO.updateMember(memberDTO);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	public void deleteMember(HttpServletRequest request) {
		System.out.println("MemberService deleteMember()" );
		
		try {
			
			String id = request.getParameter("_6id");
			String pass = request.getParameter("_6pass");
			
			MemberDTO memberDTO = new MemberDTO();
			
			memberDTO.setM_id(id);
			memberDTO.setM_pass(pass);
			
			memberDAO = new MemberDAO();
			memberDAO.deleteMember(memberDTO);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
