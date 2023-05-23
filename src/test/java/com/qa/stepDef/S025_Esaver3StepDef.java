package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.ESaverPersonalizeAccountPage;
import com.qa.pages.HomePage;

import io.cucumber.java.en.*;

public class S025_Esaver3StepDef {
	
	private WebDriver driver;
	private HomePage homePage;
	private ESaverPersonalizeAccountPage eSaverPersonalizeAccountPage;
	
	public S025_Esaver3StepDef(TestContext context) {
		driver = context.driver;
		homePage= PageObjectFactory.getHomePage(driver);
		eSaverPersonalizeAccountPage = PageObjectFactory.getESaverPersonalizeAccountPage(driver);
	}
	
	//TC01
	
	@Given("I m navigated to E-Saver Personalize Account screen")
	public void iMNavigatedToESaverPersonalizeAccountScreen() {
	  homePage.clickonESaverMenu();
	  homePage.clickOnEsaverPersonalizeAccount();
	}

	@Then("Above specified fields are displayed in Personalize Account screen")
	public void aboveSpecifiedFieldsAreDisplayedInPersonalizeAccountScreen() {
		eSaverPersonalizeAccountPage.verifyDetailEntrySection();
	}
	
	//TC02
	@When("I select account number {string} from dropdown in Personalize Account - Enter Details section")
	public void iSelectAccountNumberFromDropdownInPersonalizeAccountEnterDetailsSection(String acctNum) {
		eSaverPersonalizeAccountPage.selectAccountNum(acctNum);
	}

	@When("I click on Next button in Personalize Account - Enter Details section")
	public void iClickOnNextButtonInPersonalizeAccountEnterDetailsSection() {
		eSaverPersonalizeAccountPage.clickOnNextBtn();
	}

	@Then("Error message is displayed in Personalize Account - Enter Details section")
	public void errorMessageIsDisplayedInPersonalizeAccountEnterDetailsSection(io.cucumber.datatable.DataTable dataTable) {
		eSaverPersonalizeAccountPage.verifyErrorMsg(dataTable.asList().get(0));
	}
	
	//TC03
	@When("I key in New Account Name {string} in Personalize Account - Enter Details section")
	public void iKeyInNewAccountNameInPersonalizeAccountEnterDetailsSection(String acctName) {
		eSaverPersonalizeAccountPage.keyInAcctName(acctName);
	}

	@Then("Verify success message is displayed in Personalize Account -Acknowledgement section")
	public void verifySuccessMessageIsDisplayedInPersonalizeAccountAcknowledgementSection(io.cucumber.datatable.DataTable dataTable) {
		eSaverPersonalizeAccountPage.verifySuccessMessage(dataTable.asList().get(0));
	}

	@Then("Verify acknowledgement details in Personalize Account -Acknowledgement section")
	public void verifyAcknowledgementDetailsInPersonalizeAccountAcknowledgementSection() {
		eSaverPersonalizeAccountPage.verifyAcknowledgementDetails();
	}

	@Then("I click on Done button in Personalize Account -Acknowledgement section")
	public void iClickOnDoneButtonInPersonalizeAccountAcknowledgementSection() {
		eSaverPersonalizeAccountPage.clickOnDoneBtn();
	}

}
