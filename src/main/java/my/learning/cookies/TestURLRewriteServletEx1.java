package my.learning.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/TestURLRewriteServletEx1.do")
public class TestURLRewriteServletEx1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		Integer count = (Integer) session.getAttribute("count");
		if(count==null) {
			count=0;
		}
		count++;
		session.setAttribute("count", count);
		
		out.write("count："+ count+"<br/>");
		out.write("<a href='"+ response.encodeURL("TestURLRewriteServletEx1.do") +"'>SessionID</a>");
		
		out.close();
	}

}
