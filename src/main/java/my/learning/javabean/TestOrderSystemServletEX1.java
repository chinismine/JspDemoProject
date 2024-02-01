package my.learning.javabean;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/orderSystem/OrderSysyemAction.do")
@WebServlet("/OrderSysyemAction.do")
public class TestOrderSystemServletEX1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String shipAddress = request.getParameter("shipAddress");
		String userPhone = request.getParameter("userPhone");
		int userAmount = Integer.parseInt(request.getParameter("userAmount"));
		
		OrderSystem os1=new OrderSystem(shipAddress, userName, userPhone, userAmount);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(os1.getOrderNumber()+"<br>"+os1.getCustomer()+"<br>"+os1.getPhone()+"<br>"+os1.getShipAddress()+"<br>"+os1.getAmount());
		
		out.close();
	}
	
	

}
