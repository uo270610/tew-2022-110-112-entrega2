package com.tew.presentation.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilterAgent
 */
@WebFilter(
		dispatcherTypes = {DispatcherType.REQUEST }
					, 
		urlPatterns = { "/faces/restricted_agent/*" }, 
		initParams = { 
				@WebInitParam(name = "LoginParam", value = "/faces/index.xhtml")
		})
public class LoginFilterAgent implements Filter {
	
	FilterConfig config = null;

    /**
     * Default constructor. 
     */
    public LoginFilterAgent() {
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
		// TODO Auto-generated method stub
		// place your code here

		// Si no es petición HTTP nada que hacer
				if (!(request instanceof HttpServletRequest)) {
					chain.doFilter(request, response);
					return;
				}
				// En el resto de casos se verifica que se haya hecho login previamente
				HttpServletRequest req = (HttpServletRequest) request;
				HttpServletResponse res = (HttpServletResponse) response;
				HttpSession session = req.getSession();
				if (session.getAttribute("AGENTE") == null) {
					String loginForm = config.getInitParameter("LoginParam");
					// Si no hay login, redirección al formulario de login
					res.sendRedirect(req.getContextPath() + loginForm);
					return;
				}
				// pass the request along the filter chain
				chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		config = fConfig;
	}

}
