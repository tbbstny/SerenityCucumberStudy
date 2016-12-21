@api
@component:calculator
@release:1.0
@issue:JIRA_123
@test @verify_naming_convention

Feature: Mismatched Feature file name with Feature keyword description
  This feature has theme/epic parent with names theme_with_unmatched_feature_name/epic_with_unmatched_feature_name,
  but because the feature file name (feature_with_unmatched_feature_name.feature) does not match the Feature:
  keyword description in this file (Mismatched Feature file name with Feature keyword description), the parent
  theme and epic do not show up on the Serenity BDD report requirements / home page.

  They also no longer show up under Epic or Feature tabs.

  Scenario: Mismatched Feature Name Test scenario
    Given a number '1'
    And a number '1'
    When added together
    Then the result is '2'

