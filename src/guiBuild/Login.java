package guiBuild;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import coen275project.UserManager;

public class Login {

	private JFrame frame;
	private JTextField userAccountField;
	private JTextField userPasswordField;
	private JButton loginButton;
	private JLabel lblWelcomeTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// initialize a collection of users and cards
					UserManager um = new UserManager();    
					
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		addListeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(200, 202, 117, 29);
		frame.getContentPane().add(loginButton);
		
		lblWelcomeTo = new JLabel("Welcome to CampusSmartCafe");
		lblWelcomeTo.setBounds(129, 49, 218, 16);
		frame.getContentPane().add(lblWelcomeTo);
		
		JLabel lblUserAccount = new JLabel("Account No.:");
		lblUserAccount.setBounds(104, 104, 84, 16);
		frame.getContentPane().add(lblUserAccount);
		
		userAccountField = new JTextField();
		userAccountField.setBounds(188, 98, 134, 28);
		frame.getContentPane().add(userAccountField);
		userAccountField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(104, 147, 84, 16);
		frame.getContentPane().add(lblPassword);
		
		userPasswordField = new JTextField();
		userPasswordField.setBounds(188, 141, 134, 28);
		frame.getContentPane().add(userPasswordField);
		userPasswordField.setColumns(10);
	}
	
	public void addListeners() {
		loginButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {   
	        	String accountNumber = userAccountField.getText();
	        	String password = userPasswordField.getText();  
	        	
	        	Boolean judge = UserManager.checkLogin(accountNumber, password);
	            if (judge) {
	            	lblWelcomeTo.setText("Succeed!");
	            	userAccountField.setText("");
	            	userPasswordField.setText("");
	            	
	            	try {
						Thread.sleep(1000);
						//Navigation.main(null);
						Navigation.main(new String[]{accountNumber});
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
	            } else {
	            	lblWelcomeTo.setText("Failed! Wrong account/password.");
	            }
	        }
		});
	}
	
}
