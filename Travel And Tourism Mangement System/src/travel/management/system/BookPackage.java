package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class BookPackage extends JFrame implements ActionListener{
	
	Choice c1;
	JLabel l3,l4,l7,l9,l11,l13;
	JTextField t1;
	JButton b1,b2,b3;
	
	public BookPackage(String username) {
		
		setLayout(null);
		setBounds(300,200,950,450);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel l1 = new JLabel("BOOK PACKAGE");
		l1.setBounds(100,20,200,30);
		l1.setFont(new Font("Yu Mincho",Font.PLAIN,18));
		add(l1);
		
		JLabel l2 = new JLabel("Username");
		l2.setBounds(30,70,150,30);
		l2.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l2);
		
		l3 = new JLabel();
		l3.setBounds(240,70,200,30);
		l3.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l3);
		
		l4 = new JLabel("Select Package");
		l4.setBounds(30,110,150,30);
		l4.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l4);
		
		c1 = new Choice();
		c1.setBounds(240,110,200,30);
		c1.add("Gold Package");
		c1.add("Silver Package");
		c1.add("Bronze Package");
		add(c1);
		
		JLabel l5 = new JLabel("Total persons");
		l5.setBounds(30,150,150,30);
		l5.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l5);
		
		t1 = new JTextField("1");
		t1.setBounds(240,150,200,30);
		add(t1);
		
		JLabel l6 = new JLabel("ID");
		l6.setBounds(30,190,150,30);
		l6.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l6);
		
		l7 = new JLabel();
		l7.setBounds(240,190,200,30);
		l7.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l7);
		
		JLabel l8 = new JLabel("Number");
		l8.setBounds(30,230,150,30);
		l8.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l8);
		
		l9 = new JLabel();
		l9.setBounds(240,230,200,30);
		l9.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l9);
		
		JLabel l10 = new JLabel("Phone");
		l10.setBounds(30,270,150,30);
		l10.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l10);
		
		l11 = new JLabel();
		l11.setBounds(240,270,200,30);
		l11.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l11);
		
		JLabel l12 = new JLabel("Total Price");
		l12.setBounds(30,310,150,30);
		l12.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l12);
		
		l13 = new JLabel();
		l13.setBounds(240,310,200,30);
		l13.setFont(new Font("Tahoma",Font.PLAIN,14));
		l13.setForeground(Color.RED);
		add(l13);
		
		b1 = new JButton("Check Price");
		b1.setOpaque(true);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(50,360,120,30);
		b1.setBorder(BorderFactory.createEmptyBorder());
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Book Package");
		b2.setOpaque(true);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(190,360,120,30);
		b2.setBorder(BorderFactory.createEmptyBorder());
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setOpaque(true);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(330,360,120,30);
		b3.setBorder(BorderFactory.createEmptyBorder());
		b3.addActionListener(this);
		add(b3);
		
		String filepath = "travel/management/system/icons/bookpackage.jpg";
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(filepath));
		Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l14 = new JLabel(i3);
		l14.setBounds(500,20,400,300);
		add(l14);

		try {
			Conn conn = new Conn();
			String query = "Select * from customer where username=?";
			PreparedStatement stmt = conn.c.prepareStatement(query);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				l3.setText(rs.getString("username"));
				l7.setText(rs.getString("id"));
				l9.setText(rs.getString("number"));
				l11.setText(rs.getString("phone"));
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == b1) {
			
			String p = c1.getSelectedItem();
			int cost = 0;
			
			if(p.equals("Gold Package"))
				cost+=12000;
			else if(p.equals("Silver Package"))
				cost+=24000;
			else if(p.equals("Bronze Package"))
				cost+=32000;
			
			int persons = Integer.parseInt(t1.getText());
			cost *= persons;
			
			l13.setText("Rs " + cost);
				
			
		}
		else if(ae.getSource() == b2) {
			String username = l3.getText();
			String pack = c1.getSelectedItem();
			String persons = t1.getText();
			String id = l7.getText();
			String number = l9.getText();
			String phone = l11.getText();
			String price = l13.getText();
			
			try {
				
				Conn conn = new Conn();
				
				String query = "Insert into bookpackage values(?,?,?,?,?,?,?)";
				
				PreparedStatement stmt = conn.c.prepareStatement(query);
				
				stmt.setString(1,username);
				stmt.setString(2,pack);
				stmt.setString(3,persons);
				stmt.setString(4,id);
				stmt.setString(5,number);
				stmt.setString(6,phone);
				stmt.setString(7,price);
				
				stmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Package Booked Successfully");
				this.setVisible(false);
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		else if(ae.getSource() == b3) {
			this.setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		new BookPackage("");

	}

}
