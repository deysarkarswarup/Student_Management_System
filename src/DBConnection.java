import java.sql.*;
import javax.swing.*;

public class DBConnection {
	
	 public static Connection dbConnector()
	{
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/MCA21";
		String uname="root";
		String pass="qwerty12345";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection(url,uname,pass);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
		}
		return con;	
	}

}

