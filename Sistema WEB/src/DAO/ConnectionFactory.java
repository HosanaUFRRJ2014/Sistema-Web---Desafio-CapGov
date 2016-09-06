package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.postgresql.*;

public class ConnectionFactory 
{
	
	Connection connection;
	
	public Connection getConnection() {
	    System.out.println("Conectando ao banco");
	    try {
	            //Class.forName("com.mysql.jdbc.Driver");
	            DriverManager.registerDriver(new org.postgresql.Driver()); 
	            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/","postgres","hosanapossante");
	            } catch(SQLException e) {
	                e.printStackTrace();
	                throw new RuntimeException(e);
	             
	        }
	         
	    }

	
	/*public Connection getConnection(){
		try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/","postgres","hosanapossante");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	*/
	/*public Connection getConnection() {
		System.out.println("Conectando ao banco ");
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432", "postgres", "hosanapossante");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}*/
	/*public Connection getConnection()
	{
		try 
		{
			try 
			{
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/","postgres","hosanapossante");
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			
			return connection;
		
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}*/

}
