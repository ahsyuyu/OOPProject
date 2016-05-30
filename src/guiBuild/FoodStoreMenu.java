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
	String[] colNames = {"Item", "Price", "Calories", "Sugar", "Sodium", "Cholesterol",  "Quantity"};
	String[][] rows = new String[5][7];
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
			rows[counter][2] = Integer.toString( f.getCalories() );
			rows[counter][3] = (f.getSodium())? "Low":"High";
			rows[counter][4] = (f.getSugar())? "Low":"High";
			rows[counter][5] = (f.getCholesterol())? "Low":"High";
	
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
			int[] foodList  = foodStoreMenuList.getSelectedRows();
			float price = 0;
			int calories = 0;
			ArrayList<ArrayList<Boolean>> allNutrition = new ArrayList<>();
			boolean lowSugar;
			boolean lowSodium;
			boolean lowCholesterol;
			
			for(int i = 0; i < foodList.length; i++) {
				ArrayList<Boolean> nutrition = new ArrayList<Boolean>();
				String foodName = (String)foodStoreMenuList.getValueAt(foodList[i],0);
				System.out.println(foodName);
				int quantity = Integer.parseInt( (String)foodStoreMenuList.getValueAt(foodList[i],6) );
				price += quantity * Float.parseFloat( (String)foodStoreMenuList.getValueAt(foodList[i],1) );
				calories += quantity * Integer.parseInt( (String)foodStoreMenuList.getValueAt(foodList[i],2) );
				
				nutrition.add( (foodStoreMenuList.getValueAt(foodList[i],3) == "Low" )? true:false );
				nutrition.add( (foodStoreMenuList.getValueAt(foodList[i],4) == "Low" )? true:false );
				nutrition.add( (foodStoreMenuList.getValueAt(foodList[i],5) == "Low" )? true:false );
				allNutrition.add(nutrition);
			}
			System.out.println(price);
			System.out.println(calories);
			System.out.println(allNutrition);
			
			
		}
	}
	
}
