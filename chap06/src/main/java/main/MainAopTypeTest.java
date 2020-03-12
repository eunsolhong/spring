package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import board.MemberService;
import board.UpdateInfo;

public class MainAopTypeTest {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx
		= new GenericXmlApplicationContext("classpath:aopTypeTest.xml");
		
		MemberService ms = ctx.getBean("memberService", MemberService.class);
		
		UpdateInfo updateInfo = new UpdateInfo();
		updateInfo.setNewName("유림몬");
		ms.update("madvirus", updateInfo);
		
		ctx.close();
	}
}
