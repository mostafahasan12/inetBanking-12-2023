package com.inetbanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
//  Create constructor 
	public LoginPage (WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name = "uid")
	@CacheLookup
	WebElement  txtUserName;
	
	@FindBy(name = "password") 
	@CacheLookup
	WebElement  txtPassword;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement  btnlogin;
	
	@FindBy (linkText = "Guru99 Bank")
	WebElement check;
	
	@FindBy (xpath = "/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnklogout;
	
	public void SetUserName (String mngr469234) {
		txtUserName.sendKeys(mngr469234);
	}
	
	public void Setpassowrd (String sedApEq) {
		txtPassword.sendKeys(sedApEq);
	}
	
	public void setSubmit () {
		btnlogin.click();
	}
	
	public void logoutlink () {
		lnklogout.click();
	}
}
