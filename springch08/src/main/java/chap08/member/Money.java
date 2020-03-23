package chap08.member;

public class Money {
	
	private int amount;
	private String currency;
	
	public Money(int amount, String currency){
		this.amount=amount;
		this.currency=currency;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return  amount + currency;
	}

	public String getCurrency() {
		return currency;
	}



}
