package com.crm.vtigerTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateContactOrganization 
{
	@Test
	public void CreateOrganization() throws InterruptedException
	{
	//launch the browser	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	//get the Url
	driver.get("http://localhost:8888/index.php?action=index&module=Home");

	//login to the application
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");	
	driver.findElement(By.id("submitButton")).click();

	//navigate to Contacts
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(By.linkText("Contacts")).click();

	//create contact with organisation
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	Thread.sleep(3);
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	
	//handling the window
	String parentwh = driver.getWindowHandle();
	Set<String> windows = driver.getWindowHandles();
	for(String str:windows)
	{
		driver.switchTo().window(str);
		String title=driver.getTitle();
		if(!title.contains("Administrator"))
		{
			System.out.println(title);
			break;
		}
	}
	driver.findElement(By.id("5")).click();
	driver.switchTo().window(parentwh);
	Thread.sleep(3);
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	
	//signout from vtiger
		WebElement target = driver.findElement(By.xpath("//td[@valign='bottom']"));
		Thread.sleep(3);
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();	
}
}
