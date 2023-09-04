package com.itwillbs.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class AddToWishlistServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Ajax 요청 처리 시작");
		
        // p_num과 m_num을 클라이언트에서 받아온다
        String p_numStr = request.getParameter("w_p_num");
        String m_numStr = request.getParameter("w_m_num");

        // 결과 메시지 초기화
        String resultMessage = "";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
        	
            // 컨텍스트에서 데이터 소스 가져오기
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/c1d2304t4");

            // 데이터베이스 연결
            conn = ds.getConnection();

            // SQL 쿼리를 작성하여 찜 정보를 추가
            String sql = "INSERT INTO wishlists (w_p_num, w_m_num) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);

            // p_num과 m_num을 정수로 파싱하여 설정
            int w_p_num = Integer.parseInt(p_numStr);
            int w_m_num = Integer.parseInt(m_numStr);
            pstmt.setInt(1, w_p_num);
            pstmt.setInt(2, w_m_num);

            // SQL 쿼리 실행
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                resultMessage = "Success: 찜이 추가되었습니다.";
            } else {
                resultMessage = "Error: 찜을 추가하지 못했습니다.";
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            resultMessage = "Error: 데이터베이스 오류 발생 - " + e.getMessage(); // 더 구체적인 오류 메시지 반환
        } finally {
            // 자원 해제
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 결과 메시지를 클라이언트에게 응답으로 보냄
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(resultMessage);
        out.close();
        
        System.out.println("Ajax 요청 처리 완료");
	}
}
