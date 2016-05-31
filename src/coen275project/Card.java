package coen275project;

import java.io.Serializable;

public class Card implements Serializable {
    private String cardNumber;
    private String password;
    private float totalBalance = 5000.0F;     //****
    private static final long serialVersionUID = 1L;
    
    public Card(String cardNumber, String password) {
    	this.cardNumber = cardNumber;
    	this.password = password;
    }
    
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
	synchronized public void deductMoney(float expense) {   //synchronized //****  update after purchase   // 
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Card temCard = Serialization.deSerialize("database/"+ this.cardNumber +".ser");
		this.totalBalance = temCard.getTotalBalance();
		System.out.print("( before deduct is " + this.totalBalance);
		this.totalBalance -= expense;    // this is not atomic step
		System.out.println(", after deduct is " + this.totalBalance + ")");
	    Serialization.serialize(this,"database/"+ this.cardNumber +".ser");
	}
	
	public float getTotalBalance() {
		return this.totalBalance;
	}
	
	public void setTotalBalance() {
		
	}
	
	@Override
	public String toString() {
		String s = "cardNumber: " + cardNumber + "\n";
		s += "password: " + password + "\n";
		s += "totalBalance: " + totalBalance + "\n";
		return s;
	}
}
