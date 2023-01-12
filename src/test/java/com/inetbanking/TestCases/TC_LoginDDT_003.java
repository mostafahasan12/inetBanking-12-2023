package com.inetbanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;
import com.inetbanking.Utilities.ExcelReader;

public class TC_LoginDDT_003 extends BaseClass {

	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}

	@Test(dataProvider="ExcelData")
	public void loginDDT(String user , String pass) throws InterruptedException 
	{
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
			logger.info("login fail");
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
}
