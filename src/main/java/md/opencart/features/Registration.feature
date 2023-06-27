Feature: Register Flow Feature Test Suite

  Scenario: Access the Account page after successful registration
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid data
    And the privacyToggle is enabled
    And continueBtn is clicked
    Then the new page url contains "success&language" keyword


  Scenario: User remains on register page when Continue button is not clicked during the register flow
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid data
    And the privacyToggle is enabled
    Then the new page url contains "register" keyword