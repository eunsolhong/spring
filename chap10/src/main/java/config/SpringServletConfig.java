package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringServletConfig implements WebApplicationInitializer {
//web.xml역할
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException{
		XmlWebApplicationContext servletAppContext =
				new XmlWebApplicationContext();
		servletAppContext.setConfigLocation("/WEB-INF/dispatcher.xml");
		
		DispatcherServlet dispatcherServlet = 
				new DispatcherServlet(servletAppContext);
		ServletRegistration.Dynamic registration = 
				servletContext.addServlet("dispatcher", dispatcherServlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("*.do");
	}
}
