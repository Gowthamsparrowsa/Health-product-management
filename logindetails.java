package Health_products;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class logindetails {
private Connection con;
public logindetails() throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/health_products","root","3110@Gowtham");
}
public boolean login_user(String username,String password) throws SQLException  {
	Statement s =con.createStatement();
	ResultSet rs=s.executeQuery("select * from login_user");
	while(rs.next()) {
		if(username.equals(rs.getString("username"))&& password.equals(rs.getString("password"))) {
			return true;
			
		}
	}return false;
}
public void view() throws SQLException {
	Statement s=con.createStatement();
	ResultSet rs=s.executeQuery("select*from products");
	while (rs.next()) {
		System.out.println(rs.getInt("sno")+"\t"+rs.getString("name")+"\t"+rs.getString("type")+"\t"
	+rs.getInt("quantity")+"\t"+rs.getInt("price")+"\t"+rs.getString("benefits"));
		
	}
}
}
