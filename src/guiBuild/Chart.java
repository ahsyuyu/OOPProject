package guiBuild;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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


class Slice {
    double value;
    Color color;
    public Slice(double value, Color color) {  
        this.value = value;
        this.color = color;
    }
}
class pieChart extends JPanel {
    Slice[] slices = { new Slice(5, Color.black), 
    new Slice(33, Color.green),
    new Slice(20, Color.yellow), new Slice(15, Color.red) };
    pieChart() {}
    public void paintComponent(Graphics g) {
        drawPie((Graphics2D) g, getBounds(), slices);
    }
    void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
        double total = 0.0D;
        for (int i = 0; i < slices.length; i++) {
            total += slices[i].value;
        }
        double curValue = 0.0D;
        int startAngle = 0;
        for (int i = 0; i < slices.length; i++) {
            startAngle = (int) (curValue * 360 / total);
            int arcAngle = (int) (slices[i].value * 360 / total);
            g.setColor(slices[i].color);
            g.fillArc(area.x, area.y, area.width, area.height, 
            startAngle, arcAngle);
            curValue += slices[i].value;
        }
    }
}
	
public class Chart extends JFrame{
	longChart lc;
	pieChart pc;
	public Chart(){
		setSize(960, 480);
		setTitle("Display Window");
		lc = new longChart();
		lc.setPreferredSize(new Dimension(480,480));
		pc = new pieChart();
		pc.setPreferredSize(new Dimension(480,480));
		add(lc);
		add(pc);		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	    pack();
	    setVisible(true);
	}
	public static void main(String[] args) {		
		new Chart();
		   
	}
}
