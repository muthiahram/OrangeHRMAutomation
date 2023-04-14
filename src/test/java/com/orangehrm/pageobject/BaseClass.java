package com.orangehrm.pageobject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.orangehrm.testcase.TC_LoginTest_001;
import com.orangehrm.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	ReadConfig rc = new ReadConfig();
	public String appurl = rc.getUrl();
	public String username = rc.getUserName();
	public String pwd = rc.getPassword();
	public String br = rc.getBrowser();
	public static Logger logger = LogManager.getLogger(BaseClass.class);
	

	@BeforeMethod

	public void setUp() {

		if (br.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			driver.get(appurl);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			logger.info("Launched the application url");
		}

		else if (br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(appurl);

		}

		else if (br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(appurl);

		}

		else if (br.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.get(appurl);

		}

	}

	@AfterMethod

	public void tearDown() {
		driver.close();
	}

	public void screenshot() throws IOException {

		Date d = new Date(0);
		// System.out.println(d);
		String filename = d.toString().replace(" ", "-").replace(":", "-");
		System.out.println(filename);
		TakesScreenshot srcsht = (TakesScreenshot) driver;
		File srcfile = srcsht.getScreenshotAs(OutputType.FILE);
		String x = "C:\\Users\\Administrator\\SeleniumAutomationFrameWork\\Orange_HRM_Automation\\screenshots\\one "
				+ filename + ".jpeg";
		File destfile = new File(x);
		FileUtils.copyFile(srcfile, destfile);

	}
}
