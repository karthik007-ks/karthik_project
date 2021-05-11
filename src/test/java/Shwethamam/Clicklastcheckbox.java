package Shwethamam;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Clicklastcheckbox
{
	@Test
	public void clicklastbox()
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
		
		//navigate to organization and click
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.id("selectCurrentPageRec")).click();
		
		//to select all the checkbox to click last checkbox
		List<WebElement>allboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
		int count=allboxes.size();
		//click on last checkbox
        allboxes.get(count-1).click();
		driver.close();
	}
}

