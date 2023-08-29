package com.itwillbs.service;

import javax.servlet.http.HttpServletRequest;

import com.itwillbs.dao.AdminDAO;

public class AdminService {
	AdminDAO adminDAO = null;
	
	public void testSave(HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		adminDAO = new AdminDAO();
		adminDAO.testSave(num,id);
	}

}
