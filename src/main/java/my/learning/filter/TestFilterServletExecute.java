package my.learning.filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(urlPatterns={"/TestFilterServletEx1.do"})
//@WebFilter("/*")
public class TestFilterServletExecute implements Filter {
	private ServletContext context;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		context = filterConfig.getServletContext();	
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		Integer count = (Integer)context.getAttribute("count");
		if(count==null) {
			count=0; //count=new Integer(0)
		}
		count++;
		context.setAttribute("count", count);
		out.write("You are the "+count+" visitor, welcome!</br>");
		
		chain.doFilter(request, response);
		
		out.write("Response message finished.</br>");
		out.close();

	}

	@Override
	public void destroy() {
		context=null;
	}

	
}
