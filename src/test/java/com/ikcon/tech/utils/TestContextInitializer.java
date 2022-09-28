package com.ikcon.tech.utils;


//import org.openqa.selenium.WebDriver;

import com.ikcon.tech.pagelocator.PageObjectManager;

public class TestContextInitializer {

	//public WebDriver driver;
	
	public PageObjectManager pom;
	
	public WebDriverManager webDriverManager;
	
	
	public TestContextInitializer() {
		
		webDriverManager = new WebDriverManager();
		
		this.pom = new PageObjectManager(webDriverManager.InitalizeWebDriver());
				
		
		
	}
	
}
