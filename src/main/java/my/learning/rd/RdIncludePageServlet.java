package my.learning.rd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RdIncludePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userAddress = request.getParameter("userAddress");
		String codeValue = (String)request.getAttribute("code");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.write("userName："+userName+"</br>");
		out.write("userAddress："+userAddress+"</br>");
		out.write("codeValue："+codeValue+"</br>");
		
		out.close();
	}

}
