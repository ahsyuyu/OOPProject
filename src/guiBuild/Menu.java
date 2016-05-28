package guiBuild;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
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
		
		JButton btnBuyorderFod = new JButton("Buy/Order food");
		btnBuyorderFod.setBounds(173, 72, 150, 30);
		frame.getContentPane().add(btnBuyorderFod);
		BuyFoodHandler bh = new BuyFoodHandler();
		btnBuyorderFod.addActionListener(bh);
		
		
		JButton btnEnterPreference = new JButton("Enter Preference");
		btnEnterPreference.setBounds(173, 114, 150, 30);
		frame.getContentPane().add(btnEnterPreference);
		
		JButton btnDietaryProfile = new JButton("Dietary Profile");
		btnDietaryProfile.setBounds(173, 156, 150, 30);
		frame.getContentPane().add(btnDietaryProfile);
		
		JButton btnExpenseProfile = new JButton("Expense Profile");
		btnExpenseProfile.setBounds(173, 198, 150, 30);
		frame.getContentPane().add(btnExpenseProfile);
		
		JLabel lblWelcomeAlice = new JLabel("Welcome, Alice");
		lblWelcomeAlice.setBounds(183, 29, 112, 16);
		frame.getContentPane().add(lblWelcomeAlice);
	}
	
	class BuyFoodHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Map m = new Map();
			frame.getContentPane().removeAll();
			frame.getContentPane().add(m);
			frame.setSize(1200, 600);
			System.out.println("buy");
		}
	}

}


