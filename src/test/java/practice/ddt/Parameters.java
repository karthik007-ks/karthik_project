package practice.ddt;

import org.testng.annotations.Test;

public class Parameters 
{
@Test
public void createTest()
{
	String USERNAME=System.getProperty("username");
	String PASSWORD=System.getProperty("password");
	String BROWSER=System.getProperty("browser");
	System.out.println("executing test1");
	System.out.println("========>"+USERNAME);
	System.out.println("========>"+PASSWORD);
	System.out.println("========>"+BROWSER);
}	
}
