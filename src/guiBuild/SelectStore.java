package guiBuild;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import coen275project.Cafe;
import coen275project.Food;
import coen275project.FoodStore;
import coen275project.FoodStoreList;
import coen275project.Serialization;
import coen275project.User;
import coen275project.VendingMachine;

public class SelectStore extends JPanel {
	String[] sList = {"Mission Cafe", "Tago", "Drink", "Snack"};
	JList<String> storeList;
	static JPanel listPanel;
	static JPanel mapPanel;
	static FoodStoreList foodstorelist;
	User theUser;
	
	public SelectStore(User u){
		System.out.println(u);
		initialize();
		this.theUser = u;
		setLayout(new GridLayout(1,0));
		listPanel = new JPanel();
		mapPanel = new JPanel();
		
		StoreList sl = new StoreList();
		listPanel.add(sl);
		Map map = new Map(listPanel, mapPanel);
		mapPanel.add(map);
		
		add(listPanel);
		add(mapPanel);		
		
	}
	
	class StoreList extends JPanel{
		public StoreList(){
			//setLayout(new GridLayout(0,1));
			//add(new JLabel("Store List"));
			storeList = new JList<>(sList);
			storeList.setPreferredSize(new Dimension(200,400));
			storeList.setFont(new Font("Serif", Font.PLAIN, 24));
			listHandler lh = new listHandler();
			storeList.addListSelectionListener(lh);
			add(storeList);
			
			
		}
	}
	
	private class listHandler implements ListSelectionListener{
		ArrayList<String> storeMenu = new ArrayList<String>();
		public void valueChanged(ListSelectionEvent e){
			if(e.getValueIsAdjusting() ){
				mapPanel.removeAll();
				mapPanel.repaint();
//				JFrame foodStoreMenuWindow = new JFrame();
//				foodStoreMenuWindow.setSize(500,500);
//				foodStoreMenuWindow.setVisible(true);
//				foodStoreMenuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				FoodStore fs = foodstorelist.getFoodStore(storeList.getSelectedValue());//
				FoodStoreMenu fsm = new FoodStoreMenu(theUser, fs);

				mapPanel.add(fsm);
				mapPanel.revalidate();
			}
		}
	}
	
	class Map extends JPanel {
		private JPanel listPanel;
		private JPanel mapPanel;
		public Map(JPanel lp, JPanel mp){
			
			this.listPanel = lp;
			this.mapPanel = mp;
			ImageIcon imageIcon = new ImageIcon((new ImageIcon("image.jpg"))
					.getImage().getScaledInstance(600, 600,
					java.awt.Image.SCALE_SMOOTH));
			//ImageIcon imageIcon = new ImageIcon("image.jpg");
			MapHandler mh = new MapHandler();
			addMouseListener(mh);
			add(new JLabel(imageIcon));
		}
	}
	
	private class MapHandler implements MouseListener{
		
		public void mouseClicked(MouseEvent e){
			//System.out.println(e.getX() + " " + e.getY());
			listPanel.removeAll();
			listPanel.repaint();
			int x = e.getX();
			int y = e.getY();
			String storeName = "";
			//blue Daly Science
			if(x > 150 && x < 200 && y > 97 && y < 140){
				System.out.println("blue");
				storeName = "Drink";
			}
			else if(x > 107 && x < 143 && y > 250 && y < 292){
				System.out.println("orange");
				storeName = "Tago";
			}
			else if(x > 496 && x < 540 && y > 302 && y < 340){
				System.out.println("green");
				storeName = "Snack";
			}
			else if(x > 365 && x < 400 && y > 446 && y < 486){
				System.out.println("red");
				storeName = "Mission Cafe";
			}
//			JFrame foodStoreMenuWindow = new JFrame();
//			foodStoreMenuWindow.setSize(500,500);
//			foodStoreMenuWindow.setVisible(true);
//			foodStoreMenuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			FoodStore fs = SelectStore.foodstorelist.getFoodStore(storeName);
			FoodStoreMenu fsm = new FoodStoreMenu(theUser, fs);
			//foodStoreMenuWindow.add(fsm);
			listPanel.add(fsm);
			listPanel.revalidate();
			
		}
		public void mousePressed(MouseEvent e){};
		public void mouseReleased(MouseEvent e){};
		public void mouseEntered(MouseEvent e){};
		public void mouseExited(MouseEvent e){}
	}
	
	public void initialize(){
		// TODO Auto-generated method stub
		
		Cafe cafe1 = new Cafe("Mission Cafe", 1, "Benson Memorial Hall");
		Cafe cafe2 = new Cafe("Tago", 2, "119 Washington St, Santa Clara");
	    VendingMachine vm1 = new VendingMachine("Drink", 3, "Daly Science Center");
	    VendingMachine vm2 = new VendingMachine("Snack", 4, "Engineering Center");
	    
	    Food sandwhich = new Food("Sandwhich", 5.99F, 500, true, true, true);
	    Food yoguart = new Food("Yoguart", 3.99F, 100, true, true, true);
	    Food hamburger = new Food("Hamburger", 8.99F, 1500, true, false, false);
	    Food pizza = new Food("Pizza", 4.49F, 250, true, false, false);
	    Food latte = new Food("Latte", 3.99F, 500, true, true, true);
	    Food american = new Food("American Coffee", 3.49F, 500, true, true, true);
	    Food coke = new Food("Coke", 1.99F, 140, false, true, true);
	    Food toritos = new Food("Toritos", 2.99F, 130, false, false, true);
	    Food cheetos = new Food("Cheetos", 2.99F, 150, false, false, true);
	    Food chipAhoy = new Food("Chips Ahoy", 1.99F, 110, false, false, true);
	    
	    cafe1.addFoodToList(sandwhich.getName(), sandwhich);
	    cafe1.addFoodToList(yoguart.getName(), yoguart);
	    cafe1.addFoodToList(latte.getName(), latte);
	    
	    cafe2.addFoodToList(hamburger.getName(), hamburger);
	    cafe2.addFoodToList(yoguart.getName(), yoguart);
	    cafe2.addFoodToList(pizza.getName(), pizza);
	    
	    vm1.addFoodToList(latte.getName(), latte);
	    vm1.addFoodToList(coke.getName(), coke);
	    vm1.addFoodToList(american.getName(), american);
	    
	    vm2.addFoodToList(toritos.getName(), toritos);
	    vm2.addFoodToList(cheetos.getName(), cheetos);
	    vm2.addFoodToList(chipAhoy.getName(), chipAhoy);
	    
	    foodstorelist = new FoodStoreList();
	    foodstorelist.addFoodStore("Mission Cafe", cafe1);
	    foodstorelist.addFoodStore("Tago", cafe2);
	    foodstorelist.addFoodStore("Drink", vm1);
	    foodstorelist.addFoodStore("Snack", vm2);
	    
	}
	
	public static void main(String[] args) {
//		User u = Serialization.deSerialize("database/user_1002_0.ser");
//		JFrame window = new JFrame("Select a store");
//		SelectStore ss = new SelectStore(u);
//		window.add(ss);
//		window.setSize(1200, 600);
//		window.setVisible(true);
//		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

}

