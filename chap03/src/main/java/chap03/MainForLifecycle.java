package chap03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForLifecycle {

	public static void main(String[] args) {
		useXml();
	}
	
	private static void useXml() {
		System.out.println("~~~~~~~~~~~~~~~~ XML META ~~~~~~~~~~~~~~~~");
		String configLocation = "classpath:config-for-lifecycle.xml";
		//AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigForLifecycle.class);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		ctx.close();
	}
}
