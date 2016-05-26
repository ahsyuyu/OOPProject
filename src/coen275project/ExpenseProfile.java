package coen275project;

import java.text.SimpleDateFormat;
import java.util.*;


public class ExpenseProfile {
	private String cardNumber; 		// need a cardnumber to serialization
	private double currentFund;		// expense limitation this month
	private double nextFund;		// expense limitation next month
	private double expense;			// total expense in the period
	private String firstDay;		// firstDay of this month
    private List<ExpenseRecord> expenseRecordList = new ArrayList<>();	//expenseList of this month

    
    public ExpenseProfile() {
    	this.cardNumber = null;
    	this.currentFund = 0;
    	this.nextFund = 0;
    	this.expense = 0;
    	firstDay = null;
    	expenseRecordList = null;
    }
    
    // for program initialization
    public ExpenseProfile(String cardNumber, double currentFund, double nextFund, double expense, String firstDay, List<ExpenseRecord> expenseRecordList ) {
    	this.cardNumber = cardNumber;
    	this.currentFund = currentFund;
    	this.nextFund = nextFund;
    	this.expense = expense;
    	this.firstDay = firstDay;
    	this.expenseRecordList = expenseRecordList;
    }
    
	// user buy item
    public void addExpenseRecord(ExpenseRecord er) {
    	expenseRecordList.add(er);
    }
    
    // when second period begin
    public void reset () {
    	currentFund = nextFund;
    	nextFund = 0;
    	expense = 0;
    	firstDay = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
    	expenseRecordList = null;
    	
    }
    
    public String getCardNumber() {
    	return cardNumber;
    }
    
    public double getCurrentFund() {
    	return currentFund;
    }
    
    public double getExpense() {
    	return expense;
    }
    
    public double getNextFund() {
    	return nextFund;
    }
    
    public List<ExpenseRecord> getList() {
    	return expenseRecordList;
    }
    
    public String getFirstDay() {
    	return firstDay;
    }
    
    public void setCurrentFund(double fund) {
    	this.currentFund = fund;
    }
    // modify fund of next month
    public void setNextFund(double fund) {
    	this.nextFund = fund;	
    }
    
    public void setExpense(double expense) {
    	this.expense = expense;
    }
    
    public void setFirstDay(String firstDay) {
    	this.firstDay = firstDay;
    }
    
    public void setList(List<ExpenseRecord> list) {
    	this.expenseRecordList = list;
    }
    
    
    @Override
    public String toString() {
    	String s = "Card number: " + cardNumber + "\n";
    	s += "Limitation of this month: " + currentFund + "\n";
    	s += "Limitation of next month: " + nextFund + "\n";
    	s += "Expense of this month: " + expense + "\n";
    	s += expenseRecordList;
    	return s;
    	
    }
    
    
}
