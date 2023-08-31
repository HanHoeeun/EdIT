package com.itwillbs.domain;

import java.sql.Timestamp;


public class AdminDTO {
	private int a_num; // 게시물 번호
	private String a_m_nick; //작성자
	private String a_title; // 제목
	private String a_content; // 내용
	private Timestamp a_date; //작성시간
	private int a_cs_type; // 1 계정, 2 중고거래, 3|0 기타 
	
	private String a_file; // 파일명
	
	private String a_answer; // 답변
	
	public String getA_answer() {
		return a_answer;
	}
	public void setA_answer(String a_answer) {
		this.a_answer = a_answer;
	}
	public String getA_file() {
		return a_file;
	}
	public void setA_file(String a_file) {
		this.a_file = a_file;
	}
	public int getA_num() {
		return a_num;
	}
	public String getA_m_nick() {
		return a_m_nick;
	}
	public String getA_title() {
		return a_title;
	}
	public String getA_content() {
		return a_content;
	}
	public Timestamp getA_date() {
		return a_date;
	}
	public int getA_cs_type() {
		return a_cs_type;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	public void setA_m_nick(String a_m_nick) {
		this.a_m_nick = a_m_nick;
	}
	public void setA_title(String a_title) {
		this.a_title = a_title;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public void setA_date(Timestamp a_date) {
		this.a_date = a_date;
	}
	public void setA_cs_type(int a_cs_type) {
		this.a_cs_type = a_cs_type;
	}
}

