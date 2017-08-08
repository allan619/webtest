package com.gdglc.spring;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Servlet Filter implementation class ReloadFilter
 */
public class ReloadFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ReloadFilter() {
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
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		WebApplicationContextUtils.getWebApplicationContext(httpRequest.getSession().getServletContext());
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(httpRequest.getSession().getServletContext());
		User user = (User)context.getBean("user");
		System.out.println("context.getBean(user).name:"+user.getName()+"");
		XmlWebApplicationContext xmlcontext  = (XmlWebApplicationContext)context;
		user.setName("update");
		//xmlcontext.refresh();
		//context.getParent();
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
