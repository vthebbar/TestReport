package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.HomePage;
import com.qa.pages.ManageFavouriteAccountsPage;
import com.qa.pages.OverseasTransferPage;

import io.cucumber.java.en.*;

public class S017_TransferStepDef {
	
	private WebDriver driver;
	private HomePage homePage;
	private OverseasTransferPage overseasTransferPage;
	private ManageFavouriteAccountsPage manageFavouriteAccountsPage;
	
	public  S017_TransferStepDef(TestContext context) {
		
		driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		overseasTransferPage = PageObjectFactory.getOverseasTransferPage(driver);
		manageFavouriteAccountsPage = PageObjectFactory.getManageFavouriteAccountsPage(driver);
	}
	
	
	//TC01
	@When("I m navigated to Overseas Transfer - Details Entry Section")
	public void iMNavigatedToOverseasTransferDetailsEntrySection() {
		homePage.clickOnPayAndTransact();
		homePage.clickOnOverseasTransferMenu();
	}

	@Then("Verify all elements are displayed in Overseas Transfer - Details Entry Section")
	public void verifyAllElementsAreDisplayedInOverseasTransferDetailsEntrySection() {
		overseasTransferPage.verifyElementsAreDisplayedInDetailEntrySectionOneTimeTransfer();
	}
	
	//TC02
	@When("Select and key in details in Overseas Transfer Details Entry Section {string}, {string}, {string},{string},{string},{string},{string},{string},{string},{string}")
	public void selectAndKeyInDetailsInOverseasTransferDetailsEntrySection(String From, String RecipientBank, String RecipientBankAddress, 
			String SWIFTCode, String ToAccount, String RecipientName, String Amount, String Description, String whenToTransfer, String Date) {
	    
		overseasTransferPage.selectFromAcct(From);
		overseasTransferPage.keyInRecipientBank(RecipientBank);
		overseasTransferPage.keyInRecipientBankAddress(RecipientBankAddress);
		overseasTransferPage.keyInSwiftCode(SWIFTCode);
		overseasTransferPage.keyInToAccount(ToAccount);
		overseasTransferPage.keyInRecipientName(RecipientName);
		overseasTransferPage.keyInAmount(Amount);
		overseasTransferPage.keyInDescription(Description);
		overseasTransferPage.selectWhenToTransfer(whenToTransfer);
		overseasTransferPage.selectDate(Date);
	}


	@When("Click on Next button in Overseas Transfer - Details Entry Section")
	public void clickOnNextButtonInOverseasTransferDetailsEntrySection() {
	  
		overseasTransferPage.clickOnNextBtn();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Verify fields are displayed in Overseas Transfer - Confirmation Section")
	public void verifyFieldsAreDisplayedInOverseasTransferConfirmationSection() {
	    
		overseasTransferPage.verifyConfirmScreenOneTimeTransfer();
	}
	
	//TC03
	

	@When("Key in TAC code in Overseas Transfer - Confirmation Section")
	public void keyInTACCodeInOverseasTransferConfirmationSection() {
		overseasTransferPage.keyInTac();
	}

	@When("Click on Submit button in Overseas Transfer - Confirmation Section")
	public void clickOnSubmitButtonInOverseasTransferConfirmationSection() {
		overseasTransferPage.clickOnSubmitBtn();
	}

	@Then("Verify the success message in Overseas Transfer - Acknowledgement Section")
	public void verifyTheSuccessMessageInOverseasTransferAcknowledgementSection(io.cucumber.datatable.DataTable dataTable) {
		overseasTransferPage.verifySuccessMessage(dataTable.asList().get(0));
	}

	@Then("Verify fields are displayed in Overseas Transfer - Acknowledgement Section")
	public void verifyFieldsAreDisplayedInOverseasTransferAcknowledgementSection() {
		overseasTransferPage.verifyAcknowledgmentScreenOneTimeTransfer();
	}

	@Then("Click on Make Another Transfer button in Overseas Transfer - Acknowledgement Section")
	public void clickOnMakeAnotherTransferButtonInOverseasTransferAcknowledgementSection() {
		overseasTransferPage.clickOnMakeAnotherTransferBtn();
	}

	@Then("I m navigated to Overseas Transfer - initial data entry screen")
	public void iMNavigatedToOverseasTransferInitialDataEntryScreen() {
		overseasTransferPage.verifyTransferDetailsLabelIsDisplayed();
	}
	
	//TC04
	@Then("Click on Done button in Overseas Transfer - Acknowledgement Section")
	public void clickOnDoneButtonInOverseasTransferAcknowledgementSection() {
		overseasTransferPage.clickOnDoneBtn();
	}
	
	//TC05
	@When("I when to transfer radio button in Overseas Transfer - Details Entry")
	public void iWhenToTransferRadioButtonInOverseasTransferDetailsEntry(io.cucumber.datatable.DataTable dataTable) {
		overseasTransferPage.selectWhenToTransfer(dataTable.asList().get(0));
	}

	@Then("Verify all elements are displayed in Overseas Transfer - Details Entry Section Recurring Transfer")
	public void verifyAllElementsAreDisplayedInOverseasTransferDetailsEntrySectionRecurringTransfer() {
		overseasTransferPage.verifyElementsAreDisplayedInDetailEntrySectionRecurringTransfer();
	}
	
	//TC06
	@When("Select frequency {string} and key in number of times {string} in Overseas Transfer - Details Entry Section")
	public void selectFrequencyAndKeyInNumberOfTimesInOverseasTransferDetailsEntrySection(String frequency, String numberOfTimes) {
		overseasTransferPage.selectFrequencyOfTransfer(frequency);
		overseasTransferPage.keyInNumberOfTimes(numberOfTimes);
	}
	
	@Then("Verify fields are displayed in Overseas Transfer - Confirmation Section - Recurring Transfer")
	public void verifyFieldsAreDisplayedInOverseasTransferConfirmationSectionRecurringTransfer() {
		overseasTransferPage.verifyConfirmScreenRecurringTransfer();
	}
	
	//TC07
	@Then("Verify fields are displayed in Overseas Transfer - Acknowledgement Section - Recurring Transfer")
	public void verifyFieldsAreDisplayedInOverseasTransferAcknowledgementSectionRecurringTransfer() {
		overseasTransferPage.verifyAcknowledgmentScreenRecurringTransfer();
	}
	
	//TC09
	@Then("Verify error messages displayed for fields - To Account, Amount, Description")
	public void verifyErrorMessagesDisplayedForFieldsToAccountAmountDescription(io.cucumber.datatable.DataTable dataTable) {
		overseasTransferPage.verifyErrorMsgToAcctFieldBlank(dataTable.asList().get(0));
		overseasTransferPage.verifyErrorMsgAmountFieldBlank(dataTable.asList().get(1));
		overseasTransferPage.verifyErrorMsgDescriptionFieldBlank(dataTable.asList().get(2));
		
	}
	
	//TC10
	
	@When("Key in invalid TAC code in Overseas Transfer - Confirmation Section")
	public void keyInInvalidTACCodeInOverseasTransferConfirmationSection(io.cucumber.datatable.DataTable dataTable) {
		overseasTransferPage.keyInInvalidTac(dataTable.asList().get(0));
	}

	
	@Then("Verify the error message for TAC in Overseas Transfer - Confirmation Section")
	public void verifyTheErrorMessageForTACInOverseasTransferConfirmationSection(io.cucumber.datatable.DataTable dataTable) {
		overseasTransferPage.verifyErrorMsgInvalidTac(dataTable.asList().get(0));
	}
	
	//TC11
	@When("I click on Add Favourite menu in Overseas Transfer - Details Entry Section")
	public void iClickOnAddFavouriteMenuInOverseasTransferDetailsEntrySection() {
		overseasTransferPage.clickOnAddFavouriteMenu();
	}

	@When("I click on No button in Add Favourite pop up in Overseas Transfer - Details Entry Section")
	public void iClickOnNoButtonInAddFavouritePopUpInOverseasTransferDetailsEntrySection() {
		overseasTransferPage.clickOnNoBtn();
	}

	@Then("I m navigated to Overseas Transfer - Details Entry  main screen")
	public void iMNavigatedToOverseasTransferDetailsEntryMainScreen() {
		overseasTransferPage.verifyTransferDetailsLabelIsDisplayed();
	}
	
	//TC12
	
	@When("I click on Yes button in Add Favourite pop up in Overseas Transfer - Details Entry Section")
	public void iClickOnYesButtonInAddFavouritePopUpInOverseasTransferDetailsEntrySection() {
		overseasTransferPage.clickOnYesBtn();
	}

	@When("Select or key in the Favourite Account details in Manage My Favoutite Accounts screen {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void selectOrKeyInTheFavouriteAccountDetailsInManageMyFavoutiteAccountsScreen(String ReceipientBank, String ReceipientBankAddr, String SwiftCode, String ToAccount, String RecipientAccountCurrency, String RecipientName, String FavAcctName) {
		manageFavouriteAccountsPage.keyInRecipientBank(ReceipientBank);
		manageFavouriteAccountsPage.keyInRecipientBankAddress(ReceipientBankAddr);
		manageFavouriteAccountsPage.keyInSwiftCode(SwiftCode);
		manageFavouriteAccountsPage.keyInToAcctOverseas(ToAccount);
		manageFavouriteAccountsPage.selectRecipientCurrency(RecipientAccountCurrency);
		manageFavouriteAccountsPage.keyInRecipientName(RecipientName);
		manageFavouriteAccountsPage.keyInLocalRecFavName(FavAcctName);
		
	}

	@Then("Verify all details are displayed correctly in Manage Favourite Accounts - Acknowledgement section Overseas Transfer")
	public void verifyAllDetailsAreDisplayedCorrectlyInManageFavouriteAccountsAcknowledgementSectionOverseasTransfer() {
		manageFavouriteAccountsPage.verifyAcknowledgementDetailsAreDisplayedOverseasAddFav();
	}
	
	//TC13
	@Then("Verify Favourite account and delete or bin icon are displayed in Overseas Transfer - Details Entry Section")
	public void verifyFavouriteAccountAndDeleteOrBinIconAreDisplayedInOverseasTransferDetailsEntrySection() {
		overseasTransferPage.verifyFavouriteAccountIsDisplayed();
		overseasTransferPage.verifyDeleteBinIconIsDisplayed();
	}
	
	//TC14
	@When("I click on No button in Overseas Transfer - Details Entry Section pop up to confirm the deletion")
	public void iClickOnNoButtonInOverseasTransferDetailsEntrySectionPopUpToConfirmTheDeletion() {
		overseasTransferPage.clickOnBtnNoForDeleteConfirmation();
	}

	@Then("Verify Favourite Record is NOT deleted under Overseas Transfer screen")
	public void verifyFavouriteRecordIsNOTDeletedUnderOverseasTransferScreen() {
		overseasTransferPage.verifyRecordIsNotDeleted();
	}
	
	//TC15
	@When("I click on Delete or Bin icon button in Overseas Transfer - Details Entry Section")
	public void iClickOnDeleteOrBinIconButtonInOverseasTransferDetailsEntrySection() {
		overseasTransferPage.clickOnDeleteIcon();
	}

	@When("I click on Checkbox to selet the record for deletion in Overseas Transfer - Details Entry Section")
	public void iClickOnCheckboxToSeletTheRecordForDeletionInOverseasTransferDetailsEntrySection() {
		overseasTransferPage.clickOnCheckBoxToSelectRecordToDelete();
	}

	@When("I click on Yes button in Overseas Transfer - Details Entry Section pop up to confirm the deletion")
	public void iClickOnYesButtonInOverseasTransferDetailsEntrySectionPopUpToConfirmTheDeletion() {
		overseasTransferPage.clickOnBtnYesForDeleteConfirmation();
	}

	@Then("Verify Favourite Record deleted successfully under Overseas Transfer screen")
	public void verifyFavouriteRecordDeletedSuccessfullyUnderOverseasTransferScreen() {
		overseasTransferPage.verifyRecordIsDeleted();
	}

}
