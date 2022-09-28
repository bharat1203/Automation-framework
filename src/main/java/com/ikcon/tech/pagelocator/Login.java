package com.ikcon.tech.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	public WebDriver driver;
	
	@FindBy(how = How.ID,using = "useremail")
	public WebElement userNameLocator;
	
	@FindBy(how = How.ID,using = "searchinput1")
	public WebElement passwordLocator;
	
	@FindBy(how = How.XPATH, using = "//button[@id='login_submit']")
	public WebElement signButtonLocator;
	
	@FindBy(how = How.XPATH, using = "//span[@data-original-title='Apps']")
	public WebElement fourgridLocator;
	
	@FindBy(how = How.XPATH, using = "//a/div[text()='User Management']")
	public WebElement UserMamagementLocator; 
	
    @FindBy(how = How.XPATH, using = "//a[@href='/employees/view_list']")
	public WebElement AddEmployeeLocator;

	public Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}

}
