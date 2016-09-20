@example @verify_tags
Feature: Verify serenity tag usage
Verify serenity tags work with cucumber

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
