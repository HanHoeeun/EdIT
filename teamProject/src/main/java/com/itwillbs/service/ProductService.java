package com.itwillbs.service;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.dao.ProductDAO;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.ProductDTO;
import com.itwillbs.domain.ProductPageDTO;
import com.itwillbs.domain.WishListDTO;

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

	public List<ProductDTO> getLatestProducts(ProductPageDTO ppageDTO) {
		List<ProductDTO> latestList = null;
		System.out.println("ProductService getLatestProducts()");
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();	
			// DAO에서 데이터 가져오기
			latestList =productDAO.getLatestProducts(ppageDTO); 
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
	
	// 전체상품보기 내 판매중인 상품
	public List<ProductDTO> getSellProducts(ProductPageDTO ppageDTO) {
		System.out.println("ProductService getSellProducts()");
		List<ProductDTO> sellList = null;
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();
			// DAO에서 데이터 가져오기
			sellList=productDAO.getSellProducts(ppageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellList;
	}

	// 전체상품보기 내 판매완료인 상품
	public List<ProductDTO> getSoldProducts(ProductPageDTO ppageDTO) {
		System.out.println("ProductService getSoldProducts()");
		List<ProductDTO> soldList = null;
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();
			// DAO에서 데이터 가져오기
			soldList=productDAO.getSoldProducts(ppageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soldList;
	}
	
	// 노트북 중 최신순
		public List<ProductDTO> getLaptopLatestProducts(ProductPageDTO ppageDTO) {
			List<ProductDTO>	laptopLatestList = null;
			System.out.println("ProductService getLatestProducts()");
			try {
				// productDAO 객체생성
				productDAO = new ProductDAO();	
				// DAO에서 데이터 가져오기
				laptopLatestList =productDAO.getLaptopLatestProducts(ppageDTO); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return laptopLatestList;
		}

		// 노트북 중 인기순
		public List<ProductDTO> getLaptopPopularProducts(ProductPageDTO ppageDTO) {
			List<ProductDTO>	laptopPopularList = null;
			System.out.println("ProductService getLaptopPopularProducts()");
			try {
				// productDAO 객체생성
				productDAO = new ProductDAO();	
				// DAO에서 데이터 가져오기
				laptopPopularList =productDAO.getLaptopPopularProducts(ppageDTO); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return laptopPopularList;
		}

		// 노트북 중 가격 높은 순
		public List<ProductDTO> getLaptopHighPriceProducts(ProductPageDTO ppageDTO) {
			List<ProductDTO>	laptopHighPriceList = null;
			System.out.println("ProductService getLaptopHighPriceProducts()");
			try {
				// productDAO 객체생성
				productDAO = new ProductDAO();	
				// DAO에서 데이터 가져오기
				laptopHighPriceList =productDAO.getLaptopHighPriceProducts(ppageDTO); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return laptopHighPriceList;
		}

		// 노트북 중 가격낮은순
		public List<ProductDTO> getLaptopLowPriceProducts(ProductPageDTO ppageDTO) {
			List<ProductDTO>	laptopLowPriceList = null;
			System.out.println("ProductService getLaptopLowPriceProducts()");
			try {
				// productDAO 객체생성
				productDAO = new ProductDAO();	
				// DAO에서 데이터 가져오기
				laptopLowPriceList =productDAO.getLaptopLowPriceProducts(ppageDTO); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return laptopLowPriceList;
		}
	
	// 노트북 내에 판매중인 상품 검색 
	public List<ProductDTO> getLaptopSellProducts(ProductPageDTO ppageDTO) {
		System.out.println("ProductService getLaptopSellProducts()");
		List<ProductDTO> sellList = null;
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();
			// DAO에서 데이터 가져오기
			sellList=productDAO.getLaptopSellProducts(ppageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellList;
	}

	// 노트북 내에 판매완료된 상품 검색 
	public List<ProductDTO> getLaptopSoldProducts(ProductPageDTO ppageDTO) {
		System.out.println("ProductService getLaptopSoldProducts()");
		List<ProductDTO> soldList = null;
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();
			// DAO에서 데이터 가져오기
			soldList=productDAO.getLaptopSoldProducts(ppageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soldList;
	}
	
	// 폰 중 최신순
	public List<ProductDTO> getPhoneLatestProducts(ProductPageDTO ppageDTO) {
		List<ProductDTO>	phoneLatestList = null;
		System.out.println("ProductService getPhoneLatestProducts()");
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();	
			// DAO에서 데이터 가져오기
			phoneLatestList =productDAO.getPhoneLatestProducts(ppageDTO); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phoneLatestList;
	}
	
	// 폰 중 인기순
	public List<ProductDTO> getPhonePopularProducts(ProductPageDTO ppageDTO) {
		List<ProductDTO>	phonePopularList = null;
		System.out.println("ProductService getPhonePopularProducts()");
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();	
			// DAO에서 데이터 가져오기
			phonePopularList =productDAO.getPhonePopularProducts(ppageDTO); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phonePopularList;
	}
	
	// 폰 중 가격높은 순
	public List<ProductDTO> getPhoneHighPriceProducts(ProductPageDTO ppageDTO) {
		List<ProductDTO>	phoneHighPriceList = null;
		System.out.println("ProductService getPhoneHighPriceProducts()");
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();	
			// DAO에서 데이터 가져오기
			phoneHighPriceList =productDAO.getPhoneHighPriceProducts(ppageDTO); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phoneHighPriceList;
	}
	
	// 폰 중 가격낮은 순
	public List<ProductDTO> getPhoneLowPriceProducts(ProductPageDTO ppageDTO) {
		List<ProductDTO>	phoneLowPriceList = null;
		System.out.println("ProductService getPhoneLowPriceProducts()");
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();	
			// DAO에서 데이터 가져오기
			phoneLowPriceList =productDAO.getPhoneLowPriceProducts(ppageDTO); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phoneLowPriceList;
	}
	
	// 폰페이지 내에 판매중인 상품 검색 
	public List<ProductDTO> getPhoneSellProducts(ProductPageDTO ppageDTO) {
		System.out.println("ProductService getPhoneSellProducts()");
		List<ProductDTO> sellList = null;
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();
			// DAO에서 데이터 가져오기
			sellList=productDAO.getPhoneSellProducts(ppageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellList;
	}

	// 폰페이지 내에 판매완료된 상품 검색 
	public List<ProductDTO> getPhoneSoldProducts(ProductPageDTO ppageDTO) {
		System.out.println("ProductService getPhoneSoldProducts()");
		List<ProductDTO> soldList = null;
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();
			// DAO에서 데이터 가져오기
			soldList=productDAO.getPhoneSoldProducts(ppageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soldList;
	}
	
	
	
	// 태블릿 중 최신순
		public List<ProductDTO> getTabletLatestProducts(ProductPageDTO ppageDTO) {
			List<ProductDTO>	tabletLatestList = null;
			System.out.println("ProductService getTabletLatestProducts()");
			try {
				// productDAO 객체생성
				productDAO = new ProductDAO();	
				// DAO에서 데이터 가져오기
				tabletLatestList =productDAO.getTabletLatestProducts(ppageDTO); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tabletLatestList;
		}

		// 태블릿 중 인기순
		public List<ProductDTO> getTabletPopularProducts(ProductPageDTO ppageDTO) {
			List<ProductDTO>	tabletPopularList = null;
			System.out.println("ProductService getTabletPopularProducts()");
			try {
				// productDAO 객체생성
				productDAO = new ProductDAO();	
				// DAO에서 데이터 가져오기
				tabletPopularList =productDAO.getTabletPopularProducts(ppageDTO); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tabletPopularList;
		}


		// 태블릿 중 가격높은 순
		public List<ProductDTO> getTabletHighPriceProducts(ProductPageDTO ppageDTO) {
			List<ProductDTO>	tabletHighPriceList = null;
			System.out.println("ProductService getTabletHighPriceProducts()");
			try {
				// productDAO 객체생성
				productDAO = new ProductDAO();	
				// DAO에서 데이터 가져오기
				tabletHighPriceList =productDAO.getTabletHighPriceProducts(ppageDTO); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tabletHighPriceList;
		}

		// 태블릿 중 가격낮은 순
		public List<ProductDTO> getTabletLowPriceProducts(ProductPageDTO ppageDTO) {
			List<ProductDTO>	tabletLowPriceList = null;
			System.out.println("ProductService getTabletLowPriceProducts()");
			try {
				// productDAO 객체생성
				productDAO = new ProductDAO();	
				// DAO에서 데이터 가져오기
				tabletLowPriceList =productDAO.getTabletLowPriceProducts(ppageDTO); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tabletLowPriceList;
		}
		
		// 태블릿페이지 내에 판매중인 상품 검색 
		public List<ProductDTO> getTabletSellProducts(ProductPageDTO ppageDTO) {
			System.out.println("ProductService getTabletSellProducts()");
			List<ProductDTO> sellList = null;
			try {
				// productDAO 객체생성
				productDAO = new ProductDAO();
				// DAO에서 데이터 가져오기
				sellList=productDAO.getTabletSellProducts(ppageDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return sellList;
		}
		
		// 태블릿페이지 내에 판매완료된 상품 검색 
		public List<ProductDTO> getTabletSoldProducts(ProductPageDTO ppageDTO) {
			System.out.println("ProductService getTabletSoldProducts()");
			List<ProductDTO> soldList = null;
			try {
				// productDAO 객체생성
				productDAO = new ProductDAO();
				// DAO에서 데이터 가져오기
				soldList=productDAO.getTabletSoldProducts(ppageDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return soldList;
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
	}	//getLaptopList
	
	public List<ProductDTO> getPhoneList(ProductPageDTO ppageDTO) {
		System.out.println("productService getPhoneList()");
		List<ProductDTO> phoneList = null;
		try {
			int p_startRow = (ppageDTO.getP_currentPage()-1)*ppageDTO.getP_pageSize()+1;
			int p_endRow = p_startRow+ppageDTO.getP_pageSize()-1;
			ppageDTO.setP_startRow(p_startRow);
			ppageDTO.setP_endRow(p_endRow);
			productDAO = new ProductDAO();
			phoneList = productDAO.getPhoneList(ppageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phoneList;
	}//getPhoneList
	
	public List<ProductDTO> getTabletList(ProductPageDTO ppageDTO) {
		System.out.println("productService getTabletList()");
		List<ProductDTO> tabletList = null;
		try {
			int p_startRow = (ppageDTO.getP_currentPage()-1)*ppageDTO.getP_pageSize()+1;
			int p_endRow = p_startRow+ppageDTO.getP_pageSize()-1;
			ppageDTO.setP_startRow(p_startRow);
			ppageDTO.setP_endRow(p_endRow);
			productDAO = new ProductDAO();
			tabletList = productDAO.getTabletList(ppageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tabletList;
	}//getTabletList
	

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
			String m_nick = multi.getParameter("m_nick");
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
			productDTO.setM_nick(m_nick);
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



// -----------------------------------------------------------------




	public List<WishListDTO> getWishSellProducts(ProductPageDTO ppageDTO) {
		System.out.println("ProductService getWishSellProducts()");
		List<WishListDTO> sellList = null;
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();
			// DAO에서 데이터 가져오기
			sellList=productDAO.getWishSellProducts(ppageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellList;
	}


	public List<WishListDTO> getWishSoldProducts(ProductPageDTO ppageDTO) {
		System.out.println("ProductService getWishSoldProducts()");
		List<WishListDTO> soldList = null;
		try {
			// productDAO 객체생성
			productDAO = new ProductDAO();
			// DAO에서 데이터 가져오기
			soldList=productDAO.getWishSoldProducts(ppageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soldList;
	}


	public List<WishListDTO> getWishList(ProductPageDTO ppageDTO) {
		System.out.println("productService getWishList()");
		List<WishListDTO> wishList = null;
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
			wishList = productDAO.getWishList(ppageDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wishList;
	
}// get



	public MemberDTO getmember(HttpServletRequest request) {
		MemberDTO memberDTO = null;
		try {
			// request 한글처리
			request.setCharacterEncoding("utf-8");
			
			// request 파라미터 가져오기 => int num 저장
			int n_num = Integer.parseInt(request.getParameter("n_num"));
			
			// BoardDAO 객체생성
			productDAO = new ProductDAO();
			
			// boardDTO = getBoard(num) 메서드 호출
			memberDTO = productDAO.getmember(n_num);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberDTO;
	}



	

	


	
	
	
	
	
	
	
}
