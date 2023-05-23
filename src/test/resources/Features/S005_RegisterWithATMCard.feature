Feature: S005_Register for Online Banking with ATM Card

  Scenario: S005_TC01_Verify the registration screen (Enter Details Section) fields for registration using an ATM Card
    """ verify all field names and input fields are displayed- Card No. , Card PIN, ID Type, ID No. , Captcha"""

    Given I m on the login page
    When I m navigated to Enter Details Section by choosing registration using an ATM Card
    Then verify that all field names and input fields are displayed in the screen for registration using an ATM Card

  Scenario: S005_TC02_Verify the available dropdown options for ID Type field in Enter Details Section of registration using an ATM Card
    """verify expected options are available in drop down - Please Select,  National Identity Card,  Passport,  Birth Certificate,  Others-Individual, Certificate of Incorporation - Foreign, Certificate of Incorporation, Others - Non Individual, Registration of Society/Club/Association - Foreign, Business Registration, Business Registration - Foreign, Registration of Society/Club/Association"""

    Given I m on the login page
    When I m navigated to Enter Details Section by choosing registration using an ATM Card
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

  Scenario: S005_TC03_Verify Account Registration Enter Details  [Negative test] using an ATM Card
    """ click on Next button without entering any details and verify error message is correctly displayed for all the input fields"""

    Given I m on the login page
    When I m navigated to Enter Details Section by choosing registration using an ATM Card
    And I click on Next button in Enter Details section of register using an ATM Card
    Then Following error messages are displayed for input fields for registration using ATM Card
      | Card No.             | Card PIN        | ID Type             | ID No.                | Captcha             |
      | ATM Card is required | PIN is required | ID Type is required | ID Number is required | Captcha is required |

  Scenario Outline: S005_TC04_Verify error message is correctly displayed when Invalid Card No. keyed in [Netagive test]
    """ Under Enter Details Section of Register for Online Banking using Account Number"""

    Given I m on the login page
    When I m navigated to Enter Details Section by choosing registration using an ATM Card
    And key in the value "<cardNo>" for Card No. field
    Then Error message "<errMsg>" is displayed correctly for Card No. field

    Examples: 
      | cardNo | errMsg                     |
      | ABC123 | Invalid Card Number format |
