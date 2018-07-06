package com.qfedu.shop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.shop.dao.BillDao;
import com.qfedu.shop.dao.impl.BillDaoImpl;

@WebServlet("/billAdd.do")
public class BillAddServlet extends HttpServlet {
	
	private BillDao dao;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		dao = (BillDao) getServletContext().getAttribute("billDaoInstance");
		if (dao == null) {
			dao = new BillDaoImpl();
			getServletContext().setAttribute("billDaoInstance", dao);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> paramsMap = req.getParameterMap();
		
		try {
			dao.add(paramsMap);
			
			resp.sendRedirect("admin_bill_list.html");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
