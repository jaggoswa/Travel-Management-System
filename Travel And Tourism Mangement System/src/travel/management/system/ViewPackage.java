package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class ViewPackage extends JFrame implements ActionListener{
	
	JButton b1;
	JLabel l3,l5,l7,l9,l11,l13,l15;
	
	public ViewPackage(String username) {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setBounds(400,200,800,450);
		
		JLabel l1 = new JLabel("VIEW PACKAGE DETAILS");
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
		
		JLabel l4 = new JLabel("Package:");
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
		
		JLabel l8 = new JLabel("ID:");
		l8.setBounds(30,180,150,30);
		l8.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l8);
		
		l9 = new JLabel();
		l9.setBounds(220,180,200,30);
		l9.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l9);
		
		JLabel l10 = new JLabel("Number:");
		l10.setBounds(30,220,150,30);
		l10.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l10);
		
		l11 = new JLabel();
		l11.setBounds(220,220,200,30);
		l11.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l11);
		
		JLabel l12 = new JLabel("Phone:");
		l12.setBounds(30,260,150,30);
		l12.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l12);
		
		l13 = new JLabel();
		l13.setBounds(220,260,200,30);
		l13.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l13);
		
		JLabel l14 = new JLabel("Price:");
		l14.setBounds(30,300,150,30);
		l14.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l14);
		
		l15 = new JLabel();
		l15.setBounds(220,300,200,30);
		l15.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l15);
		
		b1 = new JButton("Back");
		b1.setOpaque(true);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(100,360,120,30);
		b1.setBorder(BorderFactory.createEmptyBorder());
		b1.addActionListener(this);
		add(b1);
		
		String filepath = "travel/management/system/icons/bookedDetails.jpg";
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(filepath));
		Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l16 = new JLabel(i3);
		l16.setBounds(350,50,400,300);
		add(l16);

		
		try {
			
			Conn conn = new Conn();
			String query = "Select * from bookpackage where username=?";
			PreparedStatement stmt = conn.c.prepareStatement(query);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				l3.setText(rs.getString("username"));
				l5.setText(rs.getString("package"));
				l7.setText(rs.getString("persons"));
				l9.setText(rs.getString("id"));
				l11.setText(rs.getString("number"));
				l13.setText(rs.getString("phone"));
				l15.setText(rs.getString("price"));
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
		new ViewPackage("");

	}

}
