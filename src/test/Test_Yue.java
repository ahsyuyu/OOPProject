package test;

import coen275project.*;
import java.io.*;
import java.util.*;

public class Test_Yue {
	private final static String EXPENSEPROFILE_FILENAME = "database/1_exp.ser";
	private final static String DIETARYPROFILE_FILENAME = "database/1_die.ser";
	
	public static void main(String[] args) {
		
		System.out.println("initialization....");
		
		
		/***************************create card**************/
		System.out.println("");
		System.out.println("create card....");
		
		Card card = new Card("1", "111");			// TODO: totalBalance with defualt value 5000.0f
		
		//System.out.println(card);
		
		
		/***************************create ExpenseProfile**************/
		System.out.println("");
		System.out.println("create ExpenseProfile....");
		
		List<ExpenseRecord> expenseList = new ArrayList<>();
		ExpenseRecord er = new ExpenseRecord("2016-05-03", 20, "June", "VendingMachine1");
		expenseList.add(er);
		er = new ExpenseRecord("2016-05-03", 10, "June", "VendingMachine2");
		expenseList.add(er);
		er = new ExpenseRecord("2016-05-04", 30, "June", "VendingMachine1");
		expenseList.add(er);
		er = new ExpenseRecord("2016-05-05", 40, "June", "VendingMachine2");
		expenseList.add(er);
		er = new ExpenseRecord("2016-05-06", 20, "June", "VendingMachine1");
		expenseList.add(er);
		er = new ExpenseRecord("2016-05-07", 20, "June", "VendingMachine2");
		expenseList.add(er);
		er = new ExpenseRecord(30, "June", "Cafe1");
		expenseList.add(er);
		er = new ExpenseRecord(20, "June", "Cafe2");
		expenseList.add(er);

		ExpenseProfile expenseProfile_1 = new ExpenseProfile(card.getCardNumber(), "June", 1000, 800, 80, "2016-05-01", expenseList);
		
		System.out.println(expenseProfile_1);
		
		
		/***************************create DietaryProfile**************/
		System.out.println("");
		System.out.println("create DietaryProfile....");
		
		List<DietaryRecord> dietaryList = new ArrayList<>();
		DietaryRecord dr = new DietaryRecord("2016-05-03", 20, "June");
		dietaryList.add(dr);
		dr = new DietaryRecord("2016-05-08", 20, "June");
		dietaryList.add(dr);
		dr = new DietaryRecord("2016-05-09", 20, "June");
		dietaryList.add(dr);
		dr = new DietaryRecord("2016-05-13", 20, "June");
		dietaryList.add(dr);
		dr = new DietaryRecord("2016-05-15", 20, "June");
		dietaryList.add(dr);
		dr = new DietaryRecord("2016-05-17", 20, "June");
		dietaryList.add(dr);
		dr = new DietaryRecord("2016-05-18", 30, "June");
		dietaryList.add(dr);
		dr = new DietaryRecord("2016-05-20", 30, "June");
		dietaryList.add(dr);
		dr = new DietaryRecord("2016-05-21", 20, "June");
		dietaryList.add(dr);
		dr = new DietaryRecord("2016-05-22", 10, "June");
		dietaryList.add(dr);
		dr = new DietaryRecord(30, "June");
		dietaryList.add(dr);
		dr = new DietaryRecord(20, "June");
		dietaryList.add(dr);
		
		DietaryProfile dietaryProfile_1 = new DietaryProfile("1", "June", 2000, 1600, 10, "2016-05", "2016-05-27", dietaryList, true, false, false);
		
		System.out.println(dietaryProfile_1);
		
		
		/***************************create User**************/
		System.out.println("");
		System.out.println("create User....");
		
		User user_1 = new User("June", card);
		user_1.setDietaryProfile(dietaryProfile_1);
		user_1.setExpenseProfile(expenseProfile_1);
		user_1.setName("June");
		
		//System.out.println(user_1);
		
		/***************************test serialization expenseProfile**************/
		System.out.println("");
		System.out.println("test serialization and deserialization expenseProfile....");
		
		System.out.print("Before Serializing - \n");
		System.out.println(expenseProfile_1);
		Serialization.serialize(expenseProfile_1, EXPENSEPROFILE_FILENAME);
		System.out.print("After DeSerializing - ");
		expenseProfile_1 = null;
		expenseProfile_1 = Serialization.deSerialize(EXPENSEPROFILE_FILENAME);
		System.out.println(expenseProfile_1);
		
		/***************************test serialization dietaryProfile**************/
		System.out.println("");
		System.out.println("test serialization and deserialization dietaryProfile....");
		
		System.out.print("Before Serializing - \n");
		System.out.println(dietaryProfile_1);
		Serialization.serialize(dietaryProfile_1, DIETARYPROFILE_FILENAME);
		System.out.print("After DeSerializing - ");
		dietaryProfile_1 = null;
		dietaryProfile_1 = Serialization.deSerialize(DIETARYPROFILE_FILENAME);
		System.out.println(dietaryProfile_1);
		
		
		
		/***************************Test login **************/
		
		// TODO

		/***************************Test loginUpdateExpenseProfile **************/
		System.out.println("");
		System.out.println("Test loginUpdateExpenseProfile....");
		
		if(CheckValidation.loginUpdateExpenseProfile(expenseProfile_1)) {
			expenseProfile_1 = Serialization.deSerialize(EXPENSEPROFILE_FILENAME);
			System.out.println("updated expenseProfile is:\n");
			System.out.println(expenseProfile_1);
		}
		
		
		/***************************Test loginUpdateDietaryProfile **************/
		System.out.println("");
		System.out.println("Test loginUpdateExpenseProfile....");
		
		if(CheckValidation.loginUpdateDietaryProfile(dietaryProfile_1)) {
			dietaryProfile_1 = Serialization.deSerialize(DIETARYPROFILE_FILENAME);
			System.out.println("updated dietaryProfile is:\n");
			System.out.println(dietaryProfile_1);
		}
		
		
		/***************************Test GUI**************/
		
		
		
	}
	
	

}
