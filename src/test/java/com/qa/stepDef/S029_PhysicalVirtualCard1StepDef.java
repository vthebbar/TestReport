package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.BlockUnBlockEcommercePage;
import com.qa.pages.BlockUnblockOverseasATMPOSPage;
import com.qa.pages.BlockUnblockPhysicalDebitCardPage;
import com.qa.pages.ChangeDebitingAccountPage;
import com.qa.pages.HomePage;
import com.qa.pages.SetDailyLimitPage;

import io.cucumber.java.en.*;

public class S029_PhysicalVirtualCard1StepDef {
	
	private WebDriver driver;
	private HomePage homePage;
	private BlockUnblockPhysicalDebitCardPage blockUnblockPhysicalDebitCardPage;
	private BlockUnBlockEcommercePage blockUnBlockEcommercePage;
	private BlockUnblockOverseasATMPOSPage blockUnblockOverseasATMPOSPage;
	private ChangeDebitingAccountPage changeDebitingAccountPage;
	private SetDailyLimitPage setDailyLimitPage;
	
	
	public S029_PhysicalVirtualCard1StepDef(TestContext context) {
		driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		blockUnblockPhysicalDebitCardPage = PageObjectFactory.getBlockUnblockPhysicalDebitCardPage(driver);
		blockUnBlockEcommercePage = PageObjectFactory.getBlockUnBlockEcommercePage(driver);
		blockUnblockOverseasATMPOSPage = PageObjectFactory.getBlockUnblockOverseasATMPOSPage(driver);
		changeDebitingAccountPage = PageObjectFactory.getChangeDebitingAccountPage(driver);
		setDailyLimitPage = PageObjectFactory.getSetDailyLimitPage(driver);
	}
	
	@And("I m on Physical & Virtual Card Overview Section")
	public void iMOnPhysicalVirtualCardOverviewSection() {
		homePage.clickOnPhysicalAndVirtualCardMenu();
	}

	//TC01
	@Then("Verify that all labels and submenus are displayed")
	public void verifyThatAllLabelsAndSubmenusAreDisplayed() {
		homePage.verifyPhysicalAndVirtualCardSubMenus();
	}

	//TC02
	@When("I click on Block\\/Unblock sub menu for physical card")
	public void iClickOnBlockUnblockSubMenuForPhysicalCard() {
		homePage.clickOnBlockUnblockMenuPhysicalCard();
	}

	@When("I click on Block button in Block\\/Unblock Physical Card screen")
	public void iClickOnBlockButtonInBlockUnblockPhysicalCardScreen() {
		blockUnblockPhysicalDebitCardPage.clickOnBlockBtn();
	}

	@Then("Card block successful message displayed as below in Block\\/Unblock Physical Card screen")
	public void cardBlockSuccessfulMessageDisplayedAsBelowInBlockUnblockPhysicalCardScreen(io.cucumber.datatable.DataTable dataTable) {
		blockUnblockPhysicalDebitCardPage.verifyCardBlockMessage(dataTable.asList().get(0));
	}

	@Then("I click on Done button in Block\\/Unblock Physical Card screen")
	public void iClickOnDoneButtonInBlockUnblockPhysicalCardScreen() {
		blockUnblockPhysicalDebitCardPage.clickOnDoneBtn();
	}
	
	//TC03
	@When("I click on Unblock button in Block\\/Unblock Physical Card screen")
	public void iClickOnUnblockButtonInBlockUnblockPhysicalCardScreen() {
		blockUnblockPhysicalDebitCardPage.clickOnUnblockBtn();
	}

	@When("I enter the valid TAC in Block\\/Unblock Physical Card screen")
	public void iEnterTheValidTACInBlockUnblockPhysicalCardScreen() {
		blockUnblockPhysicalDebitCardPage.keyInTac();
	}

	@When("I click on Submit button in Block\\/Unblock Physical Card screen")
	public void iClickOnSubmitButtonInBlockUnblockPhysicalCardScreen() {
		blockUnblockPhysicalDebitCardPage.clickOnSubmitBtn();
	}

	@Then("Card Unblock successful message displayed as below in Block\\/Unblock Physical Card screen")
	public void cardUnblockSuccessfulMessageDisplayedAsBelowInBlockUnblockPhysicalCardScreen(io.cucumber.datatable.DataTable dataTable) {
		blockUnblockPhysicalDebitCardPage.verifyCardUnBlockMessage(dataTable.asList().get(0));
	}

	//TC04
	@When("I click on Block\\/Unblock E-commerce sub menu for physical card")
	public void iClickOnBlockUnblockECommerceSubMenuForPhysicalCard() {
		homePage.clickOnBlockUnblockEcommercePhycialCard();
	}

	@When("I click on Block button in Block\\/Unblock E-Commerce page")
	public void iClickOnBlockButtonInBlockUnblockECommercePage() {
		blockUnBlockEcommercePage.clickOnBlockBtn();
	}

	@Then("Ecommerce blocking successful message displayed in Block\\/Unblock E-Commerce page")
	public void ecommerceBlockingSuccessfulMessageDisplayedInBlockUnblockECommercePage(io.cucumber.datatable.DataTable dataTable) {
		blockUnBlockEcommercePage.verifyEcommerceBlockMessage(dataTable.asList().get(0));
	}

	@Then("I click on Done button in Block\\/Unblock E-Commerce page")
	public void iClickOnDoneButtonInBlockUnblockECommercePage() {
		blockUnBlockEcommercePage.clickOnDoneBtn();
	}
	
	//TC05
	@When("I click on Unblock button in Block\\/Unblock E-Commerce page")
	public void iClickOnUnblockButtonInBlockUnblockECommercePage() {
		blockUnBlockEcommercePage.clickOnUnblockBtn();
	}

	@When("I enter the valid TAC in Block\\/Unblock E-Commerce page")
	public void iEnterTheValidTACInBlockUnblockECommercePage() {
		blockUnBlockEcommercePage.keyInTac();
	}

	@When("I click on Submit button in Block\\/Unblock E-Commerce page")
	public void iClickOnSubmitButtonInBlockUnblockECommercePage() {
		blockUnBlockEcommercePage.clickOnSubmitBtn();
	}

	@Then("Ecommerce Unblock successful message displayed in Block\\/Unblock E-Commerce page")
	public void ecommerceUnblockSuccessfulMessageDisplayedInBlockUnblockECommercePage(io.cucumber.datatable.DataTable dataTable) {
		blockUnBlockEcommercePage.verifyEcommerceUnblockMessage(dataTable.asList().get(0));
	}
	
	//TC06
	@When("I click on Block\\/Unblock Overseas ATM\\/POS sub menu for physical card")
	public void iClickOnBlockUnblockOverseasATMPOSSubMenuForPhysicalCard() {
		homePage.clcikOnBlockUnBlockOverseasATMPOSPhysicalCard();
	}

	@When("I click on Block button in Block\\/Unblock Overseas ATM\\/POS page")
	public void iClickOnBlockButtonInBlockUnblockOverseasATMPOSPage() {
		blockUnblockOverseasATMPOSPage.clickOnBlockBtn();
	}

	@When("Verify success message is displayed in Block\\/Unblock Overseas ATM\\/POS page")
	public void verifySuccessMessageIsDisplayedInBlockUnblockOverseasATMPOSPage(io.cucumber.datatable.DataTable dataTable) {
		blockUnblockOverseasATMPOSPage.verifyBlockOverseasATMPOSMessage(dataTable.asList().get(0));
	}

	@When("I click on Done button in Block\\/Unblock Overseas ATM\\/POS page")
	public void iClickOnDoneButtonInBlockUnblockOverseasATMPOSPage() {
		blockUnblockOverseasATMPOSPage.clickOnDoneBtn();
	}
	
	//TC07
	@When("I click on Unblock button in Block\\/Unblock Overseas ATM\\/POS page")
	public void iClickOnUnblockButtonInBlockUnblockOverseasATMPOSPage() {
		blockUnblockOverseasATMPOSPage.clickOnUnblockBtn();
	}

	@When("I enter the valid TAC in Block\\/Unblock Overseas ATM\\/POS page")
	public void iEnterTheValidTACInBlockUnblockOverseasATMPOSPage() {
		blockUnblockOverseasATMPOSPage.keyInTac();
	}

	@When("I click on Submit button in Block\\/Unblock Overseas ATM\\/POS page")
	public void iClickOnSubmitButtonInBlockUnblockOverseasATMPOSPage() {
		blockUnblockOverseasATMPOSPage.clickOnSubmitBtn();
	}

	@Then("Verify Unblock success message displayed in Block\\/Unblock Overseas ATM\\/POS page")
	public void verifyUnblockSuccessMessageDisplayedInBlockUnblockOverseasATMPOSPage(io.cucumber.datatable.DataTable dataTable) {
		blockUnblockOverseasATMPOSPage.verifyUnblockMessage(dataTable.asList().get(0));
	}

	//TC08
	@When("I click on Change Debiting Account sub menu for physical card")
	public void iClickOnChangeDebitingAccountSubMenuForPhysicalCard() {
		homePage.clickOnChangeDebitingAccountSubMenu();
	}

	@Then("Verify that Debit Card, Current Debiting Account, New Debiting Account and Next button are displayed")
	public void verifyThatDebitCardCurrentDebitingAccountNewDebitingAccountAndNextButtonAreDisplayed() {
		changeDebitingAccountPage.verifyDetailsEntrySection();
	}

	//TC09
	@When("I select New Debiting Account from dropdown in Change Debiting Account screen - Enter Details section")
	public void iSelectNewDebitingAccountFromDropdownInChangeDebitingAccountScreenEnterDetailsSection() {
		changeDebitingAccountPage.selectNewDebitAcct();
	}

	@When("I click on Next button in Change Debiting Account screen - Enter Details section")
	public void iClickOnNextButtonInChangeDebitingAccountScreenEnterDetailsSection() {
		//changeDebitingAccountPage.clickOnNextBtn();
		//This action covered in previous step : changeDebitingAccountPage.selectNewDebitAcct()
	}

	@Then("Verify that Debit Card, New Debiting Account, HLB Connect Password field, Back and Submit button are displayed")
	public void verifyThatDebitCardNewDebitingAccountHLBConnectPasswordFieldBackAndSubmitButtonAreDisplayed() {
		changeDebitingAccountPage.verifyConfirmDetailsSection();
	}
	
	//TC10
	@When("I key in HLB Connect password in Change Debiting Account screen - Confirm Details section")
	public void iKeyInHLBConnectPasswordInChangeDebitingAccountScreenConfirmDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		changeDebitingAccountPage.keyInPassword();
	}

	@When("I click on Submit button in Change Debiting Account screen - Confirm Details section")
	public void iClickOnSubmitButtonInChangeDebitingAccountScreenConfirmDetailsSection() {
		changeDebitingAccountPage.clickOnSubmitBtn();
	}

	@Then("Verify that success message is displayed in Change Debiting Account screen - Acknowledgement section")
	public void verifyThatSuccessMessageIsDisplayedInChangeDebitingAccountScreenAcknowledgementSection(io.cucumber.datatable.DataTable dataTable) {
		changeDebitingAccountPage.verifySuccessMsg(dataTable.asList().get(0));
	}

	@Then("Verify Debit Account and New Debit Account are displayed in Change Debiting Account screen - Acknowledgement section")
	public void verifyDebitAccountAndNewDebitAccountAreDisplayedInChangeDebitingAccountScreenAcknowledgementSection() {
		changeDebitingAccountPage.verifyAcknowledgenebtDetialsSection();
	}

	@Then("I click on Done button in Change Debiting Account screen - Acknowledgement section")
	public void iClickOnDoneButtonInChangeDebitingAccountScreenAcknowledgementSection() {
		changeDebitingAccountPage.clickOnDoneBtn();
	}

	//TC11
	@When("I click on Set Daily Limit Submeu for physical card")
	public void iClickOnSetDailyLimitSubmeuForPhysicalCard() {
		homePage.clickOnSetDailyLimitSubMenuPhysicalCard();
	}

	@Then("Verify Debit Card is displayed in Set Daily Limit - Enter Details section")
	public void verifyDebitCardIsDisplayedInSetDailyLimitEnterDetailsSection() {
		setDailyLimitPage.verifyDebitCardIsDisplayed();
	}

	@Then("Verify labels Transaction Type, Max Daily Limit, Current Daily Limit and New Daily Limit are displayed")
	public void verifyLabelsTransactionTypeMaxDailyLimitCurrentDailyLimitAndNewDailyLimitAreDisplayed() {
		setDailyLimitPage.verifyTableHeadersAreDisplayed();
	}

	@Then("Verify Purchase Limit label and values are displayed in Set Daily Limit Screen - Enter Details section")
	public void verifyPurchaseLimitLabelAndValuesAreDisplayedInSetDailyLimitScreenEnterDetailsSection() {
		setDailyLimitPage.verifyPurchaseLimitValuesDisplayed();
	}

	@Then("Verify Withdrawal Limit label and values are displayed in Set Daily Limit Screen - Enter Details section")
	public void verifyWithdrawalLimitLabelAndValuesAreDisplayedInSetDailyLimitScreenEnterDetailsSection() {
		setDailyLimitPage.verifyWithdrawlLimitValuesDisplayed();
	}
	
	//TC12
	@When("Key in New Daily Purchase Limit value USD in Set Daily Limit - Enter Details section")
	public void keyInNewDailyPurchaseLimitValueUSDInSetDailyLimitEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		setDailyLimitPage.keyInPurchaseLimit(dataTable.asList().get(0));
	}

	@Then("Verify the error message displayed in Set Daily Limit - Enter Details section")
	public void verifyTheErrorMessageDisplayedInSetDailyLimitEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		setDailyLimitPage.verifyErrorMsg(dataTable.asList().get(0));
	}

	//TC14
	@When("Key in New Daily Withdrawl Limit value USD in Set Daily Limit - Enter Details section")
	public void keyInNewDailyWithdrawlLimitValueUSDInSetDailyLimitEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		setDailyLimitPage.keyInWithdrawlLimit(dataTable.asList().get(0));
	}

	//TC16
	@When("I key in New Daily Purchase limit and New Daily WithDrawl Limit in Set Daily Limit - Enter Details section")
	public void iKeyInNewDailyPurchaseLimitAndNewDailyWithDrawlLimitInSetDailyLimitEnterDetailsSection() {
		setDailyLimitPage.keyInValidPurchaseLimit();
		setDailyLimitPage.keyInNewWithDrawlLimit();
	}

	@When("I click on Next button in Set Daily Limit - Enter Details section")
	public void iClickOnNextButtonInSetDailyLimitEnterDetailsSection() {
		setDailyLimitPage.clickOnNextbtn();
	}

	@Then("Verify the Set Daily Limit - Confirm Details section")
	public void verifyTheSetDailyLimitConfirmDetailsSection() {
		setDailyLimitPage.verifyConfirmDetailsSection();
	}
	
	//TC17
	@When("I key in valid TAC in Set Daily Limit - Confirm Details section")
	public void iKeyInValidTACInSetDailyLimitConfirmDetailsSection() {
		setDailyLimitPage.keyInTac();
	}

	@When("I click on Submit button in Set Daily Limit - Confirm Details section")
	public void iClickOnSubmitButtonInSetDailyLimitConfirmDetailsSection() {
		setDailyLimitPage.clickOnSubmitBtn();
	}

	@Then("Verify the success message in Set Daily Limit - Acknowledgement section")
	public void verifyTheSuccessMessageInSetDailyLimitAcknowledgementSection(io.cucumber.datatable.DataTable dataTable) {
		setDailyLimitPage.verifyResult(dataTable.asList().get(0));
	}

	@Then("Verify that other acknowledgement details are displayed")
	public void verifyThatOtherAcknowledgementDetailsAreDisplayed() {
		setDailyLimitPage.verifyAcknowledgementSection();
	}

	@Then("I click on Done button in Set Daily Limit - Acknowledgement section")
	public void iClickOnDoneButtonInSetDailyLimitAcknowledgementSection() {
		setDailyLimitPage.clickOnDoneBtn();
	}

	//TC18
	@When("I key in invalid TAC in Set Daily Limit - Confirm Details section")
	public void iKeyInInvalidTACInSetDailyLimitConfirmDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		setDailyLimitPage.keyInInvalidTac(dataTable.asList().get(0));
	}

	@Then("Verify the error message in Set Daily Limit - Confirm Details section")
	public void verifyTheErrorMessageInSetDailyLimitConfirmDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		setDailyLimitPage.verifyErrorMsg(dataTable.asList().get(0));
	}
	
	//TC20
	
	@When("I click on Travel Notification Services submenu for physical card")
	public void iClickOnTravelNotificationServicesSubmenuForPhysicalCard() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Verify all specified details are displayed in Travel Notification Services - Enter Details section")
	public void verifyAllSpecifiedDetailsAreDisplayedInTravelNotificationServicesEnterDetailsSection() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on Travel Notification Service submenu for physical card")
	public void iClickOnTravelNotificationServiceSubmenuForPhysicalCard() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I select {string} , {string} , {string} in Travel Notification Services - Enter Details Section")
	public void iSelectInTravelNotificationServicesEnterDetailsSection(String string, String string2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on Next button in Travel Notification Services - Enter Details Section")
	public void iClickOnNextButtonInTravelNotificationServicesEnterDetailsSection() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on Submit button in Travel Notification Services - Confirm Details Section")
	public void iClickOnSubmitButtonInTravelNotificationServicesConfirmDetailsSection() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Verify Success message is displayed in Travel Notification Services - Acknowledgement Section")
	public void verifySuccessMessageIsDisplayedInTravelNotificationServicesAcknowledgementSection(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Verify other details are displayed in Travel Notification Services - Acknowledgement Section")
	public void verifyOtherDetailsAreDisplayedInTravelNotificationServicesAcknowledgementSection() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I click on Done button in Travel Notification Services - Acknowledgement Section")
	public void iClickOnDoneButtonInTravelNotificationServicesAcknowledgementSection() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
