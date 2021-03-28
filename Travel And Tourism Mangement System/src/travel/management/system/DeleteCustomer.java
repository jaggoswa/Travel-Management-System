package travel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class DeleteCustomer extends JFrame implements ActionListener{
	
	JButton b1,b2;
	String username;
	
	public DeleteCustomer(String user) {
		
		username = user;
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setBounds(450,200,800,550);
		
		JLabel l1 = new JLabel("DELETE CUSTOMER DETAILS");
		l1.setBounds(50,20,400,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(l1);
		
		JLabel l2 = new JLabel("Username:");
		l2.setBounds(30,90,200,30);
		add(l2);
		
		JLabel l3 = new JLabel();
		l3.setBounds(240,90,200,30);
		add(l3);
		
		JLabel l4 = new JLabel("ID:");
		l4.setBounds(30,130,200,30);
		add(l4);
		
		JLabel l5 = new JLabel();
		l5.setBounds(240,130,200,30);
		add(l5);
		
		JLabel l6 = new JLabel("Number:");
		l6.setBounds(30,170,200,30);
		add(l6);
		
		JLabel l7 = new JLabel();
		l7.setBounds(240,170,200,30);
		add(l7);
		
		JLabel l8 = new JLabel("Name:");
		l8.setBounds(30,210,200,30);
		add(l8);
		
		JLabel l9 = new JLabel();
		l9.setBounds(240,210,200,30);
		add(l9);
		
		JLabel l10 = new JLabel("Gender:");
		l10.setBounds(30,250,200,30);
		add(l10);
		
		JLabel l11 = new JLabel();
		l11.setBounds(240,250,200,30);
		add(l11);
		
		JLabel l12 = new JLabel("Country:");
		l12.setBounds(30,290,200,30);
		add(l12);
		
		JLabel l13 = new JLabel();
		l13.setBounds(240,290,200,30);
		add(l13);
		
		JLabel l14 = new JLabel("Address:");
		l14.setBounds(30,330,200,30);
		add(l14);
		
		JLabel l15 = new JLabel();
		l15.setBounds(240,330,200,30);
		add(l15);
		
		JLabel l16 = new JLabel("Phone:");
		l16.setBounds(30,370,200,30);
		add(l16);
		
		JLabel l17 = new JLabel();
		l17.setBounds(240,370,200,30);
		add(l17);
		
		JLabel l18 = new JLabel("Email:");
		l18.setBounds(30,410,200,30);
		add(l18);
		
		JLabel l19 = new JLabel();
		l19.setBounds(240,410,200,30);
		add(l19);
		
		b1 = new JButton("Delete");
		b1.setOpaque(true);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(80,470,100,30);
		b1.setBorder(BorderFactory.createEmptyBorder());
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setOpaque(true);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(210,470,100,30);
		b2.setBorder(BorderFactory.createEmptyBorder());
		b2.addActionListener(this);
		add(b2);
		
		String filepath = "travel/management/system/icons/delete.png";
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(filepath));
		Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l20 = new JLabel(i3);
		l20.setBounds(400,80,300,300);
		add(l20);
		
		try {
			Conn conn = new Conn();
			String query = "Select * from customer where username=?";
			PreparedStatement stmt = conn.c.prepareStatement(query);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				l3.setText(rs.getString("username"));
				l5.setText(rs.getString("id"));
				l7.setText(rs.getString("number"));
				l9.setText(rs.getString("name"));
				l11.setText(rs.getString("gender"));
				l13.setText(rs.getString("country"));
				l15.setText(rs.getString("address"));
				l17.setText(rs.getString("phone"));
				l19.setText(rs.getString("email"));
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
				String query1 = "Delete from bookhotel where username=?";
				String query2 = "Delete from bookpackage where username=?";
				String query3 = "Delete from customer where username=?";
				String query4 = "Delete from account where username=?";
				
				PreparedStatement stmt1 = conn.c.prepareStatement(query1);
				PreparedStatement stmt2 = conn.c.prepareStatement(query2);
				PreparedStatement stmt3 = conn.c.prepareStatement(query3);
				PreparedStatement stmt4 = conn.c.prepareStatement(query4);
				
				stmt1.setString(1, username);
				stmt2.setString(1, username);
				stmt3.setString(1, username);
				stmt4.setString(1, username);
				
				stmt1.executeUpdate();
				stmt2.executeUpdate();
				stmt3.executeUpdate();
				stmt4.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Customer details deleted successfully");
				System.exit(0);
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			
		}
		else if(ae.getSource() == b2) {
			this.setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		new DeleteCustomer("jaggoswa");

	}

}
