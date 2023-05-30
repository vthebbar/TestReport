package com.qa.stepDef;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.LoginPage;
import com.qa.pages.RegisterForOnlineBankingPage;

import io.cucumber.java.en.*;

public class S004_RegisterWithAccountNumberStepDef {
	private WebDriver driver;
	private LoginPage loginPage;
	private RegisterForOnlineBankingPage registerForOnlineBankingPage;
	
	public S004_RegisterWithAccountNumberStepDef(TestContext context) {
		driver = context.driver;
		loginPage = PageObjectFactory.getLoginPage(driver);
		registerForOnlineBankingPage = PageObjectFactory.getRegisterForOnlineBankingPage(driver);
	}
	
	@When("I m navigated to Registration page")
	public void iMNavigatedToRegistrationPage() {
		registerForOnlineBankingPage=loginPage.clickOnRegisterForOnlineBankingBtn();
	}

	@Then("Two options for registration option1 and option2 are displayed")
	public void twoOptionsForRegistrationOption1AndOption2AreDisplayed(io.cucumber.datatable.DataTable dataTable) {
	
		List<Map<String,String>>  x = dataTable.asMaps();
		registerForOnlineBankingPage.verifyAcctNumOptionIsDisplayed(x.get(0).get("option1"));
		registerForOnlineBankingPage.verifyATMOptionIsDisplayed(x.get(0).get("option2"));

	}

	//TC02 to TC05
	@When("I m navigated to Enter Details Section by choosing registration using Account Number")
	public void iMNavigatedToEnterDetailsSectionByChoosingRegistrationUsingAccountNumber() {
		loginPage.clickOnRegisterForOnlineBankingBtn();
		registerForOnlineBankingPage.clickOnProeedBtnForUsingAccountNumber();
	}

	@Then("verify that all field names and input fields are displayed in the screen")
	public void verifyThatFollowingFieldsAreDisplayedInTheScreen() {
		registerForOnlineBankingPage.verifyAllLablesAndInputFieldsAreDisplayed();
	}

	@Then("Following options are available for Account Type drop down field")
	public void followingOptionsAreAvailableForAccountTypeDropDownField(io.cucumber.datatable.DataTable dataTable) {
	   
			List<String> expValues = dataTable.asList();
			registerForOnlineBankingPage.verifyAccountTypeDropDownOptions(expValues);
	}

	@Then("Following options are available for ID Type drop down field")
	public void followingOptionsAreAvailableForIDTypeDropDownField(io.cucumber.datatable.DataTable dataTable) {
	  List<String> expValues = dataTable.asList();
	  registerForOnlineBankingPage. verifyIDTypeDropDownValues(expValues);
	    
	}

	@When("I click on Next button")
	public void iClickOnNextButton() {
		registerForOnlineBankingPage.clickOnNextBtn();
	}

	@Then("Following error messages are displayed for input fields")
	public void followingErrorMessagesAreDisplayedForInputFields(io.cucumber.datatable.DataTable dataTable) {
	  
		List<Map<String,String>> errorMessages=dataTable.asMaps();
		registerForOnlineBankingPage.verifyBlankFieldErrorMessageForAcctType(errorMessages.get(0).get("Account Type"));
		registerForOnlineBankingPage.verifyBlankFieldErrorMessageForAcctNum(errorMessages.get(0).get("Account No."));
		
		registerForOnlineBankingPage.verifyBlankFieldErrorMessageForIDType(errorMessages.get(0).get("ID Type"));
		registerForOnlineBankingPage.verifyBlankFieldErrorMessageForIdNum(errorMessages.get(0).get("ID No."));
		
		registerForOnlineBankingPage.verifyBlankFieldErrorMessageForTempId(errorMessages.get(0).get("Temporary ID"));
		registerForOnlineBankingPage.verifyBlankFieldErrorMessageForCaptcha(errorMessages.get(0).get("Captcha"));
	}

	
	//TC06, TC07
	@When("key in the value {string} for account number field")
	public void keyInTheValueForAccountNumberField(String acctNum) {
		registerForOnlineBankingPage.keyInAccountNumber(acctNum);
	}


	@When("key in the value {string} for Temporary field")
	public void keyInTheValueForTemporaryField(String tempId) {
		registerForOnlineBankingPage.keyInTemporaryID(tempId);
	}

	@Then("Error message {string} is displayed correctly for account number field")
	public void errorMessageInvalidAccountNumberFormatIsDisplayedCorrectlyForAccountNumberField(String expVal) {
		registerForOnlineBankingPage.verifyErrMsgForAcctNumField(expVal);
	}

	@Then("Error message {string} is displayed correctly for Temporary ID field")
	public void errorMessageInvalidTemporaryIDFormatIsDisplayedCorrectlyForTemporaryIDField(String expVal) {
		registerForOnlineBankingPage.verifyErrMsgForTempIdField(expVal);
	}

}
