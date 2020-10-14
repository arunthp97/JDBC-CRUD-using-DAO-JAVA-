import java.sql.Connection;
import java.sql.DriverManager;

public class CRUD_Connection {
	static Connection connection=null;
	 public static Connection getCon()
	 {
		 if(connection==null)
		 {
			 try
			 {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/pass","root","12345");
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 return connection;
		 }
		 else
		 {
			 return connection;
		 }
	 }
}
