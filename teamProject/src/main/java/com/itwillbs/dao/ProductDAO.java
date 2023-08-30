package com.itwillbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.domain.ProductDTO;

public class ProductDAO {

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs =null;
	
	//1,2 단계 디비 연결 메서드  정의 => 필요로 할때 호출 사용
		public Connection getConnection() throws Exception {
			Context init = new InitialContext();
			DataSource ds=
			(DataSource)init.lookup("java:comp/env/jdbc/c1d2304t4");
			con=ds.getConnection();
			return con;
		}
		//기억장소 해제 메서드()
		public void dbClose() {
			//  => con, pstmt, rs 기억장소 해제
			if(rs != null) {try {rs.close();} catch (SQLException e) {	}}			
			if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {	}}
			if(con != null) {try {con.close();} catch (SQLException e) {	}}
		}
	
	// -------------------------------------------------------------------------------------------
	
	public int getMaxNum() {
		
		int num = 0;
		try {
			//1,2 디비연결
			con=getConnection();
			//3 sql select max(num) from members
			String sql = "select max(p_num) from products;";
			pstmt=con.prepareStatement(sql);
			//4 실행 => 결과저장
			rs =pstmt.executeQuery();
			//5 if 다음행  => 열데이터 가져와서 => num저장
			if(rs.next()) {
				num = rs.getInt("max(p_num)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			dbClose();
			
		}
		return num;
	}//getMaxNum()
	
	
	public void insertProduct(ProductDTO productDTO) {
		
		try {
			//1,2단계 디비연결
			con = getConnection();
			//3 sql 구문 insert
			String sql="insert into products(p_num, p_title, p_type, p_price, p_detail, p_date, p_readcount, p_status, p_file) values(?,?,?,?,?,?,?,?,?)";
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, productDTO.getP_num());
			pstmt.setString(2, productDTO.getP_title());
			pstmt.setString(3, productDTO.getP_type());
			pstmt.setInt(4, productDTO.getP_price());
			pstmt.setString(5, productDTO.getP_detail());
			pstmt.setTimestamp(6, productDTO.getP_date());
			pstmt.setInt(7, productDTO.getP_readcount());
			pstmt.setString(8, productDTO.getP_status());
			pstmt.setString(9, productDTO.getP_file());
			
			//4 실행
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			dbClose();
			
		}
		
	}//insertMember()
	
	
	
	//-----------------------------------------------------------------------------------------------------
	
	public void updateProduct(ProductDTO productDTO) {
		try {
			System.out.println("업데이트 디에오");
			con = getConnection();
			
			//3 sql "update products set p_title=?, p_type=?, p_price=?, p_detail=?, p_date=?, p_status=?, p_file=? where p_num=?";
			String sql="update products set p_title=?, p_type=?, p_price=?, p_detail=?, p_date=?, p_status=?, p_file=? where p_num=?";
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, productDTO.getP_title());
			pstmt.setString(2, productDTO.getP_type());
			pstmt.setInt(3, productDTO.getP_price());
			pstmt.setString(4, productDTO.getP_detail());
			pstmt.setTimestamp(5, productDTO.getP_date());
			pstmt.setString(6, productDTO.getP_status());
			pstmt.setString(7, productDTO.getP_file());
			pstmt.setInt(8, productDTO.getP_num());
			
			//4 실행
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			dbClose();
		}
		
	}//updateBoard
	
	public ProductDTO getproduct(int p_num) {
		ProductDTO productDTO = null;
		
		try {
			con = getConnection();
			
			//3 sql select * from board where num = ?
			String sql="select * from products where p_num = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, p_num);
			
			//4 실행 => 결과 저장
			rs = pstmt.executeQuery();
			//5 결과 행접근 => boardDTO 객체생성 
			//        => set메서드 호출 => 열접근 데이터 저장
			
			if(rs.next()) {
				
				productDTO = new ProductDTO();
				
				productDTO.setP_num(rs.getInt("p_num"));
				productDTO.setP_title(rs.getString("p_title"));
				productDTO.setP_type(rs.getString("p_type"));
				productDTO.setP_price(rs.getInt("p_price"));
				productDTO.setP_detail(rs.getString("p_detail"));
				productDTO.setP_date(rs.getTimestamp("p_date"));
				productDTO.setP_readcount(rs.getInt("p_readcount"));
				productDTO.setP_status(rs.getString("p_status"));
				//첨부파일
				productDTO.setP_file(rs.getString("p_file"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return productDTO;
		
	}// getproduct
	
	// -----------------------------------------------------------------------------------------------------------------
	
	public void deleteProduct(int p_num) {
		try {
			//1,2 디비연결
			con = getConnection();
			
			//3 sql delete from board where num=?
			String sql="delete from products where p_num=?";
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, p_num);
			
			//4 실행
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			dbClose();
		}
		
	}//deleteBoard()
	
	
	
} // class
