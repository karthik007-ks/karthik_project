package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AttachIndustry
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

	//navigate to organization
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys("tyss");

	//select industry
	WebElement industry = driver.findElement(By.name("industry"));
	Select s=new Select(industry);
	s.selectByValue("Chemicals");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//signout from vtiger
	WebElement target = driver.findElement(By.xpath("//td[@valign='bottom']"));
	Thread.sleep(3);
	Actions a=new Actions(driver);
	a.moveToElement(target).perform();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();	
	}
	}
