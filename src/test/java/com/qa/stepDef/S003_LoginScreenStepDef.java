package com.qa.stepDef;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.FAQPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PrivacyPolicyPage;
import com.qa.pages.RegisterForOnlineBankingPage;
import com.qa.pages.ResetHlbConnectPage;
import com.qa.pages.SecurityPolicyPage;
import com.qa.pages.TermsAndConditionsPage;
import com.qa.utils.PDFReader;

import io.cucumber.java.en.*;

public class S003_LoginScreenStepDef {

	private WebDriver driver;
  private LoginPage loginPage;
  private ResetHlbConnectPage resetHlbConnectPage;
  private RegisterForOnlineBankingPage registerForOnlineBankingPage	;
  private FAQPage faqPage;
  private SecurityPolicyPage securityPolicyPage;
  private PrivacyPolicyPage privacyPolicyPage;
  private TermsAndConditionsPage termsAndConditionsPage;

  
  public S003_LoginScreenStepDef(TestContext context) {
	  driver = context.driver;
	  loginPage = PageObjectFactory.getLoginPage(driver);
	  resetHlbConnectPage = PageObjectFactory.getRresetHlbConnectPage(driver);
	  registerForOnlineBankingPage = PageObjectFactory.getRegisterForOnlineBankingPage(driver);
	  faqPage = PageObjectFactory.getFAQPage(driver);
	  securityPolicyPage = PageObjectFactory.getSecurityPolicyPage(driver);
	  privacyPolicyPage=PageObjectFactory.getPrivacyPolicyPage(driver);
	  termsAndConditionsPage=PageObjectFactory.getTermsAndConditionsPage(driver);
	  
  }
  
@Then("Username, Password and Login button are displayed")
public void usernamePasswordAndLoginButtonAreDisplayed() {
	//driver=DriverFactory.getDriver();
	//loginPage= new LoginPage(driver);
	
	loginPage.verifyUsernameFieldIsDisplayed();
	loginPage.verifyPasswordFieldIsDisplayed();
	loginPage.verifyLoginBtnIsDisplayed();
}

@When("I click on Forgot username\\/password link")
public void iClickOnForgotUsernamePasswordLink() {
	//driver=DriverFactory.getDriver();
	loginPage= new LoginPage(driver);
	resetHlbConnectPage=loginPage.clickOnForgotUsernamePassword();
}

@Then("I m navigated to RESET HLB CONNECT screen")
public void iMNavigatedToRESETHLBCONNECTScreen() {
	resetHlbConnectPage.verifyPageTitle();
}

@Then("Using an Account Number option is displayed with Proceed button")
public void usingAnAccountNumberOptionIsDisplayedWithProceedButton() {
	resetHlbConnectPage.verifyUsingAcctNumOptionIsDisplayed();
	resetHlbConnectPage.verifyProceedBtnIsDisplayedForUsingAcctNum();
}

@Then("Using an ATM Card option is displayed with Proceed button")
public void usingAnATMCardOptionIsDisplayedWithProceedButton() {
	resetHlbConnectPage.verifyUsingATMCardOptionIsDisplayed();
	resetHlbConnectPage.verifyProceedBtnIsDisplayedForUsingATMCard();
}

@When("I click on Register for Online Banking button")
public void iClickOnRegisterForOnlineBankingButton() {
	//driver=DriverFactory.getDriver();
	loginPage= new LoginPage(driver);
	registerForOnlineBankingPage=loginPage.clickOnRegisterForOnlineBankingBtn();
}

@Then("I m navigated to REGISTER FOR ONLINE BANKING screen")
public void iMNavigatedToREGISTERFORONLINEBANKINGScreen() {
	registerForOnlineBankingPage.verifyPageTitle();
}


@Then("Using an Account Number option is displayed with Proceed button for online banking registration")
public void usingAnAccountNumberOptionIsDisplayedWithProceedButtonForOnlineBankingRegistration() {
	registerForOnlineBankingPage.verifyUsingAcctNumOptionIsDisplayed();
	registerForOnlineBankingPage.verifyProceedBtnIsDisplayedForUsingAcctNum();
}

@Then("Using an ATM Card option is displayed with Proceed button for online banking registration")
public void usingAnATMCardOptionIsDisplayedWithProceedButtonForOnlineBankingRegistration() {
	registerForOnlineBankingPage.verifyUsingATMCardOptionIsDisplayed();
	registerForOnlineBankingPage.verifyProceedBtnIsDisplayedForUsingATMCard();
}

@When("I click on Terms & Conditions link")
public void iClickOnTermsConditionsLink() {
	//driver=DriverFactory.getDriver();
	//loginPage= new LoginPage(driver);
	loginPage.clickOnTermsAndConditinsLink();
}

@Then("Terms and conditions are displayed in another new tab")
public void termsAndConditionsAreDisplayedInAnotherNewTab() {
	try {
		termsAndConditionsPage.verifyTermsAndConditionsPageTitle();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

@When("I click on Privacy Policy link")
public void iClickOnPrivacyPolicyLink() {
	//driver=DriverFactory.getDriver();
	loginPage= new LoginPage(driver);
	loginPage.clickOnPrivacyPolicyLink();
}

@Then("Privacy policy displayed in another new tab")
public void privacyPolicyDisplayedInAnotherNewTab() {
	try {
		privacyPolicyPage.verifyPrivacyPolicypageTitle();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

@When("I click on Security Policy link")
public void iClickOnSecurityPolicyLink() {
	//driver=DriverFactory.getDriver();
	//loginPage= new LoginPage(driver);
	loginPage.clickOnSecurityPolicyLink();
}

@Then("Security Policy displayed in another new tab")
public void securityPolicyDisplayedInAnotherNewTab() {
	try {
		securityPolicyPage.verifySecurityPolicyPageTitle();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

@When("I click on FAQ link")
public void iClickOnFAQLink() {
	//driver=DriverFactory.getDriver();
	//loginPage= new LoginPage(driver);
	loginPage.clickOnFAQLink();
}

@Then("FAQ displayed in another new tab")
public void faqDisplayedInAnotherNewTab() {
	try {
		faqPage.verifyFAQPageTitle();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
	
}
