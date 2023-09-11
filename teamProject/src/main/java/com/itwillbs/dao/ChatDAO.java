            package com.itwillbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.domain.ChatDTO;


public class ChatDAO {
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
	
//	마지막 메시지(기본은 0) 채팅 내역 호출 
	public ArrayList<ChatDTO> getChatListByID(String ch_fromID, String ch_toID, String ch_num){
		ArrayList<ChatDTO> chatList = null;
		try {
			con = this.getConnection();
//			내가 보낸 사람이던 받는 사람이던 간에 챗리스트를 가져온다 / 챗아이디 마지막챗아이디보다(기본은 0) 클떄 / 시간순으로 정렬
			String sql ="SELECT * "
					+ 	"FROM chat "
					+	"WHERE ((ch_fromID =? AND ch_toID =?) "
					+ 	"OR (ch_fromID =? AND ch_toID =?)) "
					+ 	"AND ch_num > ? "
					+ 	"ORDER BY ch_date";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ch_fromID);
			pstmt.setString(2, ch_toID);
			pstmt.setString(3, ch_toID);
			pstmt.setString(4, ch_fromID);
			pstmt.setInt(5, Integer.parseInt(ch_num));
			
			rs = pstmt.executeQuery();
			chatList = new ArrayList<>();
			while(rs.next()) {
				ChatDTO chatDTO = new ChatDTO();
				chatDTO.setCh_num(rs.getInt("ch_num"));
//				sql 인젝션 막기위해서 간단하게 치환
				chatDTO.setCh_fromID(rs.getString("ch_fromID").replaceAll(" ","&nbsp;").replaceAll("<", "&lt").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				chatDTO.setCh_toID(rs.getString("ch_toID").replaceAll(" ","&nbsp;").replaceAll("<", "&lt").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				chatDTO.setCh_content(rs.getString("ch_content").replaceAll(" ","&nbsp;").replaceAll("<", "&lt").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				int ch_date = Integer.parseInt(rs.getString("ch_date").substring(11, 13));
				String timeType= "오전";
				if(ch_date > 12) {
					timeType = "오후";
					ch_date = ch_date - 12;
				}
//				시간 정리
				chatDTO.setCh_date(rs.getString("ch_date").substring(0, 11)+ " " + timeType + " " + ch_date + ":" + rs.getString("ch_date").substring(14,16)+ "");
				chatList.add(chatDTO);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		return  chatList;
	}
//	최근 대화내용중 몇개만 뽑아서 출력하는거 82번 // 현재는 안쓰고 위에 getChatListByID 사용
	public ArrayList<ChatDTO> getChatListByRecent(String ch_fromID, String ch_toID, int number){
		ArrayList<ChatDTO> chatList = null;
		try {
			con = this.getConnection();

			String sql ="SELECT * "
					+ 	"FROM chat "
					+ 	"WHERE ((ch_fromID =? AND ch_toID =?) OR (ch_fromID =? AND ch_toID =?)) "
					+ 	"AND ch_num > (SELECT MAX(ch_num) - ? "
					+ 	"			   FROM chat "
					+   "			   WHERE (ch_fromID = ? AND ch_toID = ?) OR (ch_fromID = ? AND ch_toID = ?)) "
					+ 	"ORDER BY ch_date";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ch_fromID);
			pstmt.setString(2, ch_toID);
			pstmt.setString(3, ch_toID);
			pstmt.setString(4, ch_fromID);
			pstmt.setInt(5, number);
			pstmt.setString(6, ch_fromID);
			pstmt.setString(7, ch_toID);
			pstmt.setString(8, ch_toID);
			pstmt.setString(9, ch_fromID);
			
			rs = pstmt.executeQuery();
			chatList = new ArrayList<>();
			while(rs.next()) {
				ChatDTO chatDTO = new ChatDTO();
				chatDTO.setCh_num(rs.getInt("ch_num"));
				chatDTO.setCh_fromID(rs.getString("ch_fromID").replaceAll(" ","&nbsp;").replaceAll("<", "&lt").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				chatDTO.setCh_toID(rs.getString("ch_toID").replaceAll(" ","&nbsp;").replaceAll("<", "&lt").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				chatDTO.setCh_content(rs.getString("ch_content").replaceAll(" ","&nbsp;").replaceAll("<", "&lt").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				int ch_date = Integer.parseInt(rs.getString("ch_date").substring(11, 13));
				String timeType= "오전";
				if(ch_date > 12) {
					timeType = "오후";
					ch_date = ch_date-12;
				}
//				시간 정리
				chatDTO.setCh_date(rs.getString("ch_date").substring(0, 11)+ " " + timeType + " " + ch_date + ":" + rs.getString("ch_date").substring(14,16)+ "");
				chatList.add(chatDTO);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		return  chatList;
	}
//	채팅 전송 메서드
	public int submit(String ch_fromID, String ch_toID, String ch_content){
		try {
			con = this.getConnection();

			String sql = "INSERT INTO chat "
					+ 	 "VALUES (DEFAULT, ?, ?, ?, NOW(), 0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ch_fromID);
			pstmt.setString(2, ch_toID);
			pstmt.setString(3, ch_content);
//			성공으로 반환되면 1 반환 
			return pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		return  -1;
	}
	
//	채팅방에 들어가면 읽음 표시 처리
	public int readChat(String ch_fromID, String ch_toID) {
		try {
			con = this.getConnection();
			String sql = "UPDATE chat "
					+ 	 "SET ch_read = 1 "
					+ 	 "WHERE (ch_fromID = ? AND ch_toID = ?)";
			pstmt = con.prepareStatement(sql);
//			바꿔서 넣는 이유는 상대방이 읽었음을 표시하기 위해서 
			pstmt.setString(1, ch_toID);
			pstmt.setString(2, ch_fromID);
			
			return pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		return -1;
	}
	
//	현재 읽지 않은 모든 메시지의 갯수를 반환 
	public int getAllUnreadChat(String m_id) {
		try {
			con = this.getConnection();
			String sql = "SELECT COUNT(ch_num) AS COUNT "
					+ 	 "FROM chat "
					+ 	 "WHERE ch_toID =? AND ch_read = 0";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m_id);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("COUNT");
			}else {
				return 0; // 받은 메시지가 없다
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		return -1;
	}
	
//	채팅방 리스트 호출 
	public ArrayList<ChatDTO> getBox(String m_id){
		ArrayList<ChatDTO> chatList = null;
		try {
			con = this.getConnection();

//			내가 보냈거나 받은 메시지중 최근걸 호출
			String sql = "SELECT * " 
				+		 "FROM chat " 
				+		 "WHERE ch_num IN (SELECT MAX(ch_num) " 
				+		 "				   FROM chat " 
				+	     "				   WHERE ch_toID = ? OR ch_fromID = ? " 
				+	     "				   GROUP BY ch_fromID, ch_toID)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_id);
			
			rs = pstmt.executeQuery();
			chatList = new ArrayList<>();
			while(rs.next()) {
				ChatDTO chatDTO = new ChatDTO();
				chatDTO.setCh_num(rs.getInt("ch_num"));
				chatDTO.setCh_fromID(rs.getString("ch_fromID").replaceAll(" ","&nbsp;").replaceAll("<", "&lt").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				chatDTO.setCh_toID(rs.getString("ch_toID").replaceAll(" ","&nbsp;").replaceAll("<", "&lt").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				chatDTO.setCh_content(rs.getString("ch_content").replaceAll(" ","&nbsp;").replaceAll("<", "&lt").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				int ch_date = Integer.parseInt(rs.getString("ch_date").substring(11, 13));
				String timeType= "오전";
				if(ch_date > 12) {
					timeType = "오후";
					ch_date = ch_date-12;
				}
//				시간 정리
				chatDTO.setCh_date(rs.getString("ch_date").substring(0, 11)+ " " + timeType + " " + ch_date + ":" + rs.getString("ch_date").substring(14,16)+ "");
				chatList.add(chatDTO);
			}
//			번호 발신자 수신자 내용 시간
//			2   111  123     8시		이 두개의 데이터를 비교하여 더 최근인 3을 남겨두고 2는 지운다
//			3   123  111     9시	
			for(int i = 0; i < chatList.size(); i++) {
				ChatDTO x = chatList.get(i);
				for(int j = 0; j < chatList.size(); j++) {
					ChatDTO y = chatList.get(j);
					if(x.getCh_fromID().equals(y.getCh_toID()) && x.getCh_toID().equals(y.getCh_fromID())) {
						if(x.getCh_num() < y.getCh_num()) {
							chatList.remove(x);
							i--;
							break;
						}else {
							chatList.remove(y);
							j--;
						}
					}
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		return  chatList;
	}
//	대화상대별 안 읽은 메시지 출력 
	public int getUnreadChat(String ch_fromID, String ch_toID) {
		try {
			con = this.getConnection();
			String sql = "SELECT COUNT(ch_num) AS COUNT "
					+    "FROM chat "
					+    "WHERE ch_fromID =? AND ch_toID = ? AND ch_read = 0";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, ch_fromID);
			pstmt.setString(2, ch_toID);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("COUNT");
			}else {
				return 0; // 받은 메시지가 없다
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbClose();
		}
		return -1;
	}
	public int chatDelete(String m_id, String ch_toID) {
		try {
			con = this.getConnection();
			String sql = "DELETE FROM chat "
					+ 	 "WHERE (ch_fromID = ? AND ch_toID = ?) OR (ch_fromID = ? AND ch_toID = ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m_id);
			pstmt.setString(2, ch_toID);
			pstmt.setString(3, ch_toID);
			pstmt.setString(4, m_id);
			
			
			return pstmt.executeUpdate();
			
		}catch (Exception e) {

		}finally {
			this.dbClose();
		}
		
		
		return -1;
	}
}
