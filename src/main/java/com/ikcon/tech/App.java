package com.ikcon.tech;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

/**
 * Hello world!
 *
 */
public class App 
{
	static TestNG testNg;
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        testNg = new TestNG();
        List<String> suites = new ArrayList<String>();
        suites.add("C:\\Users\\BharatKumarPamarthi\\eclipse-workspace\\Automation4\\testng.xml");// path to xml..
        testNg.setTestSuites(suites);
        testNg.run();
        
    }
}
