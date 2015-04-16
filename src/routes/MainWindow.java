package routes;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static HashMap<String, List<String>> data;
	private JTextField txtShadbi;

	public static void main(String[] args) {

		// data();

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		txtShadbi = new JTextField();
		txtShadbi.setEditable(false);
		txtShadbi.setText("Shadbi");

		frame.getContentPane().add(txtShadbi);
		txtShadbi.setColumns(10);

		JLabel lblCurrantLocation = new JLabel("Currant Location :");
		springLayout.putConstraint(SpringLayout.NORTH, txtShadbi, -3,
				SpringLayout.NORTH, lblCurrantLocation);
		springLayout.putConstraint(SpringLayout.WEST, txtShadbi, 33,
				SpringLayout.EAST, lblCurrantLocation);
		springLayout.putConstraint(SpringLayout.NORTH, lblCurrantLocation, 27,
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblCurrantLocation, 10,
				SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblCurrantLocation);

		JLabel lblAccedentLocation = new JLabel("Accedent Location:");
		springLayout.putConstraint(SpringLayout.NORTH, lblAccedentLocation, 13,
				SpringLayout.SOUTH, lblCurrantLocation);
		springLayout.putConstraint(SpringLayout.WEST, lblAccedentLocation, 10,
				SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblAccedentLocation);

		data();
		JComboBox<String> comboBox = new JComboBox<String>();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, -3, SpringLayout.NORTH, lblAccedentLocation);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, txtShadbi);
		frame.getContentPane().add(comboBox);
		
		comboBox.addItem("--Select Location--");
		Iterator<Entry<String, List<String>>> it = data.entrySet().iterator();
		  while (it.hasNext()) {
		        Entry<String, List<String>> pair = it.next();
		    
		       it.remove(); // avoids a ConcurrentModificationException
		       
		       comboBox.addItem(pair.getKey());
		    }
		 
		
		  comboBox.addActionListener (new ActionListener () {
			  

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					
					if(comboBox.getSelectedIndex()!=0){
					
					 String cmboitem = (String) comboBox.getSelectedItem();
					 System.out.println(cmboitem);
					}
					
				}
			});

	}

	public void data() {

		data = new HashMap<String, List<String>>();
	

		List<String> Flemnglist = new ArrayList<String>();

		Flemnglist.add(0, "path 1");
		Flemnglist.add(1, "path 2");
		Flemnglist.add(2, "path 3");
		Flemnglist.add(3, "path 4");
		data.put("Flemng", Flemnglist);

		// ===========================================================
		List<String> Loran = new ArrayList<String>();

		Loran.add(0, "path 5");
		Loran.add(1, "path 6");
		data.put("Loran", Loran);

		// =============================================================
		List<String> MohremList = new ArrayList<String>();

		MohremList.add(0, "path 7");
		MohremList.add(1, "path 8");
		MohremList.add(2, "path 9");

		data.put("MohermBeh", MohremList);

		// ==============================================================
		List<String> glimList = new ArrayList<String>();

		glimList.add(0, "path 10");
		glimList.add(1, "path 11");
		glimList.add(2, "path 12");
		glimList.add(1, "path 13");
		glimList.add(2, "path 14");

		data.put("Glim", glimList);
		// ====================================================

		List<String> sabaList = new ArrayList<String>();

		sabaList.add(0, "path 14");
		sabaList.add(1, "path 15");
		sabaList.add(2, "path 16");
		sabaList.add(3, "path 17");
		
		data.put("Saba Basha", sabaList);
		//========================================

		List<String> bakous = new ArrayList<String>();

		bakous.add(0, "path 18");
		bakous.add(1, "path 19");
		
		
		data.put("Bakous", bakous);
		
		//========================================================

		List<String> stanlyList = new ArrayList<String>();

		stanlyList.add(0, "path 20");
		stanlyList.add(1, "path 21");
		stanlyList.add(2, "path 22");
		
		
		data.put("Stanly", stanlyList);

		///===========================================================
		List<String> vactoryalist = new ArrayList<String>();

		vactoryalist.add(0, "path 23");
		vactoryalist.add(1, "path 24");
		
		
		
		data.put("Vactorya", vactoryalist);
		
		//================================================================

		List<String> wzaraList = new ArrayList<String>();

		wzaraList.add(0, "path 25");
		wzaraList.add(1, "path 26");
		wzaraList.add(0, "path 27");
		wzaraList.add(1, "path 28");
		wzaraList.add(0, "path 29");
		wzaraList.add(1, "path 30");
		
		data.put("El Wzara", wzaraList);
		
		//=================================================================

		List<String> cleopatraList = new ArrayList<String>();

		cleopatraList.add(0, "path 31");
		cleopatraList.add(1, "path 32");
		
		
		data.put("Cleopatra", cleopatraList);
		
		//===================================================================
		List<String> SportingList = new ArrayList<String>();

		SportingList.add(0, "path 33");
		SportingList.add(1, "path 34");
		
		
		data.put("Sporting", SportingList);

		
		//==========================================================
		List<String> mahfousList = new ArrayList<String>();

		mahfousList.add(0, "path 35");
		mahfousList.add(1, "path 36");
		mahfousList.add(2, "path 37");
		
		
		data.put("Mohamed Mahfouz", mahfousList);

	
	}
}
