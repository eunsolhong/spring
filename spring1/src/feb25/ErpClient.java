package feb25;

public interface ErpClient {
	
	public void connect();
	
	public void close();
	
	public void sendPurchaseInfo(ErpOrderData oi);
}
