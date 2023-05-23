package com.qa.pages;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.utils.DeleteFilesInDirectory;

public class CASAAccountOverviewPage extends BasePage {

	public CASAAccountOverviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[@class='account-details-card d-flex flex-column justify-content-center text-center']") private WebElement boxAvailableBalance;
	
	@FindBy(xpath="//label[normalize-space()='Account Number']") private WebElement lblAcctNum;
	@FindBy(xpath="//label[normalize-space()='Account Number']/parent::p/following-sibling::p") private WebElement txtAcctNumValue;
	
	
	@FindBy(xpath="//label[normalize-space()='Current Balance (KHR)']") private WebElement lblCurrentBalance;
	@FindBy(xpath="//label[normalize-space()='Current Balance (KHR)']/parent::p/following-sibling::p") private WebElement txtCurrentBalance;
	
	
	@FindBy(xpath="//label[normalize-space()='Account Details As Of']") private WebElement lblAcctDetailsAsOf;
	@FindBy(xpath="//label[normalize-space()='Account Details As Of']/parent::p/following-sibling::p") private WebElement txtAcctDetailsAsOf;
	
	@FindBy(xpath="//label[normalize-space()='Basic Interest Rate']") private WebElement lblBasicInterestRate;
	@FindBy(xpath="//label[normalize-space()='Basic Interest Rate']/parent::p/following-sibling::p") private WebElement txtBasicInterestRate;
	
	@FindBy(xpath="//label[normalize-space()='Status']") private WebElement lblStatus;
	@FindBy(xpath="//label[normalize-space()='Status']/parent::p/following-sibling::p") private WebElement txtStatus;
	
	
	@FindBy(xpath="//select[@id='idForm:j_idt459']") private WebElement drpDwnTrnTimeLine;
	@FindBy(xpath="//input[@id='idForm:idDtFrom']") private WebElement calendarDateFrom;
	@FindBy(xpath="//input[@id='idForm:idTo']") private WebElement calendarDateTo;

	@FindBy(xpath="//div[@class='col-9']//li[1]//a[1]//span[1]") private WebElement lnkDownloadCSV;
	@FindBy(xpath="//a[@id='idForm:j_idt466']//span[@class='fw-semibold']") private WebElement lnkDownloadPDF;

	
	public void verifyAvailableBalanceBoxIsNotClickable() {
		doClick(boxAvailableBalance, "Available Balance box");
		
		// verify box is still visible after click
		doAssertEqualsBoolean(isDisplayed(boxAvailableBalance, "Available Balance box"), true, "Available Balance box");

	}

	public void verifyAcctNumberIsDIsplayed() {
	
		doAssertEqualsBoolean(isDisplayed(lblAcctNum, "Account Number Label"), true, "Account Number Label");
		doAssertEqualsBoolean(isDisplayed(txtAcctNumValue, "Account Number Value"), true, "Account Number Value");
		
	}
	
	public void verifyCurrentBalanceIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(lblCurrentBalance, "Current Balance Label"), true, "Current Balance Label");
		doAssertEqualsBoolean(isDisplayed(txtCurrentBalance, "Current Balance Value"), true, "Current Balance Value");
	}
	
	public void verifyAcctDetailsAsOfIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(lblAcctDetailsAsOf, "Account Details As Of Label"), true, "Account Details As Of Label");
		doAssertEqualsBoolean(isDisplayed(txtAcctDetailsAsOf, "Account Details As Of Value"), true, "Account Details As Of Value");
	}
	
	public void verifyBasicInterestRateIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(lblBasicInterestRate, "Basic Interest Rate Label"), true, "Basic Interest Rate Label");
		doAssertEqualsBoolean(isDisplayed(txtBasicInterestRate, "Basic Interest Rate Value"), true, "Basic Interest Rate Value");
	}
	
	public void verifyStatusIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(lblStatus, "Status Label"), true, "Status Label");
		doAssertEqualsBoolean(isDisplayed(txtStatus, "Status Value"), true, "Status Value");
	}
	
	public void verifyAbleToSelectValueFromTransactionTimeLineDropDown() {
		selectValueFromDropDowm(drpDwnTrnTimeLine,"Date Range");
		
		doAssertEqualsBoolean(isDisplayed(calendarDateFrom, "From Date Selection Calendar"), true, "From Date Selection Calendar");
		doAssertEqualsBoolean(isDisplayed(calendarDateTo, "To Date Selection Calendar"), true, "To Date Selection Calendar");
		

	}
	
	public void verifyOnDownLoadCSV() {
		doClick(lnkDownloadCSV,"Download CSV");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		wait.until(new ExpectedCondition<Boolean>() {
//		    public Boolean apply(WebDriver driver) {
//		        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
//		    }
//		});
		
		File downloadDir = new File(System.getProperty("user.dir")+"/test-output/Downloads");
		//System.out.println("DIR="+downloadDir);
		File[] files = downloadDir.listFiles();
		boolean res = (files != null && files.length > 0);
		doAssertEqualsBoolean(res, true, "Files Download successful");
		
		DeleteFilesInDirectory.deleteFiles();
	}
	
	public void verifyOnDownLoadPDF() {
		doClick(lnkDownloadPDF,"Download PDF");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
//		wait.until(new ExpectedCondition<Boolean>() {
//		    public Boolean apply(WebDriver driver) {
//		        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
//		    }
//		});
		
		File downloadDir = new File(System.getProperty("user.dir")+"/test-output/Downloads");
		File[] files = downloadDir.listFiles();
		boolean res = (files != null && files.length > 0);
		doAssertEqualsBoolean(res, true, "Files Download Result");
		
		DeleteFilesInDirectory.deleteFiles();
	}
}
