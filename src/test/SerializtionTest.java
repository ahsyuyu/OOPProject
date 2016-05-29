package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import coen275project.*;

public class SerializtionTest{
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
		
		User no1 = new User("Bob", new Card("1", "abc"));

		System.out.print("Before Serializing - ");
		System.out.println(no1);
		
		serialize(no1, "No.001.ser");
		
		User no1Record = deSerialize("No.001.ser");

		System.out.print("After DeSerializing - ");
		System.out.println(no1Record);

	}
}