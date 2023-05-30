package com.qa.pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.PropertyManager;
import com.qa.utils.TACManager;

public class FixedDepositPlacementPage extends BasePage {

	public FixedDepositPlacementPage(WebDriver driver) {
		super(driver);
	}

	// ****** Details entry section *****
	
	@FindBy(xpath="//label[normalize-space()='From']/following-sibling::span/select") private WebElement dropDownFrom;
	@FindBy(xpath="//label[normalize-space()='Tenure']/following-sibling::span/select") private WebElement dropDownTenure;
	@FindBy(id="idAmt") private WebElement txtAmount;
	@FindBy(xpath="//label[normalize-space()='Remarks']/following-sibling::span/input") private WebElement txtRemarks;
	@FindBy(id="idRenewalInst") private WebElement dropDownRenewalInstr;
	
	@FindBy(xpath="//label[normalize-space()='Rate (%)']") private WebElement txtRate;
	@FindBy(xpath="//a[normalize-space()='here']") private WebElement lnkInterestRate;
	@FindBy(xpath="//label[normalize-space()='Effective Date']/following-sibling::span/span") private WebElement txtEffectiveDate;
	
	@FindBy(id="idBtnSubmit") private WebElement btnNext;
	
	
	
	@FindBy(xpath="//label[normalize-space()='Transaction Status']/following-sibling::span") private WebElement txtTranStatus;
	
	//Error messages
	@FindBy(xpath="//span[@class='text-danger']") private WebElement txtErrMsg;
	@FindBy(xpath="//li[@class='error-msg']") private WebElement txtErrMsgAmount;
	
	//******** Confirmation Section ******
	@FindBy(xpath="//label[normalize-space()='From']/following-sibling::span") private WebElement txtFromConfirm;
	@FindBy(xpath="//label[normalize-space()='Tenure']/following-sibling::span") private WebElement txtTenureConfirm;
	@FindBy(xpath="//label[normalize-space()='Principal Amount (USD)']/following-sibling::span") private WebElement txtPrincipalAmtUSDConfirm;
	@FindBy(xpath="//label[normalize-space()='Remarks']/following-sibling::span") private WebElement txtRemarksConfirm;
	@FindBy(xpath="//label[normalize-space()='Maturity Instructions']/following-sibling::span") private WebElement txtMaturityInstrConfirm;
	@FindBy(xpath="//label[normalize-space()='Rate (%)']/following-sibling::span") private WebElement txtRateConfirm;
	@FindBy(xpath="//label[normalize-space()='Effective Date']/following-sibling::span") private WebElement txtEffectiveDateConfirm;
	@FindBy(xpath="//label[@for='idFormCfmAckDtl:idTACAdd']") private WebElement lblTAC;
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idTACAdd']") private WebElement txtTac;

	@FindBy(xpath="//a[text()='Back']") private WebElement btnBack;
	@FindBy(xpath="//input[@value='Submit']") private WebElement btnSubmit;

	@FindBy(xpath="//li[@class='error-msg']") private WebElement errMsgConfirmScreen;
	
	//******* Acknowledgement section *******
	
	@FindBy(xpath="//li[@class='success-msg']") private WebElement txtSuccessMsgAck;
	@FindBy(xpath="//label[normalize-space()='Reference No']/following-sibling::span") private WebElement txtRefNoAck;
	@FindBy(xpath="//label[normalize-space()='Transaction Status']/following-sibling::span") private WebElement txtTranStatAck;
	@FindBy(xpath="//label[normalize-space()='Receipt No']/following-sibling::span") private WebElement txtRectNoAck;

	@FindBy(xpath="//label[normalize-space()='Transaction Date, Time']/following-sibling::span") private WebElement txtTranDateTimeAck;
	@FindBy(xpath="//label[normalize-space()='From Account No']/following-sibling::span") private WebElement txtFromAcctAck;
	@FindBy(xpath="//label[normalize-space()='Balance After Placement (USD)']/following-sibling::span") private WebElement txtBalanceAfterAck;
	@FindBy(xpath="//label[normalize-space()='FD Account Number']/following-sibling::span") private WebElement txtFDAcctNoAck;
	@FindBy(xpath="//label[normalize-space()='Tenure']/following-sibling::span") private WebElement txtTenureAck;
	@FindBy(xpath="//label[normalize-space()='Principal Amount (USD)']/following-sibling::span") private WebElement txtPrincipalAmtAck;
	@FindBy(xpath="//label[normalize-space()='Remarks']/following-sibling::span") private WebElement txtRemarksAck;
	@FindBy(xpath="//label[normalize-space()='Maturity Instructions']/following-sibling::span") private WebElement txtMaturityInstrAck;
	@FindBy(xpath="//label[normalize-space()='Rate (%)']/following-sibling::span") private WebElement txtRateAck;
	@FindBy(xpath="//label[normalize-space()='Effective Date']/following-sibling::span") private WebElement txtEffDateAck;
	@FindBy(xpath="//label[normalize-space()='Maturity Date']/following-sibling::span") private WebElement txtmaturityDateAck;
	@FindBy(xpath="//input[@value='Make Another Placement']") private WebElement btnMakeAnotherPlacement;
	@FindBy(xpath="//input[@value='Done']") private WebElement btnDone;

	
	
	
	public void selectFromAccount(String value) {
		selectDropDownByValue(dropDownFrom, value);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectTenure(String value) {
		
		try {
			selectValueFromDropDowm(dropDownTenure, value);

		} catch (Exception e) {
			
			selectValueFromDropDowm(dropDownTenure, value);
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void keyInAmount(String value) {
		
		try {
		doSendKeys(txtAmount, value,"Principal amount");
		}
		catch(StaleElementReferenceException e) {
			doSendKeys(txtAmount, value,"Principal amount");

		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void keyInRemarks(String value) {
		doSendKeys(txtRemarks, value, "Remarks");
	}
	
	public void selectRenewalInstruction(String value) {
		selectValueFromDropDowm(dropDownRenewalInstr, value);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	}
	
	public void clickOnNextbtn() {
		try {
		
			doClick(btnNext, "Next button");
		
		}
		catch(Exception e) {
			doClick(btnNext, "Next button");
		}
	}
	

	public void keyInTac() {
        TACManager tacManager = new TACManager();
		
		String userName = PropertyManager.propertyLoader().getProperty("userName");
		String tacCode = tacManager.getTacCode(driver, userName);
		doSendKeys(txtTac,tacCode, "TAC code");
	}
	
	public void clickOnSubmitBtn() {
		doClick(btnSubmit, "Submit button");
	}
	
	public void verifyTranStatus(String expVal) {
		String actVal = getText(txtTranStatus, "Transaction status");
		doAssertEqualsStrings(actVal, expVal,"Transaction Status");
	}
	
	public void verifyAllFieldsDisplayedInDetailsEntrySection() {
		
		boolean flag=false;
		
		flag = isDisplayed(dropDownFrom,"") && isDisplayed(dropDownTenure,"") && isDisplayed(txtAmount,"") && isDisplayed(txtRemarks,"") &&
				isDisplayed(dropDownRenewalInstr,"") && isDisplayed(txtRate,"") &&  isDisplayed(lnkInterestRate,"") &&  isDisplayed(txtEffectiveDate,"")
				&& isDisplayed(btnNext,"");
		
		doAssertEqualsBoolean(flag, true, "All fields displaued ?");
	}
	
	public void clickOnInterestRateLink() {
		doClick(lnkInterestRate, "Interest Rate link");
	}
	
	public void verifyNewWindowWithGivenUrlIsOpen(String title, String url) {
		boolean flag=false;
		Set<String> handles=driver.getWindowHandles();
		
		
		String tempTitle=null;
		String temUrl=null;
		
		for(String handle : handles) {
			
			tempTitle=driver.switchTo().window(handle).getTitle();
			temUrl=driver.switchTo().window(handle).getCurrentUrl();
			
			if(tempTitle.equalsIgnoreCase(title) && temUrl.equalsIgnoreCase(url)) {
				flag=true;
				driver.switchTo().defaultContent();
				driver.switchTo().window(handle).close();
			}
		}
		
	}
	
	public void verifyErrorMsg(String expMsg) {
		String actMsg = getText(txtErrMsg, "Error message");
		doAssertEqualsStrings(actMsg, expMsg, "Error message");
	}
	
	public void verifyErrMsgAmountLessThanUSD1k(String expVal) {
		String actval=getText(txtErrMsgAmount,"Error mesage amount less than 1k USD");
		doAssertEqualsStrings(actval, expVal, "Error mesage amount less than 1k USD");

	}
	
	public void verifyConfirmScreen() {
		boolean flag = false;
		flag = isDisplayed(txtFromConfirm,"") && isDisplayed(txtTenureConfirm,"") && isDisplayed(txtPrincipalAmtUSDConfirm,"") 
				&& isDisplayed(txtRemarksConfirm,"") && isDisplayed(txtMaturityInstrConfirm,"") &&
				isDisplayed(txtRateConfirm,"") && isDisplayed(txtEffectiveDateConfirm,"") && isDisplayed(lblTAC,"") && isDisplayed(txtTac,"") 
				&& isDisplayed(btnBack,"") && isDisplayed(btnSubmit,"") ;
		
		doAssertEqualsBoolean(flag, true, "All fields displayed in confirmtion screen ?");
	}
	
	public void keyInInvalidTac(String invaldiTac) {
		doSendKeys(txtTac,invaldiTac,"Invalid Tac");
	}

	
	public void verifyErrMsgInConfirmScreen(String expMsg) {
		
		String actMsg = getText(errMsgConfirmScreen,"Actual Error message");
		doAssertEqualsStrings(actMsg, expMsg,"Error message for invalid TAC");
	}
	
	
	public void verifySuccessMsginAcknowledgmentSection(String expMsg) {
		String actMsg = getText(txtSuccessMsgAck,"Success Message");
		doAssertEqualsStrings(actMsg, expMsg,"Success Message");
	}
	
	
	public void verifyAcknowledgementScreen() {
		boolean flag = false;
		flag = isDisplayed(txtSuccessMsgAck,"") && isDisplayed(txtRefNoAck,"") && isDisplayed(txtTranStatAck,"") 
				&& isDisplayed(txtRectNoAck,"") && isDisplayed(txtTranDateTimeAck,"") &&
				isDisplayed(txtFromAcctAck,"") && isDisplayed(txtBalanceAfterAck,"") && isDisplayed(txtFDAcctNoAck,"") && isDisplayed(txtTenureAck,"") 
				&& isDisplayed(txtPrincipalAmtAck,"") && isDisplayed(txtRemarksAck,"") && isDisplayed(txtMaturityInstrAck,"")
				&& isDisplayed(txtRateAck,"")&& isDisplayed(txtEffDateAck,"")&& isDisplayed(txtmaturityDateAck,"")&& isDisplayed(btnMakeAnotherPlacement,"")
				&& isDisplayed(btnDone,"");
		
		doAssertEqualsBoolean(flag, true, "All fields displayed in Acknowledgement screen ?");
	}
	
	public void clcikOnMakeAnotherPlacementBtn() {
		//scrollToBottomOfPage(driver);
		scrollToElement(driver,btnMakeAnotherPlacement);

		doClick(btnMakeAnotherPlacement,"Make Another palcement");
	}
	
		public void clickOnDonebtn() {
			//scrollToBottomOfPage(driver);
		
			scrollToElement(driver,btnDone);
			doClick(btnDone,"Done");

	}
		
		
  }
