package com.qfedu.shop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.shop.dao.UserDao;
import com.qfedu.shop.dao.impl.UserDaoImpl;
import com.qfedu.shop.pojo.User;

@WebServlet("/userInfo.do")
public class UserShowInfoServlet extends HttpServlet {

	private UserDao dao;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		dao = (UserDao) getServletContext().getAttribute("userDaoInstance");
		if (dao == null) {
			dao = new UserDaoImpl();
			getServletContext().setAttribute("userDaoInstance", dao);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("id");
		// 查询数据库，获取对应id的用户信息
		try {
			User user = dao.selectUserById(userId);
			
			// 将用户信息转发到userModify.jsp
			req.setAttribute("user", user);
			req.getRequestDispatcher("userModify.jsp").forward(req, resp);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
