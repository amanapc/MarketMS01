package com.qfedu.shop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.shop.dao.BillDao;
import com.qfedu.shop.dao.impl.BillDaoImpl;

@WebServlet("/billModify.do")
public class BillModifyServlet extends HttpServlet{
	
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
		String flag = req.getParameter("flag");
		int ret = 0;
		if ("update".equals(flag)) {
			
			try {
				ret = dao.update(req.getParameterMap());
				resp.getWriter().print(ret);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else if ("delete".equals(flag)) {
			try {
				ret =dao.deleteById(req.getParameter("id"));
				resp.getWriter().print(ret);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
