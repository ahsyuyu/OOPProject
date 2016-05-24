package coen275project;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;



public class ExpenseRecord implements Serializable{

	String date;
	double expense;

	public ExpenseRecord(double expense) {
		this.expense = expense;
		SimpleDateFormat dt = new SimpleDateFormat("YYYY-MM-dd"); 
		date = dt.format(new Date());
		//date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
	}
	
	// used for test
	public ExpenseRecord(double expense, String date) {
		this.expense = expense;
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd"); 
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	public double getExpense() {
		return expense;
	}
	
	public void setExpense(double expense) {
		this.expense = expense;
	}
	
	public String toString() {
		String s = date + ": ";
		s += expense;
		return s;
	}
	
	public static void main(String[] args) {

		ExpenseRecord expenseRecord = new ExpenseRecord(1);
		ExpenseRecord expenseRecord1 = new ExpenseRecord(2, "2016-05-23");
		ExpenseRecord expenseRecord2 = new ExpenseRecord(3, "2016-05-24");
		
		System.out.println(expenseRecord);
		System.out.println(expenseRecord1);
		System.out.println(expenseRecord2);
	}
}

