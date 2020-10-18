import com.jgoodies.forms.factories.DefaultComponentFactory;

import jason.environment.grid.GridWorldView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.UIManager.*;

public class StoreTravelInterface 
	extends GridWorldView 
	implements ActionListener {

	// Components of the Form 
	private Container c; 
	private JLabel title; 
	private JLabel From; 
	private JComboBox FromB; 
	private JLabel To; 
	private JComboBox ToB; 
	private JLabel Class; 
	private JComboBox ClassB; 
	private JLabel Price; 
	private JTextField PriceB; 
	
	private JButton sub; 
	private JButton reset; 
	private JTextArea tout; 
	
	private JLabel res; 
	private JTextArea resadd; 

	private JScrollPane scroll;
	
	private String Dests[] = {"All", "Algiers(ALG)", "Doha(QTR)", "Singapore(SIN)", "Dubai(UAE)", "Londo(UK)", "New York(USA)"}; 
	private String Classes[] = {"All", "First_Class", "Business_Class", "Economy_Class"}; 
	private StoreEnv.StoreModel model;
	
	private String q = "";
	/**
	 * Create the application.
	 */
	public StoreTravelInterface(StoreEnv.StoreModel model) {
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
		
		setTitle("Travel agency"); 
		setBounds(300, 90, 900, 643); 
		//setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false); 

		c = getContentPane(); 
		c.setLayout(null); 

		title = new JLabel("Travel agency"); 
		title.setFont(new Font("Segoe UI BOLD", Font.PLAIN, 30)); 
		title.setSize(300, 40); 
		title.setLocation(300, 30); 
		c.add(title); 
		/***************************/
		From = new JLabel("From"); 
		From.setFont(new Font("Arial", Font.PLAIN, 20)); 
		From.setSize(120, 30); 
		From.setLocation(80, 100); 
		c.add(From); 
		
		FromB = new JComboBox(Dests); 
		FromB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		FromB.setSize(150, 30); 
		FromB.setLocation(200, 100); 
		c.add(FromB); 
		/***************************/
		To = new JLabel("To"); 
		To.setFont(new Font("Arial", Font.PLAIN, 20)); 
		To.setSize(120, 30); 
		To.setLocation(80, 150); 
		c.add(To); 
		
		ToB = new JComboBox(Dests); 
		ToB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		ToB.setSize(150, 30); 
		ToB.setLocation(200, 150); 
		c.add(ToB); 
		/***************************/
		Class = new JLabel("Class"); 
		Class.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Class.setSize(120, 30); 
		Class.setLocation(80, 200); 
		c.add(Class); 
		
		ClassB = new JComboBox(Classes); 
		ClassB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		ClassB.setSize(150, 30); 
		ClassB.setLocation(200, 200); 
		c.add(ClassB); 
		/***************************/
		Price = new JLabel("Price"); 
		Price.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Price.setSize(100, 30); 
		Price.setLocation(80, 250); 
		c.add(Price); 
		
		PriceB = new JTextField(); 
		PriceB.setFont(new Font("Arial", Font.PLAIN, 15)); 
		PriceB.setSize(150, 30); 
		PriceB.setLocation(200, 250); 
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
		scroll.setSize(490, 430); 
		scroll.setLocation(375, 100); 
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
		s = s + "\"" + FromB.getSelectedItem() + "\", ";
		s = s + "\"" + ToB.getSelectedItem() + "\", ";
		s = s + "\"" + ClassB.getSelectedItem() + "\", ";
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
			this.model.send_travel(this.q);
		}
		else if (e.getSource() == reset) { 
			this.model.reset_travel(this.q);
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
		FromB.setSelectedIndex(0); 
		ToB.setSelectedIndex(0); 
		ClassB.setSelectedIndex(0); 
		PriceB.setText(def);
	}
	public void print(String s) {
		s = tout.getText() + "\n\n" + s;
		tout.setText(s);
	}
	public static void main(String[] args) {}
}
