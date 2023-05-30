package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.ESaverCloseAccountPage;
import com.qa.pages.HomePage;

import io.cucumber.java.en.*;

public class S027_Esaver5StepDef {
	
	private WebDriver driver;
	private HomePage homePage;
	private ESaverCloseAccountPage eSaverCloseAccountPage;
	
	public S027_Esaver5StepDef(TestContext context) {
		
		driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		eSaverCloseAccountPage = PageObjectFactory.getESaverCloseAccountPage(driver);
	}
	
	
	//TC01
	
	@Given("I m navigated to E-Saver Close Account screen")
	public void iMNavigatedToESaverCloseAccountScreen() {
		homePage.clickonESaverMenu();
		homePage.clickOnEsaverCloseAccountSubMenu();
	}

	@Given("I select the Transfer Type {string} in E-Saver Close Account - Enter Details Section")
	public void iSelectTheTransferTypeInESaverCloseAccountEnterDetailsSection(String transferType) {
		eSaverCloseAccountPage.selectTransferType(transferType);
	}

	@Then("Verify above specified fields are displayed in  E-Saver Close Account - Enter Details Section")
	public void verifyAboveSpecifiedFieldsAreDisplayedInESaverCloseAccountEnterDetailsSection() {
		eSaverCloseAccountPage.verifyEnterDetailsSection();
	}
	
	
	//TC02
	@When("I select the Account Number {string} in E-Saver Close Account - Enter Details Section")
	public void iSelectTheAccountNumberInESaverCloseAccountEnterDetailsSection(String acctNumIndex) {
		int index=Integer.parseInt(acctNumIndex);
		eSaverCloseAccountPage.selectAccountNum(index);
	}

	@When("I select the Own Account Number {string} in E-Saver Close Account - Enter Details Section")
	public void iSelectTheOwnAccountNumberInESaverCloseAccountEnterDetailsSection(String ownAcctVal) {
		int index=Integer.parseInt(ownAcctVal);
		eSaverCloseAccountPage.seletOwnAcctNumForTransfer(index);
	}

	@When("I click on Next button in E-Saver Close Account - Enter Details Section")
	public void iClickOnNextButtonInESaverCloseAccountEnterDetailsSection() {
		eSaverCloseAccountPage.clickOnNextBtn();
	}

	@Then("Verify the error message displayed in E-Saver Close Account - Enter Details Section")
	public void verifyTheErrorMessageDisplayedInESaverCloseAccountEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		eSaverCloseAccountPage.verifyErrorMessage(dataTable.asList().get(0));
	}
	
	//TC03
	

	@When("I select the Reason for Closing {string} in E-Saver Close Account - Enter Details Section")
	public void iSelectTheReasonForClosingInESaverCloseAccountEnterDetailsSection(String reason) {
	eSaverCloseAccountPage.selectReasonForClosing(reason);
	}
	
	
	//TC04
	@Then("Verify E-Saver Close Account - Confirm Details Section")
	public void verifyESaverCloseAccountConfirmDetailsSection() {
		eSaverCloseAccountPage.verifyConfirmDetailsSection();
	}
	
	//TC05
	@When("I click on Submit button in E-Saver Close Account - Confirm Details Section")
	public void iClickOnSubmitButtonInESaverCloseAccountConfirmDetailsSection() {
		eSaverCloseAccountPage.clickOnSubmitBtn();
	}

	@Then("Verify the success mesage in E-Saver Close Account - Acknowledgement Section")
	public void verifyTheSuccessMesageInESaverCloseAccountAcknowledgementSection(io.cucumber.datatable.DataTable dataTable) {
		eSaverCloseAccountPage.verifySuccessMesage(dataTable.asList().get(0));
	}

	@Then("Verify the other details in E-Saver Close Account - Acknowledgement Section")
	public void verifyTheOtherDetailsInESaverCloseAccountAcknowledgementSection() {
		eSaverCloseAccountPage.verifyAcknowledgementDetailsAreDisplayed();
	}

	@Then("I click on Done button in E-Saver Close Account - Acknowledgement Section")
	public void iClickOnDoneButtonInESaverCloseAccountAcknowledgementSection() {
		eSaverCloseAccountPage.clickOnDoneBtn();
	}
	
	//TC06
	@Then("Verify above specified fields are displayed in  E-Saver Close Account - Enter Details Section third party transfer")
	public void verifyAboveSpecifiedFieldsAreDisplayedInESaverCloseAccountEnterDetailsSectionThirdPartyTransfer() {
		eSaverCloseAccountPage.verifyEnterDetailsThirdPartyTransfer();
	}

	//TC07
	@When("I select the Account category {string} in E-Saver Close Account - Enter Details Section")
	public void iSelectTheAccountCategoryInESaverCloseAccountEnterDetailsSection(String category) {
		eSaverCloseAccountPage.selectAcctCategoryRadioBtn(category);
	}

	@When("I key in To Account {string} in E-Saver Close Account - Enter Details Section")
	public void iKeyInToAccountInESaverCloseAccountEnterDetailsSection(String toAcct) {
		eSaverCloseAccountPage.keyInToAcct(toAcct);
	}

	@When("I clear the value in Recipient Reference field in E-Saver Close Account - Enter Details Section")
	public void iClearTheValueInRecipientReferenceFieldInESaverCloseAccountEnterDetailsSection() {
		eSaverCloseAccountPage.clearRecRefField();
	}
	
	//TC08
	@When("I key in the value {string} in Recipient Reference field in E-Saver Close Account - Enter Details Section")
	public void iKeyInTheValueInRecipientReferenceFieldInESaverCloseAccountEnterDetailsSection(String refRef) {
		eSaverCloseAccountPage.keyInRecipientRef(refRef);
	}

	@When("I key in the value {string} in Description field in E-Saver Close Account - Enter Details Section")
	public void iKeyInTheValueInDescriptionFieldInESaverCloseAccountEnterDetailsSection(String desc) {
		eSaverCloseAccountPage.keyInDescription(desc);
	}

	@Then("Verify the  E-Saver Close Account - Confirm Details Section for third party account transfer")
	public void verifyTheESaverCloseAccountConfirmDetailsSectionForThirdPartyAccountTransfer() {
		eSaverCloseAccountPage.verifyConfirmDetailsSectionThirdPartyTransfer();
	}
	
	//TC09
	@When("I key in TAC in  E-Saver Close Account - Confirm Details Section")
	public void iKeyInTACInESaverCloseAccountConfirmDetailsSection() {
		eSaverCloseAccountPage.keyInValidTac();
	}

	@Then("Verify the other details in E-Saver Close Account - Acknowledgement Section - third party")
	public void verifyTheOtherDetailsInESaverCloseAccountAcknowledgementSectionThirdParty() {
		eSaverCloseAccountPage.verifyAcknowledgementSectionThirdPartyTransfer();
	}

	//TC10
	@When("I select Favourite To Account {string} in E-Saver Close Account - Enter Details Section")
	public void iSelectFavouriteToAccountInESaverCloseAccountEnterDetailsSection(String index) {
	    
		int indexVal = Integer.parseInt(index);
		eSaverCloseAccountPage.selectFavToAcct(indexVal);
	}
	
	//TC12
	@When("I key in invalid TAC in  E-Saver Close Account - Confirm Details Section")
	public void iKeyInInvalidTACInESaverCloseAccountConfirmDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		eSaverCloseAccountPage.keyInInvalidTac(dataTable.asList().get(0));
	}

	@Then("Verify the error mesage in E-Saver Close Account - Confirm Details Section")
	public void verifyTheErrorMesageInESaverCloseAccountConfirmDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		eSaverCloseAccountPage.verifyInvalidTacErrMsg(dataTable.asList().get(0));
	}

}
