package com.qa.stepDef;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.HomePage;
import com.qa.pages.ManageFavouriteAccountsPage;
import com.qa.pages.TransferToOtherAcctAtHLBCAMPage;

import io.cucumber.java.en.*;

public class S015_Transfer2StepDef {
	
	private WebDriver driver;
	private HomePage homePage;
	private TransferToOtherAcctAtHLBCAMPage transferToOtherAcctAtHLBCAMPage;
	private ManageFavouriteAccountsPage manageFavouriteAccountsPage;
	public S015_Transfer2StepDef(TestContext context) {
		
		driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		transferToOtherAcctAtHLBCAMPage = PageObjectFactory.getTransferToOtherAcctAtHLBCAMPage(driver);
		manageFavouriteAccountsPage = PageObjectFactory.getManageFavouriteAccountsPage(driver);
	}
	
	//TC01
	
	@When("I m navigated to Transfer to Other Account at HLBCAM - Details entry section")
	public void iMNavigatedToTransferToOtherAccountAtHLBCAMDetailsEntrySection() {
		homePage.clickOnPayAndTransact();
		homePage.clickOnTransferToOtherAccountAtHLBCAM();
		
	}

	@When("Select From account in Transfer to Other Account at HLBCAM - Details entry section")
	public void selectFromAccountInTransferToOtherAccountAtHLBCAMDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		transferToOtherAcctAtHLBCAMPage.selectFromAccount(dataTable.asList().get(0));
	}

	@Then("Verify all fields are displayed in Transfer to Other Account at HLBCAM - Details entry section")
	public void verifyAllFieldsAreDisplayedInTransferToOtherAccountAtHLBCAMDetailsEntrySection() {
		transferToOtherAcctAtHLBCAMPage.verifyDetailsEntrySectionsElementsAreDisplayedOneTimeTransfer();
	}
	
	//TC02
	
	@When("Key in To Account in Transfer to Other Account at HLBCAM - Details entry section")
	public void keyInToAccountInTransferToOtherAccountAtHLBCAMDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		transferToOtherAcctAtHLBCAMPage.keyInToAccount(dataTable.asList().get(0));
	}

	@When("Key in Amount and Description in Transfer to Other Account at HLBCAM - Details entry section")
	public void keyInAmountAndDescriptionInTransferToOtherAccountAtHLBCAMDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
	  
		transferToOtherAcctAtHLBCAMPage.keyInAmount(dataTable.asList().get(0).trim());
		transferToOtherAcctAtHLBCAMPage.keyInDescription(dataTable.asList().get(1).trim());

		transferToOtherAcctAtHLBCAMPage.keyInAmount(dataTable.asList().get(0).trim());

	}

	

	@When("Select when to Transfer in Transfer to Other Account at HLBCAM - Details entry section")
	public void selectWhenToTransferInTransferToOtherAccountAtHLBCAMDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		transferToOtherAcctAtHLBCAMPage.selectWhenToTransfer(dataTable.asList().get(0).trim());
	}

	@When("Select the Date in Transfer to Other Account at HLBCAM - Details entry section")
	public void selectTheDateInTransferToOtherAccountAtHLBCAMDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		transferToOtherAcctAtHLBCAMPage.selectDate(dataTable.asList().get(0).trim());
	}

	@When("Key in SMS notification mobile number in Transfer to Other Account at HLBCAM - Details entry section")
	public void keyInSMSNotificationMobileNumberInTransferToOtherAccountAtHLBCAMDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		transferToOtherAcctAtHLBCAMPage.keyInSMSMobileNum(dataTable.asList().get(0).trim());
	}

	@When("Click on Next button in Transfer to Other Account at HLBCAM - Details entry section")
	public void clickOnNextButtonInTransferToOtherAccountAtHLBCAMDetailsEntrySection() {
		transferToOtherAcctAtHLBCAMPage.clickOnNextBtn();
	}

	@Then("Verify Transfer to Other Account at HLBCAM screen - Confirmation  section")
	public void verifyTransferToOtherAccountAtHLBCAMScreenConfirmationSection() {
		transferToOtherAcctAtHLBCAMPage.verifyConfirmationScreenElementsOneTimeTransfer();
	}
	
	//TC03
	
	@When("I click on Submit button in Transfer to Other Account at HLBCAM screen - Confirmation  section")
	public void iClickOnSubmitButtonInTransferToOtherAccountAtHLBCAMScreenConfirmationSection() {
		transferToOtherAcctAtHLBCAMPage.clickOnSubmitButton();
	}

	@Then("Verify message in Transfer to Other Account at HLBCAM - Acknowledgement section")
	public void verifyMessageInTransferToOtherAccountAtHLBCAMAcknowledgementSection(io.cucumber.datatable.DataTable dataTable) {
		transferToOtherAcctAtHLBCAMPage.verifyTransferSuccessMsg(dataTable.asList().get(0).trim());
	}

	@Then("Verify fields are displayed correctly in Transfer to Other Account at HLBCAM - Acknowledgement section")
	public void verifyFieldsAreDisplayedCorrectlyInTransferToOtherAccountAtHLBCAMAcknowledgementSection() {
		transferToOtherAcctAtHLBCAMPage.verifyAcknowledgementSectionOneTimeTransferUSDtoUSD();
	}

	@Then("I click on Done button in Transfer to Other Account at HLBCAM - Acknowledgement section")
	public void iClickOnDoneButtonInTransferToOtherAccountAtHLBCAMAcknowledgementSection() {
		transferToOtherAcctAtHLBCAMPage.clickOnDoneBtn();
	}
	
	//TC04
	@Then("I click on Make Another Transfer button in Transfer to Other Account at HLBCAM - Acknowledgement section")
	public void iClickOnMakeAnotherTransferButtonInTransferToOtherAccountAtHLBCAMAcknowledgementSection() {
		transferToOtherAcctAtHLBCAMPage.clickOnMakeAnotherTransferBtn();
	}

	@Then("I m navigated to Transfer to Other Account at HLBCAM main screen")
	public void iMNavigatedToTransferToOtherAccountAtHLBCAMMainScreen() {
		transferToOtherAcctAtHLBCAMPage.verifyTransferDetailsLabelIsDisplayed();
		
	}

	//TC05
	@Then("Verify all fields are displayed in Transfer to Other Account at HLBCAM - Details entry section - Recurring Transfer")
	public void verifyAllFieldsAreDisplayedInTransferToOtherAccountAtHLBCAMDetailsEntrySectionRecurringTransfer() {
		transferToOtherAcctAtHLBCAMPage.verifyDetailsEntrySectionsElementsAreDisplayedRecurringTransfer();
	}
	
	//TC06
	@When("Select the Starting From Date, Repeat frequency and number of times in Transfer to Other Account at HLBCAM - Details entry section")
	public void selectTheStartingFromDateRepeatFrequencyAndNumberOfTimesInTransferToOtherAccountAtHLBCAMDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		transferToOtherAcctAtHLBCAMPage.selectStartFromDate(dataTable.asList().get(0));
		transferToOtherAcctAtHLBCAMPage.selectRepeatFrequency(dataTable.asList().get(1));
		transferToOtherAcctAtHLBCAMPage.keyInNumberOfTimes(dataTable.asList().get(2));
	}

	@Then("Verify Transfer to Other Account at HLBCAM screen - Confirmation  section - Recurring Transfer")
	public void verifyTransferToOtherAccountAtHLBCAMScreenConfirmationSectionRecurringTransfer() {
		transferToOtherAcctAtHLBCAMPage.verifyConfirmationScreenElementsRecurringTransfer();
	}
	
	//TC09
	@Then("Verify the error message for To Account field in Transfer to Other Account at HLBCAM - Details entry section")
	public void verifyTheErrorMessageForToAccountFieldInTransferToOtherAccountAtHLBCAMDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		transferToOtherAcctAtHLBCAMPage.verifyErrorMsgToAcctField(dataTable.asList().get(0));
	}
	
	//TC10
	@When("Key in Description in Transfer to Other Account at HLBCAM - Details entry section")
	public void keyInDescriptionInTransferToOtherAccountAtHLBCAMDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		transferToOtherAcctAtHLBCAMPage.keyInDescription(dataTable.asList().get(0));
	}

	@Then("Verify the error message for Amount field in Transfer to Other Account at HLBCAM - Details entry section")
	public void verifyTheErrorMessageForAmountFieldInTransferToOtherAccountAtHLBCAMDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		transferToOtherAcctAtHLBCAMPage.verifyErrorMsgAmountField(dataTable.asList().get(0));
	}
	
	//TC11
	
	@When("Key in Amount in Transfer to Other Account at HLBCAM - Details entry section")
	public void keyInAmountInTransferToOtherAccountAtHLBCAMDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		transferToOtherAcctAtHLBCAMPage.keyInAmount(dataTable.asList().get(0));
	}

	@Then("Verify the error message for Description field in Transfer to Other Account at HLBCAM - Details entry section")
	public void verifyTheErrorMessageForDescriptionFieldInTransferToOtherAccountAtHLBCAMDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		transferToOtherAcctAtHLBCAMPage.verifyErrorMsgDescriptionField(dataTable.asList().get(0));
	}
	
	//TC12
	
	@When("I click on Add Favourite menu in Transfer to Other Account at HLBCAM - Details entry section")
	public void iClickOnAddFavouriteMenuInTransferToOtherAccountAtHLBCAMDetailsEntrySection() {
		transferToOtherAcctAtHLBCAMPage.clickOnAddFavouriteMenu();
	}

	@When("I click on Yes button in pop up at Transfer to Other Account at HLBCAM - Details entry section")
	public void iClickOnYesButtonInPopUpAtTransferToOtherAccountAtHLBCAMDetailsEntrySection() {
		transferToOtherAcctAtHLBCAMPage.clickOnYesBtnInAddFavouritePopUp();
	}

	@When("Select the Transaction Type in Manage My Favourite Accounts screen")
	public void selectTheTransactionTypeInManageMyFavoutiteAccountsScreen(io.cucumber.datatable.DataTable dataTable) {
		manageFavouriteAccountsPage.selectTransactionTypeDropDownValue(dataTable.asList().get(0));
	}

	@When("Key in the Favourite Account details in Manage My Favourite Accounts screen")
	public void keyInTheFavouriteAccountDetailsInManageMyFavoutiteAccountsScreen(io.cucumber.datatable.DataTable dataTable) {
		
		List<Map<String, String>> data = dataTable.asMaps();
		
		manageFavouriteAccountsPage.keyInRecipientBankAddress(data.get(0).get("ReceipientBankAddress"));
		manageFavouriteAccountsPage.keyInToAccountNumber(data.get(0).get("ToAccount"));
		manageFavouriteAccountsPage.keyInFavouriteAcctName(data.get(0).get("FavouriteAccountName"));
	}

	@When("Click on Next button in Manage Favourite Accounts screen")
	public void clickOnNextButtonInManageFavoutiteAccountsScreen() {
		manageFavouriteAccountsPage.clickOnNextBtn();
	}

	@When("Key in the TAC in Manage Favourite Accounts-Receipient information section")
	public void keyInTheTACInManageFavoutiteAccountsReceipientInformationSection() {
		manageFavouriteAccountsPage.keyInTac();
	}

	@When("Click on Submit button in Manage Favourite Accounts-Receipient information section")
	public void clickOnSubmitButtonInManageFavoutiteAccountsReceipientInformationSection() {
		manageFavouriteAccountsPage.clickOnSubmitBtn();
	}

	@Then("Verify message in Manage Favourite Accounts - Acknowledgement section")
	public void verifyMessageInManageFavoutiteAccountsAcknowledgementSection(io.cucumber.datatable.DataTable dataTable) {
		manageFavouriteAccountsPage.verifySuccessMessage(dataTable.asList().get(0));
	}

	@Then("Verify all details are displayed correctly in Manage Favourite Accounts - Acknowledgement section")
	public void verifyAllDetailsAreDisplayedCorrectlyInManageFavoutiteAccountsAcknowledgementSection() {
		manageFavouriteAccountsPage.verifyAcknowledgementDetailsAreDisplayed();
	}

	@Then("Click on Done button in Manage Favourite Accounts - Acknowledgement section")
	public void clickOnDoneButtonInManageFavoutiteAccountsAcknowledgementSection() {
		manageFavouriteAccountsPage.clickOnDonebtn();
	}

	//TC13
	@When("I click on No button in pop up at Transfer to Other Account at HLBCAM - Details entry section")
	public void iClickOnNoButtonInPopUpAtTransferToOtherAccountAtHLBCAMDetailsEntrySection() {
		transferToOtherAcctAtHLBCAMPage.clickOnNoBtninAddFavouritePopUp();
	}
	
	//TC14
	@Then("Add Favourite menu and Delete or Bin icon button are displayed in Transfer to Other Account at HLBCAM - Details entry section")
	public void addFavouriteMenuAndDeleteOrBinIconButtonAreDisplayedInTransferToOtherAccountAtHLBCAMDetailsEntrySection() {
		transferToOtherAcctAtHLBCAMPage.verifyAddFavouriteMenuIsDisplayed();
		transferToOtherAcctAtHLBCAMPage.verifyDeleteButtonIconIsDisplayed();
	}
	
	//TC15
	
	@When("I click on Delete or Bin icon button in Transfer to Other Account at HLBCAM - Details entry section")
	public void iClickOnDeleteOrBinIconButtonInTransferToOtherAccountAtHLBCAMDetailsEntrySection() {
		transferToOtherAcctAtHLBCAMPage.clickOnDeleteBtn();
	}

	@When("I click on Checkbox to selet the record for deletion in Transfer to Other Account at HLBCAM - Details entry section")
	public void iClickOnCheckboxToSeletTheRecordForDeletionInTransferToOtherAccountAtHLBCAMDetailsEntrySection() {
		transferToOtherAcctAtHLBCAMPage.clickOnCheckBoxForDeleteEntry();
	}

	@When("I click on Yes button in Transfer to Other Account at HLBCAM - Details entry section - pop up to confirm the deletion")
	public void iClickOnYesButtonInTransferToOtherAccountAtHLBCAMDetailsEntrySectionPopUpToConfirmTheDeletion() {
		transferToOtherAcctAtHLBCAMPage.clickOnYesBtnToConfirmDelete();
	}

	@Then("Favourite Record deleted successfully")
	public void favouriteRecordDeletedSuccessfully() {
		transferToOtherAcctAtHLBCAMPage.verifyFavouriteRecordCount();
	}
}
