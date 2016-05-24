package guiBuild;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnTest = new JButton("Login");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTest.setBounds(200, 202, 117, 29);
		frame.getContentPane().add(btnTest);
		
		JLabel lblWelcomeTo = new JLabel("Welcome to CampusSmartCafe");
		lblWelcomeTo.setBounds(129, 49, 218, 16);
		frame.getContentPane().add(lblWelcomeTo);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(104, 104, 84, 16);
		frame.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(188, 98, 134, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(104, 147, 84, 16);
		frame.getContentPane().add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(188, 141, 134, 28);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
