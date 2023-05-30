package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StandingInstructionDetailsPage extends BasePage {

	public StandingInstructionDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//label[normalize-space()='Transaction Type']/parent::td/following-sibling::td") private WebElement txtTranType;
	@FindBy(xpath="//label[normalize-space()='Transaction Date, Time']/parent::td/following-sibling::td") private WebElement txtTranDateTime;
	@FindBy(xpath="//label[normalize-space()='From']/parent::td/following-sibling::td") private WebElement txtFrom;
	@FindBy(xpath="//label[normalize-space()='To Account']/parent::td/following-sibling::td") private WebElement txtTo;
	@FindBy(xpath="//label[normalize-space()='Payee Name']/parent::td/following-sibling::td") private WebElement txtPayeeName;
	@FindBy(xpath="//label[normalize-space()='Amount (USD)']/parent::td/following-sibling::td") private WebElement txtAmountUSD;
	@FindBy(xpath="//label[normalize-space()='First Process Date']/parent::td/following-sibling::td") private WebElement txtFirstProcessDate;
	@FindBy(xpath="//label[normalize-space()='Frequency']/parent::td/following-sibling::td") private WebElement txtFrequency;
	@FindBy(xpath="//label[normalize-space()='No. of SI to be Made']/parent::td/following-sibling::td") private WebElement txtNumOfSI;
	@FindBy(xpath="//label[normalize-space()='Last Process Date']/parent::td/following-sibling::td") private WebElement txtLastProcessDate;
	@FindBy(xpath="//label[normalize-space()='Status']/parent::td/following-sibling::td") private WebElement txtStatus;

	@FindBy(xpath="//input[@value='Back']") private WebElement btnBack;
	@FindBy(xpath="//input[@value='Repeat']") private WebElement btnRepeat;

	
	public void verifyStadingInstructionDetailsAreDisplayed() {
		
		boolean flag=false;
		flag= isDisplayed(txtTranType,"") && isDisplayed(txtTranDateTime,"") && isDisplayed(txtFrom,"") && isDisplayed(txtTo,"") && 
				isDisplayed(txtPayeeName,"") && isDisplayed(txtAmountUSD,"") && isDisplayed(txtFirstProcessDate,"") && isDisplayed(txtFrequency,"") && 
				isDisplayed(txtNumOfSI,"") && isDisplayed(txtLastProcessDate,"") && isDisplayed(txtStatus,"") ;
		
		doAssertEqualsBoolean(flag, true, "Standing Instruction Details displayed?");
	}
	
	public void clickOnRepeatBtn() {
		doClick(btnRepeat, "Repeat button");
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	public void clickOnBackBtn() {
		doClick(btnBack,"Back button");
	}
}
