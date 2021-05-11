package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;
/**
 * this class contains java specific generic libraries
 * @author BasavaRAJ
 *
 */

public class JavaUtility {
	/**
	 * generate random number
	 * @return
	 */
	public String getRandomData()
	{
		Random random=new Random();
		int ran=random.nextInt(1000);
		return ""+ran;	
	}
	/**
	 *  Generate current system date
	 * @return
	 */
	public String getCurrentSystemDate()
	{
		Date date=new Date();
		String currentDate=date.toString();
		return currentDate;
	}
	
	

}