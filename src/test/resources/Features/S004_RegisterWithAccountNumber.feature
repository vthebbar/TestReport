Feature: S004_Register for Online Banking with Account Number

  Scenario: S004_TC01_Verify Journey Registration page displayes 2 options  "Account Number" and  "ATM Card" for users to choose
    Given I m on the login page
    When I m navigated to Registration page
    Then Two options for registration option1 and option2 are displayed
      | option1                 | option2           |
      | Using an Account Number | Using an ATM Card |

  Scenario: S004_TC02_Verify the registration screen (Enter Details Section) fields for registration using Account Number
    """ verify all field names and input fields are displayed- Account Type, Account No. ,ID Type , ID No. , Temporary ID, Captcha"""

    Given I m on the login page
    When I m navigated to Enter Details Section by choosing registration using Account Number
    Then verify that all field names and input fields are displayed in the screen

  Scenario: S004_TC03_Verify the available dropdown options for Account Type field in Enter Details Section of registration using Account Number
    """ verify expected options are available in drop down- Please Select, Savings Account, Current Account, FD Account, Locan Account """

    Given I m on the login page
    When I m navigated to Enter Details Section by choosing registration using Account Number
    Then Following options are available for Account Type drop down field
      | Please Select   |
      | Savings Account |
      | Current Account |
      | FD Account      |
      | Loan Account    |

  Scenario: S004_TC04_Verify the available dropdown options for ID Type field in Enter Details Section of registration using Account Number
    """verify expected options are available in drop down - Please Select,  National Identity Card,  Passport,  Birth Certificate,  Others-Individual, Certificate of Incorporation - Foreign, Certificate of Incorporation, Others - Non Individual, Registration of Society/Club/Association - Foreign, Business Registration, Business Registration - Foreign, Registration of Society/Club/Association"""

    Given I m on the login page
    When I m navigated to Enter Details Section by choosing registration using Account Number
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

  Scenario: S004_TC05_Verify Account Registration Enter Details  [Negative test]
    """ click on Next button without entering any details and verify error message is correctly displayed for all the input fields"""

    Given I m on the login page
    When I m navigated to Enter Details Section by choosing registration using Account Number
    And I click on Next button
    Then Following error messages are displayed for input fields
      | Account Type             | Account No.                | ID Type             | ID No.                | Temporary ID             | Captcha             |
      | Account Type is required | Account Number is required | ID Type is required | ID Number is required | Temporary ID is required | Captcha is required |

  Scenario Outline: S004_TC06_Verify error message is correctly displayed when Invalid Account number keyed in [Netagive test]
    """ Under Enter Details Section of Register for Online Banking using Account Number"""

    Given I m on the login page
    When I m navigated to Enter Details Section by choosing registration using Account Number
    And key in the value "<accountNum>" for account number field
    Then Error message "<errMsg>" is displayed correctly for account number field

    Examples: 
      | accountNum | errMsg                        |
      | ABC123     | Invalid Account Number format |

  Scenario Outline: S004_TC07_Verify error message is correctly displayed when Invalid Temporary ID is keyed in [Netagive test]
    """ Under Enter Details Section of Register for Online Banking using Account Number"""

    Given I m on the login page
    When I m navigated to Enter Details Section by choosing registration using Account Number
    And key in the value "<temporaryID>" for Temporary field
    Then Error message "<errMsg>" is displayed correctly for Temporary ID field

    Examples: 
      | temporaryID | errMsg                      |
      | xyz123      | Invalid Temporary ID format |
