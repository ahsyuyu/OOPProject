package coen275project;

import java.util.*;
import java.io.Serializable;

public class User implements Serializable {
    private String name;
    //private Card card;
    private String cardNumber;
    private ExpenseProfile expenseProfile = new ExpenseProfile();
    private DietaryProfile dietaryProfile = new DietaryProfile();
    private static final long serialVersionUID = 2L;
    
    /*----------------------about dependents----------------------*/
    private int extensionNumber = 0;     // the extensionNumber is 0 for parents, and is a 2-digit number for children
    private int extensionStart = 10;     
    private int extensionEnd = 10;       // extensionEnd starts at 10, and increase by 1 when 1 dependent is added
    // the total number of dependents is "extensionEnd - extensionStart"
    
    /*private HashMap<Integer, User> dependentMap = new HashMap<Integer, User>();    // initialize the dependentMap
    
    public void addDependent(User dependent) {          
    	dependent.card = this.card;
    	dependent.extensionNumber = extensionEnd++;
    	dependentMap.put(dependent.extensionNumber, dependent);       // add the dependent to the dependentMap
    }
    
    public void deleteDependent(User dependent) {
    	dependentMap.remove(dependent.extensionNumber);
    }
    
    public User findDependent(int extensionNumber) {          // use extensionNumber to find the dependent user
    	return dependentMap.get(extensionNumber);
    }
    
    public Collection<User> getDependents() {                // return the collection of the dependents
    	return dependentMap.values();
    }*/
    
    /*-------------------------end of dependents----------------*/
    
    
    // constructor
    public User(String name, String cardNumber) {
    	this.name = name;
    	this.cardNumber = cardNumber;
    }
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
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
	public void setExtensionNumber(int extensionNumber)  {
		this.extensionNumber = extensionNumber;
	}
	public int getExtensionNumber() {
		return extensionNumber;
	}
	
	@Override
    public String toString(){
    	String s = "User:" + "\n";
    	s += "user name: " + name + "\n";
    	s += "extension: " + extensionNumber + "\n";
    	s += cardNumber;     // Lifen: change to cardNumber
    	s += expenseProfile;
    	s += dietaryProfile + "\n";
    	return s;
    }
    
}
