package com.crm.vtiger.PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebdriverUtility;

public class Createnewcontacts extends WebdriverUtility
{
	public Createnewcontacts(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
	@FindBy(name="lastname")
	public WebElement lastnameTF;
	public WebElement getLastnameTF() 
	{
		return lastnameTF;
	}
	
	@FindBy(name="button")
	public WebElement saveBUTTON;
	public WebElement getSaveBUTTON() 
	{
		return saveBUTTON;
	}
	
	@FindBy(name="leadsource")
	public WebElement leadsourcedropdown;
	public WebElement getLeadsourcedropdown()
	{
		return leadsourcedropdown;
	}
	
	@FindBy(xpath="//input[@value='U']")
	public WebElement userRadioButton;

	public WebElement getUserRadioButton() 
	{
		return userRadioButton;
	}
	
	@FindBy(xpath="//input[@value='T']")
	public WebElement groupRadioButton;
	public WebElement getGroupRadioButton() 
	{
		return groupRadioButton;
	}
	@FindBy(name="assigned_user_id")
	public WebElement AdministratorDropdown;
	public WebElement getAdministratorDropdown() 
	{
		return AdministratorDropdown;
	}
	@FindBy(name="assigned_group_id")
	public WebElement GroupDropdown;
	public WebElement getGroupDropdown()
	{
		return GroupDropdown;
	}
	
	public void clickonlastnametextfield(String lastname)
	{
		lastnameTF.sendKeys(lastname);
	}
	public void createcontactbyLeadSourcedropdown(String option)
	{
		selectOption(leadsourcedropdown, option);
	}	
	public void ClickOnsaveButton()
	{
		saveBUTTON.click();
	}
	public void ClickOnUserRadioButton() 
	{
		userRadioButton.click();
	}
	public void ClickOnGroupRadioButton() 
	{
		groupRadioButton.click();
	}
	public void UserDropdown(String option1)
	{
		selectOptionvisible(AdministratorDropdown, option1);
	}
	public void GroupDropdown(String option2)
	{
		selectOptionvisible(GroupDropdown, option2);
	}
}
