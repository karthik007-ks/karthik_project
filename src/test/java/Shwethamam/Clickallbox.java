package Shwethamam;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Clickallbox
{
	@Test
	public void clickbox()
	{
		//open the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//get the url
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		
		//enter the username
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		//enter the password
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		//click on login button
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//to select all the checkbox
		driver.findElement(By.id("selectCurrentPageRec")).click();
		
		List<WebElement> allboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(WebElement box:allboxes)
		{
			box.click();
		}
		driver.quit();
	}
}
