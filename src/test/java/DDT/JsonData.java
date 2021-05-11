package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebdriverUtility;

public class JsonData {
	WebdriverUtility wbu=new WebdriverUtility();
	FileUtility futil=new FileUtility();
	@Test  
	public void createOrgWithIndustry() throws IOException, InterruptedException, ParseException
	{
		//storing jason data in variables      
		WebDriver driver=null;
		String browserName = futil.getDataFromJson("browser");
		String url = futil.getDataFromJson("url");
		String username = futil.getDataFromJson("username");
		String password = futil.getDataFromJson("password");
		
		//Launch browser based on the browser name
		if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		wbu.waitUntilPageLoad(driver);
		
		//Step1:get url
		driver.get(url);
		
		//Step2:logn to application

		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		
		//Step3:Navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step4:Click on create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step5:Create orgamization
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("TYSS31");
		WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
		wbu.mouseOver(driver, industry);
		driver.findElement(By.xpath("//option[@value='Banking']")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(4000);
		
		//Step6:Click on signout
				WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wbu.mouseOver(driver, signout);
				driver.findElement(By.linkText("Sign Out")).click();
		
		
	}

}
