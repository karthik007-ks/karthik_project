package practice.ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromProPertiesFile
{
 @Test
 public void ReadDataTest() throws Throwable 
 {
	FileInputStream  fis=new FileInputStream("./data/commonData.properties");
	Properties p=new Properties();
	p.load(fis);
	String URL=p.getProperty("url");
	String BROWSER=p.getProperty("browser");
	String PLATFORRM=p.getProperty("platform");
	String USERNAME=p.getProperty("username");
	String PASSWORD=p.getProperty("password");
	System.out.println(URL);
	System.out.println(BROWSER);
	System.out.println(PLATFORRM);
	System.out.println(USERNAME);
	System.out.println(PASSWORD);
 }
}
