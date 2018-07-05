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

@WebServlet("/userModify.do")
public class UserModifyServlet extends HttpServlet {

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
		// 获取操作标志
		String doit = req.getParameter("flag");

		if ("save".equals(doit)) {
			// 更新用户数据
			// 获取User对象
			User user = new User();
			try {
				BeanUtils.populate(user, req.getParameterMap());

				dao.updateUser(user);

				// 跳转到userAdmin.do

				resp.sendRedirect("userAdmin.do");

			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if ("del".equals(doit)) {
			try {
				dao.deleteUser(req.getParameter("id"));

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
