package com.ikcon.tech.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
	
	public WebDriver driver;
	
	
	public  WebDriver InitalizeWebDriver() {
		
		Properties props = new Properties();
		try {
		    // get the properties from global properties file
		    InputStream fileInputStream = new FileInputStream(
			    "E:\\Automation1\\src\\test\\resources\\com\\ikcon\\tech\\globalconfiguration.properties");
		    props.load(fileInputStream);
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
		// getting browser value from properties file
		String browserFromProperties = props.getProperty("browser");

		// getting browser/driver from terminal
		/*
		 * "-Dbrowser" is the env property name that we give from command line terminal,
		 * so get the property with same name "browser"
		 */
		String browserFromTerminal = System.getProperty("browser");

		/*
		 * If driver/browser value from command line is null, then pick the
		 * driver/browser driver value from properties file
		 */
		String browser = browserFromTerminal != null ? browserFromTerminal : browserFromProperties;

		if (driver == null) {
		    if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", props.getProperty("chromedriverpath"));
			driver = new ChromeDriver();
		    }
		    if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", props.getProperty("chromedriverpath"));
			driver = new FirefoxDriver();
		    }
		    driver.get(props.getProperty("Url"));
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		}
		/*
		 * set driver timeout to execute different driver methods which takes time in
		 * between to execute
		 */
		return driver;
	  }

}
	
	
	


