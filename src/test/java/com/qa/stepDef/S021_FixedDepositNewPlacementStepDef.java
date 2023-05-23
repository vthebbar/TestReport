package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.FixedDepositPlacementPage;
import com.qa.pages.HomePage;
import com.qa.utils.PropertyManager;
import com.qa.utils.TACManager;

import io.cucumber.java.en.*;

public class S021_FixedDepositNewPlacementStepDef {
	
	private WebDriver driver;
	private HomePage homePage;
	private FixedDepositPlacementPage fixedDepositPlacementPage;
	
	public S021_FixedDepositNewPlacementStepDef(TestContext context) {
		driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		fixedDepositPlacementPage = PageObjectFactory.getFixedDepositPlacementPage(driver);
	}
	
	//TC01
	
	@Given("I m navigated to Fixed Deposit New Placement screen - Enter Details section")
	public void iMNavigatedToFixedDepositNewPlacementScreenEnterDetailsSection() {
		homePage.clickOnPayAndTransact();
		homePage.clickOnNewPlacement();
	}

	@Then("Verify all fields are displayed in New Placement - Enter Details section")
	public void verifyAllFieldsAreDisplayedInNewPlacementEnterDetailsSection() {
		fixedDepositPlacementPage.verifyAllFieldsDisplayedInDetailsEntrySection();
	}
	
	//TC02
	@When("I click on here link in Fixed Deposit New Placement - Enter Details Section")
	public void iClickOnHereLinkInFixedDepositNewPlacementEnterDetailsSection() {
		fixedDepositPlacementPage.clickOnInterestRateLink();
	}

	@Then("New window is opened with title and url as given below")
	public void newWindowIsOpenedWithUrlAsGivenBelow(io.cucumber.datatable.DataTable dataTable) {
		fixedDepositPlacementPage.verifyNewWindowWithGivenUrlIsOpen(dataTable.asList().get(0), dataTable.asList().get(1));
	}

	//TC03
	@When("I select From account {string} in Fixed Deposit New Placement - Enter Details Section")
	public void iSelectFromAccountInFixedDepositNewPlacementEnterDetailsSection(String fromAcct) {
		fixedDepositPlacementPage.selectFromAccount(fromAcct);
	}

	@When("I key in principal amount {string} in Fixed Deposit New Placement - Enter Details Section")
	public void iKeyInPrincipalAmountInFixedDepositNewPlacementEnterDetailsSection(String amt) {
		fixedDepositPlacementPage.keyInAmount(amt);
	}

	@When("I Key in Remark {string} in Fixed Deposit New Placement - Enter Details Section")
	public void iKeyInRemarkInFixedDepositNewPlacementEnterDetailsSection(String remark) {
		fixedDepositPlacementPage.keyInRemarks(remark);
	}

	@When("I select Renewal Instruction {string} in Fixed Deposit New Placement - Enter Details Section")
	public void iSelectRenewalInstructionInFixedDepositNewPlacementEnterDetailsSection(String renInstr) {
		fixedDepositPlacementPage.selectRenewalInstruction(renInstr);
	}

	@When("I click on Next button in Fixed Deposit New Placement - Enter Details Section")
	public void iClickOnNextButtonInFixedDepositNewPlacementEnterDetailsSection() {
		fixedDepositPlacementPage.clickOnNextbtn();
	}

	@Then("Verify error message is displayed in Fixed Deposit New Placement - Enter Details Section")
	public void verifyErrorMessageIsDisplayedInFixedDepositNewPlacementEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		fixedDepositPlacementPage.verifyErrorMsg(dataTable.asList().get(0));
	}
	
	//TC04
	@When("I select Tenure {string} in Fixed Deposit New Placement - Enter Details Section")
	public void iSelectTenuretInFixedDepositNewPlacementEnterDetailsSection(String tenure) {
		fixedDepositPlacementPage.selectTenure(tenure);
	}
	
	//TC06
	@Then("Verify error message is displayed in Fixed Deposit New Placement - Enter Details Section - amount field")
	public void verifyErrorMessageIsDisplayedInFixedDepositNewPlacementEnterDetailsSectionAmountField(io.cucumber.datatable.DataTable dataTable) {
		fixedDepositPlacementPage.clickOnNextbtn();
		fixedDepositPlacementPage.verifyErrMsgAmountLessThanUSD1k(dataTable.asList().get(0));
		
	}
	//TC08
	@Then("Verify Fixed Deposit New Placement - Confirm Details Section")
	public void verifyFixedDepositNewPlacementConfirmDetailsSection() {
		fixedDepositPlacementPage.verifyConfirmScreen();
	}

	//TC09
	@When("I key in invalid tac {string} in Fixed Deposit New Placement - Confirmation Section")
	public void iKeyInInvalidTacInFixedDepositNewPlacementConfirmationSection(String invalidTac) {
		fixedDepositPlacementPage.keyInInvalidTac(invalidTac);
	}

	@When("I click on Submit button in Fixed Deposit New Placement - Confirmation Section")
	public void iClickOnSubmitButtonInFixedDepositNewPlacementConfirmationSection() {
		fixedDepositPlacementPage.clickOnSubmitBtn();
	}

	@Then("Verify the error message displayed in Fixed Deposit New Placement - Confirmation Section")
	public void verifyTheErrorMessageDisplayedInFixedDepositNewPlacementConfirmationSection(io.cucumber.datatable.DataTable dataTable) {
		fixedDepositPlacementPage.verifyErrMsgInConfirmScreen(dataTable.asList().get(0));
	}
	
	//TC10
	@When("I key in valid TAC in Fixed Deposit New Placement - Confirmation Section")
	public void iKeyInValidTACInFixedDepositNewPlacementConfirmationSection() {
		fixedDepositPlacementPage.keyInTac();
		
	}

	@Then("Verify the success message displayed in Fixed Deposit New Placement - Acknowledgement Section")
	public void verifyTheSuccessMessageDisplayedInFixedDepositNewPlacementAcknowledgementSection(io.cucumber.datatable.DataTable dataTable) {
		fixedDepositPlacementPage.verifySuccessMsginAcknowledgmentSection(dataTable.asList().get(0));
	}

	@Then("Verify other details displayed in Fixed Deposit New Placement - Acknowledgement Section")
	public void verifyOtherDetailsDisplayedInFixedDepositNewPlacementAcknowledgementSection() {
		fixedDepositPlacementPage.verifyAcknowledgementScreen();
	}

	@Then("I click in Make Another Placement button in Fixed Deposit New Placement - Acknowledgement Section")
	public void iClickInMakeAnotherPlacementButtonInFixedDepositNewPlacementAcknowledgementSection() {
		fixedDepositPlacementPage.clickOnDonebtn();
	}

	@Then("Fixed Deposit New Placement screen - Enter Details section is displayed")
	public void fixedDepositNewPlacementScreenEnterDetailsSectionIsDisplayed() {
		fixedDepositPlacementPage.verifyAllFieldsDisplayedInDetailsEntrySection();
	}
}
