@example @browser @driver:firefox
Feature: Use Firefox browser

  An example of using the Serenity @driver:firefox tag to force the use of the FireFox browser.

  Scenario: Open the FireFox browser
    Given the browser is open
    Then close the browser