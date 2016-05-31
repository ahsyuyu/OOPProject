package guiBuild;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import coen275project.*;

public class Navigation {
	private JFrame frame;
    private User theUser;
    
	/*** Launch the application.*/
	public static void main(String[] args) {
		final String accountNumber = args[0];       // get the accountNumber
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Navigation window = new Navigation(accountNumber);    // pass the accountNumber
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*** Create the application.*/
	public Navigation(String accountNumber) {
		findUser(accountNumber);
		initialize();
	}
	
	private void findUser(String accountNumber) {
		theUser = UserManager.getUser(accountNumber);
	}

	/*** Initialize the contents of the frame.*/
	private void initialize() {
		frame = new JFrame("Navigation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setBounds(100, 100, 2000, 1000);
		//frame.getContentPane().setLayout(null);
		
		 // make the frame 1/2 the height and width
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	int height = screenSize.height;
    	int width = screenSize.width;
    	System.out.println(width);
    	frame.setSize(width*2/3, height/2);

    	// center the mainFrame on screen
    	frame.setLocationRelativeTo(null);
    	
    	JTabbedPane tabbedPane = new JTabbedPane();      //**JTabbedPane
    	tabbedPane.addTab("Buy/Order food", new OrderPanel());
    	tabbedPane.addTab("Enter Preference", new PreferencePanel());
    	tabbedPane.addTab("Dietary Profile", new DietaryPanel());
    	tabbedPane.addTab("Expense Profile", new ExpensePanel());
    	
    	frame.getContentPane().add(tabbedPane);
    	//frame.pack();
    	frame.setVisible(true);
	}	
	
	
	// Lifen:  below are 4 panels as inner classes
	private class OrderPanel extends JPanel {     // include SelectStore GUI
		JLabel message;

		public OrderPanel(){
			/*message = new JLabel(theUser.getName() + ", welcome to Order/Buy Panel!");
			message.setFont(new Font("Serif", Font.PLAIN, 20));
			setBackground(Color.yellow);
			add(message);*/
			
			SelectStore storeList = new SelectStore();
//			Map map = new Map();
//			this.add(storeList);
//			this.add(map);
			this.add(storeList);
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
	}
	
	private class PreferencePanel extends JPanel {
		JLabel message;

		public PreferencePanel(){
			message = new JLabel("Welcome " + theUser.getName() + ", please edit your preferences here");
			message.setFont(new Font("Serif", Font.PLAIN, 20));
			setBackground(Color.yellow);
			add(message);
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);	
			
		}
	}

	private class DietaryPanel extends JPanel {
		JLabel message;

		public DietaryPanel(){
			message = new JLabel(theUser.getName() + ", below is your Dietary Profile");
			message.setFont(new Font("Serif", Font.PLAIN, 20));
			setBackground(Color.yellow);
			add(message);
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);	 		
		}
	}

	private class ExpensePanel extends JPanel {
		JLabel message;

		public ExpensePanel(){
			message = new JLabel(theUser.getName() + ", below is your Expense Profile");
			message.setFont(new Font("Serif", Font.PLAIN, 20));
			setBackground(Color.yellow);
			add(message);
			setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			
		}
	}

}




