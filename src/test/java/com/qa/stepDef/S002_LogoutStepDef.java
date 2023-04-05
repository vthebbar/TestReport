package com.qa.stepDef;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.LogoutPage;

import io.cucumber.java.en.*;

public class S002_LogoutStepDef {
	WebDriver driver;
	HomePage homePage;
	LogoutPage logoutPage;
	LoginPage loginPage;
	
	@Given("I m logged in")
	public void iMLoggedIn() throws InterruptedException {

		driver = DriverFactory.getDriver();
		
		loginPage = new LoginPage(driver);
		loginPage.doLogin();
		
//		  driver.get("https://t1uat.hongleongconnect.com.kh/rib/app/fo/login?t=1");
//		  driver.findElement(By.id("login_id")).sendKeys("connect111");
//		    driver.findElement(By.id("login_pswd")).sendKeys("Connect321");
//		    driver.findElement(By.id("idBtnLoginSubmit")).click();
		    
		    //new LoginPage(driver).load("https://t1uat.hongleongconnect.com.kh/rib/app/fo/login?t=1");
//		    driver.findElement(By.xpath("//span[normalize-space()='Pay & Transact']")).click();
//		    Thread.sleep(2000);
//		    driver.findElement(By.xpath("//span[normalize-space()='Withdraw Placement']")).click();
//		    
	}

	@When("I click on Logout button")
	public void iClickOnLogoutButton() {
		//driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		new HomePage(driver).clikLogoutBtn();
	}

	@Then("I should be loggedout successfully")
	public void iShouldBeLoggedoutSuccessfully(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<Map<String, String>> message=dataTable.asMaps();
		new LogoutPage(driver).verifyLogoutMessage(message.get(0).get("resultMessage"));
		
	}
}
