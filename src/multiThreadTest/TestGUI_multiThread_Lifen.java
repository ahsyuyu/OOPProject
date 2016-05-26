package multiThreadTest;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import coen275project.User;

/**
 * @author Lifen
 * test the GUI with two threads act at the same time
 * cooperate with class of Lifen_UserManage (create a family), class of Card (set the deductMoney() synchronized or not)
 * When buttons "parent" or "child" is clicked, a new thread is created separately, and go to deductMonday()
 */

public class TestGUI_multiThread_Lifen {
	private static JButton btnParent = new JButton("parent");
	private static JButton btnChild = new JButton("child");

	public static void main(String [] args){
		/********create GUI*********/
		JFrame mainFrame = new JFrame();
		JPanel panel = new JPanel();
		panel.add(btnParent);
		panel.add(btnChild);

		Container c = mainFrame.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(panel,BorderLayout.CENTER);
		
		/********create a family************/
		Lifen_UserManager.createTestFamily();   

		/*******add ActionListener*****/
		btnParent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				Thread aWorker = new Thread() {
					public void run(){ 
						User parent = Lifen_UserManager.getParent();
						parent.getCard().deductMoney(20.0f); }           // withdraw money
				};// end of thread

				aWorker.start();
			}//end of actionPerformed
		});

		btnChild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
				Thread bWorker = new Thread() {
					public void run(){       
						try{ 
							User child = Lifen_UserManager.getChild();
							child.getCard().deductMoney(15.5f); }           // withdraw money
						catch(Exception ex){} 
					}
				};

				bWorker.start();
			}
		});


		mainFrame.setSize(300,200);
		mainFrame.setVisible(true);
	}         
}
