@verify_norun_tags
Feature: Subsequent Feature should Execute
  A subsequent feature not marked SKIPPED or PENDING should execute tests as expected.

  Scenario: Subsequent Feature Test scenario
    This scenario is NOT tagged as pending, so all steps should indicate SUCCESS or FAILURE only.
    No steps should be marked PENDING, IGNORED or SKIPPED.  This Scenario should result in FAILURE.

    Given a number '1'
    And a number '1'
    When added together
    Then the result is '4'
