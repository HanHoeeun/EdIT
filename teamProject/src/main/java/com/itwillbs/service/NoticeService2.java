package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.itwillbs.dao.NoticeDAO2;
import com.itwillbs.domain.NoticeDTO;
import com.itwillbs.domain.NoticePageDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NoticeService2 {
	NoticeDAO2 noticeDAO = null;
	
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
			
			System.out.println("startRow"+startRow);
			
			// NoticeDAO 객체생성
			noticeDAO = new NoticeDAO2();
			// noticeList = getnoticeList() 메서드 호출
			noticeList = noticeDAO.getNoticeList(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}return noticeList;
	}//getNoticeList
	
	public void insertNotice(HttpServletRequest request) {
		System.out.println("NoticeService insertNotice()");
		try {
			// request 한글처리
			request.setCharacterEncoding("utf-8");
			// 업로드 폴더 경로=> 물리적 경로
			String uploadPath=request.getRealPath("/upload");
			// 이클립스에 실행하면 이클립스 가상경로 
			System.out.println(uploadPath);
			//파일 최대크기 지정  10M
			int maxSize=10*1024*1024; 
			// 파일 업로드 했을때 폴더내 파일이름 동일하면 파일이름 변경하는 프로그램
			// import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
			// new DefaultFileRenamePolicy()
			MultipartRequest multi 
			= new MultipartRequest(request, uploadPath, maxSize,"utf-8", new DefaultFileRenamePolicy()); 

			// multi 파라미터 값 가져오기
			String a_title = multi.getParameter("a_title");
			String a_content = multi.getParameter("a_content");
			//첨부파일이름 가져오기
			String a_file = multi.getFilesystemName("a_file");
		
			// request 파라미터 값 가져오기
			int a_notice_type = Integer.parseInt(multi.getParameter("a_notice_type"));
			System.out.println("a_notice_type"+a_notice_type);
			
			// a_date 변수저장
			Timestamp a_date = new Timestamp(System.currentTimeMillis());
			
			// NoticeDAO 객체생성
			noticeDAO = new NoticeDAO2();
			// NoticeDTO 객체생성
			NoticeDTO noticeDTO = new NoticeDTO();
			// set메서드 호출 파라미터값 저장
			noticeDTO.setA_notice_type(a_notice_type);
			noticeDTO.setA_title(a_title);
			noticeDTO.setA_content(a_content);
			noticeDTO.setA_date(a_date);
			// 첨부파일
			noticeDTO.setA_file(a_file);
			
			// 리턴할형없음 insertNotice(noticeDTO) 호출
			noticeDAO.insertNotice(noticeDTO);
			
//			===================== 글 유형에 따라 일반공지, 이벤트로 넘어가게 =================
			if(a_notice_type==1){
				// 리턴할형없음 insertNotice(noticeDTO) 호출
				noticeDAO.insertNotice(noticeDTO);
			}else {
				noticeDAO.insertEvent(noticeDTO);
			}
	
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
			noticeDAO = new NoticeDAO2();
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
			noticeDAO = new NoticeDAO2();
			// count = getNoticeCount() 호출
			count = noticeDAO.getNoticeCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}//getNoticeCount()
//================================== 수정 =======================================
	public void updateNotice(HttpServletRequest request) {
		System.out.println("NoticeService updateNotice()");
		try {
			// 한글처리
			request.setCharacterEncoding("utf-8");
			//업로드 파일경로(upload폴더)
			String uploadPath=request.getRealPath("/upload");
			int maxSize=10*1024*1024;
			MultipartRequest multi 
			= new MultipartRequest(request, uploadPath,maxSize,"utf-8",
					new DefaultFileRenamePolicy());
			// num title content file a_oldfile 파라미터 값 가져오기
			int a_num = Integer.parseInt(multi.getParameter("a_num"));
			String a_title =multi.getParameter("a_title");
			String a_content = multi.getParameter("a_content");
			//file a_oldfile
			String a_file = multi.getFilesystemName("a_file");
			//첨부파일 없는 경우
			if(a_file == null) {
				//기존 파일이름 가져오기
				a_file = multi.getParameter("a_oldfile");
			}
			// NoticeDTO 객체생성
			NoticeDTO noticeDTO = new NoticeDTO();
			// set메서드 호출 파라미터값 저장
			noticeDTO.setA_num(a_num);
			noticeDTO.setA_title(a_title);
			noticeDTO.setA_content(a_content);
			// 파일
			noticeDTO.setA_file(a_file);
			// DAO 객체생성
			noticeDAO = new NoticeDAO2();
			// updateNotice(noticeDTO) 메서드호출
			noticeDAO.updateNotice(noticeDTO);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//updateNotice()
//==================================== 삭제 ==================================
	public void deleteNotice(HttpServletRequest request) {
		System.out.println("NoticeService deleteNotice()");
		try {
			// 한글처리
			request.setCharacterEncoding("utf-8");
			// NoticeService => int a_num = request 파라미터값 가져오기
			int a_num = Integer.parseInt(request.getParameter("a_num"));
			// NoticeDAO 객체생성 
			noticeDAO = new NoticeDAO2();
			// deleteNotice(a_num)호출
			noticeDAO.deleteNotice(a_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//deleteNotice()

//=======================================================================================================	
//=============================================== 이벤트 ===========================================================
	public List<NoticeDTO> getEventList(NoticePageDTO pageDTO2) {
		System.out.println("NoticeService getEventList()");
		List<NoticeDTO> eventList = null;
		try {
			// 시작하는 행부터 10개 뽑아오기
			int startRow = (pageDTO2.getCurrentPage()-1)*pageDTO2.getPageSize()+1;
			// 시작하는 행부터 끝나는 행까지 뽑아오기
			int endRow = startRow+pageDTO2.getPageSize()-1;
			
			//pageDTO2 저장 <= startRow, endRow
			pageDTO2.setStartRow(startRow);
			pageDTO2.setEndRow(endRow);
			
			System.out.println("startRow"+startRow);
			
			// NoticeDAO 객체생성
			noticeDAO = new NoticeDAO2();
			// eventList = getEventList() 메서드 호출
			eventList = noticeDAO.getEventList(pageDTO2);
		}catch (Exception e) {
			e.printStackTrace();
		}return eventList;
	}//getEventList

	public int getEventCount() {
		System.out.println("NoticeService getEventCount()");
		int count=0;
		try {
			// NoticeDAO 객체생성
			noticeDAO = new NoticeDAO2();
			// count = getNoticeCount() 호출
			count = noticeDAO.getEventCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}//getEventCount()

	public void insertEvent(HttpServletRequest request) {
		System.out.println("NoticeService insertEvent()");
		try {
			// request 한글처리
			request.setCharacterEncoding("utf-8");
			// 업로드 폴더 경로=> 물리적 경로
			String uploadPath=request.getRealPath("/upload");
			// 이클립스에 실행하면 이클립스 가상경로 
			System.out.println(uploadPath);
			//파일 최대크기 지정  10M
			int maxSize=10*1024*1024; 
			// 파일 업로드 했을때 폴더내 파일이름 동일하면 파일이름 변경하는 프로그램
			// import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
			// new DefaultFileRenamePolicy()
			MultipartRequest multi 
			= new MultipartRequest(request, uploadPath, maxSize,"utf-8", new DefaultFileRenamePolicy()); 

			// multi 파라미터 값 가져오기
			String a_title = multi.getParameter("a_title");
			String a_content = multi.getParameter("a_content");
			//첨부파일이름 가져오기
			String a_file = multi.getFilesystemName("a_file");
		
			// request 파라미터 값 가져오기
			int a_notice_type = Integer.parseInt(multi.getParameter("a_notice_type"));
			System.out.println("a_notice_type"+a_notice_type);
			
			// a_date 변수저장
			Timestamp a_date = new Timestamp(System.currentTimeMillis());
			
			// NoticeDAO 객체생성
			noticeDAO = new NoticeDAO2();
			// NoticeDTO 객체생성
			NoticeDTO eventDTO = new NoticeDTO();
			// set메서드 호출 파라미터값 저장
			eventDTO.setA_notice_type(a_notice_type);
			eventDTO.setA_title(a_title);
			eventDTO.setA_content(a_content);
			eventDTO.setA_date(a_date);
			// 첨부파일
			eventDTO.setA_file(a_file);
			
			// 리턴할형없음 insertNotice(noticeDTO) 호출
			noticeDAO.insertEvent(eventDTO);
			
//			===================== 글 유형에 따라 일반공지, 이벤트로 넘어가게 =================
			if(a_notice_type==1){
				// 리턴할형없음 insertNotice(noticeDTO) 호출
				noticeDAO.insertNotice(eventDTO);
			}else {
				noticeDAO.insertEvent(eventDTO);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//insertEvent()

	public NoticeDTO getEvent(HttpServletRequest request) {
		System.out.println("NoticeService getEvent()");
		NoticeDTO eventDTO = null;
		try {
			// request 한글처리
			request.setCharacterEncoding("utf-8");
			// request 파라미터 가져오기 => int num 저장
			int a_num = Integer.parseInt(request.getParameter("a_num"));
			// NoticeDAO 객체생성
			noticeDAO = new NoticeDAO2();
			// noticeDTO = getNotice(a_num) 메서드 호출
			eventDTO = noticeDAO.getEvent(a_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eventDTO;
	}//getEvent()

	public void updateEvent(HttpServletRequest request) {
		System.out.println("NoticeService updateEvent()");
		try {
			// 한글처리
			request.setCharacterEncoding("utf-8");
			//업로드 파일경로(upload폴더)
			String uploadPath=request.getRealPath("/upload");
			int maxSize=10*1024*1024;
			MultipartRequest multi 
			= new MultipartRequest(request, uploadPath,maxSize,"utf-8",
					new DefaultFileRenamePolicy());
			// num title content file a_oldfile 파라미터 값 가져오기
			int a_num = Integer.parseInt(multi.getParameter("a_num"));
			String a_title =multi.getParameter("a_title");
			String a_content = multi.getParameter("a_content");
			//file a_oldfile
			String a_file = multi.getFilesystemName("a_file");
			//첨부파일 없는 경우
			if(a_file == null) {
				//기존 파일이름 가져오기
				a_file = multi.getParameter("a_oldfile");
			}
			// NoticeDTO 객체생성
			NoticeDTO eventDTO = new NoticeDTO();
			// set메서드 호출 파라미터값 저장
			eventDTO.setA_num(a_num);
			eventDTO.setA_title(a_title);
			eventDTO.setA_content(a_content);
			// 파일
			eventDTO.setA_file(a_file);
			// DAO 객체생성
			noticeDAO = new NoticeDAO2();
			// updateNotice(noticeDTO) 메서드호출
			noticeDAO.updateNotice(eventDTO);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//updateEvent()

	public void deleteEvent(HttpServletRequest request) {
		System.out.println("NoticeService deleteEvent()");
		try {
			// 한글처리
			request.setCharacterEncoding("utf-8");
			// NoticeService => int a_num = request 파라미터값 가져오기
			int a_num = Integer.parseInt(request.getParameter("a_num"));
			// NoticeDAO 객체생성 
			noticeDAO = new NoticeDAO2();
			// deleteNotice(a_num)호출
			noticeDAO.deleteEvent(a_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//deleteEvent()
		
	
	
	

	
	
	
}//class