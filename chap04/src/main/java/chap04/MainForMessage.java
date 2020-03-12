package chap04;

import java.util.Locale;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForMessage {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:message-config.xml");

		System.out.println(ctx.getMessage("hello", null, Locale.getDefault()));
		System.out.println(ctx.getMessage("welcome", new String[] { "최범균" }, Locale.getDefault()));

		System.out.println(ctx.getMessage("hello", null, Locale.ENGLISH));
		System.out.println(ctx.getMessage("welcome", new String[] { "madvirus" }, Locale.ENGLISH));

		ctx.close();
	}
}
