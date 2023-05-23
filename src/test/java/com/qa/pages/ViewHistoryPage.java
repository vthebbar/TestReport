package com.qa.pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.DeleteFilesInDirectory;

public class ViewHistoryPage extends BasePage {

	public ViewHistoryPage(WebDriver driver) {
		super(driver);
	}

	//
	@FindBy(xpath="//span[normalize-space()='Account']/following-sibling::div/select") private WebElement dropDownAaccount;
	@FindBy(xpath="//span[@class='col-3 text-end mt-1 fw-semibold'][normalize-space()='Status']/following-sibling::div/select") private WebElement dropDownStatus;
	@FindBy(xpath="//span[@class='col text-end mt-1 fw-semibold'][normalize-space()='Transaction Type']/following-sibling::div/select") private WebElement dropDownTranType;
	@FindBy(xpath="//span[normalize-space()='Period']/following-sibling::div/select") private WebElement dropDownPeriod;
	@FindBy(id="idBtnSrch") private WebElement btnSearch;
	
	@FindBy(xpath="//span[@class='fw-semibold']") private WebElement lnkDownloadCSV;
	
	//table header
	@FindBy(xpath="//span[text()='Ref No.']") private WebElement tblRefNo;
	@FindBy(xpath="//span[text()='Date']") private WebElement tblDate;
	@FindBy(xpath="//span[text()='From']") private WebElement tblFrom;
	@FindBy(xpath="//span[text()='To Account']") private WebElement tblTo;
	@FindBy(xpath="//th/span[text()='Transaction Type']") private WebElement tblTranType;;
	@FindBy(xpath="//span[text()='Amount']") private WebElement tblAmount;
	@FindBy(xpath="//th/span[text()='Status']") private WebElement tblStatus;
	@FindBy(xpath="//span[text()='Actions']") private WebElement tblActions;

	//Link- REF No-1 & Repeat btn-2
	
	@FindBy(xpath="//table/tbody/tr[1]/td[1]") private WebElement txtRefNoLink1;
	@FindBy(xpath="//table/tbody/tr[1]/td[8]") private WebElement btnRepeat1;

	
	public void verifySearchDropDownOptionsAreDisplayed() {
		boolean flag=false;
		flag = isDisplayed(dropDownAaccount,"") && isDisplayed(dropDownStatus,"") && isDisplayed(dropDownTranType,"") && isDisplayed(dropDownPeriod,"") ;
		
		doAssertEqualsBoolean(flag, true,"Seach Options displayed?");
	}
	
	public void verifySearchBtnIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(btnSearch,"Search button"), true, "Search button displayed?");
	}
	
	
	public void clickOnDownloadCSV() {
		doClick(lnkDownloadCSV, "Download CSV link");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyFileDownloadIsSuccessful() {
		
		boolean res = performFileDownload();
		doAssertEqualsBoolean(res, true, "Files Download successful");
		performDeleteFiles();
	}
	
	public void verifyTableHeadersAreDisplayed() {
		boolean res=false;
		res = isDisplayed(tblRefNo,"") && isDisplayed(tblDate,"") && isDisplayed(tblFrom,"") && 
				isDisplayed(tblTo,"") && isDisplayed(tblTranType,"") && isDisplayed(tblAmount,"") 
				&& isDisplayed(tblStatus,"") && isDisplayed(tblActions,"") ;
		
		doAssertEqualsBoolean(res, true,"Table headers displayed");
	}
	
	//
	public TransactionDetailsPage clickOnRefNoLink() {
		
		doClick(txtRefNoLink1, "Reference Number link");
		return new TransactionDetailsPage(driver);
	}
	
	public void selectTransactionType(String visibleText) {
		selectValueFromDropDowm(dropDownTranType,visibleText);
	}
	
	public void clickOnSearchBtn() {
		doClick(btnSearch,"Search button");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnRepeatBtn() {
		doClick(btnRepeat1, "Repeat button");
	}
}
