package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.BlockUnblockVirtualCardPage;
import com.qa.pages.ChangeDebitingAcctVirtualCardPage;
import com.qa.pages.CreateUpdateNoteVirtualCardPage;
import com.qa.pages.HomePage;
import com.qa.pages.SetDailyLimitVirtualCardPage;
import com.qa.pages.VirtualDebitCardOverviewPage;

import io.cucumber.java.en.*;

public class S011_MyCards2StepDef {
	
	private WebDriver driver;
	private HomePage homePage;
	private VirtualDebitCardOverviewPage virtualDebitCardOverviewPage;
	private BlockUnblockVirtualCardPage blockUnblockVirtualCardPage;
	private ChangeDebitingAcctVirtualCardPage changeDebitingAcctVirtualCardPage;
	private SetDailyLimitVirtualCardPage setDailyLimitVirtualCardPage;
	private CreateUpdateNoteVirtualCardPage createUpdateNoteVirtualCardPage;
	
	public S011_MyCards2StepDef(TestContext context) {
		
		this.driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		virtualDebitCardOverviewPage = PageObjectFactory.getVirtualDebitCardOverviewPage(driver);
		blockUnblockVirtualCardPage = PageObjectFactory.getBlockUnblockVirtualCardPage(driver);
		changeDebitingAcctVirtualCardPage = PageObjectFactory.getChangeDebitingAcctVirtualCardPage(driver);
		setDailyLimitVirtualCardPage = PageObjectFactory.getSetDailyLimitVirtualCardPage(driver);
		createUpdateNoteVirtualCardPage = PageObjectFactory.getCreateUpdateNoteVirtualCardPage(driver);
	}
	
	
	//TC01 to TC04
	@When("I m navigated to Virtual Debit Card Overview screen")
	public void iMNavigatedToVirtualDebitCardOverviewScreen() {
		homePage.clickOnVirtualDebitCard();
		
	}

	@Then("Card Number, Valid Thru and CVV are displayed")
	public void cardNumberValidThruAndCVVAreDisplayed() {
		virtualDebitCardOverviewPage.verifyCardNumberIsDisplayed();
		virtualDebitCardOverviewPage.verifyCardExpiryDateIsDisplayed();
		virtualDebitCardOverviewPage.verifyCardCVVIsDisplayed();
	}

	@Then("Account Balance, Linked Account, Card Status and Note are displayed")
	public void accountBalanceLinkedAccountCardStatusAndNoteAreDisplayed() {
		virtualDebitCardOverviewPage.verifyAcctBalanceIsDisplayed();
		virtualDebitCardOverviewPage.verifyLinkedAcctIsDisplayed();
		virtualDebitCardOverviewPage.verifyCardStatusIsDisplayed();
		virtualDebitCardOverviewPage.verifyNoteIsDisplayed();
	}

	@Then("Transaction Timeline is displayed")
	public void transactionTimelineIsDisplayed() {
		virtualDebitCardOverviewPage.verifyTransactionTimeLineHeadingIsDisplayed();
	}

	@Then("Ref No, Date, Description, Incoming, Outgoing are displayed")
	public void refNoDateDescriptionIncomingOutgoingAreDisplayed() {
		virtualDebitCardOverviewPage.verifyTransactionTimeLineTableHeadingsAreDisplayed();
	}
	
	//TC05
	
	@When("I click on Manage Card Settings option")
	public void iClickOnManageCardSettingsOption() {
		virtualDebitCardOverviewPage.clickOnManageCardSettings();
	}

	@Then("Block\\/Unblock Virtual Card,Change Debiting Account, Set Daily Limit, Create\\/Update Note are displayed")
	public void blockUnblockVirtualCardChangeDebitingAccountSetDailyLimitCreateUpdateNoteAreDisplayed() {
		virtualDebitCardOverviewPage.verifyManageCardSettingOptionsAreDisplayed();
	}
	
	//TC06
	

@When("I m naviagted to Block\\/Unblock Virtual Card - Enter Details section")
public void iMNaviagtedToBlockUnblockVirtualCardEnterDetailsSection() {
	homePage.clickOnVirtualDebitCard();
	virtualDebitCardOverviewPage.clickOnManageCardSettings();
	virtualDebitCardOverviewPage.clickOnBlockUnblockVirtualCard();

}

@Then("Alert, Card Details, Card Status, Action are displayed")
public void alertCardDetailsCardStatusActionAreDisplayed() {
	blockUnblockVirtualCardPage.verifyBlockUnblockVirtualCardScreenElements();
}

//TC07
@When("I click on Block button in Block\\/Unblock Virtual Card screen - Enter Details section")
public void iClickOnBlockButtonInBlockUnblockVirtualCardScreenEnterDetailsSection() {
	blockUnblockVirtualCardPage.clickOnBlockBtn();
}

@Then("Message displayed as below")
public void messageDisplayedAsBelow(io.cucumber.datatable.DataTable dataTable) {
	String expMsg= dataTable.asList().get(0);
	blockUnblockVirtualCardPage.verifyResponseMessage(expMsg);
}

@Then("I click on Done button in Block\\/Unblock Virtual Card - Acknowledgement section")
public void iClickOnDoneButtonInBlockUnblockVirtualCardAcknowledgementSection() {
	blockUnblockVirtualCardPage.clickOnDoneBtn();
}

@Then("I m navigated to home page")
public void iMNavigatedToHomePage() {
	homePage.verifyMyCardsSectionHeadingIsDisplayed();
}

//TC08

@Then("Card Status is displayed as Blocked")
public void cardStatusIsDisplayedAsBlocked() {
	blockUnblockVirtualCardPage.verifyCardStatus();
}

@Then("Unblock action button is displayed")
public void unblockActionButtonIsDisplayed() {
	blockUnblockVirtualCardPage.verifyUnblockBtnIsDisplayed();
}
//TC09
@When("I click on Unblock button in Block\\/Unblock Virtual Card screen - Enter Details section")
public void iClickOnUnblockButtonInBlockUnblockVirtualCardScreenEnterDetailsSection() {
	blockUnblockVirtualCardPage.clickOnUnblockBtn();
}

@When("I enter Invalid TAC in Block\\/Unblock Virtual Card screen - Confirm Details section")
public void iEnterInvalidTACInBlockUnblockVirtualCardScreenConfirmDetailsSection(io.cucumber.datatable.DataTable dataTable) {
  
	String invalidTac = dataTable.asList().get(0);
	blockUnblockVirtualCardPage.keyInInvalidTac(invalidTac);
}

@When("I click on Submit button in Block\\/Unblock Virtual Card screen - Confirm Details section")
public void iClickOnSubmitButtonInBlockUnblockVirtualCardScreenConfirmDetailsSection() {
	blockUnblockVirtualCardPage.clickOnSubmit();
}

@Then("For invalid TAC submission Message displayed as below")
public void forInvalidTACSubmissionMessageDisplayedAsBelow(io.cucumber.datatable.DataTable dataTable) {
  String expMsg = dataTable.asList().get(0);
  blockUnblockVirtualCardPage.verifyErrMsgForInvalidTac(expMsg);
}

//TC10

@When("I enter valid TAC in Block\\/Unblock Virtual Card screen - Confirm Details section")
public void iEnterValidTACInBlockUnblockVirtualCardScreenConfirmDetailsSection() {
	blockUnblockVirtualCardPage.keyInValidTAC();
}

//TC11

@When("I m navigated to Change Debiting Account screen- Enter Details section")
public void iMNavigatedToChangeDebitingAccountScreenEnterDetailsSection() {
	homePage.clickOnVirtualDebitCard();
	virtualDebitCardOverviewPage.clickOnManageCardSettings();
	virtualDebitCardOverviewPage.clickOnChangeDebitingAcct();
}

@Then("Debit Card numer, Current Debiting account, New Debiting account dropdown and Next button are displayed")
public void debitCardNumerCurrentDebitingAccountNewDebitingAccountDropdownAndNextButtonAreDisplayed() {
	changeDebitingAcctVirtualCardPage.verifyChangeDebitAcctEnterDetailsScreen();
}

//TC12
@When("Select new Debiting account and click on Next button")
public void selectNewDebitingAccountAndClickOnNextButton() {
	changeDebitingAcctVirtualCardPage.selectNewDebitAcct();
}

@When("Key in valid HLB Connect Password")
public void keyInValidHLBConnectPassword(io.cucumber.datatable.DataTable dataTable) {
	changeDebitingAcctVirtualCardPage.keyInHLBConnectPwd(dataTable.asList().get(0));
}

@When("Click on Submit button in Change Debiting Account screen- Confirm Details section")
public void clickOnSubmitButtonInChangeDebitingAccountScreenConfirmDetailsSection() {
	changeDebitingAcctVirtualCardPage.clickOnSubmitBtn();
}

@Then("Verify the response message dispalyed as below, after change in debiting account")
public void verifyTheResponseMessageDispalyedAsBelowAfterChangeInDebitingAccount(io.cucumber.datatable.DataTable dataTable) {
	changeDebitingAcctVirtualCardPage.verifyResponseMsg(dataTable.asList().get(0));
}

@Then("Verify Debit Card and New Debiting Account are displayed")
public void verifyDebitCardAndNewDebitingAccountAreDisplayed() {
	changeDebitingAcctVirtualCardPage.verifyResponsePageElementsAreDisplayed();
}

@Then("Click on Done  button in Change Debiting Account screen- Acknowledgement section")
public void clickOnDoneButtonInChangeDebitingAccountScreenAcknowledgementSection() {
	changeDebitingAcctVirtualCardPage.clickOnDoneBtn();
}


//TC13

@When("Key in Invalid HLB Connect Password")
public void keyInInvalidHLBConnectPassword(io.cucumber.datatable.DataTable dataTable) {
	changeDebitingAcctVirtualCardPage.keyInHLBConnectPwd(dataTable.asList().get(0));
}


@Then("Verify error message dispalyed as below, while changing debiting account")
public void verifyErrorMessageDispalyedAsBelowWhileChangingDebitingAccount(io.cucumber.datatable.DataTable dataTable) {
	changeDebitingAcctVirtualCardPage.verifyErrMsg(dataTable.asList().get(0));
}

//TC14
@When("I m navigated to Set Daily Limit screen - Enter Details section")
public void iMNavigatedToSetDailyLimitScreenEnterDetailsSection() {
	homePage.clickOnVirtualDebitCard();
	virtualDebitCardOverviewPage.clickOnManageCardSettings();
	virtualDebitCardOverviewPage.clickOnSetDailyLimit();
}

@Then("Debit Card , Limit Type, Max Daily Limit, Current Daily Limit, New Daily Limit fields are displayed")
public void debitCardLimitTypeMaxDailyLimitCurrentDailyLimitNewDailyLimitFieldsAreDisplayed() {
	setDailyLimitVirtualCardPage.verifySetDailyLimitScreenEnterDetailsSectionFields();
}
//TC15

@When("Key in valid value for New Daily Limit")
public void keyInValidValueForNewDailyLimit() {
	setDailyLimitVirtualCardPage.KeyInNewLimit();
}

@When("Click on Next button in Set Daily Limit screen - Enter Details section")
public void clickOnNextButtonInSetDailyLimitScreenEnterDetailsSection() {
	setDailyLimitVirtualCardPage.clickOnNextbtn();
}

@When("Key in valid in TAC in Set Daily Limit screen - Confirm Details section")
public void keyInValidInTACInSetDailyLimitScreenConfirmDetailsSection() {
	setDailyLimitVirtualCardPage.KeyInTac();
}

@When("Click on Submit button in Set Daily Limit screen - Confirm Details section")
public void clickOnSubmitButtonInSetDailyLimitScreenConfirmDetailsSection() {
	setDailyLimitVirtualCardPage.clickOnSubmitBtn();
}

@Then("Verfy the response message in Set Daily Limit screen - Acknowledgement section")
public void verfyTheResponseMessageInSetDailyLimitScreenAcknowledgementSection(io.cucumber.datatable.DataTable dataTable) {
	setDailyLimitVirtualCardPage.verifyResponseMsg(dataTable.asList().get(0));
}

@Then("Verify Debit card and New Limit are displayed in Set Daily Limit screen - Acknowledgement section")
public void verifyDebitCardAndNewLimitAreDisplayedInSetDailyLimitScreenAcknowledgementSection() {
	setDailyLimitVirtualCardPage.verifyLimitSetupResultDetails();
}

@Then("Click in Done button in Set Daily Limit screen - Acknowledgement section")
public void clickInDoneButtonInSetDailyLimitScreenAcknowledgementSection() {
	setDailyLimitVirtualCardPage.clickOnDoneBtn();
}

//TC16..TC17
@When("Key in value for New Daily Limit")
public void keyInValueForNewDailyLimit(io.cucumber.datatable.DataTable dataTable) {
	setDailyLimitVirtualCardPage.keyInNewLimitValue(dataTable.asList().get(0));
}

@Then("Verify the error message displayed in Set Daily Limit screen - Enter Details section")
public void verifyTheErrorMessageDisplayedInSetDailyLimitScreenEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
	setDailyLimitVirtualCardPage.verifyErrMsg(dataTable.asList().get(0));
}
//TC18

@When("Key in invalid in TAC in Set Daily Limit screen - Confirm Details section")
public void keyInInvalidInTACInSetDailyLimitScreenConfirmDetailsSection(io.cucumber.datatable.DataTable dataTable) {
	setDailyLimitVirtualCardPage.KeyInInvalidTacVal(dataTable.asList().get(0));
}

@Then("Verfy the error message in Set Daily Limit screen - Confirm Details section")
public void verfyTheErrorMessageInSetDailyLimitScreenConfirmDetailsSection(io.cucumber.datatable.DataTable dataTable) {
	setDailyLimitVirtualCardPage.verifyErrMsg(dataTable.asList().get(0));
}

//TC19
@When("I m navigated to Create\\/Update Note - Enter Details Section")
public void iMNavigatedToCreateUpdateNoteEnterDetailsSection() {
	homePage.clickOnVirtualDebitCard();
	virtualDebitCardOverviewPage.clickOnManageCardSettings();
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	virtualDebitCardOverviewPage.clickOnCreateUpdateNoteMenu();
}

@Then("Virtual Debit Card, Current Note and New note filed are displayed")
public void virtualDebitCardCurrentNoteAndNewNoteFiledAreDisplayed() {
	createUpdateNoteVirtualCardPage.verifyCreateUpdateNoteScreenFields();
}

//TC20

@When("Key in the value for New Note field in Create\\/Update Note screen - Enter Details Section")
public void keyInTheValueForNewNoteFieldInCreateUpdateNoteScreenEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
	createUpdateNoteVirtualCardPage.keyInNewNote(dataTable.asList().get(0));
	
}

@When("Click on Save button in Create\\/Update Note screen - Enter Details Section")
public void clickOnSaveButtonInCreateUpdateNoteScreenEnterDetailsSection() {
	createUpdateNoteVirtualCardPage.clickOnSavebtn();
}

@Then("Response message displayes in Create\\/Update Note screen - Acknowledgement Section")
public void responseMessageDisplayesInCreateUpdateNoteScreenAcknowledgementSection(io.cucumber.datatable.DataTable dataTable) {
	createUpdateNoteVirtualCardPage.verifyResponseMsg(dataTable.asList().get(0));
}

@Then("Debit Card and New Note displayed in Create\\/Update Note screen - Acknowledgement Section")
public void debitCardAndNewNoteDisplayedInCreateUpdateNoteScreenAcknowledgementSection() {
	createUpdateNoteVirtualCardPage.verifyResponseDetails();
}

@When("Click on Done button in Create\\/Update Note screen - Acknowledgement Section")
public void clickOnDoneButtonInCreateUpdateNoteScreenAcknowledgementSection() {
	createUpdateNoteVirtualCardPage.clickOnDoneBtn();
}

}

