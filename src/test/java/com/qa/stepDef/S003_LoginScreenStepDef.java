package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;

import io.cucumber.java.en.*;

public class S003_LoginScreenStepDef {

	WebDriver driver;
  LoginPage loginPage;
	
@Then("Username, Password and Login button are displayed")
public void usernamePasswordAndLoginButtonAreDisplayed() {
	driver=DriverFactory.getDriver();
	loginPage= new LoginPage(driver);
	
	loginPage.verifyUsernameFieldIsDisplayed();
	loginPage.verifyPasswordFieldIsDisplayed();
	loginPage.verifyLoginBtnIsDisplayed();
}

@When("I click on Forgot username\\/password link")
public void iClickOnForgotUsernamePasswordLink() {
    
}

@Then("I m navigated to RESET HLB CONNECT screen")
public void iMNavigatedToRESETHLBCONNECTScreen() {
    
}

@Then("Using an Account Number option is displayed with Proceed button")
public void usingAnAccountNumberOptionIsDisplayedWithProceedButton() {
    
}

@Then("Using an ATM Card option is displayed with Proceed button")
public void usingAnATMCardOptionIsDisplayedWithProceedButton() {
    
}

@When("I click on Register for Online Banking button")
public void iClickOnRegisterForOnlineBankingButton() {
   
}

@Then("I m navigated to REGISTER FOR ONLINE BANKING screen")
public void iMNavigatedToREGISTERFORONLINEBANKINGScreen() {
  
}

@When("I click on Terms & Conditions link")
public void iClickOnTermsConditionsLink() {
  
}

@Then("Terms and conditions are displayed in another new tab")
public void termsAndConditionsAreDisplayedInAnotherNewTab() {
    
}

@When("I click on Privacy Policy link")
public void iClickOnPrivacyPolicyLink() {
   
}

@Then("Privacy policy displayed in another new tab")
public void privacyPolicyDisplayedInAnotherNewTab() {
   
}

@When("I click on Security Policy link")
public void iClickOnSecurityPolicyLink() {
    
}

@Then("Security Policy displayed in another new tab")
public void securityPolicyDisplayedInAnotherNewTab() {
    
}

@When("I click on FAQ link")
public void iClickOnFAQLink() {
   
}

@Then("FAQ displayed in another new tab")
public void faqDisplayedInAnotherNewTab() {
   
}
	
}
