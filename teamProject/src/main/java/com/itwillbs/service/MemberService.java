package com.itwillbs.service;



import java.io.UnsupportedEncodingException;
import java.lang.reflect.Member;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberDTO;

public class MemberService {
	
	MemberDAO memberDAO = null;

	public void insertMember(HttpServletRequest request) {
		System.out.println("MemberService insertMember()");
		
		try {
			
			request.setCharacterEncoding("utf-8");
			
			String m_id = request.getParameter("_6id");
			String m_pass1 = request.getParameter("_6pass1");
			String m_pass2 = request.getParameter("_6pass2");
			String m_name = request.getParameter("_6name");
			String m_nick = request.getParameter("_6nick");
			String m_phone = request.getParameter("_6phone");
			String m_email = request.getParameter("_6email");
			Timestamp m_date = new Timestamp(System.currentTimeMillis());
			String m_event = request.getParameter("_6event");
			
			int m_num = 1;
			
			memberDAO = new MemberDAO();
			
			m_num = memberDAO.getMaxNum() + 1;
			

			MemberDTO memberDTO = new MemberDTO();
			
			memberDTO.setM_num(m_num);
			memberDTO.setM_id(m_id);
			memberDTO.setM_pass(m_pass1);
			memberDTO.setM_pass(m_pass2);
			memberDTO.setM_name(m_name);
			memberDTO.setM_nick(m_nick);
			memberDTO.setM_phone(m_phone);
			memberDTO.setM_email(m_email);
			memberDTO.setM_date(m_date);
			memberDTO.setM_event(m_event);
			
			System.out.println(memberDTO);
			
			
			memberDAO.insertMember(memberDTO);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
//	로그인 유저체크
	public MemberDTO userCheck(HttpServletRequest request) {
		System.out.println("MemberService userCheck()");
		
		MemberDTO memberDTO = null;
		
		try {
			
//			한글처리
			request.setCharacterEncoding("utf-8");
			
			
			String m_id = request.getParameter("_5id");
			String m_pass = request.getParameter("_5pass");
			
			MemberDTO memberDTO2 = new MemberDTO();
			memberDTO2.setM_id(m_id);
			memberDTO2.setM_pass(m_pass);
			
			memberDAO = new MemberDAO();
			memberDTO = memberDAO.userCheck(memberDTO2);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return memberDTO;
	}


	public MemberDTO getMember(String m_id) {
		System.out.println("MemberService getMember()");
		
		MemberDTO memberDTO = null;
		
		try {
			
			memberDAO = new MemberDAO();
			memberDTO = memberDAO.getMember(m_id);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberDTO;
	}


	
//	회원정보 수정
	public void updateMember(HttpServletRequest request) {
		System.out.println("MemberService updateMember()");
		
		try {
//			한글처리
			request.setCharacterEncoding("utf-8");
			
			String m_id = request.getParameter("_6id");
			String m_pass1 = request.getParameter("_6pass1");
			String m_pass2 = request.getParameter("_6pass2");
			String m_pass3 = request.getParameter("_6pass3");
			String m_name = request.getParameter("_6name");
			String m_nick = request.getParameter("_6nick");
			String m_email = request.getParameter("_6email");
			String m_phone = request.getParameter("_6phone");
			
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setM_id(m_id);
			memberDTO.setM_pass(m_pass1);
			memberDTO.setM_pass(m_pass2);
			memberDTO.setM_pass(m_pass3);
			memberDTO.setM_name(m_name);
			memberDTO.setM_nick(m_nick);
			memberDTO.setM_email(m_email);
			memberDTO.setM_phone(m_phone);
			
			memberDAO = new MemberDAO();
			memberDAO.updateMember(memberDTO);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	
	
	
	
	public void deleteMember(HttpServletRequest request) {
		System.out.println("MemberService deleteMember()");

		
		try {
			
			String m_id = request.getParameter("_6id");
			String m_pass = request.getParameter("_6pass");
	
			
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setM_id(m_id);
			memberDTO.setM_pass(m_pass);
			
			memberDAO = new MemberDAO();
			memberDAO.deleteMember(memberDTO);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	
	
//	멤버리스트
	public List<MemberDTO> getMemberList() {
		System.out.println("MemberService getMemberList()");

		List<MemberDTO> memberList = null;
		
		try {
			
			memberDAO = new MemberDAO();
			memberList = memberDAO.getMemberList();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberList;
	}
	

	
	
	

	
	
	
	
	
	
	
	
	
	
	
}
