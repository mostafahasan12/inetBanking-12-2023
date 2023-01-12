package com.inetbanking.TestCases;

import java.io.IOException;
import org.testng.annotations.Test;
import com.inetbanking.PageObjects.AddCustomerPage;
import com.inetbanking.PageObjects.LoginPage;


public class TC_AddNewCustomer_Test extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.SetUserName(UserName);
		 logger.info("Entered Username");
		lp.Setpassowrd(password);
		logger.info("Entered password");
		lp.setSubmit();
		
		Thread.sleep (3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		logger.info("Providing customer details...");
		addcust.ClickAddNewCustomer();
		addcust.CustomerName("mostafa");
		addcust.CustomerGender("click");;
		addcust.Customerdata("5", "22", "1992");
		addcust.Customeradress("egypt");
		addcust.Customercity("cairo");
		addcust.Customerstate("qal");
		addcust.Customerpinno("5484844");
		addcust.Customertelephoneno("878767327");
		
		String email = randomstring()+"@gmail.com";
		addcust.CustomerEmail(email);
		addcust.Customerpassword("aswqt");
		addcust.Customersubmit();
		
	   Thread.sleep(3000);
	   
	   logger.info("validation started...");
	   boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
       
	   if (res == true) 
	   {
		  org.testng.Assert.assertTrue(true);
		  logger.info("test case passed...");
	   } else {
		   logger.info("test case failed...");
		   CaptureScreen(driver, "addNewCustomer");
		   org.testng.Assert.assertTrue(false);
	   }
	}

}
