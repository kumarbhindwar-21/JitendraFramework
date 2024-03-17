package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		
		this.driver=ldriver;
	}
	
	@FindBy(id="user-name1")
	public WebElement userName;
	@FindBy(xpath="//span[text()='Next']")
	public WebElement next;
	@FindBy(id="password")
	public WebElement password;
	@FindBy(name="login-button")
	public WebElement next1;
	
	public void loginToGmail(String userNameApp, String passApp) throws InterruptedException {
		Thread.sleep(2000);
		userName.sendKeys(userNameApp);
		//next.click();
		password.sendKeys(passApp);
		next1.click();
	}
	
	

}
