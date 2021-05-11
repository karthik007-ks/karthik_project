package com.comcast.crm.createcontact;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

public class Createcontact3 extends BaseClass
{
	@Test(groups="smoketest")
	public void createContactradioTest() throws InterruptedException, IOException
	{	
		//click on contact module and then on + button
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("karthik");
		Thread.sleep(2);
		
		//select administrator in dropdown
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		WebElement administrator = driver.findElement(By.name("assigned_user_id"));
		Wutil.selectOption(administrator, "1");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	@Test(groups="smoketest")
	public void createContactradiooTest() throws InterruptedException, IOException
	{	
		//click on contact module and then on + button
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("karthik");
		Thread.sleep(3);
		driver.findElement(By.xpath("//input[@value='T']")).click();
		WebElement group = driver.findElement(By.name("assigned_group_id"));
		Wutil.selectOption(group, "4");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}	
}
