package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LocalTransferPage;
import com.qa.pages.ManageStandingInstructionPage;
import com.qa.pages.StandingInstructionDetailsPage;

import io.cucumber.java.en.*;

public class S019_ManageStandingInstructionStepDef {
	
	private WebDriver driver;
	private HomePage homePage;
	private ManageStandingInstructionPage manageStandingInstructionPage;
	private LocalTransferPage localTransferPage;
	private StandingInstructionDetailsPage standingInstructionDetailsPage;
	
	public S019_ManageStandingInstructionStepDef(TestContext context) {
		driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		manageStandingInstructionPage = PageObjectFactory.getManageStandingInstructionPage(driver);
		localTransferPage = PageObjectFactory.getLocalTransferPage(driver);
		standingInstructionDetailsPage = PageObjectFactory.getStandingInstructionDetailsPage(driver);
	}
	
	//TC01
	
	@Given("I m navigated to Manage Standing Instruction screen")
	public void iMNavigatedToManageStandingInstructionScreen() {
		homePage.clickOnPayAndTransact();
		homePage.clickOnManageStandingInstructionMenu();
	}

	@Then("Verify available dropdown options for Transaction Type dropdown in Manage Standing Instruction screen")
	public void verifyAvailableDropdownOptionsForTransactionTypeDropdownInManageStandingInstructionScreen(io.cucumber.datatable.DataTable dataTable) {
		manageStandingInstructionPage.verifyTranTypeDropDownValues(dataTable.asList());
	}

	//TC02
	@Then("Verify available dropdown options for Status dropdown in Manage Standing Instruction screen")
	public void verifyAvailableDropdownOptionsForStatusDropdownInManageStandingInstructionScreen(io.cucumber.datatable.DataTable dataTable) {
		manageStandingInstructionPage.verifyStatusDropDownValues(dataTable.asList());
	}
	
	//TC03
	@Given("Select the search value {string} from Transaction Type dropdown in Manage Standing Instruction screen")
	public void selectTheSearchValueFromTransactionTypeDropdownInManageStandingInstructionScreen(String tranType) {
		manageStandingInstructionPage.selectTranTypeSearchValue(tranType);
	}

	@Given("Click on Search button in Manage Standing Instruction screen")
	public void clickOnSearchButtonInManageStandingInstructionScreen() {
		manageStandingInstructionPage.clickOnSearchBtn();
	}

	@Then("Verify that Transaction Type column value in table is {string}")
	public void verifyThatTransactionTypeColumnValueInTableIs(String expVal) {
		manageStandingInstructionPage.verifyTranTypeColValue(expVal);
	}
	
	//TC04
	@Given("Select the search value {string} from Status dropdown in Manage Standing Instruction screen")
	public void selectTheSearchValueFromStatusDropdownInManageStandingInstructionScreen(String status) {
		manageStandingInstructionPage.selectStatusValue(status);
	}

	@Then("Verify that Status column value in table is {string}")
	public void verifyThatStatusColumnValueInTableIs(String status) {
		manageStandingInstructionPage.verifyStatusColValue(status);
	}

	//TC05
	
	@Given("I click on Download CSV link in Manage Standing Instruction screen")
	public void iClickOnDownloadCSVLinkInManageStandingInstructionScreen() {
		manageStandingInstructionPage.clickOnDownloadCSVLink();
	}

	@Then("Verify that CSV file is downloaded successfully")
	public void verifyThatCSVFileIsDownloadedSuccessfully() {
		manageStandingInstructionPage.verifyFileDownload();
	}
	
	//TC06
	@Then("Verify table headers are displayed correctly in Manage Standing Instruction screen")
	public void verifyTableHeadersAreDisplayedCorrectlyInManageStandingInstructionScreen() {
	
		manageStandingInstructionPage.verifyTableHeadersAreDisplayed();
	}
	
	//TC07
	@Given("Search for Local Transfer Transaction in Manage Standing Instruction screen")
	public void searchForLocalTransferTransactionInManageStandingInstructionScreen(io.cucumber.datatable.DataTable dataTable) {
		manageStandingInstructionPage.selectTranTypeSearchValue(dataTable.asList().get(0));
		manageStandingInstructionPage.clickOnSearchBtn();
	}

	@Given("I click on Repeat button in Manage Standing Instruction screen")
	public void iClickOnRepeatButtonInManageStandingInstructionScreen() {
		manageStandingInstructionPage.clickOnRepeatBtn();
	}

	@Given("Key in the amount in Local Transfer - Details entry section")
	public void keyInTheAmountInLocalTransferDetailsEntrySection(io.cucumber.datatable.DataTable dataTable) {
		localTransferPage.keyInAmount(dataTable.asList().get(0));
	}

	@Given("Complete the Local Transfer Transaction")
	public void completeTheLocalTransferTransaction() {
		localTransferPage.clickOnNextBtn();
		localTransferPage.clickOnSubmitBtn();
	}

	@Then("Verify the success message in Local Transfer - Acknowledgement section")
	public void verifyTheSuccessMessageInLocalTransferAcknowledgementSection(io.cucumber.datatable.DataTable dataTable) {
		localTransferPage.verifySuccessMessage(dataTable.asList().get(0));
	}
	
	//TC08
	@Given("I click on the REF NO. link in Manage Standing Instruction screen")
	public void iClickOnTheREFNOLinkInManageStandingInstructionScreen(io.cucumber.datatable.DataTable dataTable) {
		manageStandingInstructionPage.selectTranTypeSearchValue(dataTable.asList().get(0));
		manageStandingInstructionPage.clickOnSearchBtn();
		manageStandingInstructionPage.clickOnRefNoLink();
	}

	@Then("Verify Standing Instruction details are displayed in Standing Instruction details screen")
	public void verifyStandingInstructionDetailsAreDisplayedInStandingInstructionDetailsScreen() {
		standingInstructionDetailsPage.verifyStadingInstructionDetailsAreDisplayed();
	}
	
	//TC09
	@Given("I click on Repeat button in Manage Standing Instruction Details screen")
	public void iClickOnRepeatButtonInManageStandingInstructionDetailsScreen() {
		standingInstructionDetailsPage.clickOnRepeatBtn();
	}
	
	//TC10
	@Given("I click on Back button in Standing Instruction Details screen")
	public void iClickOnBackButtonInStandingInstructionDetailsScreen() {
		standingInstructionDetailsPage.clickOnBackBtn();
	}

	@Then("Manage Standing Instruction screen is displayed")
	public void manageStandingInstructionScreenIsDisplayed() {
		manageStandingInstructionPage.verifySearchBtnIsDisplayed();
	}

}
