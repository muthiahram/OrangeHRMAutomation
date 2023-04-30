package com.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	
	public ReadConfig(){
	
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\Administrator\\SeleniumAutomationFrameWork\\Orange_HRM_Automation\\src\\test\\resources\\configfiles\\config.properties");
			prop= new Properties();
			prop.load(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	/*
	 * public String getBrowser() { String br= prop.getProperty("browser"); return
	 * br; }
	 */
	
	public String getUserName() {
		String username= prop.getProperty("uname");
		return username;
	}
	
	public String getPassword() {
		String pwd= prop.getProperty("password");
		return pwd;
	}

	public String getUrl() {
		String appurl=prop.getProperty("url");
		return appurl;
	}
	
	public String getHuburl() {
		String hurl=prop.getProperty("huburl");
		return hurl;
	}
	
	
}