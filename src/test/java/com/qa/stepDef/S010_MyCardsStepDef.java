package com.qa.stepDef;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.BlockUnBlockEcommercePage;
import com.qa.pages.BlockUnblockOverseasATMPOSPage;
import com.qa.pages.BlockUnblockPhysicalDebitCardPage;
import com.qa.pages.ChangeDebitingAccountPage;
import com.qa.pages.HomePage;
import com.qa.pages.PhysicalDebitCardOverviewPage;
import com.qa.pages.ResetPinPage;
import com.qa.pages.SetDailyLimitPage;
import com.qa.pages.TravelNotificationServicePage;

import io.cucumber.java.en.*;

public class S010_MyCardsStepDef {

	private WebDriver driver;
	private HomePage homePage;
	private PhysicalDebitCardOverviewPage physicalDebitCardOverviewPage;
	private BlockUnblockPhysicalDebitCardPage blockUnblockPhysicalDebitCardPage;
	private BlockUnBlockEcommercePage blockUnBlockEcommercePage;
	private BlockUnblockOverseasATMPOSPage blockUnblockOverseasATMPOSPage;
	private ChangeDebitingAccountPage  changeDebitingAccountPage;
	private SetDailyLimitPage setDailyLimitPage;
	private TravelNotificationServicePage travelNotificationServicePage;
	private ResetPinPage resetPinPage;
	
	public S010_MyCardsStepDef(TestContext context) {
		driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		physicalDebitCardOverviewPage = PageObjectFactory.getPhysicalDebitCardOverviewPage(driver);
		blockUnblockPhysicalDebitCardPage = PageObjectFactory.getBlockUnblockPhysicalDebitCardPage(driver);
		blockUnBlockEcommercePage = PageObjectFactory.getBlockUnBlockEcommercePage(driver);
		blockUnblockOverseasATMPOSPage = PageObjectFactory.getBlockUnblockOverseasATMPOSPage(driver);
		changeDebitingAccountPage = PageObjectFactory.getChangeDebitingAccountPage(driver);
		setDailyLimitPage = PageObjectFactory.getSetDailyLimitPage(driver);
		travelNotificationServicePage = PageObjectFactory.getTravelNotificationServicePage(driver);
		resetPinPage = PageObjectFactory.getResetPinPage(driver);
	}
	
	//TC01
	@Then("My cards section heading is displayed")
	public void myCardsSectionHeadingIsDisplayed() {
		homePage.verifyMyCardsSectionHeadingIsDisplayed();
	}

	@Then("Type of card is displayed")
	public void typeOfCardIsDisplayed() {
		homePage.verifyTypeOfCardIsDisplayed();
	}

	@Then("Card number last four digits are displayed, reamining digits masked with x")
	public void cardNumberLastFourDigitsAreDisplayedReaminingDigitsMaskedWithX() {
		homePage.verifyCardNumber();
	}

	@Then("Hide\\/Unhide card information icon is displayed")
	public void hideUnhideCardInformationIconIsDisplayed() {
		homePage.verifyHideUnhideIconIsDisplayed();
	}
  
	//TC02, TC03
	
	@When("I m navigated to Physical Debit Card Overview page")
	public void iMNavigatedToPhysicalDebitCardOverviewPage() {
		homePage.clickOnPhysicalDebitCard();
	}

	@Then("Card number, Valid through, CVV, Account Balance, Linked Account, Card status are displayed")
	public void cardNumberValidThroughCVVAccountBalanceLinkedAccountCardStatusAreDisplayed() {
		physicalDebitCardOverviewPage.verifyCardNumberIsDisplayed();
		physicalDebitCardOverviewPage.verifyValidThroughIsDisplayed();
		physicalDebitCardOverviewPage.verifyCvvIsDisplayed();
		physicalDebitCardOverviewPage.verifyAccountBalanceIsDisplayed();
		physicalDebitCardOverviewPage.verifyLinkedAccountIsDisplayed();
		physicalDebitCardOverviewPage.verifyCardStatusIsDisplayed();
	}

	@Then("Manage Card Settings option is displayed")
	public void manageCardSettingsOptionIsDisplayed() {
		physicalDebitCardOverviewPage.verifyManageSettinsgMenuIsDisplayed();
	}

	@Then("Transaction Timeline label is displayed")
	public void transactionTimelineLabelIsDisplayed() {
		physicalDebitCardOverviewPage.verifyTransactionTimeLineLabelIsDisplayed();
	}

	@Then("Transaction timeline table displayed with columns headers Ref No., Date, Description, Incoming, Outgoing")
	public void transactionTimelineTableDisplayedWithColumnsHeadersRefNoDateDescriptionIncomingOutgoing() {
		physicalDebitCardOverviewPage.verifyTransactionTimeLineTableHeadings();
	}

	//TC04, TC05
	
	@When("I click on Manage Card Settings menu")
	public void iClickOnManageCardSettingsMenu() {
		physicalDebitCardOverviewPage.clickOnManageCardSettings();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("verify specified options are displayed")
	public void verifySpecifiedOptionsAreDisplayed() {
		physicalDebitCardOverviewPage.verifyManageCardSettingOptionsAreDisplayed();
	}

	@When("I m navigated to Block\\/Unblock Physical Card screen")
	public void iMNavigatedToBlockUnblockPhysicalCardScreen() {
		homePage.clickOnPhysicalDebitCard();
		physicalDebitCardOverviewPage.clickOnManageCardSettings();
		physicalDebitCardOverviewPage.clickOnBlockUnBlockPhysicalDebitCard();
	}

	@When("I click on Block button")
	public void iClickOnBlockButton() {
		blockUnblockPhysicalDebitCardPage.clickOnBlockBtn();
	}

	@Then("Card blocked successfully with message")
	public void cardBlockedSuccessfullyWithMessage(io.cucumber.datatable.DataTable dataTable) {
	   
		
		List<String> blockMsg = dataTable.asList();
		blockUnblockPhysicalDebitCardPage.verifyCardBlockMessage(blockMsg.get(0));
		blockUnblockPhysicalDebitCardPage.clickOnDoneBtn();
	    
	}

	@When("I click on Unblock button")
	public void iClickOnUnblockButton() {
		blockUnblockPhysicalDebitCardPage.clickOnUnblockBtn();
	}

	@When("I enter TAC to unblock the physical debit card")
	public void iEnterTACToUnblockThePhysicalDebitCard() {
		blockUnblockPhysicalDebitCardPage.keyInTac();
	}

	@When("I click on Submit button to unblock physical debit card")
	public void iClickOnSubmitButtonToUnblockPhysicalDebitCard() {
		blockUnblockPhysicalDebitCardPage.clickOnSubmitBtn();
	}

	@Then("Card unblocked successfully with message")
	public void cardUnblockedSuccessfullyWithMessage(io.cucumber.datatable.DataTable dataTable) {
	    
		List<String> expUnblockMsg = dataTable.asList();
		blockUnblockPhysicalDebitCardPage.verifyCardUnBlockMessage(expUnblockMsg.get(0));
	  
	}

	//TC06
	@When("I m navigated to Block\\/Unblock E-commerce screen")
	public void iMNavigatedToBlockUnblockECommerceScreen() {
		homePage.clickOnPhysicalDebitCard();
		physicalDebitCardOverviewPage.clickOnManageCardSettings();
		physicalDebitCardOverviewPage.clickOnBlockUnblockEcommerce();
		
	}


@When("I click on Block button to block E-commerce")
public void iClickOnBlockButtonToBlockECommerce() {
	blockUnBlockEcommercePage.clickOnBlockBtn();
}

@Then("I click on Done button")
public void iClickOnDoneButton() {
	blockUnBlockEcommercePage.clickOnDoneBtn();
}

@Then("I m navigated to Home screen")
public void iMNavigatedToHomeScreen() {
	homePage.verifyHideUnhideIconIsDisplayed();
}

@When("I click on Unblock button to Unblock E-commerce")
public void iClickOnUnblockButtonToUnblockECommerce() {
	blockUnBlockEcommercePage.clickOnUnblockBtn();
}

@When("I enter TAC to unblock the E-commerce")
public void iEnterTACToUnblockTheECommerce() {
	blockUnBlockEcommercePage.keyInTac();
}

@When("I click on Submit button to unblock E-commerce")
public void iClickOnSubmitButtonToUnblockECommerce() {
	blockUnBlockEcommercePage.clickOnSubmitBtn();
}


@Then("Card blocked successfully for E-commerce with message")
public void cardBlockedSuccessfullyForECommerceWithMessage(io.cucumber.datatable.DataTable dataTable) {
  
	List<String> expMsg = dataTable.asList();
	blockUnBlockEcommercePage.verifyEcommerceBlockMessage(expMsg.get(0));
	
}

@Then("I click on Done button in Block\\/Unblock E-commerce screen")
public void iClickOnDoneButtonInBlockUnblockECommerceScreen() {
	blockUnBlockEcommercePage.clickOnDoneBtn();
}

@Then("Card unblocked successfully for E-commerce with message")
public void cardUnblockedSuccessfullyForECommerceWithMessage(io.cucumber.datatable.DataTable dataTable) {
	List<String> expMsg = dataTable.asList();
	blockUnBlockEcommercePage.verifyEcommerceUnblockMessage(expMsg.get(0));
}

//S10_TC07


@When("I m navigated to Block\\/Unblock Overseas ATM\\/POS screen")
public void iMNavigatedToBlockUnblockOverseasATMPOSScreen() {
	homePage.clickOnPhysicalDebitCard();
	physicalDebitCardOverviewPage.clickOnManageCardSettings();
	physicalDebitCardOverviewPage.clickOnBlockUnblockOverseasATMPOS();
}

@When("I click on block button in Block\\/Unblock Overseas ATM\\/POS screen")
public void iClickOnBlockButtonInBlockUnblockOverseasATMPOSScreen() {
	blockUnblockOverseasATMPOSPage.clickOnBlockBtn();
}

@Then("Overseas ATM\\/POS blocked successfully with message")
public void overseasATMPOSBlockedSuccessfullyWithMessage(io.cucumber.datatable.DataTable dataTable) {
	
	List<String> expMsg = dataTable.asList();
	
	blockUnblockOverseasATMPOSPage.verifyBlockOverseasATMPOSMessage(expMsg.get(0));
}

@Then("I click on Done button in Block\\/Unblock Overseas ATM\\/POS screen")
public void iClickOnDoneButtonInBlockUnblockOverseasATMPOSScreen() {
	blockUnblockOverseasATMPOSPage.clickOnDoneBtn();
}

@When("click on Unblock button in Block\\/Unblock Overseas ATM\\/POS screen")
public void clickOnUnblockButtonInBlockUnblockOverseasATMPOSScreen() {
	blockUnblockOverseasATMPOSPage.clickOnUnblockBtn();
}

@When("I enter TAC to unblock Oversaes ATM\\/POS")
public void iEnterTACToUnblockOversaesATMPOS() {
	blockUnblockOverseasATMPOSPage.keyInTac();
	
}

@When("I click on Submit button to Unblock Oversaes ATM\\/POS")
public void iClickOnSubmitButtonToUnblockOversaesATMPOS() {
	blockUnblockOverseasATMPOSPage.clickOnSubmitBtn();
}

@Then("Overseas ATM\\/POS Unblock successfully with message")
public void overseasATMPOSUnblockSuccessfullyWithMessage(io.cucumber.datatable.DataTable dataTable) {
	
	List<String> expMsg = dataTable.asList();
	
	blockUnblockOverseasATMPOSPage.verifyUnblockMessage(expMsg.get(0));
}

//S010_TC08

@When("I m navigated to Change Debiting Account screen")
public void iMNavigatedToChangeDebitingAccountScreen() {
	homePage.clickOnPhysicalDebitCard();
	physicalDebitCardOverviewPage.clickOnManageCardSettings();
	physicalDebitCardOverviewPage.clickOnChangeDebitingAccount();
}

@When("I select new debiting account and click next button")
public void iSelectNewDebitingAccountAndClickNextButton() {
	changeDebitingAccountPage.selectNewDebitAcct();
	//changeDebitingAccountPage.clickOnNextBtn();
}

@When("I key in HLB Connect password")
public void iKeyInHLBConnectPassword() {
	changeDebitingAccountPage.keyInPassword();
}

@When("I click on Submit button in Change Debiting Account screen")
public void iClickOnSubmitButtonInChangeDebitingAccountScreen() {
	changeDebitingAccountPage.clickOnSubmitBtn();
}

@Then("Debiting account successfully changed with message")
public void debitingAccountSuccessfullyChangedWithMessage(io.cucumber.datatable.DataTable dataTable) {
	List<String> expMsg = dataTable.asList();
	changeDebitingAccountPage.verifySuccessMsg(expMsg.get(0));
}
//S10_TC09

@When("I key in invalid HLB Connect password")
public void iKeyInInvalidHLBConnectPassword(io.cucumber.datatable.DataTable dataTable) {
	List<String> pwd = dataTable.asList();
	changeDebitingAccountPage.keyInInvalidPassword(pwd.get(0));
}

@Then("Error message displayed")
public void errorMessageDisplayed(io.cucumber.datatable.DataTable dataTable) {
	List<String> errMsg = dataTable.asList();
	changeDebitingAccountPage.verifyErrorMsg(errMsg.get(0));
}

//TC10
@When("I m navigated to Set Daily Limit screen")
public void iMNavigatedToSetDailyLimitScreen() {
	homePage.clickOnPhysicalDebitCard();
	physicalDebitCardOverviewPage.clickOnManageCardSettings();
	physicalDebitCardOverviewPage.clickOnSetDailyLimit();
	
}

@When("key in valid Purchase Limit")
public void keyInValidPurchaseLimit() {
	setDailyLimitPage.keyInValidPurchaseLimit();;
}

@When("Key in valid Withdrawl Limit")
public void keyInValidWithdrawlLimit() {
	setDailyLimitPage.keyInNewWithDrawlLimit();
}

@When("click on Next button in Set Daily Limit screen")
public void clickOnNextButtonInSetDailyLimitScreen() {
	
	setDailyLimitPage.clickOnNextbtn();
}

@When("key in TAC value in Set Daily Limit screen")
public void keyInTACValueInSetDailyLimitScreen() {
	setDailyLimitPage.keyInTac();
}

@When("click on Submit button in Set Daily Limit screen")
public void clickOnSubmitButtonInSetDailyLimitScreen() {
	setDailyLimitPage.clickOnSubmitBtn();
}

@Then("verify the success message in Set Daily Limit screen")
public void verifyTheSuccessMessageInSetDailyLimitScreen(io.cucumber.datatable.DataTable dataTable) {
   
	String expMsg = dataTable.asList().get(0);
	setDailyLimitPage.verifyResult(expMsg);
}

//TC11, TC12


@When("Key in Purchase Limit")
public void keyInPurchaseLimit(io.cucumber.datatable.DataTable dataTable) {
 
	String purchaseLimit = dataTable.asList().get(0);
	setDailyLimitPage.keyInPurchaseLimit(purchaseLimit);
	
}

@When("Move cursor focus to Withdrawal Limit	input box")
public void moveCursorFocusToWithdrawalLimitInputBox() {
	setDailyLimitPage.focusOnWithdrawalLimitBox();
}

@Then("Verify the error message")
public void verifyTheErrorMessage(io.cucumber.datatable.DataTable dataTable) {
    String errMsg = dataTable.asList().get(0);
    setDailyLimitPage.verifyErrorMsg(errMsg);
}

@When("Key in Withdrawal Limit")
public void keyInWithdrawalLimit(io.cucumber.datatable.DataTable dataTable) {
	String withdrawlLimit = dataTable.asList().get(0);
	setDailyLimitPage.keyInWithdrawlLimit(withdrawlLimit);
}

@When("Move cursor focus to Purchase Limit	input box")
public void moveCursorFocusToPurchaseLimitInputBox() {
	setDailyLimitPage.focusOnPurchaseLimitBox();
}

//TC14
@When("key in invalid TAC value in Set Daily Limit screen")
public void keyInInvalidTACValueInSetDailyLimitScreen(io.cucumber.datatable.DataTable dataTable) {
  
	String invaldiTac = dataTable.asList().get(0);
	setDailyLimitPage.keyInInvalidTac(invaldiTac);
}

@Then("Verify the error message in Set Daily Limit screen")
public void verifyTheErrorMessageInSetDailyLimitScreen(io.cucumber.datatable.DataTable dataTable) {
   String errMsg = dataTable.asList().get(0);
   setDailyLimitPage.verifyErrorMsg(errMsg);
}

//TC15

@When("I m navigated to Travel Notification Services Enter Details screen")
public void iMNavigatedToTravelNotificationServicesEnterDetailsScreen() {
	homePage.clickOnPhysicalDebitCard();
	physicalDebitCardOverviewPage.clickOnManageCardSettings();
	physicalDebitCardOverviewPage.clickOnTravelNotificationService();
	travelNotificationServicePage.clickOnCreateTravelNotificationBtn();
	
	
}

@When("Key in Start Date")
public void keyInStartDate(io.cucumber.datatable.DataTable dataTable) {
	
	String startDate = dataTable.asList().get(0);
	travelNotificationServicePage.keyInStartDate(startDate);
}

@When("Key in End Date")
public void keyInEndDate(io.cucumber.datatable.DataTable dataTable) {
   
	String endDate = dataTable.asList().get(0);
	travelNotificationServicePage.keyInEndDate(endDate);
}


@When("Select Destination country name, number")
public void selectDestinationCountryNameNumber(io.cucumber.datatable.DataTable dataTable) {
   
	List<Map<String, String>> country = dataTable.asMaps();
	
	String countryName = country.get(0).get("cName");
	String countryNumber = country.get(0).get("cNumber");
	
	travelNotificationServicePage.clickOnDestination();
	travelNotificationServicePage.keyInSearchCountry(countryName);
	travelNotificationServicePage.selectCountry(countryNumber);
	travelNotificationServicePage.clickOnNextBtnInPopUp();
	travelNotificationServicePage.clickOnNextBtnInEnterDetailsSection();
}

@When("Click on Submit button in Travel Notification Service screen")
public void clickOnSubmitButtonInTravelNotificationServiceScreen() {
	travelNotificationServicePage.clickOnSubmitBtn();
}

@Then("Verify the result message")
public void verifyTheResultMessage(io.cucumber.datatable.DataTable dataTable) {
	String expMsg = dataTable.asList().get(0);
	travelNotificationServicePage.verifyResultMsg(expMsg);
}

@Then("Debit Card, Travel Notification Service, From, To and Destination Countires are displayed")
public void debitCardTravelNotificationServiceFromToAndDestinationCountiresAreDisplayed() {
	travelNotificationServicePage.verifyCreateTravelNotificationResultDetails();
}

@Then("Click on Done button in Travel Notification Service screen")
public void clickOnDoneButtonInTravelNotificationServiceScreen() {
	travelNotificationServicePage.clickOnDoneBtn();
}

@Then("User is navigated to Home page")
public void userIsNavigatedToHomePage() {
	homePage.verifyMyCardsSectionHeadingIsDisplayed();
}

//TC16
@Then("Card, Date Range, Destinations are displayed")
public void cardDateRangeDestinationsAreDisplayed() {
	travelNotificationServicePage.verifyLabelsInEnterDetailsSection();
}

//TC17
@When("I m navigated to Travel Notification Services")
public void iMNavigatedToTravelNotificationServices() {
	homePage.clickOnPhysicalDebitCard();
	physicalDebitCardOverviewPage.clickOnManageCardSettings();
	physicalDebitCardOverviewPage.clickOnTravelNotificationService();
}

@Then("Card Details, Date Range, Destination Countries, Action and Create Travel Notification button are displayed")
public void cardDetailsDateRangeDestinationCountriesActionAndCreateTravelNotificationButtonAreDisplayed() {
	travelNotificationServicePage.verifyExistingNotificationDetailsScreen();
}

//TC18

@When("I click on Action bin icon")
public void iClickOnActionBinIcon() {
	travelNotificationServicePage.clickOnDeleteIcon();
}

@When("I click on No button in confirmation pop up message")
public void iClickOnNoButtonInConfirmationPopUpMessage() {
	travelNotificationServicePage.clickOnNoBtnInPopUp();
}

@Then("I m directed back to Travel notification main screen")
public void iMDirectedBackToTravelNotificationMainScreen() {
	travelNotificationServicePage.verifyExistingNotificationDetailsScreen();
}

//TC19
@When("I click on Yes button in confirmation pop up message")
public void iClickOnYesButtonInConfirmationPopUpMessage() {
	travelNotificationServicePage.clickOnYesBtnInPopUp();
}

@Then("Success message displayed as below")
public void successMessageDisplayedAsBelow(io.cucumber.datatable.DataTable dataTable) {
   String expMsg = dataTable.asList().get(0);
   travelNotificationServicePage.verifyResultMsg(expMsg);
}

@Then("Debit Card, Travel Notification Status, From, To, Destination Countries are displayed")
public void debitCardTravelNotificationStatusFromToDestinationCountriesAreDisplayed() {
	travelNotificationServicePage.verifyDeleteTravelNotificationResultDetails();
}

@Then("I click on Done button in Travel Notification Services Screen")
public void iClickOnDoneButtonInTravelNotificationServicesScreen() {
	travelNotificationServicePage.clickOnDoneBtn();
}

//TC20
@When("I m navigated to Reset PIN page")
public void iMNavigatedToResetPINPage() {
	homePage.clickOnPhysicalDebitCard();
	physicalDebitCardOverviewPage.clickOnManageCardSettings();
	physicalDebitCardOverviewPage.clickOnResetPINMenu();
}

@When("Key in Create New Card PIN")
public void keyInCreateNewCardPIN(io.cucumber.datatable.DataTable dataTable) {
	String newPin=dataTable.asList().get(0);
	resetPinPage.keyInNewPin(newPin);
}

@When("Key in Confirm New Card PIN")
public void keyInConfirmNewCardPIN(io.cucumber.datatable.DataTable dataTable) {
  String confirmPin = dataTable.asList().get(0);
  resetPinPage.keyInConfirmPin(confirmPin);
}

@When("Click on Next button in Reset PIN - Enter Details section")
public void clickOnNextButtonInResetPINEnterDetailsSection() {
	resetPinPage.clickOnNextbtn();
}

@When("Key in TAC value in Reset PIN - Confirm Details section")
public void keyInTACValueInResetPINConfirmDetailsSection() {
	resetPinPage.keyInTac();
}

@When("Click on Confirm button in Reset PIN - Confirm Details section")
public void clickOnConfirmButtonInResetPINConfirmDetailsSection() {
	resetPinPage.clickOnConfirmBtn();
}

@Then("Verify the message displayed")
public void verifyTheMessageDisplayed(io.cucumber.datatable.DataTable dataTable) {
	String expMsg = dataTable.asList().get(0);
	resetPinPage.verifyResultMessage(expMsg);
}

@Then("Verify Debit Card and PIN Status are displayed")
public void verifyDebitCardAndPINStatusAreDisplayed() {
	resetPinPage.verifyDebitCardAndPinStatusAreDisplayed();
}

@Then("I click on Done button in Reset PIN - Acknowledgement section")
public void iClickOnDoneButtonInResetPINAcknowledgementSection() {
	resetPinPage.clickOnDoneBtn();
}
//TC20

@When("Key in Invalid TAC value in Reset PIN - Confirm Details section")
public void keyInInvalidTACValueInResetPINConfirmDetailsSection(io.cucumber.datatable.DataTable dataTable) {

	resetPinPage.KeyInInvalidTac(dataTable.asList().get(0));
}


@Then("Verify the error message displayed for TAC")
public void verifyTheErrorMessageDisplayed(io.cucumber.datatable.DataTable dataTable) {
	resetPinPage.verifyErrorMsgTac(dataTable.asList().get(0));
}

//TC21

@Then("Verify the error message displayed for PIN")
public void verifyTheErrorMessageDisplayedForPIN(io.cucumber.datatable.DataTable dataTable) {
	resetPinPage.verifyErrorMsgPin(dataTable.asList().get(0));
}


}
