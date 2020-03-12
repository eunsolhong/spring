package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import board.NewArticleRequest;
import board.ReadArticleService;
import board.WriteArticleService;

public class MainDesignatorTest {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx
		= new GenericXmlApplicationContext("classpath:designatorTest.xml");
		WriteArticleService writeSvc = ctx.getBean("writeArticleService", WriteArticleService.class);
		writeSvc.write(new NewArticleRequest("wrtier", "title", "content"));
		
		ReadArticleService readSvc = ctx.getBean("readArticleService", ReadArticleService.class);
		System.out.println("~~~~~~~~~~~~~~~~first readSvc.read(1)");
		readSvc.read(1);
		System.out.println("~~~~~~~~~~~~~~~~second readSvc.read(1)");
		readSvc.read(1);
		
		ctx.close();
	}
}
