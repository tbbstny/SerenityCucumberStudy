@example @verify_driver_tag @driver:firefox
Feature: Force use of Firefox browser

  An example of using the Serenity @driver:firefox tag to force the use of the FireFox browser.

  Scenario: Open the FireFox browser
    Given the browser is open
    Then close the browser
