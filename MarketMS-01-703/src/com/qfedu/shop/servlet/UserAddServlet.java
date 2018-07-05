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

import com.qfedu.shop.dao.UserDao;
import com.qfedu.shop.dao.impl.UserDaoImpl;
import com.qfedu.shop.pojo.User;

@WebServlet("/userAdd.do")
public class UserAddServlet extends HttpServlet {

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取用户填写的表单，将表单数据封装为User对象
		User user = new User();
		try {
			BeanUtils.populate(user, req.getParameterMap());

			// 将新的用户信息写入数据库
			int addedRowCount = dao.addUser(user);
			
			if (addedRowCount > 0) {
				// 跳转到userAdmin.jsp，展示用户列表
				// 应该转发到userAdmin.do
				resp.sendRedirect("userAdmin.do");				
			} else {
				resp.getWriter().println("数据库添加失败");
			}

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			resp.getWriter().println(e.getMessage());
			e.printStackTrace();
		}
	}

}
