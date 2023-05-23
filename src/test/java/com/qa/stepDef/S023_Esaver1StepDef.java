package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.HomePage;

import io.cucumber.java.en.*;

public class S023_Esaver1StepDef {
		
	private WebDriver driver;
	private HomePage homePage;
	
		public S023_Esaver1StepDef(TestContext context) {
			driver=context.driver;
			homePage= PageObjectFactory.getHomePage(driver);
		}
		
		
		//TC01
		
		@When("I Click on E-Saver menu in home page")
		public void iClickOnESaverMenuInHomePage() {
			homePage.clickonESaverMenu();
		}

		@Then("Menus specified above are displayed")
		public void menusSpecifiedAboveAreDisplayed() {
			homePage.verifyESaverSubMenusAreDisplayed();
		}
}
