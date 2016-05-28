package coen275project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


/**
 * is the control class represents use case
 * 
 * @author Yue Liu
 *
 */

//TODO change the class name to make more sense
public class CheckValidation {
	
	/**
	 * check validation of cardnumber and password when login
	 * if not, refuse to login
	 * 
	 * @param cardNumber
	 * @param password
	 * @return
	 */
	public static boolean loginCheckCard(int cardNumber, String password) {
		// TODO
		// deserialize data from card.ser or red data from card.txt
		
		// retrieve and compare
		return true;
	}
	
	
	/**
	 * check expenseProfile when log in, compare today and firstDay in expenseprofile
	 * if in the same month, do nothing, else, reset expenseProfile
	 * @param expenseProfile
	 */
	public static void loginUpdateExpenseProfile(ExpenseProfile expenseProfile) {
		
		String firstDay = expenseProfile.getFirstDay();
		if (firstDay == null) {			
//			return false;
			System.err.println("Will Never see this line, in CheckValidation:loginCheckExpenseProfile");
			expenseProfile.reset();
			
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
			expenseProfile.reset();
		}
		
		//return true;
	}
	
	/**
	 * check dietaryprofile when log in, compare today and firstDay, date in dietary profile
	 * if without the same month, clear up dietaryRecordList and expense, modify firstDay and today
	 * if without the same day, modify date and clear expense
	 * @param dietaryprofile
	 */
	public static void loginUpdateDietaryProfile(DietaryProfile dietaryProfile) {
		// check if within the same month
		String today = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
		String[] temp1 = today.split("-");
		String firstDay = dietaryProfile.getFirstDay();
		String[] temp2 = firstDay.split("-");
		
		if (!temp1[0].equals(temp2[0]) || !temp1[1].equals(temp2[1])) {
			dietaryProfile.setExpense(0);
			dietaryProfile.setList(new ArrayList<DietaryRecord>());
			dietaryProfile.setDate(today);
			dietaryProfile.setFirstDay(temp1[0] + temp1[1] + "01");
		}
		
		// check if within the same day
		String date =  dietaryProfile.getDate();
		if (!date.equals(today)) {
			dietaryProfile.setDate(today);
			dietaryProfile.setExpense(0);
		}
	}
	
	
	/**
	 * 
	 * buy item and update corresponding data.
	 * update ExpenseProfile(expense, list), DietaryProfile(expense, list), Card(totalBalance)
	 * 
	 * @param user
	 * @param foodStore
	 * @param price
	 */
	public static boolean buyItem(User user, FoodStore foodStore, float price, int calorie) {
		if (!checkExpenseValidation(user, price) || !checkDietaryValidation(user,calorie)) {
			return false;
			
		}
		
		// update ExpenseProfile
		user.getExpenseProfile().setExpense(user.getExpenseProfile().getExpense() - price);
		ExpenseRecord record1 = new ExpenseRecord(price, user.getName(), foodStore.getName());
		user.getExpenseProfile().addExpenseRecord(record1);

		// update DietaryProfile
		user.getDietaryProfile().setExpense(user.getDietaryProfile().getExpense() + calorie);
		// integrate dietaryProfile to everyday has a record against instead of recording every record
		user.getDietaryProfile().addDietaryRecord(new DietaryRecord(calorie, user.getName()));
		
		// TODO
		user.getCard().setTotalBalance();
		
		return true;
	}
	
	/**
	 * 
	 * check ExpenseProfile and totalBalance when buy item
	 * 
	 * @param user
	 * @param price
	 * @return true:  if satisfy expense limitation
	 *         false: not satisfy expense limitation
	 */
	private static boolean checkExpenseValidation(User user,float price) {
		//return expenseProfile.getExpense() + food.getPrice()<= expenseProfile.getCurrentFund();
		// check ExpenseProfile
		if (user.getExpenseProfile().getExpense() + price <= user.getExpenseProfile().getCurrentFund()) {
			System.out.println("Exceed limitation fund of the month.");
			return false;
		}
		
		// check totalBalance
		// Since we don't implement deposit, we will initialize totalBalance with a large number
		if (user.getCard().getTotalBalance() < price) {
			System.err.println("Will Never see this line, exceed totalBalance, the user is shopping expert, please re-initialize it to a large number");
			return false;
		}
		
		return true;
	}
	
	/**
	 * check DietaryProfile when buy item
	 * 
	 * @param user
	 * @param calorie
	 * @return true: if satisfy 
	 * 		   false: if not satisfy
	 */
	private static boolean checkDietaryValidation(User user,int calorie) {
		
		return user.getDietaryProfile().getExpense() + calorie <= user.getDietaryProfile().getExpense();
	}
	
	

	
	/**
	 * check validation and update ExpenseProfile(nextFund) 
	 * if satisfy Card(totalBalance), update ExpenseProfile(nextFund)
	 * if not, do nothing
	 * 
	 * @param user
	 * @param newFund
	 * 
	 * @return true: if satisfy
	 *         false: if not satisfy
	 */
	public static boolean updateExpenseProfile (User user,float newFund) {
		// check validation
		// may not need check validation when update ExpenseProfile, since we check totalBalance when buy item
		if(user.getCard().getTotalBalance() < newFund) {
			System.err.println("Will Never see this line, please initialize the totalBlance to a large number");
			return false;
		}
		// update
		user.getExpenseProfile().setNextFund(newFund);
		return true;
	}
	
	/**
	 * update dietaryProfile directly, don't need to check
	 * 
	 * @param user
	 * @param newCalorie
	 * 
	 * @return
	 */
	public static boolean updateDietaryProfile (User user, int newCalorie) {
		// check validation
		
		user.getDietaryProfile().setNextCalorie(newCalorie);
		return true;
	}
	
	
	
	public static void main(String[] args) {

	}

}
