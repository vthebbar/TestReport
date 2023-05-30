package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.HomePage;
import com.qa.pages.MyQRPage;

import io.cucumber.java.en.*;

public class S020_MyQRStepDef {
	
	private WebDriver driver;
	private HomePage homePage;
	private MyQRPage myQRPage;
	
	public S020_MyQRStepDef(TestContext context) {
		driver = context.driver;
		homePage = PageObjectFactory.getHomePage(driver);
		myQRPage=PageObjectFactory.getMyQRPage(driver);
	}
	
	//TC01
	@Given("I m navigated to My QR screen")
	public void iMNavigatedToMyQRScreen() {
		homePage.clickOnPayAndTransact();
		homePage.clickOnMyQRMenu();
	}

	@Given("Select the account from Account {string} dropdown in My QR screen")
	public void selectTheAccountFromAccountDropdownInMyQRScreen(String value) {
		myQRPage.selectAccountFromDropDown(value);
	}

	@Given("Click on Show My QR button in My QR screen")
	public void clickOnShowMyQRButtonInMyQRScreen() {
		myQRPage.clickonShowMyQRBtn();
	}

	@Then("Verify HLB Connect Logo is displayed in My QR screen")
	public void verifyHLBConnectLogoIsDisplayedInMyQRScreen() {
		myQRPage.verifyHLBConnectLogoIsDisplayed();
	}

	@Then("HLB Connect QR Name and Account number are displayed in My QR screen")
	public void hlbConnectQRNameAndAccountNumberAreDisplayedInMyQRScreen() {
		myQRPage.verifyAccountNameAndAccountNumbersAreDisplayed();
	}

	@Then("Print, Save MY QR, Generate Another My QR buttons are  displayed in My QR screen")
	public void printSaveMYQRGenerateAnotherMyQRButtonsAreDisplayedInMyQRScreen() {
		myQRPage.verifyPrintBtnIsDisplayed();
		myQRPage.verifySaveMYQRBtnIsDisplayed();
		myQRPage.verifyGenerateAnotherMYQRBtnIsDisplayed();
	}
}
