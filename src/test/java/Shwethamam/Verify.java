package Shwethamam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class Verify
{
	public class Databaseutils 
	{
	@Test
	public void getExecuteQuery() throws SQLException
	{
		//step1:register the database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//establish connection with databse
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer", "root", "root");
		
		//create statement
	     Statement state=con.createStatement();
	     
	     //execute query
	      ResultSet result=state.executeQuery("select * from Customer;");
	      
	      String s="karthik";
	      //verifying the string
	      while(result.next())
	      {
	    	  String verify=result.getString(1);
	      if(verify.equalsIgnoreCase(s))
	      {
	    	  System.out.println("the given name is present in the database");
	      }
	      }
	      //close the connection
	      System.out.println("connection is closed");
	      con.close();
	}
	}

}
