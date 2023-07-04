Feature: Login Feature Test Suite

  Scenario Outline: An error message is displayed when login is performed with invalid data <attribute>
    Given The "https://andreisecuqa.host/index.php?route=account/login&language=en-gb" is accessed
    And the following data is entered into the login form:
      | <email>    |
      | <password> |
    When "loginButton" from "LoginPage" is clicked
    Then the following error messages are displayed
      | Warning: No match for E-mail Address and/or Password. |
    Examples:
      | attribute | email               | password      |  |
      | email     | invalid@email.com   | parola        |  |
      | password  | rima.hahn@yahoo.com | parolagresita |  |

  Scenario Outline: A valid user is able to log into the sistem <
    Given The "https://andreisecuqa.host/index.php?route=account/login&language=en-gb" is accessed
    And the following data is entered into the login form:
      | <email>    |
      | <password> |
    When "loginButton" from "LoginPage" is clicked
    Then the current url contains following keyword: "account"
    Examples:
      |  | email             | password |  |
      |  | invalid@email.com | q529w1f6 |  |