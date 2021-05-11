package com.crm.vtiger.GenericUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.vtiger.PomClass.LoginPage;

public class BaseClass
{
public static WebDriver sdriver;
public WebDriver driver;
public ExcelUtility Eutil=new ExcelUtility();
public FileUtility Futil=new FileUtility();
public JavaUtility Jutil=new JavaUtility();
public WebdriverUtility Wutil=new WebdriverUtility();

@BeforeSuite(groups={"smoketest","regressiontest"})
public void configBt()
{
	//connect to database
}

@BeforeTest(groups={"smoketest","regressiontest"})
public void configTb()
{
	//parallel execution
}

@BeforeClass(groups={"smoketest","regressiontest"})
public void openbrowser() throws Throwable 
{
 String browser=Futil.getPropertyKeyValue("browser");
 if(browser.equalsIgnoreCase("chrome"))
 {
	 driver=new ChromeDriver();
 }
 else if(browser.equalsIgnoreCase("Firefox"))
 {
	 driver=new FirefoxDriver();
 }
 driver.manage().window().maximize();
 Wutil.waitUntilPageLoad(driver);
 sdriver=driver;
}
@BeforeMethod(groups={"smoketest","regressiontest"})
public void login() throws Throwable
{
	driver.get(Futil.getPropertyKeyValue("url"));
	String username = Futil.getDataFromJson("username");
	String password = Futil.getDataFromJson("password");
	LoginPage login =new LoginPage(driver);
	login.login(username, password);
}
@AfterMethod(groups={"smoketest","regressiontest"})
public void logout()
{
	WebElement target = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Wutil.mouseOver(driver, target);
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
}
@AfterClass(groups={"smoketest","regressiontest"})
public void closebrowser()
{
	driver.close();
}
@AfterTest(groups={"smoketest","regressiontest"})
public void configAt()
{
	//closing browser parallel
}
@AfterSuite(groups={"smoketest","regressiontest"})
public void configAs()
{
	//disconecting database
}
}
