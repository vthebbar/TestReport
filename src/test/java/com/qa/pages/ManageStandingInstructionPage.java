package com.qa.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ManageStandingInstructionPage extends BasePage {

	public ManageStandingInstructionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//label[normalize-space()='Transaction Type']/following-sibling::span/select")
	private WebElement dropDownTranType;
	@FindBy(xpath = "//label[normalize-space()='Status']/following-sibling::span/select")
	private WebElement dropDownStatus;

	@FindBy(id = "idBtnSrch")
	private WebElement btnSearch;
	@FindBy(xpath = "//span[@class='fw-semibold']")
	private WebElement lnkDownloadCSV;

	// Table headers
	@FindBy(xpath = "//span[@class='text-nowrap text-uppercase']")
	private WebElement lblRefNo;
	@FindBy(xpath = "//span[text()='Next Process']")
	private WebElement lblNextProcessDate;
	@FindBy(xpath = "//span[text()='From Account']")
	private WebElement lblFromAccount;
	@FindBy(xpath = "//span[text()='To Account']")
	private WebElement lblToAccount;
	@FindBy(xpath = "//span[text()='Transaction Type']")
	private WebElement lblTranType;
	@FindBy(xpath = "//span[text()='Amount']")
	private WebElement lblAmount;
	@FindBy(xpath = "//span[text()='Status']")
	private WebElement lblStatus;
	@FindBy(xpath = "//span[text()='Actions']")
	private WebElement lblActions;

	@FindBy(xpath="//table/tbody/tr/td[count(//table/thead/tr/th/span[text()='Transaction Type']/parent::th/preceding-sibling::th)+1]") private List<WebElement> txtTranTypeValue;
	@FindBy(xpath="//table/tbody/tr/td[count(//table/thead/tr/th/span[text()='Status']/parent::th/preceding-sibling::th)+1]") private List<WebElement> txtStatus;
	@FindBy(xpath="//td[normalize-space()='No records found.']") private WebElement txtNoRecordsFound;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[8]") private WebElement btnRepeat;
	@FindBy(xpath="//table/tbody/tr[1]/td[1]") private WebElement linkRefNo;
	
	public void verifyTranTypeDropDownValues(List<String> expValues) {

		boolean flag = false;
		List<String> actValues = getDropDownValues(dropDownTranType);

		if (expValues.size() != actValues.size()) {
			flag = false;
			doAssertEqualsBoolean(flag, true, "Number of dropdown values expected & actual same ?");
			return;
		} else {
//			Collections.sort(actValues);
//			Collections.sort(expValues);
			System.out.println("ACT="+actValues);
			System.out.println("EXP="+expValues);
			

				//if (actValues.get(i).trim() != expValues.get(i).trim()) {
				if(expValues.containsAll(actValues)) {
					flag = true;
					
					
				}
			
		}
		doAssertEqualsBoolean(flag, true, "Dropdown values expected & actual are same ?");

	}
	
	
	public void verifyStatusDropDownValues(List<String> expValues) {

		boolean flag = false;
		List<String> actValues = getDropDownValues(dropDownStatus);
		
		System.out.println("ACT="+actValues);
		System.out.println("EXP="+expValues);
		

		if (expValues.size() != actValues.size()) {
			flag = false;
			doAssertEqualsBoolean(flag, true, "Number of dropdown values expected & actual same ?");
			return;
		} else {
//			Collections.sort(actValues);
//			Collections.sort(expValues);
			
			

			
			

				//if (actValues.get(i).trim() != expValues.get(i).trim()) {
				if(actValues.containsAll(expValues)) {
					flag = true;
				}
			
		}
		doAssertEqualsBoolean(flag, true, "Dropdown values expected & actual are same ?");

	}

	public void selectTranTypeSearchValue(String tranType) {
		selectValueFromDropDowm(dropDownTranType, tranType);
	}
	
	public void clickOnSearchBtn() {
		doClick(btnSearch, "Search button");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyTranTypeColValue(String expVal) {
		
		boolean flag=true;
		for(int i=0;i<txtTranTypeValue.size();i++) {
			String actVal = txtTranTypeValue.get(0).getText().trim();
			if(!actVal.equalsIgnoreCase(expVal)) {
				flag=false;
			}
		}
		
		if(txtTranTypeValue.size()==0) {
		if(txtNoRecordsFound.isDisplayed()) {
			flag=true;
			System.out.println("No Record Displayed for the given search");
		}
		}
		
		doAssertEqualsBoolean(flag, true,"Transaction Type COlumn Values are correct?");
	}
	
	
	public void selectStatusValue(String status) {
		selectValueFromDropDowm(dropDownStatus,status);
	}
	
     public void verifyStatusColValue(String expVal) {
		
		boolean flag=true;
		for(int i=0;i<txtStatus.size();i++) {
			String actVal = txtStatus.get(0).getText().trim();
			if(!actVal.equalsIgnoreCase(expVal)) {
				flag=false;
			}
		}
		
		if(txtStatus.size()==0) {
		if(txtNoRecordsFound.isDisplayed()) {
			flag=true;
			System.out.println("No Record Displayed for the given search");
		}
		}
		
		doAssertEqualsBoolean(flag, true,"Status column Values are correct?");
	}
     
     public void clickOnDownloadCSVLink() {
    	 doClick(lnkDownloadCSV, "Download CSV link");
    	 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
     }
     
     public void verifyFileDownload() {
    	 performFileDownload();
    	 performDeleteFiles();
     }
     
     public void verifyTableHeadersAreDisplayed() {
    	 
    	 boolean flag= false;
    	 flag = isDisplayed(lblRefNo,"") && isDisplayed(lblNextProcessDate,"") && isDisplayed(lblFromAccount,"") && isDisplayed(lblToAccount,"") && 
    			 isDisplayed(lblTranType,"") && isDisplayed(lblAmount,"") && isDisplayed(lblStatus,"") && isDisplayed(lblActions,"") ;
    	 
    	 doAssertEqualsBoolean(flag, true,"Verify table headers are displayed correctly ?");
     }
     
     public void clickOnRepeatBtn() {
    	 doClick(btnRepeat,"Repeat button");
    	 try {
 			Thread.sleep(5000);
 		} catch (InterruptedException e) {
 			e.printStackTrace();
 		}
     }
     
     public void clickOnRefNoLink() {
    	 doClick(linkRefNo,"Reference Number");
    	 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
     }
     
     public void verifySearchBtnIsDisplayed() {
    	 doAssertEqualsBoolean(isDisplayed(btnSearch,""), true , "Manage Standing Instruction screen displayed ?");
     }
}
