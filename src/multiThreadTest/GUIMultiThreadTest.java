package multiThreadTest;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import coen275project.Card;
import coen275project.Serialization;
import coen275project.User;
import discard.UserManager;

/**
 * @author Lifen
 * test the GUI with two threads act at the same time
 * cooperate with class of Lifen_UserManage (create a family), class of Card (set the deductMoney() synchronized or not)
 * When buttons "parent" or "child" is clicked, a new thread is created separately, and go to deductMonday()
 */

public class GUIMultiThreadTest extends JPanel{
	private static JButton buyButton;
	private static JTextField moneyArea;	
	private User user;
	
	public GUIMultiThreadTest(User user){
		this.user = user;
		initialize();
	}
	
	public void initialize() {
		moneyArea = new JTextField();
		moneyArea.setBounds(188, 98, 134, 28);
		moneyArea.setColumns(10);
		add(moneyArea);
		
		buyButton = new JButton("buy");
		buyButton.setBounds(200, 202, 117, 29);
		add(buyButton);
		
		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				Thread aWorker = new Thread() {
					public void run(){ 
						Card.temTest(user.getCardNumber(), Float.parseFloat(moneyArea.getText()));
					}
				};// end of thread

				aWorker.start();
			}//end of actionPerformed
		});		
	}

	public static void main(String [] args){
		/********create GUI*********/
	}  

}
