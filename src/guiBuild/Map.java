package guiBuild;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import coen275project.FoodStore;

//public class Map extends JPanel {
//	private JPanel listPanel;
//	private JPanel mapPanel;
//	public Map(JPanel lp, JPanel mp){
//		this.listPanel = lp;
//		this.mapPanel = mp;
//		ImageIcon imageIcon = new ImageIcon((new ImageIcon("image.jpg"))
//				.getImage().getScaledInstance(600, 600,
//				java.awt.Image.SCALE_SMOOTH));
//		//ImageIcon imageIcon = new ImageIcon("image.jpg");
//		MapHandler mh = new MapHandler();
//		addMouseListener(mh);
//		add(new JLabel(imageIcon));
//	}
//
//	private class MapHandler implements MouseListener{
//		SelectStore.listPanel.removeAll();
//		public void mouseClicked(MouseEvent e){
//			//System.out.println(e.getX() + " " + e.getY());
//			int x = e.getX();
//			int y = e.getY();
//			String storeName = "";
//			//blue Daly Science
//			if(x > 150 && x < 200 && y > 97 && y < 140){
//				System.out.println("blue");
//				storeName = "Drink";
//			}
//			else if(x > 107 && x < 143 && y > 250 && y < 292){
//				System.out.println("orange");
//				storeName = "Tago";
//			}
//			else if(x > 496 && x < 540 && y > 302 && y < 340){
//				System.out.println("green");
//				storeName = "Snack";
//			}
//			else if(x > 365 && x < 400 && y > 446 && y < 486){
//				System.out.println("red");
//				storeName = "Mission Cafe";
//			}
//			JFrame foodStoreMenuWindow = new JFrame();
//			foodStoreMenuWindow.setSize(500,500);
//			foodStoreMenuWindow.setVisible(true);
//			foodStoreMenuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			//foodStoreMenuWindow.pack();
//			FoodStore fs = SelectStore.foodstorelist.getFoodStore(storeName);
//			FoodStoreMenu fsm = new FoodStoreMenu(fs);
//			foodStoreMenuWindow.add(fsm);
//			
//		}
//		public void mousePressed(MouseEvent e){};
//		public void mouseReleased(MouseEvent e){};
//		public void mouseEntered(MouseEvent e){};
//		public void mouseExited(MouseEvent e){}
//	}
//
//}

