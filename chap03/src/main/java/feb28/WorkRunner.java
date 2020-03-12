package feb28;

import org.springframework.beans.factory.BeanNameAware;

public class WorkRunner implements BeanNameAware {

	private String beanId; // BeanNameAware를 자동으로 상속받음

	@Override
	public void setBeanName(String name) { // 이 클래스에 스트링에 만들어져있는 이름을 넘긴다.
		this.beanId = name; // 이름이 beanId로 들어갔다.
	}

	public void execute(Work work) {
		System.out.printf("WorkRunner[%s] execute Work[%d]\n", beanId, work.getOrder());
		work.run();
	}
}
