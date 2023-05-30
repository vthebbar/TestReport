package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransactionDetailsPage extends BasePage {

	public TransactionDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//label[normalize-space()='Transaction Status']/following-sibling::span") private WebElement txtTranStatus;
	@FindBy(xpath="//label[normalize-space()='Transaction Date, Time']/following-sibling::span") private WebElement txtTranDateTime;
	@FindBy(xpath="//label[normalize-space()='From']/following-sibling::span") private WebElement txtFrom;
	@FindBy(xpath="//label[normalize-space()='To Account']/following-sibling::span") private WebElement txtTo;
	@FindBy(xpath="//label[contains(@for,'idFormEntry:idAmt')]/parent::span/following-sibling::span") private WebElement txtAmount;
	@FindBy(xpath="//label[normalize-space()='Transaction Type']/following-sibling::span") private WebElement txtTranType;
	@FindBy(xpath="//input[@value='Back']") private WebElement btnBack;
	@FindBy(xpath="//input[@value='Repeat']") private WebElement btnRepeat;


	public void verifyAllTransactioinDetailsAreDisplayed() {
		boolean flag=false;
		flag = isDisplayed(txtTranStatus,"") && isDisplayed(txtTranDateTime,"") && isDisplayed(txtFrom,"") && isDisplayed(txtTo,"") &&
				isDisplayed(txtAmount,"") && isDisplayed(txtTranType,"") && isDisplayed(btnBack,"") && isDisplayed(btnRepeat,"");
		
		doAssertEqualsBoolean(flag, true, "All Transaction details displayed ?");
	}
	
	public void verifyBackAndRepeatBtnAreDisplayed() {
		boolean flag=false;
		flag = isDisplayed(btnBack,"") && isDisplayed(btnRepeat,"") ;
		
		doAssertEqualsBoolean(flag, true, "Back and Repeat buttons displayed ?");

	}
	
	public void clickOnRepeatBtn() {
		
		doClick(btnRepeat, "Repeat button");
	}
	
	public ViewHistoryPage clickOnBackBtn() {
		doClick(btnBack, "Back button");
		return new ViewHistoryPage(driver);
	}
}
