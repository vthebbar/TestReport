package com.qa.stepDef;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.LoginPage;
import com.qa.pages.RegisterForOnlineBankingPage;

import io.cucumber.java.en.*;

public class S005_RegisterWithATMCardStepDef {

	private WebDriver driver;
	private LoginPage loginPage;
	private RegisterForOnlineBankingPage registerForOnlineBankingPage;
	public S005_RegisterWithATMCardStepDef(TestContext context) {
		driver = context.driver;
		loginPage = PageObjectFactory.getLoginPage(driver);
		registerForOnlineBankingPage = PageObjectFactory.getRegisterForOnlineBankingPage(driver);
	}
	
	

@When("I m navigated to Enter Details Section by choosing registration using an ATM Card")
public void iMNavigatedToEnterDetailsSectionByChoosingRegistrationUsingAnATMCard() {
	loginPage.clickOnRegisterForOnlineBankingBtn();
	registerForOnlineBankingPage.clickOnProceedBtnUsingATMCard();
}

@Then("verify that all field names and input fields are displayed in the screen for registration using an ATM Card")
public void verifyThatAllFieldNamesAndInputFieldsAreDisplayedInTheScreenForRegistrationUsingAnATMCard() {
	registerForOnlineBankingPage.verifyAllLablesAndInputFieldsAreDisplayedForRegUsingATMCard();
}

//TC03
@When("I click on Next button in Enter Details section of register using an ATM Card")
public void iClickOnNextButtonInEnterDetailsSectionOfRegisterUsingAnATMCard() {
	registerForOnlineBankingPage.clickOnNextBtnForRegisterUsingATMCard();
}


@Then("Following error messages are displayed for input fields for registration using ATM Card")
public void followingErrorMessagesAreDisplayedForInputFieldsForRegistrationUsingATMCard(io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
	
	List<Map<String, String>> errorMessages = dataTable.asMaps();
   
	registerForOnlineBankingPage.verifyBlankFieldErrMsgForCardNo(errorMessages.get(0).get("Card No."));
	registerForOnlineBankingPage.verifyBlankFieldErrMsgForCardPIN(errorMessages.get(0).get("Card PIN"));
	registerForOnlineBankingPage.verifyBlankFieldErrorMessageForIDType(errorMessages.get(0).get("ID Type"));
	registerForOnlineBankingPage.verifyBlankFieldErrorMessageForIdNum(errorMessages.get(0).get("ID No."));
	registerForOnlineBankingPage.verifyBlankFieldErrorMessageForCaptcha(errorMessages.get(0).get("Captcha"));
}

@When("key in the value {string} for Card No. field")
public void keyInTheValueForCardNoField(String cardNo) {
	registerForOnlineBankingPage.keyInValueToCardNo(cardNo);
    
}

@Then("Error message {string} is displayed correctly for Card No. field")
public void errorMessageIsDisplayedCorrectlyForCardNoField(String errMsg) {
	registerForOnlineBankingPage.verifyErrorMessageForInvalidCardNumber(errMsg);
}



}
