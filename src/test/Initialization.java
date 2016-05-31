package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import coen275project.*;

public class Initialization {
	public static void main(String[] args) {

		/**************************************
		 * create user_1000
		 **********************************************************/

		// card
		Card card_1000 = new Card("1000", "0000");
		// expense profile
		List<ExpenseRecord> expenseList_1000 = new ArrayList<>();
		ExpenseRecord er = new ExpenseRecord("2016-05-03", 20, "user_1000_0", "VendingMachine1");
		expenseList_1000.add(er);
		er = new ExpenseRecord("2016-05-03", 10, "user_1000_0", "VendingMachine2");
		expenseList_1000.add(er);
		er = new ExpenseRecord("2016-05-04", 30, "user_1000_0", "VendingMachine1");
		expenseList_1000.add(er);
		er = new ExpenseRecord("2016-05-05", 40, "user_1000_0", "VendingMachine2");
		expenseList_1000.add(er);
		er = new ExpenseRecord("2016-05-06", 20, "user_1000_0", "VendingMachine1");
		expenseList_1000.add(er);
		er = new ExpenseRecord("2016-05-07", 20, "user_1000_0", "VendingMachine2");
		expenseList_1000.add(er);
		er = new ExpenseRecord(30, "user_1000_0", "Cafe1");
		expenseList_1000.add(er);
		er = new ExpenseRecord(20, "user_1000_0", "Cafe2");
		expenseList_1000.add(er);
		ExpenseProfile expenseProfile_1000 = new ExpenseProfile("1000", "user_1000_0", 1000, 800, 120, "2016-05",
				expenseList_1000);
		// dietary profile
		List<DietaryRecord> dietaryList_1000 = new ArrayList<>();
		DietaryRecord dr = new DietaryRecord("2016-05-03", 20, "user_1000_0");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-08", 20, "user_1000_0");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-09", 20, "user_1000_0");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-13", 20, "user_1000_0");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-15", 20, "user_1000_0");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-17", 20, "user_1000_0");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-18", 30, "user_1000_0");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-20", 30, "user_1000_0");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-21", 20, "user_1000_0");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-22", 10, "user_1000_0");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord(30, "user_1000_0");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord(20, "user_1000_0");
		dietaryList_1000.add(dr);
		DietaryProfile dietaryProfile_1000 = new DietaryProfile("1000", "user_1000_0", 2000, 1600, 0, "2016-05",
				"2016-05-27", dietaryList_1000, true, false, false);
		// user
		User user_1000 = new User("user_1000_0", card_1000);
		user_1000.setExtensionNumber(0);
		user_1000.setExpenseProfile(expenseProfile_1000);
		user_1000.setDietaryProfile(dietaryProfile_1000);


		/**************************************
		 * create user_1001
		 **********************************************************/

		// card
		Card card_1001 = new Card("1001", "0000");
		// expense profile
		List<ExpenseRecord> expenseList_1001 = new ArrayList<>();
		er = new ExpenseRecord("2016-05-03", 20, "user_1001_0", "VendingMachine1");
		expenseList_1001.add(er);
		er = new ExpenseRecord("2016-05-03", 10, "user_1001_0", "VendingMachine2");
		expenseList_1001.add(er);
		er = new ExpenseRecord("2016-05-04", 30, "user_1001_0", "VendingMachine1");
		expenseList_1001.add(er);
		er = new ExpenseRecord("2016-05-05", 40, "user_1001_0", "VendingMachine2");
		expenseList_1001.add(er);
		er = new ExpenseRecord("2016-05-06", 20, "user_1001_0", "VendingMachine1");
		expenseList_1001.add(er);
		er = new ExpenseRecord("2016-05-07", 20, "user_1001_0", "VendingMachine2");
		expenseList_1001.add(er);
		er = new ExpenseRecord(30, "user_1001_0", "Cafe1");
		expenseList_1001.add(er);
		er = new ExpenseRecord(20, "user_1001_0", "Cafe2");
		expenseList_1001.add(er);
		ExpenseProfile expenseProfile_1001 = new ExpenseProfile("1001", "user_1001_0", 1000, 800, 120, "2016-05",
				expenseList_1001);
		// dietary profile
		List<DietaryRecord> dietaryList_1001 = new ArrayList<>();
		dr = new DietaryRecord("2016-05-03", 20, "user_1001_0");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-08", 20, "user_1001_0");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-09", 20, "user_1001_0");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-13", 20, "user_1001_0");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-15", 20, "user_1001_0");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-17", 20, "user_1001_0");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-18", 30, "user_1001_0");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-20", 30, "user_1001_0");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-21", 20, "user_1001_0");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-22", 10, "user_1001_0");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord(30, "user_1001_0");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord(20, "user_1001_0");
		dietaryList_1001.add(dr);
		DietaryProfile dietaryProfile_1001 = new DietaryProfile("1001", "user_1001_0", 2000, 1600, 0, "2016-05",
				"2016-05-27", dietaryList_1001, true, false, true);
		// user
		User user_1001 = new User("user_1001_0", card_1001);
		user_1001.setExtensionNumber(0);
		user_1001.setExpenseProfile(expenseProfile_1001);
		user_1001.setDietaryProfile(dietaryProfile_1001);

		
		/**************************************
		 * create user_1002_10
		 **********************************************************/

		// card
		Card card_1002 = new Card("1002", "0000");
		// expense profile
		List<ExpenseRecord> expenseList_1002_10 = new ArrayList<>();
		er = new ExpenseRecord("2016-05-03", 20, "user_1002_10", "VendingMachine1");
		expenseList_1002_10.add(er);
		er = new ExpenseRecord("2016-05-03", 10, "user_1002_10", "VendingMachine2");
		expenseList_1002_10.add(er);
		er = new ExpenseRecord("2016-05-04", 30, "user_1002_10", "VendingMachine1");
		expenseList_1002_10.add(er);
		er = new ExpenseRecord("2016-05-05", 40, "user_1002_10", "VendingMachine2");
		expenseList_1002_10.add(er);
		er = new ExpenseRecord("2016-05-06", 20, "user_1002_10", "VendingMachine1");
		expenseList_1002_10.add(er);
		er = new ExpenseRecord("2016-05-07", 20, "user_1002_10", "VendingMachine2");
		expenseList_1002_10.add(er);
		er = new ExpenseRecord(30, "user_1002_10", "Cafe1");
		expenseList_1002_10.add(er);
		er = new ExpenseRecord(20, "user_1002_10", "Cafe2");
		expenseList_1002_10.add(er);
		ExpenseProfile expenseProfile_1002_10 = new ExpenseProfile("1002", "user_1002_10", 1000, 800, 120, "2016-05",
				expenseList_1002_10);
		// dietary profile
		List<DietaryRecord> dietaryList_1002_10 = new ArrayList<>();
		dr = new DietaryRecord("2016-05-03", 20, "user_1002_10");
		dietaryList_1002_10.add(dr);
		dr = new DietaryRecord("2016-05-08", 20, "user_1002_10");
		dietaryList_1002_10.add(dr);
		dr = new DietaryRecord("2016-05-09", 20, "user_1002_10");
		dietaryList_1002_10.add(dr);
		dr = new DietaryRecord("2016-05-13", 20, "user_1002_10");
		dietaryList_1002_10.add(dr);
		dr = new DietaryRecord("2016-05-15", 20, "user_1002_10");
		dietaryList_1002_10.add(dr);
		dr = new DietaryRecord("2016-05-17", 20, "user_1002_10");
		dietaryList_1002_10.add(dr);
		dr = new DietaryRecord("2016-05-18", 30, "user_1002_10");
		dietaryList_1002_10.add(dr);
		dr = new DietaryRecord("2016-05-20", 30, "user_1002_10");
		dietaryList_1002_10.add(dr);
		dr = new DietaryRecord("2016-05-21", 20, "user_1002_10");
		dietaryList_1002_10.add(dr);
		dr = new DietaryRecord("2016-05-22", 10, "user_1002_10");
		dietaryList_1002_10.add(dr);
		dr = new DietaryRecord(30, "user_1002_10");
		dietaryList_1002_10.add(dr);
		dr = new DietaryRecord(20, "user_1002_10");
		dietaryList_1002_10.add(dr);
		DietaryProfile dietaryProfile_1002_10 = new DietaryProfile("1002", "user_1002_10", 2000, 1600, 0, "2016-05",
				"2016-05-27", dietaryList_1002_10, true, false, true);
		// user
		User user_1002_10 = new User("user_1002_10", card_1002);
		user_1002_10.setExtensionNumber(10);
		user_1002_10.setExpenseProfile(expenseProfile_1002_10);
		user_1002_10.setDietaryProfile(dietaryProfile_1002_10);

		
		
		/**************************************
		 * create user_1002_2
		 **********************************************************/

		// card
		
		// expense profile
		List<ExpenseRecord> expenseList_1002_11 = new ArrayList<>();
		er = new ExpenseRecord("2016-05-03", 20, "user_1002_11", "VendingMachine1");
		expenseList_1002_11.add(er);
		er = new ExpenseRecord("2016-05-03", 10, "user_1002_11", "VendingMachine2");
		expenseList_1002_11.add(er);
		er = new ExpenseRecord("2016-05-04", 30, "user_1002_11", "VendingMachine1");
		expenseList_1002_11.add(er);
		er = new ExpenseRecord("2016-05-05", 40, "user_1002_11", "VendingMachine2");
		expenseList_1002_11.add(er);
		er = new ExpenseRecord("2016-05-06", 20, "user_1002_11", "VendingMachine1");
		expenseList_1002_11.add(er);
		er = new ExpenseRecord("2016-05-07", 20, "user_1002_11", "VendingMachine2");
		expenseList_1002_11.add(er);
		er = new ExpenseRecord(30, "user_1002_11", "Cafe1");
		expenseList_1002_11.add(er);
		er = new ExpenseRecord(20, "user_1002_11", "Cafe2");
		expenseList_1002_11.add(er);
		ExpenseProfile expenseProfile_1002_11 = new ExpenseProfile("1002", "user_1002_11", 1000, 800, 120, "2016-05",
				expenseList_1002_11);
		// dietary profile
		List<DietaryRecord> dietaryList_1002_11 = new ArrayList<>();
		dr = new DietaryRecord("2016-05-03", 20, "user_1002_11");
		dietaryList_1002_11.add(dr);
		dr = new DietaryRecord("2016-05-08", 20, "user_1002_11");
		dietaryList_1002_11.add(dr);
		dr = new DietaryRecord("2016-05-09", 20, "user_1002_11");
		dietaryList_1002_11.add(dr);
		dr = new DietaryRecord("2016-05-13", 20, "user_1002_11");
		dietaryList_1002_11.add(dr);
		dr = new DietaryRecord("2016-05-15", 20, "user_1002_11");
		dietaryList_1002_11.add(dr);
		dr = new DietaryRecord("2016-05-17", 20, "user_1002_11");
		dietaryList_1002_11.add(dr);
		dr = new DietaryRecord("2016-05-18", 30, "user_1002_11");
		dietaryList_1002_11.add(dr);
		dr = new DietaryRecord("2016-05-20", 30, "user_1002_11");
		dietaryList_1002_11.add(dr);
		dr = new DietaryRecord("2016-05-21", 20, "user_1002_11");
		dietaryList_1002_11.add(dr);
		dr = new DietaryRecord("2016-05-22", 10, "user_1002_11");
		dietaryList_1002_11.add(dr);
		dr = new DietaryRecord(30, "user_1002_11");
		dietaryList_1002_11.add(dr);
		dr = new DietaryRecord(20, "user_1002_11");
		dietaryList_1002_11.add(dr);
		DietaryProfile dietaryProfile_1002_11 = new DietaryProfile("1002", "user_1002_11", 2000, 1600, 0, "2016-05",
				"2016-05-27", dietaryList_1002_11, true, false, true);
		// user
		User user_1002_11 = new User("user_1002_11", card_1002);
		user_1002_11.setExtensionNumber(11);
		user_1002_11.setExpenseProfile(expenseProfile_1002_11);
		user_1002_11.setDietaryProfile(dietaryProfile_1002_11);

		
		
		/***************************
		 * check users
		 **********************************************************/
		
		// succeed
//		System.out.println(user_1000);
//		System.out.println(user_1001);
//		System.out.println(user_1002_10);
//		System.out.println(user_1002_2);
		
		
		
		/***************************
		 * serialization
		 **********************************************************/

		// cards.ser
//		HashMap<String, String> cardhashmap = new HashMap<>();
//		cardhashmap.put(card_1000.getCardNumber(), card_1000.getPassword());
//		cardhashmap.put(card_1001.getCardNumber(), card_1001.getPassword());
//		cardhashmap.put(card_1002.getCardNumber(), card_1002.getPassword());
//		
//
//		Serialization.serialize(cardhashmap, "database/cards.ser");
//		
//		// individual card
//		Serialization.serialize(card_1000, "database/card_1000.ser");
//		Serialization.serialize(card_1001, "database/card_1001.ser");
//		Serialization.serialize(card_1002, "database/card_1002.ser");
//		
//		// user
//		Serialization.serialize(user_1000, "database/user_1000_0.ser");
//		Serialization.serialize(user_1001, "database/user_1001_0.ser");
//		Serialization.serialize(user_1002_10, "database/user_1002_10.ser");
//		Serialization.serialize(user_1002_11, "database/user_1002_11.ser");
//		System.out.println("finish.");
		
		
		/***************************
		 * deserialization
		 **********************************************************/
		
//		card_1000 = null;
//		card_1001 = null;
//		card_1002 = null;
		//user_1000 = null;
//		user_1001 = null;
//		user_1002_10 = null;
//		user_1002_11 = null;
		card_1000 = Serialization.deSerialize("database/card_1000.ser");
//		card_1001 = Serialization.deSerialize("database/card_1001.ser");
//		card_1002 = Serialization.deSerialize("database/card_1002.ser");
		user_1000 = Serialization.deSerialize("database/user_1000_0.ser");
//		user_1001 = Serialization.deSerialize("database/user_1001_0.ser");
//		user_1002_10 = Serialization.deSerialize("database/user_1002_10.ser");
//		user_1002_11 = Serialization.deSerialize("database/user_1002_11.ser");
//		cardhashmap = null;
//		cardhashmap = Serialization.deSerialize("database/cards.ser");
//		
//		// succeed
		//System.out.println("card_1000" + "\n" + card_1000 + "\n");
//		System.out.println("card_1001" + "\n" + card_1001 + "\n");
//		System.out.println("card_1002" + "\n" + card_1002 + "\n");
		//System.out.println("user_1000" + "\n" + user_1000 + "\n");
//		System.out.println("user_1001" + "\n" + user_1001 + "\n");
//		System.out.println("user_1002_10" + "\n" + user_1002_10 + "\n");
//		System.out.println("user_1002_11" + "\n" + user_1002_11 + "\n");
//		System.out.println(cardhashmap);
		
		System.out.println("****************************************");
		System.out.println(card_1000.getTotalBalance());
		System.out.println(user_1000.getCard().getTotalBalance());
	
		user_1000.getCard().deductMoney(100);
		System.out.println(user_1000.getCard().getTotalBalance());
		user_1000.getCard().deductMoney(100);
		System.out.println(user_1000.getCard().getTotalBalance());
		Serialization.serialize(user_1000, "database/user_1000_0.ser");
	}

}
