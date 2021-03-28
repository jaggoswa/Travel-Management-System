package travel.management.system;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Paytm extends JFrame implements ActionListener{
	
	JButton b1;
	
	public Paytm() {
		
		setBounds(500,200,550,400);
		JEditorPane j = new JEditorPane();
		j.setEditable(false);
		
		try {
			
			j.setPage("https://paytm.com/credit-card-bill-payment");
			
		}catch(Exception e) {
			j.setContentType("text/html");
			j.setText("<html>"
					+ "<body"
					+ "><p>Error loading page</p>"
					+ "<p>e</p>"
					+ "</body>"
					+ "</html>");
		}
		
		JScrollPane js = new JScrollPane(j);
		getContentPane().add(js);
		
		b1 = new JButton("Back");
		b1.setBounds(400,20,80,30);
		b1.setOpaque(true);
		b1.setBackground(new Color(133,193,233));
		b1.setForeground(Color.BLACK);
		b1.setBorder(BorderFactory.createBevelBorder(0));
		b1.addActionListener(this);
		j.add(b1);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		this.setVisible(false);
		new Payment();
	}

	public static void main(String[] args) {
		new Paytm();

	}

}
