package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class ViewBookedHotel extends JFrame implements ActionListener{
	
	JButton b1;
	JLabel l3,l5,l7,l9,l11,l13,l15,l17,l19,l21;
	
	public ViewBookedHotel(String username) {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setBounds(400,200,850,550);
		
		JLabel l1 = new JLabel("VIEW BOOKED HOTEL DETAILS");
		l1.setBounds(50,20,300,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(l1);
		
		JLabel l2 = new JLabel("Username:");
		l2.setBounds(30,60,150,30);
		l2.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l2);
		
		l3 = new JLabel();
		l3.setBounds(220,60,200,30);
		l3.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l3);
		
		JLabel l4 = new JLabel("Hotel Name:");
		l4.setBounds(30,100,150,30);
		l4.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l4);
		
		l5 = new JLabel();
		l5.setBounds(220,100,200,30);
		l5.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l5);
		
		JLabel l6 = new JLabel("Total Persons:");
		l6.setBounds(30,140,150,30);
		l6.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l6);
		
		l7 = new JLabel();
		l7.setBounds(220,140,200,30);
		l7.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l7);
		
		JLabel l8 = new JLabel("Total Days:");
		l8.setBounds(30,180,150,30);
		l8.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l8);
		
		l9 = new JLabel();
		l9.setBounds(220,180,200,30);
		l9.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l9);
		
		JLabel l10 = new JLabel("AC Included?:");
		l10.setBounds(30,220,150,30);
		l10.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l10);
		
		l11 = new JLabel();
		l11.setBounds(220,220,200,30);
		l11.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l11);
		
		JLabel l12 = new JLabel("Food Included?:");
		l12.setBounds(30,260,150,30);
		l12.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l12);
		
		l13 = new JLabel();
		l13.setBounds(220,260,200,30);
		l13.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l13);
		
		JLabel l14 = new JLabel("ID:");
		l14.setBounds(30,300,150,30);
		l14.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l14);
		
		l15 = new JLabel();
		l15.setBounds(220,300,200,30);
		l15.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l15);
		
		JLabel l16 = new JLabel("Number:");
		l16.setBounds(30,340,150,30);
		l16.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l16);
		
		l17 = new JLabel();
		l17.setBounds(220,340,200,30);
		l17.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l17);
		
		JLabel l18 = new JLabel("Phone:");
		l18.setBounds(30,370,150,30);
		l18.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l18);
		
		l19 = new JLabel();
		l19.setBounds(220,370,200,30);
		l19.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l19);
		
		JLabel l20 = new JLabel("Total Price:");
		l20.setBounds(30,410,150,30);
		l20.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l20);
		
		l21 = new JLabel();
		l21.setBounds(220,410,200,30);
		l21.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l21);
		
		b1 = new JButton("Back");
		b1.setOpaque(true);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(100,460,120,30);
		b1.setBorder(BorderFactory.createEmptyBorder());
		b1.addActionListener(this);
		add(b1);
		
		String filepath = "travel/management/system/icons/bookedDetails.jpg";
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(filepath));
		Image i2 = i1.getImage().getScaledInstance(450, 350, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l22 = new JLabel(i3);
		l22.setBounds(370,70,450,350);
		add(l22);

		
		try {
			
			Conn conn = new Conn();
			String query = "Select * from bookhotel where username=?";
			PreparedStatement stmt = conn.c.prepareStatement(query);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				l3.setText(rs.getString("username"));
				l5.setText(rs.getString("hotel"));
				l7.setText(rs.getString("persons"));
				l9.setText(rs.getString("days"));
				l11.setText(rs.getString("ac"));
				l13.setText(rs.getString("food"));
				l15.setText(rs.getString("id"));
				l17.setText(rs.getString("number"));
				l19.setText(rs.getString("phone"));
				l21.setText(rs.getString("price"));
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == b1)
			this.setVisible(false);
		
	}

	public static void main(String[] args) {
		new ViewBookedHotel("jaggoswa");

	}

}
