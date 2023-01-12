package com.inetbanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	
//  Create constructor 
	public AddCustomerPage (WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
  @FindBy (how =  How.XPATH , using = "/html/body/div[3]/div/ul/li[2]/a")
  @CacheLookup 
  WebElement lnkAddNewCustomer;
  
  @FindBy (how =  How.NAME , using = "name")
  @CacheLookup 
  WebElement txtCustomerName;
  
  @FindBy (how =  How.NAME , using = "rad1")
  @CacheLookup 
  WebElement genderty;
  
  @FindBy (how =  How.ID_OR_NAME , using = "dob")
  @CacheLookup 
  WebElement txtdob;
  
  @FindBy (how =  How.NAME , using = "addr")
  @CacheLookup 
  WebElement txtadress;
  
  @FindBy (how =  How.NAME , using = "city")
  @CacheLookup 
  WebElement txtcity;
  
  @FindBy (how =  How.NAME , using = "state")
  @CacheLookup 
  WebElement txtstate;
  
  @FindBy (how =  How.NAME , using = "pinno")
  @CacheLookup 
  WebElement txtpinno;
  
  @FindBy (how =  How.NAME , using = "telephoneno")
  @CacheLookup 
  WebElement txtTelephone;
  
  @FindBy (how =  How.NAME , using = "emailid")
  @CacheLookup 
  WebElement txtEmail;
  
  @FindBy (how =  How.NAME , using = "password")
  @CacheLookup 
  WebElement txtpassword;
  
  @FindBy (how =  How.NAME , using = "sub")
  @CacheLookup 
  WebElement btnsubmit;
  
  public void ClickAddNewCustomer() {
	 lnkAddNewCustomer.click(); 
  }
  
  public void CustomerName(String cname) {
	  txtCustomerName.sendKeys(cname); 
  }
  
  public void CustomerGender(String cgender) {
	  genderty.click(); 
	  }
  
  public void Customerdata(String mm , String dd , String yy ) {
	  txtdob.sendKeys(mm);
	  txtdob.sendKeys(dd);
	  txtdob.sendKeys(yy);
	  }
  
  public void Customeradress(String cadress) {
	  txtadress.sendKeys(cadress); 
  }
  
  public void Customercity(String ccity) {
	  txtcity.sendKeys(ccity); 
  }
  
  public void Customerstate(String cstate) {
	  txtstate.sendKeys(cstate); 
  }
  
  public void Customerpinno(String cpinno) {
	  txtpinno.sendKeys(String.valueOf(cpinno)); 
  }
  
  public void Customertelephoneno(String ctelephoneno) {
	  txtTelephone.sendKeys(ctelephoneno); 
  }
  
  public void CustomerEmail(String cEmail) {
	  txtEmail.sendKeys(cEmail); 
  }
  
  public void Customerpassword(String cpassword) {
	  txtpassword.sendKeys(cpassword); 
  }
  
  public void Customersubmit() {
	  btnsubmit.click(); 
  }
}
