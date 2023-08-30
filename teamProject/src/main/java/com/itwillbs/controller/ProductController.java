package com.itwillbs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.domain.ProductDTO;
import com.itwillbs.service.ProductService;

public class ProductController extends HttpServlet{

	RequestDispatcher dispatcher = null;
	ProductService productService = null;
	
	// HttpServlet 처리 담당자 -> 자동으로 doGet, doPost 호출
	//-> 재정의여 사용
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductController doGet()");
		doProcess(request, response);
	}//doGet()

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductController doPost()");
		doProcess(request, response);
	}//doPost()
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductController doProcess()");
		// 가상주소 뽑아오기
		String sPath=request.getServletPath();
		System.out.println("뽑은 가상주소 :  " + sPath);
		// 뽑은 가상주소 비교하기 => 실제 페이지 연결
		
		if (sPath.equals("/products.po")) {
			// product/products.jsp 주소변경 없이 연결
			dispatcher
			= request.getRequestDispatcher("product/products.jsp");
			dispatcher.forward(request, response);
		} // products.me
		
		// -------------------------------------------------------------------------------
		
		if(sPath.equals("/productReg.po")) {
			dispatcher 
			    = request.getRequestDispatcher("product/productReg.jsp");
			dispatcher.forward(request, response);
			
		} // if
		
		if(sPath.equals("/productRegPro.po")) {
			
			// ProductService 객체생성
			productService = new ProductService();
			// insertMember() 메서드 호출
			productService.insertProduct(request);
			//로그인 이동 => 주소변경하면서 이동
			response.sendRedirect("products.po");
			
		} // if
		
		// -------------------------------------------------------------------------------
		
		if(sPath.equals("/productUpdate.po")) {
			//수정하기 전에 디비 나의 정보 조회(세션값 id) => jsp 화면 출력
			// 세션 객체생성
			HttpSession session = request.getSession();
			
			// "p_id" 세션값 가져오기=> String id 변수 저장
			String m_id = (String)session.getAttribute("m_id");
			
			// ProductService 객체생성
			productService = new ProductService();
			
			// ProductDTO productDTO = getMember(id) 메서드 호출
			ProductDTO productDTO = productService.getproduct(request);
			
			// request에 productDTO 저장 ("이름",값)
			request.setAttribute("productDTO", productDTO);
			
			// product/productUpdate.jsp 주소변경없이 이동
			dispatcher 
		    = request.getRequestDispatcher("product/productUpdate.jsp");
		dispatcher.forward(request, response);
		
		}//
		
		if(sPath.equals("/productUpdatePro.po")) {
			// request안에 폼에서 입력한 수정할 값이 저장
			// ProductService 객체생성
			productService = new ProductService();
			
			// memberDTO != null 아이디 비밀번호 일치=> 
			// 수정  리턴할형없음  updateMember(request) 메서드 호출 
			//  sql =>  update members set name = ? where id = ? 
			productService.updateProduct(request);
			
			response.sendRedirect("products.po");
			
		}//
		
		// -------------------------------------------------------------------------------------------
		
		if(sPath.equals("/delete.po")) {
			// BoardService 객체생성
			productService = new ProductService();
			
			// deleteBoard(request) 메서드 호출
			productService.deleteProduct(request);
			
			// 글목록 list.bo 주소 변경 되면서 이동
			response.sendRedirect("products.bo");
			
		}//
		
		
		if(sPath.equals("/single.po")) {
			// ProductService 객체생성
			productService = new ProductService();
			
			//조회수 증가 readcount 1증가
			// 리턴할형 없음  updateReadcount(request) 메서드 호출
//			productService.updateReadcount(request);
			
			// ProductDTO productDTO = getBoard(request) 메서드 호출
			ProductDTO productDTO = productService.getproduct(request);
			
			// request에 "boardDTO",boardDTO 담아서
			request.setAttribute("productDTO", productDTO);
			
			dispatcher 
		    = request.getRequestDispatcher("product/single.jsp");
			dispatcher.forward(request, response);
		
		}//
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//doProcess()
}
