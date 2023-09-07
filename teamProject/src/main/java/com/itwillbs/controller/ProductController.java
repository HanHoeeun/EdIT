package com.itwillbs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.ProductDTO;
import com.itwillbs.domain.ProductPageDTO;
import com.itwillbs.domain.WishListDTO;
import com.itwillbs.service.MemberService;
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
		
// ==================================================================================================================================	
		
		if (sPath.equals("/products.po")) {
			System.out.println("뽑은 가상주소 비교 : /products.po");
			
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("m_id");
			
			MemberService memberService = new MemberService();
			MemberDTO memberDTO =  memberService.getMember(id);
			
			ProductService productService = new ProductService();
			ProductDTO productDTO = productService.getproduct(request);
			
			// 한페이지에서 보여지는 글개수 설정
			int p_pageSize=6;
			// 페이지번호 
			String p_pageNum=request.getParameter("p_pageNum");
			// 페이지번호가 없으면 1페이지 설정
			if(p_pageNum == null) {
				p_pageNum = "1";
			}
			// 페이지 번호를 => 정수형 변경
			int p_currentPage = Integer.parseInt(p_pageNum);
			
			ProductPageDTO ppageDTO = new ProductPageDTO();
			ppageDTO.setP_pageSize(p_pageSize);
			ppageDTO.setP_pageNum(p_pageNum);
			ppageDTO.setP_currentPage(p_currentPage);
			
			
			// ProductService 객체생성
			productService = new ProductService();
			
// 			List<ProductDTO> productList = getProductList(); 메서드 호출
			List<ProductDTO> productList=productService.getProductList(ppageDTO);
			
			// orderBy 파라미터를 받아와서 옵션 값 확인
		    String orderBy = request.getParameter("ord");
		   // System.out.println("orderBy"+ orderBy);
		    if(orderBy != null) {

		    if ("latest".equals(orderBy)) {
		        productList = productService.getLatestProducts(ppageDTO);
		    } else if ("popular".equals(orderBy)) {
		        productList = productService.getPopularProducts(ppageDTO);
		    } else if ("highPrice".equals(orderBy)) {
		        productList = productService.getHighPriceProducts(ppageDTO);
		    } else if ("lowPrice".equals(orderBy)) {
		        productList = productService.getLowPriceProducts(ppageDTO);
		    } else if ("sell".equals(orderBy)) {
		    	productList = productService.getSellProducts(ppageDTO);
		    } else if ("sold".equals(orderBy)) {
		    	productList = productService.getSoldProducts(ppageDTO);
		    	
		    } else {
		        // 디폴트로 최신순 정렬
		        productList = productService.getLatestProducts(ppageDTO);
		    }
		    }
			
			// 게시판 전체 글 개수 구하기 
			int p_count = productService.getProductCount();
			// 한화면에 보여줄 페이지개수 설정
			int p_pageBlock = 3;
			// 시작하는 페이지번호
			// currentPage  pageBlock  => startPage
			//   1~10(0~9)      10     =>  (0~9)/10*10+1=>0*10+1=> 0+1=> 1 
			//   11~20(10~19)   10     =>  (10~19)/10*10+1=>1*10+1=>10+1=>11
			//   21~30(20~29)   10     =>  (20~29)/10*10+1=>2*10+1=>20+1=>21
			int p_startPage=(p_currentPage-1)/p_pageBlock*p_pageBlock+1;
			// 끝나는페이지번호
			//  startPage   pageBlock => endPage
			//     1            10    =>   10
			//     11           10    =>   20
			//     21           10    =>   30
			int p_endPage=p_startPage+p_pageBlock-1;
			// 계산한값 endPage 10 => 전체페이지 2
			// 전체페이지 구하기
			// 글개수 50  한화면에 보여줄글개수 10 => 페이지수 5 + 0
			// 글개수 57  한화면에 보여줄글개수 10 => 페이지수 5 + 1
			int p_pageCount = p_count / p_pageSize + (p_count % p_pageSize==0?0:1);
			if(p_endPage > p_pageCount) {
				p_endPage = p_pageCount;
			}
			
			//pageDTO 저장
			ppageDTO.setP_count(p_count);
			ppageDTO.setP_pageBlock(p_pageBlock);
			ppageDTO.setP_startPage(p_startPage);
			ppageDTO.setP_endPage(p_endPage);
			ppageDTO.setP_pageCount(p_pageCount);
			//ppageDTO.setM_id(id);
//			System.out.println("스타트페이지 =" + p_startPage +", 페이지 블럭 = "+ p_pageBlock);
//			System.out.println("현재페이지 =" + p_currentPage);
			
			// request에 "productList",productList 저장
			
			request.setAttribute("productList", productList);
			request.setAttribute("ppageDTO", ppageDTO);
			request.setAttribute("orderBy", orderBy);
			request.setAttribute("productDTO", productDTO);
			request.setAttribute("memberDTO", memberDTO);
			
			// 주소변경없이 이동 center/products.jsp
			dispatcher 
		    = request.getRequestDispatcher("product/products.jsp");
		dispatcher.forward(request, response);
		} // products.po
	
		
		if (sPath.equals("/productsPro.po")) {
			System.out.println("뽑은 가상 주소 비교 : /productsPro.po");
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("m_id");
			
			MemberService memberService = new MemberService();
			MemberDTO memberDTO =  memberService.getMember(id);
			request.setAttribute("memberDTO", memberDTO);
			
			// ProductDTO productDTO = getBoard(request) 메서드 호출
			ProductDTO productDTO = productService.getproduct(request);
			
			// request에 "boardDTO",boardDTO 담아서
			request.setAttribute("productDTO", productDTO);
			 
			response.sendRedirect("products.po");
		}
		//========================================================================================================
		
		if (sPath.equals("/laptop.po")) {
			System.out.println("뽑은 가상주소 비교 : /laptop.po");
			

			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("m_id");
			
			MemberService memberService = new MemberService();
			MemberDTO memberDTO =  memberService.getMember(id);
			
			ProductService productService = new ProductService();
			ProductDTO productDTO = productService.getproduct(request);
			
			// 한페이지에서 보여지는 글개수 설정
			int p_pageSize=6;
			// 페이지번호 
			String p_pageNum=request.getParameter("p_pageNum");
			// 페이지번호가 없으면 1페이지 설정
			if(p_pageNum == null) {
				p_pageNum = "1";
			}
			// 페이지 번호를 => 정수형 변경
			int p_currentPage = Integer.parseInt(p_pageNum);
			
			ProductPageDTO ppageDTO = new ProductPageDTO();
			ppageDTO.setP_pageSize(p_pageSize);
			ppageDTO.setP_pageNum(p_pageNum);
			ppageDTO.setP_currentPage(p_currentPage);
			
			// ProductService 객체생성
			productService = new ProductService();
// 			List<ProductDTO> laptopList = getProductList(); 메서드 호출
			List<ProductDTO> laptopList=productService.getLaptopList(ppageDTO);
			
			// orderBy 파라미터를 받아와서 옵션 값 확인
		    String orderBy = request.getParameter("ord");
		    System.out.println("orderBy"+ orderBy);
		    if(orderBy != null) {
		    if ("laptopLatest".equals(orderBy)) {
		    	laptopList = productService.getLaptopLatestProducts(ppageDTO);
		    } else
		    	if ("laptopPopular".equals(orderBy)) {
		    	laptopList = productService.getLaptopPopularProducts(ppageDTO);
		    } else if ("laptopHighPrice".equals(orderBy)) {
		    	laptopList = productService.getLaptopHighPriceProducts(ppageDTO);
		    } else if ("laptopLowPrice".equals(orderBy)) {
		    	laptopList = productService.getLaptopLowPriceProducts(ppageDTO);
		    } else if ("laptopSell".equals(orderBy)) {
		    	laptopList = productService.getLaptopSellProducts(ppageDTO);
		    } else if ("laptopSold".equals(orderBy)) {
		    	laptopList = productService.getLaptopSoldProducts(ppageDTO);
		    } else {
		        // 디폴트로 최신순 정렬
		    	laptopList = productService.getLatestProducts(ppageDTO);
		    }}
			// 게시판 전체 글 개수 구하기 
			int p_count = productService.getProductCount();
			// 한화면에 보여줄 페이지개수 설정
			int p_pageBlock = 3;
			// 시작하는 페이지번호
			// currentPage  pageBlock  => startPage
			//   1~10(0~9)      10     =>  (0~9)/10*10+1=>0*10+1=> 0+1=> 1 
			//   11~20(10~19)   10     =>  (10~19)/10*10+1=>1*10+1=>10+1=>11
			//   21~30(20~29)   10     =>  (20~29)/10*10+1=>2*10+1=>20+1=>21
			int p_startPage=(p_currentPage-1)/p_pageBlock*p_pageBlock+1;
			// 끝나는페이지번호
			//  startPage   pageBlock => endPage
			//     1            10    =>   10
			//     11           10    =>   20
			//     21           10    =>   30
			int p_endPage=p_startPage+p_pageBlock-1;
			// 계산한값 endPage 10 => 전체페이지 2
			// 전체페이지 구하기
			// 글개수 50  한화면에 보여줄글개수 10 => 페이지수 5 + 0
			// 글개수 57  한화면에 보여줄글개수 10 => 페이지수 5 + 1
			int p_pageCount = p_count / p_pageSize + (p_count % p_pageSize==0?0:1);
			if(p_endPage > p_pageCount) {
				p_endPage = p_pageCount;
			}
			//pageDTO 저장
			ppageDTO.setP_count(p_count);
			ppageDTO.setP_pageBlock(p_pageBlock);
			ppageDTO.setP_startPage(p_startPage);
			ppageDTO.setP_endPage(p_endPage);
			ppageDTO.setP_pageCount(p_pageCount);
			System.out.println(" laptop 스타트페이지 =" + p_startPage +", 페이지 블럭 = "+ p_pageBlock);
			// request에 "laptopList",laptopList 저장
			request.setAttribute("laptopList", laptopList);
			request.setAttribute("ppageDTO", ppageDTO);
			request.setAttribute("orderBy", orderBy);
			request.setAttribute("productDTO", productDTO);
			request.setAttribute("memberDTO", memberDTO);
			
			// 주소변경없이 이동 center/laptop.jsp
			dispatcher 
		    = request.getRequestDispatcher("product/laptop.jsp");
		dispatcher.forward(request, response);
		} // laptop.po
		
		
		if (sPath.equals("/laptopPro.po")) {
			System.out.println("뽑은 가상 주소 비교 : /laptopPro.po");
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("m_id");
			
			MemberService memberService = new MemberService();
			MemberDTO memberDTO =  memberService.getMember(id);
			request.setAttribute("memberDTO", memberDTO);
			
			// ProductDTO productDTO = getBoard(request) 메서드 호출
			ProductDTO productDTO = productService.getproduct(request);
			
			// request에 "boardDTO",boardDTO 담아서
			request.setAttribute("productDTO", productDTO);
			 
			response.sendRedirect("laptop.po");
		}
		
		
		// -------------------------------------------------------------------------------
		if (sPath.equals("/phone.po")) {
			System.out.println("뽑은 가상주소 비교 : /phone.po");
			
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("m_id");
			
			MemberService memberService = new MemberService();
			MemberDTO memberDTO =  memberService.getMember(id);
			
			ProductService productService = new ProductService();
			ProductDTO productDTO = productService.getproduct(request);
			
			// 한페이지에서 보여지는 글개수 설정
			int p_pageSize=6;
			// 페이지번호 
			String p_pageNum=request.getParameter("p_pageNum");
			// 페이지번호가 없으면 1페이지 설정
			if(p_pageNum == null) {
				p_pageNum = "1";
			}
			// 페이지 번호를 => 정수형 변경
			int p_currentPage = Integer.parseInt(p_pageNum);
			
			ProductPageDTO ppageDTO = new ProductPageDTO();
			ppageDTO.setP_pageSize(p_pageSize);
			ppageDTO.setP_pageNum(p_pageNum);
			ppageDTO.setP_currentPage(p_currentPage);
			
			// ProductService 객체생성
			productService = new ProductService();
// 			List<ProductDTO> laptopList = getProductList(); 메서드 호출
			List<ProductDTO> phoneList=productService.getPhoneList(ppageDTO);
			
			// orderBy 파라미터를 받아와서 옵션 값 확인
		    String orderBy = request.getParameter("ord");
		    System.out.println("orderBy"+ orderBy);
		    if(orderBy != null) {
		    if ("phoneLatest".equals(orderBy)) {
		    	phoneList = productService.getPhoneLatestProducts(ppageDTO);
		    } else
		    	if ("phonePopular".equals(orderBy)) {
		    	phoneList = productService.getPhonePopularProducts(ppageDTO);
		    } else if ("phoneHighPrice".equals(orderBy)) {
		    	phoneList = productService.getPhoneHighPriceProducts(ppageDTO);
		    } else if ("phoneLowPrice".equals(orderBy)) {
		    	phoneList = productService.getPhoneLowPriceProducts(ppageDTO);
		    } else if ("phoneSell".equals(orderBy)) {
		    	phoneList = productService.getPhoneSellProducts(ppageDTO);
		    } else if ("phoneSold".equals(orderBy)) {
		    	phoneList = productService.getPhoneSoldProducts(ppageDTO);
		    } else {
		        // 디폴트로 최신순 정렬
		    	phoneList = productService.getLatestProducts(ppageDTO);
		    }}
			// 게시판 전체 글 개수 구하기 
			int p_count = productService.getProductCount();
			// 한화면에 보여줄 페이지개수 설정
			int p_pageBlock = 3;
			// 시작하는 페이지번호
			// currentPage  pageBlock  => startPage
			//   1~10(0~9)      10     =>  (0~9)/10*10+1=>0*10+1=> 0+1=> 1 
			//   11~20(10~19)   10     =>  (10~19)/10*10+1=>1*10+1=>10+1=>11
			//   21~30(20~29)   10     =>  (20~29)/10*10+1=>2*10+1=>20+1=>21
			int p_startPage=(p_currentPage-1)/p_pageBlock*p_pageBlock+1;
			// 끝나는페이지번호
			//  startPage   pageBlock => endPage
			//     1            10    =>   10
			//     11           10    =>   20
			//     21           10    =>   30
			int p_endPage=p_startPage+p_pageBlock-1;
			// 계산한값 endPage 10 => 전체페이지 2
			// 전체페이지 구하기
			// 글개수 50  한화면에 보여줄글개수 10 => 페이지수 5 + 0
			// 글개수 57  한화면에 보여줄글개수 10 => 페이지수 5 + 1
			int p_pageCount = p_count / p_pageSize + (p_count % p_pageSize==0?0:1);
			if(p_endPage > p_pageCount) {
				p_endPage = p_pageCount;
			}
			//pageDTO 저장
			ppageDTO.setP_count(p_count);
			ppageDTO.setP_pageBlock(p_pageBlock);
			ppageDTO.setP_startPage(p_startPage);
			ppageDTO.setP_endPage(p_endPage);
			ppageDTO.setP_pageCount(p_pageCount);
			System.out.println("phone 스타트페이지 =" + p_startPage +", 페이지 블럭 = "+ p_pageBlock);
			// request에 "phoneList",phoneList 저장
			request.setAttribute("phoneList", phoneList);
			request.setAttribute("ppageDTO", ppageDTO);
			request.setAttribute("orderBy", orderBy);
			request.setAttribute("productDTO", productDTO);
			request.setAttribute("memberDTO", memberDTO);
			
			// 주소변경없이 이동 center/laptop.jsp
			dispatcher 
		    = request.getRequestDispatcher("product/phone.jsp");
		dispatcher.forward(request, response);
		} // phone.po
		 
		if (sPath.equals("/phonePro.po")) {
			System.out.println("뽑은 가상 주소 비교 : /phonePro.po");
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("m_id");
			
			MemberService memberService = new MemberService();
			MemberDTO memberDTO =  memberService.getMember(id);
			request.setAttribute("memberDTO", memberDTO);
			
			// ProductDTO productDTO = getBoard(request) 메서드 호출
			ProductDTO productDTO = productService.getproduct(request);
			
			// request에 "boardDTO",boardDTO 담아서
			request.setAttribute("productDTO", productDTO);
			 
			response.sendRedirect("phone.po");
		}
		
		// -------------------------------------------------------------------------------
				if (sPath.equals("/tablet.po")) {
					System.out.println("뽑은 가상주소 비교 : /tablet.po");
					HttpSession session = request.getSession();
					String id = (String)session.getAttribute("m_id");
					
					MemberService memberService = new MemberService();
					MemberDTO memberDTO =  memberService.getMember(id);
					
					ProductService productService = new ProductService();
					ProductDTO productDTO = productService.getproduct(request);
					
					// 한페이지에서 보여지는 글개수 설정
					int p_pageSize=6;
					// 페이지번호 
					String p_pageNum=request.getParameter("p_pageNum");
					// 페이지번호가 없으면 1페이지 설정
					if(p_pageNum == null) {
						p_pageNum = "1";
					}
					// 페이지 번호를 => 정수형 변경
					int p_currentPage = Integer.parseInt(p_pageNum);
					
					ProductPageDTO ppageDTO = new ProductPageDTO();
					ppageDTO.setP_pageSize(p_pageSize);
					ppageDTO.setP_pageNum(p_pageNum);
					ppageDTO.setP_currentPage(p_currentPage);
					
					// ProductService 객체생성
					productService = new ProductService();
//		 			List<ProductDTO> laptopList = getProductList(); 메서드 호출
					List<ProductDTO> tabletList=productService.getTabletList(ppageDTO);
					
					// orderBy 파라미터를 받아와서 옵션 값 확인
				    String orderBy = request.getParameter("ord");
				    System.out.println("orderBy"+ orderBy);
				    if(orderBy != null) {
				    if ("tabletLatest".equals(orderBy)) {
				    	tabletList = productService.getTabletLatestProducts(ppageDTO);
				    } else
				    	if ("tabletPopular".equals(orderBy)) {
				    	tabletList = productService.getTabletPopularProducts(ppageDTO);
				    } else if ("tabletHighPrice".equals(orderBy)) {
				    	tabletList = productService.getTabletHighPriceProducts(ppageDTO);
				    } else if ("tabletLowPrice".equals(orderBy)) {
				    	tabletList = productService.getTabletLowPriceProducts(ppageDTO);
				    } else if ("tabletSell".equals(orderBy)) {
				    	tabletList = productService.getTabletSellProducts(ppageDTO);
				    } else if ("tabletSold".equals(orderBy)) {
				    	tabletList = productService.getTabletSoldProducts(ppageDTO);
				    } else {
				        // 디폴트로 최신순 정렬
				    	tabletList = productService.getLatestProducts(ppageDTO);
				    }}
					// 게시판 전체 글 개수 구하기 
					int p_count = productService.getProductCount();
					// 한화면에 보여줄 페이지개수 설정
					int p_pageBlock = 3;
					// 시작하는 페이지번호
					// currentPage  pageBlock  => startPage
					//   1~10(0~9)      10     =>  (0~9)/10*10+1=>0*10+1=> 0+1=> 1 
					//   11~20(10~19)   10     =>  (10~19)/10*10+1=>1*10+1=>10+1=>11
					//   21~30(20~29)   10     =>  (20~29)/10*10+1=>2*10+1=>20+1=>21
					int p_startPage=(p_currentPage-1)/p_pageBlock*p_pageBlock+1;
					// 끝나는페이지번호
					//  startPage   pageBlock => endPage
					//     1            10    =>   10
					//     11           10    =>   20
					//     21           10    =>   30
					int p_endPage=p_startPage+p_pageBlock-1;
					// 계산한값 endPage 10 => 전체페이지 2
					// 전체페이지 구하기
					// 글개수 50  한화면에 보여줄글개수 10 => 페이지수 5 + 0
					// 글개수 57  한화면에 보여줄글개수 10 => 페이지수 5 + 1
					int p_pageCount = p_count / p_pageSize + (p_count % p_pageSize==0?0:1);
					if(p_endPage > p_pageCount) {
						p_endPage = p_pageCount;
					}
					//pageDTO 저장
					ppageDTO.setP_count(p_count);
					ppageDTO.setP_pageBlock(p_pageBlock);
					ppageDTO.setP_startPage(p_startPage);
					ppageDTO.setP_endPage(p_endPage);
					ppageDTO.setP_pageCount(p_pageCount);
					System.out.println("tablet 스타트페이지 =" + p_startPage +", 페이지 블럭 = "+ p_pageBlock);
					// request에 "phoneList",phoneList 저장
					request.setAttribute("tabletList", tabletList);
					request.setAttribute("ppageDTO", ppageDTO);
					request.setAttribute("orderBy", orderBy);
					request.setAttribute("productDTO", productDTO);
					request.setAttribute("memberDTO", memberDTO);
					
					// 주소변경없이 이동 center/laptop.jsp
					dispatcher 
				    = request.getRequestDispatcher("product/tablet.jsp");
				dispatcher.forward(request, response);
				} // tablet.po
		
				if (sPath.equals("/tabletPro.po")) {
					System.out.println("뽑은 가상 주소 비교 : /tabletPro.po");
					HttpSession session = request.getSession();
					String id = (String)session.getAttribute("m_id");
					
					MemberService memberService = new MemberService();
					MemberDTO memberDTO =  memberService.getMember(id);
					request.setAttribute("memberDTO", memberDTO);
					
					// ProductDTO productDTO = getBoard(request) 메서드 호출
					ProductDTO productDTO = productService.getproduct(request);
					
					// request에 "boardDTO",boardDTO 담아서
					request.setAttribute("productDTO", productDTO);
					 
					response.sendRedirect("tablet.po");
				}
		// -------------------------------------------------------------------------------
		
		if(sPath.equals("/productReg.po")) {
			System.out.println("뽑은 가상주소 비교 : /productReg.po");
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("m_id");
			
			MemberService memberService = new MemberService();
			MemberDTO memberDTO =  memberService.getMember(id);
			request.setAttribute("memberDTO", memberDTO);
			
			// 주소 변경 없이 이동 product/productReg.jsp
			dispatcher 
			    = request.getRequestDispatcher("product/productReg.jsp");
			dispatcher.forward(request, response);
			
		} // if
		
		if(sPath.equals("/productRegPro.po")) {
			System.out.println("뽑은 가상주소 비교 : /tablet.po");
			
			// ProductService 객체생성
			productService = new ProductService();
			// insertMember() 메서드 호출
			productService.insertProduct(request);
			
			
			//로그인 이동 => 주소변경하면서 이동
			response.sendRedirect("products.po");
			
		} // if
		
		// -------------------------------------------------------------------------------
		
		if(sPath.equals("/productUpdate.po")) {
			System.out.println("뽑은 가상주소 비교 : /productUpdate.po");
			//수정하기 전에 디비 나의 정보 조회(세션값 id) => jsp 화면 출력
			// 세션 객체생성
			HttpSession session = request.getSession();
			
			// "p_id" 세션값 가져오기=> String id 변수 저장
			String id = (String)session.getAttribute("m_id");
			
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
			System.out.println("뽑은 가상주소 비교 : /productUpdatePro.po");
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
			System.out.println("뽑은 가상주소 비교 : /delete.po");
			// BoardService 객체생성
			productService = new ProductService();
			
			// deleteBoard(request) 메서드 호출
			productService.deleteProduct(request);
			
			// 글목록 list.bo 주소 변경 되면서 이동
			response.sendRedirect("main.me");
			
		}//
		
		
		if(sPath.equals("/single.po")) {
			System.out.println("뽑은 가상주소 비교 : /single.po");
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("m_id");
			
			MemberService memberService = new MemberService();
			MemberDTO memberDTO =  memberService.getMember(id);
			request.setAttribute("memberDTO", memberDTO);
			
			// ProductService 객체생성
			productService = new ProductService();
			
			//조회수 증가 readcount 1증가
			// 리턴할형 없음  updateReadcount(request) 메서드 호출
			productService.updateReadcount(request);
			
			// ProductDTO productDTO = getBoard(request) 메서드 호출
			ProductDTO productDTO = productService.getproduct(request);
			
			// request에 "boardDTO",boardDTO 담아서
			request.setAttribute("productDTO", productDTO);
			
			dispatcher 
		    = request.getRequestDispatcher("product/single.jsp");
			dispatcher.forward(request, response);
		
		}//
		
		if(sPath.equals("/complete.po")) {
			
			// request안에 폼에서 입력한 수정할 값이 저장
			// ProductService 객체생성
			productService = new ProductService();
			
			productService.updateProduct2(request);
			
			response.sendRedirect("main.me");
			
		}//
		
		
		if(sPath.equals("/buylist.po")) {
			
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("m_id");
			
			MemberService memberService = new MemberService();
			MemberDTO memberDTO =  memberService.getMember(id);
			request.setAttribute("memberDTO", memberDTO);
			
			// ProductService 객체생성
			productService = new ProductService();
			
			// ProductDTO productDTO = getBoard(request) 메서드 호출
			// ProductDTO productDTO = productService.getproduct(request);
			
			// request에 "boardDTO",boardDTO 담아서
			//request.setAttribute("productDTO", productDTO);
			
			ProductDTO productDTO = new ProductDTO();
			
			String m_id = (String)session.getAttribute("m_id");
			String p_status = "거래완료";
			
			productDTO.setM_id(m_id);
			productDTO.setP_status(p_status);
			
			
			// List<ProductDTO> productList  =  getProductList2();메서드호출
			List<ProductDTO> productList = productService.getProductList2(productDTO);
			
			// request에 "productList", productList를 담기
			request.setAttribute("productList", productList);
			
			// product/buylist.jsp 주소변경 없이 이동
			dispatcher 
		    = request.getRequestDispatcher("product/buylist.jsp");
			dispatcher.forward(request, response);	
		
		}//
		
		
		
		
		// -----------------------------------------------------------------------------
		if (sPath.equals("/wishlist.po")) {
			System.out.println("뽑은 가상주소 비교222 : /wishlist.po");
			
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("m_id");
			
			MemberService memberService = new MemberService();
			MemberDTO memberDTO =  memberService.getMember(id);
			
			//ProductService productService = new ProductService();
			//ProductDTO productDTO = productService.getproduct(request);
		
			int p_pageSize=10;
			System.out.println("size"+p_pageSize);
			String p_pageNum=request.getParameter("p_pageNum");
			if(p_pageNum == null) {
				p_pageNum = "1";
			}
			int p_currentPage = Integer.parseInt(p_pageNum);
			ProductPageDTO ppageDTO = new ProductPageDTO();
			ppageDTO.setP_pageSize(p_pageSize);
			ppageDTO.setP_pageNum(p_pageNum);
			ppageDTO.setP_currentPage(p_currentPage);
			ppageDTO.setM_id(id);
			productService = new ProductService();
			List<WishListDTO> wishList=productService.getWishList(ppageDTO);
//			String orderBy = request.getParameter("ord");
//		    System.out.println("orderBy"+ orderBy);
//		    if(orderBy != null) {
//		    	if ("wishSell".equals(orderBy)) {
//			    	wishList = productService.getWishSellProducts(ppageDTO);
//			    } else if ("wishSold".equals(orderBy)) {
//			    	wishList = productService.getWishSoldProducts(ppageDTO);
//			    	
//			    } else {
//			        // 디폴트로 판매중으로 정렬
//			    	wishList = productService.getWishSellProducts(ppageDTO);
//			    }
//		    }	
		    int p_count = productService.getProductCount();
		    int p_pageBlock = 2;
		    int p_startPage=(p_currentPage-1)/p_pageBlock*p_pageBlock+1;
		    int p_endPage=p_startPage+p_pageBlock-1;
		    int p_pageCount = p_count / p_pageSize + (p_count % p_pageSize==0?0:1);
			if(p_endPage > p_pageCount) {
				p_endPage = p_pageCount;
			}
			ppageDTO.setP_count(p_count);
			ppageDTO.setP_pageBlock(p_pageBlock);
			ppageDTO.setP_startPage(p_startPage);
			ppageDTO.setP_endPage(p_endPage);
			ppageDTO.setP_pageCount(p_pageCount);
			
			System.out.println("스타트페이지 =" + p_startPage +", 페이지 블럭 = "+ p_pageBlock);
			System.out.println("현재페이지 =" + p_currentPage);
			request.setAttribute("wishList", wishList);
			request.setAttribute("ppageDTO", ppageDTO);
			//request.setAttribute("orderBy", orderBy);
			//request.setAttribute("productDTO", productDTO);
			request.setAttribute("memberDTO", memberDTO);
			
			dispatcher 
		    = request.getRequestDispatcher("product/wishlist.jsp");
		dispatcher.forward(request, response);
		}//wishlist.po
		

		if (sPath.equals("/productSearch.po")) {
			System.out.println("뽑은 가상 주소 비교 : /productSearch.po ");
			
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("m_id");
			System.out.println("m_id" + id);
			
			
			MemberService memberService = new MemberService();
			MemberDTO memberDTO =  memberService.getMember(id);
			
			ProductService productService = new ProductService();
			ProductDTO productDTO = productService.getproduct(request);
			
			request.setCharacterEncoding("utf-8");
			String search = request.getParameter("search");
			// 한페이지에서 보여지는 글개수 설정
			int p_pageSize=6;
			// 페이지번호 
			String p_pageNum=request.getParameter("p_pageNum");
			// 페이지번호가 없으면 1페이지 설정
			if(p_pageNum == null) {
				p_pageNum = "1";
			}
			// 페이지 번호를 => 정수형 변경
			int p_currentPage = Integer.parseInt(p_pageNum);
			
			ProductPageDTO ppageDTO = new ProductPageDTO();
			ppageDTO.setP_pageSize(p_pageSize);
			ppageDTO.setP_pageNum(p_pageNum);
			ppageDTO.setP_currentPage(p_currentPage);
			ppageDTO.setSearch(search);
			
			
			productService = new ProductService();
			List<ProductDTO> productList = productService.getProductListSearch(ppageDTO);
			
			int p_count = productService.getProductCount();
			int p_pageBlock = 3;
			int p_startPage=(p_currentPage-1)/p_pageBlock*p_pageBlock+1;
			int p_endPage=p_startPage+p_pageBlock-1;
			int p_pageCount = p_count / p_pageSize + (p_count % p_pageSize==0?0:1);
			if(p_endPage > p_pageCount) {
			p_endPage = p_pageCount;
			}
			
			//pageDTO 저장
			ppageDTO.setP_count(p_count);
			ppageDTO.setP_pageBlock(p_pageBlock);
			ppageDTO.setP_startPage(p_startPage);
			ppageDTO.setP_endPage(p_endPage);
			ppageDTO.setP_pageCount(p_pageCount);
			
			request.setAttribute("productList", productList);
			request.setAttribute("ppageDTO", ppageDTO);
			request.setAttribute("productDTO", productDTO);
			request.setAttribute("memberDTO", memberDTO);
			//System.out.println("m_num"+ memberDTO.getM_num());
			
			dispatcher
			= request.getRequestDispatcher("product/productSearch.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		
		
		}//doProcess()
	
	
	}//

