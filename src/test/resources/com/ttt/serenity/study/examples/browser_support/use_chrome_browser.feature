@example @browser @driver:chrome
Feature: Use Chrome browser

  An example of using the Serenity @driver:chrome tag to force the use of the Chrome browser.

  Scenario: Open the Chrome browser
    Given the browser is open
    Then close the browser
