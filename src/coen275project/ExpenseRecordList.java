package coen275project;

import java.util.List;

import java.util.ArrayList;
import java.util.Date;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;


/*
 * My Note:
 * 1. work flow
 *    a. user login: deserialize cardnumber.ser from memory. don't need to check whether within 30 days.
 *    b. user update profile or buy item: initialize the profile(clear List)
 * 2. 
 *    usercase1: the user login, and doesn't have a profile
 *    usercase2: the user login, and has a profile
 *    usercase3: the user update profile
 *    usercase4: the user buy item
 * 
 * 
 * Question:
 * 
 * 
 * 
 * TODO:
 * 1. DONE:whenever updated, serializable 
 * 2. whenever updated, synchronized
 * 2. everytime when add record, need to check whether reach the end of period
 *    there may be only 15 records, but 30 days has past.
 */

/**
 * The ExpenseRecordList records expense records of a period time(30 days), everytime when user logs in,
 * ExpenseRecordList will read NoXXX_expenserecordlist.txt from memory and check whether reaching 30days, 
 * if so, record date of today and empty the records before.
 * 
 * @author June
 *
 */

public class ExpenseRecordList implements Serializable{
	public static final int MONTH_PERIOD = 30;
	
	// TODO
	// what is firstDay
	// way 1: if I don't consume today, is today the firstDay, now, it is.
	// way 2: i can view the last period, but when I update preference or buy something, the firstDay will will update.
	private String firstDay;
	private List<ExpenseRecord> expenseRecordList;
	
	// TODO need a cardnumber to serialization
	private Card card;
	
	//usercase1: the user doesn't have a profile
	//usercase3: the user update profile
	public ExpenseRecordList() {
		// initialization
		expenseRecordList = new ArrayList<ExpenseRecord>();
		SimpleDateFormat df1 = new SimpleDateFormat("YYYY-MM-dd"); 
		firstDay = df1.format(new Date());
		//firstDay = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		// store
		Serialization.serialize(this, "No.001.ser");
		
	}
	
	// usercase2: the user login, and has a profile
	// in the main function, deserilize the cardnumber.ser and pass the argument
	public ExpenseRecordList(ExpenseRecordList oldExpenseRecordList) { 
		// initialized from cardnumber.ser
		this.firstDay = oldExpenseRecordList.firstDay;
		this.expenseRecordList = oldExpenseRecordList.expenseRecordList;
		
		// don't need to check within or without period

	}
	// usercase4: the user buy item
	// when user buy items, need to check weather within in period 
	// whether fund is enough => check in the profile class
	public boolean updateExpenseRecordList(ExpenseRecord expenseRecord) { 
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		if(!CalculationData.isWithinPeriod(today, firstDay)) {
			return false;
		}
		
		// add the record or update the last record
		this.add(expenseRecord);
		return true;
		
//		if(!CalculationData.isWithinPeriod(today, firstDay)) {
//			expenseRecordList = new ArrayList<ExpenseRecord>();
//			SimpleDateFormat df2 = new SimpleDateFormat("YYYY-MM-dd"); 
//			firstDay = df2.format(new Date());
//			// clear .ser
//			Serialization.serialize(this, "No.001.ser");
//		}
	}
	
	// add a record to the list or update the last record
	private void add(ExpenseRecord expenseRecord) {
		if (isSameDay(expenseRecord.getDate())) {
			update(expenseRecord.getExpense());
		} else {
			expenseRecordList.add(expenseRecord);			
		}
	}
	
	// compare today and the last date of the record
	private boolean isSameDay(String date) {
		// get the last day in the record
		if (expenseRecordList.isEmpty()) {
			return false;
		}
		String today = expenseRecordList.get(expenseRecordList.size() - 1).getDate();
		return today.equals(date);
	}
	
	// update the last record
	private void update(double expense) {
		double newExpense = expenseRecordList.get(expenseRecordList.size() - 1).getExpense() + expense;
		expenseRecordList.get(expenseRecordList.size() - 1).setExpense(newExpense);
	}
	
	
	public List<ExpenseRecord> getList() {
		return expenseRecordList;
	}
	
	public String getFirstDay() {
		return firstDay;
	}


	
	// TODO
	// may be used for dietary profile => change to public static class
	static class CalculationData {
		
		public static boolean isWithinPeriod(String newDay, String oldDay) {
			// covert to data pbject
			String[] data_array = newDay.split("-");
			int new_year = Integer.parseInt(data_array[0]);
			int new_month = Integer.parseInt(data_array[1]);
			int new_day = Integer.parseInt(data_array[2]);
			Date newDate = new Date(new_year, new_month, new_day);
			
			data_array = oldDay.split("-");
			int old_year = Integer.parseInt(data_array[0]);
			int old_month = Integer.parseInt(data_array[1]);
			int old_day = Integer.parseInt(data_array[2]);
			Date oldDate = new Date(new_year, new_month, new_day);
			
			// subtract and cover milliseconds to days
			long diff_millisecond = newDate.getTime() - newDate.getTime();
			long diff_day = diff_millisecond/1000/60/60/24;
			
			// compare
			return diff_day < MONTH_PERIOD;
		}
	}
	
	
	
	@Override
	public String toString() {
		String s = "First Day begins at: " + firstDay + "\n";
		s += expenseRecordList.toString();
		return s;
	}
	
	public static void main(String[] args) {
		/*
		System.out.println("test serialization...");
		ExpenseRecordList expenseRecordList = new ExpenseRecordList();
		ExpenseRecord expenseRecord = new ExpenseRecord(1);
		ExpenseRecord expenseRecord1 = new ExpenseRecord(2, "2016-05-23");
		ExpenseRecord expenseRecord2 = new ExpenseRecord(3, "2016-05-24");
		expenseRecordList.add(expenseRecord);
		expenseRecordList.add(expenseRecord1);
		expenseRecordList.add(expenseRecord2);
		System.out.println(expenseRecordList);
		*/
		
		System.out.println("test initialization within period and without period...");
		
		
	}
	
}

