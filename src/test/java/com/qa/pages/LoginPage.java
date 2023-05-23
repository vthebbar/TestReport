package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.qa.utils.PropertyManager;

public class LoginPage extends BasePage {
	
	@FindBy(id="login_id") private WebElement txtUserName;
	@FindBy(id="login_pswd") private WebElement txtPassword;
	@FindBy(id="idBtnLoginSubmit") private WebElement btnLogin;
	@FindBy(xpath="//a[normalize-space()='Forgot username/password']") private WebElement lnkForgotUserpwd;
	@FindBy(css="input[value='Register for Online Banking']") private WebElement btnRegisterForOnlinebanking;
	
	@FindBy(xpath="//a[normalize-space()='Terms & Conditions']") private WebElement lnkTermsAndConditions;
	@FindBy(xpath="//a[normalize-space()='Privacy Policy']") private WebElement lnkPrivacyPolicy;
	@FindBy(xpath="//a[normalize-space()='Security Policy']") private WebElement lnkSecurityPolicy;
	@FindBy(xpath="//a[normalize-space()='FAQ']") private WebElement lnkFAQ;
	@FindBy(xpath="//div[contains(text(),'Invalid Login. Please try again. (1009)')]") private WebElement txtErrMsg;
	@FindBy(id="idMsgLoginId") private WebElement txtUsernameErrMsg;
	@FindBy(id="idMsgPswd")private WebElement txtPasswordErrMsg;
	
	
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
	
	
	public void verifyUsernameFieldIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(txtUserName, "User name"), true, "Username");
	}
	
	public void verifyPasswordFieldIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(txtUserName, "Password"), true, "Password");

	}
	
	public void verifyLoginBtnIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(txtUserName, "Login button"), true, "Login button");

	}
	
	public ResetHlbConnectPage clickOnForgotUsernamePassword() {
		
		doClick(lnkForgotUserpwd,"Forgot username/Password");
		return new ResetHlbConnectPage(driver);
	}
	
	
	public RegisterForOnlineBankingPage clickOnRegisterForOnlineBankingBtn() {
		doClick(btnRegisterForOnlinebanking,"Register for Online Banking");
		return new RegisterForOnlineBankingPage(driver);
	}
	
	public void clickOnTermsAndConditinsLink() {
		doClick(lnkTermsAndConditions, "Terms & Conditions");
	}
	
	public void clickOnPrivacyPolicyLink() {
		doClick(lnkPrivacyPolicy, "Privacy Policy");

		}
	public void clickOnSecurityPolicyLink() {
		doClick(lnkSecurityPolicy, "Security Policy");

	}
	public void clickOnFAQLink() {
		doClick(lnkFAQ, "FAQ");

	}
	
	//
	public void verifyIncorrectLoginErrMsg(String expVal) {
		String actVal=getText(txtErrMsg,"Incorrect user/pwd Login error message");
		doAssertEqualsStrings(actVal, expVal,"Incorrect user/pwd Login error message");
	}
	//TC04
	public void verifyErrMsgForEmptyUsername(String expVal) {
		
		String actVal= getText(txtUsernameErrMsg, "Error message for empty username");
		doAssertEqualsStrings(actVal, expVal,"Error message for empty username");

	}
	
	public void verifyErrMsgForEmptyPassword(String expVal) {
		String actVal= getText(txtPasswordErrMsg, "Error message for empty password");
		doAssertEqualsStrings(actVal, expVal,"Error message for empty password");

	}
}
