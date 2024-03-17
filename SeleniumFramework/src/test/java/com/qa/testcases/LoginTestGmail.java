package com.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.pages.BaseClass;
import com.qa.pages.LoginPage;

import comqa.utility.HelperUtility;

public class LoginTestGmail extends BaseClass {
	
	@Test(priority = 1)
	public void loginApp() throws InterruptedException {
		logger=report.createTest("Free_CRM");
		
	LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
	
	logger.info("Starting Application");
	//loginPage.loginToGmail(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
	loginPage.loginToGmail(excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1));
	logger.pass("Login Successfull");
	//HelperUtility.capturScreenshot(driver);
	}
	@Test(priority = 2)
	public void loginApp1() throws InterruptedException{
	logger=report.createTest("Free_CRM");
	logger.info("Starting Application");
	logger.fail("Failed");
	//HelperUtility.capturScreenshot(driver);
	}

}
