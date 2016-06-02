package coen275project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
	 * check validation of cardnumber + extension and password when login
	 * if yes, deserilize user.ser (eg: user_1002_1.ser) and card.ser (eg: card_1002.ser)
	 * if not, refuse to login
	 * 
	 * @param cardNumber
	 * @param password
	 * @return
	 */
	public static String loginCheckCard(String cardNumber, String extension, String password) {
		// TODO
		// get input
		
		// TODO : Lifen
		// retrieve 
		HashMap<String, String> cardhashmap = Serialization.deSerialize("/database/cards.ser");
		
		String s = cardhashmap.get(cardNumber);
		if (s != password) {
			return "";
		}
		
		User user = Serialization.deSerialize("/database/user_" + cardNumber + "_" + extension + ".ser");
		loginUpdateExpenseProfile(user);
		loginUpdateDietaryProfile(user);
		return "/database/user_" + cardNumber + "_" + extension + ".ser";
	}
	
	
	/**
	 * check expenseProfile when log in, compare today and period in expenseprofile
	 * if in the same month, do nothing
	 * else, reset expenseProfile
	 * @param user
	 * @return true: if updated
	 *         false: if not updated since it's already with updated state
	 */
	private static boolean loginUpdateExpenseProfile(User user) {
		ExpenseProfile expenseProfile = user.getExpenseProfile();
		String period = expenseProfile.getPeriod();
		if (period == null) {			
			System.err.println("Will Never see this line, in CheckValidation:loginCheckExpenseProfile");
			expenseProfile.reset();
			System.out.println("loginUpdateExpenseProfile: updated");
			return true;
		}
		
		// check if within the same month
		String newMonth = new SimpleDateFormat("YYYY-MM").format(new Date());
		
		if (!newMonth.equals(period)) {
			expenseProfile.reset();
			System.out.println("loginUpdateExpenseProfile: ExpenseProfile is out of updated, System updated it.");
			
			// serialization
			serialization(user);
			return true;	
		}
		
		System.out.println("loginUpdateExpenseProfile: ExpenseProfile has already in updated state. System doesn't update it");
		return false;
	}
	
	/**
	 * check dietaryprofile when log in, compare today and firstDay, date in dietary profile
	 * if without the same month, clear up dietaryRecordList and expense, modify period and today
	 * if without the same day, modify date and clear expense
	 * else, do nothing.
	 * @param dietaryprofile
	 * 
	 * @return true: if updated
	 *         false: if not updated since the user login within the same day
	 */
	private static boolean loginUpdateDietaryProfile(User user) {
		
		DietaryProfile dietaryProfile = user.getDietaryProfile();
		// check if within the same month
		String today = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
		String newMonth = new SimpleDateFormat("YYYY-MM").format(new Date());
		String period = dietaryProfile.getPeriod();
		
		if (!period.equals(newMonth)) {
			dietaryProfile.reset_newmonth();
			System.out.println("loginUpdateDietaryProfile: without the same month, System updated it.");
		}
		
		// check if within the same day
		String date =  dietaryProfile.getDate();
		if (!date.equals(today)) {
			dietaryProfile.reset_newday();
			
			// serialization
			System.out.println("loginUpdateDietaryProfile: without the same day, System updated it.");
			serialization(user);
			return true;
		}
		
		System.out.println("loginUpdateDietaryProfile: DietaryProfile has already in updated state. System doesn't update it");
		return false;
		
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
	public static List<Boolean> buyItem(User user, FoodStore foodStore, float price, int calorie, List<List<Boolean>> foods) {
		// check foods + calorie
		List<Boolean> list = checkDietaryValidation(user,calorie, foods);
	  
		// check expense
		list.add(checkExpenseValidation(user, price));
		
		for (Boolean b : list) {
			if (b == false) {
				return list;
			}
		}
		
		// update ExpenseProfile
		user.getExpenseProfile().setExpense(user.getExpenseProfile().getExpense() + price);
		ExpenseRecord record1 = new ExpenseRecord(price, user.getName(), foodStore.getName());
		user.getExpenseProfile().addExpenseRecord(record1);

		// update DietaryProfile
		user.getDietaryProfile().setExpense(user.getDietaryProfile().getExpense() + calorie);
		// integrate dietaryProfile to everyday has a record against instead of recording every record
		user.getDietaryProfile().addDietaryRecord(new DietaryRecord(calorie, user.getName()));
		
		user.getCard().setTotalBalance();
		
		// serialization
		serialization(user);
		
		return list;
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
		
		// check ExpenseProfile
		if (user.getExpenseProfile().getCurrentFund() <= user.getExpenseProfile().getExpense() + price) {
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
	private static List<Boolean> checkDietaryValidation(User user,int calorie, List<List<Boolean>> foods) {
		boolean lowsugar = user.getDietaryProfile().getLowSugar();
		boolean lowsodium = user.getDietaryProfile().getLowSodium();
		boolean lowcholesterol = user.getDietaryProfile().getLowCholesterol();
		
		List<Boolean> list = new ArrayList<>();
		for (List<Boolean> food: foods) {
			if ( lowsugar == true && food.get(0) == false 
					|| lowsodium == true &&  food.get(1) == false
					|| lowcholesterol == true && food.get(2) == false) {
				list.add(false);
			}
			list.add(true);
		}
		
		list.add(user.getDietaryProfile().getExpense() + calorie <= user.getDietaryProfile().getCurrentCalorie());
		return list;
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
		
		serialization(user);
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
	public static boolean updateDietaryProfile (User user, int newCalorie, boolean lowsugar, boolean lowsodium, boolean lowcholesterol) {
		user.getDietaryProfile().setNextCalorie(newCalorie);
		user.getDietaryProfile().setLowSugar(lowsugar);
		user.getDietaryProfile().setLowSodium(lowsodium);
		user.getDietaryProfile().setLowCholesterol(lowcholesterol);
		
		serialization(user);
		return true;
	}
	
	private static boolean serialization(User user) {
		String cardNumber = user.getCard().getCardNumber();
		String extension = user.getExtensionNumber()+"";
		Serialization.serialize(user, "database/user_" + cardNumber + "_" + extension + ".ser" );
		return true;
	}
	
	
	public static void main(String[] args) {

	}

}
