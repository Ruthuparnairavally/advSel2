package vtigerGenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
/**
 * This class contains all the generic methods related to database
 * @author RUTHUPARNA
 *
 */
public class DatabaseUtils {

	public Driver driverref;
	public static Connection con;
	
	/**
	 * This method is used to establis the connection with database
	 * @return
	 * @throws SQLException
	 */
	public Connection connectoDb() throws SQLException
	{
		driverref = new Driver();
		DriverManager.registerDriver(driverref);
		con = DriverManager.getConnection(IConstant.dburl, IConstant.dbun, IConstant.dpass);
		
		return con;
	}
	
	public String getData(String query, int index, String expdata ) throws SQLException
	{
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery(query);
		Boolean flag = false;
		while(res.next())
		{
			if(res.getString(index).equals(expdata))
			{
				flag = true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Data valid");
			return expdata;
		}
		else
		{
			System.out.println("Data not valid");
			return "";
		}
	}
	
	public void closeDb() throws SQLException
	{
		con.close();
	}
}
