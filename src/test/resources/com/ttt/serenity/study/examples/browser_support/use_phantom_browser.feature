@example @browser @driver:phantomjs
Feature: Use Phantom browser

  An example of using the Serenity @driver:phantomjs tag to force the use of the PhantomJS browser.

  Scenario: Open the PhantomJS browser
    Given the browser is open
    Then close the browser
