package coen275project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginCheck {
	/**
	 * check validation of cardnumber + extension and password when login
	 * if yes, deserilize user.ser (eg: user_1002_1.ser) and card.ser (eg: card_1002.ser)
	 * if not, refuse to login
	 * 
	 * @param cardNumber
	 * @param password
	 * @return
	 */
	public static boolean loginCheckCard(String cardNumber, String extension, String password) {
		// TODO
		// get input
		//String cardNumber = cardNumberAndExtension.substring(0, 4);
		//String extension = cardNumberAndExtension.substring(4, cardNumberAndExtension.length());
		
		// retrieve, markoff, change to read from txt file
		/*HashMap<String, String> cardhashmap = Serialization.deSerialize("/database/cards.ser");
		String s = cardhashmap.get(cardNumber);
		if (s != password) {
			return false;
		}*/
		
		String filePath = "database/cardCollection.txt";
		
        BufferedReader br = null;
        String line = null;
        
        try {          // read file line-by-line
            br = new BufferedReader(new FileReader(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }        
        
        do {          // parse each line to check the info validation
            try {
				line = br.readLine();
				if (line != null && !line.equals("")){
					System.out.println(line);
	            	String[] parts = line.split("\\s+");
	            	System.out.println(parts.length);
	            	System.out.println(parts[0] + " + " + parts[1] + " + " + parts[2]);
	            	if (parts[0].equals(cardNumber) && parts[1].equals(password) && parts[2].equals(extension)){
	            		//User user = Serialization.deSerialize("database/user_" + cardNumber + "_" + extension + ".ser");
	            		//loginUpdateExpenseProfile(user);    //Lifen:?? do later
	            		//loginUpdateDietaryProfile(user);    //Lifen:?? do later
	            		return true;
	            	}
	            } 
			} catch (IOException e) {
				e.printStackTrace();
			}     
        } while (line != null);
        
		
		return false;
	}
}
