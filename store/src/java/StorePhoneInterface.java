import com.jgoodies.forms.factories.DefaultComponentFactory;

import jason.environment.grid.GridWorldView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.UIManager.*;

public class StorePhoneInterface 
	extends GridWorldView 
	implements ActionListener {

	// Components of the Form 
	private Container c; 
	private JLabel title; 
	private JLabel Manufacturer; 
	private JComboBox ManufacturerB;
	private JLabel CPU; 
	private JComboBox CPUB;
	private JLabel RAM; 
	private JTextField RAMB; 
	private JLabel ROM; 
	private JTextField ROMB; 
	private JLabel Battery; 
	private JTextField BatteryB; 
	private JLabel Screen; 
	private JComboBox ScreenB;
	private JLabel Fingerprint; 
	private JComboBox FingerprintB;
	private JLabel Size; 
	private JTextField SizeB; 
	private JLabel Price; 
	private JTextField PriceB; 
	
	private JButton sub; 
	private JButton reset; 
	private JTextArea tout; 
	
	private JLabel res; 
	private JTextArea resadd; 

	private JScrollPane scroll;
	
	private String Manufacturers[] = {"All", "Samsung", "Apple", "LG", "Google", "OnePlus", "Asus", "Xiaomi"}; 
	private String CPUs[] = {"All", "Snapdragon_720G", "Snapdragon_865", "Snapdragon_855", "Snapdragon_845", "Snapdragon_835", "A13_Bionic"}; 
	private String Screens[] = {"All", "Dynamic_AMOLED", "Super_AMOLED", "Super_Retina", "Retina_LCD", "LCD", "P-OLED", "Optic_AMOLED", "Fluid_AMOLED", "AMOLED"}; 
	private String Fingerprints[] = {"All", "Under_display", "Rear_mounted", "Front_mounted", "Side-mounted", "NONE"}; 
	private StoreEnv.StoreModel model;
	
	private String q = "";
	/**
	 * Create the application.
	 */
	public StorePhoneInterface(StoreEnv.StoreModel model) {
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
		
		setTitle("Phone selling agency"); 
		setBounds(300, 90, 900, 643); 
		//setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false); 

		c = getContentPane(); 
		c.setLayout(null); 

		title = new JLabel("Phone selling agency"); 
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
		CPU = new JLabel("CPU"); 
		CPU.setFont(new Font("Arial", Font.PLAIN, 20)); 
		CPU.setSize(100, 30); 
		CPU.setLocation(100, 150); 
		c.add(CPU); 
		
		CPUB = new JComboBox(CPUs); 
		CPUB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		CPUB.setSize(150, 30); 
		CPUB.setLocation(220, 150); 
		c.add(CPUB); 
		/***************************/
		RAM = new JLabel("RAM"); 
		RAM.setFont(new Font("Arial", Font.PLAIN, 20)); 
		RAM.setSize(100, 30); 
		RAM.setLocation(100, 200); 
		c.add(RAM); 
		
		RAMB = new JTextField(); 
		RAMB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		RAMB.setSize(150, 30); 
		RAMB.setLocation(220, 200); 
		c.add(RAMB); 
		/***************************/
		ROM = new JLabel("ROM"); 
		ROM.setFont(new Font("Arial", Font.PLAIN, 20)); 
		ROM.setSize(100, 30); 
		ROM.setLocation(100, 250); 
		c.add(ROM); 
		
		ROMB = new JTextField(); 
		ROMB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		ROMB.setSize(150, 30); 
		ROMB.setLocation(220, 250); 
		c.add(ROMB); 
		/***************************/
		Battery = new JLabel("Battery"); 
		Battery.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Battery.setSize(100, 30); 
		Battery.setLocation(100, 300); 
		c.add(Battery); 
		
		BatteryB = new JTextField(); 
		BatteryB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		BatteryB.setSize(150, 30); 
		BatteryB.setLocation(220, 300); 
		c.add(BatteryB); 
		/***************************/
		Screen = new JLabel("Screen"); 
		Screen.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Screen.setSize(100, 30); 
		Screen.setLocation(100, 350); 
		c.add(Screen); 
		
		ScreenB = new JComboBox(Screens); 
		ScreenB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		ScreenB.setSize(150, 30); 
		ScreenB.setLocation(220, 350); 
		c.add(ScreenB); 
		/***************************/
		Fingerprint = new JLabel("Fingerprint"); 
		Fingerprint.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Fingerprint.setSize(100, 30); 
		Fingerprint.setLocation(100, 400); 
		c.add(Fingerprint); 
		
		FingerprintB = new JComboBox(Fingerprints); 
		FingerprintB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		FingerprintB.setSize(150, 30); 
		FingerprintB.setLocation(220, 400); 
		c.add(FingerprintB); 
		/***************************/
		Size = new JLabel("Size"); 
		Size.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Size.setSize(100, 30); 
		Size.setLocation(100, 450); 
		c.add(Size); 
		
		SizeB = new JTextField(); 
		SizeB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		SizeB.setSize(150, 30); 
		SizeB.setLocation(220, 450); 
		c.add(SizeB); 
		/***************************/
		Price = new JLabel("Price"); 
		Price.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Price.setSize(100, 30); 
		Price.setLocation(100, 500); 
		c.add(Price); 
		
		PriceB = new JTextField(); 
		PriceB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		PriceB.setSize(150, 30); 
		PriceB.setLocation(220, 500); 
		c.add(PriceB); 
		/***************************/

		sub = new JButton("Submit"); 
		sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
		sub.setSize(100, 30); 
		sub.setLocation(150, 550); 
		sub.addActionListener(this); 
		c.add(sub); 

		reset = new JButton("Reset"); 
		reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
		reset.setSize(100, 30); 
		reset.setLocation(270, 550); 
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
		s = s + "\"" +  CPUB.getSelectedItem() + "\", ";
		s = s + RAMB.getText() + ", ";
		s = s + ROMB.getText() + ", ";
		s = s + BatteryB.getText() + ", ";
		s = s + "\"" +  ScreenB.getSelectedItem() + "\", ";
		s = s + "\"" +  FingerprintB.getSelectedItem() + "\", ";
		s = s + SizeB.getText() + ", ";
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
			this.model.send_phone(this.q);
		}
		else if (e.getSource() == reset) { 
			this.model.reset_phone(this.q);
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
		CPUB.setSelectedIndex(0); 
		RAMB.setText(def); 
		ROMB.setText(def);
		BatteryB.setText(def);  
		ScreenB.setSelectedIndex(0); 
		FingerprintB.setSelectedIndex(0);
		SizeB.setText(def);
		PriceB.setText(def);
	}
	public void print(String s) {
		s = tout.getText() + "\n\n" + s;
		tout.setText(s);
	}
	public static void main(String[] args) {}
}
