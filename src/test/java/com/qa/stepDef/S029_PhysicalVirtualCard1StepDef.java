package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.BlockUnBlockEcommercePage;
import com.qa.pages.BlockUnblockOverseasATMPOSPage;
import com.qa.pages.BlockUnblockPhysicalDebitCardPage;
import com.qa.pages.ChangeDebitingAccountPage;
import com.qa.pages.HomePage;

import io.cucumber.java.en.*;

public class S029_PhysicalVirtualCard1StepDef {
	
	private WebDriver driver;
	private HomePage homePage;
	private BlockUnblockPhysicalDebitCardPage blockUnblockPhysicalDebitCardPage;
	private BlockUnBlockEcommercePage blockUnBlockEcommercePage;
	private BlockUnblockOverseasATMPOSPage blockUnblockOverseasATMPOSPage;
	private ChangeDebitingAccountPage changeDebitingAccountPage;
	
	public S029_PhysicalVirtualCard1StepDef(TestContext context) {
		driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		blockUnblockPhysicalDebitCardPage = PageObjectFactory.getBlockUnblockPhysicalDebitCardPage(driver);
		blockUnBlockEcommercePage = PageObjectFactory.getBlockUnBlockEcommercePage(driver);
		blockUnblockOverseasATMPOSPage = PageObjectFactory.getBlockUnblockOverseasATMPOSPage(driver);
		changeDebitingAccountPage = PageObjectFactory.getChangeDebitingAccountPage(driver);
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
}
