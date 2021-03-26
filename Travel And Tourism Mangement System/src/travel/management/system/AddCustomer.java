package travel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener{
	
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JComboBox c1;
	JRadioButton r1,r2;
	JButton b1,b2;
	
	public AddCustomer(String username){
		setLayout(null);
		setBounds(400,150,750,520);
		getContentPane().setBackground(Color.WHITE);
		setUndecorated(true);
		
		JLabel l1 = new JLabel("Username");
		l1.setBounds(30,50,100,25);
		add(l1);
		
		t1 = new JTextField();
		t1.setBounds(170,50,150,30);
		add(t1);
		
		JLabel l2 = new JLabel("ID");
		l2.setBounds(30,90,100,25);
		add(l2);
		
		c1 = new JComboBox(new String[]{"Passport","Adhaar Card","Pan Card","Ration Card"});
		c1.setBounds(170,90,150,30);
		add(c1);
		
		JLabel l3 = new JLabel("Number");
		l3.setBounds(30,130,100,25);
		add(l3);
		
		t2 = new JTextField();
		t2.setBounds(170,130,150,30);
		add(t2);
		
		JLabel l4 = new JLabel("Name");
		l4.setBounds(30,170,100,25);
		add(l4);
		
		t3 = new JTextField();
		t3.setBounds(170,170,150,30);
		add(t3);
		
		JLabel l5 = new JLabel("Gender");
		l5.setBounds(30,210,100,25);
		add(l5);
		
		r1 = new JRadioButton("Male");
		r1.setBounds(170,210,70,25);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setBounds(240,210,90,25);
		add(r2);
		
		JLabel l6 = new JLabel("Country");
		l6.setBounds(30,250,100,25);
		add(l6);
		
		t4 = new JTextField();
		t4.setBounds(170,250,150,30);
		add(t4);
		
		JLabel l7 = new JLabel("Address");
		l7.setBounds(30,290,100,25);
		add(l7);
		
		t5 = new JTextField();
		t5.setBounds(170,290,150,30);
		add(t5);
		
		JLabel l8 = new JLabel("Phone");
		l8.setBounds(30,330,100,25);
		add(l8);
		
		t6 = new JTextField();
		t6.setBounds(170,330,150,30);
		add(t6);
		
		JLabel l9 = new JLabel("Email");
		l9.setBounds(30,370,100,25);
		add(l9);
		
		t7 = new JTextField();
		t7.setBounds(170,370,150,30);
		add(t7);
		
		b1 = new JButton("Add");
		b1.setBounds(70,430,100,30);
		b1.setOpaque(true);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBorder(BorderFactory.createEmptyBorder());
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(200,430,100,30);
		b2.setOpaque(true);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBorder(BorderFactory.createEmptyBorder());
		b2.addActionListener(this);
		add(b2);
		
		String filepath = "travel/management/system/icons/newCustomer.jpg";
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(filepath));
		Image i2 = i1.getImage().getScaledInstance(400, 550, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l10 = new JLabel(i3);
		l10.setBounds(350,10,400,550);
		add(l10);
		
		try {
			Conn conn = new Conn();
			String query = "Select * from customer where username = ?";
			PreparedStatement stmt = conn.c.prepareStatement(query);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				t1.setText(rs.getString("username"));
				t2.setText(rs.getString("name"));
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String username = t1.getText();
		String id = (String) c1.getSelectedItem();
		String number = t2.getText();
		String name = t3.getText();
		String gender = null;
		
		if(r1.isSelected())
			gender = "Male";
		else if(r2.isSelected())
			gender = "Female";
		
		String country = t4.getText();
		String address = t5.getText();
		String phone = t6.getText();
		String email = t7.getText();
		
		if(ae.getSource() == b1) {
			Conn conn = new Conn();
			String query = "Insert into customer values (?,?,?,?,?,?,?,?,?)";
			
			try {
				
				PreparedStatement stmt = conn.c.prepareStatement(query);
				stmt.setString(1, username);
				stmt.setString(2, id);
				stmt.setString(3, number);
				stmt.setString(4, name);
				stmt.setString(5, gender);
				stmt.setString(6, country);
				stmt.setString(7, address);
				stmt.setString(8, phone);
				stmt.setString(9, email);
				
				stmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Customer Details added successfully");
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			
		}
		else if(ae.getSource() == b2){
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new AddCustomer("");

	}

}
