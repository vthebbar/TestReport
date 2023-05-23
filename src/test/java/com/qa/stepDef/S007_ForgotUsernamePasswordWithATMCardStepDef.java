package com.qa.stepDef;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.LoginPage;
import com.qa.pages.RegisterForOnlineBankingPage;

import io.cucumber.java.en.*;

public class S007_ForgotUsernamePasswordWithATMCardStepDef {

	private WebDriver driver;
	private LoginPage loginPage;
	private RegisterForOnlineBankingPage registerForOnlineBankingPage
;	
	public S007_ForgotUsernamePasswordWithATMCardStepDef(TestContext context) {
		
		driver = context.driver;
		loginPage=PageObjectFactory.getLoginPage(driver);
		registerForOnlineBankingPage = PageObjectFactory.getRegisterForOnlineBankingPage(driver);
	}
	
	

@When("I m navigated to Enter Details Section of RESET HLB CONNECT screen using an ATM Card option")
public void iMNavigatedToEnterDetailsSectionOfRESETHLBCONNECTScreenUsingAnATMCardOption() {
	loginPage.clickOnForgotUsernamePassword();
	registerForOnlineBankingPage.clickOnProceedBtnUsingATMCard();
}

@Then("verify that all field names and input fields are displayed in the screen for RESET HLB CONNECT using an ATM Card")
public void verifyThatAllFieldNamesAndInputFieldsAreDisplayedInTheScreenForRESETHLBCONNECTUsingAnATMCard() {
	registerForOnlineBankingPage.verifyAllLablesAndInputFieldsAreDisplayedForRegUsingATMCard();
}

@Then("Following error messages are displayed for input fields for RESET HLB CONNECT using ATM Card")
public void followingErrorMessagesAreDisplayedForInputFieldsForRESETHLBCONNECTUsingATMCard(io.cucumber.datatable.DataTable dataTable) {
	List<Map<String, String>> errorMessages = dataTable.asMaps();
	   
	registerForOnlineBankingPage.verifyBlankFieldErrMsgForCardNo(errorMessages.get(0).get("Card No."));
	registerForOnlineBankingPage.verifyBlankFieldErrMsgForCardPIN(errorMessages.get(0).get("Card PIN"));
	registerForOnlineBankingPage.verifyBlankFieldErrorMessageForIDType(errorMessages.get(0).get("ID Type"));
	registerForOnlineBankingPage.verifyBlankFieldErrorMessageForIdNum(errorMessages.get(0).get("ID No."));
	registerForOnlineBankingPage.verifyBlankFieldErrorMessageForCaptcha(errorMessages.get(0).get("Captcha"));
}
}
