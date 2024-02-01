package my.learning.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class TestSesssionServletEx1
 */
public class TestSessionServletEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		
		if(session.isNew()) {
			out.write("Session created.<br/>");
			out.write("sessionId="+sessionId+"<br/>");
			session.setAttribute("user", "Jay");
			session.setMaxInactiveInterval(6);
		}else {
//			session.invalidate();
			String userName=(String) session.getAttribute("user");
			out.write("User="+userName+"<br/>");
			out.write("sessionId="+sessionId+"<br/>");
			out.write("Session Alive.<br/>");
		}
		
		out.close();
	}

}
