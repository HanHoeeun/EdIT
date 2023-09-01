package com.itwillbs.domain;

import java.sql.Timestamp;

public class MemberDTO {

	
//	member members
	private int m_num;
	private String m_id;
	private String m_pass;
	private String m_name;
	private String m_nick;
	private String m_phone;
	private String m_email;
	private Timestamp m_date;
	private String m_event;
	private int m_level;
	private int m_count;
	
	
//	member blacklist			
	private String bl_m_id;
	private String bl_m_email;
	private String bl_reason;
	
	
	
	
//	alt + shift + s -> shift + s 
	@Override
	public String toString() {
		return "MemberDTO [m_num=" + m_num + ", m_id=" + m_id + ", m_pass=" + m_pass + ", m_name=" + m_name
				+ ", m_nick=" + m_nick + ", m_phone=" + m_phone + ", m_email=" + m_email + ", m_date=" + m_date
				+ ", m_event=" + m_event + ", m_level=" + m_level + ", m_count=" + m_count + ", bl_m_id=" + bl_m_id
				+ ", bl_m_email=" + bl_m_email + ", bl_reason=" + bl_reason + "]";
	}
	
	
//	get(), set()
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pass() {
		return m_pass;
	}
	public void setM_pass(String m_pass) {
		this.m_pass = m_pass;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public Timestamp getM_date() {
		return m_date;
	}
	public void setM_date(Timestamp m_date) {
		this.m_date = m_date;
	}
	public String getM_event() {
		return m_event;
	}
	public void setM_event(String m_event) {
		this.m_event = m_event;
	}
	public int getM_level() {
		return m_level;
	}
	public void setM_level(int m_level) {
		this.m_level = m_level;
	}
	public int getM_count() {
		return m_count;
	}
	public void setM_count(int m_count) {
		this.m_count = m_count;
	}


	public String getBl_m_id() {
		return bl_m_id;
	}
	public void setBl_m_id(String bl_m_id) {
		this.bl_m_id = bl_m_id;
	}
	public String getBl_m_email() {
		return bl_m_email;
	}
	public void setBl_m_email(String bl_m_email) {
		this.bl_m_email = bl_m_email;
	}
	public String getBl_reason() {
		return bl_reason;
	}
	public void setBl_reason(String bl_reason) {
		this.bl_reason = bl_reason;
	}
//	request.getParameter -> string 받아서 timestamp로 변환
	public void setM_date(String timestampString) {
	    long timestamp = Long.parseLong(timestampString);
	    this.m_date = new Timestamp(timestamp);
	}

	
	
	
	
	
	
	
	
	
}