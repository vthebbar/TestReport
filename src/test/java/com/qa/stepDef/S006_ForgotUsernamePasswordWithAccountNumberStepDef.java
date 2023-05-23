package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.LoginPage;
import com.qa.pages.RegisterForOnlineBankingPage;

import io.cucumber.java.en.*;

public class S006_ForgotUsernamePasswordWithAccountNumberStepDef {

	private WebDriver driver;
	LoginPage loginPage;
	RegisterForOnlineBankingPage registerForOnlineBankingPage;
	
	public S006_ForgotUsernamePasswordWithAccountNumberStepDef(TestContext context) {
		driver = context.driver;
		loginPage = PageObjectFactory.getLoginPage(driver);
		registerForOnlineBankingPage = PageObjectFactory.getRegisterForOnlineBankingPage(driver);
				
	}
	
	@When("I m navigated to RESET HLB CONNECT page")
	public void iMNavigatedToRESETHLBCONNECTPage() {
		loginPage.clickOnForgotUsernamePassword();
	}

	@When("I m navigated to Enter Details Section of RESET HLB CONNECT by choosing, Using an Account Number")
	public void iMNavigatedToEnterDetailsSectionOfRESETHLBCONNECTByChoosingUsingAnAccountNumber() {
		loginPage.clickOnForgotUsernamePassword();
		registerForOnlineBankingPage.clickOnProeedBtnForUsingAccountNumber();
	}

}
