package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.qa.utils.PropertyManager;

public class ChangeDebitingAccountPage extends BasePage {

	public ChangeDebitingAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//select[@id='idAccountToLink']") private WebElement drpDownNewDebitAcct;
	@FindBy(xpath="//input[@id='idBtnSubmit']") private WebElement btnNext;
	@FindBy(xpath="//li[@class='error-msg']") private WebElement txtErrMsg;
	
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idPswd']") private WebElement txtHLBCPwd;
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idBtnConfirmTrsf']") private WebElement btnSubmit;
	@FindBy(xpath="//li[@class='success-msg']") private WebElement txtSuccessMsg;
	
	
	public void clickOnNextBtn() {
		
		doClick(btnNext, "Next button");
	}
	
	public void selectNewDebitAcct() {
		
		Select s = new Select(drpDownNewDebitAcct);
		List<WebElement> options = s.getOptions();
		s.selectByIndex(options.size()-1);
		
		doClick(btnNext, "Next button");
		
		if(driver.findElements(By.xpath("//li[@class='error-msg']")).size()>0)
		{
			s.selectByIndex(options.size()-2);
			doClick(btnNext, "Next button");

		}

	}
	
	public void keyInPassword() {
		
		String password = PropertyManager.propertyLoader().getProperty("password");
		doSendKeys(txtHLBCPwd, password, "HLB Connect Password");
	}
	
	public void clickOnSubmitBtn() {
		doClick(btnSubmit, "Submit button");
	}
	
	public void verifySuccessMsg(String expMsg) {
		String actMsg = getText(txtSuccessMsg, "Success Mesage");
		doAssertEqualsStrings(actMsg, expMsg, "Success Mesage");
	}
	
	public void keyInInvalidPassword(String InvalidPwd) {
		
		doSendKeys(txtHLBCPwd, InvalidPwd, "HLB Connect Invalid Password");

	}
	
	public void verifyErrorMsg(String expMsg) {
		
		String actMsg = getText(txtErrMsg, "Error Message");
		doAssertEqualsStrings(expMsg, actMsg, "Error message");
	}
}
