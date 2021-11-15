package com.crm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.crm.utils.CommonUtils;
import com.crm.utils.WebDriverEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	WebDriver driver;
	protected Properties prop;
	protected SoftAssert asrt;
	public Logger logger; 
	
	public Base base;
	
	public void configProperties() throws IOException {
		prop = System.getProperties();
		try {
			prop.load(new FileInputStream(new File("src/main/java/com/crm/config/config.properties")));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	@BeforeMethod
	@Parameters(value = {"browser"})
	public void initialize() throws IOException {
		configProperties();
		logger = Logger.getLogger(TestBase.class);
		
		if(prop.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			logger.info("Setting up chrome web driver.");
			driver = new ChromeDriver();
		}else if(prop.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		/** Create an EventFiringWebDriver object and then register webdrivereventlistener to webdriver driver
		 *
		 *EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		 *WebDriverEventListener elistener = new WebDriverEventListener();
		 *driver = eventDriver.register(elistener);			
		 */

		driver = new EventFiringWebDriver(driver).register(new WebDriverEventListener());
		
		driver.manage().window().maximize();
		logger.info("Maximize window");
		driver.manage().deleteAllCookies();
		logger.info("Delete all the cookies.");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIMEOUT));
		logger.info("Setting page load timeout.");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIMEOUT));
		logger.info("Setting implicit wait.");
		driver.get(prop.getProperty("url"));
		logger.info("Open the browser and redirect to url");
		asrt = new SoftAssert();
		
		base = new BasePage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		asrt.assertAll();
		driver.close();
	}
}
