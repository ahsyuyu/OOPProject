package multiThreadTest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import coen275project.User;
import coen275project.UserManager;

import javax.swing.JButton;

/**
 * @author Lifen
 * perform the same as 
 */
public class GUITest_EventQueue {
	public JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITest_EventQueue window = new GUITest_EventQueue();
					window.frame.setVisible(true);				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUITest_EventQueue() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnParent = new JButton("Parent");
		btnParent.setBounds(38, 31, 117, 29);
		frame.getContentPane().add(btnParent);
		
		JButton btnChild = new JButton("Child");
		btnChild.setBounds(38, 133, 117, 29);
		frame.getContentPane().add(btnChild);
		
		UserManager.createTestFamily();

		
		btnParent.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent event){
	    		  System.out.println("here");
	    		  Thread aWorker = new Thread() {
	    			  public void run(){ 
	    				  User parent = UserManager.getParent();
	    				  parent.getCard().deductMoney(20.0f); }           // Do something that takes a long time

	    		  };// end of thread
	    		  
	    		  aWorker.start();  
	    	  }//end of actionPerformed
	      });//
		
		
		btnChild.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
            	Thread bWorker = new Thread() {
	    			  public void run(){       
	    				  try{ 
	    					  User child = UserManager.getChild();
	    					  child.getCard().deductMoney(15.5f); }           // Do something that takes a long time
	    				  catch(Exception ex){} 
	    			  }
	    		  };
	    		  
	    		  bWorker.start();
            }
         });
		
		frame.setSize(300,200);
		frame.setVisible(true);
	}
}
