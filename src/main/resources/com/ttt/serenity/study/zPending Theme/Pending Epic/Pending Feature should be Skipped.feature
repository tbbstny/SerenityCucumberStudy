@verify_norun_tags @pending
Feature: Pending Feature should be Skipped
  A feature marked SKIPPED or PENDING should not result in FAILURE even if tests would fail otherwise.

  Scenario: Pending Feature Test scenario
    This feature and scenario is tagged as pending, so all steps and overall status shuld be marked as PENDING.

    Given a number '1'
    And a number '1'
    When added together
    Then the result is '4'
