package glue;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.Scenario;

public class CustomExtentReporter {
	
	 private ExtentHtmlReporter extentHtmlReporter;
	 private ExtentReports extentReports;
	 
	 public CustomExtentReporter(String reportlocation) {
		 extentHtmlReporter = new ExtentHtmlReporter(new File(reportlocation));
		 extentReports = new ExtentReports();
		 // will start extent report engine
		 extentReports.attachReporter(extentHtmlReporter);
		 
	 }
	 public void createTest(Scenario scenario,String screenshotFile) {
		 if(scenario!=null){
			 String testName =getScenarioTitle(scenario);
			 switch (scenario.getStatus()){
			       //to get the title of the scenario 
			      
			      case PASSED:
				       extentReports.createTest(testName).pass("passed");
				       break;
			     case FAILED:
			    	  extentReports.createTest(testName).fail("failed").addScreenCaptureFromPath(getScreenshotLocation(screenshotFile));
			    	  break;
				
			     default:
			    	extentReports.createTest(testName).skip("skipped");
				    break;
				    
			}
		 }
		 
	 }
	 public void writeToReport() {
		 if(extentReports!=null) {
			 extentReports.flush();
		 }
	 }
	 private String getScreenshotLocation(String location) {
		 return "file:////"+location.replace("\\", "//");
	 }
	 private String getScenarioTitle(Scenario scenario) {
		 
		 return scenario.getName().replace(" ", "");
		 
	 }
	 
}
