package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import board.MemberRegRequest;
import board.MemberService;
import board.NewArticleRequest;

import board.ReadArticleService;
import board.UpdateInfo;
import board.WriteArticleService;

public class MainJavaConfigQuickStart {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(QuickStartConfig.class);
		
		
		WriteArticleService writeArticleService = 
				ctx.getBean("writeAriticleService", WriteArticleService.class);
		writeArticleService.write(new NewArticleRequest("writer", "title", "content"));
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		ReadArticleService readArticleService = ctx.getBean(ReadArticleService.class);
		readArticleService.read(1); //read 라는 메소드는 joinpoint
		readArticleService.read(1);
		readArticleService.read(2);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		MemberService memberService = ctx.getBean(MemberService.class);
		MemberRegRequest memberRegReq = new MemberRegRequest("id", "name", "pw");
		memberService.regist(memberRegReq);
		
		UpdateInfo updateInfo = new UpdateInfo();
		updateInfo.setNewName("새이름");
		memberService.update("madvirus", updateInfo);
		
		ctx.close();
	}
}
