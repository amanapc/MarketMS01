package com.qfedu.shop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.qfedu.shop.dao.ProviderDao;
import com.qfedu.shop.dao.impl.ProviderDaoImpl;

@WebServlet("/providerSimple.do")
public class ProviderSimpleServlet extends HttpServlet {
	
	private ProviderDao dao;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		dao = (ProviderDao) getServletContext().getAttribute("providerDaoInstance");
		if (dao == null) {
			dao = new ProviderDaoImpl();
			getServletContext().setAttribute("providerDaoInstance", dao);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("application/json");
			resp.getWriter().print(JSON.toJSONString(dao.selectSimple()));
			resp.getWriter().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
