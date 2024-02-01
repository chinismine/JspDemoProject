package my.learning;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet implementation class TestRequestInfoServletEx1
 */
public class TestRequestInfoServletEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("userName");
		String userAge=request.getParameter("userAge");
		
		String url = request.getRequestURL().toString();
		String serverName = request.getServerName();
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String httpMethod = request.getMethod();
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("url:"+url+"</br>");
		out.write("serverName:"+serverName+"</br>");
		out.write("contextPath:"+contextPath+"</br>");
		out.write("servletPath:"+servletPath+"</br>");
		out.write("httpMethod:"+httpMethod+"</br>");
		out.write("<p></p>");
		out.write("userName:"+userName+"</br>");
		out.write("userAge:"+userAge+"</br>");
		out.write("<p></p>");
		
		Enumeration<String> e1 = request.getHeaderNames();
		while(e1.hasMoreElements()) {
			String headerName = e1.nextElement();
			String headerValue = request.getHeader(headerName);
			
			out.write(headerName+":"+headerValue+"</br>");
		}
		
		out.close();
	}
}
