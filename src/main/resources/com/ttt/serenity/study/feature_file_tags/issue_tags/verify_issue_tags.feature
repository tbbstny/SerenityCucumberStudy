@example @verify_issue_tags
Feature: Verify serenity @issue and @issues tag usage
Verify serenity @issue and @issues tags work with Cucumber-JVM

  @issue:JIRA-1234
  Scenario: Use of @issue tag
    Given a number '1'
    And a number '1'
    When added together
    Then the result is '2'

  @issues:JIRA-9870,JIRA-6540
  Scenario: Use of @issues tag
    Given a number '1'
    And a number '1'
    When added together
    Then the result is '2'
