package com.qa.stepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDef {

	WebDriver driver;
	HomePage homePage;
	
@Given("I m on the login page")
public void iMOnTheLoginPage() {
    
	
	
	driver = DriverFactory.getDriver();
	
	//driver.get("https://t1uat.hongleongconnect.com.kh/rib/app/fo/login?t=1");
	new LoginPage(driver).launchAppBaseUrl();
}



@When("I enter login username {string} and password {string}")
public void iEnterLoginUsernameAndPassword(String userName, String password) {
	new LoginPage(driver).enterUserName(userName);
    new LoginPage(driver).enterPassword(password);
}

@When("I press on login button")
public void iPressOnLoginButton() {
   //driver.findElement(By.id("idBtnLoginSubmit")).click();
	homePage=new LoginPage(driver).clickOnLoginBtn();
}

@Then("login should be successful")
public void loginShouldBeSuccessful() {
	
	homePage.verifyHomeMenuIsDisplayed();
	homePage.verifyLogoutBtnIsDisplayed();

}

}
