Feature: S006_Forgot username/password functionality using an Account Number

Scenario: S006_TC01_Verify Forgot username/password page displayes 2 options  "Account Number" and  "ATM Card" for users to choose
""" Verify that RESET HLB CONNECT page displayes 2 options to Using an Account Number and Using an ATM Card"""
    Given I m on the login page
    When I m navigated to RESET HLB CONNECT page
    Then Two options for registration option1 and option2 are displayed
      | option1                 | option2           |
      | Using an Account Number | Using an ATM Card |

  Scenario: S006_TC02_Verify the RESET HLB CONNECT screen (Enter Details Section) fields for reset using Account Number
    """ verify all field names and input fields are displayed- Account Type, Account No. ,ID Type , ID No. , Temporary ID, Captcha"""

    Given I m on the login page
    When I m navigated to Enter Details Section of RESET HLB CONNECT by choosing, Using an Account Number
    Then verify that all field names and input fields are displayed in the screen

  Scenario: S006_TC03_Verify the available dropdown options for Account Type field in Enter Details Section of RESET HLB CONNECT using Account Number
    """ verify expected options are available in drop down- Please Select, Savings Account, Current Account, FD Account, Locan Account """

    Given I m on the login page
    When I m navigated to Enter Details Section of RESET HLB CONNECT by choosing, Using an Account Number
    Then Following options are available for Account Type drop down field
      | Please Select   |
      | Savings Account |
      | Current Account |
      | FD Account      |
      | Loan Account    |

  Scenario: S006_TC04_Verify the available dropdown options for ID Type field in Enter Details Section of RESET HLB CONNECT using an Account Number
    """verify expected options are available in drop down - Please Select,  National Identity Card,  Passport,  Birth Certificate,  Others-Individual, Certificate of Incorporation - Foreign, Certificate of Incorporation, Others - Non Individual, Registration of Society/Club/Association - Foreign, Business Registration, Business Registration - Foreign, Registration of Society/Club/Association"""

    Given I m on the login page
    When I m navigated to Enter Details Section of RESET HLB CONNECT by choosing, Using an Account Number
    Then Following options are available for ID Type drop down field
      | Please Select                                      |
      | National Identity Card                             |
      | Passport                                           |
      | Birth Certificate                                  |
      | Others-Individual                                  |
      | Certificate of Incorporation - Foreign             |
      | Certificate of Incorporation                       |
      | Others - Non Individual                            |
      | Registration of Society/Club/Association - Foreign |
      | Business Registration                              |
      | Business Registration - Foreign                    |
      | Registration of Society/Club/Association           |

  Scenario: S006_TC05_Verify RESET HLB CONNECT Enter Details fields [Negative test]
    """ click on Next button without entering any details and verify error message is correctly displayed for all the input fields"""

    Given I m on the login page
    When I m navigated to Enter Details Section of RESET HLB CONNECT by choosing, Using an Account Number
    And I click on Next button
    Then Following error messages are displayed for input fields
      | Account Type             | Account No.                | ID Type             | ID No.                | Temporary ID             | Captcha             |
      | Account Type is required | Account Number is required | ID Type is required | ID Number is required | Temporary ID is required | Captcha is required |

  Scenario Outline: S006_TC06_Verify error message is correctly displayed when Invalid Account number keyed in [Netagive test]
    """ [RESET HLB CONNECT] Under Enter Details Section of Register for Online Banking using Account Number"""

    Given I m on the login page
    When I m navigated to Enter Details Section of RESET HLB CONNECT by choosing, Using an Account Number
    And key in the value "<accountNum>" for account number field
    Then Error message "<errMsg>" is displayed correctly for account number field

    Examples: 
      | accountNum | errMsg                        |
      | ABC123     | Invalid Account Number format |

  Scenario Outline: S006_TC07_Verify error message is correctly displayed when Invalid Temporary ID is keyed in [Netagive test]
    """[RESET HLB CONNECT] Under Enter Details Section of Register for Online Banking using Account Number"""

    Given I m on the login page
    When I m navigated to Enter Details Section of RESET HLB CONNECT by choosing, Using an Account Number
    And key in the value "<temporaryID>" for Temporary field
    Then Error message "<errMsg>" is displayed correctly for Temporary ID field

    Examples: 
      | temporaryID | errMsg                      |
      | xyz123      | Invalid Temporary ID format |