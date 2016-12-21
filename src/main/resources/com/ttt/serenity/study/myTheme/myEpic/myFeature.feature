@api
@component:calculator
@release:1.0
@issue:JIRA_123
@test @verify_naming_convention

Feature: myFeature
  myFeature is part of a set of themes/epics/features with non-unique names, so only one of the set is reported by Serenity BDD (this is expected behavior).
  * my theme/my epic/my feature.feature
  * my_theme/my_epic/my_feature.feature
  * my-theme/my-epic/my-feature.feature
  * myTheme/myEpic/myFeature.feature
  .
  .
  This set of themes/epics/features shows names that include space, underscore, dash and camelCase naming convention are all valid as long as the names are unique.  All show up in the Serenity BDD report.
  * theme with space/epic with space/feature with space.feature
  * theme_with_underscore/epic_with_underscore/feature_with_underscore.feature
  * theme-with-dash/epic-with-dash/feature-with-dash.feature
  * themeWithCamelCase/epicWithCamelCase/featureWithCamelCase.feature

  Scenario: "myFeature" Test scenario
    Given a number '1'
    And a number '1'
    When added together
    Then the result is '2'

