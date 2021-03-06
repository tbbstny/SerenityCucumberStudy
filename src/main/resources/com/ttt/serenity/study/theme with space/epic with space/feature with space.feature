@api
@component:calculator
@release:1.0
@issue:JIRA_123
@test @verify_naming_convention

Feature: feature with space
    "Feature With Space" is part of the set of following themes/epics/features that have been included in the test suite, showing the space, underscore, dash and camelCase naming convention are all valid as long as the names are unique.
    - theme with space/epic with space/feature with space.feature
    - theme_with_underscore/epic_with_underscore/feature_with_underscore.feature
    - theme-with-dash/epic-with-dash/feature-with-dash.feature
    - themeWithCamelCase/epicWithCamelCase/featureWithCamelCase.feature

    The following themes/epics/features have been included in the tests suite, but because the names are not considered unique by Serenity, only one shows up in the report.  This is expected behavior.
    - my theme/my epic/my feature.feature
    - my_theme/my_epic/my_feature.feature
    - my-theme/my-epic/my-feature.feature
    - myTheme/myEpic/myFeature.feature

  Scenario: "feature with space" Test scenario
    Given a number '1'
    And a number '1'
    When added together
    Then the result is '2'

