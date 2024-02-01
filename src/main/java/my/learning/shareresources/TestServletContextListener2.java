package my.learning.shareresources;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class TestServletContextListener2 implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		String codeValue = context.getInitParameter("code");
		String replyValue = context.getInitParameter("reply");
		
		System.out.println("code:"+codeValue);
		System.out.println("reply:"+replyValue);
		
		context.setAttribute("code", codeValue);
		context.setAttribute("reply", replyValue);
		
	}

}
