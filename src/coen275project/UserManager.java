package coen275project;

import coen275project.*;

public class UserManager {
    private static User user1;
    private static User user11;
    
	public static void createTestFamily() {
		Card card1 = new Card(1111, "aaaa");
	    user1 = new User("Alice", card1);
	    user11 = new User("Lili", null);
	    user1.addDependent(user11);
	    
	    Card card2 = new Card(2222, "bbbb");
	    User user2 = new User("Bob", card2);
	    
	    Card card3 = new Card(3333, "cccc");
	    User user3 = new User("Carlos", card3);
	    
	    Card card4 = new Card(4444, "dddd");
	    User user4 = new User("David", card4);
	    
	    Card card5 = new Card(5555, "eeee");
	    User user5 = new User("Ella", card5);
	}
	
	
	//Lifen: below is used to test user and its dependent
	public static User getParent() {
		return user1;
	}
	
	public static User getChild() {
		return user11;
	}
}
