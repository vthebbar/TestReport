package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.PropertyManager;

public class LoginPage extends BasePage {
	
	@FindBy(id="login_id") private WebElement txtUserName;
	@FindBy(id="login_pswd") private WebElement txtPassword;
	@FindBy(id="idBtnLoginSubmit") private WebElement btnLogin;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	
	public void enterUserName(String userName) {
		
		//txtUserName.sendKeys(userName);
//		wait.until(ExpectedConditions.visibilityOf(txtUserName)).clear();
//		wait.until(ExpectedConditions.visibilityOf(txtUserName)).sendKeys(userName);
		
		doSendKeys(txtUserName,userName, "User name");
	}
	
	public void enterPassword(String password) {
//		wait.until(ExpectedConditions.visibilityOf(txtPassword)).clear();
//		wait.until(ExpectedConditions.visibilityOf(txtPassword)).sendKeys(password);
		
		doSendKeys(txtPassword,password, "Password");


	}
	
	public HomePage clickOnLoginBtn() {

		//wait.until(ExpectedConditions.visibilityOf(btnLogin)).click();
		
		doClick(btnLogin, "Login button");
		return new HomePage(driver);
	}
	
	public HomePage doLogin() {
		launchAppBaseUrl();
		
		String userName=PropertyManager.propertyLoader().getProperty("userName");
		String password=PropertyManager.propertyLoader().getProperty("password");
		
		doSendKeys(txtUserName,userName, "User name");
		doSendKeys(txtPassword,password, "Password");
		doClick(btnLogin, "Login button");
		
//		wait.until(ExpectedConditions.visibilityOf(txtUserName)).clear();
//		wait.until(ExpectedConditions.visibilityOf(txtUserName)).sendKeys();
//		wait.until(ExpectedConditions.visibilityOf(txtPassword)).clear();
//		wait.until(ExpectedConditions.visibilityOf(txtPassword)).sendKeys();
//		wait.until(ExpectedConditions.visibilityOf(btnLogin)).click();

		return new HomePage(driver);
	}
}
