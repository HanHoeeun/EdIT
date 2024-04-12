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
	NoticeDAO eventDAO = null;

// ==================================== getNoticeList ======================================		
	public List<NoticeDTO> getNoticeList(NoticePageDTO pageDTO) {
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
			// noticeList = getNoticeList() 메서드 호출
			noticeList = noticeDAO.getNoticeList(pageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeList;
	}//getNoticeList

//===================================== getNoticeCount ===========================================		
	public int getNoticeCount() {
		System.out.println("NoticeService getNoticeCount()");
		int count = 0;
		try {
			// NoticeDAO 객체생성
			noticeDAO = new NoticeDAO();
			// a_count = getNoticeCount() 호출
			count = noticeDAO.getNoticeCount();
		} catch (Exception e) {
			e.printStackTrace();
		}return count;
	}//getNoticeCount

//===================================== insertNotice =======================================	
	public String insertNotice(HttpServletRequest request, String m_id) {
		System.out.println("NoticeService insertNotice()");
		String a_notice_type = "";
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
			a_notice_type = (multi.getParameter("a_notice_type"));
			System.out.println("a_notice_type"+a_notice_type);
			// a_date 변수저장
			Timestamp a_date = new Timestamp(System.currentTimeMillis());

			// NoticeDAO 객체생성
			noticeDAO = new NoticeDAO();
			// NoticeDTO 객체생성
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setA_m_id(m_id);
			// set메서드 호출 파라미터값 저장
			noticeDTO.setA_notice_type(a_notice_type);
			noticeDTO.setA_title(a_title);
			noticeDTO.setA_content(a_content);
			noticeDTO.setA_date(a_date);
			// 첨부파일
			noticeDTO.setA_file(a_file);

			// 글 유형에 따라 일반공지, 이벤트로 넘어가게
			if(a_notice_type=="공지" || a_notice_type.equals("공지")){
				// 리턴할형없음 insertNotice(noticeDTO) 호출
				System.out.println("----------------------------------------------------------");
				noticeDAO.insertNotice(noticeDTO);
			}else {
				noticeDAO.insertEvent(noticeDTO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}return a_notice_type;
	}//insertNotice

//======================================= getNotice =============================================	
	public NoticeDTO getNotice(HttpServletRequest request) {
		System.out.println("NoticeService getNotice()");
		NoticeDTO noticeDTO = null;
		try {
			request.setCharacterEncoding("utf-8");
			// request 파라미터 가져오기 => int a_num 저장
			int a_num = Integer.parseInt(request.getParameter("a_num"));
			// NoticeDAO 객체생성
			noticeDAO = new NoticeDAO();
			// noticeDTO = getNotice(a_num) 메서드 호출
			noticeDTO = noticeDAO.getNotice(a_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeDTO;
	}//getNotice

//======================================= updateNotice =============================================	
	public String updateNotice(HttpServletRequest request) {
		System.out.println("NoticeService updateNotice()");
		String a_notice_type = "";
		try {
			request.setCharacterEncoding("utf-8");
			//업로드 파일경로(upload폴더)
			String uploadPath=request.getRealPath("/upload");
			int maxSize=10*1024*1024;
			MultipartRequest multi 
			= new MultipartRequest(request, uploadPath,maxSize,"utf-8",
					new DefaultFileRenamePolicy());
			
			// a_num, a_title, a_content, a_file, a_oldfile 파라미터 값 가져오기
			int a_num = Integer.parseInt(multi.getParameter("a_num"));
			String a_title =multi.getParameter("a_title");
			String a_content = multi.getParameter("a_content");
			a_notice_type = (multi.getParameter("a_notice_type"));
			//a_file, a_oldfile
			String a_file = multi.getFilesystemName("a_file");
			//첨부파일 없는 경우
			if(a_file == null) {
				//기존 파일이름 가져오기
				a_file = multi.getParameter("a_oldfile");
			}
			
			// NoticeDTO 객체생성
			NoticeDTO noticeDTO = new NoticeDTO();
			// set메서드 호출 파라미터값 저장
			noticeDTO.setA_notice_type(a_notice_type);
			noticeDTO.setA_num(a_num);
			noticeDTO.setA_title(a_title);
			noticeDTO.setA_content(a_content);
			// 파일
			noticeDTO.setA_file(a_file);
			
			System.out.println(noticeDTO+"updateNotice");
			// NoticeDAO 객체생성
			noticeDAO = new NoticeDAO();
			// updateNotice(noticeDTO) 메서드호출
//			noticeDAO.updateNotice(noticeDTO);		
			// 글 유형에 따라 일반공지, 이벤트로 넘어가게
			if(a_notice_type.equals("공지")){
				// 리턴할형없음 insertNotice(noticeDTO) 호출
				System.out.println("공지수정");
				noticeDAO.updateNotice(noticeDTO);
			}else {
				System.out.println("이벤트수정");
				noticeDAO.updateEvent(noticeDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}return a_notice_type;
	}//updateNotice

//======================================= deleteNotice ================================================
	public void deleteNotice(HttpServletRequest request) {
		System.out.println("NoticeService deleteNotice()");
		try {
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
	}//deleteNotice

//===================================== getNoticeListSearch ===========================================
	public List<NoticeDTO> getNoticeListSearch(NoticePageDTO pageDTO) {
		System.out.println("NoticeSearvice getNoticeListSearch()");
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
			// noticeList = getNoticeList() 메서드 호출
			noticeList = noticeDAO.getNoticeListSearch(pageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeList;
	}//getNoticeListSearch
	
//===================================== getNoticeCountSearch ===========================================		
		public int getNoticeCountSearch(NoticePageDTO pageDTO) {
			System.out.println("NoticeService getNoticeCountSearch()");
			int count = 0;
			try {
				// NoticeDAO 객체생성
				noticeDAO = new NoticeDAO();
				// a_count = getNoticeCount() 호출
				count = noticeDAO.getNoticeCountSearch(pageDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}return count;
		}//getNoticeCountSearch


//******************************************************************************************
//******************************************************************************************
//===================================== getEventList =====================================		
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

			// NoticeDAO 객체생성
			eventDAO = new NoticeDAO();
			// eventList = getEventList() 메서드 호출
			eventList = eventDAO.getEventList(pageDTO2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eventList;
	}//getEventList

//===================================== getEventCount ===========================================		
	public int getEventCount() {
		System.out.println("NoticeService getEventCount()");
		int count = 0;
		try {
			// NoticeDAO 객체생성
			eventDAO = new NoticeDAO();
			// a_count = getEventCount() 호출
			count = eventDAO.getEventCount();
		} catch (Exception e) {
			e.printStackTrace();
		}return count;
	}//getEventCount

//===================================== insertEvent =======================================	
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
			String a_notice_type = (multi.getParameter("a_notice_type"));
			System.out.println("a_notice_type"+a_notice_type);
			// a_date 변수저장
			Timestamp a_date = new Timestamp(System.currentTimeMillis());

			// NoticeDAO 객체생성
			eventDAO = new NoticeDAO();
			// NoticeDTO 객체생성
			NoticeDTO noticeDTO = new NoticeDTO();
			// set메서드 호출 파라미터값 저장
			noticeDTO.setA_notice_type(a_notice_type);
			noticeDTO.setA_title(a_title);
			noticeDTO.setA_content(a_content);
			noticeDTO.setA_date(a_date);
			// 첨부파일
			noticeDTO.setA_file(a_file);
			
			// 글 유형에 따라 일반공지, 이벤트로 넘어가게
			if(a_notice_type=="공지"){
				// 리턴할형없음 insertNotice(noticeDTO) 호출
				noticeDAO.insertNotice(noticeDTO);
			}else {
				eventDAO.insertEvent(noticeDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//insertEvent

//======================================= getEvent =============================================	
	public NoticeDTO getEvent(HttpServletRequest request) {
		System.out.println("NoticeService getEvent()");
		NoticeDTO noticeDTO = null;
		try {
			request.setCharacterEncoding("utf-8");
			// request 파라미터 가져오기 => int a_num 저장
			int a_num = Integer.parseInt(request.getParameter("a_num"));
			// NoticeDAO 객체생성
			eventDAO = new NoticeDAO();
			// noticeDTO = getEvent(a_num) 메서드 호출
			noticeDTO = eventDAO.getEvent(a_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeDTO;
	}//getEvent
	
//======================================= updateEvent =============================================	
	public void updateEvent(HttpServletRequest request) {
		System.out.println("NoticeService updateEvent()");
		try {
			request.setCharacterEncoding("utf-8");
			//업로드 파일경로(upload폴더)
			String uploadPath=request.getRealPath("/upload");
			int maxSize=10*1024*1024;
			MultipartRequest multi 
			= new MultipartRequest(request, uploadPath,maxSize,"utf-8",
					new DefaultFileRenamePolicy());

			// a_num, a_title, a_content, a_file, a_oldfile 파라미터 값 가져오기
			int a_num = Integer.parseInt(multi.getParameter("a_num"));
			String a_title =multi.getParameter("a_title");
			String a_content = multi.getParameter("a_content");
			//a_file, a_oldfile
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
			// NoticeDAO 객체생성
			eventDAO = new NoticeDAO();
			// updateNotice(noticeDTO) 메서드호출
			eventDAO.updateNotice(noticeDTO);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//updateEvent
	
//======================================= deleteEvent ================================================
	public void deleteEvent(HttpServletRequest request) {
		System.out.println("NoticeService deleteEvent()");
		try {
			request.setCharacterEncoding("utf-8");
			// NoticeService => int a_num = request 파라미터값 가져오기
			int a_num = Integer.parseInt(request.getParameter("a_num"));
			// NoticeDAO 객체생성 
			eventDAO = new NoticeDAO();
			// deleteEvent(a_num)호출
			eventDAO.deleteEvent(a_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//deleteEvent

//======================================= getEventListSearch ================================================	
	public List<NoticeDTO> getEventListSearch(NoticePageDTO pageDTO2) {
		System.out.println("NoticeSearvice getEventListSearch()");
		List<NoticeDTO> eventList = null;
		try {
			// 시작하는 행부터 10개 뽑아오기
			int startRow = (pageDTO2.getCurrentPage()-1)*pageDTO2.getPageSize()+1;
			// 시작하는 행부터 끝나는 행까지 뽑아오기
			int endRow = startRow+pageDTO2.getPageSize()-1;
			//pageDTO 저장 <= startRow, endRow
			pageDTO2.setStartRow(startRow);
			pageDTO2.setEndRow(endRow);

			// NoticeDAO 객체생성
			eventDAO = new NoticeDAO();
			// eventList = getEventList() 메서드 호출
			eventList = eventDAO.getEventListSearch(pageDTO2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eventList;
	}//getEventListSearch

//===================================== getEventCountSearch ===========================================		
	public int getEventCountSearch(NoticePageDTO pageDTO2) {
		System.out.println("NoticeService getEventCountSearch()");
		int count = 0;
		try {
			// NoticeDAO 객체생성
			eventDAO = new NoticeDAO();
			// a_count = getEvnetCount() 호출
			count = eventDAO.getEventCountSearch(pageDTO2);
		} catch (Exception e) {
			e.printStackTrace();
		}return count;
	}//getEventCountSearch	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class