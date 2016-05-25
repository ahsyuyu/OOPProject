package coen275project;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int id;
    private Card card;
    private ExpenseProfile expenseProfile;
    private DietaryProfile dietaryProfile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public ExpenseProfile getExpenseProfile() {
		return expenseProfile;
	}
	public void setExpenseProfile(ExpenseProfile expenseProfile) {
		this.expenseProfile = expenseProfile;
	}
	public DietaryProfile getDietaryProfile() {
		return dietaryProfile;
	}
	public void setDietaryProfile(DietaryProfile dietaryProfile) {
		this.dietaryProfile = dietaryProfile;
	}
    
    
}
