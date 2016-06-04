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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

public class TotalExpenseProfile extends JPanel{
	private JPanel testMultiThreadPanel, totalExpensePanel;	
	private User user;
	
	public TotalExpenseProfile(User user){
		this.user = user;
		initialize();
	}
	
	public void initialize() {
		//this.setLayout(new FlowLayout());
		this.setSize(800, 800);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 
		 
		JScrollPane scrollPane_record = new JScrollPane();
		scrollPane_record.setBorder(BorderFactory.createTitledBorder("Record Information"));
		scrollPane_record.setPreferredSize(new Dimension(700, 200));
		this.add(scrollPane_record);
		
		
		testMultiThreadPanel = new TestMultiThreadPanel();
		testMultiThreadPanel.setLayout(new FlowLayout());
		testMultiThreadPanel.setPreferredSize(new Dimension(700, 150));
		testMultiThreadPanel.setBorder(BorderFactory.createTitledBorder(null, "test Multi-Thread", TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman",Font.BOLD,36), Color.blue));
		
		//this.add(Box.createRigidArea(new Dimension(800, 100)));
		this.add(testMultiThreadPanel);
		
		/*totalExpensePanel = new ExpenseShowPanel();
		totalExpensePanel.setLayout(new FlowLayout());
		totalExpensePanel.setPreferredSize(new Dimension(800, 100));
		totalExpensePanel.setBorder(BorderFactory.createTitledBorder(null, "ExpenseShowPanel", TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman",Font.BOLD,36), Color.blue));
		*/
		
		
		
	}  

	private class TestMultiThreadPanel extends JPanel{
		private JButton buyButton;
		private JTextField moneyArea;
		
		public TestMultiThreadPanel(){
			moneyArea = new JTextField();
			moneyArea.setBounds(188, 98, 134, 28);
			moneyArea.setColumns(10);
			this.add(moneyArea);
			
			buyButton = new JButton("buy");
			buyButton.setBounds(200, 202, 117, 29);
			this.add(buyButton);

			
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
	}
	
	private class ExpenseShowPanel extends JPanel {
	    private JLabel docNameLabel, docStoreLabel;
	    private JTextField docNameText, docStoreText;
	    private JPanel docNamePanel, docStorePanel, buttonPanel;
	    private JTextArea docContentArea;
	    private JScrollPane scrollPane;
	    
		public ExpenseShowPanel () {
			setBackground(Color.ORANGE);
			
			/*docNameLabel = new JLabel("new doc name");
			docStoreLabel = new JLabel("docSotre name");
			
			docNameText = new JTextField(10);
			docStoreText = new JTextField(10);
			
			docContentArea = new JTextArea("type doc content here", 5, 20);
			
			docNamePanel = new JPanel();
			docNamePanel.setPreferredSize(new Dimension(300, 40));
			docNamePanel.add(docNameLabel);
			docNamePanel.add(docNameText);
			
			docStorePanel = new JPanel();
			docStorePanel.setPreferredSize(new Dimension(300, 40));
			docStorePanel.add(docStoreLabel);
			docStorePanel.add(docStoreText);
			
			scrollPane = new JScrollPane(docContentArea);    //* the JTextArea has to be added to JScrollPane at this step. It doesn't work if use add() later
			scrollPane.setPreferredSize(new Dimension(300, 300));
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			
			buttonPanel = new JPanel();
			buttonPanel.setPreferredSize(new Dimension(300, 40));
			
			this.add(docNamePanel);
	 		this.add(docStorePanel);
	 	    this.add(scrollPane);
	 		this.add(buttonPanel); */
	 		//mainFrame.setVisible(true);
		}
	}

}



