package coen275project;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;


public class ExpenseProfile implements Serializable{
	private static final String TYPE = "Expense Profile";
	private int cardNumber; 		// need a cardnumber to serialization
	private String userName;
	private float currentFund;		// expense limitation this month
	private float nextFund;		// expense limitation next month
	private float expense;			// total expense in the period
	private String firstDay;		// firstDay of this month
    private List<ExpenseRecord> expenseRecordList = new ArrayList<>();	//expenseList of this month

    
    public ExpenseProfile() {
    	this.cardNumber = 0;
    	this.currentFund = 0;
    	this.nextFund = 0;
    	this.expense = 0;
    	firstDay = null;
    	expenseRecordList = null;
    }
    
    // for program initialization
    public ExpenseProfile(int cardNumber, String userName, float currentFund, float nextFund, float expense, String firstDay, List<ExpenseRecord> expenseRecordList ) {
    	this.cardNumber = cardNumber;
    	this.userName = userName;
    	this.currentFund = currentFund;
    	this.nextFund = nextFund;
    	this.expense = expense;
    	this.firstDay = firstDay;
    	this.expenseRecordList = expenseRecordList;
    }
    

    
    // when second period begin
    public void reset () {
    	currentFund = nextFund;
    	nextFund = 0;
    	expense = 0;
    	firstDay = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
    	expenseRecordList = new ArrayList<>();
    	
    }
    
    // modify fund of next month
    public void setNextFund(float fund) {
    	this.nextFund = fund;	
    }
    
	// user buy item
    public void addExpenseRecord(ExpenseRecord er) {
    	expenseRecordList.add(er);
    }
    
    public String getYearAndMonth() {
    	String[] temp1 = firstDay.split("-");
		String yearOfProfile = temp1[0];
		String monthOfProfile = temp1[1];
		
		return yearOfProfile + "-" + monthOfProfile;
    }
    
    public int getCardNumber() {
    	return cardNumber;
    }
    
    public float getCurrentFund() {
    	return currentFund;
    }
    
    public float getExpense() {
    	return expense;
    }
    
    public float getNextFund() {
    	return nextFund;
    }
    
    public List<ExpenseRecord> getList() {
    	return expenseRecordList;
    }
    
    public String getFirstDay() {
    	return firstDay;
    }
    
    public String getUserName() {
		return userName;
	}
    
    public void setCurrentFund(float fund) {
    	this.currentFund = fund;
    }
    

    
    public void setExpense(float expense) {
    	this.expense = expense;
    }
    
    public void setFirstDay(String firstDay) {
    	this.firstDay = firstDay;
    }
    
    public void setList(List<ExpenseRecord> list) {
    	this.expenseRecordList = list;
    }
    

	public void setUserName(String userName) {
		this.userName = userName;
	}
    
    @Override
    public String toString() {
    	String s = "Profile type: " + TYPE + "\n";
    	s += "Card number: " + cardNumber + "\n";
    	s += "Period: " + getYearAndMonth() + "\n";
    	
    	s += "Limitation of this month: " + currentFund + "\n";
    	s += "Limitation of next month: " + nextFund + "\n";
    	s += "Expense of this month: " + expense + "\n";
    	s += expenseRecordList;
    	return s;
    	
    }

	
    
    
}
