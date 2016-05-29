package guiBuild;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import coen275project.Food;
import coen275project.FoodStore;
import coen275project.FoodStoreList;

public class SelectStore extends JPanel {
	String[] sList = {"Mission Cafe", "Tago", "Drink", "Snack"};
	JList<String> storeList;
	static FoodStoreList foodstorelist;
	public SelectStore(){
		//setLayout(new GridLayout(0,1));
		//add(new JLabel("Store List"));
		storeList = new JList<>(sList);
		storeList.setPreferredSize(new Dimension(200,400));
		storeList.setFont(new Font("Serif", Font.PLAIN, 24));
		listHandler lh = new listHandler();
		storeList.addListSelectionListener(lh);
		add(storeList);
		
		
	}
	private class listHandler implements ListSelectionListener{
		ArrayList<String> storeMenu = new ArrayList<String>();
		public void valueChanged(ListSelectionEvent e){
			if(e.getValueIsAdjusting() ){
				JFrame foodStoreMenuWindow = new JFrame();
				foodStoreMenuWindow.setSize(500,500);
				foodStoreMenuWindow.setVisible(true);
				foodStoreMenuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//foodStoreMenuWindow.pack();
				FoodStore fs = foodstorelist.getFoodStore(storeList.getSelectedValue());
				FoodStoreMenu fsm = new FoodStoreMenu(fs);
				foodStoreMenuWindow.add(fsm);
				
			}
	
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FoodStore cafe1 = new FoodStore("Mission Cafe", 1, "Benson Memorial Hall");
	    FoodStore cafe2 = new FoodStore("Tago", 2, "119 Washington St, Santa Clara");
	    FoodStore vm1 = new FoodStore("Drink", 3, "Benson Memorial Hall");
	    FoodStore vm2 = new FoodStore("Snack", 4, "Engineering Center");
	    
	    Food sandwhich = new Food("sandwhich", 5.99F, 500, true, true, true);
	    Food yoguart = new Food("yoguart", 3.99F, 200, true, true, true);
	    Food hamburger = new Food("hamburger", 8.99F, 1000, true, false, false);
	    Food latte = new Food("latte", 3.99F, 500, true, true, true);
	    Food coke = new Food("coke", 1.99F, 700, false, true, true);
	    Food toritos = new Food("toritos", 2.99F, 1200, false, false, true);
	    Food cheetos = new Food("cheetos", 2.99F, 1100, false, false, true);
	    
	    cafe1.addFoodToList("sandwhich", sandwhich);
	    cafe1.addFoodToList("yoguart", yoguart);
	    cafe1.addFoodToList("latte", latte);
	    
	    cafe2.addFoodToList("hamburger", hamburger);
	    cafe2.addFoodToList("yoguart", yoguart);
	    
	    vm1.addFoodToList("latte", latte);
	    vm1.addFoodToList("coke", coke);
	    
	    vm2.addFoodToList("toritos", toritos);
	    vm2.addFoodToList("cheetos", cheetos);
	    
	    foodstorelist = new FoodStoreList();
	    foodstorelist.addFoodStore("Mission Cafe", cafe1);
	    foodstorelist.addFoodStore("Tago", cafe2);
	    foodstorelist.addFoodStore("Drink", vm1);
	    foodstorelist.addFoodStore("Snack", vm2);
		
		
		JFrame window = new JFrame("Select a store");
		window.setLayout(new GridLayout(1,0));
		SelectStore storeList = new SelectStore();
		Map map = new Map();
		window.setSize(1200, 600);
		window.add(storeList);
		window.add(map);
		
		window.setVisible(true);
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
	}

}

