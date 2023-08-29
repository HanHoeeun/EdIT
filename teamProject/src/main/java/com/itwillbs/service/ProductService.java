package com.itwillbs.service;

import java.util.List;

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
	
	// registerProduct 넣기

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
	
	
}
