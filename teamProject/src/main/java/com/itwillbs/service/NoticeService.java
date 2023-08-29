package com.itwillbs.service;

import java.util.List;

import com.itwillbs.dao.NoticeDAO;
import com.itwillbs.domain.NoticeDTO;
import com.itwillbs.domain.NoticePageDTO;

public class NoticeService {
	NoticeDAO noticeDAO = null;
	public List<NoticeDTO> getNoticeList(NoticePageDTO pageDTO){
		System.out.println("NoticeService getNoticeList()");
		List<NoticeDTO> noticeList = null;
		try {
			// 시작하는 행부터 10개 뽑아오기
			int startRow = (pageDTO.getCurrentPage()-1)*pageDTO.getPageSize()+1;
			// 시작하는 행부터 끝나는 행까지 뽑아오기
			int endRow = startRow+pageDTO.getPageSize()-1;
			
			//pageDTO 저장 <= startRow, endRow
			pageDTO.setStartRow(startRow);
			pageDTO.setEndRow(endRow);
			
			// NoticeDAO 객체생성
			NoticeDAO noticeDAO = new NoticeDAO();
			// noticeList = getnoticeList() 메서드 호출
			noticeList = noticeDAO.getNoticeList(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}return noticeList;
	}//getNoticeList
	
	
	
	
	
	
	
}//class