package guiBuild;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import coen275project.Food;
import coen275project.FoodStore;

public class FoodStoreMenu extends JPanel {
	FoodStore foodStore;
	JTable foodStoreMenuList;
	String[] colNames = {"Item", "Price", "Quantity"};
	String[][] rows = new String[5][3];
	public FoodStoreMenu(FoodStore fs){
		this.foodStore = fs;
		HashMap<String, Food> fsm = fs.getFoodList();
		//DefaultListModel<String> fooddlm = new DefaultListModel<String>();
		Iterator<?> it = fsm.entrySet().iterator();
		int counter = 0;
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			rows[counter][0] = (String)pair.getKey();
			Food f = (Food)pair.getValue();
			rows[counter][1] = Float.toString( f.getPrice() );

			counter++;
		}
		
		foodStoreMenuList = new JTable(rows, colNames);
		JScrollPane scrollPane = new JScrollPane(foodStoreMenuList);
		add(scrollPane);
		JButton checkout = new JButton("Checkout");
		checkoutHandler ch = new checkoutHandler();
		checkout.addActionListener(ch);
		add(checkout);
	}
	
	
	
	class checkoutHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//List<String> items = foodStoreMenuList.getSelectedValuesList();
			//System.out.println(items);
		}
	}
	
}
