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


/**
 * The ExpenseRecordList records expense records of a period time(30 days),
 * everytime when user logs in, ExpenseRecordList will read
 * NoXXX_expenserecordlist.ser from memory and check whether reaching 30days, if
 * so, record date of today and empty the records before.
 * 
 * @author June
 *
 */

public class ExpenseRecordList implements Serializable {
//	public static final int MONTH_PERIOD = 30;
//	public static final int WEEK_PERIOD = 7;

//	private String cardNumber; 		
//	private String firstDay;
	private List<ExpenseRecord> expenseRecordList;
	
	// usercase2: the user login
	// in the main function, deserilize the cardnumber.ser and pass the argument
	public ExpenseRecordList(ExpenseRecordList oldExpenseRecordList) {
		// initialized from cardnumber.ser
//		this.cardNumber = oldExpenseRecordList.cardNumber;
//		this.firstDay = oldExpenseRecordList.firstDay;
		this.expenseRecordList = oldExpenseRecordList.expenseRecordList;

//		String today = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
//		// check whether without period
//		if (!CalculationData.isWithinPeriod(today, firstDay)) {
//			reset();
//			Serialization.serialize(this, "database/No.001.ser");
//		}
	}

	// the user update profile
	public ExpenseRecordList() {

		// initialization
		expenseRecordList = new ArrayList<ExpenseRecord>();
//		SimpleDateFormat df1 = new SimpleDateFormat("YYYY-MM-dd");
//		firstDay = df1.format(new Date());
//
//		// firstDay = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//
//		// store
		//Serialization.serialize(this, "database/No.001.ser");

	}

	public void reset() {
		// initialization
		expenseRecordList = new ArrayList<ExpenseRecord>();
//		SimpleDateFormat df1 = new SimpleDateFormat("YYYY-MM-dd");
//		firstDay = df1.format(new Date());

		// firstDay = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		// store
		//Serialization.serialize(this, "database/No.001.ser");

	}

	// usercase4: the user buy item
//	public boolean update(ExpenseRecord expenseRecord) {
		// add the record or update the last record
		
//		if (isSameDay(expenseRecord.getDate())) {
//			update(expenseRecord.getExpense());
//		} else {
//			expenseRecordList.add(expenseRecord);
//		}
//		Serialization.serialize(this, "database/No.001.ser");
//		return true;
//	}

	// compare today and the last date of the record
//	private boolean isSameDay(String date) {
//		// get the last day in the record
//		if (expenseRecordList.isEmpty()) {
//			return false;
//		}
//		String today = expenseRecordList.get(expenseRecordList.size() - 1).getDate();
//		return today.equals(date);
//	}

	// update the last record
//	private void update(double expense) {
//		double newExpense = expenseRecordList.get(expenseRecordList.size() - 1).getExpense() + expense;
//		expenseRecordList.get(expenseRecordList.size() - 1).setExpense(newExpense);
//	}

	public List<ExpenseRecord> getList() {
		return expenseRecordList;
	}

//	public String getFirstDay() {
//		return firstDay;
//	}
//
//	public String getCardNumber() {
//		return cardNumber;
//	}

//	// TODO
//	// may be used for dietary profile => change to public static class
//	// need to test whether the result is correct
//	static class CalculationData {
//
//		public static boolean isWithinPeriod(String newDay, String oldDay) {
//			// covert to data pbject
//			String[] data_array = newDay.split("-");
//			int new_year = Integer.parseInt(data_array[0]);
//			int new_month = Integer.parseInt(data_array[1]);
//			int new_day = Integer.parseInt(data_array[2]);
//			Date newDate = new Date(new_year, new_month, new_day);
//
//			data_array = oldDay.split("-");
//			int old_year = Integer.parseInt(data_array[0]);
//			int old_month = Integer.parseInt(data_array[1]);
//			int old_day = Integer.parseInt(data_array[2]);
//			Date oldDate = new Date(new_year, new_month, new_day);
//
//			// subtract and cover milliseconds to days
//			long diff_millisecond = newDate.getTime() - newDate.getTime();
//			long diff_day = diff_millisecond / 1000 / 60 / 60 / 24;
//
//			// compare
//			return diff_day < MONTH_PERIOD;
//		}
//	}

	@Override
	public String toString() {
		String s = "First Day begins at: " + firstDay + "\n";
		s += expenseRecordList.toString();
		return s;
	}

	public static void main(String[] args) {
		/*
		 * System.out.println("test serialization..."); ExpenseRecordList
		 * expenseRecordList = new ExpenseRecordList(); ExpenseRecord
		 * expenseRecord = new ExpenseRecord(1); ExpenseRecord expenseRecord1 =
		 * new ExpenseRecord(2, "2016-05-23"); ExpenseRecord expenseRecord2 =
		 * new ExpenseRecord(3, "2016-05-24");
		 * expenseRecordList.add(expenseRecord);
		 * expenseRecordList.add(expenseRecord1);
		 * expenseRecordList.add(expenseRecord2);
		 * System.out.println(expenseRecordList);
		 */

		System.out.println("test initialization within period and without period...");

	}

}
