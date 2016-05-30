package coen275project;

import java.util.*;

import coen275project.*;

/**Lifen: For test purpose, use HashMap, HashSet to collect cards and users temporarily*/
public class UserManager {
    private static User user1;
    private static User user11;
    public static HashMap<String, String> cardHash = new HashMap<>();    // card collection  <cardNumber, password>
    public static HashMap<String, User> userHash = new HashMap<>();        // user collection  <cardNumber, User>
    
    public UserManager() {
    	createTestFamily();
    }
	public static void createTestFamily() {
		Card card1 = new Card("1111", "aaaa");
	    user1 = new User("Alice", card1);
	    user11 = new User("Lili", null);
	    user1.addDependent(user11);
	    
	    Card card2 = new Card("2222", "bbbb");
	    User user2 = new User("Bob", card2);
	    
	    Card card3 = new Card("3333", "cccc");
	    User user3 = new User("Carlos", card3);
	    
	    Card card4 = new Card("4444", "dddd");
	    User user4 = new User("David", card4);
	    
	    Card card5 = new Card("5555", "eeee");
	    User user5 = new User("Ella", card5);
	    
	    cardHash.put("1111", "aaaa");
	    cardHash.put("2222", "bbbb");
	    cardHash.put("3333", "cccc");
	    cardHash.put("4444", "dddd");
	    cardHash.put("5555", "eeee");
	    
	    userHash.put("1111", user1);
	    userHash.put("2222", user2);
	    userHash.put("3333", user3);
	    userHash.put("4444", user4);
	    userHash.put("5555", user5);
	    
	    userHash.put("1111-1", user11);
	}
	
	
	//Lifen: below is used to test user and its dependent
	public static User getParent() {
		return user1;
	}
	
	public static User getChild() {
		return user11;
	}
	
	//Lifen: check account and password
	public static boolean checkLogin(String account, String password){
		return cardHash.containsKey(account) && cardHash.get(account).equals(password);
	}
	
	public static User getUser(String account) {
		if (userHash.containsKey(account)) {
			return userHash.get(account);
		} else {
			return null;
		}
		
	}
}
