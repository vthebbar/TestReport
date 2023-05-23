package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.CASAAccountOverviewPage;
import com.qa.pages.HomePage;

import io.cucumber.java.en.*;

public class S008_CASAAccountOverviewStepDef {
	
	private WebDriver driver;
	private HomePage homePage;
	private CASAAccountOverviewPage cASAAccountOverviewPage;
	
	public S008_CASAAccountOverviewStepDef(TestContext context) {
		driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		cASAAccountOverviewPage=PageObjectFactory.getCASAAccountOverviewPage(driver);
	}
	

	@Given("I m on the Home page")
	public void iMOnTheHomePage() {
		homePage.clikonHomeMenu();
	}

	@Then("CASA Account Overview Section is diaplyed")
	public void casaAccountOverviewSectionIsDiaplyed() {
	    
		homePage.verifyCASAAcctOverViewSectionIsDisplayed();
	}

	@Then("Type of account, Currency, Account Number, Amount with currency at the bottom of the value are displayed")
	public void typeOfAccountCurrencyAccountNumberAmountWithCurrencyAtTheBottomOfTheValueAreDisplayed() {
	    
		homePage.verifyAccountDetailsAreDisplayedInAcctOverViewSection();
	}

	@Given("I m navigated to account overview screen")
	public void iMNavigatedToAccountOverviewScreen() {
		cASAAccountOverviewPage = homePage.clickOnAcctDetails();
	}

	@Then("Verify that Available Balance box is not clickable")
	public void verifyThatAvailableBalanceBoxIsNotClickable() {
		cASAAccountOverviewPage.verifyAvailableBalanceBoxIsNotClickable();
	}

	@Then("Verify that user is able to view Account Number, Current Balance, Account Details as of, Basic Interest Rate, Status")
	public void verifyThatUserIsAbleToViewAccountNumberCurrentBalanceAccountDetailsAsOfBasicInterestRateStatus() {
		cASAAccountOverviewPage.verifyAcctNumberIsDIsplayed();
		cASAAccountOverviewPage.verifyAcctDetailsAsOfIsDisplayed();
	
		cASAAccountOverviewPage.verifyBasicInterestRateIsDisplayed();
		cASAAccountOverviewPage.verifyCurrentBalanceIsDisplayed();
		cASAAccountOverviewPage.verifyStatusIsDisplayed();
	}

	@Then("Verify that users should be able to click and select the transaction period")
	public void verifyThatUsersShouldBeAbleToClickAndSelectTheTransactionPeriod() {
		cASAAccountOverviewPage.verifyAbleToSelectValueFromTransactionTimeLineDropDown();
	}

	@Then("Verify that user is able to click and download CSV")
	public void verifyThatUserIsAbleToClickAndDownloadCSV() {
		cASAAccountOverviewPage.verifyOnDownLoadCSV();
	}

	@Then("Verify that user is able to click and download PDF")
	public void verifyThatUserIsAbleToClickAndDownloadPDF() {
		cASAAccountOverviewPage.verifyOnDownLoadPDF();
	}

	
}
