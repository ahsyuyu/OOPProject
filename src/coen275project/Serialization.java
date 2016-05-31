package coen275project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization{
	
//	public static void serialize(ExpenseProfile expenseProfile, String filename) {
//		FileOutputStream fout = null;
//		ObjectOutputStream out = null;
//		try {
//			fout = new FileOutputStream(filename);
//			out = new ObjectOutputStream(fout);
//			out.writeObject(expenseProfile);
//			out.close();
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
//	}

//	public static ExpenseProfile deSerialize(String filename) {
//		ExpenseProfile transOb = null;
//		FileInputStream fis = null;
//		ObjectInputStream fin = null;
//		try {
//			fis = new FileInputStream(filename);
//			fin = new ObjectInputStream(fis);
//			transOb = (ExpenseProfile) fin.readObject();
//			fin.close();
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return transOb;
//	}
	private static final long serialVersionUID = 1L;
	public static <E> void serialize(E obj, String filename) {
		FileOutputStream fout = null;
		ObjectOutputStream out = null;
		try {
			fout = new FileOutputStream(filename);
			out = new ObjectOutputStream(fout);
			out.writeObject(obj);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static <E> E deSerialize(String filename) {
		E transOb = null;
		FileInputStream fis = null;
		ObjectInputStream fin = null;
		try {
			fis = new FileInputStream(filename);
			fin = new ObjectInputStream(fis);
			transOb = (E) fin.readObject();
			fin.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return transOb;
	}
	
	public static void main(String[] args) {

//		ExpenseRecordList expenseRecordList = new ExpenseRecordList();
//		ExpenseRecord expenseRecord = new ExpenseRecord(1, "2016-05-23");
//		ExpenseRecord expenseRecord1 = new ExpenseRecord(2, "2016-05-23");
//		ExpenseRecord expenseRecord2 = new ExpenseRecord(3, "2016-05-24");
//		expenseRecordList.update(expenseRecord);
//		expenseRecordList.update(expenseRecord1);
//		expenseRecordList.update(expenseRecord2);
//		
//		System.out.print("Before Serializing - ");
//		System.out.println(expenseRecordList);
//		
//		serialize(expenseRecordList, "No.001.ser");
//		
//		ExpenseRecordList expenseRecordListRec = deSerialize("No.001.ser");
//
//		System.out.print("After DeSerializing - ");
//		System.out.println(expenseRecordListRec);

	}
}
