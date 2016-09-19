@example @verify_test_configuration
Feature: Verify configuration

   Test feature to ensure automated build process is working as expected
   Simple steps to add and subtract two numbers
   Intended as simple test of automated build process only

  @verify_test_configuration_1
  Scenario: Addition scenario
    Given a number '3'
    And a number '7'
    When added together
    Then the result is '10'

  Scenario Outline: Addition scenario outline
    Given a number '<A>'
    And a number '<B>'
    When added together
    Then the result is '<C>'

    Examples:
      | A | B | C  |
      | 1 | 1 |  2 |
      | 2 | 2 |  4 |
      | 5 | 5 | 10 |

  Scenario Outline: Subtract two numbers
    Given a number '<A>'
    And a number '<B>'
    When A subtract B
    Then the result is '<C>'

    Examples:
      | A | B | C |
      | 1 | 1 | 0 |
      | 5 | 2 | 3 |
      | 7 | 3 | 4 |
