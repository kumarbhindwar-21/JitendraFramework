package com.qa.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import comqa.utility.BrowserFactory;
import comqa.utility.ConfigDataProvider;
import comqa.utility.ExcelDataProvider;
import comqa.utility.HelperUtility;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Setting up reports and test is getting ready", true);
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		
		ExtentSparkReporter extent=new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/Login"+ HelperUtility.getCurentDateTime()+".html"));
		//ExtentSparkReporter extent=new ExtentSparkReporter(new File("C:\\MyEclipseWorkSpace24\\SeleniumFramework\\Reports\\Login.html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting done. Test can be started",true);
	}
	
	/*
	 * @BeforeClass public void setUp() {
	 * Reporter.log("Trying to start broser and getting application ready",true);
	 * driver=BrowserFactory.startApllication(driver, config.getBrowser(),
	 * config.getStagingUrl()); //driver=BrowserFactory.startApllication(driver,
	 * browser, url);
	 * 
	 * Reporter.log("Browser and uplication is up and running",true); }
	 */
	
	//if run through parameter
	    @Parameters({"browser","appurl"})
		@BeforeClass
		public void setUp(String browser, String url) {
			Reporter.log("Trying to start broser and getting application ready",true);
			driver=BrowserFactory.startApllication(driver, browser, url);

			Reporter.log("Browser and uplication is up and running",true);
		}
	
@AfterClass
public void tearDown() {
	
	BrowserFactory.quitBrowser(driver);
	
}
@AfterMethod
public void tearDownMethod(ITestResult result) {
	Reporter.log("Test is about to end",true);
	if(result.getStatus()==ITestResult.FAILURE) {
		//HelperUtility.capturScreenshot(driver);
		logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(HelperUtility.capturScreenshot(driver)).build());
	}
	else if(result.getStatus()==ITestResult.SUCCESS) {
		logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(HelperUtility.capturScreenshot(driver)).build());
	
	}
	report.flush();
	Reporter.log("Test completed and report generated",true);
}


}
