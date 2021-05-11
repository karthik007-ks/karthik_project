package com.comcast.crm.createcontact;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebdriverUtility;
import com.crm.vtiger.PomClass.ContactsPage;
import com.crm.vtiger.PomClass.Createnewcontacts;
import com.crm.vtiger.PomClass.HomePage;
@Listeners(com.comcast.crm.createcontact.ListenerImplimentationClass.class)
public class TC_6_create_Contact_Test extends BaseClass
{   
	WebdriverUtility wbu=new WebdriverUtility(); 
	FileUtility futil=new FileUtility();
	@Test
	public void createContactTest() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{	
		//click on contact module and then on + button
		String lastname = Eutil.getExcelData("Sheet2", 1, 2);
		HomePage home= new HomePage(driver);
		home.ClickOnContactsModule();
		ContactsPage con=new ContactsPage(driver);
		con.ClickOnCreateNewContact();
		Createnewcontacts create=new Createnewcontacts(driver);
		create.clickonlastnametextfield(lastname);
		
		driver.findElement(By.xpath("//img[@title='Export Contacts']")).click();
		Thread.sleep(1);
		driver.findElement(By.name("Export")).click();
	}
	
}
