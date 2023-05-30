Feature: S020_My QR

  Background: 
    Given I m logged in
    And I m navigated to My QR screen
	
	
  Scenario Outline: S020_TC01_Verify user is able select account and find QR code
    [
    The My QR screen should show and allow user as below
    1. User able to select account via dropdown
    2. User to click Show My QR
    
    
    The My QR code successful generate should show user as below
    1. HLB Connct logo
    2. HLB Connect QR Name 
    3. HLB Connect Account number
    4. User can click print to print copy of QR via PDF
    5. User click done to direct back to main dashboard
    ]

    And Select the account from Account "<Value>" dropdown in My QR screen
    And Click on Show My QR button in My QR screen
    Then Verify HLB Connect Logo is displayed in My QR screen
    And HLB Connect QR Name and Account number are displayed in My QR screen
    And Print, Save MY QR, Generate Another My QR buttons are  displayed in My QR screen

    Examples: 
      | Value |
      | 10000 |
      | 10001 |
      | 10004 |
