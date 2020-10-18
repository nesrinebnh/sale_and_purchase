import com.jgoodies.forms.factories.DefaultComponentFactory;

import jason.environment.grid.GridWorldView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.UIManager.*;

public class StoreTruckInterface 
	extends GridWorldView 
	implements ActionListener {

	// Components of the Form 
	private Container c; 
	private JLabel title; 
	private JLabel Manufacturer; 
	private JComboBox ManufacturerB;
	private JLabel Trailer; 
	private JComboBox TrailerB;
	private JLabel Trailer_weight; 
	private JTextField Trailer_weightB; 
	private JLabel Cargo_area; 
	private JComboBox Cargo_areaB;
	private JLabel Cargo_size; 
	private JTextField Cargo_sizeB; 
	private JLabel Price; 
	private JTextField PriceB; 
	
	private JButton sub; 
	private JButton reset; 
	private JTextArea tout; 
	
	private JLabel res; 
	private JTextArea resadd; 

	private JScrollPane scroll;
	
	private String Manufacturers[] = {"All", "Tesla", "Cascadia", "Volva", "Peterbilt", "Ford", "Ram", "Chevrolet", "Nissan", "Toyota", "Tesla"}; 
	private String tf[] = {"All", "true", "false"};
	private StoreEnv.StoreModel model;
	
	private String q = "";
	/**
	 * Create the application.
	 */
	public StoreTruckInterface(StoreEnv.StoreModel model) {
		super(model, "Mars World", 600);
		this.model = model;
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		setTitle("Trucks selling agency"); 
		setBounds(300, 90, 900, 643); 
		//setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false); 

		c = getContentPane(); 
		c.setLayout(null); 

		title = new JLabel("Trucks selling agency"); 
		title.setFont(new Font("Segoe UI BOLD", Font.PLAIN, 30)); 
		title.setSize(300, 40); 
		title.setLocation(300, 30); 
		c.add(title); 
		/***************************/
		Manufacturer = new JLabel("Manufacturer"); 
		Manufacturer.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Manufacturer.setSize(120, 30); 
		Manufacturer.setLocation(100, 100); 
		c.add(Manufacturer); 
		
		ManufacturerB = new JComboBox(Manufacturers); 
		ManufacturerB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		ManufacturerB.setSize(150, 30); 
		ManufacturerB.setLocation(220, 100); 
		c.add(ManufacturerB); 
		/***************************/
		Trailer = new JLabel("Trailer"); 
		Trailer.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Trailer.setSize(120, 30); 
		Trailer.setLocation(100, 150); 
		c.add(Trailer); 
		
		TrailerB = new JComboBox(tf); 
		TrailerB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		TrailerB.setSize(150, 30); 
		TrailerB.setLocation(220, 150); 
		c.add(TrailerB); 
		/***************************/
		Trailer_weight = new JLabel("HP"); 
		Trailer_weight.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Trailer_weight.setSize(100, 30); 
		Trailer_weight.setLocation(100, 200); 
		c.add(Trailer_weight); 
		
		Trailer_weightB = new JTextField(); 
		Trailer_weightB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		Trailer_weightB.setSize(150, 30); 
		Trailer_weightB.setLocation(220, 200); 
		c.add(Trailer_weightB); 
		/***************************/
		Cargo_area = new JLabel("Fuel"); 
		Cargo_area.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Cargo_area.setSize(100, 30); 
		Cargo_area.setLocation(100, 250); 
		c.add(Cargo_area); 
		
		Cargo_areaB = new JComboBox(tf); 
		Cargo_areaB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		Cargo_areaB.setSize(150, 30); 
		Cargo_areaB.setLocation(220, 250); 
		c.add(Cargo_areaB); 
		/***************************/
		Cargo_size = new JLabel("HP"); 
		Cargo_size.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Cargo_size.setSize(100, 30); 
		Cargo_size.setLocation(100, 300); 
		c.add(Cargo_size); 
		
		Cargo_sizeB = new JTextField(); 
		Cargo_sizeB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		Cargo_sizeB.setSize(150, 30); 
		Cargo_sizeB.setLocation(220, 300); 
		c.add(Cargo_sizeB); 
		/***************************/
		Price = new JLabel("Price"); 
		Price.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Price.setSize(100, 30); 
		Price.setLocation(100, 350); 
		c.add(Price); 
		
		PriceB = new JTextField(); 
		PriceB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		PriceB.setSize(150, 30); 
		PriceB.setLocation(220, 350); 
		c.add(PriceB); 
		/***************************/

		sub = new JButton("Submit"); 
		sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
		sub.setSize(100, 30); 
		sub.setLocation(150, 500); 
		sub.addActionListener(this); 
		c.add(sub); 

		reset = new JButton("Reset"); 
		reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
		reset.setSize(100, 30); 
		reset.setLocation(270, 500); 
		reset.addActionListener(this); 
		c.add(reset); 

		tout = new JTextArea("zdzdzd"); 
		tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tout.setSize(6650, 430); 
		//tout.setLocation(400, 100); 
		tout.setLineWrap(true); 
		tout.setEditable(false); 
		scroll = new JScrollPane(tout, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setSize(450, 430); 
		scroll.setLocation(400, 100); 
		c.add(scroll); 
		//c.add(tout); 

		res = new JLabel(""); 
		res.setFont(new Font("Arial", Font.PLAIN, 20)); 
		res.setSize(500, 25); 
		res.setLocation(100, 600); 
		c.add(res); 

		resadd = new JTextArea(); 
		resadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
		resadd.setSize(200, 75); 
		resadd.setLocation(580, 175); 
		resadd.setLineWrap(true); 
		c.add(resadd); 

		setVisible(true);
		this.reset.setEnabled(false);
		
		resetF();
		
		tout.setText("Result area:");
	}
	
	public String getT() {
		String s = ""; 
		s = s + "\"" + ManufacturerB.getSelectedItem() + "\", ";
		s = s + "\"" +  TrailerB.getSelectedItem() + "\", ";
		s = s + Trailer_weightB.getText() + ", ";
		s = s + "\"" + Cargo_areaB.getSelectedItem() + "\", ";
		s = s + Cargo_sizeB.getText() + ", ";
		s = s + PriceB.getText();
		return s;
	}
	public void actionPerformed(ActionEvent e) 
	{ 
		if (e.getSource() == sub) {
			print("[Client] Requesting: " + getT());
			print("════════════════════════════════════");
			this.q = getT();
			this.sub.setEnabled(false);
			this.reset.setEnabled(true);
			this.model.send_truck(this.q);
		}
		else if (e.getSource() == reset) { 
			this.model.reset_truck(this.q);
			this.q = "";
			this.sub.setEnabled(true);
			this.reset.setEnabled(false);
			print("[System] Clearing the request.");
			print("█████████████████████████████████████");
			resetF();

		} 
	} 
	void resetF() {
		String def = "0"; 
		ManufacturerB.setSelectedIndex(0); 
		TrailerB.setSelectedIndex(0);
		Trailer_weightB.setText(def); 
		Cargo_areaB.setSelectedIndex(0); 
		Cargo_sizeB.setText(def);
		PriceB.setText(def);
	}
	public void print(String s) {
		s = tout.getText() + "\n\n" + s;
		tout.setText(s);
	}
	public static void main(String[] args) {}
}
