package com.qa.hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.context.TestContext;
import com.qa.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {
	
	
	private WebDriver driver;
	private final TestContext context;

	
	public MyHooks(TestContext context) {
		this.context = context;
	}

	
	
	@Before
	public void before() {
		
		
		driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
		context.driver = driver;

	}
	
	
	@After
	public void after(Scenario scenario) {
		
		
		  if (scenario.isFailed()) { // Take a screenshot and attach it to the scenario
		  byte[] screenshot = ((TakesScreenshot)
		  driver).getScreenshotAs(OutputType.BYTES); scenario.attach(screenshot,
		  "image/png", "Failed Test Screenshot"); }
		 
		
		driver.quit();
	}
}
