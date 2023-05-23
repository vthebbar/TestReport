package com.qa.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import com.qa.utils.PDFReader;

public class FAQPage extends BasePage {

	public FAQPage(WebDriver driver) {
		super(driver);
	}

	public void verifyFAQPageTitle() throws InterruptedException {
		String url=null;
		String title=null;
		
	Set<String> handles =  driver.getWindowHandles();
	for(String h: handles) {
		   
		 driver.switchTo().window(h);
		 Thread.sleep(10000);
		   title= driver.getTitle();
		    url=driver.getCurrentUrl();
			System.out.println("URL="+ url);  

		   if(url.contains("faq.pdf")) {

			   break;
		   }
		  
	   }
	   
	   doAssertEqualsBoolean(url.contains("faq.pdf"), true, "Verify FAQ PDF document is displayed, page Url="+ url);
	}
}
