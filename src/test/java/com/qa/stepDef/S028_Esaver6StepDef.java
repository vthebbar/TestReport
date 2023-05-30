package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.ESaverViewApplicationHistoryPage;
import com.qa.pages.HomePage;

import io.cucumber.java.en.*;

public class S028_Esaver6StepDef {
	
	private WebDriver driver;
	private HomePage homePage;
	private ESaverViewApplicationHistoryPage eSaverViewApplicationHistoryPage;
	
	public S028_Esaver6StepDef(TestContext context) {
		driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		eSaverViewApplicationHistoryPage = PageObjectFactory.getESaverViewApplicationHistoryPage(driver);
	}
	
	
	//TC01
	@Given("I m navigated to E-Saver View Application History screen")
	public void iMNavigatedToESaverViewApplicationHistoryScreen() {
		homePage.clickonESaverMenu();
		homePage.clickOnViewApplicationHistorySubMenu();
	}

	@When("I select the Application Type {string} from dropdown in View Application History screen")
	public void iSelectTheApplicationTypeFromDropdownInViewApplicationHistoryScreen(String appType) {
		eSaverViewApplicationHistoryPage.selectApplicationType(appType);
	}

	@When("I click on the Search button in View Application History screen")
	public void iClickOnTheSearchButtonInViewApplicationHistoryScreen() {
		eSaverViewApplicationHistoryPage.clickOnSearchBtn();
	}

	@Then("Application Type value {string} displayed in table should match with the search value in View Application History screen")
	public void applicationTypeValueDisplayedInTableShouldMatchWithTheSearchValueInViewApplicationHistoryScreen(String appType) {
		eSaverViewApplicationHistoryPage.verifyApplicationTypeSearchValues(appType);
	}
	
	//TC02
	@When("I select Status {string} from dropdown in View Application History screen")
	public void iSelectStatusFromDropdownInViewApplicationHistoryScreen(String status) {
		eSaverViewApplicationHistoryPage.selectStatus(status);
	}

	@Then("Status value {string} displayed in table should match with the search value in View Application History screen")
	public void statusValueDisplayedInTableShouldMatchWithTheSearchValueInViewApplicationHistoryScreen(String status) {
		eSaverViewApplicationHistoryPage.verifyStatusSearchValues(status);
	}
	
	//TC03
	@When("I select period {string} , start date {string} and {string} in View Application History screen")
	public void iSelectPeriodStartDateAndInViewApplicationHistoryScreen(String period, String startDate, String endDate) {
		eSaverViewApplicationHistoryPage.selectPeriod(period, startDate, endDate);
	}

	@Then("Verify the at least one or more data rows are displayed in View Application History screen")
	public void verifyTheAtLeastOneOrMoreDataRowsAreDisplayedInViewApplicationHistoryScreen() {
		eSaverViewApplicationHistoryPage.verifyDataRowsAreDisplayed();
	}

	//TC04
	@Then("All table headers are displayed in View Application History screen")
	public void allTableHeadersAreDisplayedInViewApplicationHistoryScreen() {
		eSaverViewApplicationHistoryPage.verifyAllHeadersOfTableAreDisplaeyd();
	}
	
	//TC05
	@When("I click on Download CSV link in View Application History screen")
	public void iClickOnDownloadCSVLinkInViewApplicationHistoryScreen() {
		eSaverViewApplicationHistoryPage.clickOnDownloadCSVLink();
	}

	@Then("Verify that file is downloaded successfully")
	public void verifyThatFileIsDownloadedSuccessfully() {
		eSaverViewApplicationHistoryPage.verifyFileIsDownloaded();
	}
	
	//TC06
	@When("I click on REF NO link in View Application History screen")
	public void iClickOnREFNOLinkInViewApplicationHistoryScreen() {
		eSaverViewApplicationHistoryPage.clickOnRefNoLink();
	}

	@Then("Verify that details of the application are displayed under ESaver Create Account section")
	public void verifyThatDetailsOfTheApplicationAreDisplayedUnderESaverCreateAccountSection() {
		eSaverViewApplicationHistoryPage.verifyRefNoDetailsAreDisplayed();
	}

	
	@Then("I click on Done button in ESaver Create Account section")
	public void iClickOnDoneButtonInESaverCreateAccountSection() {
		eSaverViewApplicationHistoryPage.clickOnDoneBtn();
	}

	@Then("E-saver View Application History page is displayed")
	public void eSaverViewApplicationHistoryPageIsDisplayed() {
		eSaverViewApplicationHistoryPage.verifyAllHeadersOfTableAreDisplaeyd();
	}
}
