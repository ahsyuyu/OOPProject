package guiBuild;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import coen275project.*;

/**
 * @author Lifen
 * test the GUI with two threads act at the same time
 * cooperate with class of Lifen_UserManage (create a family), class of Card (set the deductMoney() synchronized or not)
 * When buttons "parent" or "child" is clicked, a new thread is created separately, and go to deductMonday()
 */

public class TotalExpenseProfile extends JPanel implements Observer{	
	private User user;
	private static final String[] COLUMN_NAMES = { "Date", "Expense", "Location", "User" };
	private JScrollPane scrollPane_record;
	
	public TotalExpenseProfile(User user){
		this.user = user;
		user.getExpenseProfile().addObserver(this);
		initialize();
	}
	
	public void update( Observable observable, Object object ){
		System.out.println("MVC test, step 2");
		this.removeAll();
		initialize();
	}
	
	public void initialize() {
		this.setSize(800, 800);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 
		
		scrollPane_record = new mvcTestPanel(user.getExpenseProfile());
		scrollPane_record.setBorder(BorderFactory.createTitledBorder("Record Information of user_" + user.getCardNumber() + "_" + 0));
		scrollPane_record.setPreferredSize(new Dimension(700, 200));
		this.add(scrollPane_record);
	
		
			
		// find the user + extension, if exists, create JScrollPanel and add to TotalExpenseProfile
		/*for (int iExtension = 0; iExtension < 5; iExtension++) {
			String filePathString = "database/user_" + user.getCardNumber() + "_" + iExtension + ".ser";
			File f = new File(filePathString);
			
			if(f.exists() && !f.isDirectory()) { 
			    //System.out.println("yes," + iExtension + " it exist");
			    
			    JScrollPane scrollPane_record = new ExpenseShowPanel(filePathString);
				scrollPane_record.setBorder(BorderFactory.createTitledBorder("Record Information of user_" + user.getCardNumber() + "_" + iExtension));
				scrollPane_record.setPreferredSize(new Dimension(700, 200));
				this.add(scrollPane_record);
			} else {
				break;
			}		
		}*/
		
		
		
		
        
		// test multi-thread panel
		/*JPanel testMultiThreadPanel = new TestMultiThreadPanel();
		testMultiThreadPanel.setLayout(new FlowLayout());
		testMultiThreadPanel.setPreferredSize(new Dimension(700, 120));
		testMultiThreadPanel.setBorder(BorderFactory.createTitledBorder(null, "test Multi-Thread", TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman",Font.BOLD,30), Color.blue));
		//this.add(Box.createRigidArea(new Dimension(800, 100)));
		this.add(testMultiThreadPanel);*/
	}  

	private class mvcTestPanel extends JScrollPane{

		public mvcTestPanel (ExpenseProfile oneExpenseProfile) {
			setBackground(Color.ORANGE);

			// populate table content
			int NumberOfRow = oneExpenseProfile.getList().size();
			Object[][] data = new Object[NumberOfRow][4];
			for (int i = 0; i < NumberOfRow; i++) {
				data[i][0] = oneExpenseProfile.getList().get(i).getDate();
				data[i][1] = oneExpenseProfile.getList().get(i).getExpense();
				data[i][2] = oneExpenseProfile.getList().get(i).getStoreName();
				data[i][3] = oneExpenseProfile.getList().get(i).getUserName();
			}

			JTable table = new JTable(data, COLUMN_NAMES);

			table.setFillsViewportHeight(true); 	

			this.setViewportView(table); 	
			/************************************* end ******************************************/
		}

	}


	
	private class ExpenseShowPanel extends JScrollPane{
	    
		public ExpenseShowPanel (String filePath) {
			setBackground(Color.ORANGE);
			
			User theUser = Serialization.deSerialize(filePath);   // get the user
            ExpenseProfile oneExpenseProfile = theUser.getExpenseProfile();   // get s/he profile
            
			/************************************* record, Yue's code***********************************/
			// populate table content
			int NumberOfRow = oneExpenseProfile.getList().size();
			Object[][] data = new Object[NumberOfRow][4];
			for (int i = 0; i < NumberOfRow; i++) {
				data[i][0] = oneExpenseProfile.getList().get(i).getDate();
				data[i][1] = oneExpenseProfile.getList().get(i).getExpense();
				data[i][2] = oneExpenseProfile.getList().get(i).getStoreName();
				data[i][3] = oneExpenseProfile.getList().get(i).getUserName();
			}

			JTable table = new JTable(data, COLUMN_NAMES);

			table.setFillsViewportHeight(true); 	

			this.setViewportView(table); 	
			/************************************* end ******************************************/
		}
		
	}
		
}



/*private class TestMultiThreadPanel extends JPanel{
private JButton buyButton;
private JTextField moneyArea;
private JLabel message;
private JLabel moneySign;

public TestMultiThreadPanel(){
	message = new JLabel("welcome, " + user.getName() + "!    ");
	message.setFont(new Font("Serif", Font.PLAIN, 20));
	setBackground(Color.yellow);
	this.add(message);
	
	buyButton = new JButton("buy");
	buyButton.setBounds(200, 202, 117, 29);
	this.add(buyButton);
	
	moneyArea = new JTextField();
	moneyArea.setBounds(188, 98, 134, 28);
	moneyArea.setColumns(10);
	this.add(moneyArea);
	
	moneySign = new JLabel("$");
	this.add(moneySign);
	
	buyButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event){
			Thread aWorker = new Thread() {
				public void run(){ 
					Card.deductMoney(user.getCardNumber(), Float.parseFloat(moneyArea.getText()));
				}
			};// end of thread
			aWorker.start();
		}//end of actionPerformed
	});		
}
}*/




