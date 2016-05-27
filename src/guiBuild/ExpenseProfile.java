package guiBuild;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ExpenseProfile extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	// Info
	JLabel lblNewLabel_cardnumber = new JLabel("");
	JLabel lblNewLabel_username = new JLabel("");
	JLabel lblNewLabel_totalbalance = new JLabel("");
	JLabel lblNewLabel_currentfund = new JLabel("");
	JLabel lblNewLabel_nextfund = new JLabel("");
	JLabel lblNewLabel_expense = new JLabel("");
	
	
	// Record
	
	// bar graph
	
	// Pie chart

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpenseProfile frame = new ExpenseProfile();
					frame.setVisible(true);
					frame.setLocation(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExpenseProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		// 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Expense Profile");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 600, 16);
		contentPane.add(lblNewLabel);
		
		JPanel panel_info = new JPanel();
		panel_info.setBorder(BorderFactory.createTitledBorder("Expense Profile Infomation"));
		panel_info.setBounds(10, 18, 584, 89);
		contentPane.add(panel_info);
		GridBagLayout gbl_panel_info = new GridBagLayout();
		gbl_panel_info.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_info.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_info.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_info.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_info.setLayout(gbl_panel_info);
		
		JLabel lblNewLabel_9 = new JLabel("Card Number: ");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 0;
		panel_info.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		lblNewLabel_cardnumber = new JLabel("No. 001");
		GridBagConstraints gbc_lblNewLabel_cardnumber = new GridBagConstraints();
		gbc_lblNewLabel_cardnumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_cardnumber.gridx = 1;
		gbc_lblNewLabel_cardnumber.gridy = 0;
		panel_info.add(lblNewLabel_cardnumber, gbc_lblNewLabel_cardnumber);
		
		JLabel lblNewLabel_11 = new JLabel("User Name: ");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 8;
		gbc_lblNewLabel_11.gridy = 0;
		panel_info.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		lblNewLabel_username = new JLabel("June");
		GridBagConstraints gbc_lblNewLabel_username = new GridBagConstraints();
		gbc_lblNewLabel_username.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_username.gridx = 9;
		gbc_lblNewLabel_username.gridy = 0;
		panel_info.add(lblNewLabel_username, gbc_lblNewLabel_username);
		
		JLabel lblNewLabel_1 = new JLabel("Total Balance: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_info.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblNewLabel_totalbalance = new JLabel("$ 10000");
		GridBagConstraints gbc_lblNewLabel_totalbalance = new GridBagConstraints();
		gbc_lblNewLabel_totalbalance.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_totalbalance.gridx = 1;
		gbc_lblNewLabel_totalbalance.gridy = 1;
		panel_info.add(lblNewLabel_totalbalance, gbc_lblNewLabel_totalbalance);
		
		JLabel lblNewLabel_3 = new JLabel("Current Fund: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 8;
		gbc_lblNewLabel_3.gridy = 1;
		panel_info.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		lblNewLabel_currentfund = new JLabel("$ 500");
		GridBagConstraints gbc_lblNewLabel_currentfund = new GridBagConstraints();
		gbc_lblNewLabel_currentfund.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_currentfund.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_currentfund.gridx = 9;
		gbc_lblNewLabel_currentfund.gridy = 1;
		panel_info.add(lblNewLabel_currentfund, gbc_lblNewLabel_currentfund);
		
		JLabel lblNewLabel_5 = new JLabel("Next Fund: ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 2;
		panel_info.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		lblNewLabel_nextfund = new JLabel("$ 600");
		GridBagConstraints gbc_lblNewLabel_nextfund = new GridBagConstraints();
		gbc_lblNewLabel_nextfund.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_nextfund.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_nextfund.gridx = 1;
		gbc_lblNewLabel_nextfund.gridy = 2;
		panel_info.add(lblNewLabel_nextfund, gbc_lblNewLabel_nextfund);
		
		JLabel lblNewLabel_7 = new JLabel("Expense");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 8;
		gbc_lblNewLabel_7.gridy = 2;
		panel_info.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		lblNewLabel_expense = new JLabel("$ 400");
		GridBagConstraints gbc_lblNewLabel_expense = new GridBagConstraints();
		gbc_lblNewLabel_expense.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_expense.gridx = 9;
		gbc_lblNewLabel_expense.gridy = 2;
		panel_info.add(lblNewLabel_expense, gbc_lblNewLabel_expense);
		
		JScrollPane scrollPane_record = new JScrollPane();
		scrollPane_record.setBorder(BorderFactory.createTitledBorder("Expense Record Information"));
		scrollPane_record.setBounds(6, 119, 588, 84);
		contentPane.add(scrollPane_record);
		
		
		table = new JTable();
		scrollPane_record.setColumnHeaderView(table);
		scrollPane_record.setViewportView(table);		// manually add this line
		
		// initialization record table
		
		
		JTabbedPane tabbedPane_graph = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_graph.setBounds(0, 212, 594, 160);
		contentPane.add(tabbedPane_graph);
		
		JPanel panel_bargraph = new JPanel();
		tabbedPane_graph.addTab("Bar Graph", null, panel_bargraph, null);
		panel_bargraph.setLayout(null);
		
		JPanel panel_piechart = new JPanel();
		tabbedPane_graph.addTab("Pie Chart", null, panel_piechart, null);
		panel_piechart.setLayout(null);
	}
}
