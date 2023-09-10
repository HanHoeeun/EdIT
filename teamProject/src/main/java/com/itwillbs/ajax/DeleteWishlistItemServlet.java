package com.itwillbs.ajax;

import java.io.IOException;
import java.io.PrintWriter;
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

public class DeleteWishlistItemServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 System.out.println("Ajax 요청 처리 시작");
    	
    	// 클라이언트에서 전송한 w_num 값을 받아옴
        String w_numStr = request.getParameter("w_num");

        // w_num을 정수로 파싱
        int w_num = Integer.parseInt(w_numStr);

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

            // SQL 쿼리를 작성하여 찜 정보를 삭제
            String sql = "DELETE FROM wishlists WHERE w_p_num = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, w_num);

            // SQL 쿼리 실행
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                resultMessage = "success : 삭제되었습니다. ";
            
            } else {
                resultMessage = "error : 삭제되지 않았습니다. ";
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            resultMessage = "database_error";
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
