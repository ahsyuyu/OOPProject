package coen275project;

import java.util.*;

public class User {
    private String name;
    private int id;
    private Card card;
    private ExpenseProfile expenseProfile = new ExpenseProfile();
    private DietaryProfile dietaryProfile = new DietaryProfile();
    
    /*----------------------about dependents---------*/
    private HashMap<Integer, User> dependentMap = null;        ///*********
    
    public void addDependent(User dependent) {
    	dependent.card = this.card;
    	int extensionNumber = 55;        //Math.random(5-0+1) + 1;
    	dependentMap.put(extensionNumber, dependent);
    }
    
    /*public void deleteDependent(User dependent) {
    	
    }*/
    
    /*-------------------------end of dependents----------------*/
    
    
    
    public User(String name, int id, Card card) {
    	this.name = name;
    	this.id = id;
    	this.card = card;
    }
    
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
