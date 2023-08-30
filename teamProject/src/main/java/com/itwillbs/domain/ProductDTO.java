package com.itwillbs.domain;

import java.sql.Timestamp;

public class ProductDTO {
	private int p_num;
	private String p_title;
	private String p_m_id;
	private String p_type;
	private int p_price;
	private String p_detail;
	private Timestamp p_date;
	private int p_readcount;
	private String p_status;
	private String p_file;
	
	
	@Override
	public String toString() {
		return "ProductDTO [p_num=" + p_num + ", p_title= "+ p_title + ",p_m_id=" + p_m_id +
							", p_type= "+ p_type + ", p_price= " + p_price + ", p_detail=" + p_detail +
							", p_date= " + p_date + ", p_readcount= "+ p_readcount +
							",p_status=" +p_status +",p_file="+ p_file+ "]";
	}
	// getter & setter 
	public String getP_file() {
		return p_file;
	}
	public void setP_file(String p_file) {
		this.p_file = p_file;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public String getP_title() {
		return p_title;
	}
	public void setP_title(String p_title) {
		this.p_title = p_title;
	}
	public String getP_m_id() {
		return p_m_id;
	}
	public void setP_m_id(String p_m_id) {
		this.p_m_id = p_m_id;
	}
	public String getP_type() {
		return p_type;
	}
	public void setP_type(String p_type) {
		this.p_type = p_type;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public String getP_detail() {
		return p_detail;
	}
	public void setP_detail(String p_detail) {
		this.p_detail = p_detail;
	}
	public Timestamp getP_date() {
		return p_date;
	}
	public void setP_date(Timestamp p_date) {
		this.p_date = p_date;
	}
	public int getP_readcount() {
		return p_readcount;
	}
	public void setP_readcount(int p_readcount) {
		this.p_readcount = p_readcount;
	}
	public String getP_status() {
		return p_status;
	}
	public void setP_status(String p_status) {
		this.p_status = p_status;
	}
	
	
	
}
