package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class BookHotel extends JFrame implements ActionListener{
	
	Choice c1,c2,c3;
	JLabel l3,l6,l10,l12,l14,l16;
	JTextField t1,t2;
	JButton b1,b2,b3;
	
	public BookHotel(String username) {
		
		setLayout(null);
		setBounds(300,200,950,570);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel l1 = new JLabel("BOOK HOTEL");
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
		
		JLabel l4 = new JLabel("Select Hotel");
		l4.setBounds(30,110,150,30);
		l4.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l4);
		
		c1 = new Choice();
		c1.setBounds(240,110,200,30);
		try {
			
			Conn conn = new Conn();
			String query = "Select * from hotel";
			PreparedStatement stmt = conn.c.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				c1.add(rs.getString("name"));
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		add(c1);
		
		JLabel l5 = new JLabel("Total persons");
		l5.setBounds(30,150,150,30);
		l5.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l5);
		
		t1 = new JTextField("1");
		t1.setBounds(240,150,200,30);
		add(t1);
		
		JLabel l6 = new JLabel("No. of Days");
		l6.setBounds(30,190,150,30);
		l6.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l6);
		
		t2 = new JTextField();
		t2.setBounds(240,190,200,30);
		add(t2);
		
		JLabel l7 = new JLabel("AC/Non-AC");
		l7.setBounds(30,230,150,30);
		l7.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l7);

		c2 = new Choice();
		c2.setBounds(240,230,200,30);
		c2.add("Yes");
		c2.add("No");
		add(c2);
		
		JLabel l8 = new JLabel("Food Included");
		l8.setBounds(30,270,150,30);
		l8.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l8);
		
		c3 = new Choice();
		c3.setBounds(240,270,200,30);
		c3.add("Yes");
		c3.add("No");
		add(c3);
		
		JLabel l9 = new JLabel("ID");
		l9.setBounds(30,310,150,30);
		l9.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l9);
		
		l10 = new JLabel();
		l10.setBounds(240,310,200,30);
		l10.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l10);
		
		JLabel l11 = new JLabel("Number");
		l11.setBounds(30,350,150,30);
		l11.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l11);
		
		l12 = new JLabel();
		l12.setBounds(240,350,200,30);
		l12.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l12);
		
		JLabel l13 = new JLabel("Phone");
		l13.setBounds(30,390,150,30);
		l13.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l13);
		
		l14 = new JLabel();
		l14.setBounds(240,390,200,30);
		l14.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l14);
		
		JLabel l15 = new JLabel("Total Price");
		l15.setBounds(30,430,150,30);
		l15.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l15);
		
		l16 = new JLabel();
		l16.setBounds(240,430,200,30);
		l16.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l16);
		
		b1 = new JButton("Check Price");
		b1.setOpaque(true);
		b1.setBackground(Color.BLUE);
		b1.setForeground(Color.WHITE);
		b1.setBounds(50,480,120,30);
		b1.setBorder(BorderFactory.createEmptyBorder());
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Book Hotel");
		b2.setOpaque(true);
		b2.setBackground(Color.BLUE);
		b2.setForeground(Color.WHITE);
		b2.setBounds(190,480,120,30);
		b2.setBorder(BorderFactory.createEmptyBorder());
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setOpaque(true);
		b3.setBackground(Color.BLUE);
		b3.setForeground(Color.WHITE);
		b3.setBounds(330,480,120,30);
		b3.setBorder(BorderFactory.createEmptyBorder());
		b3.addActionListener(this);
		add(b3);
		
		String filepath = "travel/management/system/icons/book.jpg";
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(filepath));
		Image i2 = i1.getImage().getScaledInstance(450, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l17 = new JLabel(i3);
		l17.setBounds(480,50,450,400);
		add(l17);

		try {
			Conn conn = new Conn();
			String query = "Select * from customer where username=?";
			PreparedStatement stmt = conn.c.prepareStatement(query);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				l3.setText(rs.getString("username"));
				l10.setText(rs.getString("id"));
				l12.setText(rs.getString("number"));
				l14.setText(rs.getString("phone"));
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == b1) {
			
			try {
				
				Conn conn = new Conn();
				String query = "Select * from hotel where name=?";
				PreparedStatement stmt = conn.c.prepareStatement(query);	
				stmt.setString(1, c1.getSelectedItem());
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					int cost = Integer.parseInt(rs.getString("cost_per_day"));
					int food = Integer.parseInt(rs.getString("food_charges"));
					int ac = Integer.parseInt(rs.getString("ac_charges"));
					
					int persons = Integer.parseInt(t1.getText());
					int days = Integer.parseInt(t2.getText());
					
					String isAc = c2.getSelectedItem();
					String isFood = c3.getSelectedItem();
					
					if(persons * days > 0) {
						int total = 0;
						total += isAc.equals("Yes") ? ac : 0;
						total += isFood.equals("Yes") ? food : 0;
						total += cost;
						total = total * persons * days;
						l16.setText("" + total);
					}
					else {
						JOptionPane.showMessageDialog(null, "Please enter a valid number");
					}
				}
					
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
				
			
		}
		else if(ae.getSource() == b2) {
			String username = l3.getText();
			String hotel = c1.getSelectedItem();
			String persons = t1.getText();
			String days = t2.getText();
			String ac = c2.getSelectedItem();
			String food = c3.getSelectedItem();
			String id = l10.getText();
			String number = l12.getText();
			String phone = l14.getText();
			String price = l16.getText();
			
			try {
				
				Conn conn = new Conn();
				
				String query = "Insert into bookhotel values(?,?,?,?,?,?,?,?,?,?)";
				
				PreparedStatement stmt = conn.c.prepareStatement(query);
				
				stmt.setString(1,username);
				stmt.setString(2,hotel);
				stmt.setString(3,persons);
				stmt.setString(4,days);
				stmt.setString(5,ac);
				stmt.setString(6,food);
				stmt.setString(7,id);
				stmt.setString(8,number);
				stmt.setString(9,phone);
				stmt.setString(10,price);
				
				stmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
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
		new BookHotel("");

	}

}
