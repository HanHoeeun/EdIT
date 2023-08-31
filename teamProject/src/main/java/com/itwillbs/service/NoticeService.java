package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.itwillbs.dao.NoticeDAO;
import com.itwillbs.domain.NoticeDTO;
import com.itwillbs.domain.NoticePageDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
			noticeDAO = new NoticeDAO();
			// noticeList = getnoticeList() 메서드 호출
			noticeList = noticeDAO.getNoticeList(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}return noticeList;
	}//getNoticeList
	
	public void insertNotice(HttpServletRequest request) {
		try {
			System.out.println("NoticeService insertNotice()");
			// request 한글처리
			request.setCharacterEncoding("utf-8");
			// request 파라미터 값 가져오기
			int a_notice_type = Integer.parseInt(request.getParameter("a_notice_type"));
			String a_title = request.getParameter("a_title");
			String a_content = request.getParameter("a_content");
			System.out.println(a_notice_type);
			// NoticeDAO 객체생성
			noticeDAO = new NoticeDAO();
			// NoticeDTO 객체생성
			NoticeDTO noticeDTO = new NoticeDTO();
			// set메서드 호출 파라미터값 저장
			
			noticeDTO.setA_notice_type(a_notice_type);
			noticeDTO.setA_title(a_title);
			noticeDTO.setA_content(a_content);
			
			// 리턴할형없음 insertNotice(noticeDTO) 호출
			noticeDAO.insertNotice(noticeDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//insertNotice()
	
	public NoticeDTO getNotice(HttpServletRequest request) {
		System.out.println("NoticeService getNotice()");
		NoticeDTO noticeDTO = null;
		try {
			// request 한글처리
			request.setCharacterEncoding("utf-8");
			// request 파라미터 가져오기 => int num 저장
			int a_num = Integer.parseInt(request.getParameter("a_num"));
			// NoticeDAO 객체생성
			noticeDAO = new NoticeDAO();
			// noticeDTO = getNotice(a_num) 메서드 호출
			noticeDTO = noticeDAO.getNotice(a_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeDTO;
	}//getNotice()

	public int getNoticeCount() {
		System.out.println("NoticeService getNoticeCount()");
		int count=0;
		try {
			// NoticeDAO 객체생성
			noticeDAO = new NoticeDAO();
			// count = getNoticeCount() 호출
			count = noticeDAO.getNoticeCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}//getNoticeCount()

	public void updateNotice(HttpServletRequest request) {
		System.out.println("NoticeService updateNotice()");
		try {
			// 한글처리
			request.setCharacterEncoding("utf-8");
			// num title content 파라미터 값 가져오기
			int a_num = Integer.parseInt(request.getParameter("a_num"));
			String a_title = request.getParameter("a_title");
			String a_content = request.getParameter("a_content");
			// NoticeDTO 객체생성
			NoticeDTO noticeDTO = new NoticeDTO();
			// set메서드 호출 파라미터값 저장
			noticeDTO.setA_num(a_num);
			noticeDTO.setA_title(a_title);
			noticeDTO.setA_content(a_content);
			// DAO 객체생성
			noticeDAO = new NoticeDAO();
			// updateNotice(noticeDTO) 메서드호출
			noticeDAO.updateNotice(noticeDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//updateNotice()

	public void deleteNotice(HttpServletRequest request) {
		System.out.println("NoticeService deleteNotice()");
		try {
			// 한글처리
			request.setCharacterEncoding("utf-8");
			// NoticeService => int a_num = request 파라미터값 가져오기
			int a_num = Integer.parseInt(request.getParameter("a_num"));
			// NoticeDAO 객체생성 
			noticeDAO = new NoticeDAO();
			// deleteNotice(a_num)호출
			noticeDAO.deleteNotice(a_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//deleteNotice()
	
	// 첨부파일
//	public void finsertNotice(HttpServletRequest request) {
//		System.out.println("NoticeService finsertNotice()");
//		try {
//			//업로드 폴더 만들기 webapp - upload 폴더만들기
//			// 업로드 폴더 경로=> 물리적 경로
//			String uploadPath=request.getRealPath("/upload");
//			// 이클립스에 실행하면 이클립스 가상경로 
//			System.out.println(uploadPath);
//			//파일 최대크기 지정  10M
//			int maxSize=10*1024*1024; 
//			// 파일 업로드 했을때 폴더내 파일이름 동일하면 파일이름 변경하는 프로그램
////			import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
//			// new DefaultFileRenamePolicy()
//			MultipartRequest multi 
//			= new MultipartRequest(request, uploadPath, maxSize,"utf-8", new DefaultFileRenamePolicy()); 
//			
//			// multi 파라미터 값 가져오기
//			String name = multi.getParameter("name");
//			String subject = multi.getParameter("subject");
//			String content = multi.getParameter("content");
//			//첨부파일이름 가져오기
//			String file = multi.getFilesystemName("file");
//			
//			// num, date => 변수저장
//			Timestamp date = new Timestamp(System.currentTimeMillis());
//			// NoticeDAO 객체생성
//			noticeDAO = new NoticeDAO();
//			int num = noticeDAO.getMaxNum() + 1;
//			
//			// NoticeDTO 객체생성
//			NoticeDTO noticeDTO = new NoticeDTO();
//			// set메서드 호출 파라미터값 저장
//			noticeDTO.setNum(num);
//			noticeDTO.setSubject(subject);
//			noticeDTO.setContent(content);
//			noticeDTO.setDate(date);
//			//첨부파일
//			noticeDTO.setFile(file);
//			
//			// 리턴할형없음 insertNotice(noticeDTO) 호출
//			noticeDAO.insertNotice(noticeDTO);			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}//finsertNotice
	
//	public void updateNotice(HttpServletRequest request) {
//		System.out.println("NoticeService updateNotice()");
//		try {
//			// 한글처리
//			request.setCharacterEncoding("utf-8");
//			// num name subject content 파라미터 값 가져오기
//			int num = Integer.parseInt(request.getParameter("a_num"));
//			String a_title = request.getParameter("subject");
//			String a_content = request.getParameter("a_content");
//			// NoticeDTO 객체생성
//			NoticeDTO noticeDTO = new NoticeDTO();
//			// 내용 시간 분류 파일명 제목
//			// set메서드 호출 파라미터값 저장
//			noticeDTO.setA_content(a_content);;
//			noticeDTO.setA_notice_type();
//			noticeDTO.);
//			// NoticeDAO 객체생성
//			noticeDAO = new NoticeDAO();
//			// updateNotice(boardDTO) 메서드호출
//			noticeDAO.updateNotice(noticeDTO);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}//updateNotice()
	
	
	
}//class