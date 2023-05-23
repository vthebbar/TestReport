package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LocalTransferPage;
import com.qa.pages.ManageFavouriteAccountsPage;

import io.cucumber.java.en.*;

public class S016_Transfer3StepDef {
		
	private WebDriver driver;
	private HomePage homePage;
	private LocalTransferPage localTransferPage;
	private ManageFavouriteAccountsPage manageFavouriteAccountsPage;
	
	
	public S016_Transfer3StepDef(TestContext context) {
		
		driver = context.driver;
		homePage= PageObjectFactory.getHomePage(driver);
		localTransferPage = PageObjectFactory.getLocalTransferPage(driver);
		manageFavouriteAccountsPage = PageObjectFactory.getManageFavouriteAccountsPage(driver);
	}
	
	//TC01
	@When("I m navigated to Local Transfer - Details Entry Section")
	public void iMNavigatedToLocalTransferDetailsEntrySection() {
		homePage.clickOnPayAndTransact();
		homePage.clickOnLocalTransferMenu();
	}

	@When("I select from account {string} in Local Transfer - Details Entry Section")
	public void iSelectFromAccountInLocalTransferDetailsEntrySection(String acctVal) {
		localTransferPage.selectFromAcct(acctVal);
	}

	@Then("Verify all elements are displayed in Local Transfer - Details Entry Section")
	public void verifyAllElementsAreDisplayedInLocalTransferDetailsEntrySection() {
		localTransferPage.verifyAllFieldsAreDisplayedInDetailsEntrySectionOneTimeTransfer();
	}
	
	//TC02
	
	@When("I select {string} ,{string} in Local Transfer - Details Entry Section")
	public void iSelectInLocalTransferDetailsEntrySection(String fromAcct, String ReceipientBank) {
		localTransferPage.selectFromAcct(fromAcct);
		localTransferPage.selectReceipientBank(ReceipientBank);
	}

	@When("I key in details for the Local Transfer {string}, {string}, {string}, {string}, {string}")
	public void iKeyInDetailsForTheLocalTransfer(String ToAcct, String ReceipientName, String Amount, String Description, String SMSMobileNo) {
		localTransferPage.keyInToAccount(ToAcct);
		localTransferPage.keyInReceipientName(ReceipientName);
		localTransferPage.keyInAmount(Amount);
		localTransferPage.keyInDescription(Description);
		localTransferPage.keyInMobileNumForSMS(SMSMobileNo);
	}

	@When("I Select when to Transfer {string} and select date {string}")
	public void iSelectWhenToTransferAndSelectDate(String whenToTransfer, String Date) {
		localTransferPage.selectWhenToTransfer(whenToTransfer);
		localTransferPage.selectTransferDate(Date);
	}

	@When("I click on Next button in Local Transfer - Details Entry Section")
	public void iClickOnNextButtonInLocalTransferDetailsEntrySection() {
		localTransferPage.clickOnNextBtn();
	}

	@Then("Verify that all details displayed correctly in Local Transfer - Confirmation Section")
	public void verifyThatAllDetailsDisplayedCorrectlyInLocalTransferConfirmationSection() {
		localTransferPage.verifyDetailsAreDisplayedInConfirmSection();
	}
	
	//TC03
	@When("I click on Submit button in Local Transfer - Confirmation Section")
	public void iClickOnSubmitButtonInLocalTransferConfirmationSection() {
		localTransferPage.clickOnSubmitBtn();
	}

	@Then("Verify the success message in Local Transfer - Acknowledgement Section")
	public void verifyTheSuccessMessageInLocalTransferAcknowledgementSection(io.cucumber.datatable.DataTable dataTable) {
		localTransferPage.verifySuccessMessage(dataTable.asList().get(0));
		localTransferPage.verifyElementsAreDisplayedInAcknowledgementSection();
	}

	@Then("I click on Make Another Transfer button in Local Transfer - Acknowledgement Section")
	public void iClickOnMakeAnotherTransferButtonInLocalTransferAcknowledgementSection() {
		localTransferPage.clickOnMakeAnotherTransferBtn();
	}

	@Then("Local Transfer - Details Entry Section is displayed")
	public void localTransferDetailsEntrySectionIsDisplayed() {
		localTransferPage.verifyTransferDetailsLabelIsDisplayed();
	}
	
	//TC04
	@Then("I click on Done button in Local Transfer - Acknowledgement Section")
	public void iClickOnDoneButtonInLocalTransferAcknowledgementSection() {
		localTransferPage.clickOnDoneBtn();
	}
	
	
	//TC05
	@When("I select when to transfer radio button in Local Transfer - Details Entry Section")
	public void iSelectWhenToTransferRadioButtonInLocalTransferDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		localTransferPage.selectWhenToTransfer(dataTable.asList().get(0));
	}

	@Then("Verify all elements are displayed in Local Transfer - Details Entry Section for Recurring Transfer")
	public void verifyAllElementsAreDisplayedInLocalTransferDetailsEntrySectionForRecurringTransfer() {
		localTransferPage.verifyAllFieldsAreDisplayedInDetailsEntrySectionRecurringTransfer();
	}
	
	//TC06
	
	@When("I Select Repeat frequency {string} and Number of times {string}")
	public void iSelectRepeatFrequencyAndNumberOfTimes(String repeatFreq, String numOfTimes) {
		localTransferPage.selectRepatFrequency(repeatFreq);
		localTransferPage.KeyInNumberOfTimes(numOfTimes);
	}

	@Then("Verify that all details displayed correctly in Local Transfer - Confirmation Section for Recurring Transfer")
	public void verifyThatAllDetailsDisplayedCorrectlyInLocalTransferConfirmationSectionForRecurringTransfer() {
		localTransferPage.verifyDetailsAreDisplayedInConfirmSectionForRecurringTransfer();
	}
	
	//TC09
	@When("I key in details for the Local Transfer {string}, {string}, {string}, {string}")
	public void iKeyInDetailsForTheLocalTransfer(String receipientName, String Amt, String desc, String mobileNo) {
		
		//work around
		localTransferPage.keyInToAccount("01234");
		
		
		localTransferPage.keyInReceipientName(receipientName);
		localTransferPage.keyInAmount(Amt);
		localTransferPage.keyInDescription(desc);
		localTransferPage.keyInMobileNumForSMS(mobileNo);
		
		//work around
		localTransferPage.clearToAcctField();

		localTransferPage.clickOnNextBtn();
	}

	@Then("Verify the error message for To Account in Local Transfer - Details Entry Section")
	public void verifyTheErrorMessageForToAccountInLocalTransferDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		localTransferPage.verifyErrorMessage(dataTable.asList().get(0));
	}
	
	//TC10
	@When("I key in details for the Local Transfer {string} {string},  {string}, {string}")
	public void iKeyInDetailsForTheLocalTransfer1(String toAcct, String recName, String desc, String mobileNo) {
		localTransferPage.keyInToAccount(toAcct);
		
		//work around
		localTransferPage.keyInAmount("11");

		
		localTransferPage.keyInReceipientName(recName);
		localTransferPage.keyInDescription(desc);
		localTransferPage.keyInMobileNumForSMS(mobileNo);
		
		//work around
				localTransferPage.clearAmtField();
				localTransferPage.clickOnNextBtn();
				localTransferPage.keyInReceipientName(recName);
				localTransferPage.keyInDescription(desc);
				localTransferPage.clickOnNextBtn();
				localTransferPage.keyInDescription(desc);
				localTransferPage.clickOnNextBtn();

	}

	@Then("Verify the error message for Amount in Local Transfer - Details Entry Section")
	public void verifyTheErrorMessageForAmountInLocalTransferDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		localTransferPage.verifyErrorMessage(dataTable.asList().get(0));
	}
	
	//TC11
	@When("I key in details for the Local Transfer without description {string}, {string}, {string}, {string}")
	public void iKeyInDetailsForTheLocalTransferWithoutDescription(String toAcct, String recName, String amt, String mobileNo) {
		localTransferPage.keyInToAccount(toAcct);
		localTransferPage.keyInReceipientName(recName);
		localTransferPage.keyInAmount(amt);
		localTransferPage.keyInDescription("Desc");
		localTransferPage.keyInMobileNumForSMS(mobileNo);
		localTransferPage.clearDescriptionField();
		
		//work around
		localTransferPage.clickOnNextBtn();
		localTransferPage.keyInReceipientName(recName);
		localTransferPage.keyInAmount(amt);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		localTransferPage.clickOnNextBtn();


		
	}
	
	//TC12
	
	@Then("Verify error messages for To Account, Receipient Name, Amount, Description")
	public void verifyErrorMessagesForToAccountReceipientNameAmountDescription(io.cucumber.datatable.DataTable dataTable) {
		localTransferPage.verifyErrMsgToAccount(dataTable.asList().get(0));
		localTransferPage.verifyErrMsgRecName(dataTable.asList().get(1));
		localTransferPage.verifyErrMsgAmount(dataTable.asList().get(2));
		localTransferPage.verifyErrorMsgDesc(dataTable.asList().get(3));
	}
	
	
	//TC13
	
	@When("I click on Add Favourite menu in Local Transfer - Details Entry Section")
	public void iClickOnAddFavouriteMenuInLocalTransferDetailsEntrySection() {
		localTransferPage.clickOnAddFavouriteMenu();
	}

	@When("I click on Yes button in Add Favourite pop up in Local Transfer - Details Entry Section")
	public void iClickOnYesButtonInAddFavouritePopUpInLocalTransferDetailsEntrySection() {
		localTransferPage.clickOnYesBtn();
	}

	@When("Select the Transaction Type {string} in Manage My Favourite Accounts screen")
	public void selectTheTransactionTypeInManageMyFavouriteAccountsScreen(String transferType) {
		manageFavouriteAccountsPage.selectTransactionTypeDropDownValue(transferType);
	}



@When("Key in the Favourite Account details in Manage My Favoutite Accounts screen {string}, {string}, {string}, {string}, {string}")
public void keyInTheFavouriteAccountDetailsInManageMyFavoutiteAccountsScreen(String ReceipientBank, String ReceipientBranch, String ToAccount, String RecipientName, String FavouriteAccountName) {
	manageFavouriteAccountsPage.selectRecipientBank(ReceipientBank);
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	manageFavouriteAccountsPage.keyInRecipientBankBranch(ReceipientBranch);
	manageFavouriteAccountsPage.keyInToLocalAcctNum(ToAccount);
	manageFavouriteAccountsPage.keyInLocalRecipientName(RecipientName);
	manageFavouriteAccountsPage.keyInLocalRecFavName(FavouriteAccountName);
}

	@When("Key in the TAC in Manage Favoutite Accounts-Receipient information section")
	public void keyInTheTACInManageFavoutiteAccountsReceipientInformationSection() {
		manageFavouriteAccountsPage.keyInTac();
	}

	@Then("Verify message {string} in Manage Favourite Accounts - Acknowledgement section")
	public void verifyMessageInManageFavouriteAccountsAcknowledgementSection(String msg) {
		manageFavouriteAccountsPage.verifySuccessMessage(msg);
		
	}
	
	@Then("Verify all details are displayed correctly in Manage Favourite Accounts - Acknowledgement section Local Transfer")
	public void verifyAllDetailsAreDisplayedCorrectlyInManageFavouriteAccountsAcknowledgementSectionLocalTransfer() {
		manageFavouriteAccountsPage.verifyAcknowledgementDetailsAreDisplayedLocalAddFav();
	}
	
	//TC14
	
	@When("I click on No button in Add Favourite pop up in Local Transfer - Details Entry Section")
	public void iClickOnNoButtonInAddFavouritePopUpInLocalTransferDetailsEntrySection() {
		localTransferPage.clickOnNoBtn();
	}

	@Then("I m navigated to Local Transfer- Details Entry main screen")
	public void iMNavigatedToLocalTransferDetailsEntryMainScreen() {
	
		localTransferPage.verifyTransferDetailsLabelIsDisplayed();
	}
	
	//TC15
	@Then("Verify Add Favourite menu and Delete button icon are displayed in Local Transfer - Details Entry Section")
	public void verifyAddFavouriteMenuAndDeleteButtonIconAreDisplayedInLocalTransferDetailsEntrySection() {
		localTransferPage.verifyAddFavouriteMenuIsDisplayed();
		localTransferPage.verifyDeleteBtnIsDisplayed();
	}
	
	//TC16
	@When("I click on Delete or Bin icon button in Local Transfer - Details Entry Section")
	public void iClickOnDeleteOrBinIconButtonInLocalTransferDetailsEntrySection() {
		localTransferPage.clickOnDeleteBtn();
	}

	@When("I click on Checkbox to selet the record for deletion in Local Transfer - Details Entry Section")
	public void iClickOnCheckboxToSeletTheRecordForDeletionInLocalTransferDetailsEntrySection() {
		localTransferPage.selectCheckBoxToDeleteFavRecord();
	}

	@When("I click on Yes button in Local Transfer - Details Entry Section pop up to confirm the deletion")
	public void iClickOnYesButtonInLocalTransferDetailsEntrySectionPopUpToConfirmTheDeletion() {
		localTransferPage.clickOnYesBtnToCOnfirmDelete();
	}

	@Then("Favourite Record deleted successfully under Local Transfer")
	public void favouriteRecordDeletedSuccessfullyUnderLocalTransfer() {
		localTransferPage.verifyFavouriteRecordCountAfterDeletion();
	}
}
