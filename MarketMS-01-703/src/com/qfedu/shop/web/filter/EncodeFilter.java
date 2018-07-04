package com.qfedu.shop.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter({ "*.do", "*.html", "*.jsp" })
public class EncodeFilter implements Filter {

	public EncodeFilter() {
		System.out.println(this + " construct");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println(this + " doFilter");
		arg0.setCharacterEncoding("utf8");
		arg1.setCharacterEncoding("utf8");

		arg2.doFilter(arg0, arg1);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println(this + " init");
	}

}
