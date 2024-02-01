package my.learning;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/GenericServletEx1.forway2")
public class TestGenericServletEx1 extends GenericServlet {

	/**
	Its a java api doc comments
	java doc generate
	*/
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("welcome!!<br/>");
		out.close();

	}

}
