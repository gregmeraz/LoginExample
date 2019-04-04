package com.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
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
		
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		HttpServletResponse httpServletResponse=(HttpServletResponse) response;
		
		if(user!=null && pass !=null) {
			if(user.equals("admin") && pass.equals("test")){
				chain.doFilter(request, response);
			}
			
			else {
				System.out.println("Wrong username or password");
				httpServletResponse.sendRedirect("/LoginExample/login.html");
			}
			
		}
		else {
			System.out.println("Null username or password");
			httpServletResponse.sendRedirect("/LoginExample/login.html");
		}
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
