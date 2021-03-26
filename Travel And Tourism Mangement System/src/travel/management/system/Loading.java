package travel.management.system;

import java.awt.*;

import javax.swing.*;

public class Loading extends JFrame implements Runnable{
	
	JProgressBar p;
	Thread t;
	
	public Loading(String username) {
		
		t = new Thread(this);
		
		setLayout(null);
		setBounds(450,200,500,300);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel l1 = new JLabel("Travel And Tourism Application");
		l1.setBounds(50,20,500,50);
		l1.setFont(new Font("Raleway",Font.BOLD,25));
		l1.setForeground(Color.RED);
		add(l1);
		
		p = new JProgressBar();
		p.setBounds(100,80,300,25);
		p.setStringPainted(true);
		add(p);
		
		JLabel l2 = new JLabel("Please wait...");
		l2.setBounds(200,90,100,50);
		l2.setFont(new Font("Tahoma",Font.BOLD,14));
		l2.setForeground(Color.RED);
		add(l2);
		
		JLabel l3 = new JLabel("Welcome " + username);
		l3.setBounds(20,220,150,50);
		l3.setFont(new Font("Tahoma",Font.BOLD,14));
		l3.setForeground(Color.RED);
		add(l3);
		
		t.start();
		
		setVisible(true);
	}
	
	public void run() {
		
		try {
			
			for(int i=1; i<=102; i++) {
				int m = p.getMaximum();
				int n = p.getValue();
				
				if(n < m)
					p.setValue(n + 1);
				else {
					i = 102;
					setVisible(false);
					new Dashboard();
				}
				
				Thread.sleep(50);
			}
			
		}catch(Exception e) {
			
		}
		
	}

	public static void main(String[] args) {
		
		new Loading("Jagriti");
	}

}
