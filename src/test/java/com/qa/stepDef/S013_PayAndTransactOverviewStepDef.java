package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.HomePage;

import io.cucumber.java.en.*;

public class S013_PayAndTransactOverviewStepDef {
	
	private WebDriver driver;
	private HomePage homePage;
	
	public S013_PayAndTransactOverviewStepDef(TestContext context) {
		driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
	}
	
	@When("I click on Pay & Transaction menu")
	public void iClickOnPayTransactionMenu() {
		homePage.clickOnPayAndTransact();
	}

	@Then("Verify all menu options given are displayed")
	public void verifyAllMenuOptionsGivenAreDisplayed() {
		homePage.verifyTransferMenuMenuOptions();
		homePage.verifyOnlineTransactionMenuOptions();
		homePage.verifyFixedDepositmenuoptions();
	}
}
