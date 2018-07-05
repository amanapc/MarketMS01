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

@WebServlet("/providerModify.do")
public class ProviderModifyServlet extends HttpServlet {

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
		String flag = req.getParameter("flag");
		int ret = 0;
		if ("update".equals(flag)) {
			System.out.println(this + flag);
			Provider provider = new Provider();
			try {
				BeanUtils.populate(provider, req.getParameterMap());
				ret = dao.update(provider);
				
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else if ("delete".equals(flag)) {
			System.out.println(this + flag);
			try {
				ret = dao.deleteById(req.getParameter("id"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		resp.getWriter().print(ret);
		resp.getWriter().close();
	}
	
}
