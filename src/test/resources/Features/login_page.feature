Feature: Login and Home Page feature
  Scenario: Login Page title verification
    Given User is on login page
    When User gets the title of the page
    Then page title should be "Demo Web Shop. Login"

  Scenario: Home page title verification
    Given User is on login page
    When user enters username "test123@g.co"
    And user enters password "123456"
    And user clicks on Login button
    Then user gets the title of the web page
    And page title should be "Demo Web Shop"

  Scenario: Forgot password link
    Given User is on login page
    Then forgot your password link should be displayed