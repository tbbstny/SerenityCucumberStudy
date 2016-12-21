@example @verify_driver_tag
Feature: Use configured browser

  An example that DOES NOT use the Serenity @driver tag to force use of a specific browser.
  In this case the browser used comes from the system proprty webdriver.driver.  This may be
  set in the serenity.properties or provided from the command line.

  Scenario: Open the default browser
    Given the browser is open
    Then close the browser
