package my.learning.upload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet("/myupload.action")
@MultipartConfig(location = "C:/temp/upload")
public class TestFileUploadServletEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		processSingleFileActoion(request,response);
		processMultipleSingleFileActoion(request,response);
		
		
	}

	private void processMultipleSingleFileActoion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		
		Collection<Part> parts = request.getParts();
		out.write("上傳檔案：<br>");
		for(Part part:parts) {
			String fileName = part.getSubmittedFileName();
			out.write("\t *"+fileName+"<br>");
			if(!"".equals(fileName)&&part.getContentType()!=null) {
				part.write(fileName);
			}
			
		}
		out.write("<br>多檔案上傳成功");	
		out.close();
		
	}

	private void processSingleFileActoion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		Part part = request.getPart("multimedia");
		String headerValue = part.getHeader("Content-Disposition");
		String fileName = part.getSubmittedFileName();
		
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		out.write("headerValue="+headerValue+"<br>");
		out.write("fileName="+fileName+"<br>");
		
		if(!"".equals(fileName)&&part.getContentType()!=null) {
			out.write("上傳成功");
			part.write(fileName);
		}
		
		out.close();
		
	}

}
