package my.learning.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import my.learning.util.JdbcConnUtil;

@WebServlet("/JdbcConnServletEx3.do")
public class TestJdbcConnServletEx3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private Connection conn;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	processAction(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processAction(req,resp);
	}
	
	
	private void queryAll() throws SQLException {
		String sql="select * from Product";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			out.write(rs.getInt(1)+". productName： "+rs.getString(2)+" , price："+rs.getInt(3)+" , qty："+rs.getInt(4)+" , note："+rs.getString(5)+"<br/>");
		}
		rs.close();
		stmt.close();
	}
	
	private void insertData() throws SQLException {
		String inssql="insert into Product "
				+ "(productName,productPrice,qty,note)\r\n"
				+ "values(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(inssql);
		pstmt.setString(1, "orange");
		pstmt.setInt(2, 15);
		pstmt.setInt(3, 600);
		pstmt.setString(4, "gooooood!");
		
		int result=pstmt.executeUpdate();
		out.write(result+" is inserted. ");
		pstmt.close();
	}
	
	private void updateData() throws SQLException {
		String updsql="update Product set productPrice=?, qty=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(updsql);
		pstmt.setInt(1, 599);
		pstmt.setInt(2, 20);
		pstmt.setInt(3, 1002);
		
		int result=pstmt.executeUpdate();
		out.write(result+" is updated. ");
		pstmt.close();
	}
	
	private void deleteById() throws SQLException {
		String delsql="Delete from Product where id=?";
		PreparedStatement pstmt = conn.prepareStatement(delsql);
		pstmt.setInt(1, 1003);
		
		
		int result=pstmt.executeUpdate();
		out.write(result+" is deleted. ");
		pstmt.close();
	}

	private void processAction(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			
			resp.setContentType("text/html;charset=UTF-8");
			out = resp.getWriter();
			JdbcConnUtil connUtil=new JdbcConnUtil();
			conn=connUtil.createConn2();
			
			if(conn!=null) {
				
				queryAll();
				out.write("<hr/>");
//			insertData();
//			updateData();
//				deleteById();
//				out.write("<hr/>");
//				queryAll();
				connUtil.closeConn();
			}
			
			
			
			out.close();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
