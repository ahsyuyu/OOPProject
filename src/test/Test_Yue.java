package test;

import coen275project.*;
import java.io.*;
import java.util.*;

public class Test_Yue {
	
	public static void main(String[] args) {
		
		System.out.println("initialization....");
		
		// create a card
		System.out.println("create card....");
		Card card = new Card(1, "111");
		
		// create a user
		
		// create a expenseprofile
		List<ExpenseRecord> list = new ArrayList<>();
		ExpenseRecord r = new ExpenseRecord("2016-02-03", 1, "June", "VendingMachine1");
		list.add(r);
		r = new ExpenseRecord("2016-05-18", 2, "June", "VendingMachine2");
		list.add(r);
		r = new ExpenseRecord(3, "June", "Cafe1");
		list.add(r);
		r = new ExpenseRecord(4, "June", "Cafe2");
		list.add(r);

		//ExpenseProfile expenseProfile = new ExpenseProfile(card.getCardNumber(), "June", );
				
		
		// create a user
		
		

		
		
		
		
		
		
		
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
