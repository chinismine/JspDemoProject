package my.learning.shareresources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class TestServletContextListener implements ServletContextListener {
	private String resourcefile;	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("System shutdown");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		resourcefile=context.getInitParameter("resourceFile");
		System.out.println("resourcefile："+resourcefile);
		InputStream is1 = context.getResourceAsStream(resourcefile);
		BufferedReader br1=new BufferedReader(new InputStreamReader(is1));
		String data;
		try {
			while((data=br1.readLine())!=null) {
				System.out.println("data:"+data);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br1.close();
				is1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
