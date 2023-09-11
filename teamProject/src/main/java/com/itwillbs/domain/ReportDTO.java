package com.itwillbs.domain;

import java.sql.Timestamp;

public class ReportDTO {
	private int r_num;
	private int r_m_num;
	private int r_m_target;
	private String r_m_num_nick;
	private String r_m_target_nick;
	private String r_m_num_id;
	private String r_m_target_id;
	private String r_title;
	private String r_content;
	private Timestamp r_date;
	private String r_file;
	private String r_answer;
	private int r_check;  // 0 확인x 1 확인 o
	private String bl_reason;
	
	
	
	public String getR_m_num_id() {
		return r_m_num_id;
	}
	public String getR_m_target_id() {
		return r_m_target_id;
	}
	public void setR_m_num_id(String r_m_num_id) {
		this.r_m_num_id = r_m_num_id;
	}
	public void setR_m_target_id(String r_m_target_id) {
		this.r_m_target_id = r_m_target_id;
	}
	public int getR_num() {
		return r_num;
	}
	public int getR_m_num() {
		return r_m_num;
	}
	public int getR_m_target() {
		return r_m_target;
	}
	public String getR_m_num_nick() {
		return r_m_num_nick;
	}
	public String getR_m_target_nick() {
		return r_m_target_nick;
	}
	public String getR_title() {
		return r_title;
	}
	public String getR_content() {
		return r_content;
	}
	public Timestamp getR_date() {
		return r_date;
	}
	public String getR_file() {
		return r_file;
	}
	public String getR_answer() {
		return r_answer;
	}
	public int getR_check() {
		return r_check;
	}
	public String getBl_reason() {
		return bl_reason;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public void setR_m_num(int r_m_num) {
		this.r_m_num = r_m_num;
	}
	public void setR_m_target(int r_m_target) {
		this.r_m_target = r_m_target;
	}
	public void setR_m_num_nick(String r_m_num_nick) {
		this.r_m_num_nick = r_m_num_nick;
	}
	public void setR_m_target_nick(String r_m_target_nick) {
		this.r_m_target_nick = r_m_target_nick;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public void setR_date(Timestamp r_date) {
		this.r_date = r_date;
	}
	public void setR_file(String r_file) {
		this.r_file = r_file;
	}
	public void setR_answer(String r_answer) {
		this.r_answer = r_answer;
	}
	public void setR_check(int r_check) {
		this.r_check = r_check;
	}
	public void setBl_reason(String bl_reason) {
		this.bl_reason = bl_reason;
	}

	
	

}
