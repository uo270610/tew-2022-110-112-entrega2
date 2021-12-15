package com.tew.presentation.filter; 
import java.io.IOException; 
import javax.servlet.Filter; 
import javax.servlet.FilterChain; 
import javax.servlet.FilterConfig; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
/** 
 * Enable client-side cross-origin requests. Each request is inspected, 
 * and appropriate response headers are added to HttpServletResponse. 
 **/ 
public class CORSFilter implements Filter { 
	 @Override 
	 public void destroy() { 
	  // TODO Auto-generated method stub 
	 } 
	 @Override 
	 public void doFilter(ServletRequest request, ServletResponse response, 
			 FilterChain chain) throws IOException, ServletException { 
	        HttpServletRequest req = (HttpServletRequest) request; 
	        HttpServletResponse res = (HttpServletResponse) response; 
	        res.addHeader("Access-Control-Allow-Origin", "*"); 
	        res.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization"); 
	        res.addHeader("Access-Control-Allow-Credentials", "true"); 
	        res.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, 	DELETE, OPTIONS, HEAD"); 
	        res.addHeader("Access-Control-Max-Age", "1209600"); 
	 
	        // Forward the request down the filter chain. 
	        chain.doFilter(req, res); 
	     } 
	 @Override 
	 public void init(FilterConfig arg0) throws ServletException { 
	  // TODO Auto-generated method stub 
	 } 
}