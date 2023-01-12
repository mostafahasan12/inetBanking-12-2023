package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
    Properties pro;
	public ReadConfig()   {
		File src = new File("./Configuration\\Config.Properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (FileNotFoundException e) {
			System.out.println("Expection is"+ e.getMessage());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public String getApplicationUrl() {
		String url = pro.getProperty("BaseUrl");
		return url;		
	}
	
	public String UserName() {
		String UserName = pro.getProperty("UserName");
		return UserName;		
	}
	
	public String getpassword() {
		String password= pro.getProperty("password");
		return password;		
	}
	
	public String getchromepath() {
		String chromepath= pro.getProperty("chromepath");
		return chromepath;		
	}
	
	public String getfirefoxpath() {
		String firefoxpath= pro.getProperty("firefoxpath");
		return firefoxpath;		
	}
	
	public String getedgepath() {
		String edgepath= pro.getProperty("firefoxpath");
		return edgepath ;		
	}
}
