package multiThreadTest;

import coen275project.Card;
import coen275project.Serialization;
import coen275project.User;
import discard.UserManager;

/******Lifen: test serialization with user login (single user and family)*****/

public class Test_serialization_multiThread {
	public static void main(String[] args) {		
		
		/**********Lifen: test case1, single user to purchase*************/
		//System.out.println(card_1000.getTotalBalance());   // just for test of the card
		/*
		User user_1000 = Serialization.deSerialize("database/user_1000_0.ser");
		System.out.println(user_1000.getCard().getTotalBalance());
		user_1000.getCard().deductMoney(100);
		System.out.println(user_1000.getCard().getTotalBalance());
		user_1000.getCard().deductMoney(100);
		System.out.println(user_1000.getCard().getTotalBalance());
		*/
		
		
		/**********Lifen: test case2, parent and child login at the same time, purchase in sequence********/
		/*
		User user_1002_10 = Serialization.deSerialize("database/user_1002_10.ser");
		User user_1002_11 = Serialization.deSerialize("database/user_1002_11.ser");
		
		System.out.println(user_1002_10.getCard().getTotalBalance());	
		user_1002_10.getCard().deductMoney(10);
		System.out.println(user_1002_10.getCard().getTotalBalance());
		System.out.println("");
		
		System.out.println(user_1002_11.getCard().getTotalBalance());	
		user_1002_11.getCard().deductMoney(20);
		System.out.println(user_1002_11.getCard().getTotalBalance());
		System.out.println("");
		
		System.out.println(user_1002_10.getCard().getTotalBalance());
		user_1002_10.getCard().deductMoney(30);
		System.out.println(user_1002_10.getCard().getTotalBalance());
		System.out.println("");
		
		System.out.println(user_1002_11.getCard().getTotalBalance());	
		user_1002_11.getCard().deductMoney(40);
		System.out.println(user_1002_11.getCard().getTotalBalance());
		System.out.println("");
		*/
		
		
		/**********Lifen: test case3, parent login and purchase, then child login and purchase, then both purchase at the same time********/
		// parent login and make purchase
		/*User user_1002_10 = Serialization.deSerialize("database/user_1002_10.ser");
		System.out.println(user_1002_10.getCard().getTotalBalance());	
		user_1002_10.getCard().deductMoney(10);
		System.out.println(user_1002_10.getCard().getTotalBalance());
		System.out.println("");
		
		// child login and make purchase
		User user_1002_11 = Serialization.deSerialize("database/user_1002_11.ser");		
		System.out.println(user_1002_11.getCard().getTotalBalance());	
		user_1002_11.getCard().deductMoney(20);
		System.out.println(user_1002_11.getCard().getTotalBalance());
		System.out.println("");*/
		
		
		// parent and child purchase at the same time
		User user_1002_10 = Serialization.deSerialize("database/user_1002_10.ser");
		User user_1002_11 = Serialization.deSerialize("database/user_1002_11.ser");		
		//user_1002_10.getCard().deductMoney(10);
		//user_1002_11.getCard().deductMoney(20);
		
		TestThread t1 = new TestThread("1002", 5);
	    TestThread t2 = new TestThread("1002", 9);
		t1.start();
		t2.start();
		
	}
}

//Lifen:  use to test multiThread
class TestThread extends Thread {
	String cardNumber;
	int money;
	
	public TestThread(String cardNumber, int money) {
		this.cardNumber = cardNumber;
		this.money = money;
	}
	
	public void run() {
		Card.temTest(cardNumber, money);
		//userTem.getCard().deductMoney(money);   //Lifen: the .getCard() may cause problem when using with serialization in .deductMoney()
	}
}
