package feb25;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSensor {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:/xml/config-sensor.xml");
		Monitor monitor = ctx.getBean(Monitor.class);
		System.out.println(monitor);
		ctx.close();
	}
}
