package feb25;

import java.util.Properties;

public class DefaultErpClientFactory extends ErpClientFactory {

	private String server;
	public DefaultErpClientFactory(Properties props) {
		this.server = props.getProperty("server");
	}
	
	@Override
	public ErpClient create() {
		return new ErpClient() {
			@Override
			public void connect() {
				System.out.println("connect : " + server);
			}
			
			@Override
			public void close() {
				System.out.println("connect down : " + server);
			}
			
			@Override
			public void sendPurchaseInfo(ErpOrderData oi) {
				System.out.println("order info submit : " + server);
			}
		};
	}
}
