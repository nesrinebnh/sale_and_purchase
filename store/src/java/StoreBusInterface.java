
	import com.jgoodies.forms.factories.DefaultComponentFactory;

	import jason.environment.grid.GridWorldView;

	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.Arrays;

	import javax.swing.*;
	import javax.swing.UIManager.*;

	public class StoreBusInterface 
		extends GridWorldView 
		implements ActionListener {

		// Components of the Form 
		private Container c; 
		private JLabel title; 
		private JLabel Manufacturer; 
		private JComboBox ManufacturerB;
		private JLabel Bus_Type; 
		private JComboBox Bus_TypeB;
		private JLabel Size; 
		private JComboBox SizeB;
		private JLabel Price; 
		private JTextField PriceB; 
		
		private JButton sub; 
		private JButton reset; 
		private JTextArea tout; 
		
		private JLabel res; 
		private JTextArea resadd; 

		private JScrollPane scroll;
		
		private String Manufacturers[] = {"All", "MCV", "Volvo", "TransBus", "VDL_Berkhof", "Goppel"}; 
		private String Bus_Types[] = {"All", "double_deck", "single_deck"}; 
		private String Sizes[] = {"All", "sm", "md", "lg"}; 
		private StoreEnv.StoreModel model;
		
		private String q = "";
		/**
		 * Create the application.
		 */
		public StoreBusInterface(StoreEnv.StoreModel model) {
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
			
			setTitle("Buses selling agency"); 
			setBounds(300, 90, 900, 643); 
			//setDefaultCloseOperation(EXIT_ON_CLOSE); 
			setResizable(false); 

			c = getContentPane(); 
			c.setLayout(null); 

			title = new JLabel("Buses selling agency"); 
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
			Bus_Type = new JLabel("Bus_Type"); 
			Bus_Type.setFont(new Font("Arial", Font.PLAIN, 20)); 
			Bus_Type.setSize(120, 30); 
			Bus_Type.setLocation(100, 150); 
			c.add(Bus_Type); 
			
			Bus_TypeB = new JComboBox(Bus_Types); 
			Bus_TypeB.setFont(new Font("Arial", Font.PLAIN, 15)); 
			Bus_TypeB.setSize(150, 30); 
			Bus_TypeB.setLocation(220, 150); 
			c.add(Bus_TypeB); 
			/***************************/
			Size = new JLabel("Size"); 
			Size.setFont(new Font("Arial", Font.PLAIN, 20)); 
			Size.setSize(100, 30); 
			Size.setLocation(100, 200); 
			c.add(Size); 
			
			SizeB = new JComboBox(Sizes); 
			SizeB.setFont(new Font("Arial", Font.PLAIN, 15)); 
			SizeB.setSize(150, 30); 
			SizeB.setLocation(220, 200); 
			c.add(SizeB); 
			/***************************/
			Price = new JLabel("Price"); 
			Price.setFont(new Font("Arial", Font.PLAIN, 20)); 
			Price.setSize(100, 30); 
			Price.setLocation(100, 250); 
			c.add(Price); 
			
			PriceB = new JTextField(); 
			PriceB.setFont(new Font("Arial", Font.PLAIN, 15)); 
			PriceB.setSize(150, 30); 
			PriceB.setLocation(220, 250); 
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
			s = s + "\"" +  Bus_TypeB.getSelectedItem() + "\", ";
			s = s + "\"" + SizeB.getSelectedItem() + "\", ";
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
				this.model.send_bus(this.q);
			}
			else if (e.getSource() == reset) { 
				this.model.reset_bus(this.q);
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
			Bus_TypeB.setSelectedIndex(0); 
			SizeB.setSelectedIndex(0);
			PriceB.setText(def);
		}
		public void print(String s) {
			s = tout.getText() + "\n\n" + s;
			tout.setText(s);
		}
		public static void main(String[] args) {}
	}
