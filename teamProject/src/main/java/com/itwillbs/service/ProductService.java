package com.itwillbs.service;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import com.itwillbs.dao.ProductDAO;
import com.itwillbs.domain.ProductDTO;

public class ProductService {
	ProductDAO productDAO = null;
	
	
	//-----------------------------------------------------------------------------------
	public void insertProduct(HttpServletRequest request) {
		
		try {
			
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
			
			// request 한글처리
			request.setCharacterEncoding("utf-8");
			
    	    // request 저장된 파라미터값 가져오기=>변수저장
			String p_title = multi.getParameter("p_title");
			String p_type = multi.getParameter("p_type");
			int p_price = Integer.parseInt(multi.getParameter("p_price"));
			String p_detail = multi.getParameter("p_detail");
			Timestamp p_date = new Timestamp(System.currentTimeMillis());
			
			// 조회수
			int p_readcount = 0;
			
			String p_status = multi.getParameter("p_status");
			String p_file = multi.getFilesystemName("p_file");
			
			productDAO = new ProductDAO();
			
			int p_num = productDAO.getMaxNum() + 1;
			
			// ProductDTO 객체생성 
			ProductDTO productDTO =new ProductDTO();
			
			// set메서드 호출 파라미터값 저장
			productDTO.setP_num(p_num);
			productDTO.setP_title(p_title);
			productDTO.setP_type(p_type);
			productDTO.setP_price(p_price);
			productDTO.setP_detail(p_detail);
			productDTO.setP_date(p_date);
			productDTO.setP_readcount(p_readcount);
			productDTO.setP_status(p_status);
			productDTO.setP_file(p_file);
			
			// insertMember() 메서드 호출
			productDAO.insertProduct(productDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//insertMember()
	
	//------------------------------------------------------------------------------------------------------------------
	
	public void updateProduct(HttpServletRequest request) {
		try {
			System.out.println("서비스");
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
			
			// request 한글처리
			request.setCharacterEncoding("utf-8");
			
			int p_num = Integer.parseInt(multi.getParameter("p_num"));
			String p_title = multi.getParameter("p_title");
			String p_type = multi.getParameter("p_type");
			int p_price = Integer.parseInt(multi.getParameter("p_price"));
			String p_detail = multi.getParameter("p_detail");
			Timestamp p_date = new Timestamp(System.currentTimeMillis());
			
			String p_status = multi.getParameter("p_status");
			String p_file = multi.getFilesystemName("p_file");
			
			if(p_file == null) {
				//기존 파일이름 가져오기
				p_file = multi.getParameter("oldfile");
			}
			
			// ProductDTO 객체생성 
			ProductDTO productDTO =new ProductDTO();
			
			// set메서드 호출 파라미터값 저장
			productDTO.setP_num(p_num);
			productDTO.setP_title(p_title);
			productDTO.setP_type(p_type);
			productDTO.setP_price(p_price);
			productDTO.setP_detail(p_detail);
			productDTO.setP_date(p_date);
			productDTO.setP_status(p_status);
			productDTO.setP_file(p_file);
			
			
			// ProductDAO 객체생성
			productDAO = new ProductDAO();
			
			// updateProduct(productDTO) 메서드 호출
			productDAO.updateProduct(productDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} //updateProduct()
	
	
	public ProductDTO getproduct(HttpServletRequest request) {
		
		ProductDTO productDTO = null;
		try {
			// request 한글처리
			request.setCharacterEncoding("utf-8");
			
			// request 파라미터 가져오기 => int num 저장
			int p_num = Integer.parseInt(request.getParameter("p_num"));
			
			// BoardDAO 객체생성
			productDAO = new ProductDAO();
			
			// boardDTO = getBoard(num) 메서드 호출
			productDTO = productDAO.getproduct(p_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productDTO;
	}//getBoard
	
	//--------------------------------------------------------------------------------------------------
	
	public void deleteProduct(HttpServletRequest request) {
		
		try {
			// 한글처리
			request.setCharacterEncoding("utf-8");
			
			// num  파라미터 값 가져오기
			int p_num = Integer.parseInt(request.getParameter("p_num"));
			
			// BoardDAO 객체생성
			productDAO = new ProductDAO();
			
			//deleteBoard(num) 메서드호출
			productDAO.deleteProduct(p_num);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//deleteProduct()
	
	
	
	
	
	
	
}
