package my.learning.shareresources;

import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.text.AbstractDocument.Content;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TestServletContextListenerRetrieve.do")
public class TestServletContextListenerRetrieve extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String codeInfo, replyInfo;

	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		codeInfo=(String) context.getAttribute("code");
		replyInfo=(String) context.getAttribute("reply");
	
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}
	
	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("codeinfo="+codeInfo+"<br>");
		out.write("replyinfo="+replyInfo+"<br>");
		out.close();
		
	}
}
