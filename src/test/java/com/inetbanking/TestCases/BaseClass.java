package com.inetbanking.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.Utilities.ReadConfig;

public class BaseClass  {
	
  ReadConfig readconfig = new ReadConfig();
  public String baseUrl  = readconfig.getApplicationUrl();
  public String UserName = readconfig.UserName();
  public String password = readconfig.getpassword();
  public static WebDriver driver;
  public static Logger logger;
//  @SuppressWarnings("deprecation")
@Parameters("browser")
  @BeforeClass 
  public void setup(String br) throws InterruptedException
  {
	  logger = Logger.getLogger("ebanking");
	  PropertyConfigurator.configure("log4j.properties");	
	  
	  if (br.equals("chrome")) {
		  System.setProperty("webdriver.chrome.driver",
				  readconfig.getchromepath());
		  driver = new ChromeDriver();
	} else if (br.equals("firefox")) {
		 System.setProperty("webdriver.gecko.driver",
				  readconfig.getfirefoxpath());
		  driver = new FirefoxDriver();
	} else if (br.equals("edge")) {
		 System.setProperty("webdriver.msedge.driver",
				  readconfig.getedgepath());
		  driver = new EdgeDriver();
	}
	  driver.get(baseUrl);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  
  @AfterClass 
  public void teardown() 
  {
	  driver.quit();
  }
  
 public void CaptureScreen(WebDriver driver , String tname) throws IOException {
	 TakesScreenshot ts =(TakesScreenshot) driver;
	 File source = ts.getScreenshotAs(OutputType.FILE);
	 File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
	 FileUtils.copyFile(source, target);
	 System.out.println("Screenshot taken");
 }
 
 public String randomstring() 
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
	}
	public String randomNum() 
	{
		String generatedstring2 = RandomStringUtils.randomNumeric(4);
		return generatedstring2;
	}
}
