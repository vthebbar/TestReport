package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.HomePage;
import com.qa.pages.TransferToOwnAccountPage;

import io.cucumber.java.en.*;

public class S014_Transfer1StepDef {

	private WebDriver driver;
	private HomePage homePage;
	private TransferToOwnAccountPage transferToOwnAccountPage;
	
	public S014_Transfer1StepDef(TestContext context) {
		driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		transferToOwnAccountPage = PageObjectFactory.getTransferToOwnAccountPage(driver);
	}
	
	//TC01
	@When("I m navigated to Transfer to Own Account screen")
	public void iMNavigatedToTransferToOwnAccountScreen() {
		homePage.clickOnPayAndTransact();
		homePage.clickOnTransferToOwnAcct();
	}

	@When("Select From account in Transfer to Own Account - Enter Details section")
	public void selectFromAccount(io.cucumber.datatable.DataTable dataTable) {
	   
		String visibleText = dataTable.asList().get(0);
		transferToOwnAccountPage.seletFromDropDown(visibleText);
		
	}

	@When("Select To account in Transfer to Own Account - Enter Details section")
	public void selectToAccount(io.cucumber.datatable.DataTable dataTable) {
		String visibleText = dataTable.asList().get(0);
		try {
		transferToOwnAccountPage.selectToDropDown(visibleText);
		}
		catch(Exception e) {
			transferToOwnAccountPage.selectToDropDown(visibleText);
		}
	}

	@Then("Verify all fields specified above are displayed")
	public void verifyAllFieldsSpecifiedAboveAreDisplayed() {
		transferToOwnAccountPage.verifyTransferToOwnAccountEnterDetailsSection();
	}
	
	//TC02
	
	@When("Key in the amount to transfer in Transfer to Own Account - Enter Details section")
	public void keyInTheAmountToTransferInTransferToOwnAccountEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		transferToOwnAccountPage.keyInAmount(dataTable.asList().get(0).trim());
	}

	@When("Key in Description in Transfer to Own Account - Enter Details section")
	public void keyInDescriptionInTransferToOwnAccountEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		transferToOwnAccountPage.keyInDesc(dataTable.asList().get(0).trim());
	}

	@When("Select One Time Transfer in Transfer to Own Account - Enter Details section")
	public void selectOneTimeTransferInTransferToOwnAccountEnterDetailsSection() {
		transferToOwnAccountPage.selectOneTimeTransferRadioBtn();
	}

	@When("Select Date of Transfer in Transfer to Own Account - Enter Details section")
	public void selectDateOfTransferInTransferToOwnAccountEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		
		//transferToOwnAccountPage.keyInDate(dataTable.asList().get(0).trim());
		
		transferToOwnAccountPage.selectDate(dataTable.asList().get(0).trim());
	}

	@When("Click on Next button in Transfer to Own Account - Enter Details section")
	public void clickOnNextButtonInTransferToOwnAccountEnterDetailsSection() {
		transferToOwnAccountPage.clickOnNextBtn();
	}

	@Then("Verify the fields displayed in Transfer to Own Account - Confirm Details section")
	public void verifyTheFieldsDisplayedInTransferToOwnAccountConfirmDetailsSection() {
		transferToOwnAccountPage.verifyConfirmDetailsSectionElementsAreDisplayed();
	}

	//TC03
	
	@When("Click on Submit button in Transfer to Own Account - Confirm Details section")
	public void clickOnSubmitButtonInTransferToOwnAccountConfirmDetailsSection() {
		transferToOwnAccountPage.clickOnSubmitBtn();
	}

	@Then("Verify the acknowledgement message in Transfer to Own Account - Acknowledgment section")
	public void verifyTheAcknowledgementMessageInTransferToOwnAccountAcknowledgmentSection(io.cucumber.datatable.DataTable dataTable) {
		String expMsg = dataTable.asList().get(0);
		transferToOwnAccountPage.verifyAcknowledgmentMessage(expMsg);
	}

	@Then("Verify Acknowlegdement details are displayed as specified")
	public void verifyAcknowlegdementDetailsAreDisplayedAsSpecified() {
		transferToOwnAccountPage.verifyAcknowledgementDetailsAreDisplayed();
	}

	@Then("Click on Done button in Transfer to Own Account - Acknowledgment section")
	public void clickOnDoneButtonInTransferToOwnAccountAcknowledgmentSection() {
		transferToOwnAccountPage.clickOnDoneBtn();
	}
	
	//TC04
	@Then("Click on Make Another Transfer button in Transfer to Own Account - Acknowledgment section")
	public void clickOnMakeAnotherTransferButtonInTransferToOwnAccountAcknowledgmentSection() {
		transferToOwnAccountPage.clickOnMakeAnotherTransferBtn();
	}

	@Then("I m navigated to Transfer to Own Account screen - Enter Details section")
	public void iMNavigatedToTransferToOwnAccountScreenEnterDetailsSection() {
		transferToOwnAccountPage.verifyEnterDetailsSectionHeaderIsDisplayed();
	}
	
	//TC05
	
	@When("Select Recurring Transfer radio button")
	public void selectRecurringTransferRadioButton() {
		transferToOwnAccountPage.selectRecurringTransferRadioBtn();
	}

	@Then("Verify all fields specified above are displayed for recurring transfer")
	public void verifyAllFieldsSpecifiedAboveAreDisplayedForRecurringTransfer() {
		transferToOwnAccountPage.verifyTransferToOwnAccountEnterDetailsSectionRecurring();
	}
	
	//TC06
	
	@When("Select Recurring Transfer in Transfer to Own Account - Enter Details section")
	public void selectRecurringTransferInTransferToOwnAccountEnterDetailsSection() {
		transferToOwnAccountPage.selectRecurringTransferRadioBtn();

	}

	@When("Select Starting From date in Transfer to Own Account - Enter Details section")
	public void selectStartingFromDateInTransferToOwnAccountEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		//transferToOwnAccountPage.selectStartingFromDate(dataTable.asList().get(0));
		transferToOwnAccountPage.selectDate(dataTable.asList().get(0).trim());
	}

	@When("Select Repeat frequency in Transfer to Own Account - Enter Details section")
	public void selectRepeatFrequencyInTransferToOwnAccountEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		transferToOwnAccountPage.selectRepeatFrequency(dataTable.asList().get(0).trim());
	}

	@When("Key in number of times in Transfer to Own Account - Enter Details section")
	public void keyInNumberOfTimesInTransferToOwnAccountEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		transferToOwnAccountPage.KeyInNumberOfTimes(dataTable.asList().get(0).trim());
	}

	@Then("Verify the fields displayed for Recurring Transfer in Transfer to Own Account - Confirm Details section")
	public void verifyTheFieldsDisplayedForRecurringTransferInTransferToOwnAccountConfirmDetailsSection() {
		transferToOwnAccountPage.verifyRecurringConfirmDetailsSectionElementsAreDisplayed();
	}
	
	//TC07
	@Then("Verify Acknowlegdement details are displayed for Recurring Transfer as specified")
	public void verifyAcknowlegdementDetailsAreDisplayedForRecurringTransferAsSpecified() {
		transferToOwnAccountPage.verifyRecurringTransferAcknowledgementDetailsAreDisplayed();
	}
	
	//TC09
	@Then("Verify the error message displayed for Amount field in Transfer to Own Account - Enter Details section")
	public void verifyTheErrorMessageDisplayedForAmountFieldInTransferToOwnAccountEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		transferToOwnAccountPage.verifyErrorMsg(dataTable.asList().get(0).trim());
	}
	
	//TC10
	
	@Then("Verify the error message displayed for Description field in Transfer to Own Account - Enter Details section")
	public void verifyTheErrorMessageDisplayedForDescriptionFieldInTransferToOwnAccountEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		transferToOwnAccountPage.verifyErrorMsg(dataTable.asList().get(0).trim());
	}
}
