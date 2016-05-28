package coen275project;

import java.util.ArrayList;
import java.util.List;

public class DietaryProfile {
	private String cardNumber; 			// need a cardnumber to serialization
	private int currentCalorie;			// expense limitation within a day
	private int nextCalorie;			// expense limitation within a day
	private int expense;				// total expense within a day
	private String firstDay;			// firstDay of this month
	private String date;				// today
    private List<DietaryRecord> dietaryRecordList = new ArrayList<>();		//Calorie expense of this month
    
    public DietaryProfile() {
    	
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
    
}
