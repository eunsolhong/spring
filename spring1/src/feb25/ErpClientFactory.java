package feb25;

import java.util.Properties;

public abstract class ErpClientFactory {
// 빈이 추상클래스인 경우
	
	public static ErpClientFactory instance() {
		Properties props = new Properties();
		props.setProperty("server", "localhost");
		return instance(props);
	}

	public static ErpClientFactory instance(Properties props) {
		System.out.println("static  instance ");
		return new DefaultErpClientFactory(props);
	}

	protected ErpClientFactory() {
	}

	public abstract ErpClient create();
}
