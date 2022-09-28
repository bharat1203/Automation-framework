package glue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ikcon.tech.utils.TestContextInitializer;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public  static Logger logger = LogManager.getLogger(StepDefinition.class);
	
	private WebDriver driver;
	private static CustomExtentReporter customExtentReporter;
	private static boolean isReporterRunning;
	
	private TestContextInitializer initializer;
	
	public Hooks(TestContextInitializer initializer){
		this.initializer = initializer;
		this.driver = this.initializer.webDriverManager.InitalizeWebDriver();
	}
	
	//execute before every scenario
	@Before
	public void BeforeScenario() {
		driver.manage().window().maximize();
	}
	@Before
	public void beforeScenario(Scenario scenario) {
		if(!isReporterRunning) {
			customExtentReporter = new CustomExtentReporter("C:\\Users\\BharatKumarPamarthi\\eclipse-workspace\\Automation4\\Data\\TestReport.html");
			isReporterRunning=true;
		}
	}
	
	
	
	@AfterStep
	public void captureScreenshot(Scenario scenario) {
		
		File file = null;
		byte[] filecontent= null;
		/*
		if(scenario.isFailed()) {
			logger.info("Scenario step failed");
			logger.debug(scenario.getLine() + "is the failed step in the scenario");
			file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			try {
				filecontent = FileUtils.readFileToByteArray(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scenario.attach(filecontent, "image/jpg","failedstep");
		}*/
		
		file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			filecontent = FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scenario.attach(filecontent, "image/png","sucess");
		
		
	}
	
	@AfterStep
	public void captureFailedSccreenshot(Scenario scenario) {
		
		File file ;
		byte[] filecontent= null;
		
		if(scenario.isFailed()) {
			logger.info("Scenario step failed");
			logger.debug(scenario.getLine() + "is the failed step in the scenario");
			file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			try {
				filecontent = FileUtils.readFileToByteArray(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scenario.attach(filecontent, "image/jpg","failedstep");
		}
		
		
	}
	
	/*
	@After
	public void afterScenario(Scenario scenario) {
		File file =null;
		byte[] filecontent =null;
		if(scenario.isFailed()) {
			String screenshotfileName ="C:\\Users\\BharatKumarPamarthi\\eclipse-workspace\\Automation4\\Data"+scenario.getName().replace(" ", "")+".jpg";
			if(scenario.isFailed()) {
				
				file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
			
				
				scenario.attach(filecontent, "image/jpg","failedstep");
				
			}
			
		}
		
	}*/
	
	//executes after every Scenario
	@After
	public void AfterScenario() {
		driver.quit();
	}
	

}
