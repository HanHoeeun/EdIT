package com.itwillbs.domain;

public class AdminPageDTO {
	private int pageSize;	//표현할 게시물 수
	private String pageNum;	//현재페이지
	private int currentPage;//현재페이지
	private int startRow;	//시작하는 게시물
	private int endRow;		//끝나는 게시물
	
	private int count;
	private int startPage;	//시작하는 페이지
	private int endPage;	//끝나는 페이지
	private int pageBlock;  //페이지 크기
	private int pageCount;	//페이지 갯수
	private String m_id;
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	private String search; //검색어 저장
	private int search_type; // 회원 검색 타입 0 전체 1 회원번호 2 아이디 3 닉네임 4 신고횟수
	
	public int getSearch_type() {
		return search_type;
	}
	public void setSearch_type(int search_type) {
		this.search_type = search_type;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getPageSize() {
		return pageSize;
	}
	public String getPageNum() {
		return pageNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
}
