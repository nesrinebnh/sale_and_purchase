import com.jgoodies.forms.factories.DefaultComponentFactory;

import jason.environment.grid.GridWorldView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.UIManager.*;

public class StoreMotocycleInterface 
	extends GridWorldView 
	implements ActionListener {

	// Components of the Form 
	private Container c; 
	private JLabel title; 
	private JLabel Manufacturer; 
	private JComboBox ManufacturerB;
	private JLabel Weight_class; 
	private JComboBox Weight_classB;
	private JLabel Range; 
	private JTextField RangeB;
	private JLabel Tspeed; 
	private JTextField TspeedB;  
	private JLabel Acc; 
	private JTextField AccB; 
	private JLabel Price; 
	private JTextField PriceB; 
	
	private JButton sub; 
	private JButton reset; 
	private JTextArea tout; 
	
	private JLabel res; 
	private JTextArea resadd; 

	private JScrollPane scroll;
	
	private String Manufacturers[] = {"All", "Piaggio", "YAMAHA", "BMW", "Ducati", "triumph", "arch_motorcycle"}; 
	private String Weight_classes[] = {"All", "light", "mid", "heavy"}; 
	private StoreEnv.StoreModel model;
	
	private String q = "";
	/**
	 * Create the application.
	 */
	public StoreMotocycleInterface(StoreEnv.StoreModel model) {
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
		
		setTitle("Motocycle selling agency"); 
		setBounds(300, 90, 900, 643); 
		//setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false); 

		c = getContentPane(); 
		c.setLayout(null); 

		title = new JLabel("Motocycle selling agency"); 
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
		Weight_class = new JLabel("Weight_class"); 
		Weight_class.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Weight_class.setSize(120, 30); 
		Weight_class.setLocation(100, 150); 
		c.add(Weight_class); 
		
		Weight_classB = new JComboBox(Weight_classes); 
		Weight_classB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		Weight_classB.setSize(150, 30); 
		Weight_classB.setLocation(220, 150); 
		c.add(Weight_classB); 
		/***************************/
		Range = new JLabel("Range"); 
		Range.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Range.setSize(100, 30); 
		Range.setLocation(100, 200); 
		c.add(Range); 
		
		RangeB = new JTextField(); 
		RangeB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		RangeB.setSize(150, 30); 
		RangeB.setLocation(220, 200); 
		c.add(RangeB); 
		/***************************/
		Tspeed = new JLabel("Speed"); 
		Tspeed.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Tspeed.setSize(100, 30); 
		Tspeed.setLocation(100, 250); 
		c.add(Tspeed); 
		
		TspeedB = new JTextField(); 
		TspeedB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		TspeedB.setSize(150, 30); 
		TspeedB.setLocation(220, 250); 
		c.add(TspeedB); 
		/***************************/
		Acc = new JLabel("Acceleration"); 
		Acc.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Acc.setSize(130, 30); 
		Acc.setLocation(100, 300); 
		c.add(Acc); 
		
		AccB = new JTextField(); 
		AccB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		AccB.setSize(150, 30); 
		AccB.setLocation(220, 300); 
		c.add(AccB); 
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
		s = s + "\"" +  Weight_classB.getSelectedItem() + "\", ";
		s = s + RangeB.getText() + ", ";
		s = s + TspeedB.getText() + ", ";
		s = s + AccB.getText() + ", ";
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
			this.model.send_mc(this.q);
		}
		else if (e.getSource() == reset) { 
			this.model.reset_mc(this.q);
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
		Weight_classB.setSelectedIndex(0);
		RangeB.setText(def);
		TspeedB.setText(def);
		AccB.setText(def);
		PriceB.setText(def);
	}
	public void print(String s) {
		s = tout.getText() + "\n\n" + s;
		tout.setText(s);
	}
	public static void main(String[] args) {}
}
