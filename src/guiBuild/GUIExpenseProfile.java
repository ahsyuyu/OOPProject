package guiBuild;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import coen275project.*;
import coen275project.ExpenseProfile;

public class GUIExpenseProfile extends JFrame {

	// Entity Object
	private ExpenseProfile myExpenseProfile = null;

	// GUI frame
	private JPanel contentPane;

	// GUi Info
	// TODO don't need to create object field of these components
	JLabel lblNewLabel_cardnumber = new JLabel("");
	JLabel lblNewLabel_username = new JLabel("");
	JLabel lblNewLabel_totalbalance = new JLabel("");
	JLabel lblNewLabel_currentfund = new JLabel("");
	JLabel lblNewLabel_nextfund = new JLabel("");
	JLabel lblNewLabel_expense = new JLabel("");

	// GUi Record
	// private JTable table;
	private static final String[] COLUMN_NAMES = { "Date", "Expense", "Location", "User" };

	// GUi Bar graph

	// GUi Pie chart

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// TODO: need to get a expenseProfile when integrate
					String expenseProfileFileName = "database/1_expenseprofile.ser";
					GUIExpenseProfile frame = new GUIExpenseProfile(expenseProfileFileName);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

					// frame.setLocation(null); // in the middle of window

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIExpenseProfile(String expenseProfileFileName) {

		initializeData(expenseProfileFileName);
		initializeGUI();
	}

	private void initializeData(String expenseProfileFileName) {
		myExpenseProfile = Serialization.deSerialize(expenseProfileFileName);
	}

	private void initializeGUI() {
		// frame and main panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); // absolute layout

		// top label
		JLabel lblNewLabel = new JLabel("Expense Profile");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 600, 16);
		contentPane.add(lblNewLabel);

		// panel info
		JPanel panel_info = new JPanel();
		panel_info.setBorder(BorderFactory.createTitledBorder("Information"));
		panel_info.setBounds(10, 16, 584, 100);
		contentPane.add(panel_info);
		panel_info.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Card Number : ");
		lblNewLabel_1.setBounds(6, 20, 102, 16);
		panel_info.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Total Balance :");
		lblNewLabel_2.setBounds(6, 48, 102, 16);
		panel_info.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Current Fund :");
		lblNewLabel_3.setBounds(6, 78, 102, 16);
		panel_info.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("User Name :");
		lblNewLabel_4.setBounds(261, 20, 119, 16);
		panel_info.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Expense :");
		lblNewLabel_5.setBounds(261, 48, 119, 16);
		panel_info.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Next Period Fund :");
		lblNewLabel_6.setBounds(261, 78, 119, 16);
		panel_info.add(lblNewLabel_6);

		JLabel label_cardnumber = new JLabel(myExpenseProfile.getCardNumber() + "");
		label_cardnumber.setBounds(120, 20, 61, 16);
		panel_info.add(label_cardnumber);

		JLabel label_username = new JLabel(myExpenseProfile.getUserName());
		label_username.setBounds(392, 20, 61, 16);
		panel_info.add(label_username);

		// TODO:
		// way 1: add totalfund in profile which has the same value of
		// totalvalue in card, maybe implements by adding observer
		// way 2: get card info when jump to the window
		// way 3: delete the label, since it doesn't make much sense in
		// multiuser
		JLabel label_totalbalance = new JLabel("$ 100000");
		label_totalbalance.setBounds(120, 48, 61, 16);
		panel_info.add(label_totalbalance);

		JLabel label_expense = new JLabel("$ " + myExpenseProfile.getExpense());
		label_expense.setBounds(392, 48, 61, 16);
		panel_info.add(label_expense);

		JLabel label_currentfund = new JLabel("$ " + myExpenseProfile.getCurrentFund() + "");
		label_currentfund.setBounds(120, 78, 61, 16);
		panel_info.add(label_currentfund);

		JLabel label_nextfund = new JLabel("$ " + myExpenseProfile.getNextFund());
		label_nextfund.setBounds(392, 78, 61, 16);
		panel_info.add(label_nextfund);

		// panel record
		
		// populate table content
		final int NumberOfRow = myExpenseProfile.getList().size();
		Object[][] data = new Object[NumberOfRow][4];
		for (int i = 0; i < NumberOfRow; i++) {
			data[i][0] = myExpenseProfile.getList().get(i).getDate();
			data[i][1] = myExpenseProfile.getList().get(i).getExpense();
			data[i][2] = myExpenseProfile.getList().get(i).getStoreName();
			data[i][3] = myExpenseProfile.getList().get(i).getUserName();
		}
		
		final JTable table = new JTable(data, COLUMN_NAMES);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));	// ??
        table.setFillsViewportHeight(true);									// ??
        
        JScrollPane scrollPane_record = new JScrollPane();
		scrollPane_record.setBorder(BorderFactory.createTitledBorder("Record Information"));
		scrollPane_record.setBounds(6, 119, 588, 84);
		contentPane.add(scrollPane_record);
		
//      scrollPane_record.add(table);				// avoid this way, use setViewportView instead
//		scrollPane_record.setColumnHeaderView(table);
		scrollPane_record.setViewportView(table); 	// manually add this line, show the table
		
		
		// panel graph
		JTabbedPane tabbedPane_graph = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_graph.setBounds(0, 212, 594, 160);
		contentPane.add(tabbedPane_graph);

		JPanel panel_bargraph = new JPanel();
		tabbedPane_graph.addTab("Bar Graph", null, panel_bargraph, null);
		panel_bargraph.setLayout(null);

//		JPanel panel_piechart = new JPanel();
//		tabbedPane_graph.addTab("Pie Chart", null, panel_piechart, null);
//		panel_piechart.setLayout(null);
		
		// bar graph
		
		if (myExpenseProfile.getList().size() > 0) {
			BarChart chart = new BarChart();
			chart.setSize(tabbedPane_graph.getSize());
			chart.setBackground(Color.BLUE);			// ??? didn't display
			
			
			for (int i = 0; i < myExpenseProfile.getList().size(); i++) {
				System.out.println("For loop");
				Random rm = new Random();
				int r = rm.nextInt(256);
				int g = rm.nextInt(256);
				int b = rm.nextInt(256);
				Color color = new Color(r, g, b);
				Bar bar = new Bar(color, myExpenseProfile.getList().get(i).getExpense());
				chart.addBar(i, bar);
			}
			System.out.println("for loop end");
			panel_bargraph.add("bar graph", chart);
			System.out.println("added to panel");
//			System.out.println(tabbedPane_graph.getBounds());
//			System.out.println(chart.getBounds());
		}
		
//		JPanel temp = new JPanel();
//		temp.setBackground(Color.BLUE);
//		temp.setSize(100, 100);
//		panel_bargraph.add(temp);
		
//		getContentPane().setBackground(Color.CYAN);
//		getContentPane().add(chart);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		pack();
//		setVisible(true);
//		panel_bargraph.add(chart);
		
	}
}

class BarChart extends JPanel {
	private Map<Integer, Bar> bars = new LinkedHashMap<Integer, Bar>();
	
	public BarChart() {
		
	}

	public BarChart(Dimension d) {
		setPreferredSize(d); 		// ??? 改了没变化啊
		System.out.println("public BarChart(Dimension d)");
	}

	/**
	 * Add new bar to chart
	 * 
	 * @param color
	 *            color to display bar
	 * @param value
	 *            size of bar
	 */
	public void addBar(Integer i, Bar bar) {
		bars.put(i, bar);
		// cannot call paintComponent() or paint() directly
		repaint();
		
		System.out.println("public void addBar(Integer i, Bar bar)");
	}

	@Override
	protected void paintComponent(Graphics g) {
		// determine longest bar
		System.out.println("paintComponent");
		int max = Integer.MIN_VALUE;
		for (Bar bar : bars.values()) {
			float f = bar.getValue();
			max = Math.max(max, (int)f);
		}

		// paint bars
//		int width = (getWidth() / bars.size());
		int width = (20);
		int x = 1;
		for (Bar bar : bars.values()) {
			int value = (int)bar.getValue().floatValue();
			int height = (int) ((getHeight() - 5) * ((double)value / max));		// (double) guarantee result of division > 0
			g.setColor(bar.getColor());
			g.fillRect(x, getHeight() - height, width, height);
			g.setColor(Color.black);
			g.drawRect(x, getHeight() - height, width, height); // draw border
			x += (width + 2);
			System.out.println("" + x + " " +(getHeight() - height) + " " + width + " " + height);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(bars.size() * 10 + 2, 50); // ??? 但是并没有用到这句
	}
}

class Bar {
	Color color;
	Float value;
	
	public Bar(Color color, Float value) {
		this.color = color;
		this.value = value;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}
}
