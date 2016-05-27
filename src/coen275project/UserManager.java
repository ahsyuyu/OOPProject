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
	}
	
	public static User getParent() {
		return user1;
	}
	
	public static User getChild() {
		return user11;
	}
}
