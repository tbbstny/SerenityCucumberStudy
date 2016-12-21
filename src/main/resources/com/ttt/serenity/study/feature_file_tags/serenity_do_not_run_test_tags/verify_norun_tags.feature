@example @verify_norun_tags
Feature: Verify serenity tag usage
  Verify Serenity tags @ignore, @pending, @skip, @wip and @manual work with Cucumber-JVM,
  and cause tests to correctly be counted and not executed.

  @ignore
  Scenario: Use of @ignore tag
    Given a number '1'
    And a number '1'
    When added together
    Then the result is '4'

  @ignored
  Scenario: Use of @ignored tag
    Given a number '1'
    And a number '1'
    When added together
    Then the result is '4'

  @pending
  Scenario: Use of @pending tag
    Given a number '1'
    And a number '1'
    When added together
    Then the result is '4'

  @skip
  Scenario: Use of @skip tag
    Given a number '1'
    And a number '1'
    When added together
    Then the result is '4'

  @wip
  Scenario: Use of @wip tag
    Given a number '1'
    And a number '1'
    When added together
    Then the result is '4'

  @manual
  Scenario: Use of @manual tag
    Given a number '1'
    And a number '1'
    When added together
    Then the result is '4'
