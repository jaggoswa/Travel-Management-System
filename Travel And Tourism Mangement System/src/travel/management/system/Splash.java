package travel.management.system;
import javax.swing.*;
import java.awt.*;

public class Splash {
	
	public static void main(String[] args) {
		SplashFrame frame =  new SplashFrame();
		frame.setVisible(true);
		int x = 1;
		
		for(int i = 1; i<=600; i++,x++) {
			frame.setLocation(650 - (x-i/10),450 - x/2);
			frame.setSize(x+i, i);
			
			try {
				Thread.sleep(10);
			}catch(Exception e) {}
		}
		
	}

}

class SplashFrame extends JFrame implements Runnable{
	
	SplashFrame(){
		Thread t1;
		String filepath = "travel/management/system/icons/splash.jpg";
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(filepath));
		Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		add(l1);
//		setBounds(100,100,600,400);
		
		setUndecorated(true);
		t1 = new Thread(this);
		t1.start();
	}
	
	public void run() {
		try{
			Thread.sleep(10000);
			this.setVisible(false);
			
			new Login();
		}catch(Exception e) {}
	}
}
