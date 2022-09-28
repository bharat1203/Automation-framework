package com.ikcon.tech.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/com/ikcon/tech",glue="glue",
              dryRun=false, monochrome=true, plugin = { "pretty", "junit:target/cucumber-reports/Cucumber.xml",
            		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class RunnerTest extends AbstractTestNGCucumberTests {

}
