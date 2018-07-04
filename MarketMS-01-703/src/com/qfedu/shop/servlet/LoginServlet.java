package com.qfedu.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.shop.dao.UserDao;
import com.qfedu.shop.dao.impl.UserDaoImpl;

@WebServlet("/login.do")
public class LoginServlet implements Servlet {

	private UserDao userDao;
	private ServletConfig config;
	@Override
	public void destroy() {
		System.out.println(this + " destroy");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return config;
	}

	@Override
	public String getServletInfo() {
		
		return "验证用户名与密码，处理用户登录请求";
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println(this + " init");
		this.config = arg0;
		
		userDao = new UserDaoImpl();
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println(this + " service");
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		
		try {
			Map<String, Object> userInfo = userDao.login(username, password);
			if (userInfo != null) {
				// 用户名与密码匹配，可以登录
				// 将用户信息放入会话，
				request.getSession().setAttribute("user", userInfo);
				// 在客户端添加cookie，记录成功登录的用户名
				response.addCookie(new Cookie("username", username));
				// 向前端发送一个状态数字，1，表示验证成功
				out.print("1");
			} else {
				// 验证失败，向前端发送一个状态数字，0，
				out.print("0");
			}
		} catch (SQLException e) {
			// 设定响应状态码：500（服务器内部错误）
			response.setStatus(500);
			out.print(e.getMessage());
			e.printStackTrace();
		}
		
		out.close();
		
	}

}
