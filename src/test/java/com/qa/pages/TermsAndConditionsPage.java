package com.qa.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class TermsAndConditionsPage extends BasePage {

	
	public TermsAndConditionsPage(WebDriver driver) {
		super(driver);
	}

	public void verifyTermsAndConditionsPageTitle() throws InterruptedException {
		String url=null;
		String title=null;
		
	Set<String> handles =  driver.getWindowHandles();
	for(String h: handles) {
		   
		 driver.switchTo().window(h);
		 Thread.sleep(10000);
		   title= driver.getTitle();
		    url=driver.getCurrentUrl();
			System.out.println("URL="+ url);  

		    
		   if(url.contains("tnc.pdf")) {
			   break;
		   }
		  
	   }
	   
	   doAssertEqualsBoolean(url.contains("tnc.pdf"), true, "Verify Terms and Conditions PDF document is displayed, Page URL="+ url);
	}
}
