package com.qfedu.shop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.shop.dao.UserDao;
import com.qfedu.shop.dao.impl.UserDaoImpl;
import com.qfedu.shop.pojo.User;

@WebServlet("/userAdmin.do")
public class UserAdminServlet extends HttpServlet {

	private UserDao dao;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		dao = new UserDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//从数据查询出所有用户信息
		try {
			List<User> users = dao.selectAllUser(User.class);
			
			// 将users放入request作用域中
			req.setAttribute("users", users);
			
			// 转发到jsp页面展示
			req.getRequestDispatcher("userAdmin.jsp").forward(req, resp);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
