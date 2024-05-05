package Health_products;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Health_products {
	private Connection con;
	public Health_products() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/health_products","root","3110@Gowtham");
	}
	public void cclose() throws SQLException {
		con.close();
	}public boolean admin(String username,String password) throws SQLException {
		Statement s= con.createStatement();
		ResultSet rs=s.executeQuery("select* from admin");
		while(rs.next()) {
			if(username.equals(rs.getString("username"))&& password.equals(rs.getString("password"))) {
				return true;
			}
		}return false;
	}public int insert (String name,String type,int quantity,int price,String benefits) throws SQLException {
		PreparedStatement ps=con.prepareStatement("insert into products(name,type,quantity,price,benefits) values(?,?,?,?,?)");
		ps.setString(1,name);
		ps.setString(2,type);
		ps.setInt(3, quantity);
		ps.setInt(4,price);
		ps.setString(5, benefits);
		return ps.executeUpdate();
	}public void view() throws SQLException {
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select*from products");
		while (rs.next()) {
			System.out.println(rs.getInt("sno")+"\t"+rs.getString("name")+"\t"+rs.getString("type")+"\t"
		+rs.getInt("quantity")+"\t"+rs.getInt("price")+"\t"+rs.getString("benefits"));
			
		}
	}public int update (String name,int quantity,int price) throws SQLException {
		PreparedStatement ps=con.prepareStatement("update products set quantity=?,price=? where name=?");
		ps.setInt(1,quantity);
		ps.setInt(2, price);
		ps.setString(3, name);
		return ps.executeUpdate();
	}
	public int delete (int sno) throws SQLException {
		PreparedStatement ps=con.prepareStatement("delete from products where sno=?");
		ps.setInt(1, sno);
		return ps.executeUpdate();
	}

}
