package guiBuild;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import coen275project.FoodStore;
//import coen275project.FoodStoreList;

public class SelectStore extends JPanel {
	String[] sList = {"The White Elephant", "Tago", "Drink", "Snack"};
	JList<String> storeList;
	//static FoodStoreList foodstorelist;
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
		public void valueChanged(ListSelectionEvent e){
			System.out.println(storeList.getSelectedValue());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FoodStore cafe1 = new FoodStore("The White Elephant", 1, "1190 Lexington St, Santa Clara");
	    FoodStore cafe2 = new FoodStore("Tago", 2, "119 Washington St, Santa Clara");
	    FoodStore vm1 = new FoodStore("Drink", 3, "Benson Memorial Hall");
	    FoodStore vm2 = new FoodStore("Snack", 4, "Engineering Center");
	    
//	    foodstorelist = new FoodStoreList();
//	    foodstorelist.addFoodStore(cafe1);
//	    foodstorelist.addFoodStore(cafe2);
//	    foodstorelist.addFoodStore(vm1);
//	    foodstorelist.addFoodStore(vm2);
		
		
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
