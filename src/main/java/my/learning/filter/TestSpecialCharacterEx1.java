package my.learning.filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/filters/mySpecialCharacter.play")
public class TestSpecialCharacterEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String userAddress = request.getParameter("userAddress");
		
		String myuserName=replaceSpecialCharacter(userName);
		String myuserAddress=replaceSpecialCharacter(userAddress);
		
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		
		out.write("userName:"+userName+"<br/>");
		out.write("userAddress:"+userAddress+"<br/>");
		
		out.write("<hr/>");
		out.write("myuserName:"+myuserName+"<br/>");
		out.write("myuserAddress:"+myuserAddress+"<br/>");
		
		out.close();
		
	}

	private String replaceSpecialCharacter(String value) {
		value=value.replaceAll("<", "&lt;");
		value=value.replaceAll(">", "&gt;");
		return value;
	}

}
