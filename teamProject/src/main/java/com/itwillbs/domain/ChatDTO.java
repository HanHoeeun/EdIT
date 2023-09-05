package com.itwillbs.domain;

public class ChatDTO {
	private int ch_num;
	private String ch_fromID;
	private String ch_toID;
	private String ch_content;
	private String ch_date;

	public int getCh_num() {
		return ch_num;
	}

	public String getCh_fromID() {
		return ch_fromID;
	}

	public String getCh_toID() {
		return ch_toID;
	}

	public String getCh_content() {
		return ch_content;
	}

	public String getCh_date() {
		return ch_date;
	}

	public void setCh_num(int ch_num) {
		this.ch_num = ch_num;
	}

	public void setCh_fromID(String ch_fromID) {
		this.ch_fromID = ch_fromID;
	}

	public void setCh_toID(String ch_toID) {
		this.ch_toID = ch_toID;
	}

	public void setCh_content(String ch_content) {
		this.ch_content = ch_content;
	}

	public void setCh_date(String ch_date) {
		this.ch_date = ch_date;
	}

}
