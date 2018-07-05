package com.qfedu.shop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.qfedu.shop.dao.ProviderDao;
import com.qfedu.shop.dao.impl.ProviderDaoImpl;
import com.qfedu.shop.pojo.Provider;

@WebServlet("/providerAdmin.do")
public class ProviderAdminServlet extends HttpServlet {
	
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
		// 查询所有信息
		try {
			List<Provider> list = dao.selectAll(Provider.class);
			
			// 将list转成Json格式数组
			String jstr = JSON.toJSONString(list);
			
			System.out.println(jstr);
			// 设定response 
			resp.setContentType("application/json");
			
			// 响应
			resp.getWriter().print(jstr);
			resp.getWriter().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
