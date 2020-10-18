import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StoreInterface extends JFrame implements ActionListener { 
	
	// Components of the Form 
	private Container c; 
	private JLabel title; 
	private JLabel Wheels; 
	private JTextField tname; 
	private ButtonGroup gengp; 
	private JButton sub; 
	private JButton reset; 
	private JTextArea tout; 
	private JTextArea resadd; 
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JLabel name_1_1_1_1_2;
	private JLabel name_1_2_1_2;
	private JLabel name_2_1_2;
	private JLabel name_1_1_1_2;
	private JLabel name_1_2_2;
	private JLabel name_1_1_1_1_3;
	private JLabel name_1_2_1_3;
	private JLabel name_2_1_3;
	private JLabel name_1_1_1_3;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JComboBox year_1_1_1_2;
	private JComboBox year_1_1_1_3;
	private JComboBox year_1_1_2;
	private JComboBox year_1_1_3;
	private JComboBox year_1_2;
	private JComboBox year_2;
	private JComboBox year;

	// constructor, to initialize the components 
	// with default values. 
	public StoreInterface() 
	{ 
		setTitle("Registration Form"); 
		setBounds(300, 90, 965, 850); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false); 

		c = getContentPane(); 
		c.setLayout(null); 

		title = new JLabel("Select the vehicle features"); 
		title.setFont(new Font("Arial", Font.PLAIN, 30)); 
		title.setSize(356, 30); 
		title.setLocation(320, 13); 
		c.add(title); 

		Wheels = new JLabel("Wheels"); 
		Wheels.setFont(new Font("Arial", Font.PLAIN, 20)); 
		Wheels.setSize(66, 20); 
		Wheels.setLocation(184, 56); 
		c.add(Wheels); 

		tname = new JTextField(); 
		tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tname.setSize(190, 20); 
		tname.setLocation(274, 56); 
		c.add(tname);

		gengp = new ButtonGroup();

		sub = new JButton("Submit"); 
		sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
		sub.setSize(100, 20); 
		sub.setLocation(252, 782); 
		sub.addActionListener(this); 
		c.add(sub); 

		reset = new JButton("Reset"); 
		reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
		reset.setSize(100, 20); 
		reset.setLocation(364, 782); 
		reset.addActionListener(this); 
		c.add(reset); 

		tout = new JTextArea(); 
		tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tout.setSize(413, 691); 
		tout.setLocation(487, 56); 
		tout.setLineWrap(true); 
		tout.setEditable(false); 
		c.add(tout);

		resadd = new JTextArea(); 
		resadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
		resadd.setSize(200, 75); 
		resadd.setLocation(580, 175); 
		resadd.setLineWrap(true); 
		c.add(resadd); 
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(274, 89, 190, 20);
		getContentPane().add(textField);
		
		JLabel name_1 = new JLabel("Passengers");
		name_1.setFont(new Font("Arial", Font.PLAIN, 20));
		name_1.setBounds(146, 87, 104, 20);
		getContentPane().add(name_1);
		
		JLabel name_1_1 = new JLabel("Body frame");
		name_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		name_1_1.setBounds(146, 122, 104, 20);
		getContentPane().add(name_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_1.setBounds(274, 157, 190, 20);
		getContentPane().add(textField_1);
		
		JLabel name_2 = new JLabel("Doors");
		name_2.setFont(new Font("Arial", Font.PLAIN, 20));
		name_2.setBounds(197, 155, 53, 22);
		getContentPane().add(name_2);
		
		JLabel name_1_2 = new JLabel("Fuel");
		name_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		name_1_2.setBounds(213, 190, 37, 20);
		getContentPane().add(name_1_2);
		
		JComboBox year_1 = new JComboBox(new Object[]{});
		year_1.setFont(new Font("Arial", Font.PLAIN, 15));
		year_1.setBounds(274, 225, 190, 20);
		getContentPane().add(year_1);
		
		JLabel name_1_1_1 = new JLabel("Category");
		name_1_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		name_1_1_1.setBounds(169, 223, 81, 20);
		getContentPane().add(name_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_3.setBounds(274, 258, 190, 20);
		getContentPane().add(textField_3);
		
		JLabel name_2_1 = new JLabel("Hp");
		name_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		name_2_1.setBounds(226, 256, 24, 20);
		getContentPane().add(name_2_1);
		
		JLabel name_1_2_1 = new JLabel("Transmission");
		name_1_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		name_1_2_1.setBounds(134, 289, 116, 20);
		getContentPane().add(name_1_2_1);
		
		JComboBox year_1_1 = new JComboBox(new Object[]{});
		year_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		year_1_1.setBounds(274, 326, 190, 20);
		getContentPane().add(year_1_1);
		
		JLabel name_1_1_1_1 = new JLabel("Manufacturer");
		name_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		name_1_1_1_1.setBounds(134, 324, 116, 20);
		getContentPane().add(name_1_1_1_1);
		
		JLabel name_2_1_1 = new JLabel("Style");
		name_2_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		name_2_1_1.setBounds(206, 357, 44, 20);
		getContentPane().add(name_2_1_1);
		
		JLabel name_1_2_1_1 = new JLabel("Size");
		name_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		name_1_2_1_1.setBounds(213, 390, 37, 20);
		getContentPane().add(name_1_2_1_1);
		
		JComboBox year_1_1_1 = new JComboBox(new Object[]{});
		year_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		year_1_1_1.setBounds(274, 427, 190, 20);
		getContentPane().add(year_1_1_1);
		
		JLabel name_1_1_1_1_1 = new JLabel("Bus type");
		name_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		name_1_1_1_1_1.setBounds(169, 425, 81, 20);
		getContentPane().add(name_1_1_1_1_1);
		
		name_1_1_1_1_2 = new JLabel("Weight_class");
		name_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		name_1_1_1_1_2.setBounds(126, 594, 124, 20);
		getContentPane().add(name_1_1_1_1_2);
		
		name_1_2_1_2 = new JLabel("Cargo_size");
		name_1_2_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		name_1_2_1_2.setBounds(150, 561, 100, 20);
		getContentPane().add(name_1_2_1_2);
		
		name_2_1_2 = new JLabel("Trailer_weight");
		name_2_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		name_2_1_2.setBounds(126, 526, 124, 20);
		getContentPane().add(name_2_1_2);
		
		name_1_1_1_2 = new JLabel("Cargo_size_area");
		name_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		name_1_1_1_2.setBounds(93, 493, 157, 20);
		getContentPane().add(name_1_1_1_2);
		
		name_1_2_2 = new JLabel("Trailer");
		name_1_2_2.setFont(new Font("Arial", Font.PLAIN, 20));
		name_1_2_2.setBounds(194, 460, 56, 20);
		getContentPane().add(name_1_2_2);
		
		name_1_1_1_1_3 = new JLabel("Max price");
		name_1_1_1_1_3.setFont(new Font("Arial", Font.PLAIN, 20));
		name_1_1_1_1_3.setBounds(157, 727, 93, 20);
		getContentPane().add(name_1_1_1_1_3);
		
		name_1_2_1_3 = new JLabel("Acc");
		name_1_2_1_3.setFont(new Font("Arial", Font.PLAIN, 20));
		name_1_2_1_3.setBounds(213, 693, 37, 20);
		getContentPane().add(name_1_2_1_3);
		
		name_2_1_3 = new JLabel("Tspeed");
		name_2_1_3.setFont(new Font("Arial", Font.PLAIN, 20));
		name_2_1_3.setBounds(184, 660, 66, 20);
		getContentPane().add(name_2_1_3);
		
		name_1_1_1_3 = new JLabel("Range");
		name_1_1_1_3.setFont(new Font("Arial", Font.PLAIN, 20));
		name_1_1_1_3.setBounds(184, 627, 66, 20);
		getContentPane().add(name_1_1_1_3);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_7.setBounds(274, 728, 190, 20);
		getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_8.setBounds(274, 694, 190, 20);
		getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_9.setBounds(274, 661, 190, 20);
		getContentPane().add(textField_9);
		
		JComboBox year_1_1_1_1 = new JComboBox(new Object[]{});
		year_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		year_1_1_1_1.setBounds(274, 495, 190, 20);
		getContentPane().add(year_1_1_1_1);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_10.setBounds(274, 528, 190, 20);
		getContentPane().add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_11.setBounds(274, 562, 190, 20);
		getContentPane().add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_12.setBounds(274, 628, 190, 20);
		getContentPane().add(textField_12);
		
		year_1_1_1_2 = new JComboBox(new Object[]{});
		year_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		year_1_1_1_2.setBounds(274, 595, 190, 20);
		getContentPane().add(year_1_1_1_2);
		
		year_1_1_1_3 = new JComboBox(new Object[]{});
		year_1_1_1_3.setFont(new Font("Arial", Font.PLAIN, 15));
		year_1_1_1_3.setBounds(274, 461, 190, 20);
		getContentPane().add(year_1_1_1_3);
		
		year_1_1_2 = new JComboBox(new Object[]{});
		year_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		year_1_1_2.setBounds(274, 391, 190, 20);
		getContentPane().add(year_1_1_2);
		
		year_1_1_3 = new JComboBox(new Object[]{});
		year_1_1_3.setFont(new Font("Arial", Font.PLAIN, 15));
		year_1_1_3.setBounds(274, 359, 190, 20);
		getContentPane().add(year_1_1_3);
		
		year_1_2 = new JComboBox(new Object[]{});
		year_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		year_1_2.setBounds(274, 291, 190, 20);
		getContentPane().add(year_1_2);
		
		year_2 = new JComboBox(new Object[]{});
		year_2.setFont(new Font("Arial", Font.PLAIN, 15));
		year_2.setBounds(274, 190, 190, 20);
		getContentPane().add(year_2);
		
		year = new JComboBox(new Object[]{});
		year.setFont(new Font("Arial", Font.PLAIN, 15));
		year.setBounds(274, 122, 190, 20);
		getContentPane().add(year);

		setVisible(true); 
	} 

	// method actionPerformed() 
	// to get the action performed 
	// by the user and act accordingly 
	public void actionPerformed(ActionEvent e) 
	{ /*
		if (e.getSource() == sub) { 
			if (term.isSelected()) { 
				String data1; 
				String data 
					= "Name : "
					+ tname.getText() + "\n"
					+ "Mobile : "
					+ tmno.getText() + "\n"; 
				if (male.isSelected()) 
					data1 = "Gender : Male"
							+ "\n"; 
				else
					data1 = "Gender : Female"
							+ "\n"; 
				String data2 
					= "DOB : "
					+ (String)date.getSelectedItem() 
					+ "/" + (String)month.getSelectedItem() 
					+ "/" + (String)year.getSelectedItem() 
					+ "\n"; 

				String data3 = "Address : " + tadd.getText(); 
				tout.setText(data + data1 + data2 + data3); 
				tout.setEditable(false); 
				res.setText("Registration Successfully.."); 
			} 
			else { 
				tout.setText(""); 
				resadd.setText(""); 
				res.setText("Please accept the"
							+ " terms & conditions.."); 
			} 
		} 

		else if (e.getSource() == reset) { 
			String def = ""; 
			tname.setText(def); 
			tadd.setText(def); 
			tmno.setText(def); 
			res.setText(def); 
			tout.setText(def); 
			term.setSelected(false); 
			date.setSelectedIndex(0); 
			month.setSelectedIndex(0); 
			year.setSelectedIndex(0); 
			resadd.setText(def); 
		} */
	} 
} 