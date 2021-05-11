package practice.ddt;

import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlTest;

public class CreateCustomerTest 
{
@Test
public void CreateCustomerTest(XmlTest xml)
{
	 String browser=xml.getParameter("browser"); 
	System.out.println(browser);
}

}
