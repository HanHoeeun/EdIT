package com.itwillbs.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.dao.ChatDAO;
import com.itwillbs.service.ChatService;

public class ChatController extends HttpServlet{

	ChatService chatService = null;
	RequestDispatcher dispatcher = null;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("뽑아온 가상 주소 : " + sPath);
		
		
		if(sPath.equals("/box.ch")) {
			dispatcher = request.getRequestDispatcher("chat/box.jsp");
			dispatcher.forward(request, response);
		}
		if(sPath.equals("/chatUnread.ch")) {
			chatService = new ChatService();
			
			String result = chatService.getChatUnread(request);
			
			response.setContentType("text/html; charset=utf-8");
			
			response.getWriter().write(result);
		}
		
		if(sPath.equals("/chatBox.ch")) {
			chatService = new ChatService();
			
			String result = chatService.getChatBox(request);
			System.out.println(result);
			response.setContentType("text/html; charset=utf-8");
			
			response.getWriter().write(result);
			
		}
		
		if(sPath.equals("/chat.ch")) {
			dispatcher = request.getRequestDispatcher("chat/chat.jsp");
			dispatcher.forward(request, response);
		}
		
		if(sPath.equals("/chatList.ch")) {
			chatService = new ChatService();
			
			String result = chatService.getChatList(request);

			response.setContentType("text/html; charset=utf-8");
			
			response.getWriter().write(result);
			
		}
		
		if(sPath.equals("/chatSubmit.ch")) {
			chatService = new ChatService();
			
			String result = chatService.getChatSubmit(request);
			System.out.println("챗서블릿");
			response.setContentType("text/html; charset=utf-8");
			
			request.setCharacterEncoding("utf-8");
			
			response.getWriter().write(result);
		}
		
		
		if(sPath.equals("/chatDelete.ch")) {
			
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String userID =request.getParameter("userID");
			String toID =request.getParameter("toID");
			
			if(userID == null || userID.equals("") || toID == null || toID.equals("") ) {
				response.getWriter().write("0");
			}else {
				userID = URLDecoder.decode(userID, "utf-8");
				toID = URLDecoder.decode(toID, "utf-8");
				
				response.getWriter().write(new ChatDAO().chatDelete(userID, toID) + "");
			}
			
		}
	}

	
}
