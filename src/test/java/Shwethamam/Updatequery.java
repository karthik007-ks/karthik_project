package Shwethamam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class Updatequery 
{
@Test
public void getUpdateQuery() throws SQLException
{
	Connection con=null;
	try
	{
	//step1:register the database
	Driver driverref=new Driver();
	DriverManager.registerDriver(driverref);
	
	//establish connection with database
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer", "root", "root");
	
	//create statement
     Statement state=con.createStatement();
     
     //execute query
      int result=state.executeUpdate("insert Customer values('satya','bangalore','dubhai');");
      if(result==1)
      {
    	  System.out.println("project is successfully created");
      }
      else
      {
    	  System.out.println("query failed");
      }  
}
      catch(Exception e)
      {
    	  
      } 
      finally
      {
    	  con.close();
    	  System.out.println("connection closed");
      }
}
}
