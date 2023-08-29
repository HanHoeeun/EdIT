package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.itwillbs.dao.AdminDAO;
import com.itwillbs.domain.AdminDTO;
import com.itwillbs.domain.AdminPageDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminService {
	AdminDAO adminDAO = null;
	
	public void faqBoardInsert(HttpServletRequest request) {
		try {

			//파일이 저장될 경로명
//			String directory = "/usr/local/tomcat/img/"; 
//			String directory = "C:\\Users\\kkm\\Desktop\\workspace_jsp\\FunWeb\\src\\main\\webapp\\upload";
//			물리적인 경로 
			String uploadPath = request.getRealPath("/adminUpload");
			
//			이클립스에 실행하면 이클립스 가상 경로 
			System.out.println(uploadPath);
			
			//파일의 최대 크기 10mb
			int sizeLimit = 10*1024*1024;	
//										MultipartRequest(request, 저장경로, 파일크기제한, 한글처리, 파일이름 중복처리
			MultipartRequest multi = new MultipartRequest(request, uploadPath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy() );
			
//			multi 파라미터 값 가져오기
			int a_cs_type = Integer.parseInt(multi.getParameter("faq_select"));
			String name = multi.getParameter("name");
			String subject = multi.getParameter("subject");
			String content = multi.getParameter("content");
			adminDAO = new AdminDAO();
			
			
			
//			첨부파일 이름 가져오기 <input type="file" name="file" > name = file 매개변수 
			String file = multi.getFilesystemName("imgfile");
			
			AdminDTO adminDTO = new AdminDTO();
			
			adminDTO.setA_cs_type(a_cs_type);
			adminDTO.setA_m_nick(name);
			adminDTO.setA_title(subject);
			adminDTO.setA_content(content);
			
			System.out.println(adminDTO.getA_cs_type());
			
			if(file != null) {
				adminDTO.setA_file(file);
			}
			
//			첨부파일 이름 담기			
//			boardDTO.setFile(file);
			
			adminDAO.insertBoard(adminDTO);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<AdminDTO> getBoardListSearch(AdminPageDTO pageDTO) {
		List<AdminDTO> adminList = null;
		try {
//			시박하는 행부터 10개 뽑아오기
//			페이지 번호 	한화면에 보여줄 글개수 => 			시작하는 행번호
//			currentPage		pageSize	=>		 	startRow
//			1				10			=> 0*10 +1	 1 ~ 10
//			2				10			=> 1*10 +1 	11 ~ 20
//			3				10			=> 2*10 +1 	21 ~ 30
//			((currentPage-1)*10)+1
			int startRow = (pageDTO.getCurrentPage()-1)*pageDTO.getPageSize()+1;
			int endRos = startRow + pageDTO.getPageSize() -1;
			
			pageDTO.setStartRow(startRow);
			pageDTO.setEndRow(endRos);
			
//			AdminDAO 객체 생성
			adminDAO = new AdminDAO();
//			adminList = getBoardList() 메서드 호출
			adminList =  adminDAO.getBoardListSearch(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return adminList;
		
	}

	public int getBoardCountSearch(AdminPageDTO pageDTO) {
		int count = 0;
		try {
			adminDAO = new AdminDAO();
			count = adminDAO.getBoardCountSearch(pageDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

}
