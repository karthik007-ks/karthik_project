package com.comcast.crm.createcontact;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.FileUtility;

public class ListenerImplimentationClass implements ITestListener
{
	public void onTestFailure(ITestResult result)
	{
		String failedTestName = result.getMethod().getMethodName();
		String currentSysDate = new Date().toString().replace(" ", "").replace(":", "");
		EventFiringWebDriver e=new EventFiringWebDriver(BaseClass.sdriver);
		File sourceDestnation = e.getScreenshotAs(OutputType.FILE);
		File destinationPath= new File("./screenshot/"+failedTestName+"_"+currentSysDate+".png");

        try {
			FileUtils.copyFile(sourceDestnation, destinationPath);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}