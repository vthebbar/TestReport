package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyQRPage extends BasePage {

	public MyQRPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//label[text()='Account']/following-sibling::span/select") private WebElement dropdownAccount;
	@FindBy(id="idBtnSubmit") private WebElement btnShowMyQR;
	
	//
	@FindBy(xpath="//*[@id=\"idFormCfmAckDtl:idSelectedAcctImg\"]/img[2]") private WebElement imgQRCode;
	@FindBy(xpath="//*[@id=\"idFormCfmAckDtl:idSelectedAcctImg\"]/img[1]") private WebElement imgLogo;
	@FindBy(xpath="//div/img/following-sibling::b/span") private List<WebElement> txtQRNameAccountNum;
	@FindBy(xpath="//input[@value='Print']") private WebElement btnPrint;;
	@FindBy(xpath="//input[@value='Save My QR']") private WebElement btnSaveMyQR;;
	@FindBy(xpath="//input[@value='Generate Another MY QR']") private WebElement btnGenerateAnotheMYrQR;;
	
	
	public void selectAccountFromDropDown(String value) {
		
		selectDropDownByValue(dropdownAccount, value);
	}
	
	public void clickonShowMyQRBtn() {
		doClick(btnShowMyQR, "Show My QR button");
	}
	
	public void verifyHLBConnectLogoIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(imgLogo, ""),true, "HLB COnnect Logo is displayed?");
	}
	
	public void verifyQRCodeIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(imgQRCode,""), true, "QR code is displayed ?");
	}
	
	public void verifyAccountNameAndAccountNumbersAreDisplayed() {
		
		boolean flag=false;
		if(txtQRNameAccountNum.size()==2) {
			flag= true;
		}
		doAssertEqualsBoolean(flag, true, "Account Name and Account Number are displayed ?");

	}
	
	public void verifyPrintBtnIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(btnPrint,""), true, "Print button is displayed?");
	}
	
	public void verifySaveMYQRBtnIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(btnSaveMyQR,""), true, "Save MY QR button is displayed?");

		}
	
	public void verifyGenerateAnotherMYQRBtnIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(btnGenerateAnotheMYrQR,""), true, "Generate Another MY QR button is displayed?");

	}
}
