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
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import coen275project.*;
import javafx.scene.control.CheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIExpenseProfile extends JPanel implements Observer {

	// entity
	User user = null;
	private ExpenseProfile myExpenseProfile = null;

	// GUI data
	private static final String[] COLUMN_NAMES = { "Date", "Expense", "Location" };

	public static void main(String[] args) {
		String filename = "database/user_1000_0.ser";
		User user = Serialization.deSerialize(filename);
		GUIExpenseProfile GUI_expenseprofile = new GUIExpenseProfile(user);

		JFrame window = new JFrame("Expense Profile");
		window.getContentPane().add(GUI_expenseprofile);

		window.setSize(800, 600);
		window.setLocationRelativeTo(null);
		try {
			// 1.6+
			window.setLocationByPlatform(true); // !!!
			window.setMinimumSize(window.getSize()); // !!!
		} catch (Throwable ignoreAndContinue) {
		}
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public GUIExpenseProfile(User user) {
		initializeData(user);
		initializeGUI();
	}

	private void initializeData(User user) {
		this.user = user;
		myExpenseProfile = user.getExpenseProfile();
		myExpenseProfile.addObserver(this);
	}

	public void update(Observable observable, Object object) {
		//System.out.println("MVC test, step 2");
		this.removeAll();
		initializeGUI();
	}

	private void initializeGUI() {

		/************************************** JFrame ******************************************/

		this.setSize(800, 700);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel_info = new JPanel();
		panel_info.setBorder(BorderFactory.createTitledBorder("Information"));
		panel_info.setPreferredSize(new Dimension(800, 70));
		this.add(panel_info);
		panel_info.setLayout(null);

		JScrollPane scrollPane_record = new JScrollPane();
		scrollPane_record.setBorder(BorderFactory.createTitledBorder("Record Information"));
		scrollPane_record.setPreferredSize(new Dimension(800, 190));
		scrollPane_record.setMaximumSize(new Dimension(800, 190));
		this.add(scrollPane_record);

		JTabbedPane tabbedPane_graph = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_graph.setPreferredSize(new Dimension(800, 300));
		this.add(tabbedPane_graph);

		/************************************* info ******************************************/
		JLabel lblNewLabel_1 = new JLabel("Card Number : ");
		lblNewLabel_1.setBounds(6, 20, 131, 16);
		panel_info.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Fund of this month:");
		lblNewLabel_2.setBounds(6, 50, 131, 16);
		panel_info.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Expense :");
		lblNewLabel_3.setBounds(581, 50, 81, 16);
		panel_info.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("User Name :");
		lblNewLabel_4.setBounds(291, 20, 145, 16);
		panel_info.add(lblNewLabel_4);

		JLabel lblPeriod = new JLabel("Period :");
		lblPeriod.setBounds(581, 20, 81, 16);
		panel_info.add(lblPeriod);

		JLabel lblNextFund = new JLabel("Fund Of Next Month :");
		lblNextFund.setBounds(291, 50, 145, 16);
		panel_info.add(lblNextFund);

		JLabel label_cardnumber = new JLabel(myExpenseProfile.getCardNumber() + "");
		label_cardnumber.setForeground(Color.BLUE);
		label_cardnumber.setBounds(149, 20, 110, 16);
		panel_info.add(label_cardnumber);

		JLabel label_username = new JLabel(myExpenseProfile.getUserName());
		label_username.setForeground(Color.BLUE);
		label_username.setBounds(448, 20, 89, 16);
		panel_info.add(label_username);

		JLabel label_currentfund = new JLabel("$ " + myExpenseProfile.getCurrentFund());
		label_currentfund.setForeground(Color.BLUE);
		label_currentfund.setBounds(149, 50, 110, 16);
		panel_info.add(label_currentfund);

		JLabel label_expense = new JLabel("$ " + myExpenseProfile.getExpense());
		label_expense.setForeground(Color.BLUE);
		label_expense.setBounds(674, 50, 110, 16);
		panel_info.add(label_expense);

		JLabel label_period = new JLabel(myExpenseProfile.getPeriod());
		label_period.setForeground(Color.BLUE);
		label_period.setBounds(674, 20, 110, 16);
		panel_info.add(label_period);

		JLabel label_nextfund = new JLabel("$ " + myExpenseProfile.getNextFund());
		label_nextfund.setForeground(Color.GRAY);
		label_nextfund.setBounds(448, 50, 89, 16);
		panel_info.add(label_nextfund);

		/************************************* record ******************************************/

		final int NumberOfRow = myExpenseProfile.getList().size();
		Object[][] data = new Object[NumberOfRow][4];
		for (int i = 0; i < NumberOfRow; i++) {
			data[i][0] = myExpenseProfile.getList().get(i).getDate();
			data[i][1] = myExpenseProfile.getList().get(i).getExpense();
			data[i][2] = myExpenseProfile.getList().get(i).getStoreName();
		}

		final JTable table = new JTable(data, COLUMN_NAMES);
		table.setFillsViewportHeight(true);
		scrollPane_record.setViewportView(table);

		/************************************ tabbedPane ****************************************/

		// bar graph
		JPanel panel_bargraph = new JPanel();
		panel_bargraph.setLayout(new BoxLayout(panel_bargraph, BoxLayout.Y_AXIS));
		tabbedPane_graph.addTab("Bar Graph", null, panel_bargraph, null);
		panel_bargraph.setPreferredSize(new Dimension(800, 300));
		panel_bargraph.setMinimumSize(new Dimension(800, 300));

		// top
		JPanel panel_bargraph_top = new JPanel();
		panel_bargraph_top.setPreferredSize(new Dimension(800, 30));
		panel_bargraph_top.setMinimumSize(new Dimension(800, 30));
		panel_bargraph_top.setMaximumSize(new Dimension(800, 30));
		panel_bargraph.add(panel_bargraph_top);

		// scroll will be add after bargraph

		// pie chart
		JPanel panel_piechart = new JPanel();
		tabbedPane_graph.addTab("Pie Chart", null, panel_piechart, null);
		panel_piechart.setPreferredSize(new Dimension(800, 300));
		panel_piechart.setMinimumSize(new Dimension(800, 300));

		JPanel panel_piechart_left = new JPanel();
		panel_piechart_left.setPreferredSize(new Dimension(350, 300));
		panel_piechart_left.setMinimumSize(new Dimension(350, 300));
		panel_piechart.add(panel_piechart_left);

		JPanel panel_piechart_right = new JPanel();
		panel_piechart_right.setLayout(new BoxLayout(panel_piechart_right, BoxLayout.Y_AXIS));
		panel_piechart_right.setPreferredSize(new Dimension(350, 300));
		panel_piechart_right.setMinimumSize(new Dimension(350, 300));
		panel_piechart.add(panel_piechart_right);

		/**********************************************
		 * bargraph top
		 ****************************************/
		JButton button_1 = new JButton();
		button_1.setPreferredSize(new Dimension(16, 16));
		button_1.setBackground(Color.ORANGE);
		button_1.setOpaque(true);
		button_1.setBorderPainted(false);

		JButton button_2 = new JButton();
		button_2.setPreferredSize(new Dimension(16, 16));
		button_2.setBackground(Color.PINK);
		button_2.setOpaque(true);
		button_2.setBorderPainted(false);

		JButton button_3 = new JButton();
		button_3.setPreferredSize(new Dimension(16, 16));
		button_3.setBackground(Color.CYAN);
		button_3.setOpaque(true);
		button_3.setBorderPainted(false);

		JButton button_4 = new JButton();
		button_4.setPreferredSize(new Dimension(16, 16));
		button_4.setBackground(Color.YELLOW);
		button_4.setOpaque(true);
		button_4.setBorderPainted(false);

		JLabel label_1 = new JLabel();
		label_1.setPreferredSize(new Dimension(160, 16));
		label_1.setText("Drink Vending Machine");

		JLabel label_2 = new JLabel();
		label_2.setPreferredSize(new Dimension(160, 16));
		label_2.setText("Snack Vending Machine");

		JLabel label_3 = new JLabel();
		label_3.setPreferredSize(new Dimension(120, 16));
		label_3.setText("Tago Restaurant");

		JLabel label_4 = new JLabel();
		label_4.setPreferredSize(new Dimension(120, 16));
		label_4.setText("Mission Cafe");

		panel_bargraph_top.add(button_1);
		panel_bargraph_top.add(label_1);
		panel_bargraph_top.add(button_2);
		panel_bargraph_top.add(label_2);
		panel_bargraph_top.add(button_3);
		panel_bargraph_top.add(label_3);
		panel_bargraph_top.add(button_4);
		panel_bargraph_top.add(label_4);

		/************************************
		 * bar graph
		 ************************************/
		if (myExpenseProfile.getList().size() > 0) {

			BarChart chart = new BarChart();
			chart.setPreferredSize(new Dimension(myExpenseProfile.getList().size() * 110, 200));

			for (int i = 0; i < myExpenseProfile.getList().size(); i++) {

				ExpenseRecord r = myExpenseProfile.getList().get(i);

				Color color = null;
				if (r.getStoreName().equals("Drink Vending Machine")) {
					color = new Color(255, 200, 0); // orange
				} else if (r.getStoreName().equals("Snack Vending Machine")) {
					color = new Color(255, 175, 175); // pink
				} else if (r.getStoreName().equals("Tago Restaurant")) {
					color = new Color(0, 255, 255); // cyan
				} else {
					color = new Color(255, 255, 0); // yellow
				}
				Bar bar = new Bar(color, (float) myExpenseProfile.getList().get(i).getExpense(),
						myExpenseProfile.getList().get(i).getDate());
				chart.addBar(i, bar);
			}

			JScrollPane scrollpane_bargraph = new JScrollPane(chart);
			// scrollpane_bargraph.setPreferredSize(new Dimension(800,300));
			scrollpane_bargraph.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			// scrollpane_bargraph.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			panel_bargraph.add(scrollpane_bargraph);

			/*************************************
			 * pie chart right
			 ****************************************/

			JButton button_5 = new JButton();
			button_5.setPreferredSize(new Dimension(16, 16));
			button_5.setBackground(Color.WHITE);
			button_5.setOpaque(true);
			button_5.setBorderPainted(false);

			JLabel lblRemainFundOf = new JLabel();
			lblRemainFundOf.setPreferredSize(new Dimension(300, 16));
			lblRemainFundOf.setText("remain fund of this month: $ "
					+ (myExpenseProfile.getCurrentFund() - myExpenseProfile.getExpense()));

			JButton button_6 = new JButton();
			button_6.setPreferredSize(new Dimension(16, 16));
			button_6.setBackground(Color.RED);
			button_6.setOpaque(true);
			button_6.setBorderPainted(false);

			JLabel label_6 = new JLabel();
			label_6.setPreferredSize(new Dimension(300, 16));
			label_6.setText("expense of this month: $ " + myExpenseProfile.getExpense());

			JPanel panel_row1 = new JPanel();
			panel_row1.setPreferredSize(new Dimension(300, 125));

			JPanel panel_row2 = new JPanel();
			panel_row2.setPreferredSize(new Dimension(300, 125));

			panel_row1.add(button_5);
			panel_row1.add(lblRemainFundOf);
			panel_row2.add(button_6);
			panel_row2.add(label_6);

			panel_piechart_right.add(panel_row1);
			panel_piechart_right.add(panel_row2);

			/*************************************
			 * pie chart left
			 ****************************************/

			PieChartView pieChart = new PieChartView();
			if (myExpenseProfile.getList().size() > 0) {
				Slice slice = new Slice(myExpenseProfile.getExpense(), Color.RED);
				pieChart.addSlice(slice);
				slice = new Slice(myExpenseProfile.getCurrentFund() - myExpenseProfile.getExpense(), Color.WHITE);
				pieChart.addSlice(slice);
			} else {
				Slice slice = new Slice(1.0f, Color.WHITE);
				pieChart.addSlice(slice);
			}
			panel_piechart_left.add(pieChart);

		}
	}
}

// class BarChart extends JPanel {
// private Map<Integer, Bar> bars = new LinkedHashMap<Integer, Bar>();
//
// public BarChart() {
//
// }
//
// public BarChart(Dimension d) {
// setPreferredSize(d);
// // System.out.println("public BarChart(Dimension d)");
// }
//
// public void addBar(Integer i, Bar bar) {
// bars.put(i, bar);
// // cannot call paintComponent() or paint() directly
// repaint();
//
// // System.out.println("public void addBar(Integer i, Bar bar)");
// }
//
// @Override
// protected void paintComponent(Graphics g) {
// // determine longest bar
// // System.out.println("paintComponent");
// int max = Integer.MIN_VALUE;
// for (Bar bar : bars.values()) {
// float f = bar.getValue();
// max = Math.max(max, (int) f);
// }
//
// // paint bars
// // int width = (getWidth() / bars.size());
// int width = (20);
// int x = 1;
// for (Bar bar : bars.values()) {
// int value = (int) bar.getValue().floatValue();
// int height = (int) ((getHeight() - 5) * ((double) value / max));
// g.setColor(bar.getColor());
// g.fillRect(x, getHeight() - height, width, height);
// g.setColor(Color.black);
// g.drawRect(x, getHeight() - height, width, height); // draw
// // border
// x += (width + 2);
// // System.out.println("" + x + " " + (getHeight() - height) + "
// // " + width + " " + height);
// }
// }
//
// @Override
// public Dimension getPreferredSize() {
// return new Dimension(bars.size() * 10 + 2, 50); // ??? 但是并没有用到这句
// }
// }
//
// class Bar {
// Color color;
// Float value;
//
// public Bar(Color color, Float value) {
// this.color = color;
// this.value = value;
// }
//
// public Color getColor() {
// return color;
// }
//
// public void setColor(Color color) {
// this.color = color;
// }
//
// public Float getValue() {
// return value;
// }
//
// public void setValue(Float value) {
// this.value = value;
// }
// }
//
// class PieChartView extends JPanel {
//
// public PieChartView() {
//
// }
//
// private List list = new ArrayList();
//
// public void addSlice(Slice slice) {
//
// if (slice == null)
// throw new NullPointerException();
//
// list.add(slice);
//
// repaint();
// }
//
// public void paintComponent(Graphics g) {
// super.paintComponent(g);
// drawPieChart(g);
// }
//
// private void drawPieChart(Graphics g) {
// double total = getTotal();
//
// Iterator iterator = list.iterator();
// Slice slice = null;
//
//// int min = Math.min(getWidth(), getHeight()) / 2;
// int min = Math.min(getWidth(), getHeight());
// double curValue = 0.0D;
// int startAngle = 0;
//
// while (iterator.hasNext()) {
// int arcAngle = 0;
// slice = (Slice) iterator.next();
// startAngle = (int) (curValue * 360 / total);
// arcAngle = (int) (slice.getValue() * 360 / total);
// g.setColor(slice.getColor());
//// g.fillArc(getWidth() / 2 - min / 2, getHeight() / 2 - min, min - 10, min -
// 10, startAngle, arcAngle);
// g.fillArc(0, 0, min-60, min-60, startAngle, arcAngle);
// curValue += slice.getValue();
//
//
// System.out.println(this.getBounds());
// System.out.println("min " + min + " " +getWidth() + " "+ getHeight());
// }
//
// g.setColor(Color.black);
//// g.drawArc(getWidth() / 2 - min / 2, getHeight() / 2 - min, min - 10, min -
// 10, 0, 360);
// g.drawArc(0, 0, min-60, min-60, 0, 360);
//
// } // end method drawPieChart
//
//
//
// private double getTotal() {
// double sum = 0.0;
//
// Iterator iterator = list.iterator();
// Slice account = null;
//
// while (iterator.hasNext()) {
// account = (Slice) iterator.next();
// sum += account.getValue();
// }
//
// return sum;
// }
//
// public Dimension getPreferredSize() {
// System.out.println("Systemout dimension" + getWidth() +" " +getHeight());
// int min = Math.min(getWidth(), getHeight());
// return new Dimension(min, min);
//
// }
//
// public Dimension getMinimumSize() {
// return getPreferredSize();
// }
//
// public Dimension getMaximumSize() {
// return getPreferredSize();
// }
// }
//
// class LegendView extends JPanel {
// private List list = new ArrayList();
//
// public LegendView() {
// this.setLayout(new GridLayout(0, 2, 0, 0));
//
// }
//
// public void addSlice(Slice slice) {
// if (slice == null)
// throw new NullPointerException();
//
//
// list.add(slice);
//
// repaint();
// }
//
// @Override
// public void paintComponent(Graphics g) {
// super.paintComponent(g);
//
// drawLegends(g);
// }
//
// private void drawLegends(Graphics g) {
// Iterator iterator = list.iterator();
// Slice slice = null;
//
// Font font = new Font("SansSerif", Font.BOLD, 12);
// g.setFont(font);
//
// FontMetrics metrics = getFontMetrics(font);
// int ascent = metrics.getMaxAscent();
// int offsetY = ascent + 2;
//
// for (int i = 1; iterator.hasNext(); i++) {
//
// slice = (Slice) iterator.next();
// g.setColor(slice.getColor());
// g.fillRect(125, offsetY * i, ascent, ascent);
// g.setColor(Color.black);
// g.drawString(slice.getDate(), 140, offsetY * i + ascent);
// }
// }
//
//
// public Dimension getPreferredSize() {
// return new Dimension(getWidth(), getHeight());
// }
//
// public Dimension getMinimumSize() {
// return getPreferredSize();
// }
//
//
// public Dimension getMaximumSize() {
// return getPreferredSize();
// }
//
// private class Rectangle extends JPanel {
//
// private JButton button;
// private JLabel label;
//
// public Rectangle(Color color, String s) {
// System.out.println("draw rectangle");
// this.button = new JButton();
// button.setBackground(color);
// button.setSize(5, 5);
// label = new JLabel(s);
// label.setSize(15, 5);
// this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
// this.add(button);
// this.add(label);
// }
//
// public JButton getButton() {
// return button;
// }
//
// public void setButton(JButton button) {
// this.button = button;
// }
//
// public JLabel getJLabel() {
// return label;
// }
//
// public void setJLabel(JLabel jLabel) {
// label = jLabel;
// }
//
// public Dimension getPreferredSize() {
// return new Dimension(20, 5);
// }
//
// public Dimension getMinimumSize() {
// return getPreferredSize();
// }
//
// public Dimension getMaximumSize() {
// return getPreferredSize();
// }
//
// }
//
// }
//
// class Slice {
// private float value;
// private String date;
// private Color color;
//
// public Slice(float value, String date) {
// this.value = value;
// this.date = date;
// color = getRandomColor();
// }
//
// public float getValue() {
// return value;
// }
//
// public void setValue(float value) {
// this.value = value;
// }
//
// public String getDate() {
// return date;
// }
//
// public void setDate(String date) {
// this.date = date;
// }
//
// public Color getColor() {
// return color;
// }
//
// public void setColor(Color color) {
// this.color = color;
// }
//
// // get a random Color for drawing pie wedges
// public Color getRandomColor() {
// // calculate random red, green and blue values
// int red = (int) (Math.random() * 256);
// int green = (int) (Math.random() * 256);
// int blue = (int) (Math.random() * 256);
//
// // return newly created Color
// return new Color(red, green, blue);
// }
// }
