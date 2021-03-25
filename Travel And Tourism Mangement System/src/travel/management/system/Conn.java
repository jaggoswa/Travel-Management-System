package travel.management.system;

import java.sql.*;

public class Conn {
	
	Connection c;
	Statement s;
	
	public Conn() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms","root","Adobe125$");
			s = c.createStatement();
			
		}catch(Exception e) {
			
		}
	}

}
