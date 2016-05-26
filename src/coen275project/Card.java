package coen275project;

import java.io.Serializable;

public class Card implements Serializable {
    private int cardNumber;
    private String password;
    private float totalBalance = 5000.0F;     //****
    
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
    
	synchronized public void deductMoney(float expense) {   //synchronized //****  update after purchase   // 
		
		System.out.print("( before deduct is " + this.totalBalance);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.totalBalance -= expense;    // this is not atomic step
		System.out.println(", after deduct is " + this.totalBalance + ")");
	}
	
	public float getTotalBalance() {
		return this.totalBalance;
	}
	
	public void setTotalBalance() {
		
	}
}
