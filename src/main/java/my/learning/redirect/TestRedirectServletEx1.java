package my.learning.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class TestRedirectServletEx1
 */
public class TestRedirectServletEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int count=1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		response.sendRedirect("http://tw.yahoo.com");
		
//		response.setHeader("Refresh", ""+3);
		response.setHeader("Refresh", 5+";URL=http://tw.yahoo.com");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
//		out.write("count="+(count++)+"<br>");
		out.write("網頁已經搬家，將在5秒內重新導向<br>");
		out.close();
		
	}

}
