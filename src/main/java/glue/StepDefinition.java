package glue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.ikcon.tech.pagelocator.Login;
import com.ikcon.tech.utils.TestContextInitializer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinition {
	
	public  static Logger logger = LogManager.getLogger(StepDefinition.class);
			
	private  WebDriver driver;
	private TestContextInitializer initializer;
	private Login login;
	private WebDriverWait wait;
	static {
		
	}
	
	public StepDefinition(TestContextInitializer initializer) {
		
		this.initializer = initializer;
		this.driver = this.initializer.webDriverManager.InitalizeWebDriver();
		this.login  = this.initializer.pom.getLoginInstance();
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}
	
	@Given("user should be at Ceipal Landing page")
	public void user_should_be_at_ceipal_landing_page() {
	    // Write code here that turns the phrase above into concrete actions
	    
		
		logger.info("user browsed the ceipalWorkforce url");
		//to check whether the user is at correct page
		String homepagetitle = driver.getTitle();
		Assert.assertTrue(homepagetitle.contains("Sign In CEIPAL WORKFORCE"));
		logger.info("User has reached to correct page");
		
		
	    
	}
	@When("the user enters the  Username {string} and password {string} and Signin")
	public void the_user_enters_the_username_and_password_and_signin(String string, String string2) throws InterruptedException {
		login.userNameLocator.sendKeys(string);
		login.passwordLocator.sendKeys(string2);
		//takeScreenshot("Loginpage", driver);
		login.signButtonLocator.click();
		Thread.sleep(6000);
		
	   
	}
	@Then("User should be loggedin with home dispalyed")
	public void user_should_be_loggedin_with_home_dispalyed() throws InterruptedException {
		
	    String pagetitle = driver.getTitle();
	    Assert.assertTrue(pagetitle.contains("Dashboard"));
	    //takeScreenshot("Homepage", driver);
	    Thread.sleep(2000);
		login.fourgridLocator.click();
		Thread.sleep(2000);
		login.UserMamagementLocator.click();
		Thread.sleep(2000);;
		login.AddEmployeeLocator.click();
		
	}
	
	/*public static void takeScreenshot(String filename, WebDriver driver) {
		
		Calendar cal =  Calendar.getInstance();
		Date time =  cal.getTime();
		System.out.println(time);
		String timestamp= time.toString().replace(":", "").replace(" ", "");
		//1.take screenshot and store it as file format:
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("E:/Automation1"+"/screenshot/",filename+timestamp+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	
}
