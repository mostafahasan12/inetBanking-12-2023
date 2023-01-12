package com.inetbanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.inetbanking.PageObjects.LoginPage;
import com.inetbanking.Utilities.XLUtils2;

public class TC_LoginDDT_002 extends BaseClass {

	@Test (dataProvider = "LoginData" )
	public void loginDDT(String user , String pass) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.SetUserName(user);
		logger.info("username provided");
		lp.Setpassowrd(pass);
		logger.info("password provided");
		lp.setSubmit();
		
//		Thread.sleep(3000);
		
		if (isAlertPresent() == true)
		   {
			driver.switchTo().alert().accept();// close alert 
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("login passed");			
			lp.logoutlink();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();// close logout alert 
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent() // user defined method created to check alert is present or not 
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
		    return false;
		}
	}
	
	@DataProvider (name = "LoginData")  
	 String[][] getData() throws IOException 
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/TestData/inetBanking.xlsx";
//		String path = "C:/Users/mostafa/eclipse-workspace/inetBankingV1/src/test/java/com/inetbanking/TestData/inetBanking.xlsx";
		
		int rownum = XLUtils2.GetRowCount(path, "Sheet1");
		int colcount = XLUtils2.GetCellCount(path, "Sheet1", 1);        
		
		String logindata [] [] = new String [rownum ] [colcount] ;
		for (int i = 1; i <= rownum; i++)
		{
			for (int j = 0 ;j < colcount; j++) 
			{
				logindata [i -1 ] [j] = XLUtils2.getCellData(path, "Sheet1", i, j); // 1 0
			}
		}
		return logindata;
	}
	
}
