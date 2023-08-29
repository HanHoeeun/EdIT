package com.itwillbs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.service.AdminService;

public class AdminController extends HttpServlet{
	RequestDispatcher dispatcher = null;
	AdminService adminService = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductController doProcess()");
		// 가상주소 뽑아오기
		String sPath=request.getServletPath();
		System.out.println("뽑은 가상주소 :  " + sPath);
		if(sPath.equals("/faq.ad")) {
			dispatcher = request.getRequestDispatcher("admin/faq_1_1.jsp");
			dispatcher.forward(request, response);
				
		}
		if(sPath.equals("admin/test123.ad")) {
			adminService = new AdminService();
			adminService.testSave(request);
			
		}
	}

	
}
