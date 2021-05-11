package Shwethamam;

import java.awt.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CaptureDynamicWebTable 
{	
	@Test
	public void captureOrgName()
{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	//step1:get the Url
	driver.get("http://localhost:8888/index.php?action=index&module=Home");
	
	//step2:login to the application
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");	
	driver.findElement(By.id("submitButton")).click();
	
	//step3:navigate to organization
	driver.findElement(By.linkText("Organizations")).click();
	
	//step4:capture all the organization names
	 java.util.List<WebElement> allorgnames = driver.findElements(By.xpath("//table[@class='lvt small']//tr[*]/td[3]"));
	
	//step5: print all the values
	for (WebElement Element:allorgnames)
	{
		System.out.println(Element.getText());
	}
}
}
