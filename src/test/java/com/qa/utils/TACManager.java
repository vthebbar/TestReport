package com.qa.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

public class TACManager {

	
	// Read TAC
	public String getTacCode(WebDriver driver, String userName) {
		
		TestUtils utils = new TestUtils();
		
		utils.log().info("Started opening TAC URL and reading TAC");
		
		String tacUrl= PropertyManager.propertyLoader().getProperty("publicTacUrl");
		Actions action = new Actions(driver);
		
//		if(System.getProperty("os.name").contains("Mac")) {
//        action.keyDown(Keys.COMMAND).sendKeys("t").keyUp(Keys.COMMAND).build().perform();
//		}
//		else if(System.getProperty("os.name").contains("Windows")) {
//	        action.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
//
//		}
		
		((JavascriptExecutor) driver).executeScript("window.open();");

		
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		driver.navigate().to(tacUrl);
		
		try {
			Thread.sleep(18000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// code to read tac
		
		String user=null;
		String tacCode = null;
		
		String beforeXpathUserName = "//table/tbody/tr[" ;
		String afterXpathUserName="]/td[count(//table/tbody/tr/th[text()='Login Id']/preceding-sibling::th)+1]";
		
		String beforeXpathTac="//table/tbody/tr[" ;
		String afterXpathTac="]/td[count(//table/tbody/tr/th[text()='Plain TAC']/preceding-sibling::th)+1]";
				
		
		int rowCount = driver.findElements(By.xpath("//table/tbody/tr")).size();
		
		for(int i=2;i<=rowCount;i++) {
			
			user = driver.findElement(By.xpath(beforeXpathUserName+i+afterXpathUserName)).getText().trim();
			tacCode = driver.findElement(By.xpath(beforeXpathTac+i+afterXpathTac)).getText().trim();
			
			if(user.equalsIgnoreCase(userName)) {
				System.out.println("User name="+ user);
				System.out.println("TAC ="+ tacCode);
				break;
			}
		}
		
		//switch back to previous tab
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        return tacCode;
	}
	
}
