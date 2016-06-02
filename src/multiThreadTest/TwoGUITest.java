package multiThreadTest;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import coen275project.User;
import discard.UserManager;

public class TwoGUITest {
	private static JButton btnParent = new JButton("parent");
	private static JButton btnChild = new JButton("child");

	public static void main(String [] args){
		buildGui();
		buildGui();
	}  
	
	public static void buildGui() {
		/********create GUI*********/
		JFrame mainFrame = new JFrame();
		JPanel panel = new JPanel();
		panel.add(btnParent);
		panel.add(btnChild);

		Container c = mainFrame.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(panel,BorderLayout.CENTER);
		
		/********create a family************/
		UserManager.createTestFamily();   

		/*******add ActionListener*****/
		btnParent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				Thread aWorker = new Thread() {
					public void run(){ 
						User parent = UserManager.getParent();
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
							User child = UserManager.getChild();
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
