package com.qfedu.shop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.qfedu.shop.dao.BillDao;
import com.qfedu.shop.dao.impl.BillDaoImpl;

@WebServlet("/billAdmin.do")
public class BillAdminServlet extends HttpServlet {

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 查询所有的账单信息
		try {
			List<Map<String, Object>> list = dao.selectAll();
			
			String jstr = JSON.toJSONStringWithDateFormat(list, "yy/MM/dd hh:mm");
			
			resp.setContentType("application/json");
			resp.getWriter().print(jstr);
			resp.getWriter().close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}
