package coen275project;

import java.io.Serializable;

public class Card implements Serializable {
    private int cardNumber;
    private String password;
    
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
    
    
}
