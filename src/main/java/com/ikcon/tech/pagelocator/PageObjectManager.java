package com.ikcon.tech.pagelocator;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	}
	
	public Login getLoginInstance() {
		Login login = new Login(driver);
		return login;
	}

}
