package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LocalTransferPage;
import com.qa.pages.OverseasTransferPage;
import com.qa.pages.TransactionDetailsPage;
import com.qa.pages.ViewHistoryPage;

import io.cucumber.java.en.*;


public class S018_ViewHistoryStepDef {

	private WebDriver driver;
	private HomePage homePage;
	private ViewHistoryPage viewHistoryPage;
	private TransactionDetailsPage transactionDetailsPage;
	private OverseasTransferPage overseasTransferPage;
	private LocalTransferPage localTransferPage;
	
	public S018_ViewHistoryStepDef(TestContext context) {
		
		driver=context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		viewHistoryPage=PageObjectFactory.getViewHistoryPage(driver);
		transactionDetailsPage = PageObjectFactory.getTransactionDetailsPage(driver);
		overseasTransferPage = PageObjectFactory.getOverseasTransferPage(driver);
		localTransferPage = PageObjectFactory.getLocalTransferPage(driver);
	}
	
	
	//TC01
	@Given("I m navigated to View History screen")
	public void iMNavigatedToViewHistoryScreen() {
		homePage.clickOnPayAndTransact();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		homePage.clickOnViewHistory();
		
	}

	@Then("Verify dropdown options for Account, Transaction Type, Status and Period are displayed in View History screen")
	public void verifyDropdownOptionsForAccountTransactionTypeStatusAndPeriodAreDisplayedInViewHistoryScreen() {
		viewHistoryPage.verifySearchDropDownOptionsAreDisplayed();
		
	}

	@Then("Verify Search button is displayed in View History screen")
	public void verifySearchButtonIsDisplayedInViewHistoryScreen() {
		viewHistoryPage.verifySearchBtnIsDisplayed();
	}

	//TC02
	@When("I click on Download CSV link in View History screen")
	public void iClickOnDownloadCSVLinkInViewHistoryScreen() {
		viewHistoryPage.clickOnDownloadCSV();
	}

	@Then("Verify that CSV file is downloaded")
	public void verifyThatCSVFileIsDownloaded() {
		viewHistoryPage.verifyFileDownloadIsSuccessful();
	}
	
	//TC03
	@Then("Verify View History table headers are dispalyed in View History screen")
	public void verifyViewHistoryTableHeadersAreDispalyedInViewHistoryScreen() {
		viewHistoryPage.verifyTableHeadersAreDisplayed();
	}
	
	//TC04
	@Given("I click on REF NO. link in View History screen")
	public void iClickOnREFNOLinkInViewHistoryScreen() {
		viewHistoryPage.clickOnRefNoLink();
	}

	@Then("Verify all transaction details mentioned above are displayed in trsanction details screen")
	public void verifyAllTransactionDetailsMentionedAboveAreDisplayedInTrsanctionDetailsScreen() {
		transactionDetailsPage.verifyAllTransactioinDetailsAreDisplayed();
	}

	@Then("Back and Repeat button are displayed in trsanction details screen")
	public void backAndRepeatButtonAreDisplayedInTrsanctionDetailsScreen() {
		transactionDetailsPage.verifyBackAndRepeatBtnAreDisplayed();
	}
	
	//TC05
	
	@Given("I search for Overseas Transfer Transaction Type")
	public void iSearchForOverseasTransferTransactionType(io.cucumber.datatable.DataTable dataTable) {
		viewHistoryPage.selectTransactionType(dataTable.asList().get(0));
		viewHistoryPage.clickOnSearchBtn();
	}

	@Given("I click on Repeat button in View History screen")
	public void iClickOnRepeatButtonInViewHistoryScreen() {
		viewHistoryPage.clickOnRepeatBtn();
	}

	@Given("I Key in Amount in Overseas Transfer - Details Entry Section")
	public void iKeyInAmountInOverseasTransferDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		overseasTransferPage.keyInAmount(dataTable.asList().get(0));
	}

	@Given("I click on Next button in Overseas Transfer - Details Entry Section")
	public void iClickOnNextButtonInOverseasTransferDetailsEntrySection() {
		overseasTransferPage.clickOnNextBtn();
	}

	@Given("I key in TAC in Overseas Transfer - Confirmation Section")
	public void iKeyInTACInOverseasTransferConfirmationSection() {
		overseasTransferPage.keyInTac();
		
	}

	@Given("I click on Submit button in Overseas Transfer - Confirmation Section")
	public void iClickOnSubmitButtonInOverseasTransferConfirmationSection() {
		overseasTransferPage.clickOnSubmitBtn();
	}

	@Then("Verify transaction success message in Overseas Transfer - Acknowledgement Section")
	public void verifyTransactionSuccessMessageInOverseasTransferAcknowledgementSection(io.cucumber.datatable.DataTable dataTable) {
		overseasTransferPage.verifySuccessMessage(dataTable.asList().get(0));
	}
	
	//TC06
	@Given("I search for Local Transfer Transaction Type in View History screen")
	public void iSearchForLocalTransferTransactionTypeInViewHistoryScreen(io.cucumber.datatable.DataTable dataTable) {
		viewHistoryPage.selectTransactionType(dataTable.asList().get(0));

	}

	@Given("I click on Repeat button in Transaction Details screen")
	public void iClickOnRepeatButtonInTransactionDetailsScreen() {
		transactionDetailsPage.clickOnRepeatBtn();
	}

	@Given("I Key in Amount in Local Transfer - Details Entry Section")
	public void iKeyInAmountInLocalTransferDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		localTransferPage.keyInAmount(dataTable.asList().get(0));
	}


	@Then("Verify transaction success message in Local Transfer - Acknowledgement Section")
	public void verifyTransactionSuccessMessageInLocalTransferAcknowledgementSection(io.cucumber.datatable.DataTable dataTable) {
		localTransferPage.verifySuccessMessage(dataTable.asList().get(0));
	}

	//TC07
	@Given("I click on Back button in Transaction Details screen")
	public void iClickOnBackButtonInTransactionDetailsScreen() {
		transactionDetailsPage.clickOnBackBtn();
	}

	@Then("I m directed back to View History page")
	public void iMDirectedBackToViewHistoryPage() {
		viewHistoryPage.verifySearchBtnIsDisplayed();
	}
}
