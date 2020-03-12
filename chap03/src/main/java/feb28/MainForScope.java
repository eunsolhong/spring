package feb28;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForScope {

	public static void main(String[] args) {
		useXml();
	}
	
	private static void useXml() {
		System.out.println("~~~~~~~~~~~~~~XML Meta~~~~~~~~~~~~~~"); 
		String configLocation = "classpath:config-for-scope.xml";
	//	GenericXmlApplicationContext ctx =  // ctx가 WorkSchedule에 setApplicationContext로 들어감 
	//			new GenericXmlApplicationContext(configLocation);
	 AnnotationConfigApplicationContext ctx = 
			 new AnnotationConfigApplicationContext(ConfigForScope.class);
		
		WorkScheduler scheduler = ctx.getBean("workScheduler", WorkScheduler.class);
		scheduler.makeAndRunWork();
		
		ctx.close();
	}
}
