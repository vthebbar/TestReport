package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.FixedDepositOverviewPage;
import com.qa.pages.FixedDepositPlacementDetailPage;
import com.qa.pages.FixedDepositPlacementPage;
import com.qa.pages.HomePage;
import com.qa.utils.PropertyManager;
import com.qa.utils.TACManager;

import io.cucumber.java.en.*;

public class S022_WithdrawPlacementStepDef {
	
	private WebDriver driver;
	private HomePage homePage;
	private FixedDepositOverviewPage fixedDepositOverviewPage;
	private FixedDepositPlacementDetailPage fixedDepositPlacementDetailPage;
	private FixedDepositPlacementPage fixedDepositPlacementPage;
	
	public S022_WithdrawPlacementStepDef(TestContext context) {
		
		driver=context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		fixedDepositOverviewPage = PageObjectFactory.getFixedDepositOverviewPage(driver);
		fixedDepositPlacementDetailPage = PageObjectFactory.getFixedDepositPlacementDetailPage(driver);
		fixedDepositPlacementPage = PageObjectFactory.getFixedDepositPlacementPage(driver);
	}
	
	
	//TC01
	
	@Given("I m navigated to Fixed Deposit Overview screen")
	public void iMNavigatedToFixedDepositOverviewScreen() {
	    homePage.clickOnPayAndTransact();
	    homePage.clickOnWithdrawPlacementMenu();
	}

	@When("I select Account Number {string} from dropdown in Fixed Deposit Overview screen")
	public void iSelectAccountNumberFromDropdownInFixedDepositOverviewScreen(String acctNum) {
		fixedDepositOverviewPage.selectAcctNumFromDropDown(acctNum);
	}

	@Then("Available Balance is displayed in Fixed Deposit Overview screen")
	public void availableBalanceIsDisplayedInFixedDepositOverviewScreen() {
		fixedDepositOverviewPage.verifyAvailableBalanceIsDisplayed();
	}

	@Then("Equivalent Balance is displayed in Fixed Deposit Overview screen")
	public void equivalentBalanceIsDisplayedInFixedDepositOverviewScreen() {
		fixedDepositOverviewPage.verifyEquivalentBalanceIsDisplayed();
	}
	
	//TC02
	@Then("Verify table headers are displayed correctly in Fixed Deposit Overview Overview screen")
	public void verifyTableHeadersAreDisplayedCorrectlyInFixedDepositOverviewOverviewScreen() {
	  
		fixedDepositOverviewPage.verifyRectNoISDisplayed();
		fixedDepositOverviewPage.verifyPrincipalAmtIsDisplayed();
		fixedDepositOverviewPage.verifyTenureIsDisplayed();
		fixedDepositOverviewPage.verifyPlacementDateIsDisplayed();
		fixedDepositOverviewPage.verifyMaturityDateIsDisplayed();
		fixedDepositOverviewPage.verifyRateIsDiaplyed();
		fixedDepositOverviewPage.verifyRenewalInstructionIsDisplayed();
		fixedDepositOverviewPage.verifyActionsIsDisplayed();
	}
	
	//TC03

@When("I click on Download CSV link in Fixed Deposit Overview screen")
public void iClickOnDownloadCSVLinkInFixedDepositOverviewScreen() {
	fixedDepositOverviewPage.clickOnDownloadCSVlink();
}

@Then("Verify CSV file is downloaded successfully")
public void verifyCSVFileIsDownloadedSuccessfully() {
	fixedDepositOverviewPage.verifyDownloadCSVIsSuccessful();
}

//TC04
@When("I click on Receipt number link in Fixed Deposit Overview screen")
public void iClickOnReceiptNumberLinkInFixedDepositOverviewScreen() {
	fixedDepositOverviewPage.clickOnRectNoLink();
}

@Then("Verify Fixed Deposit Placement Detail screen")
public void verifyFixedDepositPlacementDetailScreen() {
	fixedDepositPlacementDetailPage.verifyAccountNumberIsDisplayed();
	fixedDepositPlacementDetailPage.verifyAccountStatusIsDisplayed();
	fixedDepositPlacementDetailPage.verifyPrincipalAmtIsDIsplayed();
	fixedDepositPlacementDetailPage.verifyTenureIsDisplayed();
	fixedDepositPlacementDetailPage.verifyRateIsDisplayed();
	fixedDepositPlacementDetailPage.verifylastRenewalDateIsDisplayed();
	fixedDepositPlacementDetailPage.verifyPlacementDateIsDisplayed();
	fixedDepositPlacementDetailPage.verifyMaturityDateIsDisplayed();
	fixedDepositPlacementDetailPage.verifyRenewalInstructionIsDisplayed();
	fixedDepositPlacementDetailPage.verifyInterestPaymentAccountIsDisplayed();
	fixedDepositPlacementDetailPage.verifyAccurredInterestKhrIsDisplayed();
	fixedDepositPlacementDetailPage.verifyAutoRenewalIsDisplayed();
}

//TC05
@When("I click on Withdraw button in Fixed Deposit Overview screen")
public void iClickOnWithdrawButtonInFixedDepositOverviewScreen() {
	fixedDepositOverviewPage.clickOnWithdrawBtn();
}

@Then("Verify Fixed Deposit withdraw - Confirm Details section")
public void verifyFixedDepositWithdrawConfirmDetailsSection() {
	fixedDepositOverviewPage.verifyConfirmDetailsSection();
}

//TC06

@When("I click on Next button in Fixed Deposit withdraw - Confirm Details section")
public void iClickOnNextButtonInFixedDepositWithdrawConfirmDetailsSection() {
	fixedDepositOverviewPage.clickOnNextBtn();
}


@When("I Key in invalid TAC in Fixed Deposit withdraw - Confirm Details section")
public void iKeyInInvalidTACInFixedDepositWithdrawConfirmDetailsSection(io.cucumber.datatable.DataTable dataTable) {
	fixedDepositOverviewPage.keyInInvalidTac(dataTable.asList().get(0));
}

@When("I click on Submit button in Fixed Deposit withdraw - Confirm Details section")
public void iClickOnSubmitButtonInFixedDepositWithdrawConfirmDetailsSection() {
	fixedDepositOverviewPage.clickOnSubmitBtn();
}

@Then("Verify the error message in Fixed Deposit withdraw - Confirm Details section")
public void verifyTheErrorMessageInFixedDepositWithdrawConfirmDetailsSection(io.cucumber.datatable.DataTable dataTable) {
	fixedDepositOverviewPage.verifyErrMsg(dataTable.asList().get(0));
}

//TC07
@When("I Key in valid TAC in Fixed Deposit withdraw - Confirm Details section")
public void iKeyInValidTACInFixedDepositWithdrawConfirmDetailsSection() {
	fixedDepositOverviewPage.keyInTac();
    
}

@Then("Verify the success message in Fixed Deposit withdraw - Confirm Details section")
public void verifyTheSuccessMessageInFixedDepositWithdrawConfirmDetailsSection(io.cucumber.datatable.DataTable dataTable) {
	fixedDepositOverviewPage.verifySuccessMessage(dataTable.asList().get(0));
}

@Then("Verify the details are displayed in Fixed Deposit withdraw - Acknowledgement section")
public void verifyTheDetailsAreDisplayedInFixedDepositWithdrawAcknowledgementSection() {
	fixedDepositOverviewPage.verifyAcknowledgementSection();
}

@Then("I click on Make a Placement button in Fixed Deposit withdraw - Acknowledgement section")
public void iClickOnMakeAPlacementButtonInFixedDepositWithdrawAcknowledgementSection() {
	fixedDepositOverviewPage.clickOnMakeAPlacementbtn();

}

@Then("Fixed Deposit placement - Details Entry screen displayed")
public void fixedDepositPlacementDetailsEntryScreenDisplayed() {
	fixedDepositPlacementPage.verifyAllFieldsDisplayedInDetailsEntrySection();
}

//TC08
@When("I click on Withdraw button in Fixed Deposit Placement Details screen")
public void iClickOnWithdrawButtonInFixedDepositPlacementDetailsScreen() {
	fixedDepositPlacementDetailPage.clickOnWithdrawBtn();
}

@Then("I click on Done button in Fixed Deposit withdraw - Acknowledgement section")
public void iClickOnDoneButtonInFixedDepositWithdrawAcknowledgementSection() {
	fixedDepositOverviewPage.clickOnDoneBtn();
}


}
