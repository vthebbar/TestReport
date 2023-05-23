package com.qa.stepDef;

import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.PageObjectFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import io.cucumber.java.en.*;

public class S001_LoginStepDef {

	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	
	public S001_LoginStepDef(TestContext context) {
		driver = context.driver;
		loginPage = PageObjectFactory.getLoginPage(driver);
		
	}
	
	
	
@Given("I m on the login page")
public void iMOnTheLoginPage() {
    
	
	
	//driver = DriverFactory.getDriver();
	
	loginPage.launchAppBaseUrl();
}



@When("I enter login username {string} and password {string}")
public void iEnterLoginUsernameAndPassword(String userName, String password) {
	loginPage.enterUserName(userName);
	loginPage.enterPassword(password);
}

@When("I press on login button")
public void iPressOnLoginButton() {
   //driver.findElement(By.id("idBtnLoginSubmit")).click();
	homePage=loginPage.clickOnLoginBtn();
}

@Then("login should be successful")
public void loginShouldBeSuccessful() {
	
	homePage.verifyHomeMenuIsDisplayed();
	homePage.verifyLogoutBtnIsDisplayed();

}



@Then("Error message displayed as {string}")
public void errorMessageDisplayedAs(String errMsg) {
	loginPage.verifyIncorrectLoginErrMsg(errMsg);
}

// TC04
@Then("verify correct error message is displayed for username {string}")
public void verifyCorrectErrorMessageIsDisplayedForUsername(String errMsg) {
	loginPage.verifyErrMsgForEmptyUsername(errMsg);
}

@Then("verify correct error message is displayed for password {string}")
public void verifyCorrectErrorMessageIsDisplayedForPassword(String errMsg) {
	loginPage.verifyErrMsgForEmptyPassword(errMsg);
}


}
