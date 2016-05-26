package coen275project;

import java.util.*;

public class TestDriver {
	public static void main(String[] args) {
		System.out.println("This is a test");
		
		/***************************create FoodStores and FoodStoreList**************/
		/*FoodStore foodstore1 = new FoodStore("The White Elephant", 1, "1190 Lexington St, Santa Clara");
	    FoodStore foodstore2 = new FoodStore("Tago", 2, "119 Washington St, Santa Clara");
	    FoodStore foodstore3 = new FoodStore("Mountain", 3, "113 Lafayttte St, Santa Clara");
	    
	    FoodStoreList foodstorelist = new FoodStoreList();
	    foodstorelist.addFoodStore(foodstore1);
	    foodstorelist.addFoodStore(foodstore2);
	    foodstorelist.addFoodStore(foodstore3);*/
	    
	    
	    /****************************Lifen: create User and Card***************************/
	    Card card1 = new Card(1111, "aaaa");
	    User user1 = new User("Alice", card1);
	    User user11 = new User("Lili", null);
	    user1.addDependent(user11);
	    
	    //System.out.println(user1.getCard() == user11.getCard());     // true
        /*user1.getCard().deductMoney(20.0f);     // this is in the same one thread
        user11.getCard().deductMoney(15.5f);*/
       
        /* test with TestThread class as defined below */
	    TestThread t1 = new TestThread(user1);
	    TestThread t2 = new TestThread(user11);
	    
	    /************Lifen: test card with multiThread, use class TestThread and TestThread2 as below***************/
	    /*Card card = new Card(1111, "aaaa");
	    //Card card1 = new Card(2222, "bbbb");
	    TestThread t1 = new TestThread(card);
	    TestThread2 t2 = new TestThread2(card);*/
	    
	}

}

// Lifen:  use to test multiThread
class TestThread implements Runnable {
	Card card;
	Thread t;
	
	public TestThread (Card card) {
		this.card = card;
		t = new Thread(this);
		t.start();
	}
	
	public TestThread(User user) {
		this.card = user.getCard();
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		card.deductMoney(20.0f);
	}
}

class TestThread2 implements Runnable {
	Card card;
	Thread t;
	
	public TestThread2 (Card card) {
		this.card = card;
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		card.deductMoney(15.0f);
	}
}
