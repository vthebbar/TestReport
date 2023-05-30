package com.qa.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class PrivacyPolicyPage extends BasePage {

	
	public PrivacyPolicyPage(WebDriver driver) {
		super(driver);
	}

	public void verifyPrivacyPolicypageTitle() throws InterruptedException {
		
		String url=null;
		String title=null;
		
	Set<String> handles =  driver.getWindowHandles();
	for(String h: handles) {
		   
		 driver.switchTo().window(h);
		 Thread.sleep(10000);
		   title= driver.getTitle();
		    url=driver.getCurrentUrl();
			System.out.println("URL="+ url);  

		   if(url.contains("privacy_policy.pdf")) {

			   break;
		   }
		  
	   }
	   
	   doAssertEqualsBoolean(url.contains("privacy_policy.pdf"), true, "Verify Privacy Policy PDF document is displayed, page URL="+ url);
	}
	}

