package com.crm.vtiger.PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsMod;
	
	
	
	public WebElement getContactsMod() 
	{
		return ContactsMod;
	}

	public void ClickOnContactsModule()
	{
		ContactsMod.click();
    }
}
