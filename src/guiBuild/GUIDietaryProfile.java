package guiBuild;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
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


public class GUIDietaryProfile extends JPanel {

	// entity
	private User user = null;
	private DietaryProfile myDietaryProfile = null;

	// GUI data
	private static final String[] COLUMN_NAMES = { "Date", "Expense", "User" };

	public static void main(String[] args) {
		String filename = "database/user_1000_0.ser";
		User user = Serialization.deSerialize(filename);
		GUIDietaryProfile GUI_dietaryprofile = new GUIDietaryProfile(user);

		JFrame window = new JFrame("Dietary Profile");
		window.getContentPane().add(GUI_dietaryprofile);
		window.setSize(600, 600);
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

	public GUIDietaryProfile(User user) {

		initializeData(user);
		initializeGUI();
	}

	private void initializeData(User user) {
		this.user = user;
		myDietaryProfile = user.getDietaryProfile();
	}

	private void initializeGUI() {
		
		this.setSize(600, 600);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 

		JPanel panel_info = new JPanel();
		panel_info.setBorder(BorderFactory.createTitledBorder("Information"));
		panel_info.setPreferredSize(new Dimension(600, 100));
		this.add(panel_info);
		panel_info.setLayout(null);

		JScrollPane scrollPane_record = new JScrollPane();
		scrollPane_record.setBorder(BorderFactory.createTitledBorder("Record Information"));
		scrollPane_record.setPreferredSize(new Dimension(600, 200));
		this.add(scrollPane_record);

		JTabbedPane tabbedPane_graph = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_graph.setPreferredSize(new Dimension(600, 230));
		this.add(tabbedPane_graph);

		/************************************* info ******************************************/
		JLabel lblNewLabel_1 = new JLabel("Card Number : ");
		lblNewLabel_1.setBounds(6, 20, 110, 16);
		panel_info.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Current Calorie :");
		lblNewLabel_2.setBounds(6, 50, 110, 16);
		panel_info.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Expense :");
		lblNewLabel_3.setBounds(242, 50, 81, 16);
		panel_info.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("User Name :");
		lblNewLabel_4.setBounds(242, 20, 81, 16);
		panel_info.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("Preference :");
		lblNewLabel_6.setBounds(6, 75, 93, 16);
		panel_info.add(lblNewLabel_6);

		JLabel label_cardnumber = new JLabel(myDietaryProfile.getCardNumber() + "");
		label_cardnumber.setBounds(120, 20, 110, 16);
		panel_info.add(label_cardnumber);

		JLabel label_username = new JLabel(myDietaryProfile.getUserName());
		label_username.setBounds(335, 20, 110, 16);
		panel_info.add(label_username);

		JLabel label_currentcalorie = new JLabel(myDietaryProfile.getCurrentCalorie() + "");
		label_currentcalorie.setBounds(120, 50, 110, 16);
		panel_info.add(label_currentcalorie);

		JLabel label_expense = new JLabel("$ " + myDietaryProfile.getExpense() + "");
		label_expense.setBounds(335, 50, 110, 16);
		panel_info.add(label_expense);

		JCheckBox checkbox_lowSugar = new JCheckBox("lowSugar");
		checkbox_lowSugar.setSelected(myDietaryProfile.getLowSugar());
		checkbox_lowSugar.setBounds(111, 71, 93, 23);
		panel_info.add(checkbox_lowSugar);

		JCheckBox checkbox_lowSodium = new JCheckBox("lowSodium");
		checkbox_lowSodium.setSelected(myDietaryProfile.getLowSodium());
		checkbox_lowSodium.setBounds(204, 71, 110, 23);
		panel_info.add(checkbox_lowSodium);

		JCheckBox checkbox_lowCholesterol = new JCheckBox("LowCholesterol");
		checkbox_lowCholesterol.setSelected(myDietaryProfile.getLowCholesterol());
		checkbox_lowCholesterol.setBounds(326, 71, 129, 23);
		panel_info.add(checkbox_lowCholesterol);

		/************************************* record ******************************************/

		// populate table content
		final int NumberOfRow = myDietaryProfile.getList().size();
		Object[][] data = new Object[NumberOfRow][4];
		for (int i = 0; i < NumberOfRow; i++) {
			data[i][0] = myDietaryProfile.getList().get(i).getDate();
			data[i][1] = myDietaryProfile.getList().get(i).getExpense();
			data[i][2] = myDietaryProfile.getList().get(i).getUserName();
		}

		final JTable table = new JTable(data, COLUMN_NAMES);

		table.setFillsViewportHeight(true); 		// ??

		// scrollPane_record.add(table); 			// avoid this way, use setViewportView instead scrollPane_record.setColumnHeaderView(table);
		scrollPane_record.setViewportView(table); 	// manually add this line, show the table

		


		/************************************ bar graph****************************************/
	

		JPanel panel_bargraph = new JPanel();
		tabbedPane_graph.addTab("Bar Graph", null, panel_bargraph, null);
		panel_bargraph.setPreferredSize(new Dimension(600, 230));
		panel_bargraph.setMinimumSize(new Dimension(600, 230));

		if (myDietaryProfile.getList().size() > 0) {
			BarChart chart = new BarChart();
			
			System.out.println("panel_bargaph dimension: " + tabbedPane_graph.getSize());

			for (int i = 0; i < myDietaryProfile.getList().size(); i++) {
				Random rm = new Random();
				int r = rm.nextInt(256);
				int g = rm.nextInt(256);
				int b = rm.nextInt(256);
				Color color = new Color(r, g, b);
				Bar bar = new Bar(color, (float) myDietaryProfile.getList().get(i).getExpense());
				chart.addBar(i, bar);
			}
			panel_bargraph.add(chart);
		}
		

		/************************************
		 * pie chart
		 ****************************************/

		JPanel panel_pieView = new JPanel();
		tabbedPane_graph.addTab("Pie Chart", null, panel_pieView, null);
		panel_pieView.setPreferredSize(new Dimension(600, 230));
		panel_pieView.setMinimumSize(new Dimension(600, 230));
	

		if (myDietaryProfile.getList().size() > 0) {

			PieChartView pieChart = new PieChartView();

			for (int i = 0; i < myDietaryProfile.getList().size(); i++) {
				Slice slice = new Slice(myDietaryProfile.getList().get(i).getExpense(),
						myDietaryProfile.getList().get(i).getDate());
				pieChart.addSlice(slice);
			}

			panel_pieView.add(pieChart);
			
		}

	}
}



class BarChart extends JPanel {
	private Map<Integer, Bar> bars = new LinkedHashMap<Integer, Bar>();

	public BarChart() {
		setPreferredSize(new Dimension(600, 230)); 	
	}

	public void addBar(Integer i, Bar bar) {
		bars.put(i, bar);
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		int max = Integer.MIN_VALUE;
		for (Bar bar : bars.values()) {
			float f = bar.getValue();
			max = Math.max(max, (int) f);
		}

		int width = getWidth()/bars.size() - 5;
		int x = 1;
		for (Bar bar : bars.values()) {
			int value = (int) bar.getValue().floatValue();
			int height = (int) ((getHeight() - 5) * ((double) value / max)); 
			g.setColor(bar.getColor());
			g.fillRect(x, getHeight() - height, width, height);
			g.setColor(Color.black);
			g.drawRect(x, getHeight() - height, width, height); 							
			x += (width + 2);
		}
		
		
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
	
	private List list = new ArrayList();
	
	public PieChartView() {
		setPreferredSize(new Dimension(600, 230)); 	
		setMinimumSize(new Dimension(600, 230)); 	
	}

	public void addSlice(Slice slice) {
		if (slice == null)
			throw new NullPointerException();
		list.add(slice);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		double total = getTotal();

		Iterator iterator = list.iterator();
		Slice slice = null;
		
		int min = Math.min(getWidth(), getHeight());
		double curValue = 0.0D;
		int startAngle = 0;
	
		
		while (iterator.hasNext()) {

			int arcAngle = 0;
			slice = (Slice) iterator.next();
			startAngle = (int) (curValue * 360 / total);
			arcAngle = (int) (slice.getValue() * 360 / total);
			g.setColor(slice.getColor());
			g.fillArc(getWidth() / 2 - min / 2, getHeight() / 2 - min/2, min - 50, min - 50, startAngle, arcAngle);
			curValue += slice.getValue();
			g.setColor(Color.black);
			g.drawArc(getWidth() / 2 - min / 2, getHeight() / 2 - min/2, min - 50, min - 50, startAngle, arcAngle);
			
		}


	}
	
	private double getTotal() {
		double sum = 0.0;

		Iterator iterator = list.iterator();
		Slice account = null;

		while (iterator.hasNext()) {
			account = (Slice) iterator.next();
			sum += account.getValue();
		}
		System.out.println("sum = " + sum);
		return sum;
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


/*   try drawing with tripe
// class PieChartView extends JPanel {
// public PieChartView() {
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
// int min = Math.min(getWidth(), getHeight()) / 2;
// double curValue = 0.0D;
// int startAngle = 0;
//
// while (iterator.hasNext()) {
// int arcAngle = 0;
// slice = (Slice) iterator.next();
// startAngle = (int) (curValue * 360 / total);
// arcAngle = (int) (slice.getValue() * 360 / total);
// g.setColor(slice.getColor());
// g.fillArc(getWidth() / 2 - min / 2, getHeight() / 2 - min, min - 10, min -
// 10, startAngle, arcAngle);
// curValue += slice.getValue();
// System.out.println("min " + min + " " +getWidth() + " "+ getHeight());
// }
//
// g.setColor(Color.black);
// g.drawArc(getWidth() / 2 - min / 2, getHeight() / 2 - min, min - 10, min -
// 10, 0, 360);
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
// return new Dimension(getWidth(), getHeight());
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

*/