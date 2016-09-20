@example @browser @driver:iexplorer
Feature: Force use of Internet Explorer browser

  An example of using the Serenity @driver:iexplorer tag to force the use of the Internet Explorer browser.

  Scenario: Open the Internet Explorer browser
    Given the browser is open
    Then close the browser
