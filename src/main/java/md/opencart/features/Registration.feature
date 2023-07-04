Feature: Register Flow Feature Test Suite

  Scenario: Access the Account page after successful registration
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid data
    And "privacyToggle" from "RegisterPage" is clicked
    And "continuebtn" from "RegisterPage" is clicked
    Then the new page url contains "success&language" keyword


  Scenario: User remains on register page when Continue button is not clicked during the register flow
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid data
    And "privacyToggle" from "RegisterPage" is clicked
    Then the new page url contains "register" keyword


  Scenario: Error messages are displayed are displayed when trying to register with invalid <attribute> date
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    And the registration form is completed with the following data:
      | firstName | sdfsdfsdfsadfasdsdsdsdsdsdsdsdsdfasdfasdfasfasdfasdf |
      | lastName  | nume                                                 |
      | email     | email@gmail.com                                      |
      | password  | parola                                               |
    When "continuebtn" from "RegisterPage" is clicked
    Then the following error messages are displayed
      | Warning: You must agree to the Privacy Policy! |
