package coen275project;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DietaryRecord implements Serializable{
	private String date;
	private int expense;
	private String userName;				// record user name
	
	
	public DietaryRecord(int expense, String userName) {
		this.date = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
		this.expense = expense;
		this.userName = userName;
	}
	
	// for test
	public DietaryRecord(String date, int expense, String userName) {
		this.date = date;
		this.expense = expense;
		this.userName = userName;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getExpense() {
		return expense;
	}
	public void setExpense(int expense) {
		this.expense = expense;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "\n" + "date=" + date + ", expense=" + expense + ", userName=" + userName;
	}
	
	

}
