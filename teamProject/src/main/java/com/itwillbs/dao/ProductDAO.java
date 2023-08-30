package com.itwillbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.domain.ProductDTO;
import com.itwillbs.domain.ProductPageDTO;

public class ProductDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//1,2 단계 디비 연결 메서드  정의 => 필요로 할때 호출 사용
	public Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds= (DataSource)init.lookup("java:comp/env/jdbc/c1d2304t4");
		con=ds.getConnection();
		return con;
	}
	
	// 기억장소 해제 매서드()
	public void dbClose() {
	//  => con, pstmt, rs 기억장소 해제
		if(rs != null) {try {rs.close();} catch (SQLException e) {	}}			
		if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {	}}
		if(con != null) {try {con.close();} catch (SQLException e) {	}}
	}

	public List<ProductDTO> getProductList(ProductPageDTO ppageDTO) {
		System.out.println("ProductDAO getProductList()");
		List<ProductDTO> productList = new ArrayList<>(); 
		int size = productList.size();
		try {
			//1,2 단계 디비 연
			con = getConnection();
			//3 sql  => mysql 제공 => limit 시작행-1, 몇개
//			String sql="select * from board order by num desc";
			String sql="select * from products order by p_num desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ppageDTO.getP_startRow()-1);//시작행-1
			pstmt.setInt(2, ppageDTO.getP_pageSize());//몇개
			//4 실행 => 결과 저장
			rs = pstmt.executeQuery();
			// boardList 객체생성
			productList = new ArrayList<>();
			size = productList.size();
			//5 결과 행접근 => BoardDTO객체생성 => set호출(열접근저장)
			// => 배열 한칸에 저장
			while(rs.next()) {
				ProductDTO productDTO =new ProductDTO();
				productDTO.setP_num(rs.getInt("p_num"));
				productDTO.setP_title(rs.getString("p_title"));
				productDTO.setP_type(rs.getString("p_type"));
				productDTO.setP_price(rs.getInt("p_price"));
				productDTO.setP_status(rs.getString("p_status"));
				// => 배열 한칸에 저장
				productList.add(productDTO); 
		}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return productList;
		}//getProductList;

	public int getProductCount() {
		int p_count = 0;
		try {
			//1,2 디비연결
			con=getConnection();
			//3 sql select count(*) from products
			String sql = "select count(*) from products;";
			pstmt=con.prepareStatement(sql);
			//4 실행 => 결과저장
			rs = pstmt.executeQuery();
			//5 결과 행접근 => 열접근 => count변수 저장
			if(rs.next()) {
				p_count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return p_count;
	}
		

}