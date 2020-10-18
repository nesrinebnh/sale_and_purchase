import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import jason.environment.grid.GridWorldView;

import javax.swing.JButton;

public class MainFrame extends GridWorldView implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Container c; 
	private JLabel title; 
	private JLabel text; 
	
	private JButton phonesF; 
	private JButton carsF; 
	private JButton busesF; 
	private JButton trucksF; 
	private JButton mcF; 
	private JButton reF; 
	private JButton travelF; 
	
	private StoreEnv.StoreModel model;
	public GridWorldView frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the frame.
	 */
	public MainFrame(StoreEnv.StoreModel model) {
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
		
		setTitle("VexAgency"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 560);
		setResizable(false); 

		c = getContentPane(); 
		c.setLayout(null); 

		title = new JLabel("VexAgency"); 
		title.setFont(new Font("Segoe UI BOLD", Font.PLAIN, 30)); 
		title.setSize(170, 40); 
		title.setLocation(140, 10); 
		c.add(title); 
		
		text = new JLabel("Please choose a category."); 
		text.setFont(new Font("Segoe UI", Font.PLAIN, 22)); 
		text.setSize(250, 37); 
		text.setLocation(90, 65); 
		c.add(text); 
		
		phonesF = new JButton("Phones selling point"); 
		phonesF.setFont(new Font("Segoe UI", Font.PLAIN, 17)); 
		phonesF.setSize(230, 50); 
		phonesF.setLocation(110, 142); 
		phonesF.addActionListener(this); 
		c.add(phonesF); 
		
		carsF = new JButton("Cars selling point"); 
		carsF.setFont(new Font("Segoe UI", Font.PLAIN, 17)); 
		carsF.setSize(230, 50); 
		carsF.setLocation(110, 202); 
		carsF.addActionListener(this); 
		c.add(carsF);  
		
		trucksF = new JButton("Trucks selling point"); 
		trucksF.setFont(new Font("Segoe UI", Font.PLAIN, 17)); 
		trucksF.setSize(230, 50); 
		trucksF.setLocation(110, 262); 
		trucksF.addActionListener(this); 
		c.add(trucksF); 
		
		busesF = new JButton("Buses selling point"); 
		busesF.setFont(new Font("Segoe UI", Font.PLAIN, 17)); 
		busesF.setSize(230, 50); 
		busesF.setLocation(110, 322); 
		busesF.addActionListener(this); 
		c.add(busesF); 
		
		mcF = new JButton("Motorcycles selling point"); 
		mcF.setFont(new Font("Segoe UI", Font.PLAIN, 17)); 
		mcF.setSize(230, 50); 
		mcF.setLocation(110, 382); 
		mcF.addActionListener(this); 
		c.add(mcF);
		
		travelF = new JButton("Travel agency"); 
		travelF.setFont(new Font("Segoe UI", Font.PLAIN, 17)); 
		travelF.setSize(230, 50); 
		travelF.setLocation(110, 442); 
		travelF.addActionListener(this); 
		c.add(travelF); 
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(this.frame != null) {
			this.frame.setVisible(false);
		}  
		if (e.getSource() == phonesF) {
			this.frame = new StorePhoneInterface(this.model);
		} else if (e.getSource() == carsF) {
			this.frame = new StoreCarInterface(this.model);
		} else if (e.getSource() == busesF) {
			this.frame = new StoreBusInterface(this.model);
		} else if (e.getSource() == mcF) {
			this.frame = new StoreMotocycleInterface(this.model);
		} else if (e.getSource() == travelF) {
			this.frame = new StoreTravelInterface(this.model);
		} else if (e.getSource() == trucksF) {
			this.frame = new StoreTruckInterface(this.model);
		}
		
		
	}
	public void print(String s) {
		if(this.frame instanceof StorePhoneInterface) {
			StorePhoneInterface v = (StorePhoneInterface) this.frame;
			v.print(s);
		} else if(this.frame instanceof StoreCarInterface) {
			StoreCarInterface v = (StoreCarInterface) this.frame;
			v.print(s);
		} else if(this.frame instanceof StoreBusInterface) {
			StoreBusInterface v = (StoreBusInterface) this.frame;
			v.print(s);
		} else if(this.frame instanceof StoreMotocycleInterface) {
			StoreMotocycleInterface v = (StoreMotocycleInterface) this.frame;
			v.print(s);
		} else if(this.frame instanceof StoreTravelInterface) {
			StoreTravelInterface v = (StoreTravelInterface) this.frame;
			v.print(s);
		} else if(this.frame instanceof StoreTruckInterface) {
			StoreTruckInterface v = (StoreTruckInterface) this.frame;
			v.print(s);
		}
		

	}

}
