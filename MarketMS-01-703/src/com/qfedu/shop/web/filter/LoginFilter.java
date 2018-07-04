package com.qfedu.shop.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        System.out.println(this + " construct");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(this + " doFilter");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		// 后去会话中的user
		Object user = req.getSession().getAttribute("user");
		// 获取请求资源的路径

		String reqUri = req.getServletPath();
		
		// 放行以下路径请求
		// /login.html /login.do /css/* /images/* /js/* 
		
		boolean isWhitePage = reqUri.matches("(^/(?:css|images|js)/\\S+)|(^/login.(?:html|do))");
		System.out.println(user);
		System.out.println(reqUri);
		System.out.println(isWhitePage);
		if (user == null && !isWhitePage) {
			resp.sendRedirect("login.html");
			
		} else {
			chain.doFilter(request, response);
		}
		

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println(this + " init");
	}

}
