package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ESaverViewApplicationHistoryPage extends BasePage {

	public ESaverViewApplicationHistoryPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//label[normalize-space()='Application Type']/following-sibling::span/select") private WebElement dropDownApplicationType;
	@FindBy(xpath="//label[normalize-space()='Status']/following-sibling::span/select") private WebElement dropDownStatus;
	@FindBy(xpath="//label[normalize-space()='Period']/following-sibling::span/select") private WebElement dropDownPeriod;
	@FindBy(id="idBtnSrch")private WebElement btnSearch;
	@FindBy(xpath="//span[@class='fw-semibold']") private WebElement linkDownloadCSV;
	
	
	//Date selection
	@FindBy(id="idDtFrom") private WebElement calendarIconStartDate;
	@FindBy(id="idTo") private WebElement calendarIconEndDate;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']") private WebElement dropDownMonth;
	@FindBy(xpath="//select[@class='ui-datepicker-year']") private WebElement dropDownYear;

	
	//Search Results
	
	@FindBy(xpath="//table/tbody/tr/td[count(//table/thead/tr/th/span[text()='Application Type']/parent::th/preceding-sibling::th)+1]") private List<WebElement> txtAppTypeValues;
	@FindBy(xpath="//table/tbody/tr/td[count(//table/thead/tr/th/span[text()='Status']/parent::th/preceding-sibling::th)+1]") private List<WebElement> txtStatusValues;
	
	@FindBy(xpath="//table/tbody/tr")  private List<WebElement> rows;
	
	//Table headers
	@FindBy(xpath="//span[normalize-space()='Ref No.']") private WebElement lblRefNo;
	@FindBy(xpath="//span[normalize-space()='Date']") private WebElement lblDate;
	@FindBy(xpath="//span[normalize-space()='Account']") private WebElement lblAcctNum;
	@FindBy(xpath="//span[normalize-space()='Application Type']") private WebElement lblApplType;
	@FindBy(xpath="//span[@class='d-block text-center text-uppercase ']") private WebElement lblStatus;

	//Data
	@FindBy(xpath="//table/tbody/tr[1]/td[1]") private WebElement linkFirstRefNo;
	
	//Ref No link details
	@FindBy(xpath="//label[normalize-space()='Transaction Date, Time']/following-sibling::span") private WebElement txtTranDateTime;
	@FindBy(xpath="//label[normalize-space()='E-Saver Account No.']/following-sibling::span") private WebElement txtEsaverAcctNum;
	@FindBy(xpath="//label[normalize-space()='Account Name']/following-sibling::span") private WebElement txtAcctName;
	@FindBy(xpath="//label[normalize-space()='Debiting Account']/following-sibling::span") private WebElement txtDebitAcct;
	@FindBy(xpath="//label[normalize-space()='Amount (USD)']/following-sibling::span") private WebElement txtAmount;
	@FindBy(xpath="//input[@value='Done']") private WebElement btnDone;

	
	public void selectApplicationType(String appType) {
		
		selectValueFromDropDowm(dropDownApplicationType, appType);
	}
	
	public void selectStatus(String status) {
		
		selectValueFromDropDowm(dropDownStatus, status);

	}
	
	public void selectPeriod(String period, String startDate, String endDate) {
		
		if(period.equalsIgnoreCase("Date Range")) {
		selectValueFromDropDowm(dropDownPeriod, period);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			String startValues[]=startDate.split("/");
			String endValues[] = endDate.split("/");
			
			
			//Start Date selection
			doClick(calendarIconStartDate,"Start Date Calendar");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			selectValueFromDropDowm(dropDownYear,startValues[2]);
			selectValueFromDropDowm(dropDownMonth,startValues[1]);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			String startDateXpath = "//a[text()='"+startValues[0]+"']";
			driver.findElement(By.xpath(startDateXpath)).click();
		
			//EndDate selection
			try {
				doClick(calendarIconEndDate,"End Date Calendar");

				Thread.sleep(2000);
			} catch (Exception  e) {
				doClick(calendarIconEndDate,"End Date Calendar");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
			selectValueFromDropDowm(dropDownYear,endValues[2]);
			selectValueFromDropDowm(dropDownMonth,endValues[1]);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			String endDateXpath = "//a[text()='"+endValues[0]+"']";
			driver.findElement(By.xpath(endDateXpath)).click();
			
		}
		
		else {
			
			selectValueFromDropDowm(dropDownPeriod, period);

		}
	}
	
	public void clickOnSearchBtn() {
		
		try {
			doClick(btnSearch, "Searh button");
			Thread.sleep(3000);
		} catch (Exception e) {
			doClick(btnSearch, "Searh button");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
			
	}
	
	public void clickOnDownloadCSVLink() {
		doClick(linkDownloadCSV, "Download CSV link");
		
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyApplicationTypeSearchValues(String val) {
		
		System.out.println("Expected="+ val);

		
		boolean flag=true;
		if(val.equalsIgnoreCase("All")) {
			flag=true;
		}
		
		else {
		for(WebElement e : txtAppTypeValues) {
			
			String searchVal = e.getText();
			System.out.println("Search Result="+ searchVal);
			if(!searchVal.equalsIgnoreCase(val)) {
				flag=false;
			}
		}
		}
		doAssertEqualsBoolean(flag, true,"Application Type Search Values correct ?");
	}
	
	
	public void verifyStatusSearchValues(String val) {
		
		System.out.println("Expected="+ val);
		int count=0;
		
		boolean flag=true;
		if(val.equalsIgnoreCase("All")) {
			flag=true;
		}
		
		else {
		for(WebElement e : txtStatusValues) {
			
			
			String searchVal = e.getText();
			System.out.println("Search Result="+ searchVal);
			if(!searchVal.equalsIgnoreCase(val)) {
				flag=false;
			}
			
			count++;
			if(count==10) {
				break;
			}
		}
		}
		doAssertEqualsBoolean(flag, true,"Status Search Values correct ?");
	}
	
	
	public void verifyDataRowsAreDisplayed() {
		
		boolean flag=false;
		
		int count = rows.size();
		
		if(count>=1) {
			flag=true;
		}
		
		doAssertEqualsBoolean(flag, true,"Data rows displayed ?");

	}
	
	public void verifyAllHeadersOfTableAreDisplaeyd() {
		boolean flag = false;
		flag = isDisplayed(lblRefNo,"") && isDisplayed(lblDate,"") && isDisplayed(lblAcctNum,"") && 
				isDisplayed(lblApplType,"") && isDisplayed(lblStatus,"") ;
		
		doAssertEqualsBoolean(flag, true,"All fields of table header are displayed ?");
	}
	
	public void verifyFileIsDownloaded() {
		
		performFileDownload();
		performDeleteFiles();
	}
	
	public void clickOnRefNoLink() {
		doClick(linkFirstRefNo, "Refo No link");
	}
	
	public void verifyRefNoDetailsAreDisplayed() {
		boolean flag = false;
		flag = isDisplayed(txtTranDateTime,"") && isDisplayed(txtEsaverAcctNum,"") &&
				isDisplayed(txtAcctName,"") && isDisplayed(txtDebitAcct,"") && isDisplayed(txtAmount,"") && isDisplayed(btnDone,"");
	}
	
	public void clickOnDoneBtn() {
		doClick(btnDone,"");
	}
	
	
}
