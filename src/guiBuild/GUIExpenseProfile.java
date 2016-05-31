package guiBuild;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import coen275project.*;
import javafx.scene.control.CheckBox;

public class GUIExpenseProfile extends JPanel {

	// entity
	private ExpenseProfile myExpenseProfile = null;

	// GUI data
	private static final String[] COLUMN_NAMES = { "Date", "Expense", "Location", "User" };

	// GUI component
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;

	public static void main(String[] args) {
		String filename = "database/user_1000_0.ser";
		JFrame window = new JFrame("Expense Profile");
		GUIExpenseProfile GUI_expenseprofile = new GUIExpenseProfile(filename);
		window.getContentPane().add(GUI_expenseprofile);

		window.setSize(600, 600);
		window.setLocationRelativeTo(null);
		try {
			// 1.6+
			window.setLocationByPlatform(true); 	// !!!
			window.setMinimumSize(window.getSize()); // !!!
		} catch (Throwable ignoreAndContinue) {
		}
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public GUIExpenseProfile(String filename) {

		myExpenseProfile = initializeData(filename).getExpenseProfile();
		initializeGUI();
	}

	private User initializeData(String filename) {
		return Serialization.deSerialize(filename);
	}

	private void initializeGUI() {

		/************************************** absolute layout******************************************/
		this.setBounds(100, 100, 600, 600);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null); // absolute layout

		JLabel lblNewLabel = new JLabel("Expense Profile");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 600, 30);
		this.add(lblNewLabel);

		// this.setPreferredSize(new Dimension(500, 600));
		JPanel panel_info = new JPanel();
		panel_info.setBorder(BorderFactory.createTitledBorder("Information"));
		panel_info.setBounds(10, 35, 580, 80);
		this.add(panel_info);
		panel_info.setLayout(null);

		JScrollPane scrollPane_record = new JScrollPane();
		scrollPane_record.setBorder(BorderFactory.createTitledBorder("Record Information"));
		scrollPane_record.setBounds(10, 120, 580, 200);
		this.add(scrollPane_record);

		JTabbedPane tabbedPane_graph = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_graph.setBounds(0, 320, 594, 250);
		this.add(tabbedPane_graph);

		/************************************* info ******************************************/
		JLabel lblNewLabel_1 = new JLabel("Card Number : ");
		lblNewLabel_1.setBounds(6, 20, 110, 16);
		panel_info.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Current Fund :");
		lblNewLabel_2.setBounds(6, 50, 110, 16);
		panel_info.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Expense :");
		lblNewLabel_3.setBounds(242, 50, 81, 16);
		panel_info.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("User Name :");
		lblNewLabel_4.setBounds(242, 20, 81, 16);
		panel_info.add(lblNewLabel_4);

		JLabel label_cardnumber = new JLabel(myExpenseProfile.getCardNumber() + "");
		label_cardnumber.setBounds(120, 20, 110, 16);
		panel_info.add(label_cardnumber);

		JLabel label_username = new JLabel(myExpenseProfile.getUserName());
		label_username.setBounds(335, 20, 110, 16);
		panel_info.add(label_username);

		JLabel label_currentfund = new JLabel(myExpenseProfile.getCurrentFund() + "");
		label_currentfund.setBounds(120, 50, 110, 16);
		panel_info.add(label_currentfund);

		JLabel label_expense = new JLabel("$ " + myExpenseProfile.getExpense() + "");
		label_expense.setBounds(335, 50, 110, 16);
		panel_info.add(label_expense);

		/************************************* record ******************************************/

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
//		table.setPreferredScrollableViewportSize(new Dimension(500, 70)); 		// ??
		table.setFillsViewportHeight(true); 	// ??

		// scrollPane_record.add(table); 			// avoid this way, use setViewportView instead scrollPane_record.setColumnHeaderView(table);
		scrollPane_record.setViewportView(table); 	// manually add this line, show the table


		/************************************ bar graph****************************************/
	

		JPanel panel_bargraph = new JPanel();
		tabbedPane_graph.addTab("Bar Graph", null, panel_bargraph, null);
		panel_bargraph.setLayout(null);

		if (myExpenseProfile.getList().size() > 0) {
			BarChart chart = new BarChart();
			chart.setSize(tabbedPane_graph.getSize());
			chart.setBackground(Color.BLUE); // ??? didn't display

			for (int i = 0; i < myExpenseProfile.getList().size(); i++) {
//				System.out.println("For loop");
				Random rm = new Random();
				int r = rm.nextInt(256);
				int g = rm.nextInt(256);
				int b = rm.nextInt(256);
				Color color = new Color(r, g, b);
				Bar bar = new Bar(color, (float) myExpenseProfile.getList().get(i).getExpense());
				chart.addBar(i, bar);
			}
//			System.out.println("for loop end");
			panel_bargraph.add(chart);
//			System.out.println("added to panel");
		}
		

		/************************************
		 * pie chart
		 ****************************************/

		JPanel panel_pieView = new JPanel();
		tabbedPane_graph.addTab("Pie Chart", null, panel_pieView, null);
	

		if (myExpenseProfile.getList().size() > 0) {

			PieChartView pieChart = new PieChartView();
			pieChart.setSize(tabbedPane_graph.getSize());

			for (int i = 0; i < myExpenseProfile.getList().size(); i++) {
//				System.out.println("For loop");
				Slice slice = new Slice(myExpenseProfile.getList().get(i).getExpense(),
						myExpenseProfile.getList().get(i).getDate());
				pieChart.addSlice(slice);
			}

			panel_pieView.add(pieChart);
			
//			System.out.println("added to panel");
		}
	}

}

class BarChart extends JPanel {
	private Map<Integer, Bar> bars = new LinkedHashMap<Integer, Bar>();

	public BarChart() {

	}

	public BarChart(Dimension d) {
		setPreferredSize(d); 			
		// System.out.println("public BarChart(Dimension d)");
	}

	public void addBar(Integer i, Bar bar) {
		bars.put(i, bar);
		// cannot call paintComponent() or paint() directly
		repaint();

		// System.out.println("public void addBar(Integer i, Bar bar)");
	}

	@Override
	protected void paintComponent(Graphics g) {
		// determine longest bar
		// System.out.println("paintComponent");
		int max = Integer.MIN_VALUE;
		for (Bar bar : bars.values()) {
			float f = bar.getValue();
			max = Math.max(max, (int) f);
		}

		// paint bars
		// int width = (getWidth() / bars.size());
		int width = (20);
		int x = 1;
		for (Bar bar : bars.values()) {
			int value = (int) bar.getValue().floatValue();
			int height = (int) ((getHeight() - 5) * ((double) value / max)); 
			g.setColor(bar.getColor());
			g.fillRect(x, getHeight() - height, width, height);
			g.setColor(Color.black);
			g.drawRect(x, getHeight() - height, width, height); // draw
																// border
			x += (width + 2);
			// System.out.println("" + x + " " + (getHeight() - height) + "
			// " + width + " " + height);
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

class PieChartView extends JPanel {
	
	public PieChartView() {

	}

	private List list = new ArrayList();

	public void addSlice(Slice slice) {

		if (slice == null)
			throw new NullPointerException();

		list.add(slice);

		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawPieChart(g);
	}

	private void drawPieChart(Graphics g) {
		double total = getTotal();

		Iterator iterator = list.iterator();
		Slice slice = null;

//		int min = Math.min(getWidth(), getHeight()) / 2;
		int min = Math.min(getWidth(), getHeight());
		double curValue = 0.0D;
		int startAngle = 0;

		while (iterator.hasNext()) {
			int arcAngle = 0;
			slice = (Slice) iterator.next();
			startAngle = (int) (curValue * 360 / total);
			arcAngle = (int) (slice.getValue() * 360 / total);
			g.setColor(slice.getColor());
//			g.fillArc(getWidth() / 2 - min / 2, getHeight() / 2 - min, min - 10, min - 10, startAngle, arcAngle);
			g.fillArc(0, 0, min-60, min-60, startAngle, arcAngle);
			curValue += slice.getValue();
			
			
			System.out.println(this.getBounds());
			System.out.println("min " + min + " " +getWidth() + " "+ getHeight());
		}

		g.setColor(Color.black);
//		g.drawArc(getWidth() / 2 - min / 2, getHeight() / 2 - min, min - 10, min - 10, 0, 360);
		g.drawArc(0, 0, min-60, min-60, 0, 360);

	} // end method drawPieChart

	
	
	private double getTotal() {
		double sum = 0.0;

		Iterator iterator = list.iterator();
		Slice account = null;

		while (iterator.hasNext()) {
			account = (Slice) iterator.next();
			sum += account.getValue();
		}

		return sum;
	}

	public Dimension getPreferredSize() {
		System.out.println("Systemout dimension" + getWidth() +" " +getHeight());
		int min = Math.min(getWidth(), getHeight());
		return new Dimension(min, min);

	}

	public Dimension getMinimumSize() {
		return getPreferredSize();
	}

	public Dimension getMaximumSize() {
		return getPreferredSize();
	}
}

class LegendView extends JPanel {
	private List list = new ArrayList();

	public LegendView() {
		this.setLayout(new GridLayout(0, 2, 0, 0));

	}

	public void addSlice(Slice slice) {
		if (slice == null)
			throw new NullPointerException();

		
		list.add(slice);

		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawLegends(g);
	}

	private void drawLegends(Graphics g) {
		Iterator iterator = list.iterator();
		Slice slice = null;

		Font font = new Font("SansSerif", Font.BOLD, 12);
		g.setFont(font);

		FontMetrics metrics = getFontMetrics(font);
		int ascent = metrics.getMaxAscent();
		int offsetY = ascent + 2;

		for (int i = 1; iterator.hasNext(); i++) {

			slice = (Slice) iterator.next();
			g.setColor(slice.getColor());
			g.fillRect(125, offsetY * i, ascent, ascent);
			g.setColor(Color.black);
			g.drawString(slice.getDate(), 140, offsetY * i + ascent);
		}
	} 


	public Dimension getPreferredSize() {
		return new Dimension(getWidth(), getHeight());
	}

	public Dimension getMinimumSize() {
		return getPreferredSize();
	}


	public Dimension getMaximumSize() {
		return getPreferredSize();
	}

	private class Rectangle extends JPanel {

		private JButton button;
		private JLabel label;

		public Rectangle(Color color, String s) {
			System.out.println("draw rectangle");
			this.button = new JButton();
			button.setBackground(color);
			button.setSize(5, 5);
			label = new JLabel(s);
			label.setSize(15, 5);
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			this.add(button);
			this.add(label);
		}

		public JButton getButton() {
			return button;
		}

		public void setButton(JButton button) {
			this.button = button;
		}

		public JLabel getJLabel() {
			return label;
		}

		public void setJLabel(JLabel jLabel) {
			label = jLabel;
		}

		public Dimension getPreferredSize() {
			return new Dimension(20, 5);
		}

		public Dimension getMinimumSize() {
			return getPreferredSize();
		}

		public Dimension getMaximumSize() {
			return getPreferredSize();
		}

	}

}

class Slice {
	private float value;
	private String date;
	private Color color;

	public Slice(float value, String date) {
		this.value = value;
		this.date = date;
		color = getRandomColor();
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	// get a random Color for drawing pie wedges
	public Color getRandomColor() {
		// calculate random red, green and blue values
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);

		// return newly created Color
		return new Color(red, green, blue);
	}
}
