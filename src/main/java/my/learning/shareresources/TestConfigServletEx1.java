package my.learning.shareresources;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
		urlPatterns={"/TestConfigServletEx1.webgo"},
		initParams= {
				@WebInitParam(name="contentType",value="text/html;charset=UTF-8"),
				@WebInitParam(name="bgColor",value="orange")
		}
		)
public class TestConfigServletEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String contentType;
	private String bgColor;
	
	public void init() throws ServletException {
		contentType = getInitParameter("contentType");
		bgColor = getInitParameter("bgColor");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}
	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
//		response.setContentType("text/html;charset=UTF-8");
		response.setContentType(contentType);
		PrintWriter out = response.getWriter();
//		out.write("contentType："+contentType+"<br>");
//		out.write("bgColor："+bgColor+"<br>");
		out.write("<html>");
		out.write("<head><title>Config</title></head>");
		out.write("<body bgcolor='"+bgColor+"'>");
		out.write("Hello World!!");
		out.write("</body>");
		out.write("</html>");
		
		out.close();
	}

}
