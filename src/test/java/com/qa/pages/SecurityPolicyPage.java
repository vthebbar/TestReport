package com.qa.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SecurityPolicyPage extends BasePage {

	public SecurityPolicyPage(WebDriver driver) {
		super(driver);
	}

	public void verifySecurityPolicyPageTitle() throws InterruptedException {
		String url=null;
		String title=null;
		
	Set<String> handles =  driver.getWindowHandles();
	for(String h: handles) {
		   
		 driver.switchTo().window(h);
		 Thread.sleep(10000);
		   title= driver.getTitle();
		    url=driver.getCurrentUrl();
			System.out.println("URL="+ url);  

		   if(url.contains("security_policy.pdf")) {

			   break;
		   }
		  
	   }
	   
	   doAssertEqualsBoolean(url.contains("security_policy.pdf"), true, "Verify Security Policy PDF document is displayed, Page URL="+ url);
	}
}
