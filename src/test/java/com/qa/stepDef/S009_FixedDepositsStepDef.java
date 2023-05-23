package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.FixedDepositOverviewPage;
import com.qa.pages.FixedDepositPlacementDetailPage;
import com.qa.pages.FixedDepositPlacementPage;
import com.qa.pages.FixedDepositWithdrawlPage;
import com.qa.pages.HomePage;

import io.cucumber.java.en.*;

public class S009_FixedDepositsStepDef {

	private WebDriver driver;
	private HomePage homePage;
	private FixedDepositOverviewPage fixedDepositOverviewPage;
	private FixedDepositPlacementDetailPage fixedDepositPlacementDetailPage;
	private FixedDepositWithdrawlPage  fixedDepositWithdrawlPage;
	private FixedDepositPlacementPage fixedDepositPlacementPage;
	
	public S009_FixedDepositsStepDef(TestContext context) {
		driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		fixedDepositOverviewPage = PageObjectFactory.getFixedDepositOverviewPage(driver);
		fixedDepositPlacementDetailPage = PageObjectFactory.getFixedDepositPlacementDetailPage(driver);
		fixedDepositWithdrawlPage = PageObjectFactory.getFixedDepositWithdrawlPage(driver);
		fixedDepositPlacementPage =PageObjectFactory. getFixedDepositPlacementPage(driver);
	}
	
	//TC01
	
	@When("I m navigated to Fixed Deposit Placement screen")
	public void iMNavigatedToFixedDepositPlacementScreen() {
		homePage.clickOnPayAndTransact();
		homePage.clickOnNewPlacement();
	}

	@When("I enter the Fixed Deposit details {string} , {string} , {string} , {string} , {string}")
	public void iEnterTheFixedDepositDetails(String from, String tenure, String principal, String remarks, String renewalInstr) {
		fixedDepositPlacementPage.selectFromAccount(from);
		fixedDepositPlacementPage.selectTenure(tenure);
		fixedDepositPlacementPage.keyInAmount(principal);
		fixedDepositPlacementPage.keyInRemarks(remarks);
		fixedDepositPlacementPage.selectRenewalInstruction(renewalInstr);
		
		fixedDepositPlacementPage.clickOnNextbtn();
	}

	@When("I enter the valid TAC for fd placement")
	public void iEnterTheValidTACForFdPlacement() {
		fixedDepositPlacementPage.keyInTac();
		fixedDepositPlacementPage.clickOnSubmitBtn();
	}
	
	@Then("verify the Transaction status {string}")
	public void verifyTheTransactionStatus(String status) {
		fixedDepositPlacementPage.verifyTranStatus(status);
	}
	
	//
	
	@Then("Fixed Deposit, Currency, Fixed Deposit Account Number, Upcoming Maturity Date, Amount with currency at the bottom of the value are displayed")
	public void fixedDepositCurrencyFixedDepositAccountNumberUpcomingMaturityDateAmountWithCurrencyAtTheBottomOfTheValueAreDisplayed() {
		homePage.verifyFDSectionHeaderIsDisplayed();
		homePage.verifyFixedDepositIsDiaplyedInsideSection();
		homePage.verifyCurrencyFDAcctNumMaturiyDateAreDisplayed();
	}

	@When("I m navigated to Fixed Deposit Overview Screen")
	public void iMNavigatedToFixedDepositOverviewScreen() {
		homePage.clickOnFDSection();
	}

	@Then("Receipt number, principal amount, Tenure,  Placement Date, Maturity Date, Rate, Renewal Instruction, Actions are displayed")
	public void receiptNumberPrincipalAmountTenurePlacementDateMaturityDateRateRenewalInstructionActionsAreDisplayed() {
		fixedDepositOverviewPage.verifyActionsIsDisplayed();
		fixedDepositOverviewPage.verifyMaturityDateIsDisplayed();
		fixedDepositOverviewPage.verifyPlacementDateIsDisplayed();
		fixedDepositOverviewPage.verifyPrincipalAmtIsDisplayed();
		fixedDepositOverviewPage.verifyRateIsDiaplyed();
		fixedDepositOverviewPage.verifyRectNoISDisplayed();
		fixedDepositOverviewPage.verifyRenewalInstructionIsDisplayed();
		fixedDepositOverviewPage.verifyTenureIsDisplayed();
	}

	@Then("I m able to download CSV")
	public void iMAbleToDownloadCSV() {
		fixedDepositOverviewPage.clickOnDownloadCSVlink();
		fixedDepositOverviewPage.verifyDownloadCSVIsSuccessful();
	}

	@When("I click on Receipt No.")
	public void iClickOnReceiptNo() {
		fixedDepositOverviewPage.clickOnReceiptNumberLink();
	}

	@Then("Receipt details are displayed")
	public void receiptDetailsAreDisplayed() {
		fixedDepositPlacementDetailPage.verifyAccountNumberIsDisplayed();
		fixedDepositPlacementDetailPage.verifyAccountStatusIsDisplayed();
		fixedDepositPlacementDetailPage.verifyAccurredInterestKhrIsDisplayed();
		fixedDepositPlacementDetailPage.verifyAutoRenewalIsDisplayed();
		fixedDepositPlacementDetailPage.verifyInterestPaymentAccountIsDisplayed();
		fixedDepositPlacementDetailPage.verifylastRenewalDateIsDisplayed();
		fixedDepositPlacementDetailPage.verifyMaturityDateIsDisplayed();
		fixedDepositPlacementDetailPage.verifyPlacementDateIsDisplayed();
		fixedDepositPlacementDetailPage.verifyPrincipalAmtIsDIsplayed();
		fixedDepositPlacementDetailPage.verifyRateIsDisplayed();
		fixedDepositPlacementDetailPage.verifyRenewalInstructionIsDisplayed();
		fixedDepositPlacementDetailPage.verifyTenureIsDisplayed();
		
	}

	@When("I click on Withdraw button")
	public void iClickOnWithdrawButton() {
		fixedDepositOverviewPage.clickOnWithDrawBtn();
	}

	@When("I click on Next button fro Fixed Deposit Withdrawl screen")
	public void iClickOnNextButtonFroFixedDepositWithdrawlScreen() {
		fixedDepositWithdrawlPage.clickOnNextBtn();
	}
	
	@When("I enter the valid TAC")
	public void iEnterTheValidTAC() {
		fixedDepositWithdrawlPage.enterTac();
	}

	@When("I click on Submit button")
	public void iClickOnSubmitButton() {
		fixedDepositWithdrawlPage.clickOnSubmitBtm();
	}

	@Then("Fixed Deposit withdrawl is successful")
	public void fixedDepositWithdrawlIsSuccessful() {
		fixedDepositWithdrawlPage.verifyTransactionStatus();
	}
}
