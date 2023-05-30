Feature: S028_Esaver - View Application History

  Background: 
    Given I m logged in
    And I m navigated to E-Saver View Application History screen

  Scenario Outline: S028_TC01_Verify able to filter and search based on Application Type dropdown
    [
      Verify search result is based on the Application Type
    
    ]

    When I select the Application Type "<ApplicationType>" from dropdown in View Application History screen
    And I click on the Search button in View Application History screen
    Then Application Type value "<ApplicationType>" displayed in table should match with the search value in View Application History screen

    Examples: 
      | ApplicationType             |
      | All                         |
      | Create E-Saver Account      |
      | Re-activate E-Saver Account |
      | Close E-Saver Account       |

  Scenario Outline: S028_TC02_Verify able to filter and search based on Status dropdown
    [
    	 Verify search result is based on the Status
    
    ]

    When I select Status "<Status>" from dropdown in View Application History screen
    And I click on the Search button in View Application History screen
    Then Status value "<Status>" displayed in table should match with the search value in View Application History screen

    Examples: 
      | Status                  |
      | All                     |
      | Accepted for processing |
      | Successful              |
      | Failed                  |

  Scenario Outline: S028_TC03_Verify able to filter and search based on Period
    [
    Verify search based on period , then verify rows are displayed after the search
    ]

    When I select period "<period>" , start date "<startDate>" and "<endDate>" in View Application History screen
    And I click on the Search button in View Application History screen
    Then Verify the at least one or more data rows are displayed in View Application History screen

    Examples: 
      | period       | startDate   | endDate     |
      | Last 30 days | NA          | NA          |
      | Date Range   | 10/May/2023 | 25/May/2023 |

  Scenario: S028_TC04_Verify that application history table all header fields are displayed
    [
      View Application Histor field as below
      - Ref No.
      - Date
      - Account
      - Application Type
      - Status 
    ]

    Then All table headers are displayed in View Application History screen

  
  Scenario: S028_TC05_Verify that able to click and download the CSV file
    [
      - User clicks on:  Download CSV link
      - then verify file is downloaded
    ]

    When I click on Download CSV link in View Application History screen
    Then Verify that file is downloaded successfully
	
	
  Scenario: S028_TC06_Verify that user able to view detail of application by clicking on Ref No link
    [
      - Click on Ref No link
      - Verify details are displayed
    ]

    When I click on REF NO link in View Application History screen
    Then Verify that details of the application are displayed under ESaver Create Account section
    And I click on Done button in ESaver Create Account section
    Then E-saver View Application History page is displayed
