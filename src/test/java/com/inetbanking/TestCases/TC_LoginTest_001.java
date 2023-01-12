package com.inetbanking.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	 @Test 
	 public void LoginTest() throws InterruptedException, IOException 
	 {
		 driver.get(baseUrl);
		 LoginPage lp = new LoginPage(driver);

		 logger.info("Url is Opened"); 
		 
		 lp.SetUserName(UserName);
		 logger.info("Entered Username");
		 
		 lp.Setpassowrd(password);
		 logger.info("Entered password");
		 
		 lp.setSubmit();
		
		 Thread.sleep(3000);
		 if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Passed");
		} else {
			CaptureScreen(driver, "login test");
			Assert.assertTrue(false);
			logger.info("failed");
		}
		 
	 }

}
