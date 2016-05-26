package coen275project;

public class Card {
    private int cardNumber;
    private String password;
    private float totalBalance = 100.5F;     //****
    
    public Card(int cardNumber, String password) {
    	this.cardNumber = cardNumber;
    	this.password = password;
    }
    
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
	synchronized void deductMoney(float expense) {    //****  update after purchase 
		System.out.print("( before deduct is " + this.totalBalance);
		this.totalBalance -= expense;    // this is not atomic step
		System.out.println(", after deduct is " + this.totalBalance + ")");
	}
	
	public float getTotalBalance() {
		return this.totalBalance;
	}
	
	public void setTotalBalance() {
		
	}
}
