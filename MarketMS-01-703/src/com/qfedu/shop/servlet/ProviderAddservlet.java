package com.qfedu.shop.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qfedu.shop.dao.ProviderDao;
import com.qfedu.shop.dao.impl.ProviderDaoImpl;
import com.qfedu.shop.pojo.Provider;

@WebServlet("/providerAdd.do")
public class ProviderAddservlet extends HttpServlet {
	
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取表单数据
		Provider provider = new Provider();
		try {
			BeanUtils.populate(provider, req.getParameterMap());
			
			int ret = dao.add(provider);
			
			resp.getWriter().print(ret);
			
		} catch (IllegalAccessException | InvocationTargetException | SQLException e) {
			resp.getWriter().println(e.getMessage());
			e.printStackTrace();
		} finally {
			resp.getWriter().close();
		}
	}
	
}
