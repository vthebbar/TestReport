package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.ESaverCreateAccountPage;
import com.qa.pages.HomePage;

import io.cucumber.java.en.*;

public class S024_Esaver2StepDef {

	private WebDriver driver;
	private HomePage homePage;
	private ESaverCreateAccountPage eSaverCreateAccountPage;
	
	public S024_Esaver2StepDef(TestContext context) {
		driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		eSaverCreateAccountPage = PageObjectFactory.getESaverCreateAccountPage(driver);
	}
	
	//TC01
	@Given("I m navigated to E-Saver Create Account screen")
	public void iMNavigatedToESaverCreateAccountScreen() {
		homePage.clickonESaverMenu();
		homePage.clickOnEsaverCreateAccount();
	}

	@Then("Verify all fields specified above are displayed in the screen")
	public void verifyAllFieldsSpecifiedAboveAreDisplayedInTheScreen() {
		eSaverCreateAccountPage.verifyEnterDetailsSectionElementsAreDisplayed();
	}

	//TC02
	
	@When("I select, key in the details {string} , {string} , {string} , {string} in E-Saver Create Account - Enter Details section")
	public void iSelectKeyInTheDetailsInESaverCreateAccountEnterDetailsSection(String acctName, String debitAcct, String amt, String desc) {
		eSaverCreateAccountPage.keyInAcctName(acctName);
		eSaverCreateAccountPage.selectDebitingAcct(debitAcct);
		eSaverCreateAccountPage.keyInAmount(amt);
		eSaverCreateAccountPage.keyInDesc(desc);
	}

	@When("I Select checkboxes for Product Term Sheet , Terms and Conditions in E-Saver Create Account - Enter Details section")
	public void iSelectCheckboxesForProductTermSheetTermsAndConditionsInESaverCreateAccountEnterDetailsSection() {
		eSaverCreateAccountPage.selectTermSheetCheckbkx();
		eSaverCreateAccountPage.selectTnCCheckbox();
	}

	@When("I click on Next button in E-Saver Create Account - Enter Details section")
	public void iClickOnNextButtonInESaverCreateAccountEnterDetailsSection() {
		eSaverCreateAccountPage.clickOnNextBtn();
	}

	@Then("Verify the error message in E-Saver Create Account - Enter Details section")
	public void verifyTheErrorMessageInESaverCreateAccountEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		eSaverCreateAccountPage.verifyErrMsg(dataTable.asList().get(0));
	}
	
	//TC03
	@When("I select, key in the details {string} , {string} , {string} in E-Saver Create Account - Enter Details section")
	public void iSelectKeyInTheDetailsInESaverCreateAccountEnterDetailsSection(String debitAcct, String amt, String desc) {
		eSaverCreateAccountPage.selectDebitingAcct(debitAcct);
		eSaverCreateAccountPage.keyInAmount(amt);
		eSaverCreateAccountPage.keyInDesc(desc);
	}
	
	@Then("Verify the error message in E-Saver Create Account - Enter Details section for Account Name field")
	public void verifyTheErrorMessageInESaverCreateAccountEnterDetailsSectionForAccountNameField(io.cucumber.datatable.DataTable dataTable) {
		eSaverCreateAccountPage.verifyNoInputForFieldsErrMsg(dataTable.asList().get(0));
	}
	
	//TC04
	

@When("I select or key in the details {string} , {string} , {string} in E-Saver Create Account - Enter Details section-")
public void iSelectOrKeyInTheDetailsInESaverCreateAccountEnterDetailsSection(String acctName, String debitAcct, String desc) {
	eSaverCreateAccountPage.keyInAcctName(acctName);
	eSaverCreateAccountPage.selectDebitingAcct(debitAcct);
	eSaverCreateAccountPage.keyInDesc(desc);
}

	
	@Then("Verify the error message in E-Saver Create Account - Enter Details section for amount field")
	public void verifyTheErrorMessageInESaverCreateAccountEnterDetailsSectionForAmountField(io.cucumber.datatable.DataTable dataTable) {
		eSaverCreateAccountPage.verifyNoInputForFieldsErrMsg(dataTable.asList().get(0));
	}
	
	//TC05
	@Then("Verify the E-Saver Create Account - Confirm Details section")
	public void verifyTheESaverCreateAccountConfirmDetailsSection() {
		eSaverCreateAccountPage.verifyConfirmDetailsSection();
	}

//TC06
	
	@When("I key in invalid TAC in E-Saver Create Account - Confirm Details section")
	public void iKeyInInvalidTACInESaverCreateAccountConfirmDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		eSaverCreateAccountPage.keyInInvalidTac(dataTable.asList().get(0));
	}

	@When("I click on Submit button in E-Saver Create Account - Confirm Details section")
	public void iClickOnSubmitButtonInESaverCreateAccountConfirmDetailsSection() {
		eSaverCreateAccountPage.clickOnSubmitBtn();
	}

	@Then("Verify the error message in E-Saver Create Account - Confirm Details section")
	public void verifyTheErrorMessageInESaverCreateAccountConfirmDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		eSaverCreateAccountPage.verifyErrMsg(dataTable.asList().get(0));
	}
	
	//TC07
	@When("I key in valid TAC in E-Saver Create Account - Confirm Details section")
	public void iKeyInValidTACInESaverCreateAccountConfirmDetailsSection() {
		eSaverCreateAccountPage.keyInValidTac();
	}

	@Then("Verify the success message in E-Saver Create Account - Acknowledgement section")
	public void verifyTheSuccessMessageInESaverCreateAccountAcknowledgementSection(io.cucumber.datatable.DataTable dataTable) {
		eSaverCreateAccountPage.verifySuccessMsg(dataTable.asList().get(0));
	}

	@Then("Verify the other details in E-Saver Create Account - Acknowledgement section")
	public void verifyTheOtherDetailsInESaverCreateAccountAcknowledgementSection() {
		eSaverCreateAccountPage.verifyActknowledgementSection();
	}

	@Then("I click on Done button in E-Saver Create Account - Acknowledgement section")
	public void iClickOnDoneButtonInESaverCreateAccountAcknowledgementSection() {
		eSaverCreateAccountPage.clickOnDoneBtn();
	}

	
	
}
