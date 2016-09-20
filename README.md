# Serenity + Cucumber-JVM Study
A study in Maven, Cucumber and Serenity

This demo project demonstrates:
* [Serenity @driver tag to force use of specifc browser](#driver)
* [Pending/Skipping Scenarios in Serenity Cucumber](#dontrun) [Outstanding](https://groups.google.com/forum/#!topic/thucydides-users/7FOewIrMWU8 "Pending/Skipping Scenarios in Serenity Cucumber")
* [Running Cucumber Tests in Parallel](#parallel)
* [Running Cucumber Tests from test-jar](#testjar)

To run (the easy, straing forward way):
`mvn clean compile -PSerenity`


## <a name="driver"></a> Serenity @driver tag to force use of specifc browser
Serenity recognizes the @driver tag used to force Cucumber Features/Scenarios to use a specific browser:
@driver:chrome, @driver:firefox, @driver:iexplorer, @driver:phantomjs


## <a name="dontrun"></a> Pending/Skipping Scenarios in Serenity Cucumber
Serenity recognizes the following tags, and should report on Cucumber Features/Scenarios without actually executing them:
@ignore, @pending, @skip, @wip, @manual


## <a name="parallel"></a> Running Cucumber Tests in Parallel
This project uses the `maven-failsafe-plugin` to run tests in parallel, as opposed to the sereinity.properties configuration.  The highlights:
* Need multiple test runners in order to run tests in parallel, use a standard naming convention (this project uses `*FeatureTest.java`)
* The pom files uses a regular expression to tell failsafe what runners to include:
```xml
<testrunner.prefixes></testrunner.prefixes>
<failsafe.testrunner>%regex[.*(${testrunner.prefixes})FeatureTest.class]</failsafe.testrunner>
```
..* testrunner.prefixes default to empty (All), but can be a piped list of test runner prefixes.
..* %regex[.*()FeatureTest.class] - Runs all test runners
..* %regex[.*(Driver)FeatureTest.class] - Runs only the *DriverFeatureTest runners (tests @driver tag to force specific browsers)
..* %regex[.*(Driver|DoNotRunTags)FeatureTest.class] - Runs both Driver and DoNotRunTags test runners


## <a name="testjar"></a> Running Cucumber Tests from test-jar
This project includes two pom files:
* pom.xml   - main pom used for CI at check-in time; builds test-jar
* pomIT.xml - test runner pom; scans test-jar and launches the tests

This requires a two step process to first build the test jar, then launch the tests.
This is useful for setting up a test runner so business and testers can run on demand.
1. `mvn clean install`
2. `mvn -f pomIT.xml verify`

