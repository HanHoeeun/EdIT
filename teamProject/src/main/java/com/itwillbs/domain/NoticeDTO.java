package com.itwillbs.domain;

import java.security.Timestamp;

public class NoticeDTO {
	private int a_num; //게시물 번호
	private int a_m_num; //회원 번호
	private String a_m_nick; //닉네임
	private String a_title; //제목
	private String a_content; //내용
	private Timestamp a_date; //작성일
	private String a_notice_type; //1유형 2일반공지 3이벤트 
	
	private String a_file; //파일명

	// get, set
	public int getA_num() {
		return a_num;
	}

	public void setA_num(int a_num) {
		this.a_num = a_num;
	}

	public int getA_m_num() {
		return a_m_num;
	}

	public void setA_m_num(int a_m_num) {
		this.a_m_num = a_m_num;
	}

	public String getA_m_nick() {
		return a_m_nick;
	}

	public void setA_m_nick(String a_m_nick) {
		this.a_m_nick = a_m_nick;
	}

	public String getA_title() {
		return a_title;
	}

	public void setA_title(String a_title) {
		this.a_title = a_title;
	}

	public String getA_content() {
		return a_content;
	}

	public void setA_content(String a_content) {
		this.a_content = a_content;
	}

	public Timestamp getA_date() {
		return a_date;
	}

	public void setA_date(Timestamp a_date) {
		this.a_date = a_date;
	}

	public String getA_notice_type() {
		return a_notice_type;
	}

	public void setA_notice_type(String a_notice_type) {
		this.a_notice_type = a_notice_type;
	}

	public String getA_file() {
		return a_file;
	}

	public void setA_file(String a_file) {
		this.a_file = a_file;
	}
	
}//class
	
	