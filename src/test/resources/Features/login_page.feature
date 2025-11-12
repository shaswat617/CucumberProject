Feature: Login and Home Page feature
  Scenario: Login Page title verification
    Given User is on login page
    When user gets the title of the page
    Then title of the page should be "Demo Web Shop. Login"

  Scenario: Home page title verification
    Given User is on login page
    When user enters username "test123@g.co"
    And user enters password "123456"
    And user clicks on Login button
    Then user gets the title of the page
    And title of the page should be "Demo Web Shop"

  Scenario: Forgot password link
    Given User is on login page
    Then forgot your password link should be displayed