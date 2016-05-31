package test;

import java.util.ArrayList;
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
		ExpenseRecord er = new ExpenseRecord("2016-05-03", 20, "user_1000", "VendingMachine1");
		expenseList_1000.add(er);
		er = new ExpenseRecord("2016-05-03", 10, "user_1000", "VendingMachine2");
		expenseList_1000.add(er);
		er = new ExpenseRecord("2016-05-04", 30, "user_1000", "VendingMachine1");
		expenseList_1000.add(er);
		er = new ExpenseRecord("2016-05-05", 40, "user_1000", "VendingMachine2");
		expenseList_1000.add(er);
		er = new ExpenseRecord("2016-05-06", 20, "user_1000", "VendingMachine1");
		expenseList_1000.add(er);
		er = new ExpenseRecord("2016-05-07", 20, "user_1000", "VendingMachine2");
		expenseList_1000.add(er);
		er = new ExpenseRecord(30, "user_1000", "Cafe1");
		expenseList_1000.add(er);
		er = new ExpenseRecord(20, "user_1000", "Cafe2");
		expenseList_1000.add(er);
		ExpenseProfile expenseProfile_1000 = new ExpenseProfile("1000", "user_1000", 1000, 800, 120, "2016-05",
				expenseList_1000);
		// dietary profile
		List<DietaryRecord> dietaryList_1000 = new ArrayList<>();
		DietaryRecord dr = new DietaryRecord("2016-05-03", 20, "user_1000");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-08", 20, "user_1000");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-09", 20, "user_1000");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-13", 20, "user_1000");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-15", 20, "user_1000");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-17", 20, "user_1000");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-18", 30, "user_1000");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-20", 30, "user_1000");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-21", 20, "user_1000");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord("2016-05-22", 10, "user_1000");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord(30, "user_1000");
		dietaryList_1000.add(dr);
		dr = new DietaryRecord(20, "user_1000");
		dietaryList_1000.add(dr);
		DietaryProfile dietaryProfile_1000 = new DietaryProfile("1000", "user_1000", 2000, 1600, 0, "2016-05",
				"2016-05-27", dietaryList_1000, true, false, false);
		// user
		User user_1000 = new User("user_1000", card_1000);
		user_1000.setExpenseProfile(expenseProfile_1000);
		user_1000.setDietaryProfile(dietaryProfile_1000);


		/**************************************
		 * create user_1001
		 **********************************************************/

		// card
		Card card_1001 = new Card("1001", "0000");
		// expense profile
		List<ExpenseRecord> expenseList_1001 = new ArrayList<>();
		er = new ExpenseRecord("2016-05-03", 20, "user_1001", "VendingMachine1");
		expenseList_1001.add(er);
		er = new ExpenseRecord("2016-05-03", 10, "user_1001", "VendingMachine2");
		expenseList_1001.add(er);
		er = new ExpenseRecord("2016-05-04", 30, "user_1001", "VendingMachine1");
		expenseList_1001.add(er);
		er = new ExpenseRecord("2016-05-05", 40, "user_1001", "VendingMachine2");
		expenseList_1001.add(er);
		er = new ExpenseRecord("2016-05-06", 20, "user_1001", "VendingMachine1");
		expenseList_1001.add(er);
		er = new ExpenseRecord("2016-05-07", 20, "user_1001", "VendingMachine2");
		expenseList_1001.add(er);
		er = new ExpenseRecord(30, "user_1001", "Cafe1");
		expenseList_1001.add(er);
		er = new ExpenseRecord(20, "user_1001", "Cafe2");
		expenseList_1001.add(er);
		ExpenseProfile expenseProfile_1001 = new ExpenseProfile("1001", "user_1001", 1000, 800, 120, "2016-05",
				expenseList_1001);
		// dietary profile
		List<DietaryRecord> dietaryList_1001 = new ArrayList<>();
		dr = new DietaryRecord("2016-05-03", 20, "user_1001");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-08", 20, "user_1001");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-09", 20, "user_1001");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-13", 20, "user_1001");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-15", 20, "user_1001");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-17", 20, "user_1001");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-18", 30, "user_1001");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-20", 30, "user_1001");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-21", 20, "user_1001");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord("2016-05-22", 10, "user_1001");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord(30, "user_1001");
		dietaryList_1001.add(dr);
		dr = new DietaryRecord(20, "user_1001");
		dietaryList_1001.add(dr);
		DietaryProfile dietaryProfile_1001 = new DietaryProfile("1001", "user_1001", 2000, 1600, 0, "2016-05",
				"2016-05-27", dietaryList_1001, true, false, true);
		// user
		User user_1001 = new User("user_1001", card_1001);
		user_1001.setExpenseProfile(expenseProfile_1001);
		user_1001.setDietaryProfile(dietaryProfile_1001);

		
		/**************************************
		 * create user_1002_1
		 **********************************************************/

		// card
		Card card_1002 = new Card("1002", "0000");
		// expense profile
		List<ExpenseRecord> expenseList_1002_1 = new ArrayList<>();
		er = new ExpenseRecord("2016-05-03", 20, "user_1002_1", "VendingMachine1");
		expenseList_1002_1.add(er);
		er = new ExpenseRecord("2016-05-03", 10, "user_1002_1", "VendingMachine2");
		expenseList_1002_1.add(er);
		er = new ExpenseRecord("2016-05-04", 30, "user_1002_1", "VendingMachine1");
		expenseList_1002_1.add(er);
		er = new ExpenseRecord("2016-05-05", 40, "user_1002_1", "VendingMachine2");
		expenseList_1002_1.add(er);
		er = new ExpenseRecord("2016-05-06", 20, "user_1002_1", "VendingMachine1");
		expenseList_1002_1.add(er);
		er = new ExpenseRecord("2016-05-07", 20, "user_1002_1", "VendingMachine2");
		expenseList_1002_1.add(er);
		er = new ExpenseRecord(30, "user_1002_1", "Cafe1");
		expenseList_1002_1.add(er);
		er = new ExpenseRecord(20, "user_1002_1", "Cafe2");
		expenseList_1002_1.add(er);
		ExpenseProfile expenseProfile_1002_1 = new ExpenseProfile("1002_1", "user_1002_1", 1000, 800, 120, "2016-05",
				expenseList_1001);
		// dietary profile
		List<DietaryRecord> dietaryList_1002_1 = new ArrayList<>();
		dr = new DietaryRecord("2016-05-03", 20, "user_1002_1");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-05-08", 20, "user_1002_1");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-05-09", 20, "user_1002_1");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-05-13", 20, "user_1002_1");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-05-15", 20, "user_1002_1");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-05-17", 20, "user_1002_1");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-05-18", 30, "user_1002_1");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-05-20", 30, "user_1002_1");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-05-21", 20, "user_1002_1");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-05-22", 10, "user_1002_1");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord(30, "user_1002_1");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord(20, "user_1002_1");
		dietaryList_1002_1.add(dr);
		DietaryProfile dietaryProfile_1002_1 = new DietaryProfile("1002", "user_1002_1", 2000, 1600, 0, "2016-05",
				"2016-05-27", dietaryList_1002_1, true, false, true);
		// user
		User user_1002_1 = new User("user_1002_1", card_1002);
		user_1002_1.setExpenseProfile(expenseProfile_1002_1);
		user_1002_1.setDietaryProfile(dietaryProfile_1002_1);

		
		
		/**************************************
		 * create user_1002_2
		 **********************************************************/

		// card
		
		// expense profile
		List<ExpenseRecord> expenseList_1002_2 = new ArrayList<>();
		er = new ExpenseRecord("2016-05-03", 20, "user_1002_2", "VendingMachine1");
		expenseList_1002_2.add(er);
		er = new ExpenseRecord("2016-05-03", 10, "user_1002_2", "VendingMachine2");
		expenseList_1002_2.add(er);
		er = new ExpenseRecord("2016-05-04", 30, "user_1002_2", "VendingMachine1");
		expenseList_1002_2.add(er);
		er = new ExpenseRecord("2016-05-05", 40, "user_1002_2", "VendingMachine2");
		expenseList_1002_2.add(er);
		er = new ExpenseRecord("2016-05-06", 20, "user_1002_2", "VendingMachine1");
		expenseList_1002_2.add(er);
		er = new ExpenseRecord("2016-05-07", 20, "user_1002_2", "VendingMachine2");
		expenseList_1002_2.add(er);
		er = new ExpenseRecord(30, "user_1002_2", "Cafe1");
		expenseList_1002_2.add(er);
		er = new ExpenseRecord(20, "user_1002_2", "Cafe2");
		expenseList_1002_2.add(er);
		ExpenseProfile expenseProfile_1002_2 = new ExpenseProfile("1002", "user_1002_2", 1000, 800, 120, "2016-05",
				expenseList_1001);
		// dietary profile
		List<DietaryRecord> dietaryList_1002_2 = new ArrayList<>();
		dr = new DietaryRecord("2016-05-03", 20, "user_1002_2");
		dietaryList_1002_2.add(dr);
		dr = new DietaryRecord("2016-05-08", 20, "user_1002_2");
		dietaryList_1002_2.add(dr);
		dr = new DietaryRecord("2016-05-09", 20, "user_1002_2");
		dietaryList_1002_2.add(dr);
		dr = new DietaryRecord("2016-05-13", 20, "user_1002_2");
		dietaryList_1002_2.add(dr);
		dr = new DietaryRecord("2016-05-15", 20, "user_1002_2");
		dietaryList_1002_2.add(dr);
		dr = new DietaryRecord("2016-05-17", 20, "user_1002_2");
		dietaryList_1002_2.add(dr);
		dr = new DietaryRecord("2016-05-18", 30, "user_1002_2");
		dietaryList_1002_2.add(dr);
		dr = new DietaryRecord("2016-05-20", 30, "user_1002_2");
		dietaryList_1002_2.add(dr);
		dr = new DietaryRecord("2016-05-21", 20, "user_1002_2");
		dietaryList_1002_2.add(dr);
		dr = new DietaryRecord("2016-05-22", 10, "user_1002_2");
		dietaryList_1002_2.add(dr);
		dr = new DietaryRecord(30, "user_1002_2");
		dietaryList_1002_2.add(dr);
		dr = new DietaryRecord(20, "user_1002_2");
		dietaryList_1002_2.add(dr);
		DietaryProfile dietaryProfile_1002_2 = new DietaryProfile("1002", "user_1002_2", 2000, 1600, 0, "2016-05",
				"2016-05-27", dietaryList_1002_2, true, false, true);
		// user
		User user_1002_2 = new User("user_1002_2", card_1002);
		user_1002_2.setExpenseProfile(expenseProfile_1002_2);
		user_1002_2.setDietaryProfile(dietaryProfile_1002_2);

		
		
		/***************************
		 * check users
		 **********************************************************/
		
		// succeed
//		System.out.println(user_1000);
//		System.out.println(user_1001);
//		System.out.println(user_1002_1);
//		System.out.println(user_1002_2);
		
		
		
		/***************************
		 * serialization
		 **********************************************************/

		// cards.ser
		HashSet<Card> cardhashset = new HashSet<>();
		cardhashset.add(card_1000);
		cardhashset.add(card_1001);
		cardhashset.add(card_1002);
		Serialization.serialize(cardhashset, "database/cards.ser");
		
		// individual card
		Serialization.serialize(card_1000, "database/card_1000.ser");
		Serialization.serialize(card_1001, "database/card_1001.ser");
		Serialization.serialize(card_1002, "database/card_1002.ser");
		
		// user
		Serialization.serialize(user_1000, "database/user_1000.ser");
		Serialization.serialize(user_1001, "database/user_1001.ser");
		Serialization.serialize(user_1002_1, "database/user_1002_1.ser");
		Serialization.serialize(user_1002_1, "database/user_1002_2.ser");
		System.out.println("finish.");
		
		
		/***************************
		 * deserialization
		 **********************************************************/
		
		card_1000 = null;
		card_1001 = null;
		card_1002 = null;
		user_1000 = null;
		user_1001 = null;
		user_1002_1 = null;
		user_1002_2 = null;
		card_1000 = Serialization.deSerialize("database/card_1000.ser");
		card_1001 = Serialization.deSerialize("database/card_1001.ser");
		card_1002 = Serialization.deSerialize("database/card_1002.ser");
		user_1000 = Serialization.deSerialize("database/user_1000.ser");
		user_1001 = Serialization.deSerialize("database/user_1001.ser");
		user_1002_1 = Serialization.deSerialize("database/user_1002_1.ser");
		user_1002_2 = Serialization.deSerialize("database/user_1002_2.ser");
		cardhashset = null;
		cardhashset = Serialization.deSerialize("database/cards.ser");
		
		// succeed
//		System.out.println("card_1000" + "\n" + card_1000 + "\n");
//		System.out.println("card_1001" + "\n" + card_1001 + "\n");
//		System.out.println("card_1002" + "\n" + card_1002 + "\n");
//		System.out.println("user_1000" + "\n" + user_1000 + "\n");
//		System.out.println("user_1001" + "\n" + user_1001 + "\n");
//		System.out.println("user_1002_1" + "\n" + user_1002_1 + "\n");
//		System.out.println("user_1002_2" + "\n" + user_1002_2 + "\n");
		
		
		
	}

}
