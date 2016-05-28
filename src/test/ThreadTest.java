package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class GUI extends JFrame{
	public GUI(){
		JButton a = new JButton("a");
		JButton b = new JButton("b");
		a.setBounds(25, 25, 50, 20);
		b.setBounds(25, 70, 50, 20);
		BtnAHandler bah = new BtnAHandler();
		a.addActionListener(bah);
		b.addActionListener(bah);
		add(a);
		add(b);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
	}
	class BtnAHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("(start");
			
			
			Thread aWorker = new Thread() {
				 
				public void run(){						
												// Do something that takes a long time
				 
					try{ Thread.sleep(2000); }
					catch(InterruptedException ex){}
					System.out.println("end)");
					
				}
			};// anonymous-class for aWorker
 
			aWorker.start();  // So we don�t hold up the event dispatch thread
			
			
			/*
			try{ Thread.sleep(2000); }
			catch(InterruptedException ex){}
			System.out.println("end)");
			*/
			
		}
	}
}




public class ThreadTest {
	
	public static void main(String[] args) {
		new GUI();
	}
}
