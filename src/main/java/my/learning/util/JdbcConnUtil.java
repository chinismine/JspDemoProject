package my.learning.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcConnUtil {
	private Connection conn;
	
	public Connection createConn() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String urlstr="jdbc:sqlserver://localhost:1433;"
				+ "databaseName=chinservlet;user=watcher;"
				+ "password=Passw0rd;encrypt=true;trustServerCertificate=true";
			conn = DriverManager.getConnection(urlstr);
			System.out.println("Connection is "+!conn.isClosed()+".0");
			
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public Connection createConn2() {
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/JdbcSQLServerConn/ResourceSystem");
			conn = ds.getConnection();
			System.out.println("Connection2 is "+!conn.isClosed()+".0");
			
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public void closeConn() throws SQLException {
		if(conn!=null) {
			conn.close();
		}
		System.out.println("Connection is closed.");
	}
}
