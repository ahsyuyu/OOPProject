package coen275project;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;



public class ExpenseRecord implements Serializable{

	private String date;
	private float expense;
	private String userName;				// record user name
	private String storeName;				// record store name

	
	public ExpenseRecord(float expense, String userName, String storeName) {
		this.expense = expense;
		this.userName = userName;
		this.storeName = storeName;
		SimpleDateFormat dt = new SimpleDateFormat("YYYY-MM-dd"); 
		date = dt.format(new Date());
		//date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	// for test
	public ExpenseRecord(String date, float expense, String userName, String storeName) {
		this.date = date;
		this.expense = expense;
		this.userName = userName;
		this.storeName = storeName;
	}
	
	
	
	public String getDate() {
		return date;
	}
	
	public float getExpense() {
		return expense;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getStoreName() {
		return storeName;
	}

	
	public void setExpense(float expense) {
		this.expense = expense;
	}
	
	public String toString() {
		String s = userName + ": " + date + ": " + expense + ": " + storeName + "\n";
		return s;
	}
	
	public static void main(String[] args) {

//		ExpenseRecord expenseRecord = new ExpenseRecord(1, "2016-05-23");
//		ExpenseRecord expenseRecord1 = new ExpenseRecord(2, "2016-05-23");
//		ExpenseRecord expenseRecord2 = new ExpenseRecord(3, "2016-05-24");
//		
//		System.out.println(expenseRecord);
//		System.out.println(expenseRecord1);
//		System.out.println(expenseRecord2);
	}
}

