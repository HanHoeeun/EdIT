package com.itwillbs.service;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.itwillbs.dao.ProductDAO;
import com.itwillbs.domain.ProductDTO;
import com.itwillbs.domain.ProductPageDTO;

public class ProductService {
	ProductDAO productDAO = null;
	
	public List<ProductDTO> getProductList(ProductPageDTO ppageDTO) {
		System.out.println("productService getProductList()");
		List<ProductDTO> productList = null;
		try {
			// 시작하는 행부터 10개 뽑아오기
//			페이지번호     한화면에 보여줄 글개수 => 시작하는 행번호
//			currentPage         pageSize    => startRow
//			    1                 10        => (1-1)*10+1=>0*10+1=> 0+1=>1        ~ 10
//			    2                 10        => (2-1)*10+1=>1*10+1=>10+1=>11       ~ 20
//		        3                 10        => (3-1)*10+1=>2*10+1=>20+1=>21       ~ 30			
			
			
			int p_startRow = (ppageDTO.getP_currentPage()-1)*ppageDTO.getP_pageSize()+1;
			// 시작하는 행부터 끝나는 행까지 뽑아오기
//			startRow  pageSize => endRow
//			    1         10   =>   1+10-1 =>10
//			    11        10   =>   11+10-1 =>20
//		        21        10   =>   21+10-1 =>30
			    		
			int p_endRow = p_startRow+ppageDTO.getP_pageSize()-1;
			//pageDTO 저장 <= startRow, endRow
			ppageDTO.setP_startRow(p_startRow);
			ppageDTO.setP_endRow(p_endRow);
			
			// BoardDAO 객체생성
			productDAO = new ProductDAO();
			// boardList = getBoardList() 메서드 호출
			productList = productDAO.getProductList(ppageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	public void registerProduct(HttpServletRequest request) {
		try {
			System.out.println("ProductService registerProduct");
			// request 한글처리 
			request.setCharacterEncoding("utf-8");
			// requset 파라미터 값 가져오기
			String p_title = request.getParameter("p_title");
			int p_price = Integer.parseInt(request.getParameter("p_price"));
			// ProductDAO 객체생성
			productDAO = new ProductDAO();
			// productDTO 객체생성
			ProductDTO productDTO = new ProductDTO();
			// set 메서드 호출 파라미터 값 저장  
			productDTO.setP_title(p_title);
			productDTO.setP_price(p_price);
			// 리할형 없음 registerProduct(productDTO) 호출
			productDAO.registerProduct(productDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public int getProductCount() {
		System.out.println("ProductService getProductCount()");
		int count=0;
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();
			// count = getBoardCount() 호출
			count = productDAO.getProductCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<ProductDTO> getLatestProducts(ProductPageDTO productDTO) {
		List<ProductDTO> latestList = null;
		System.out.println("ProductService getLatestProducts()");
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();	
			// DAO에서 데이터 가져오기
			latestList =productDAO.getLatestProducts(productDTO); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return latestList;
	}

	public List<ProductDTO> getPopularProducts(ProductPageDTO ppageDTO) {
		System.out.println("ProductService getPopularProducts()");
		List<ProductDTO> popluarList = null;
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();	
			// DAO에서 데이터 가져오기
			popluarList=productDAO.getPopularProducts(ppageDTO); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return popluarList;
	}

	public List<ProductDTO> getHighPriceProducts(ProductPageDTO ppageDTO) {
		System.out.println("ProductService getHighPriceProducts()");
		List<ProductDTO> highPriceList = null;
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();
			// DAO에서 데이터 가져오기
			highPriceList=productDAO.getHighPriceProducts(ppageDTO); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return highPriceList;
	}

	public List<ProductDTO> getLowPriceProducts(ProductPageDTO ppageDTO) {
		System.out.println("ProductService getLowPriceProducts()");
		List<ProductDTO> lowPriceList = null;
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();
			// DAO에서 데이터 가져오기
			lowPriceList=productDAO.getLowPriceProducts(ppageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lowPriceList;
	}

	public List<ProductDTO> getLaptopList(ProductPageDTO ppageDTO) {
		System.out.println("productService getLaptopList()");
		List<ProductDTO> laptopList = null;
		try {
			int p_startRow = (ppageDTO.getP_currentPage()-1)*ppageDTO.getP_pageSize()+1;
			int p_endRow = p_startRow+ppageDTO.getP_pageSize()-1;
			ppageDTO.setP_startRow(p_startRow);
			ppageDTO.setP_endRow(p_endRow);
			productDAO = new ProductDAO();
			laptopList = productDAO.getlaptopList(ppageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return laptopList;
	}


// -----------------------------------------------------------------------------------
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
