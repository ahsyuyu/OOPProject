package guiBuild;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

class longChart extends JPanel{
	private int x = 25, y;
	private int gap = 5;
	private int height = 25;
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int[] nums = {50, 100, 75};
		genChart(g, nums);
	}
	private void genChart(Graphics g, int[] nums){
		Graphics2D g2 = (Graphics2D)g;
		for(int i = 0; i < nums.length; i++){
			y += height + gap;
			g2.setPaint(Color.BLUE);
			g2.fill(new Rectangle2D.Double(x,y,nums[i],height));
		}
	}
}

public class Chart extends JFrame{
	longChart lc;
	public Chart(){
		setTitle("Display Window");
		lc = new longChart();
		lc.setPreferredSize(new Dimension(640,480));
		getContentPane().add(lc);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	    pack();
	    setVisible(true);
	}
	public static void main(String[] args) {		
		new Chart();
		   
	}
}
