package feb24;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp3 {
	public static void main(String[] args) {
		
		BeanFactory factory = new XmlBeanFactory(
				new FileSystemResource("src/xml/applicationContext.xml"));
		MessageBean bean = factory.getBean("messageBean", MessageBean.class);
		bean.sayHello("Spring");
	}
}
