package com.crm.vtiger.PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement Contactspage;

	public WebElement getContactspage() 
	{
		return Contactspage;
	}
	
	public void ClickOnCreateNewContact()
	{
		Contactspage.click();
	}
	
}
