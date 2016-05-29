package test;

import coen275project.*;
import java.io.*;
import java.util.*;

public class Test_Yue {
	
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
		er = new ExpenseRecord("2016-05-18", 10, "June", "VendingMachine2");
		expenseList.add(er);
		er = new ExpenseRecord(30, "June", "Cafe1");
		expenseList.add(er);
		er = new ExpenseRecord(20, "June", "Cafe2");
		expenseList.add(er);

		ExpenseProfile expenseProfile_1 = new ExpenseProfile(card.getCardNumber(), "June", 100, 80, 10, "2016-05-01", expenseList);
		
		System.out.println(expenseProfile_1);
		
		
		/***************************create DietaryProfile**************/
		System.out.println("");
		System.out.println("create DietaryProfile....");
		
		List<DietaryRecord> dietaryList = new ArrayList<>();
		DietaryRecord dr = new DietaryRecord("2016-05-03", 20, "June");
		dietaryList.add(dr);
		dr = new DietaryRecord("2016-05-18", 10, "June");
		dietaryList.add(dr);
		dr = new DietaryRecord(30, "June");
		dietaryList.add(dr);
		dr = new DietaryRecord(20, "June");
		dietaryList.add(dr);
		
		DietaryProfile dietaryProfile_1 = new DietaryProfile("1", 2000, 1600, 10, "2016-05-01", "2016-05-27", dietaryList);
		
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
		Serialization.serialize(expenseProfile_1, "database/1_expenseprofile.ser");
		System.out.print("After DeSerializing - ");
		expenseProfile_1 = null;
		expenseProfile_1 = Serialization.deSerialize("database/1_expenseprofile.ser");
		System.out.println(expenseProfile_1);
		
		/***************************test serialization dietaryProfile**************/
		System.out.println("");
		System.out.println("test serialization and deserialization dietaryProfile....");
		
		System.out.print("Before Serializing - \n");
		System.out.println(dietaryProfile_1);
		Serialization.serialize(dietaryProfile_1, "database/1_dietaryProfile.ser");
		System.out.print("After DeSerializing - ");
		dietaryProfile_1 = null;
		dietaryProfile_1 = Serialization.deSerialize("database/1_dietaryProfile.ser");
		System.out.println(dietaryProfile_1);
		
		
		
		/***************************Test login **************/
		
		// TODO

		/***************************Test loginUpdateExpenseProfile **************/
		System.out.println("");
		System.out.println("Test loginUpdateExpenseProfile....");
		
		CheckValidation.loginUpdateExpenseProfile(expenseProfile_1);
		
		
		/***************************Test loginUpdateDietaryProfile **************/
		System.out.println("");
		System.out.println("Test loginUpdateExpenseProfile....");
		
		CheckValidation.loginUpdateDietaryProfile(dietaryProfile_1);
		
		
		/***************************Test GUI**************/
		
		
		
	}
	
	
	
	
	
//	ExpenseRecordList expenseRecordList = new ExpenseRecordList();
//	ExpenseRecord expenseRecord = new ExpenseRecord(1, "2016-05-23");
//	ExpenseRecord expenseRecord1 = new ExpenseRecord(2, "2016-05-23");
//	ExpenseRecord expenseRecord2 = new ExpenseRecord(3, "2016-05-24");
//	expenseRecordList.update(expenseRecord);
//	expenseRecordList.update(expenseRecord1);
//	expenseRecordList.update(expenseRecord2);
//	
//	System.out.print("Before Serializing - ");
//	System.out.println(expenseRecordList);
//	
//	serialize(expenseRecordList, "No.001.ser");
//	
//	ExpenseRecordList expenseRecordListRec = deSerialize("No.001.ser");
//
//	System.out.print("After DeSerializing - ");
//	System.out.println(expenseRecordListRec);
	
	

}
