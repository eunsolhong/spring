package member;

public class OrderInfo {

	
	private Long id;
	private int totalPrice;
	private String memberId;
	
	public OrderInfo(Long id, int totalPrice, String memberId){
		this.id = id;
		this.memberId = memberId;
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public String getMemberId() {
		return memberId;
	}
	
	
}
