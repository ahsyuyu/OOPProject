package guiBuild;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Map extends JPanel {
	public Map(){
		ImageIcon imageIcon = new ImageIcon((new ImageIcon("image.jpg"))
				.getImage().getScaledInstance(600, 600,
				java.awt.Image.SCALE_SMOOTH));
		//ImageIcon imageIcon = new ImageIcon("image.jpg");
		MapHandler mh = new MapHandler();
		addMouseListener(mh);
		add(new JLabel(imageIcon));
	}
	
	private class MapHandler implements MouseListener{
		public void mouseClicked(MouseEvent e){
			System.out.println(e.getX() + " " + e.getY());
		}
		public void mousePressed(MouseEvent e){};
		public void mouseReleased(MouseEvent e){};
		public void mouseEntered(MouseEvent e){};
		public void mouseExited(MouseEvent e){}
	}

}

