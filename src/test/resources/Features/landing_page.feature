Feature: Landing page feature

  Background:
    Given User has already login access
      | Username     | Password |
      | test123@g.co | 123456   |

  Scenario: Landing page title
    Given user is on landing page
    When user gets the title of the landing page
    Then title of the page should be "Demo Web Shop"

  Scenario: Landing page tabs
    Given User is on landing page
    Then user gets different tabs
      | BOOKS             |
      | COMPUTERS         |
      | ELECTRONICS       |
      | APPAREL & SHOES   |
      | DIGITAL DOWNLOADS |
      | JEWELRY           |
      | GIFT CARDS        |
    And landing page tab count is 7