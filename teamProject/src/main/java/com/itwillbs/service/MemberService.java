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
//			회원번호 불러와야하는데 이거 보드num 참고해서 해야함.... 맥스 어쩌구 추가해줘야함
//			한글처리
			request.setCharacterEncoding("utf-8");
			
//			request에서 저장된 파라미터 값 가져오기
			String id = request.getParameter("_6id");
			String pass1 = request.getParameter("_6pass1");
			String pass2 = request.getParameter("_6pass2");
			String name = request.getParameter("_6name");
			String nick = request.getParameter("_6nick");
			String email = request.getParameter("_6mail");
			int phone = Integer.parseInt(request.getParameter("_6phone"));
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

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
