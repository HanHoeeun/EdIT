package com.itwillbs.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import com.itwillbs.dao.AdminDAO;
import com.itwillbs.domain.AdminDTO;
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

}
