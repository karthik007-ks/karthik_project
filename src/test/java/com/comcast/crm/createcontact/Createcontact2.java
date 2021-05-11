package com.comcast.crm.createcontact;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

public class Createcontact2 extends BaseClass
{
	@Test(groups="regressiontest")
	public void createContactorgTest() throws InterruptedException
	{
		//click on contact module and then on + button
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("karthik");
		Thread.sleep(1);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		Iterator<String> iterator = child.iterator();
		while(iterator.hasNext())
		{
			String next = iterator.next();
			driver.switchTo().window(next);
			System.out.println(driver.getTitle());
		}
		
		driver.findElement(By.id("search_txt")).sendKeys("karthik");
		driver.findElement(By.name("search")).click();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input[@style='cursor:hand;cursor:pointer']")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	@Test(groups="regressiontest")
	public void createContactleadTest() throws InterruptedException, IOException, ParseException
	{	
		//click on contact module and then on + button
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("karthik");
		
		//seleting leadsource dropdown
		 WebElement dropdown = driver.findElement(By.name("leadsource"));
		 Wutil.selectOption(dropdown, "Cold Call");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	
}
