package coen275project;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CheckValidation {
	
	// compare today and firstday in expenseprofile
	public static boolean loginCheck(ExpenseProfile expenseProfile) {
		
		String firstDay = expenseProfile.getFirstDay();
		if (firstDay == null) {
			return false;
		}
		//String[] temp = firstDay.split("-");
		String[] temp1 = firstDay.split("-");
		String yearOfProfile = temp1[0];
		String monthOfProfile = temp1[1];
		
		String today = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
		String[] temp2 = today.split("-");
		String yearOfToday = temp2[0];
		String monthOfToday = temp2[1];
		
		if (yearOfProfile.compareTo(yearOfToday) < 0|| monthOfProfile.compareTo(monthOfToday) < 0) {
			return false;
		}
		
		return true;
	}
	

	public static boolean checkExpenseValidation(ExpenseProfile expenseProfile, Food food) {
		return expenseProfile.getExpense() + food.getFoodPrice<= expenseProfile.getCurrentFund();
		
	}
	
	public static boolean checkDietaryValidation() {
		
		
		return true;
	}
	
	
	// TODO
	public static boolean checkTotalBalance() {
		
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
