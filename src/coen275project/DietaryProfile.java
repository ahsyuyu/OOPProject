package coen275project;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class DietaryProfile implements Serializable{
	
	private static final String TYPE = "Dietary Profile";
	private String cardNumber; 			// need a cardnumber to serialization
	private int currentCalorie;			// expense limitation within a day
	private int nextCalorie;			// expense limitation within a day
	private int expense;				// total expense within a day
	private String firstDay;			// firstDay of this month
	private String date;				// today
    private List<DietaryRecord> dietaryRecordList = new ArrayList<>();		//Calorie expense of this month
    
    public DietaryProfile() {
    	
    }
   
    // for program initialization
    public DietaryProfile(String cardNumber, int currentCalorie, int nextCalorie, int expense, String firstDay,
			String date, List<DietaryRecord> dietaryRecordList) {
		this.cardNumber = cardNumber;
		this.currentCalorie = currentCalorie;
		this.nextCalorie = nextCalorie;
		this.expense = expense;
		this.firstDay = firstDay;
		this.date = date;
		this.dietaryRecordList = dietaryRecordList;
	}

	public void setCurrentCalorie(int setCurrentCalorie) {
    	this.currentCalorie = setCurrentCalorie;
    }
    
    // modify calorie of next month		
    public void setNextCalorie(int nextCalorie) {
    	this.nextCalorie = nextCalorie;
    }
    
	// user buy item
    // TODO everyday with one record 
    public void addDietaryRecord(DietaryRecord record) {
    	dietaryRecordList.add(record);
    }
    
    public String getYearAndMonth() {
    	String[] temp1 = firstDay.split("-");
		String yearOfProfile = temp1[0];
		String monthOfProfile = temp1[1];
		
		return yearOfProfile + "-" + monthOfProfile;
    }
    
    public void setExpense(int expense) {
    	this.expense = expense;
    }
    
    public void setFirstDay(String firstDay) {
    	this.firstDay = firstDay;
    }
    
    public void setDate(String date) {
    	this.date = date;
    }
    
    public void setList(List<DietaryRecord> dietaryRecordList) {
    	this.dietaryRecordList = dietaryRecordList;
    }
    
    public String getCardnumber() {
    	return cardNumber;
    }
	
    public int getCurrentCalorie() {
    	return currentCalorie;
    }
    
    public int getNextCalorie() {
    	return nextCalorie;
    }
    
    public int getExpense() {
    	return expense;
    }
    
    public String getFirstDay() {
    	return firstDay;
    }
    
    public String getDate() {
    	return date;
    }
    
    public List<DietaryRecord> getList() {
    	return dietaryRecordList;
    }
    
    @Override
    public String toString() {
    	String s = "Profile type: " + TYPE + "\n";
    	s += "Card number: " + cardNumber + "\n";
    	s += "Period: " + getYearAndMonth() + "\n";
    	s += "Limitation calorie everyday in this month: " + currentCalorie + "\n";
    	s += "Limitation calorie everyday from next month: " + nextCalorie + "\n";
    	s += "Expense of this month: " + expense + "\n";
    	s += dietaryRecordList;
    	return s;
    }
    
}
