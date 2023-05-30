package com.qa.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.DeleteFilesInDirectory;
import com.qa.utils.PropertyManager;
import com.qa.utils.TACManager;

public class FixedDepositOverviewPage extends BasePage {

	public FixedDepositOverviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//label[normalize-space()='Account Number']/parent::span/following-sibling::div/select") private WebElement dropDownAcctNum;
	@FindBy(xpath="//label[normalize-space()='Available Balance (USD)']/parent::p/following-sibling::h5") private WebElement txtAvailableBalanceUSD;
	@FindBy(xpath="//label[normalize-space()='Equivalent Balance (USD)']/parent::span/following-sibling::div/span") private WebElement txtEquivalentbalanceUSD;

	
	@FindBy(xpath="//span[normalize-space()='Receipt No.']") private WebElement lblReceiptNo;
	@FindBy(xpath="//table/tbody/tr/td[count(//table/thead/tr/th/span[text()='Receipt No.']/parent::th/preceding-sibling::th)+1]") private WebElement txtReceiptNo;
	@FindBy(xpath="//table/tbody/tr/td[1]") private WebElement firstRectNoLink;
	
	
	@FindBy(xpath="//span[normalize-space()='Principal Amount (KHR)']") private WebElement lblPrincipalAmtKhr;
	@FindBy(xpath="//span[normalize-space()='Principal Amount (USD)']") private WebElement lblPrincipalAmtUSD;
	
	@FindBy(xpath="//table/tbody/tr/td[count(//table/thead/tr/th/span[text()='Principal Amount (KHR)']/parent::th/preceding-sibling::th)+1]") private WebElement txtPrincipalAmtKhr;
	
	@FindBy(xpath="//span[normalize-space()='Tenure']") private WebElement lblTenure;
	@FindBy(xpath="//table/tbody/tr/td[count(//table/thead/tr/th/span[text()='Tenure']/parent::th/preceding-sibling::th)+1]") private WebElement txtTenure;
	
	@FindBy(xpath="//span[normalize-space()='Placement Date']") private WebElement lblPlacementDate;
	@FindBy(xpath="//table/tbody/tr/td[count(//table/thead/tr/th/span[text()='Placement Date']/parent::th/preceding-sibling::th)+1]") private WebElement txtPlacementDate;
	
	@FindBy(xpath="//span[normalize-space()='Maturity Date']") private WebElement lblMaturityDate;
	@FindBy(xpath="//table/tbody/tr/td[count(//table/thead/tr/th/span[text()='Maturity Date']/parent::th/preceding-sibling::th)+1]") private WebElement txtMaturityDate;
	
	@FindBy(xpath="//span[normalize-space()='Rate (%)']") private WebElement lblRate;
	@FindBy(xpath="//table/tbody/tr/td[count(//table/thead/tr/th/span[text()='Rate (%)']/parent::th/preceding-sibling::th)+1]") private WebElement txtRate;
	
	
	@FindBy(xpath="//span[normalize-space()='Renewal Instruction']") private WebElement lblRenewalInstruction;
	@FindBy(xpath="//table/tbody/tr/td[count(//table/thead/tr/th/span[text()='Renewal Instruction']/parent::th/preceding-sibling::th)+1]") private WebElement txtRenewalInstruction;

	@FindBy(xpath="//span[normalize-space()='Actions']") private WebElement lblActions;
	@FindBy(xpath="//table/tbody/tr/td[count(//table/thead/tr/th/span[text()='Actions']/parent::th/preceding-sibling::th)+1]") private WebElement btnWithdraw;
	@FindBy(xpath="//table/tbody/tr/td[8]") private WebElement btnWithdrawFirst;
	
	//Download
	@FindBy(xpath="//span[@class='fw-semibold']") private WebElement lnkDownloadCSV;
	
	
	//******* Confirm detail section *****
	@FindBy(xpath="//label[normalize-space()='Account']/following-sibling::span") private WebElement txtAccountConfirm;
	@FindBy(xpath="//label[normalize-space()='Tenure']/following-sibling::span") private WebElement txtTenureConfirm;
	@FindBy(xpath="//label[normalize-space()='Rate (%)']/following-sibling::span") private WebElement txtRateConfirm;
	@FindBy(xpath="//label[normalize-space()='Maturity Date']/following-sibling::span") private WebElement txtMaturityDateConfirm;
	@FindBy(xpath="//label[normalize-space()='Principal Amount (KHR)']/following-sibling::span") private WebElement txtPrincipalAmtKhrConfirm;
	@FindBy(xpath="//label[normalize-space()='Principal Amount (USD)']/following-sibling::span") private WebElement txtPrincipalAmtUSDConfirm;
	@FindBy(xpath="//label[normalize-space()='Accrued Interest (KHR)']/following-sibling::span") private WebElement txtAccruedInterestKhrConfirm;
	@FindBy(xpath="//label[normalize-space()='Accrued Interest (USD)']/following-sibling::span") private WebElement txtAccruedInterestUSDConfirm;
	@FindBy(xpath="//label[normalize-space()='Transfer to Account']/following-sibling::span") private WebElement txtTransferToAcctConfirm;
	@FindBy(id="idBtnSubmit") private WebElement btnNextConfirm;
	
	
	@FindBy(xpath="//input[@id='idTACAdd']") private WebElement txtTAC;
	@FindBy(id="idBtnConfirm") private WebElement btnSubmit;
	
	//error msg
	@FindBy(xpath="//li[@class='error-msg']") private WebElement errMsgConfirm;
	
	
	//****** Acknowledgement section ****
	
	@FindBy(xpath="//li[@class='success-msg']") private WebElement txtSuccessMsgAck;
	@FindBy(xpath="//label[normalize-space()='Reference No']/following-sibling::span") private WebElement txtRefNumAck;
	@FindBy(xpath="//label[normalize-space()='Transaction Date, Time']/following-sibling::span") private WebElement txtTranDateTimeAck;
	@FindBy(xpath="//label[normalize-space()='Receipt No']/following-sibling::span") private WebElement txtRectNumAck;
	@FindBy(xpath="//label[normalize-space()='Tenure']/following-sibling::span") private WebElement txtTenureAck;
	@FindBy(xpath="//label[normalize-space()='Rate (%)']/following-sibling::span") private WebElement txtRateAck;
	@FindBy(xpath="//label[normalize-space()='Maturity Date']/following-sibling::span") private WebElement txtMaturityDateAck;
	
	@FindBy(xpath="//label[normalize-space()='Principal Amount (USD)']/following-sibling::span") private WebElement txtPrincipalAmtUSDAck;
	@FindBy(xpath="//label[normalize-space()='Principal Amount (KHR)']/following-sibling::span") private WebElement txtPrincipalAmtKHRAck;

	@FindBy(xpath="//label[normalize-space()='Accrued Interest (USD)']/following-sibling::span") private WebElement txtAccurredInterestUSDAck;
	@FindBy(xpath="//label[normalize-space()='Accrued Interest (KHR)']/following-sibling::span") private WebElement txtAccurredInterestKHRAck;

	
	@FindBy(xpath="//label[normalize-space()='Transfer to Account']/following-sibling::span") private WebElement txtTransferToAcctAck;
	@FindBy(xpath="//input[@value='Make a Placement']") private WebElement btnMakeAPlacementAck;
	@FindBy(xpath="//input[@value='Done']") private WebElement btnDoneAck;


	
	public void verifyRectNoISDisplayed() {
		doAssertEqualsBoolean(isDisplayed(lblReceiptNo,"Receipt Number label"), true, "Receipt No. label");
		//doAssertEqualsBoolean(isDisplayed(txtReceiptNo,"Receipt Number value"), true, "Receipt No. value");

	}
	
	public void verifyPrincipalAmtIsDisplayed() {
//		boolean flag1=isDisplayed(lblPrincipalAmtKhr,"Principal Amount label KHR");
//		boolean flag2=isDisplayed(lblPrincipalAmtUSD,"Principal Amount label USD");
		
		if(lblPrincipalAmtKhr.isDisplayed() || lblPrincipalAmtUSD.isDisplayed())
		{
		doAssertEqualsBoolean(true, true, "Principal Amount label displayed?");
		}
		else {
			doAssertEqualsBoolean(false, true, "Principal Amount label displayed?");

		}

		//doAssertEqualsBoolean(isDisplayed(txtPrincipalAmtKhr,"Principal Amount value"), true, "Principal Amount value");

	}
	
	public void verifyTenureIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(lblTenure,"Tenure label"), true, "Tenure label");
		//doAssertEqualsBoolean(isDisplayed(txtTenure,"Tenure value"), true, "Tenure value");

	}
	
	
	public void verifyPlacementDateIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(lblPlacementDate,"Placement Date label"), true, "Placement Date label");
		//doAssertEqualsBoolean(isDisplayed(txtTenure,"Placement Date value"), true, "Placement Date value");

	}
	
	
	public void verifyMaturityDateIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(lblMaturityDate,"Maturity Date label"), true, "Maturity Date label");
		//doAssertEqualsBoolean(isDisplayed(txtMaturityDate,"Maturity Date value"), true, "Maturity Date value");

	}
	
	
	public void verifyRateIsDiaplyed() {
		doAssertEqualsBoolean(isDisplayed(lblRate,"Rate label"), true, "Rate label");
		//doAssertEqualsBoolean(isDisplayed(txtRate,"Rate value"), true, "Rate value");

	}
	
	public void verifyRenewalInstructionIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(lblRenewalInstruction,"Renewal Instruction label"), true, "Renewal Instruction label");
		//doAssertEqualsBoolean(isDisplayed(txtRenewalInstruction,"Renewal Instruction value"), true, "Renewal Instruction value");

	}
	
	public void verifyActionsIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(lblActions,"Actions label"), true, "Actions label");
		//doAssertEqualsBoolean(isDisplayed(btnWithdraw,"Actions button"), true, "Actions button");

	}
	
	public void clickOnDownloadCSVlink() {
		
		doClick(lnkDownloadCSV,"Download CSV link");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void verifyDownloadCSVIsSuccessful() {
		
	
		File fileDownloadDir = new File(System.getProperty("user.dir")+"/test-output/Downloads");
		File files[]=fileDownloadDir.listFiles();
		boolean res= (files!=null && files.length>0);
		doAssertEqualsBoolean(res, true, "File Download Result");
		
		DeleteFilesInDirectory.deleteFiles();
	}
	
	public FixedDepositPlacementDetailPage clickOnReceiptNumberLink() {
		doClick(txtReceiptNo, "Receipt number value link");
		return new FixedDepositPlacementDetailPage(driver);
	}
	
	public FixedDepositWithdrawlPage clickOnWithDrawBtn() {
		doClick(btnWithdraw, "Withdraw button");
		return new FixedDepositWithdrawlPage(driver);
	}
	
	
	public void selectAcctNumFromDropDown(String acctNum) {
		selectValueFromDropDowm(dropDownAcctNum,acctNum);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyAvailableBalanceIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(txtAvailableBalanceUSD,"Available Balance"), true , "Available Balance is displayed?");
		
	}
	
	public void verifyEquivalentBalanceIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(txtEquivalentbalanceUSD,"Equivalent"), true , "Equivalent Balance is displayed?");

	}
	
	public FixedDepositPlacementDetailPage clickOnRectNoLink() {
		doClick(firstRectNoLink, "Receipt number link");
		return new FixedDepositPlacementDetailPage(driver);
	}
	
	public void clickOnWithdrawBtn() {
		
		doClick(btnWithdrawFirst, "Withdraw button");
	}
	
	public void verifyConfirmDetailsSection() {
		
		boolean flag = false;
		flag = isDisplayed(txtAccountConfirm,"") &&isDisplayed(txtTenureConfirm,"") &&isDisplayed(txtRateConfirm,"")
				&&isDisplayed(txtMaturityDateConfirm,"") &&isDisplayed(txtTransferToAcctConfirm,"") &&isDisplayed(btnNextConfirm,"") ;
		
		boolean flag1= false;
		if(txtPrincipalAmtKhrConfirm.isDisplayed() || txtPrincipalAmtUSDConfirm.isDisplayed()) {
			flag1=true;
		}
		
		boolean flag2= false;
		if(txtAccruedInterestKhrConfirm.isDisplayed() || txtAccruedInterestUSDConfirm.isDisplayed()) {
			flag2=true;
		}
		
		if(flag && flag1 && flag2) {
			doAssertEqualsBoolean(true, true,"Confirm details section elements displayed?");
		}
		else {
			doAssertEqualsBoolean(false, true,"Confirm details section elements displayed?");

		}
	}
	

	
	public void clickOnNextBtn() {
		doClick(btnNextConfirm, "Next button");
	}
	
	public void keyInInvalidTac(String invalidTac) {
		doSendKeys(txtTAC,invalidTac, "Invalid TAC");
	}
	
	public void clickOnSubmitBtn() {
		doClick(btnSubmit, "Submit button");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyErrMsg(String expMsg) {
		String actMsg = getText(errMsgConfirm, "Invalid TAC error mesage");
		doAssertEqualsStrings(actMsg, expMsg, "Invalid TAC error mesage");
	}
	
	public void keyInTac() {
	String userName = PropertyManager.propertyLoader().getProperty("userName");
    TACManager tacManager = new TACManager();
    String tac = tacManager.getTacCode(driver, userName);
    doSendKeys(txtTAC, tac,"TAC");
	}
	
	public void verifySuccessMessage(String expMsg) {
		String actMsg = getText(txtSuccessMsgAck, "");
		doAssertEqualsStrings(actMsg, expMsg, "Success message");
	}
	
	public void verifyAcknowledgementSection() {
		
		boolean flag  = false;
		flag = isDisplayed(txtSuccessMsgAck,"") && isDisplayed(txtRefNumAck,"") && isDisplayed(txtTranDateTimeAck,"") && isDisplayed(txtRectNumAck,"") 
				&& isDisplayed(txtTenureAck,"") && isDisplayed(txtRateAck,"") &&
				isDisplayed(txtMaturityDateAck,"") && isDisplayed(txtTransferToAcctAck,"") && isDisplayed(btnMakeAPlacementAck,"")
				&& isDisplayed(btnDoneAck,"") ;
		
		boolean flag1= false;
		if(txtPrincipalAmtUSDAck.isDisplayed() || txtPrincipalAmtKHRAck.isDisplayed()) {
			flag1=true;
		}
		
		boolean flag2=false;
		if(txtAccurredInterestUSDAck.isDisplayed() || txtAccurredInterestKHRAck .isDisplayed()) {
			flag2=true;
		}
		
		if(flag && flag1 && flag2) {
			doAssertEqualsBoolean(true, true, "Acknowledgment section elements displayed ?");
		}
		
		else {
			doAssertEqualsBoolean(false, true, "Acknowledgment section elements displayed ?");

		}
	}
	
	public void clickOnMakeAPlacementbtn() {
		doClick(btnMakeAPlacementAck, "Make a Placement button");
	}
	
	public void clickOnDoneBtn() {
		doClick(btnDoneAck, "Done button");
	}
}
