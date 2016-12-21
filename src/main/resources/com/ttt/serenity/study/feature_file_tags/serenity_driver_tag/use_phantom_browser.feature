@example @verify_driver_tag @driver:phantomjs
Feature: Force use of Phantom browser

  An example of using the Serenity @driver:phantomjs tag to force the use of the PhantomJS browser.

  Scenario: Open the PhantomJS browser
    Given the browser is open
    Then close the browser
