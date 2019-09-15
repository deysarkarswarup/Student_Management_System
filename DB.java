

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	public static Connection getConnection(){
		Connection con=null;
		try{
			String url="jdbc:mysql://localhost:3306/mca21";
			String uname="root";
			String pass="qwerty12345";
			Class.forName("com.mysql.cj.jdbc.Driver");
//			DriverManager.getConnection(url,uname,pass);
			con=DriverManager.getConnection(url,uname,pass);
		}catch(Exception e){System.out.println(e);}
		return con;
	}

}

