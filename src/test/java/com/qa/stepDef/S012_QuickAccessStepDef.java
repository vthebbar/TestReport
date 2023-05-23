package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.HomePage;

import io.cucumber.java.en.*;

public class S012_QuickAccessStepDef {
	
	private WebDriver driver;
	private HomePage homePage;
	public S012_QuickAccessStepDef(TestContext context) {
		driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		
	}

	
	@Then("Quick Access Overview Section is displayed with given menu options")
	public void quickAccessOverviewSectionIsDisplayedWithGivenMenuOptions() {
		homePage.verifyQuickAccessSection();
	}

}
