package com.orangehrm.pageobject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
	public String hurl = rc.getHuburl();
	public static Logger logger = LogManager.getLogger(BaseClass.class);

	
	@Parameters({ "browser", "platform" })
	@BeforeMethod
	public void setUp(String browserName, String platformName,Method name) {
		System.out.println(browserName);
		String methodName = name.getName();
		MutableCapabilities sauceOpts = new MutableCapabilities();
		 sauceOpts.setCapability("name", methodName);
		sauceOpts.setCapability("build", "Java-W3C-Examples");
		sauceOpts.setCapability("seleniumVersion", "4.8.2");
		sauceOpts.setCapability("username", "oauth-gomathimuthiah90-feab0");
		sauceOpts.setCapability("accessKey", "86358a53-8064-4fe5-b4c2-bf352f26fd23");
		sauceOpts.setCapability("tags", "w3c-chrome-tests");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("sauce:options", sauceOpts);
		cap.setCapability("browserVersion", "latest");
		cap.setCapability("platformName", platformName);

		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			cap.setCapability("browserName", "chrome");

		}

		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			cap.setCapability("browserName", "edge");

		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			cap.setCapability("browserName", "firefox");

		}

		else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			cap.setCapability("browserName", "ie");

		}

		try {
			driver = new RemoteWebDriver(new URL(
					"https://oauth-gomathimuthiah90-feab0:86358a53-8064-4fe5-b4c2-bf352f26fd23@ondemand.eu-central-1.saucelabs.com:443/wd/hub"),
					cap);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@AfterMethod(alwaysRun = true)

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
