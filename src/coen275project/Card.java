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
	
	synchronized public static void temTest(String cardNumber, float expense){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Card thisCard = Serialization.deSerialize("database/card_"+ cardNumber +".ser");
		System.out.println("card: " + cardNumber);
		System.out.print("( before deduct is " + thisCard.totalBalance);
		thisCard.totalBalance -= expense;    // this is not atomic step
		System.out.println(", after deduct is " + thisCard.totalBalance + ")");
		
	    Serialization.serialize(thisCard,"database/card_"+ cardNumber +".ser");		
	}
	
    
	/*synchronized public void deductMoney(float expense) {   //synchronized //****  update after purchase   // 
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("card: " + this.cardNumber);
		Card temCard = Serialization.deSerialize("database/card_"+ this.cardNumber +".ser");
		//this.totalBalance = temCard.getTotalBalance();
		this.totalBalance = temCard.totalBalance;
		System.out.print("( before deduct is " + this.totalBalance);
		this.totalBalance -= expense;    // this is not atomic step
		System.out.println(", after deduct is " + this.totalBalance + ")");
	    Serialization.serialize(this,"database/card_"+ this.cardNumber +".ser");
	}*/
	
	/*synchronized public void deductMoneyNoSer(float expense) {   //synchronized //****  update after purchase   // 
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("card: " + this.cardNumber);
		System.out.print("( before deduct is " + this.totalBalance);
		this.totalBalance -= expense;    // this is not atomic step
		System.out.println(", after deduct is " + this.totalBalance + ")");
	}*/
	
	
	public float getTotalBalance() {
		Card temCard = Serialization.deSerialize("database/card_"+ this.cardNumber +".ser");
		this.totalBalance = temCard.totalBalance;
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
