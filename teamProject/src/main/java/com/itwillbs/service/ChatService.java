package com.itwillbs.service;

import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.itwillbs.dao.ChatDAO;
import com.itwillbs.domain.ChatDTO;


public class ChatService {
	ChatDAO chatDAO = null;
	
	public String getChatUnread(HttpServletRequest request) {
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			String m_id =request.getParameter("m_id");
			
			if(m_id == null || m_id.equals("")) {
				result = "0";
			}else {
				m_id = URLDecoder.decode(m_id, "utf-8");
				result = new ChatDAO().getAllUnreadChat(m_id)+"";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String getChatBox(HttpServletRequest request) {
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			String m_id =request.getParameter("m_id");
			
			System.out.println(URLDecoder.decode(m_id, "utf-8"));
			if(m_id == null || m_id.equals("")) {
				return result;
			}else {
				try {
					m_id = URLDecoder.decode(m_id, "utf-8");
					result = this.getBox(m_id);
					return result;
				}catch (Exception e) {
					return result;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public String getBox(String m_id) {
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		ChatDAO chatDAO = new ChatDAO();
		ArrayList<ChatDTO> chatList = chatDAO.getBox(m_id);
		
		if(chatList.size() == 0) {
			return "";
		}
		for(int i=chatList.size()-1; i >= 0; i--) {
			String unread ="";
			if(m_id.equals(chatList.get(i).getCh_toID())) {
				unread = chatDAO.getUnreadChat(chatList.get(i).getCh_fromID(), m_id)+ "";
				if(unread.equals("0")) {
					unread = "";
				}
			}
			result.append("[{\"value\": \"" + chatList.get(i).getCh_fromID() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getCh_toID() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getCh_content() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getCh_date() + "\"},");
			result.append("{\"value\": \"" + unread + "\"}]");
//				마지막 원소가 아니면 그다음 원소가 있기떄문에 , 
			if(i != 0 ) {
				result.append(",");
			}
		}
		result.append("], \"last\":\"" + chatList.get(chatList.size() -1).getCh_num() + "\"}");
		return result.toString();
	}
	
	public String getChatList(HttpServletRequest request) {
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			String ch_fromID =request.getParameter("ch_fromID");
			String ch_toID =request.getParameter("ch_toID");
			String listType = request.getParameter("listType");
			
			if(ch_fromID == null || ch_fromID.equals("") || ch_toID == null || ch_toID.equals("") || listType == null || listType.equals("")) {
				result = "";
			}else {
				try {
//					특정한 채팅아이디를 기준으로 채팅을 가져온다
					result = this.getID(URLDecoder.decode(ch_fromID,"utf-8"), URLDecoder.decode(ch_toID,"utf-8"), listType);
				} catch (Exception e) {
					result = "";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String getID(String ch_fromID, String ch_toID, String ch_num) {
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		chatDAO = new ChatDAO();
		ArrayList<ChatDTO> chatList = chatDAO.getChatListByID(ch_fromID, ch_toID, ch_num);
		
		if(chatList.size() == 0) {
			return "";
		}
		for(int i=0; i<chatList.size(); i++) {
			result.append("[{\"value\": \"" + chatList.get(i).getCh_fromID() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getCh_toID() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getCh_content() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getCh_date() + "\"}]");
//			마지막 원소가 아니면 그다음 원소가 있기떄문에 , 
			if(i != chatList.size() -1 ) {
				result.append(",");
			}
		}
		result.append("], \"last\":\"" + chatList.get(chatList.size() -1).getCh_num() + "\"}");
		
		chatDAO.readChat(ch_fromID, ch_toID); // 다읽었음
		
		return result.toString();
	}

	public String getChatSubmit(HttpServletRequest request) {
		String result ="";
		try {
			request.setCharacterEncoding("utf-8");
			String ch_fromID =request.getParameter("ch_fromID");
			String ch_toID =request.getParameter("ch_toID");
			String ch_content =request.getParameter("ch_content");
			
			System.out.println("챗 서비스 :" + URLDecoder.decode(ch_fromID, "utf-8" ));
			System.out.println("챗 서비스 :" + URLDecoder.decode(ch_toID, "utf-8" ));
			System.out.println("챗 서비스 :" + URLDecoder.decode(ch_content, "utf-8" ));
			
			if(ch_fromID == null || ch_fromID.equals("") || ch_toID == null || ch_toID.equals("") || ch_content == null || ch_content.equals("")) {
				result = "0";
			}else if(ch_fromID.equals(ch_toID)) {
				result = "-1";
			}else {
				ch_fromID = URLDecoder.decode(ch_fromID, "utf-8");
				ch_toID = URLDecoder.decode(ch_toID, "utf-8");
				ch_content = URLDecoder.decode(ch_content, "utf-8");
				result = new ChatDAO().submit(ch_fromID, ch_toID, ch_content) + "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	
	
	

	
}
