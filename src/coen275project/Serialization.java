package coen275project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization{
	public static void serialize(ExpenseRecordList expenseRecordList, String filename) {
		FileOutputStream fout = null;
		ObjectOutputStream out = null;
		try {
			fout = new FileOutputStream(filename);
			out = new ObjectOutputStream(fout);
			out.writeObject(expenseRecordList);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static ExpenseRecordList deSerialize(String filename) {
		ExpenseRecordList transOb = null;
		FileInputStream fis = null;
		ObjectInputStream fin = null;
		try {
			fis = new FileInputStream(filename);
			fin = new ObjectInputStream(fis);
			transOb = (ExpenseRecordList) fin.readObject();
			fin.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return transOb;
	}
	
	public static void main(String[] args) {

		ExpenseRecordList expenseRecordList = new ExpenseRecordList();
		ExpenseRecord expenseRecord = new ExpenseRecord(1);
		ExpenseRecord expenseRecord1 = new ExpenseRecord(2, "2016-05-23");
		ExpenseRecord expenseRecord2 = new ExpenseRecord(3, "2016-05-24");
		expenseRecordList.add(expenseRecord);
		expenseRecordList.add(expenseRecord1);
		expenseRecordList.add(expenseRecord2);
		
		System.out.print("Before Serializing - ");
		System.out.println(expenseRecordList);
		
		serialize(expenseRecordList, "No.001.ser");
		
		ExpenseRecordList expenseRecordListRec = deSerialize("No.001.ser");

		System.out.print("After DeSerializing - ");
		System.out.println(expenseRecordListRec);

	}
}
