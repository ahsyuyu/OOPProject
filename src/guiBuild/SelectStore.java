package guiBuild;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectStore extends JPanel {
	String[] sList = {"mission cafe", "benson"};
	JList<String> storeList;
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
