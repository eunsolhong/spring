package chap03;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBean implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {

	public void setProperty1(String property1) {
		System.out.println("MyBean.setProperty1() Access");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware.setBeanName() Access");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContextAware.setApplicationContext() Access");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean.afterPropertiesSet() Access");
	}

	public void customInit() {
		System.out.println("MyBean.customInit() Access");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("PostConstruct() Access");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("@PreDestroy() Access");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean.destroy() Access");
	}

	public void customDestroy() {
		System.out.println("MyBean.customDestroy() Access");
	}

}
